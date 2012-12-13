DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` INT(30) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name_first` VARCHAR(30) NOT NULL,
  `name_middle` VARCHAR(10),
  `name_last` VARCHAR(30) NOT NULL,
  `username` VARCHAR(32) NOT NULL,
  `password` VARCHAR(64) NOT NULL,
  `user_status_code` VARCHAR(1) NOT NULL,
  `date_of_birth` INT(2) UNSIGNED NOT NULL,
  `month_of_birth` INT(2) UNSIGNED NOT NULL,
  `year_of_birth` INT(4) UNSIGNED NOT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uni_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
