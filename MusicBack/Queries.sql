/*
http://localhost:8080/MusicFront/home
musicstore
*/

create table Genre(name varchar(50), pic varchar(150), description varchar(255), active boolean, view int, constraint pk_Genre_name primary key(name));
create table Artist(name varchar(50), pic varchar(150), bio varchar(255), active boolean, view int, constraint pk_Artist_name primary key(name));
create table User(name varchar(50), role varchar(20), password varchar(20), enabled boolean, address varchar(255), phone varchar(10), email varchar(100), constraint pk_User_email primary key(email));
create table Album(name varchar(50), pic varchar(150), artist varchar(50), genre varchar(50), lang varchar(10), active boolean, view int, songs int, rate int, date date, constraint pk_Album_id primary key(name, artist));
create table Song(name varchar(50), track_no integer, rate integer, preview varchar(150), album varchar(50), artist varchar(50), bought integer,date date, constraint pk_Song_id primary key(track_no, album, artist));
create table Cart(id identity, email varchar(100), path varchar(150), total int, active boolean, date date, constraint pk_Cart_id primary key(id));

insert into Genre (name, pic, description, active, view) values('Rap', 'genre-rap.jpg', 'Rap Description', true, 0);
insert into Genre (name, pic, description, active, view) values('Pop', 'genre-pop.jpg', 'Pop Description', true, 0);

insert into Artist (name, pic, bio, active, view) values('Eminem', 'artist-eminem.jpg', 'Eminem bio', true, 0);
insert into Artist (name, pic, bio, active, view) values('A R Rahman', 'artist-a r rahman.jpg', 'A R Rahman bio', true, 0);

insert into Album (name, pic, artist, genre, lang, active, view, songs, rate, date) values('Recovery', 'album-recovery-eminem.jpg', 'Eminem', 'Rap', 'English', true, 0, 3, 25, '2018-01-13');
insert into Album (name, pic, artist, genre, lang, active, view, songs, rate, date) values('Dil Se', 'album-dil se-a r rahman.jpg', 'A R Rahman', 'Pop', 'Hindi', true, 0, 0, 0, '2018-01-13');

insert into Song (name, track_no, rate, preview, album, artist, bought, date) values('Love The Way You Lie', 1, 10, 'eminem-recovery-1.mp3', 'Recovery', 'Eminem', 0, '2018-01-18');
insert into Song (name, track_no, rate, preview, album, artist, bought, date) values('Space Bound', 2, 8, 'eminem-recovery-2.mp3', 'Recovery', 'Eminem', 0, '2018-01-18');
insert into Song (name, track_no, rate, preview, album, artist, bought, date) values('Not Afraid', 3, 10, 'eminem-recovery-3.mp3', 'Recovery', 'Eminem', 0, '2018-01-18');

insert into User (name, role, password, enabled, address, phone, email) values('Deepak', 'ADMIN', '123456789', false, 'abc', '1234567890', 'a@b.com');
