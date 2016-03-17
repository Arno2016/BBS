create database BBS;
use BBS;
create table main_forum(
	id int not null primary key auto_increment,
	title varchar(20) not null,
	info varchar(60) 
)charset=utf8;

create table sub_forum(
	id int not null primary key auto_increment,
	main_forum int not null, 
	title varchar(20) not null,
	info varchar(60),
	FOREIGN key(main_forum) references main_forum(id) on delete cascade on update cascade
)charset=utf8;

create table user(
	id int not null primary key auto_increment,
	username varchar(20) not null,
	password varchar(20) not null,
    photo_url tinytext,
	email varchar(30) not null,
	type int not null,       #类型
	register_date varchar(20) not null,  #注册时间
  signature varchar(50),     #签名
	level int not null default 0 , #等级
    active_code varchar(32),	#激活码
    hasActive int	#用户状态状态
)charset=utf8;

create table active(
	user_id int,
    active_code varchar(32),
    hasActive int,
    FOREIGN key(user_id) references user(id) on delete cascade on update cascade
)charset=utf8;


create table admin(
	id int not null primary key auto_increment,
	user_name varchar(20) not null,
	password varchar(20) not null,
    photo_url tinytext,
	email varchar(30) not null,
	type int not null
)charset=utf8;


#发贴表
create table sendcard(
	id int not null primary key auto_increment,
	forum int not null,   #属于的子版块
	user_id int not null,  #发帖用户
	title varchar(40) not null,  #标题
	card_content varchar(500)not null,  #发帖内容
	send_date datetime not null,    #发帖时间
	FOREIGN key(forum) references sub_forum(id) on delete cascade on update cascade,
	FOREIGN key(user_id) references user(id) on delete cascade on update cascade
)charset=utf8;


#跟帖表
create table followcard(
	id int not null primary key auto_increment,
	send_id int not null,   #属于的帖子
	user_id int not null,
	follow_content varchar(200),  #跟帖内容
	follow_date datetime not null,
	FOREIGN key(send_id) references sendcard(id) on delete cascade on update cascade,
	FOREIGN key(user_id) references user(id) on delete cascade on update cascade
)charset=utf8;


#公告表
create table notice(
	id int not null primary key auto_increment,
	admin_id int not null,  #发布的管理员
	content varchar(200),  #内容
	notice_date datetime not null,  #公告时间
	FOREIGN key(admin_id) references admin(id) on delete cascade on update cascade
)charset=utf8;