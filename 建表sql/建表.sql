create database manager;

use manager;

create table student
(
	Sno BIGINT NOT NULL PRIMARY KEY COMMENT 'ѧ��',
	Sname CHAR(20) NOT NULL COMMENT '����',
	Ssex CHAR(1) COMMENT '�Ա�',
	Sclass BIGINT NOT NULL COMMENT '�༶',
	Sphone BIGINT COMMENT '����'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;