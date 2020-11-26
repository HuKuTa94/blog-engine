DELETE FROM `blogengine`.`users` WHERE reg_time IN ( '2020-07-03 18:38:21', '2020-07-29 18:38:21');

DELETE FROM `blogengine`.`posts` WHERE time = '2020-05-07 17:27:12'; # post with large text with HTML tags
DELETE FROM `blogengine`.`posts` WHERE text IN
('Первый текст про усиленную работу над этим проектом',
'Текст поста про собачек',
'Текст поста про кошечек',
'Текст скрытого поста для проекта',
'Пост под номером id 5 нужен для массовки, чтобы проверить пагинацию',
'Пост под номером id 6 нужен для массовки, чтобы проверить пагинацию',
'Пост под номером id 7 нужен для массовки, чтобы проверить пагинацию',
'Пост под номером id 8 нужен для массовки, чтобы проверить пагинацию',
'Пост под номером id 9 нужен для массовки, чтобы проверить пагинацию',
'Пост, который должен динамически подгружаться 1, когда привышен limit',
'Пост, который должен динамически подгружаться 2, когда привышен limit',
'Пост, который должен динамически подгружаться 3, когда привышен limit',
'Пост, который должен динамически подгружаться 4, когда привышен limit',
'Пост, который должен динамически подгружаться 5, когда привышен limit',
'Пост, который будет опубликован в будущем (отложенная публикация)');

DELETE FROM `blogengine`.`tags` WHERE name IN ( 'проект','зверята','кошечки','собачки');

DELETE FROM `blogengine`.`tag2post` WHERE tag_id = '1' AND post_id = '1';
DELETE FROM `blogengine`.`tag2post` WHERE tag_id = '1' AND post_id = '4';
DELETE FROM `blogengine`.`tag2post` WHERE tag_id = '2' AND post_id = '2';
DELETE FROM `blogengine`.`tag2post` WHERE tag_id = '2' AND post_id = '3';
DELETE FROM `blogengine`.`tag2post` WHERE tag_id = '3' AND post_id = '3';
DELETE FROM `blogengine`.`tag2post` WHERE tag_id = '4' AND post_id = '2';
DELETE FROM `blogengine`.`tag2post` WHERE tag_id = '1' AND post_id = '5';
DELETE FROM `blogengine`.`tag2post` WHERE tag_id = '1' AND post_id = '6';
DELETE FROM `blogengine`.`tag2post` WHERE tag_id = '1' AND post_id = '7';
DELETE FROM `blogengine`.`tag2post` WHERE tag_id = '1' AND post_id = '8';
DELETE FROM `blogengine`.`tag2post` WHERE tag_id = '2' AND post_id = '9';

DELETE FROM `blogengine`.`post_comments` WHERE text IN 
('Текст первого комментария для первого поста про проект или поздравляю с первым постом',
'Текст второго комментария для первого поста про проект или спасибо бро',
'Текст третьего комментария для поста про собачек или собачки топ');

DELETE FROM `blogengine`.`post_votes` WHERE time IN 
('2020-08-07 17:21:12','2020-08-10 12:12:12','2020-08-09 15:05:46','2020-08-09 12:05:46',
'2020-08-19 15:11:28','2020-08-12 05:18:20','2020-08-05 15:11:28');