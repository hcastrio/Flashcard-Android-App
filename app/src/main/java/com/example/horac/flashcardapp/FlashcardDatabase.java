package com.example.horac.flashcardapp;

import android.arch.persistence.room.Room;
import android.content.Context;

import java.util.List;

public class FlashcardDatabase {
    private final AppDatabase db;

    FlashcardDatabase(Context context) {
        db = Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, "flashcard-database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

    public List<Flashcard> getAllCards() {
        return db.flashcardDao().getAll();
    }

    public void insertCard(Flashcard flashcard) {
        db.flashcardDao().insertAll(flashcard);
    }

    public void deleteCard(String flashcardQuestion) {
        List<Flashcard> allCards = db.flashcardDao().getAll();
        for (Flashcard f : allCards) {
            if (f.getQuestion().equals(flashcardQuestion)) {
                db.flashcardDao().delete(f);
            }
        }
    }

    public void updateCard(Flashcard flashcard) {
        db.flashcardDao().update(flashcard);
    }
}
