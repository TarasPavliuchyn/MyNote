package com.pavliuchyn.mynote.repository.note;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pavliuchyn.mynote.model.note.Note;
import com.pavliuchyn.mynote.model.user.User;

public interface NoteRepository extends JpaRepository<Note, Long> {

	List<Note> findByUser(User user);

}
