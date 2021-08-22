INSERT INTO FORUM_USER(NAME, EMAIL, PASSWORD) VALUES('Aluno', 'aluno@email.com', '$2a$10$jlu2wkWvpOKHo/VA94JPg.HyQExaD.NbQtHPkTJ1/TVLK8yVGJy9y');
INSERT INTO FORUM_USER(NAME, EMAIL, PASSWORD) VALUES('Moderador', 'moderator@email.com', '$2a$10$jlu2wkWvpOKHo/VA94JPg.HyQExaD.NbQtHPkTJ1/TVLK8yVGJy9y');

INSERT INTO PROFILE(ID, NAME) VALUES(1, 'ADMIN');
INSERT INTO PROFILE(ID, NAME) VALUES(2, 'MODERATOR');
INSERT INTO PROFILE(ID, NAME) VALUES(3, 'ALUMN');

INSERT INTO FORUM_USER_PROFILES(FORUM_USER_ID, PROFILES_ID) VALUES(1, 3);
INSERT INTO FORUM_USER_PROFILES(FORUM_USER_ID, PROFILES_ID) VALUES(2, 2);

INSERT INTO COURSE(NAME, CATEGORY) VALUES('Spring Boot', 'Programação');
INSERT INTO COURSE(NAME, CATEGORY) VALUES('HTML 5', 'Front-end');

INSERT INTO THREAD_POST(TITLE, BODY, CREATION_DATE, STATUS, ORIGINAL_POSTER_ID, COURSE_ID) VALUES('Dúvida', 'Erro ao criar projeto', '2019-05-05 18:00:00', 'UNANSWERED', 1, 1);
INSERT INTO THREAD_POST(TITLE, BODY, CREATION_DATE, STATUS, ORIGINAL_POSTER_ID, COURSE_ID) VALUES('Dúvida 2', 'Projeto não compila', '2019-05-05 19:00:00', 'UNANSWERED', 1, 1);
INSERT INTO THREAD_POST(TITLE, BODY, CREATION_DATE, STATUS, ORIGINAL_POSTER_ID, COURSE_ID) VALUES('Dúvida 3', 'Tag HTML', '2019-05-05 20:00:00', 'UNANSWERED', 1, 2);