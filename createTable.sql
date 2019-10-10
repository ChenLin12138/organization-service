CREATE TABLE `organizations` (
  `organization_id` char(36) COLLATE utf8_bin NOT NULL,
  `name` char(50) COLLATE utf8_bin NOT NULL,
  `contact_name` char(100) COLLATE utf8_bin NOT NULL,
  `contact_email` varchar(100) COLLATE utf8_bin NOT NULL,
  `contact_phone` varchar(100) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`organization_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO organization.organizations
(organization_id, name, contact_name, contact_email, contact_phone)
VALUES('35690f33-71b1-4996-83f8-93b8ca411848', 'orgnam', 'testorgName', 'scorpion_chenlin@163.com', '13499098898');