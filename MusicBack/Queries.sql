http://localhost:8080/MusicFront/home
musicstore

create table Genre(name varchar(50), pic varchar(150), description varchar(255), active boolean, view int, constraint pk_Genre_name primary key(name));
create table Artist(name varchar(50), pic varchar(150), bio varchar(255), active boolean, view int, constraint pk_Artist_name primary key(name));
create table User(name varchar(50), role varchar(20), password varchar(20), enabled boolean, address varchar(255), phone varchar(10), email varchar(100), constraint pk_User_email primary key(email));
create table Album(name varchar(50), pic varchar(150), artist varchar(50), genre varchar(50), lang varchar(10), active boolean, view int, songs int, constraint pk_Album_id primary key(name, artist));
create table Song(name varchar(50), track_no integer, rate integer, preview varchar(150), album varchar(50), artist varchar(50), bought integer, constraint pk_Song_id primary key(track_no, album, artist));
create table Cart(id identity, email varchar(100), path varchar(150), total double, active boolean, date date, constraint pk_Cart_id primary key(id));

insert into Genre (name, pic, description, active, view) values('Rap', 'genre-rap.jpg', 'Rap Description', true, 0);
insert into Genre (name, pic, description, active, view) values('Pop', 'genre-pop.jpg', 'Pop Description', true, 0);

insert into Artist (name, pic, bio, active, view) values('Eminem', 'artist-eminem.jpg', 'Eminem bio', true, 0);
insert into Artist (name, pic, bio, active, view) values('A R Rahman', 'artist-a r rahman.jpg', 'A R Rahman bio', true, 0);

insert into Album (name, pic, artist, genre, lang, active, view, songs) values('Recovery', 'album-recovery-eminem.jpg', 'Eminem', 'Rap', 'English', true, 0, 3);
insert into Album (name, pic, artist, genre, lang, active, view, songs) values('Dil Se', 'album-dil se-a r rahman.jpg', 'A R Rahman', 'Pop', 'Hindi', true, 0, 0);

insert into Song (name, track_no, rate, preview, album, artist, bought) values('Love The Way You Lie', 1, 10, 'eminem-recovery-1.mp3', 'Recovery', 'Eminem', 0);
insert into Song (name, track_no, rate, preview, album, artist, bought) values('Space Bound', 2, 8, 'eminem-recovery-2.mp3', 'Recovery', 'Eminem', 0);
insert into Song (name, track_no, rate, preview, album, artist, bought) values('Not Afraid', 3, 10, 'eminem-recovery-3.mp3', 'Recovery', 'Eminem', 0);

insert into User (name, role, password, enabled, address, phone, email) values('Deepak', 'ADMIN', '123456789', false, 'abc', '1234567890', 'a@b.com');

Abi Works

create table Genre(name varchar(50), pic varchar(150), description varchar(255), active boolean, constraint pk_Genre_name primary key(name));
create table Artist(artistid integer,name varchar(50), pic varchar(150), bio varchar(255), active boolean, constraint pk_Artist_name primary key(name));
create table User(name varchar(50), role varchar(20), enabled boolean, address varchar(255), phone decimal(10), email varchar(100), constraint pk_User_email primary key(email));
create table Album(albumid identity,name varchar(50), pic varchar(150), artist varchar(50), genre varchar(50), lang varchar(10), active boolean, constraint pk_Album_id primary key(albumid));
create table Song(songid identity,name varchar(50), track_no integer auto_increment, rate integer, preview varchar(150), album varchar(50), artist varchar(50), rating integer, constraint pk_Song_id primary key(songid));


Abi

create table Genre(name varchar(50), pic varchar(150), description varchar(255), active boolean, constraint pk_Genre_name primary key(name));
create table Artist(artistid integer,name varchar(50), pic varchar(150), bio varchar(255), active boolean, constraint pk_Artist_name primary key(name));
create table User(name varchar(50), role varchar(20), enabled boolean, address varchar(255), phone decimal(10), email varchar(100), constraint pk_User_email primary key(email));
create table Album(albumid identity,name varchar(50), pic varchar(150), artist varchar(50), genre varchar(50), lang varchar(10), active boolean, constraint pk_Album_id primary key(albumid), constraint fk_Artist_name foreign key(name) references Artist(name), constraint fk_Genre_name foreign key(name) references Genre(name));
create table Song(songid identity,name varchar(50), track_no integer auto_increment, rate integer, preview varchar(150), album varchar(50), artist varchar(50), rating integer, constraint pk_Song_id primary key(songid), constraint fk_Album_key foreign key(name, artist) references Album(name, artist));


Me

create table Genre(name varchar(50), pic varchar(150), description varchar(255), active boolean, constraint pk_Genre_name primary key(name));
create table Artist(name varchar(50), pic varchar(150), bio varchar(255), active boolean, constraint pk_Artist_name primary key(name));
create table User(name varchar(50), role varchar(20), enabled boolean, address varchar(255), phone decimal(10), email varchar(100), constraint pk_User_email primary key(email));
create table Album(name varchar(50), pic varchar(150), artist varchar(50), genre varchar(50), lang varchar(10), active boolean, constraint pk_Album_id primary key(name, artist), constraint fk_Artist_name foreign key(artist) references Artist(name), constraint fk_Genre_name foreign key(genre) references Genre(name));
create table Song(name varchar(50), track_no integer auto_increment, rate integer, preview varchar(150), album varchar(50), artist varchar(50), rating integer, constraint pk_Song_id primary key(track_no, album), constraint fk_Album_name foreign key(album, artist) references Album(name, artist));

CREATE TRIGGER TRG
ON Song
INSTEAD OF INSERT

AS

DECLARE @tno INT
DECLARE @album VARCHAR(60)

SELECT @tno=track_no FROM INSERTED
SELECT @album=album FROM INSERTED

IF NOT EXISTS (SELECT * FROM Song WHERE album=@album)
SET @tno=1
ELSE
SET @tno=(  SELECT MAX(S.track_no)+1 
            FROM Song S
            WHERE S.album=@album
          )

INSERT INTO Song (track_no,album)
            VALUES  (@tno,@album);