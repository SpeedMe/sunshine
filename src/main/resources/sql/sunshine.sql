/*
Navicat MySQL Data Transfer

Source Server         : me
Source Server Version : 50623
Source Host           : localhost:3306
Source Database       : sunshine

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2015-08-27 17:26:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for answer_thank
-- ----------------------------
DROP TABLE IF EXISTS `answer_thank`;
CREATE TABLE `answer_thank` (
  `answer_thank_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '回答感谢表主键id',
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户id',
  `topic_answer_id` int(11) NOT NULL DEFAULT '0' COMMENT '话题回答id',
  `thank_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '感谢时间',
  PRIMARY KEY (`answer_thank_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='回答感谢表';

-- ----------------------------
-- Records of answer_thank
-- ----------------------------

-- ----------------------------
-- Table structure for channel_topic
-- ----------------------------
DROP TABLE IF EXISTS `channel_topic`;
CREATE TABLE `channel_topic` (
  `topic_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '话题表自增主键',
  `channel_id` int(11) DEFAULT '0' COMMENT '频道id',
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '发布该话题的用户id',
  `topic_temp` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '频道话题温度',
  `topic_name` varchar(50) NOT NULL DEFAULT '' COMMENT '频道话题名字',
  `topic_content` text NOT NULL COMMENT '频道话题内容',
  `topic_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建话题的时间',
  PRIMARY KEY (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='频道话题';

-- ----------------------------
-- Records of channel_topic
-- ----------------------------

-- ----------------------------
-- Table structure for private_chat
-- ----------------------------
DROP TABLE IF EXISTS `private_chat`;
CREATE TABLE `private_chat` (
  `private_chat_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '私聊表主键id',
  `send_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '消息发送方id',
  `receive_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '消息接收方id',
  `chat_content` varchar(1024) NOT NULL DEFAULT '' COMMENT '私聊内容',
  `chat_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '私聊时间',
  `is_readed` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已经阅读',
  PRIMARY KEY (`private_chat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='私聊内容表';

-- ----------------------------
-- Records of private_chat
-- ----------------------------

-- ----------------------------
-- Table structure for shine_channel
-- ----------------------------
DROP TABLE IF EXISTS `shine_channel`;
CREATE TABLE `shine_channel` (
  `channel_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '频道表自增主键',
  `channel_name` varchar(30) NOT NULL DEFAULT '' COMMENT '频道名字',
  `channel_temp` int(10) NOT NULL DEFAULT '0' COMMENT '频道温度',
  PRIMARY KEY (`channel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='频道';

-- ----------------------------
-- Records of shine_channel
-- ----------------------------

-- ----------------------------
-- Table structure for shine_user
-- ----------------------------
DROP TABLE IF EXISTS `shine_user`;
CREATE TABLE `shine_user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户表自增主键',
  `phone_number` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '用户手机号',
  `nickname` varchar(30) NOT NULL DEFAULT '' COMMENT '用户别名',
  `realname` varchar(20) NOT NULL DEFAULT '' COMMENT '用户真实姓名',
  `email` varchar(50) NOT NULL DEFAULT '' COMMENT '用户邮箱',
  `password` varchar(40) NOT NULL DEFAULT '' COMMENT '用户密码',
  `regdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '用户注册时间',
  `avatar_path` varchar(100) NOT NULL DEFAULT '' COMMENT '头像路径',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of shine_user
-- ----------------------------

-- ----------------------------
-- Table structure for topic_answer
-- ----------------------------
DROP TABLE IF EXISTS `topic_answer`;
CREATE TABLE `topic_answer` (
  `topic_answer_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '话题回答表主键id',
  `topic_id` int(11) NOT NULL DEFAULT '0' COMMENT '话题id',
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '回答话题的用户id',
  `topic_answer_temp` int(11) NOT NULL DEFAULT '0' COMMENT '回答温度',
  `topic_answer_content` text NOT NULL COMMENT '话题回复内容',
  `topic_answer_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '话题回复时间',
  PRIMARY KEY (`topic_answer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='话题回复信息表';

-- ----------------------------
-- Records of topic_answer
-- ----------------------------

-- ----------------------------
-- Table structure for topic_attention
-- ----------------------------
DROP TABLE IF EXISTS `topic_attention`;
CREATE TABLE `topic_attention` (
  `topic_attention_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '话题关注表自增主键id',
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户id',
  `topic_id` int(11) NOT NULL DEFAULT '0' COMMENT '话题id',
  `topic_attention_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '关注时间',
  PRIMARY KEY (`topic_attention_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='话题关注表';

-- ----------------------------
-- Records of topic_attention
-- ----------------------------
