SET SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO';
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = '+00:00';

create table if not exists `User`(
    `id` int NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `password` int NOT NULL,
    PRIMARY KEY(`id`)
);

insert into `User`(`name`, `password`) 
values ('betul', '1234');

insert into `User`(`name`, `password`) 
values ('ahmet', '1234');

insert into `User`(`name`, `password`) 
values ('ayse', '1234');


create table if not exists `List`(
    `name` varchar(255) NOT NULL,
    `user_id` int NOT NULL,
    `list_id` int NOT NULL AUTO_INCREMENT,
    FOREIGN KEY (`user_id`) REFERENCES `User`(`id`) on delete cascade,
    PRIMARY KEY(`list_id`)
);

create table if not exists `Item`(
    `status` int NOT NULL,
    `list_id` int NOT NULL,
    `item_id` int NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `create_date` date NOT NULL,
    `description` varchar(255) NOT NULL,
    `deadline` date NOT NULL,
    FOREIGN KEY (`list_id`) REFERENCES `List`(`list_id`) on delete cascade,
    PRIMARY KEY(`item_id`)
);

create table if not exists `Dependency`(
    `item_id` int NOT NULL,
    `depend_id` int NOT NULL,
    FOREIGN KEY (`item_id`) REFERENCES `Item`(`item_id`) on delete cascade,
    FOREIGN KEY (`depend_id`) REFERENCES `Item` (`item_id`) on delete cascade,
    PRIMARY KEY(`item_id`, `depend_id`)
);


