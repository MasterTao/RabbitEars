package com.rabbitears.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author 
 * 问题表
 */
@Data
public class Question implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 问题标题
     */
    private String title;

    /**
     * 阅读数
     */
    private Integer readNum = 0;

    /**
     * 评论数
     */
    private Integer commentNum = 0;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最近更新时间
     */
    private LocalDateTime lastUpdateTime;

    /**
     * 问题描述
     */
    private String description;

    private static final long serialVersionUID = 1L;
}