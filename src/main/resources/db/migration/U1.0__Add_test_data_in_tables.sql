DELETE FROM `blogengine`.`users` WHERE reg_time = '2020-07-03 18:38:21';
DELETE FROM `blogengine`.`users` WHERE reg_time = '2020-07-29 18:38:21';

DELETE FROM `blogengine`.`posts` WHERE text = 'Первый текст про усиленную работу над этим проектом';
DELETE FROM `blogengine`.`posts` WHERE text = 'Текст поста про собачек';
DELETE FROM `blogengine`.`posts` WHERE text = 'Текст поста про кошечек';
DELETE FROM `blogengine`.`posts` WHERE text = 'Текст скрытого поста для проекта';
DELETE FROM `blogengine`.`posts` WHERE text = 'Пост под номером id 5 нужен для массовки, чтобы проверить пагинацию';
DELETE FROM `blogengine`.`posts` WHERE text = 'Пост под номером id 6 нужен для массовки, чтобы проверить пагинацию';
DELETE FROM `blogengine`.`posts` WHERE text = 'Пост под номером id 7 нужен для массовки, чтобы проверить пагинацию';
DELETE FROM `blogengine`.`posts` WHERE text = 'Пост под номером id 8 нужен для массовки, чтобы проверить пагинацию';
DELETE FROM `blogengine`.`posts` WHERE text = 'Пост под номером id 9 нужен для массовки, чтобы проверить пагинацию';
DELETE FROM `blogengine`.`posts` WHERE time = '2020-05-07 17:27:12';
DELETE FROM `blogengine`.`posts` WHERE text = 'Пост, который должен динамически подгружаться 1, когда привышен limit';
DELETE FROM `blogengine`.`posts` WHERE text = 'Пост, который должен динамически подгружаться 2, когда привышен limit';
DELETE FROM `blogengine`.`posts` WHERE text = 'Пост, который должен динамически подгружаться 3, когда привышен limit';
DELETE FROM `blogengine`.`posts` WHERE text = 'Пост, который должен динамически подгружаться 4, когда привышен limit';
DELETE FROM `blogengine`.`posts` WHERE text = 'Пост, который должен динамически подгружаться 5, когда привышен limit';
DELETE FROM `blogengine`.`posts` WHERE text = 'Пост, который будет опубликован в будущем (отложенная публикация)';

DELETE FROM `blogengine`.`tags` WHERE name = 'проект';
DELETE FROM `blogengine`.`tags` WHERE name = 'зверята';
DELETE FROM `blogengine`.`tags` WHERE name = 'кошечки';
DELETE FROM `blogengine`.`tags` WHERE name = 'собачки';

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

DELETE FROM `blogengine`.`post_comments` WHERE text = 'Текст первого комментария для первого поста про проект или поздравляю с первым постом';
DELETE FROM `blogengine`.`post_comments` WHERE text = 'Текст второго комментария для первого поста про проект или спасибо бро';
DELETE FROM `blogengine`.`post_comments` WHERE text = 'Текст третьего комментария для поста про собачек или собачки топ';

DELETE FROM `blogengine`.`post_votes` WHERE time = '2020-08-07 17:21:12';
DELETE FROM `blogengine`.`post_votes` WHERE time = '2020-08-10 12:12:12';
DELETE FROM `blogengine`.`post_votes` WHERE time = '2020-08-09 15:05:46';
DELETE FROM `blogengine`.`post_votes` WHERE time = '2020-08-09 12:05:46';
DELETE FROM `blogengine`.`post_votes` WHERE time = '2020-08-19 15:11:28';
DELETE FROM `blogengine`.`post_votes` WHERE time = '2020-08-12 05:18:20';
DELETE FROM `blogengine`.`post_votes` WHERE time = '2020-08-05 15:11:28';