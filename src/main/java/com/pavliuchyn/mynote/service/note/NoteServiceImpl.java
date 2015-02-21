package com.pavliuchyn.mynote.service.note;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pavliuchyn.mynote.model.note.Note;
import com.pavliuchyn.mynote.model.user.User;
import com.pavliuchyn.mynote.repository.note.NoteRepository;

@Service
public class NoteServiceImpl implements NoteService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(NoteServiceImpl.class);

	@Resource
	public NoteRepository noteRepository;

	@Transactional
	public Note create(Note created) {
		Note saved = noteRepository.save(created);
		LOGGER.info("Note saved successfully, Note Details=" + created);
		return saved;
	}

	@Transactional(rollbackFor = NoteNotFoundException.class)
	@Override
	public Note update(Note updated) throws NoteNotFoundException {
		LOGGER.warn("Updating note with information: " + updated);
		Note note = noteRepository.findOne(updated.getId());
		if (note == null) {
			LOGGER.warn("No note found with id: " + updated.getId());
			throw new NoteNotFoundException();
		}
		return noteRepository.save(updated);
	}

	@Transactional(readOnly = true)
	public List<Note> findByUser(User user) {
		LOGGER.info("Finding note by User: " + user);
		return noteRepository.findByUser(user);
	}

	@Override
	public Note delete(Long noteId) throws NoteNotFoundException {
		LOGGER.debug("Deleting note with id: " + noteId);
		Note deleted = noteRepository.findOne(noteId);
		if (deleted == null) {
			LOGGER.info("No note found with id: " + noteId);
			throw new NoteNotFoundException();
		}
		noteRepository.delete(deleted);
		return deleted;
	}

	@Override
	@Transactional(readOnly = true)
	public Note findById(Long id) {
		LOGGER.info("Finding note by id: " + id);
		return noteRepository.findOne(id);
	}
}
