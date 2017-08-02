CREATE TABLE `biz_channelarticle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` datetime DEFAULT NULL,
  `lastUpdateDate` datetime DEFAULT NULL,
  `ownership` varchar(20) NOT NULL,
  `version` int(11) DEFAULT '0',
  `content` longtext,
  `description` varchar(4000) DEFAULT NULL,
  `publish` bit(1) DEFAULT b'0',
  `title` varchar(50) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `valid` bit(1) DEFAULT b'1',
  `lastEditUser_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_gs34pqxkoykniumcl4wc1t5k2` (`lastEditUser_id`),
  CONSTRAINT `FK_gs34pqxkoykniumcl4wc1t5k2` FOREIGN KEY (`lastEditUser_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2215 DEFAULT CHARSET=utf8mb4;