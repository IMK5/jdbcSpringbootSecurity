

insert into users (username,password,enabled) values('admin','$2y$12$X7sb3o338Kcalj0mnIJQxeLx6jWuVWuD.TJqSx17phfZQIHMq8FEe',true); -- password = admin (encrypted)
insert into users (username,password,enabled) values('user','$2y$12$uiojtyao/btaYSQEyfwYAOZ2LUyFegRD12Pd5jZgTufzmW.biuAUO',true); -- password = user (encrypted)
insert into users (username,password,enabled)  values('test','$2y$12$DbmGHBEhEQaUZ5O5l/TghuaY/IqTDekMqsxCnVgJCa8B7ry.atUAO',false); -- password = test (encrypted)

insert into authorities (username,authority) values('admin','ROLE_ADMIN');
insert into authorities (username,authority) values('user','ROLE_USER');

