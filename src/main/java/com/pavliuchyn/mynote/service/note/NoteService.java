package com.pavliuchyn.mynote.service.note;

import java.util.List;

import com.pavliuchyn.mynote.model.note.Note;
import com.pavliuchyn.mynote.model.user.User;

public interface NoteService {

	Note create(Note created);

	List<Note> findByUser(User user);

	Note update(Note updated) throws NoteNotFoundException;

	Note delete(Long id) throws NoteNotFoundException;

	Note findById(Long id);

}
