package com.proiect.colectiv.model;

public enum ForumType {
    OPEN(0), VALIDATED(1), SOLVED(3);

    private int value;

    ForumType(int value) {
        this.value = value;
    }
}
