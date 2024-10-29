create table "internal-user-authentication"
(
    id                    uuid    not null,
    confirmationToken     varchar(255),
    emailAddress          varchar(255),
    emailVerifyStatus     varchar(255) check (emailVerifyStatus in ('VERIFIED', 'NOT_VERIFIED')),
    hashedPassword        varchar(255),
    isPremiumAccount      boolean not null,
    loginName             varchar(255),
    passwordRecoveryToken varchar(255),
    passwordSalt          varchar(255),
    recoveryTokenTime     timestamp(6),
    tokenGenerationTime   timestamp(6),
    primary key (id)
);

create table "user-account"
(
    id                                uuid not null,
    dateOfBirth                       date,
    firstName                         varchar(255),
    gender                            varchar(255) check (gender in ('MALE', 'FEMALE', 'NOT_VERIFY')),
    lastName                          varchar(255),
    "internal-user-authentication-id" uuid unique,
    primary key (id)
);

alter table if exists "user-account"
    add constraint FKq5xa0tjqe8s5db2rw2raatwio
    foreign key ("internal-user-authentication-id")
    references "internal-user-authentication";