create database manager;

use manager;

create table student
(
	Sno BIGINT NOT NULL PRIMARY KEY COMMENT '学号',
	Sname CHAR(20) NOT NULL COMMENT '姓名',
	Ssex CHAR(1) COMMENT '性别',
	Sclass BIGINT NOT NULL COMMENT '班级',
	Sphone BIGINT COMMENT '电话'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
