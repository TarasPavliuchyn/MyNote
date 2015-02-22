-- -----------------------------------------------------
-- Table 'users'
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS users (
  user_id BIGINT(20) NOT NULL AUTO_INCREMENT,
  login VARCHAR(20) NOT NULL,
  password VARCHAR(20) NOT NULL,
  PRIMARY KEY (user_id));
  
-- -----------------------------------------------------
-- Table `notes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS notes (
  note_id BIGINT(20) NOT NULL AUTO_INCREMENT,
  comment VARCHAR(200) NOT NULL,
  first_name VARCHAR(20) NOT NULL,
  last_name VARCHAR(20) NOT NULL,
  patronymic VARCHAR(20) NOT NULL,
  user_id BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (note_id),
  FOREIGN KEY (user_id) REFERENCES users (user_id));

  
-- -----------------------------------------------------
-- Table contacts
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS contacts (
  note_id BIGINT(20) NOT NULL,
  contact_type VARCHAR(20) NOT NULL,
  contact VARCHAR(20) NOT NULL,
  FOREIGN KEY (note_id) REFERENCES notes (note_id));






