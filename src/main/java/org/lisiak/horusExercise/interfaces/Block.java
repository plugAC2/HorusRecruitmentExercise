package org.lisiak.horusExercise.interfaces;

public interface Block {
    String getColor();
    String getMaterial();

    //jeden blok liczy się jako 1
    default int count() {
        return 1;
    }

}
