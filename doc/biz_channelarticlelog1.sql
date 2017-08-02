CREATE TABLE `biz_channelarticlelog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` datetime DEFAULT NULL,
  `lastUpdateDate` datetime DEFAULT NULL,
  `ownership` varchar(20) NOT NULL,
  `version` int(11) DEFAULT '0',
  `description` varchar(4000) DEFAULT NULL,
  `operateType` varchar(10) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `channelArticle_id` int(11) NOT NULL,
  `operateUser_id` int(11) NOT NULL,
  `content` longtext,
  PRIMARY KEY (`id`),
  KEY `FK_pbkolxexjol4jnys33iik1p1h` (`channelArticle_id`),
  KEY `FK_lai9dp4035v7gcwsauxrl1kex` (`operateUser_id`),
  CONSTRAINT `FK_lai9dp4035v7gcwsauxrl1kex` FOREIGN KEY (`operateUser_id`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `FK_pbkolxexjol4jnys33iik1p1h` FOREIGN KEY (`channelArticle_id`) REFERENCES `biz_channelarticle` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3653 DEFAULT CHARSET=utf8mb4;