create database BBS;
use BBS;
create table main_forum(
	id int not null primary key auto_increment,
	title varchar(20) not null,
	info varchar(60) 
)charset=utf8;

INSERT INTO `main_forum` 
VALUES ('1','移动开发','移动开发'),
 ('2','网站开发','网站开发');
 

create table sub_forum(
	id int not null primary key auto_increment,
	main_forum int not null, 
	title varchar(20) not null,
	info varchar(60),
	FOREIGN key(main_forum) references main_forum(id) on delete cascade on update cascade
)charset=utf8;

INSERT INTO `sub_forum`
 VALUES ('1','1','android开发','android入门到精通'),
 ('2','1','ios开发','ios从入门到精通'), 
 ('3','2','php基础','php入门'),
 ('4','2','php框架','yii，thinkphp框架等'),
 ('5','2','javaee','javaee学习');

create table user(
	id int not null primary key auto_increment,
	username varchar(20) not null,
	password varchar(20) not null,
    sex varchar(5),
    photo_url tinytext,
	email varchar(30) not null,
	type int not null,       #类型
	register_date datetime not null,  #注册时间
    signature varchar(50),     #签名
	level int not null default 0 , #等级
    active_code varchar(32),	#激活码
    hasActive int	#用户状态状态
)charset=utf8;

INSERT INTO `user` 
VALUES ('1','qq123','123','男',NULL,'123@qq.com','0','2016-03-17 21:54:37','hello','0',NULL,1)
, ('2','张建浩','123','女',NULL,'456@qq.com','0','2016-03-16 21:55:33','空你起哇','0',NULL,1);


create table admin(
	id int not null primary key auto_increment,
	user_name varchar(20) not null,
	password varchar(20) not null,
    photo_url tinytext,
	email varchar(30) not null,
	type int not null,
    sex varchar(10)
)charset=utf8;

INSERT INTO 
`admin` VALUES ('1','admin1','123',NULL,'admin1@qq.com','0'), 
('2','admin2','123',NULL,'admin2@qq.com','1');

#帖子表
create table post(
	id int not null primary key auto_increment,
	forum int not null,   #属于的子版块
	user_id int not null,  #发帖用户
	title varchar(40) not null,  #标题
	card_content varchar(500)not null,  #发帖内容
	send_date datetime not null,    #发帖时间
    post_type int, #帖子类型（普通，精华帖,由管理员设置)
    reply_num int,#帖子回复数目
	FOREIGN key(forum) references sub_forum(id) on delete cascade on update cascade,
	FOREIGN key(user_id) references user(id) on delete cascade on update cascade
)charset=utf8;
INSERT INTO `post`
 VALUES ('1','1','1','android问题1','如题，怎么解决','2016-03-17 22:01:59','0'),
 ('2','2','1','ios问题','随意，瑞','2016-03-17 22:04:53','0'),
 ('3','1','2','android问题2222','223333333','2016-03-17 22:05:32','0'), 
 ('4','3','1','php问题','测试1 11 11','2016-03-17 22:06:02','0'), 
 ('5','1','2','androd问题21','阿萨阿萨阿迪','2016-03-17 22:06:38','0');

#跟帖表
create table followcard(
	id int not null primary key auto_increment,
	send_id int not null,   #属于的帖子
	user_id int not null,
	follow_content varchar(200),  #跟帖内容
	follow_date datetime not null,
	FOREIGN key(send_id) references post(id) on delete cascade on update cascade,
	FOREIGN key(user_id) references user(id) on delete cascade on update cascade
)charset=utf8;

INSERT INTO `followcard`
 VALUES ('1','1','2','沙发','2016-03-17 22:02:40'), 
 ('2','2','2','我不会ios啊啊啊','2016-03-17 22:07:16'), 
 ('3','2','2','我还是不会','2016-03-17 22:07:29'),
 ('4','2','1','你不会啊啊啊啊','2016-03-17 22:07:47'),
 ('5','3','2','andorid阿萨啊','2016-03-17 22:08:34'), 
 ('6','3','1','随意回答','2016-03-17 22:08:32');
 
 
#公告表
create table notice(
	id int not null primary key auto_increment,
	admin_id int not null,  #发布的管理员
	content varchar(200),  #内容
	notice_date datetime not null,  #公告时间
	FOREIGN key(admin_id) references admin(id) on delete cascade on update cascade
)charset=utf8;
INSERT INTO `notice` 
VALUES ('1','1','大家随意啊','2016-03-17 22:09:38');







 