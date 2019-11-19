
    create table `administrator` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `announcement` (
       `id` integer not null,
        `version` integer not null,
        `moment` datetime(6),
        `more_info` varchar(255),
        `text` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `anonymous` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `authenticated` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `challenge` (
       `id` integer not null,
        `version` integer not null,
        `deadline` datetime(6),
        `description` varchar(255),
        `goal_bronze` varchar(255),
        `goal_gold` varchar(255),
        `goal_silver` varchar(255),
        `reward_bronze_amount` double precision,
        `reward_bronze_currency` varchar(255),
        `reward_gold_amount` double precision,
        `reward_gold_currency` varchar(255),
        `reward_silver_amount` double precision,
        `reward_silver_currency` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `commercial_banner` (
       `id` integer not null,
        `version` integer not null,
        `credit_card` varchar(255),
        `picture` varchar(255),
        `slogan` varchar(255),
        `url` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `company_records` (
       `id` integer not null,
        `version` integer not null,
        `activities` varchar(255),
        `ceo` varchar(255),
        `email` varchar(255),
        `is_incorporated` bit,
        `name` varchar(255),
        `phone` varchar(255),
        `sector` varchar(255),
        `stars` integer,
        `website` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `consumer` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `company` varchar(255),
        `sector` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `gamez_bulletin` (
       `id` integer not null,
        `version` integer not null,
        `directions` varchar(255),
        `food` varchar(255),
        `kcalories` double precision not null,
        `moment` datetime(6),
        primary key (`id`)
    ) engine=InnoDB;

    create table `investor_record` (
       `id` integer not null,
        `version` integer not null,
        `investing_statement` varchar(255),
        `name` varchar(255),
        `sector` varchar(255),
        `stars` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `martin_bulletin` (
       `id` integer not null,
        `version` integer not null,
        `age` integer,
        `date` datetime(6),
        `name` varchar(255),
        `surname` varchar(255),
        `text` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `muniz_bulletin` (
       `id` integer not null,
        `version` integer not null,
        `id_code` varchar(255),
        `name` varchar(255),
        `surname` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `navarro_bulletin` (
       `id` integer not null,
        `version` integer not null,
        `age` integer,
        `height` double precision,
        `name` varchar(255),
        `weight` double precision,
        primary key (`id`)
    ) engine=InnoDB;

    create table `non_commercial_banner` (
       `id` integer not null,
        `version` integer not null,
        `jingle` varchar(255),
        `picture` varchar(255),
        `slogan` varchar(255),
        `url` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `offer` (
       `id` integer not null,
        `version` integer not null,
        `deadline` datetime(6),
        `info` varchar(255),
        `max_money_amount` double precision,
        `max_money_currency` varchar(255),
        `min_money_amount` double precision,
        `min_money_currency` varchar(255),
        `moment` datetime(6),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `provider` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `company` varchar(255),
        `sector` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `request_entity` (
       `id` integer not null,
        `version` integer not null,
        `deadline` datetime(6),
        `moment` datetime(6),
        `reward_max_amount` double precision,
        `reward_max_currency` varchar(255),
        `reward_min_amount` double precision,
        `reward_min_currency` varchar(255),
        `text` varchar(255),
        `ticker` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `sanchez_bulletin` (
       `id` integer not null,
        `version` integer not null,
        `author` varchar(255),
        `city` varchar(255),
        `country` varchar(255),
        `date` datetime(6),
        primary key (`id`)
    ) engine=InnoDB;

    create table `spam` (
       `id` integer not null,
        `version` integer not null,
        `english_words` varchar(255),
        `spanish_words` varchar(255),
        `threshold` double precision not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `user_account` (
       `id` integer not null,
        `version` integer not null,
        `enabled` bit not null,
        `identity_email` varchar(255),
        `identity_name` varchar(255),
        `identity_surname` varchar(255),
        `password` varchar(255),
        `username` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `hibernate_sequence` (
       `next_val` bigint
    ) engine=InnoDB;

    insert into `hibernate_sequence` values ( 1 );
create index IDXnr284tes3x8hnd3h716tmb3fr on `challenge` (`deadline`);
create index IDXq2o9psuqfuqmq59f0sq57x9uf on `offer` (`deadline`);
create index IDX6075l7l7ajup0b22keibg4bil on `request_entity` (`deadline`);

    alter table `user_account` 
       add constraint UK_castjbvpeeus0r8lbpehiu0e4 unique (`username`);

    alter table `administrator` 
       add constraint FK_2a5vcjo3stlfcwadosjfq49l1 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `anonymous` 
       add constraint FK_6lnbc6fo3om54vugoh8icg78m 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `authenticated` 
       add constraint FK_h52w0f3wjoi68b63wv9vwon57 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `consumer` 
       add constraint FK_6cyha9f1wpj0dpbxrrjddrqed 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `provider` 
       add constraint FK_b1gwnjqm6ggy9yuiqm0o4rlmd 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);
