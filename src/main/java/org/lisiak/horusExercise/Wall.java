package org.lisiak.horusExercise;

import org.lisiak.horusExercise.interfaces.Block;
import org.lisiak.horusExercise.interfaces.Structure;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Wall implements Structure {
    private List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    //znajduje pierwszy blok o poszukiwanym kolorze lub wyrzuca pustego optionala
    @Override
    public Optional<Block> findBlockByColor(String color) {
        if (color == null) {
            throw new IllegalArgumentException("Color is null...");
        }
        List<Block> allMatchingBlocks = findAllByPredicate(block -> block.getColor().equals(color));
        return allMatchingBlocks.stream()
                .findFirst();
    }

    //znajduje listę bloków o wymaganym materiale
    @Override
    public List<Block> findBlocksByMaterial(String material) {
        if (material == null) {
            throw new IllegalArgumentException("Material is null...");
        }
        return findAllByPredicate(block -> block.getMaterial().equals(material));
    }

    //zlicza bloki w liście
    @Override
    public int count() {
        return blocks.stream()
                .mapToInt(Block::count)
                .sum();
    }

    //znajduje bloki na podstawie podanego predykatu (lambdy)
    private List<Block> findAllByPredicate(Predicate<Block> predicate) {
        return blocks.stream()
                .map(block -> block.getOptionalOfMatchingBlock(predicate))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }
}
