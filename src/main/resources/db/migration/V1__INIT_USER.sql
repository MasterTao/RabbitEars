USE rabbit_ears;

CREATE TABLE `user`
(
    `id`               int(10) unsigned                        NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `name`             varchar(64) COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '' COMMENT '用户名',
    `password`         varchar(32) COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '' COMMENT '密码',
    `avatar`           varchar(256) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '头像',
    `create_time`      timestamp                               NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `last_update_time` timestamp                               NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最近更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `user_name_uindex` (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='用户表';