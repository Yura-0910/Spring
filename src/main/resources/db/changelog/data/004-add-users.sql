--liquibase formatted sql
--changeset MazurovY:4

--For the case when the "id" is generated automatically via "BIGSERIAL"
--password: p56
INSERT INTO PUBLIC.USERS (login, password)
VALUES ('basic_user', '$2a$10$YJGm1uYBLWjhx2wVOx8Uu.IdZwmEy5Ul2hlTppT.WAZ03kRSE9qb2');
