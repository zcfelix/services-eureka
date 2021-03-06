DROP TABLE IF EXISTS UPLOADINGS;
CREATE TABLE `uploadings` (
  `id`         BIGINT(20)   NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `content`    VARCHAR(500) NOT NULL,
  `created_at` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;