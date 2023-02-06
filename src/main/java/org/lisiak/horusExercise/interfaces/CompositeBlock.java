package org.lisiak.horusExercise.interfaces;

import java.util.List;

public interface CompositeBlock extends Block{
    List<Block> getBlocks();

    //zlicza bloki w kompozycie
    @Override
    default int count() {
        return getBlocks().stream()
                .mapToInt(Block::count)
                .sum();
    }

}
