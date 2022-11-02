truncate table users;
truncate table transactions;

insert into users(name) values('Mike');

insert into users(name) values('Alice');

insert into users(name) values('Jack');

insert into transactions(amount, user_id, created_time)
values(200, 1, '20220501');

insert into transactions(amount, user_id, created_time)
values(200, 1, '20220701');

insert into transactions(amount, user_id, created_time)
values(200, 1, '20220901');