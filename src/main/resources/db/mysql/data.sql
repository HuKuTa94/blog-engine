INSERT INTO `blogengine`.`users` (`id`, `email`, `is_moderator`, `name`, `password`, `reg_time`) 
VALUES ('1', 'user@user.com', '0', 'user', '{bcrypt}$2a$10$Wx6AX80Al7Khp4h/x4838uVvGaynqczP6BrwWG/2zVXHacBAn.36u', '2020-07-03 18:38:21'),
('2', 'admin@admin.com', '1', 'admin', '$2a$10$TCyBMXYUnwjr/lzKRw1doOMS4rNFLfeJSIJUf7AtHpbtNBcX9Sdbe', '2020-07-29 18:38:21');

INSERT INTO `blogengine`.`posts` (`id`, `is_active`, `moderation_status`, `moderator_id`, `text`, `time`, `title`, `view_count`, `user_id`) 
VALUES ('1', '1', 'ACCEPTED', '0', 'Первый текст про усиленную работу над этим проектом', '2020-01-06 17:21:12', 'Этот проект', '0', '2'), 
('2', '1', 'ACCEPTED', '0', 'Текст поста про собачек', '2020-03-06 17:21:12', 'Собачки ВУФ', '0', '1'), 
('3', '1', 'NEW', '0', 'Текст поста про кошечек', '2020-04-06 17:21:12', 'Кошечки котятки', '0', '1'), 
('4', '0', 'ACCEPTED', '0', 'Текст скрытого поста для проекта', '2020-05-06 17:21:12', 'Скрытый пост', '0', '2');

INSERT INTO `blogengine`.`tags` (`id`, `name`) 
VALUES ('1', 'проект'), 
('2', 'зверята'), 
('3', 'кошечки'), 
('4', 'собачки');

INSERT INTO `blogengine`.`tag2post` (`tag_id`, `post_id`) 
VALUES ('1', '1'), ('1', '4'), ('2', '2'), ('2', '3'), ('3', '3'), ('4', '2');

INSERT INTO `blogengine`.`post_comments` (`id`, `text`, `time`, `parent_id`, `post_id`, `user_id`)
VALUES ('1', 'Текст первого комментария для первого поста про проект или поздравляю с первым постом', '2020-08-07 17:21:12', null ,'1','2'),
('2', 'Текст второго комментария для первого поста про проект или спасибо бро', '2020-08-07 20:21:12', '1' ,'1','1'),
('3', 'Текст третьего комментария для поста про собачек или собачки топ', '2020-08-10 21:21:12', null ,'2','2');



