/*
MySQL Data Transfer
Source Host: localhost
Source Database: filedata
Target Host: localhost
Target Database: filedata
Date: 2015/8/9 22:53:25
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for file
-- ----------------------------
CREATE TABLE `file` (
  `f_id` int(10) NOT NULL auto_increment,
  `f_name` varchar(100) NOT NULL,
  `f_path` varchar(200) NOT NULL,
  `f_download_times` int(10) unsigned zerofill default NULL,
  `f_pic_path` varchar(200) default NULL,
  PRIMARY KEY  (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for share
-- ----------------------------
CREATE TABLE `share` (
  `s_id` int(10) NOT NULL auto_increment,
  `s_name` varchar(100) NOT NULL,
  `s_url` varchar(200) NOT NULL,
  PRIMARY KEY  (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `file` VALUES ('1', 'Dreamweavercs6.zip', '/file/Adobe Dreamweaver CS6.zip', '0000000000', 'file/filebg/5.jpg');
INSERT INTO `file` VALUES ('2', 'Photoshop.rar', '/file/Photoshop CS6(带破解).rar', '0000000000', 'file/filebg/4.jpg');
INSERT INTO `file` VALUES ('3', 'Office 2013.iso', '/file/office.iso', '0000000000', 'file/filebg/3.jpg');
INSERT INTO `file` VALUES ('4', 'Tomcat 8.exe', '/file/apache-tomcat-8.0.11.exe', '0000000000', 'file/filebg/6.jpg');
INSERT INTO `file` VALUES ('5', 'Jdk8.exe', '/file/jdk-8u45-windows-x64.exe', '0000000000', 'file/filebg/7.jpg');
INSERT INTO `file` VALUES ('6', 'MySQL_5_7_3.msi', '/file/mysql-installer-community-5.7.3.0-m13.2063434697.msi', '0000000000', 'file/filebg/8.jpg');
INSERT INTO `file` VALUES ('7', 'NotePad++.exe', '/file/npp_V6.8_Installer.1437546206.exe', '0000000000', 'file/filebg/9.jpg');
INSERT INTO `file` VALUES ('8', 'eclipse-jee.zip', '/file/eclipse-jee-luna-SR2-win32-x86_64.zip', '0000000000', 'file/filebg/10.jpg');
INSERT INTO `share` VALUES ('1', 'Java Web 教学', 'http://pan.baidu.com/s/1dD8RYTV');
INSERT INTO `share` VALUES ('2', '可访问外网Host', 'http://pan.baidu.com/s/1dDCV33b');
INSERT INTO `share` VALUES ('3', 'Windwos 7 677408及软碟通', 'http://pan.baidu.com/s/1gdAiCPd');
INSERT INTO `share` VALUES ('4', 'ADT-Eclipse(SDK更新完整)', 'http://pan.baidu.com/s/1o6mTbuU');
INSERT INTO `share` VALUES ('5', 'JavaScript教程', 'http://pan.baidu.com/s/1mg9WDXQ');
INSERT INTO `share` VALUES ('6', 'JQuery教程', 'http://pan.baidu.com/s/1z1DkM');
INSERT INTO `share` VALUES ('7', '384本小说合集', 'http://pan.baidu.com/s/1eQiXByE');
INSERT INTO `share` VALUES ('8', 'RemoveWAT(windows7激活)', 'http://pan.baidu.com/s/1c02Epu4');
INSERT INTO `share` VALUES ('9', '开发软件集合', 'http://pan.baidu.com/s/1kT1JdMv');
INSERT INTO `share` VALUES ('10', '1982张高清壁纸', 'http://pan.baidu.com/s/1jG5iN3K');
INSERT INTO `share` VALUES ('11', 'adobe系列软件', 'http://pan.baidu.com/s/1pJlVMw7');
INSERT INTO `share` VALUES ('12', 'Jdk7', 'http://pan.baidu.com/s/1pJwLdPp');
INSERT INTO `share` VALUES ('13', 'sql2005标准版', 'http://pan.baidu.com/s/1mgwln3U');
INSERT INTO `share` VALUES ('14', 'Dreamweaver学习资料', 'http://pan.baidu.com/s/1qWEZV3I');
INSERT INTO `share` VALUES ('15', '歌曲：巷子里的童年', 'http://pan.baidu.com/s/1jGA01N4');
INSERT INTO `share` VALUES ('16', 'TeamViewer远程控制', 'http://pan.baidu.com/s/1eQuZ0x8');
