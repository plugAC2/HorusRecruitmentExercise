package org.lisiak.horusExercise;

import org.lisiak.horusExercise.interfaces.Block;
import org.lisiak.horusExercise.interfaces.Structure;

import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return null;
    }

    @Override
    public int count() {
        return blocks.stream()
                .mapToInt(Block::count)
                .sum();
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }
}
