create table users(email varchar, password varchar, role varchar);
insert into users(email, password, role) values ('client@web.com','$2a$04$9UEQbxdPBfOo48YuaG96lOIC3By9nzUNBGHBObdZBNDiRDSBn9VbS','CLIENT');
insert into users(email, password, role) values ('admin@web.com','$2a$04$0VPy.CkdFBuwJXh.IK8neOlfTIUInk.osXZSfVEFdF01mqnWzZrfW','ADMIN');