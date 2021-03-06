CREATE TABLE IF NOT EXISTS `msns` (
    `id` BIGINT AUTO_INCREMENT,
    `host` VARCHAR(256),
    `port` INTEGER,
    `version` VARCHAR(256),
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    INDEX idx_host(host)
);