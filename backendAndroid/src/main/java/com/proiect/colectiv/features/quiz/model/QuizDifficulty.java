package com.proiect.colectiv.features.quiz.model;

public enum QuizDifficulty {
    EASY(0),MODERATE(1),DIFFICULT(2);

    private int value;

    QuizDifficulty(int value) {
        this.value = value;
    }
}
