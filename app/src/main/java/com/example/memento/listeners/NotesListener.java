package com.example.memento.listeners;

import com.example.memento.entidades.Note;

public interface NotesListener {
    void onNoteClicked(Note note, int position);
}
