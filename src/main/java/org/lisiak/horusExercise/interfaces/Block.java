package org.lisiak.horusExercise.interfaces;

import java.util.Optional;
import java.util.function.Predicate;

public interface Block {
    String getColor();
    String getMaterial();

    //jeden blok liczy się jako 1
    default int count() {
        return 1;
    }

    default Optional<Block> getOptionalOfMatchingBlock(Predicate<Block> predicate) {
        if (predicate.test(this)) {
            return Optional.of(this);
        }
        return Optional.empty();
    }


}
