CREATE TABLE `organizations` (
  `organization_id` char(36) COLLATE utf8_bin NOT NULL,
  `name` char(50) COLLATE utf8_bin NOT NULL,
  `contact_name` char(100) COLLATE utf8_bin NOT NULL,
  `contact_email` varchar(100) COLLATE utf8_bin NOT NULL,
  `contact_phone` varchar(100) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`organization_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;