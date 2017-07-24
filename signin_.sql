Create database signin;
use signin;
create table USERS
(
ID INT(10) NOT NULL AUTO_INCREMENT,
 USERNAME VARCHAR(36) not null,
 PASSWORD VARCHAR(36) not null,
 PRIMARY KEY (ID)
) ;
desc USERS;