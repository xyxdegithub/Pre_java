-- ������
create database easymalldb;

-- ʹ�ÿ�
use easymalldb;

-- ����t_user��
create table t_user(
id int primary key auto_increment,
username varchar(20) unique,
password char(32) not null default '',
salt int,
email varchar(50),
phone varchar(20)
);




