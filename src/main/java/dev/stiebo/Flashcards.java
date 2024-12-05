package dev.stiebo;

record Flashcard(
        String question,
        String answer
) {}

public record Flashcards(
        Flashcard[] flashcards
) {
}
