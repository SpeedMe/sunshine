/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : sunshine

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-08-30 11:04:38
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
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COMMENT='回答感谢表';

-- ----------------------------
-- Records of answer_thank
-- ----------------------------
INSERT INTO `answer_thank` VALUES ('43', '19', '28', '2015-08-29 13:39:46');
INSERT INTO `answer_thank` VALUES ('44', '19', '29', '2015-08-29 14:59:27');
INSERT INTO `answer_thank` VALUES ('45', '19', '29', '2015-08-29 14:59:45');
INSERT INTO `answer_thank` VALUES ('46', '19', '29', '2015-08-29 15:00:10');
INSERT INTO `answer_thank` VALUES ('47', '19', '29', '2015-08-29 15:44:56');

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
  `topic_content` mediumtext NOT NULL COMMENT '频道话题内容',
  `topic_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建话题的时间',
  `is_anonymity` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否匿名',
  PRIMARY KEY (`topic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='频道话题';

-- ----------------------------
-- Records of channel_topic
-- ----------------------------
INSERT INTO `channel_topic` VALUES ('15', '3', '19', '16', '', '宁静已经从事了10年的心理辅导工作，但对于大地震的心理辅导来说，她也是第一次经历。大地震后，宁静来到成都市的第一天，就与成都武警医院的一位领导认识了。当时这位领导有些异样的表情引起了宁静的关注，“她的眼睛里含有泪水。”\n这位医院领导的老家就在震中汶川，父母亲和许多亲人都在地震中受灾，但是随着部队进驻灾区后，这位医院领导却不能去救自己的家人，她每天抢救大量的危重伤员，承受着双重的心理压力。这位领导最近一些较为异常的行为也让周围的人感觉到了，“她有时会骂同事和一些志愿者。”\n宁静说：“要让这位领导接受心理辅导并不容易，我给她暗示，引导她放松，让这位领导脱下军装，回归到一名最普通的女人。”经过一番治疗后，这位医院领导大哭了20分钟，一连数天压抑在心中的情绪终于释放了出来。“哭出来就是一种最好的情结宣泄。”\n孙明回复：想哭就哭出来，所有的情绪都化为眼泪，然后就快乐了！\n赵刚回复：释放出来心里会好很多的！！！！！', '2015-08-29 13:25:28', '0');
INSERT INTO `channel_topic` VALUES ('16', '3', '19', '0', '', '在课堂上，记者见到了一名少女，她在课堂中的笑声特别的大，也经常与旁边的同学嬉戏，旁边的辅导员都开玩笑地说她是“大笑姑婆”。辅导员凌键说，她叫董梦蝶，今年14岁。学校倒塌当天，她被埋了一天一夜后才被救了出来。此后，小蝶就像换了一个人似的，她不愿意与人交谈和接触，动作紧张，眼睛内没有一丝生气，经常可以一整天坐着一动不动的。\n5月17日，广州义工团心理辅导组在帐篷里发现了她，在征得其父母同意后，将她带回了武警成都医院。“我们首要的任务就是让这些孩子说话。”在此后的两天内，凌键尝试与小蝶谈话，但小蝶仍然目光呆滞，毫不搭理凌键。凌键于是每半个小时便过去与之谈一次心，告诉她要坚强。\n她终于喊出“叔叔”\n一直到5月19日，董梦蝶的口中忽然间说出了一句话：“叔叔……”能说出话，就表明小蝶开始从自闭中走出来了，凌键十分惊喜。\n接下来就转入了心理辅导的第二阶段：“揭伤疤”。辅导员通过让小蝶说出她被埋在房底下的最痛苦的经历，让他们压抑的情绪宣泄出来。没多久，她便开始了大哭起来，一哭就哭了大半个小时。哭累了，小蝶便趴在床上睡着了。\n20日早上，这名曾经是这堆孩子里最自闭的少女，终于又恢复了她以前的活力，在课堂上，她成为了最活跃的学生。\n赵天意回复：希望小女孩可以尽早从伤痛中恢复过来，加油！', '2015-08-29 13:38:46', '0');
INSERT INTO `channel_topic` VALUES ('17', '3', '19', '0', '', '很久以前，在美国的一个村庄住着一对父子，春天的时候，他们在田里撒播种子，夏天的时候，他们辛勤的施肥、浇水，待到秋天，看到累累果实，他们喜不胜收，正待收割的时候，突然一个晚上，一场飓风卷走了所有庄稼，一棵都没有留下。\n\n　　早晨起来，小男孩坐在田埂哭泣，他的父亲走过来，拍拍他的肩膀说：“感谢上苍吧，给我们留下了土壤与生命。记住，孩子，苦难终将过去，强者永远长存。”\n\n　　第二年，他们照旧春天撒种，夏天施肥、浇水，等待秋天的收获，然而又一场飓风席卷了农田，又是颗粒无收。\n\n　　早晨起来，小男孩坐在田埂哭泣，他的父亲走过来，拍拍他的肩膀说：“感谢上苍吧，给我们留下了土壤与生命。记住，孩子，苦难终将过去，强者永远长存。”\n\n　　那个小男孩永远记住了这句话，并把这句话融入了自己的生命，那个小男孩就是著名的心灵大师罗伯特．舒勒。\n丁依然回复：成功的人都是经历磨难而永不屈服的人，没有经过苦痛的成功是脆弱的！\n陈刚回复：我们经历的苦难会是我们的财富，因为他锻炼了我们的心性和意志！', '2015-08-29 13:40:58', '0');
INSERT INTO `channel_topic` VALUES ('18', '1', '19', '49', '', '寻亲类别：宝贝寻家 \n寻亲编号：143306\n姓      名：王澜峥\n性      别：男\n出生日期：1968年01月01日  \n失踪时身高：未知 \n失踪时间：1975年01月01日 \n失踪人所在地：山西省,阳泉市  \n失踪地点：不详\n寻亲者特征描述：记忆里，我是和爷爷奶奶一起生活的家好像是在岚县，父母是五寨铁路的工人，不经常回家，家里还有个姐姐\n其他资料：（静染秋 跟进） \n注册时间：2015-08-24 21:54:37 \n照片待传\n\n宝贝回家志愿者唯一QQ接待群：1840533\n站务电话：0435-3338090(吉林通化）\n宝贝回家寻子网 咨询信箱：baobeihuijia@yeah.net\n宝贝回家志愿者协会 宝贝回家寻子网  http://www.baobeihuijia.com/\n公益网站 宝贝回家志愿者为寻亲者免费服务 重点帮助16岁以下失踪儿童', '2015-08-29 13:42:13', '0');
INSERT INTO `channel_topic` VALUES ('19', '2', '19', '0', '', '点击图片进入下一页\n　　“月亮孩子”李好拥有一个幸福美满的家庭。 本版图/重庆晨报记者 苑铁力 摄\n　　“冰桶挑战”，让渐冻人走入人们的视野，“肌肉萎缩性侧索硬化症”这种罕见病被众人所知晓。\n　　罕见病，又称“孤儿病”，寓意“孤独”，期望被认知。在重庆，究竟还有多少常人难以知晓的罕见病患者存在，他们生活的家庭，又是以怎样的态度面对人生。今天开始，我们将逐一为你揭晓重庆罕见病家庭在逆境中艰难重生的故事。\n　　我们走近的第一个家庭，孩子有着白色的皮肤、白色的头发和睫毛，眼睛畏光，害怕紫外线，他是白化病患者，但有一个美丽的名字——“月亮孩子”。\n　　昨日，渝北一碗水金香林小区，天空飘着毛毛细雨，8月能有这样的天气，让42岁的李雪建感到踏实，因为没有阳光，意味着儿子出门的程序就能简化，不需要戴墨镜、穿防晒服和撑遮阳伞。这正是李雪建所希望的：儿子能像其他孩子一样，正常出门。\n　　“儿保科医生很肯定地说，你要有心理准备，今后的生活可能很难”\n　　既然没得选，那就好好活\n　　在白化病患者常聚集的“月亮孩子之家”QQ群上，有人发出这样的感叹：人生就像被钉在一个固定的坐标上，没得选择，因为这病打娘胎里就带着了。李雪建说，既然没得选，那就好好活。\n　　畏光、异于常人的外表，让白化病群体很少出门，同伴聚集的QQ群，成为生活不可或缺的部分。QQ群里李雪建的名字叫“好好爸”，他在圈子里颇有些名气，每一年，这个并不富裕的家庭，会带着儿子李好，出现在全国各地的月亮家庭聚会中，他们的生活状态令很多有着相同经历的家庭羡慕，却并不敢轻易尝试。\n　　“我们全家都一个态度，要么被这病压垮，要么就坚强起来，把病压垮。”李雪建说这话时，儿子李好从房间探出头，调皮地吐了吐舌头，白色的人影很快又缩了回去。11岁，正是天真美好的年龄，李雪建努力让儿子不再惧怕生人。\n　　时间回到2003年7月30日，儿子出生，当这个6斤6两的男婴被抱到家人跟前时，笑容在每一个人的脸上僵住，李雪建和妻子陈霞不得不接受现实，降临到他们家的小天使，跟别的孩子有些不同：皮肤、毛发发白，灰蓝色眼珠，更像个雪娃娃。\n　　3个月后，儿保科医生很肯定地告诉李雪建，那句话他至今记忆犹新：“你要有心理准备，今后的生活可能很难，你儿子有白化病，一种罕见病。”\n　　“把儿子抱出去，有人会问我，他是不是外国宝宝，我每次都说是”', '2015-08-29 13:47:42', '0');
INSERT INTO `channel_topic` VALUES ('20', '2', '19', '5', '', '白化病患者拥有一个美丽的名字—“月亮孩子”。名字最早来自古印第安人。因患者怕光，只有晚上有月光时，他们才感到舒适。\n\n　　作为一名白化病患者，35岁的关禄一直希望：看到自己和病友们的皮肤与毛发颜色，别人不会过分好奇；希望更多人看到他们和正常人一样的能力，而不是轻信“会传染”的谣言；希望白化病患者能被社会接受，得到工作、爱情，还有最起码的尊严。\n\n　　“你和别的孩子一样，只是有点白而已”\n\n　　关禄1980年12月11日出生，从那天起，他便有了白化病的特点：白发、白色泛红的皮肤、怕光、怕晒和视力差。\n\n　　父母试图搞清儿子得白化病的根源：不是近亲结婚，家族中也没病史，为什么？\n\n　　去多个大医院咨询后，才知道白化病是由遗传基因引起的罕见病，很多人都是致病基因隐性携带者。只有两个隐性基因相结合，白化病才会在下一代身上出现。\n\n　　幼年时，关禄用过各式各样的土方子和中西药，但吃了十几年药，并未洗去他身上的白色。北京一位老教授最终给出答案，“白化病无法根治”。\n\n　　尽管如此，关禄还是要上学，麻烦事也开始一波接一波地涌来：即使坐在第一排，也看不清黑板；看不清站牌，坐不了公交车，出门困难……\n\n　　多年后，在接触大量白化病家庭后，关禄开始感激父母当年的做法。他们没有像一些家庭那样，不断向孩子重复“白化病患者与常人的区别”，而是告诉关禄，“你和别的孩子一样，只是有点白而已”。\n\n　　上小学的关禄，视力仅有0.05，无法正常学习，但医生说：“孩子只是‘低视力’，不是盲人。”', '2015-08-29 13:48:50', '0');
INSERT INTO `channel_topic` VALUES ('21', '1', '19', '15', '', '白化病患者拥有一个美丽的名字—“月亮孩子”。名字最早来自古印第安人。因患者怕光，只有晚上有月光时，他们才感到舒适。\n\n　　作为一名白化病患者，35岁的关禄一直希望：看到自己和病友们的皮肤与毛发颜色，别人不会过分好奇；希望更多人看到他们和正常人一样的能力，而不是轻信“会传染”的谣言；希望白化病患者能被社会接受，得到工作、爱情，还有最起码的尊严。\n\n　　“你和别的孩子一样，只是有点白而已”\n\n　　关禄1980年12月11日出生，从那天起，他便有了白化病的特点：白发、白色泛红的皮肤、怕光、怕晒和视力差。\n\n　　父母试图搞清儿子得白化病的根源：不是近亲结婚，家族中也没病史，为什么？\n\n　　去多个大医院咨询后，才知道白化病是由遗传基因引起的罕见病，很多人都是致病基因隐性携带者。只有两个隐性基因相结合，白化病才会在下一代身上出现。\n\n　　幼年时，关禄用过各式各样的土方子和中西药，但吃了十几年药，并未洗去他身上的白色。北京一位老教授最终给出答案，“白化病无法根治”。\n\n　　尽管如此，关禄还是要上学，麻烦事也开始一波接一波地涌来：即使坐在第一排，也看不清黑板；看不清站牌，坐不了公交车，出门困难……\n\n　　多年后，在接触大量白化病家庭后，关禄开始感激父母当年的做法。他们没有像一些家庭那样，不断向孩子重复“白化病患者与常人的区别”，而是告诉关禄，“你和别的孩子一样，只是有点白而已”。\n\n　　上小学的关禄，视力仅有0.05，无法正常学习，但医生说：“孩子只是‘低视力’，不是盲人。”', '2015-08-29 13:50:14', '0');
INSERT INTO `channel_topic` VALUES ('22', '1', '19', '10', '', '本版块致力于为身在海外的游子寻亲而开设。凡目前身在海外，需在国内寻找亲人的网友，可将相关寻亲信息发至本版。\n\n最好附有详细情况说明及寻亲者本人照片，包括儿时与现在。发布帖子之后如有进展，请前来更新近况。也可留下其他联系方式，以便帮忙的网友能及时联系到您。', '2015-08-29 13:51:32', '0');
INSERT INTO `channel_topic` VALUES ('23', '1', '19', '5', '', '1992年，济南，3岁的杨超和哥哥玩耍时，被骑摩托的人贩子抱走…杨超对死死拽着他脚的哥哥说的最后一句话是：哥哥，快跑！今年已经29岁的哥哥说，如果能找到弟弟，他最想对弟弟说：对不起，那年6岁的自己没有能够好好保护弟弟。转！寻人！帮宝贝回家！', '2015-08-29 13:52:34', '0');
INSERT INTO `channel_topic` VALUES ('24', '1', '19', '5', '', '2010年1月29日，一位普通的母亲在宝贝回家网上看到了自己孩子的相片，相片上孩子已经沦为乞丐。半年过去了，痛失孩子的母亲终于有机会再见到自己的孩子，虽然这仅仅只是一张相片，但却给这位母亲无限的希望。经过一翻折腾，总算跟拍照的好心人联系上了。第二天一早，这位母亲就早早前往发现孩子的地方——厦门火车站，孩子曾经乞讨过的地方。\n在当地志愿者的陪同下，这位母亲走遍厦门的每个角落，到处打听是否有谁见过她的孩子，是否有谁知道她孩子的下落。功夫不负有心人，总算有人说曾经见过这孩子，见过控制孩子的人贩子，而且还知道人贩子生活规律。为了能和自己的孩子团圆，这位母亲苦苦地守侯在人贩子会乘坐的公交车站旁，但是命运好像跟这位母亲开了一个很大的玩笑，从首班车到末班车，孩子的母亲双脚都已经麻木了，但是还是没能见到孩子。当所有的公车都已经进站休息了，这位母亲还是不肯离去，她还在等着孩子的出现。就这样一天过去了，两天过去了，一直到了第九天，孩子母亲的双脚已经快失去知觉了。这时老家又传来噩耗，孩子母亲的一个表弟在回家的前一天被人害死在宿舍。她终于倒下了，她再也经受不起精神上的折磨了。', '2015-08-29 13:54:10', '0');
INSERT INTO `channel_topic` VALUES ('25', '3', '19', '0', '', '10000000000', '2015-08-29 15:24:39', '0');
INSERT INTO `channel_topic` VALUES ('26', '3', '19', '15', '', '很久以前，在美国的一个村庄住着一对父子，春天的时候，他们在田里撒播种子，夏天的时候，他们辛勤的施肥、浇水，待到秋天，看到累累果实，他们喜不胜收，正待收割的时候，突然一个晚上，一场飓风卷走了所有庄稼，一棵都没有留下。\n\n　　早晨起来，小男孩坐在田埂哭泣，他的父亲走过来，拍拍他的肩膀说：“感谢上苍吧，给我们留下了土壤与生命。记住，孩子，苦难终将过去，强者永远长存。”\n\n　　第二年，他们照旧春天撒种，夏天施肥、浇水，等待秋天的收获，然而又一场飓风席卷了农田，又是颗粒无收。\n\n　　早晨起来，小男孩坐在田埂哭泣，他的父亲走过来，拍拍他的肩膀说：“感谢上苍吧，给我们留下了土壤与生命。记住，孩子，苦难终将过去，强者永远长存。”\n\n　　那个小男孩永远记住了这句话，并把这句话融入了自己的生命，那个小男孩就是著名的心灵大师罗伯特．舒勒。\n丁依然回复：成功的人都是经历磨难而永不屈服的人，没有经过苦痛的成功是脆弱的！', '2015-08-29 16:25:59', '0');
INSERT INTO `channel_topic` VALUES ('27', '3', '19', '5', '', '很久以前，在美国的一个村庄住着一对父子，春天的时候，他们在田里撒播种子，夏天的时候，他们辛勤的施肥、浇水，待到秋天，看到累累果实，他们喜不胜收，正待收割的时候，突然一个晚上，一场飓风卷走了所有庄稼，一棵都没有留下。\n\n　　早晨起来，小男孩坐在田埂哭泣，他的父亲走过来，拍拍他的肩膀说：“感谢上苍吧，给我们留下了土壤与生命。记住，孩子，苦难终将过去，强者永远长存。”\n\n　　第二年，他们照旧春天撒种，夏天施肥、浇水，等待秋天的收获，然而又一场飓风席卷了农田，又是颗粒无收。\n\n　　早晨起来，小男孩坐在田埂哭泣，他的父亲走过来，拍拍他的肩膀说：“感谢上苍吧，给我们留下了土壤与生命。记住，孩子，苦难终将过去，强者永远长存。”\n\n　　那个小男孩永远记住了这句话，并把这句话融入了自己的生命，那个小男孩就是著名的心灵大师罗伯特．舒勒。\n丁依然回复：成功的人都是经历磨难而永不屈服的人，没有经过苦痛的成功是脆弱的！', '2015-08-29 16:31:14', '0');
INSERT INTO `channel_topic` VALUES ('28', '3', '21', '0', '', '5月17日，广州义工团心理辅导组在帐篷里发现了她，在征得其父母同意后，将她带回了武警成都医院。“我们首要的任务就是让这些孩子说话。”在此后的两天内，凌键尝试与小蝶谈话，但小蝶仍然目光呆滞，毫不搭理凌键。凌键于是每半个小时便过去与之谈一次心，告诉她要坚强。 她终于喊出“叔叔” 一直到5月19日，董梦蝶的口中忽然间说出了一句话：“叔叔……”能说出话，就表明小蝶开始从自闭中走出来了，凌键十分惊喜。 接下来就转入了心理辅导的第二阶段：“揭伤疤”。辅导员通过让小蝶说出她被埋在房底下的最痛苦的经历，让他们压抑的情绪宣泄出来。', '2015-08-29 17:26:36', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='私聊内容表';

-- ----------------------------
-- Records of private_chat
-- ----------------------------
INSERT INTO `private_chat` VALUES ('11', '19', '19', 'iiuuiuiuiiu', '2015-08-29 14:59:22', '0');

-- ----------------------------
-- Table structure for shine_channel
-- ----------------------------
DROP TABLE IF EXISTS `shine_channel`;
CREATE TABLE `shine_channel` (
  `channel_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '频道表自增主键',
  `channel_name` varchar(30) NOT NULL DEFAULT '' COMMENT '频道名字',
  `channel_temp` int(10) NOT NULL DEFAULT '0' COMMENT '频道温度',
  PRIMARY KEY (`channel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='频道';

-- ----------------------------
-- Records of shine_channel
-- ----------------------------
INSERT INTO `shine_channel` VALUES ('1', '宝贝回家', '134');
INSERT INTO `shine_channel` VALUES ('2', '月亮孩子', '25');
INSERT INTO `shine_channel` VALUES ('3', '灾后重生', '106');

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
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `un_idx_nickname` (`nickname`) COMMENT '唯一索引',
  UNIQUE KEY `un_idx_email` (`email`) COMMENT 'email唯一索引'
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of shine_user
-- ----------------------------
INSERT INTO `shine_user` VALUES ('19', '0', 'tianxi', '', 'tianxi@zhubajie.com', 'tianxi123', '2015-08-29 13:03:48', '');
INSERT INTO `shine_user` VALUES ('20', '0', 'isea', '', '1206401764@163.com', 'shiyeyouc9', '2015-08-29 13:34:48', '');
INSERT INTO `shine_user` VALUES ('21', '0', 'tian', '', '12@123.com', 'tianxi123', '2015-08-29 16:09:33', '');

-- ----------------------------
-- Table structure for topic_answer
-- ----------------------------
DROP TABLE IF EXISTS `topic_answer`;
CREATE TABLE `topic_answer` (
  `topic_answer_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '话题回答表主键id',
  `topic_id` int(11) NOT NULL DEFAULT '0' COMMENT '话题id',
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '回答话题的用户id',
  `topic_answer_temp` int(11) NOT NULL DEFAULT '0' COMMENT '回答温度',
  `topic_answer_content` varchar(1000) NOT NULL COMMENT '话题回复内容',
  `topic_answer_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '话题回复时间',
  `is_anonymity` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否匿名',
  PRIMARY KEY (`topic_answer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COMMENT='话题回复信息表';

-- ----------------------------
-- Records of topic_answer
-- ----------------------------
INSERT INTO `topic_answer` VALUES ('27', '15', '19', '0', '加油！会好的', '2015-08-29 13:27:51', '1');
INSERT INTO `topic_answer` VALUES ('28', '15', '19', '1', '希望大家都加油！', '2015-08-29 13:39:33', '1');
INSERT INTO `topic_answer` VALUES ('29', '18', '19', '4', '我在山西的一个乡村里发现跟丢失者条件很符合的情况，楼主私信我，具体给我说下特征，我再去看看情况。', '2015-08-29 13:45:12', '1');
INSERT INTO `topic_answer` VALUES ('30', '18', '19', '0', 'hhhhhh', '2015-08-29 14:58:23', '1');
INSERT INTO `topic_answer` VALUES ('31', '18', '19', '0', 'dpo jjjjhjhjhjh', '2015-08-29 15:12:25', '1');
INSERT INTO `topic_answer` VALUES ('32', '18', '19', '0', '206', '2015-08-29 15:44:35', '0');
INSERT INTO `topic_answer` VALUES ('33', '26', '19', '0', '我们经历的苦难会是我们的财富，因为他锻炼了我们的心性和意志！', '2015-08-29 16:26:18', '1');
INSERT INTO `topic_answer` VALUES ('34', '21', '19', '0', '加油！', '2015-08-29 16:32:24', '1');
INSERT INTO `topic_answer` VALUES ('35', '26', '19', '0', '加油', '2015-08-29 17:16:43', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COMMENT='话题关注表';

-- ----------------------------
-- Records of topic_attention
-- ----------------------------
INSERT INTO `topic_attention` VALUES ('18', '19', '20', '2015-08-29 13:48:57');
INSERT INTO `topic_attention` VALUES ('28', '19', '15', '2015-08-29 16:10:41');
INSERT INTO `topic_attention` VALUES ('30', '19', '26', '2015-08-29 16:26:06');
INSERT INTO `topic_attention` VALUES ('31', '19', '27', '2015-08-29 16:31:35');
INSERT INTO `topic_attention` VALUES ('33', '19', '21', '2015-08-29 16:32:08');
INSERT INTO `topic_attention` VALUES ('34', '19', '22', '2015-08-29 16:32:12');
INSERT INTO `topic_attention` VALUES ('36', '19', '21', '2015-08-29 16:40:52');
INSERT INTO `topic_attention` VALUES ('37', '19', '22', '2015-08-29 16:41:05');
INSERT INTO `topic_attention` VALUES ('39', '19', '24', '2015-08-29 17:26:52');
INSERT INTO `topic_attention` VALUES ('40', '19', '23', '2015-08-29 17:26:56');
INSERT INTO `topic_attention` VALUES ('42', '19', '18', '2015-08-29 17:41:46');
