package com.pavliuchyn.mynote.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pavliuchyn.mynote.model.note.Contact;
import com.pavliuchyn.mynote.model.note.ContactType;
import com.pavliuchyn.mynote.model.note.Note;
import com.pavliuchyn.mynote.service.note.NoteNotFoundException;
import com.pavliuchyn.mynote.service.note.NoteService;
import com.pavliuchyn.mynote.service.user.UserService;

@Controller
public class NoteController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(NoteController.class);

	@Autowired
	public UserService userService;
	@Autowired
	public NoteService noteService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String defaultPage(Model model) {
		return "redirect:/notes";
	}

	@RequestMapping(value = "/notes", method = RequestMethod.GET)
	public String listNotes(Model model) {
		populateNotes(model);
		return "notes";
	}

	@RequestMapping(value = "/note/{id}", method = RequestMethod.GET)
	public String showNote(@PathVariable("id") Long id, Model model) {
		model.addAttribute("note", this.noteService.findById(id));
		return "note";

	}

	@RequestMapping("note/remove/{id}")
	public String removeNote(@PathVariable("id") Long id) {
		try {
			LOGGER.info("Deleting note  with id: " + id);
			this.noteService.delete(id);
		} catch (NoteNotFoundException e) {
			LOGGER.warn("No note found with id: " + id);
			e.printStackTrace();
		}
		return "redirect:/notes";
	}

	@RequestMapping("note/edit/{id}")
	public String editNote(@PathVariable("id") Long id, Model model) {
		populateNotes(id, model);
		return "notes";
	}

	@RequestMapping(value = "/contact/delete/{noteId}/{tel}/{type}", method = RequestMethod.GET)
	public String deleteContact(@PathVariable("noteId") Long noteId,
			@PathVariable("tel") String tel, @PathVariable("type") String type,
			Model model) {
		Contact contact = new Contact(ContactType.valueOf(type), tel);
		Note note = noteService.findById(noteId);
		note.getContacts().remove(contact);
		LOGGER.info("Contact was removed:" + contact);
		try {
			this.noteService.update(note);
			LOGGER.debug("Note was updated: " + note);
		} catch (NoteNotFoundException e) {
			LOGGER.debug("No note found with id: " + note.getId());
			e.printStackTrace();
		}
		populateNotes(noteId, model);
		return "notes";
	}

	@RequestMapping(value = "/contact/add/{noteId}", method = RequestMethod.POST)
	public String addContact(@PathVariable("noteId") Long noteId,
			@ModelAttribute("contact") Contact contact, Model model) {
		Note note = noteService.findById(noteId);
		note.getContacts().add(contact);
		LOGGER.info("Contact was added:" + contact);
		try {
			this.noteService.update(note);
			LOGGER.debug("Note was updated: " + note);
		} catch (NoteNotFoundException e) {
			LOGGER.debug("No note found with id: " + note.getId());
			e.printStackTrace();
		}
		populateNotes(noteId, model);
		return "notes";
	}

	@RequestMapping(value = "/note/add", method = RequestMethod.POST)
	public String addNote(@ModelAttribute("note") @Valid Note note,
			BindingResult result, RedirectAttributes attr, Model model) {
		if (result.hasErrors()) {
			return "redirect:/notes";
		}
		note.setUser(getUser());
		if (note.getId() == null) {
			this.noteService.create(note);
		} else {
			try {
				this.noteService.update(note);
			} catch (NoteNotFoundException e) {
				LOGGER.warn("No note found  " + note);
			}
		}
		return "redirect:/notes";
	}

	private com.pavliuchyn.mynote.model.user.User getUser() {
		String login = ((User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal()).getUsername();
		return userService.findByLogin(login);
	}

	private void populateNotes(Model model) {
		model.addAttribute("note", new Note());
		model.addAttribute("contact", new Contact());
		model.addAttribute("listNotes", this.noteService.findByUser(getUser()));
	}

	private void populateNotes(Long noteId, Model model) {
		model.addAttribute("contact", new Contact());
		model.addAttribute("note", this.noteService.findById(noteId));
		model.addAttribute("listNotes", this.noteService.findByUser(getUser()));
	}

}