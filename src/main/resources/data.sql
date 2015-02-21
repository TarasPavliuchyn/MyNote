INSERT INTO users
(login, password)
VALUES
('Taras', '1'); 


INSERT INTO notes(comment, first_name, last_name, patronymic, user_id) VALUES ('friend', 'Taras', 'Pavliuchyn', 'Olexandrovych', 1 );
INSERT INTO notes(comment, first_name, last_name, patronymic, user_id) VALUES ('friend', 'Tom', 'Jerry', 'Olexandrovych', 1); 

INSERT INTO contacts (note_id, contact_type, contact) VALUES (1, 'FAX', '0673836006'); 
INSERT INTO contacts (note_id, contact_type, contact) VALUES (2, 'MOBILE_PHONE', '0673836006'); 
INSERT INTO contacts (note_id, contact_type, contact) VALUES (2, 'SKYPE', 'taras.pavliuchyn'); 
