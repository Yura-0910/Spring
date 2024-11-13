--liquibase formatted sql
--changeset MazurovY:3


CREATE TABLE PUBLIC.USERS_ROLES
(
    user_id_pk integer REFERENCES PUBLIC.USERS on delete cascade,
    role_id_pk integer REFERENCES PUBLIC.ROLES on delete restrict,
    PRIMARY KEY (user_id_pk, role_id_pk)
);

/*
 * cascade - при удалении user-а:: удаляются и связанные записи из таблицы USERS_ROLES
 * restrict - при удалении role:: ничего не удаляется, если есть user с такой ролью
 */

/*
SELECT u.USER_ID_PK, u.LOGIN, r.ROLE
FROM USERS_ROLES ur
         JOIN USERS u ON ur.USER_ID_PK = u.USER_ID_PK
         JOIN ROLES r ON ur.ROLE_ID_PK = r.ROLE_ID_PK
 */