create database if not exists `board_db`;
use `board_db`;

CREATE TABLE `Users`(
	id bigint auto_increment primary key,
    user_id varchar(255) not null unique,
    password varchar(255) not null,
    email varchar(255) not null unique,
    name varchar(255) not null,
    phone varchar(255) not null,
    gender enum('M', 'F')
);

CREATE TABLE `Articles`(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    author_id BIGINT NOT NULL,
    FOREIGN KEY(author_id) REFERENCES `Users`(id) ON DELETE CASCADE
);

CREATE TABLE `Comments` (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    article_id BIGINT NOT NULL,
    commenter_id BIGINT NOT NULL,
    content TEXT NOT NULL,
	FOREIGN KEY(article_id) REFERENCES `Articles`(id) ON DELETE CASCADE,
	FOREIGN KEY(commenter_id) REFERENCES `Users`(id) ON DELETE CASCADE
);