use toeiconline;

create table role (
                    roleid bigint not null primary key,
                    name varchar(100) null
);


alter table user add column roleid bigint;

alter table user add constraint fk_user_role foreign key (roleid)	references role(roleid);