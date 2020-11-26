INSERT INTO `blogengine`.`users` (`id`, `email`, `is_moderator`, `name`, `password`, `reg_time`) 
VALUES ('1', 'user@user.com', '0', 'user', '{bcrypt}$2a$10$Wx6AX80Al7Khp4h/x4838uVvGaynqczP6BrwWG/2zVXHacBAn.36u', '2020-07-03 18:38:21'),
('2', 'admin@admin.com', '1', 'admin', '$2a$10$TCyBMXYUnwjr/lzKRw1doOMS4rNFLfeJSIJUf7AtHpbtNBcX9Sdbe', '2020-07-29 18:38:21');

INSERT INTO `blogengine`.`posts` (`id`, `is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `view_count`, `user_id`) 
VALUES ('1', '1', 'ACCEPTED', '0', 'Первый текст про усиленную работу над этим проектом', '2020-01-06 17:21:12', 'Этот проект', '0', '2'), 
('2', '1', 'ACCEPTED', '0', 'Текст поста про собачек', '2020-03-06 17:21:12', 'Собачки ВУФ', '4', '1'), 
('3', '1', 'NEW', '0', 'Текст поста про кошечек', '2020-04-06 17:21:12', 'Кошечки котятки', '88', '1'), 
('4', '0', 'ACCEPTED', '0', 'Текст скрытого поста для проекта', '2020-05-06 17:21:12', 'Скрытый пост', '1', '2'),
('5', '1', 'ACCEPTED', '0', 'Пост под номером id 5 нужен для массовки, чтобы проверить пагинацию', '2020-05-07 17:21:12', 'Пост массовки 5', '12', '2'),
('6', '1', 'ACCEPTED', '0', 'Пост под номером id 6 нужен для массовки, чтобы проверить пагинацию', '2020-05-07 17:22:12', 'Пост массовки 6', '7', '1'),
('7', '1', 'ACCEPTED', '0', 'Пост под номером id 7 нужен для массовки, чтобы проверить пагинацию', '2020-05-07 17:23:12', 'Пост массовки 7', '19', '1'),
('8', '1', 'NEW', '0', 'Пост под номером id 8 нужен для массовки, чтобы проверить пагинацию', '2020-05-07 17:24:12', 'Пост массовки 8', '19', '1'),
('9', '1', 'NEW', '0', 'Пост под номером id 9 нужен для массовки, чтобы проверить пагинацию', '2020-05-07 17:25:12', 'Пост массовки 9', '4', '2'),
('10', '1', 'ACCEPTED', '0', 'Пост c большим количеством текста, чтобы  <b>оценить<b/> такое свойство как announce и удаленные html тэги <br> из текста анонса. Давным-давно жили были дед да бабка. Жили они дружно не тужили, но однажды случилось кое-что интересное. Внучка к ним приехала! Вот так сюрприз! Говорит: "Дед и бабка! Выручайте меня! Мне нужно убрать весь html текст из текста анонса. Неделю голову ломаю, никак не соображу, что делать". Дед с бабкой переглянулись удивленно и смолвили несколько словечек: "Внученька, а что это за слово такое непонятно и иногороднее HTML? Мы такого видать не видали за всю свою долгую и счастливую жизнь". Конец большого текста', '2020-05-07 17:27:12', 'Большой пост с тэгами HTML', '11', '2'),
('11', '1', 'ACCEPTED', '0', 'Пост, который должен динамически подгружаться 1, когда привышен limit', '2020-06-08 17:26:12', 'Подгрузка поста 1 из БД', '11', '1'),
('12', '1', 'ACCEPTED', '0', 'Пост, который должен динамически подгружаться 2, когда привышен limit', '2020-06-09 17:26:12', 'Подгрузка поста 2 из БД', '4', '1'),
('13', '1', 'ACCEPTED', '0', 'Пост, который должен динамически подгружаться 3, когда привышен limit', '2020-06-10 17:26:12', 'Подгрузка поста 3 из БД', '26', '1'),
('14', '1', 'ACCEPTED', '0', 'Пост, который должен динамически подгружаться 4, когда привышен limit', '2020-06-11 17:26:12', 'Подгрузка поста 4 из БД', '16', '2'),
('15', '1', 'ACCEPTED', '0', 'Пост, который должен динамически подгружаться 5, когда привышен limit', '2020-06-12 17:26:12', 'Подгрузка поста 5 из БД', '6', '1'),
('16', '1', 'ACCEPTED', '0', 'Пост, который будет опубликован в будущем (отложенная публикация)', '2220-06-12 17:26:12', 'Отложенная публикация поста', '0', '2');

INSERT INTO `blogengine`.`tags` (`id`, `name`) 
VALUES ('1', 'проект'), 
('2', 'зверята'), 
('3', 'кошечки'), 
('4', 'собачки');

INSERT INTO `blogengine`.`tag2post` (`tag_id`, `post_id`) 
VALUES ('1', '1'), ('1', '4'), ('2', '2'), ('2', '3'), ('3', '3'), ('4', '2'), ('1', '5'), ('1', '6'), ('1', '7'), ('1', '8'), ('2', '9');

INSERT INTO `blogengine`.`post_comments` (`id`, `text`, `time`, `parent_id`, `post_id`, `user_id`)
VALUES ('1', 'Текст первого комментария для первого поста про проект или поздравляю с первым постом', '2020-08-07 17:21:12', null ,'1','2'),
('2', 'Текст второго комментария для первого поста про проект или спасибо бро', '2020-08-07 20:21:12', '1' ,'1','1'),
('3', 'Текст третьего комментария для поста про собачек или собачки топ', '2020-08-10 21:21:12', null ,'2','2');

INSERT INTO `blogengine`.`post_votes` (`id`, `time`, `value`, `post_id`, `user_id`) 
VALUES ('1', '2020-08-07 17:21:12', '1', '1', '1'), 
('2', '2020-08-10 12:12:12', '-1', '2', '1'), 
('3', '2020-08-09 15:05:46', '-1', '2', '2'), 
('4', '2020-08-09 12:05:46', '1', '3', '1'), 
('5', '2020-08-19 15:11:28', '1', '3', '2'), 
('6', '2020-08-12 05:18:20', '-1', '4', '1'), 
('7', '2020-08-05 15:11:28', '1', '4', '2');

