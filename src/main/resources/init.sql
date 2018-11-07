create table shorten_url
(
  id        varchar(32)   not null
    primary key,
  url       varchar(2000) not null,
  short_url varchar(200)  not null
);