
create table SEC_USER
(
  userId           BIGINT NOT NULL Primary Key AUTO_INCREMENT,
  userName         VARCHAR(36) NOT NULL UNIQUE,
  encryptedPassword VARCHAR(128) NOT NULL,
  ENABLED           BIT NOT NULL 
) ;


create table SEC_ROLE
(
  roleId   BIGINT NOT NULL Primary Key AUTO_INCREMENT,
  roleName VARCHAR(30) NOT NULL UNIQUE
) ;


create table USER_ROLE
(
  ID      BIGINT NOT NULL Primary Key AUTO_INCREMENT,
  userId BIGINT NOT NULL,
  roleId BIGINT NOT NULL
);

alter table USER_ROLE
  add constraint USER_ROLE_UK unique (userId, roleId);

alter table USER_ROLE
  add constraint USER_ROLE_FK1 foreign key (userId)
  references SEC_USER (userId);
 
alter table USER_ROLE
  add constraint USER_ROLE_FK2 foreign key (roleId)
  references SEC_ROLE (roleId);

insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Jon', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Freddie Mercury', '$2y$10$kLY4T2MxHuOsQPOjNp49I.D2FPW.AG2nHyjATvADSNuuTyyxgQRW2', 1);

insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Brain May', '$2y$10$BXLz7Ac42RV9US1jyAxZtedXqXoAqJQlfIDnYGfC4meX9yIVDRXMO', 1);

insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('John Deacon', '$2y$10$/HwktDNvW42onEgluwhiGui1FB7m64ZydcqZ6OjKWz1psQahW4ZF2', 1);

insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Roger Meddows Taylor', '$2y$10$pSfpWoeqJTE/okPZeYEsE.8coslxSTJm3.l9VqprIqcxjKVvD.8na', 1);

insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('MC Ride', '$2y$10$8hLnbeDrtTd64aOw7hFjK.xo00xz506XpYYhzY8cxA75nV5l3VdIy', 1);

insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('David Gilmour', '$2y$10$U4hSd5QktdOA1vpk.d5AH.1rnjmwRNGO.QyF5Y2XAbS1MMfZhIGcC', 1);

insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Zack Hill', '$2y$10$Z8AUHGIcAv.HUbU4ENwrF.bTfjf.m76sqw97brUOD0.aJJ.2tWr6G', 1);

insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Andy Morin', '$2y$10$ysSU8nLfw17FEAl/JdSQjeajZ.iNhIh1taLBKUCaO3b4hmPrOGdbC', 1);

insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Thom Yorke', '$2y$10$f/rriIQMzLhhI1ePjE6.yOzohK46z1jAcTyPCbpu7MNFk6CtQtuEa', 1);

insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Pink Floyd', '$2y$10$mxQHAMjHsX7AJSiN.6OvLetepdJF5/Q95H70lM2AaW4SwPYZ1vLTW', 1);

insert into sec_role (roleName)
values ('ROLE_PROFESSOR');

insert into sec_role (roleName)
values ('ROLE_STUDENT');
 
insert into user_role (userId, roleId)
values (1, 1);

insert into user_role (userId, roleId)
values (2, 2);

insert into user_role (userId, roleId)
values (3, 2);

insert into user_role (userId, roleId)
values (4, 2);

insert into user_role (userId, roleId)
values (5, 2);

insert into user_role (userId, roleId)
values (6, 2);

insert into user_role (userId, roleId)
values (7, 2);

insert into user_role (userId, roleId)
values (8, 2);

insert into user_role (userId, roleId)
values (9, 2);

insert into user_role (userId, roleId)
values (10, 2);

insert into user_role (userId, roleId)
values (11, 2);

COMMIT;

