create table IF NOT EXISTS users (
    id long primary key auto_increment,
    name varchar(255) not null
);

create table IF NOT EXISTS transactions (
    id long primary key auto_increment,
    amount decimal(10) not null,
    user_id long,
    created_time Date
);