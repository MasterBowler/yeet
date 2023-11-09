CREATE TABLE `users`
(
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR
(255) NOT NULL,
  `password_hash` VARCHAR
(255) NOT NULL,
  `user_type` ENUM
('admin', 'faculty_teacher', 'highschool_teacher', 'faculty_student', 'super_user') NOT NULL,
  PRIMARY KEY
(`id`),
  UNIQUE INDEX `email_UNIQUE`
(`email` ASC)
) ENGINE = InnoDB;

CREATE TABLE `highschool_teachers`
(
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY
(`id`),
  INDEX `fk_highschool_teachers_users_idx`
(`user_id` ASC),
  CONSTRAINT `fk_highschool_teachers_users`
    FOREIGN KEY
(`user_id`)
    REFERENCES `users`
(`id`)
    ON
DELETE NO ACTION
    ON
UPDATE NO ACTION
) ENGINE = InnoDB;

CREATE TABLE `faculty_students`
(
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY
(`id`),
  INDEX `fk_faculty_students_users_idx`
(`user_id` ASC),
  CONSTRAINT `fk_faculty_students_users`
    FOREIGN KEY
(`user_id`)
    REFERENCES `users`
(`id`)
    ON
DELETE NO ACTION
    ON
UPDATE NO ACTION
) ENGINE = InnoDB;

CREATE TABLE `faculty_teachers`
(
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY
(`id`),
  INDEX `fk_faculty_teachers_users_idx`
(`user_id` ASC),
  CONSTRAINT `fk_faculty_teachers_users`
    FOREIGN KEY
(`user_id`)
    REFERENCES `users`
(`id`)
    ON
DELETE NO ACTION
    ON
UPDATE NO ACTION
) ENGINE = InnoDB;

CREATE TABLE `super_users`
(
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY
(`id`),
  INDEX `fk_super_users_users_idx`
(`user_id` ASC),
  CONSTRAINT `fk_super_users_users`
    FOREIGN KEY
(`user_id`)
    REFERENCES `users`
(`id`)
    ON
DELETE NO ACTION
    ON
UPDATE NO ACTION
) ENGINE = InnoDB;

CREATE TABLE `class_groups`
(
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `super_user_id` BIGINT NOT NULL,
  PRIMARY KEY
(`id`),
  INDEX `fk_class_groups_super_users_idx`
(`super_user_id` ASC),
  CONSTRAINT `fk_class_groups_super_users`
    FOREIGN KEY
(`super_user_id`)
    REFERENCES `super_users`
(`id`)
    ON
DELETE NO ACTION
    ON
UPDATE NO ACTION
) ENGINE = InnoDB;

CREATE TABLE `class_group_memberships`
(
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `class_group_id` BIGINT NOT NULL,
  `faculty_student_id` BIGINT NOT NULL,
  PRIMARY KEY
(`id`),
  INDEX `fk_class_group_memberships_class_groups1_idx`
(`class_group_id` ASC),
  INDEX `fk_class_group_memberships_faculty_students1_idx`
(`faculty_student_id` ASC),
  CONSTRAINT `fk_class_group_memberships_class_groups1`
    FOREIGN KEY
(`class_group_id`)
    REFERENCES `class_groups`
(`id`)
    ON
DELETE NO ACTION
    ON
UPDATE NO ACTION,
  CONSTRAINT `fk_class_group_memberships_faculty_students1`
    FOREIGN KEY
(`faculty_student_id`)
    REFERENCES `faculty_students`
(`id`)
    ON
DELETE NO ACTION
    ON
UPDATE NO ACTION
) ENGINE = InnoDB;

CREATE TABLE `password_reset_tokens`
(
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT NOT NULL,
  `token` VARCHAR
(255) NOT NULL,
  `expiry_date` DATETIME NOT NULL,
  PRIMARY KEY
(`id`),
  INDEX `fk_password_reset_tokens_users1_idx`
(`user_id` ASC),
  CONSTRAINT `fk_password_reset_tokens_users1`
    FOREIGN KEY
(`user_id`)
    REFERENCES `users`
(`id`)
    ON
DELETE NO ACTION
    ON
UPDATE NO ACTION
) ENGINE = InnoDB;

CREATE TABLE `chats`
(
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `chat_type` ENUM
('private', 'group') NOT NULL,
  PRIMARY KEY
(`id`)
) ENGINE = InnoDB;

CREATE TABLE `chat_memberships`
(
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `chat_id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY
(`id`),
  INDEX `fk_chat_memberships_chats1_idx`
(`chat_id` ASC),
  INDEX `fk_chat_memberships_users1_idx`
(`user_id` ASC),
  CONSTRAINT `fk_chat_memberships_chats1`
    FOREIGN KEY
(`chat_id`)
    REFERENCES `chats`
(`id`)
    ON
DELETE NO ACTION
    ON
UPDATE NO ACTION,
  CONSTRAINT `fk_chat_memberships_users1`
    FOREIGN KEY
(`user_id`)
    REFERENCES `users`
(`id`)
    ON
DELETE NO ACTION
    ON
UPDATE NO ACTION
) ENGINE = InnoDB;

CREATE TABLE `messages`
(
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `chat_id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  `message_content` TEXT NOT NULL,
  `timestamp` DATETIME NOT NULL,
  PRIMARY KEY
(`id`),
  INDEX `fk_messages_chats1_idx`
(`chat_id` ASC),
  INDEX `fk_messages_users1_idx`
(`user_id` ASC),
  CONSTRAINT `fk_messages_chats1`
    FOREIGN KEY
(`chat_id`)
    REFERENCES `chats`
(`id`)
    ON
DELETE NO ACTION
    ON
UPDATE NO ACTION,
  CONSTRAINT `fk_messages_users1`
    FOREIGN KEY
(`user_id`)
    REFERENCES `users`
(`id`)
    ON
DELETE NO ACTION
    ON
UPDATE NO ACTION
) ENGINE = InnoDB;