--liquibase formatted sql
--changeset MazurovY:3

INSERT INTO PUBLIC.USERS_ROLES (USER_ID_PK, ROLE_ID_PK)
VALUES ((select u.USER_ID_PK from PUBLIC.USERS u where u.LOGIN like '%user1%'),
        (select r.ROLE_ID_PK from PUBLIC.ROLES r where r.ROLE like '%USER%'));

INSERT INTO PUBLIC.USERS_ROLES (USER_ID_PK, ROLE_ID_PK)
VALUES ((select u.USER_ID_PK from PUBLIC.USERS u where u.LOGIN like '%user1%'),
        (select r.ROLE_ID_PK from PUBLIC.ROLES r where r.ROLE like '%MODERATOR%'));

INSERT INTO PUBLIC.USERS_ROLES (USER_ID_PK, ROLE_ID_PK)
VALUES ((select u.USER_ID_PK from PUBLIC.USERS u where u.LOGIN like '%user1%'),
        (select r.ROLE_ID_PK from PUBLIC.ROLES r where r.ROLE like '%ADMIN%'));

INSERT INTO PUBLIC.USERS_ROLES (USER_ID_PK, ROLE_ID_PK)
VALUES ((select u.USER_ID_PK from PUBLIC.USERS u where u.LOGIN like '%user2%'),
        (select r.ROLE_ID_PK from PUBLIC.ROLES r where r.ROLE like '%MODERATOR%'));

INSERT INTO PUBLIC.USERS_ROLES (USER_ID_PK, ROLE_ID_PK)
VALUES ((select u.USER_ID_PK from PUBLIC.USERS u where u.LOGIN like '%user3%'),
        (select r.ROLE_ID_PK from PUBLIC.ROLES r where r.ROLE like '%ADMIN%'));