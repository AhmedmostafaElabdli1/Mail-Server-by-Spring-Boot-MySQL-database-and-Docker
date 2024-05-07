DROP TABLE IF EXISTS mail;

CREATE TABLE `mail`(
                        `id` bigint unsigned NOT NULL AUTO_INCREMENT,
                        `mail_recipient` varchar(255) DEFAULT NULL,
                        `subject` varchar(255) DEFAULT NULL,
                        `body` text,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;