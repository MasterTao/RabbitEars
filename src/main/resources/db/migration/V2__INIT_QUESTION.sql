USE rabbit_ears;
CREATE TABLE `question`
(
    `id`               int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
    uid                int(10) unsigned not null default 0 comment '用户id',
    `title`            varchar(128)     NOT NULL DEFAULT '' COMMENT '问题标题',
    read_num           int unsigned     not null default 0 comment '阅读数',
    comment_num        int unsigned     not null default 0 comment '评论数',
    `description`      text             NOT NULL COMMENT '问题描述',
    `create_time`      timestamp        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `last_update_time` timestamp        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最近更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='问题表';