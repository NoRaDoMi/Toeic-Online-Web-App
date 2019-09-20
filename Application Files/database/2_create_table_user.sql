create table user (
                    userid bigint not null primary key auto_increment, -- Tự động tăng
                    name varchar(255) null,
                    password varchar(255) null,
                    fullname varchar(300) null,
                    createddate timestamp null
);