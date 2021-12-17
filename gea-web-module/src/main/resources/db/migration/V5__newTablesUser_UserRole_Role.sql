create table "user" (
                        id            SERIAL PRIMARY KEY,
                        login                 varchar(55) not null,
                        password             varchar(120) not null
);

create table role (
                      id            SMALLSERIAL PRIMARY KEY,
                      name          varchar(55) not null
);

create table user_role (
                           user_id            integer not null,
                           role_id             integer not null,
                           primary key (user_id, role_id)
);

alter table user_role add constraint FK_user_role_RefUser foreign key (user_id)
    references "user" (id) on delete restrict on update restrict;

alter table user_role add constraint FK_user_role_RefRole foreign key (role_id)
    references role (id) on delete restrict on update restrict;