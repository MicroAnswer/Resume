/*
MySQL Data Transfer
Source Host: localhost
Source Database: web
Target Host: localhost
Target Database: web
Date: 2015/8/9 22:54:08
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for message
-- ----------------------------
CREATE TABLE `message` (
  `message_id` int(10) NOT NULL,
  `user_id` int(10) NOT NULL,
  `message` text collate utf8_bin NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY  (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for users
-- ----------------------------
CREATE TABLE `users` (
  `id` int(10) NOT NULL auto_increment,
  `name` text NOT NULL,
  `password` text NOT NULL,
  `sex` int(5) NOT NULL,
  `qq` text,
  `tel` text,
  `addr` text,
  `birthday` date default NULL,
  `email` text,
  `age` int(20) NOT NULL,
  `head` varchar(50) default '/pic/defultHead.jpg',
  `info` text,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `users` VALUES ('1', '范雪蛟', '123456', '1', '78945131', '123465432132', '中国四川成都郫县', '2015-08-19', 'fanxuejiao@outlook.com', '20', '/pic/defultHead.jpg', '这是一个用户这是一个用户这是一个用户这是一个用户');
INSERT INTO `users` VALUES ('48', 'aaa', '123456', '0', '54643213213', '5464513666666', 'China', '2015-08-14', '123@ll.com', '0', '/pic/defultHead.jpg', '这是一个用户：注册日期：2015-8-9 14:45:42');
INSERT INTO `users` VALUES ('49', '小红', '123', '1', '369852147', '123687452', 'sdfasdf', '2008-02-06', '123@hh.com', '0', '/pic/defultHead.jpg', '这是一个用户：注册日期：2015-8-9 14:54:16');
INSERT INTO `users` VALUES ('50', '小小', '456', '0', '3215464', '62315456451', '1asdasd', '2000-02-02', 'qqqq@asd.com', '0', '/pic/defultHead.jpg', '这是一个用户：注册日期：2015-8-9 14:57:36');
INSERT INTO `users` VALUES ('51', 'a', '1', '0', '1', '1', '1', '2015-08-20', '1@a.com', '0', '/pic/defultHead.jpg', '这是一个用户：注册日期：2015-8-9 14:58:27');
INSERT INTO `users` VALUES ('52', '小二', '123', '0', '369852', '321654654654', '12364', '2001-02-07', 'www@qq.com', '0', '/pic/defultHead.jpg', '这是一个用户：注册日期：2015-8-9 15:04:41');
