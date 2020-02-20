CREATE TABLE IF NOT EXISTS `msns` (
    `id` BIGINT AUTO_INCREMENT,
    `host` VARCHAR(256),
    `port` INTEGER,
    `version` VARCHAR(256),
    PRIMARY KEY (`id`)
);