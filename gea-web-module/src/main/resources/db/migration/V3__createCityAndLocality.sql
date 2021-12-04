create table city (
      id            SERIAL PRIMARY KEY,
      name          varchar(55) not null,
      initials      char(10) not null,
      active        bool not null default true,
      countryId     SMALLINT
);
alter table city add constraint FK_City_RefCountry foreign key (countryId)
    references country (id) on delete restrict on update restrict;

create table locality(
     cityId               integer not null,
     localityId           integer not null,
     name                 varchar(55) not null,
     initials             char(10) not null,
     active              bool not null default true,
     primary key (cityId, localityId)
);

alter table locality add constraint FK_Locality_RefCity foreign key (cityId)
    references city (id) on delete restrict on update restrict;