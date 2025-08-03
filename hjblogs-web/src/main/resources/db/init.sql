/*
 Navicat Premium Data Transfer

 Source Server         : Weblog
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : localhost:3306
 Source Schema         : weblog

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 18/11/2023 12:00:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article`  (
                              `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '文章id',
                              `title` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '文章标题',
                              `cover` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '文章封面',
                              `summary` varchar(160) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '文章摘要',
                              `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                              `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
                              `is_deleted` tinyint(2) NOT NULL DEFAULT 0 COMMENT '删除标志位：0：未删除 1：已删除',
                              `read_num` int(11) UNSIGNED NOT NULL DEFAULT 1 COMMENT '被阅读次数',
                              PRIMARY KEY (`id`) USING BTREE,
                              INDEX `idx_create_time`(`create_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_article_category_rel
-- ----------------------------
DROP TABLE IF EXISTS `t_article_category_rel`;
CREATE TABLE `t_article_category_rel`  (
                                           `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
                                           `article_id` bigint(20) UNSIGNED NOT NULL COMMENT '文章id',
                                           `category_id` bigint(20) UNSIGNED NOT NULL COMMENT '分类id',
                                           PRIMARY KEY (`id`) USING BTREE,
                                           UNIQUE INDEX `uni_article_id`(`article_id`) USING BTREE,
                                           INDEX `idx_category_id`(`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章所属分类关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_article_content
-- ----------------------------
DROP TABLE IF EXISTS `t_article_content`;
CREATE TABLE `t_article_content`  (
                                      `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '文章内容id',
                                      `article_id` bigint(20) NOT NULL COMMENT '文章id',
                                      `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '教程正文',
                                      PRIMARY KEY (`id`) USING BTREE,
                                      INDEX `idx_article_id`(`article_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章内容表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_article_tag_rel
-- ----------------------------
DROP TABLE IF EXISTS `t_article_tag_rel`;
CREATE TABLE `t_article_tag_rel`  (
                                      `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
                                      `article_id` bigint(20) UNSIGNED NOT NULL COMMENT '文章id',
                                      `tag_id` bigint(20) UNSIGNED NOT NULL COMMENT '标签id',
                                      PRIMARY KEY (`id`) USING BTREE,
                                      INDEX `idx_article_id`(`article_id`) USING BTREE,
                                      INDEX `idx_tag_id`(`tag_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 106 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章对应标签关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_blog_settings
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_settings`;
CREATE TABLE `t_blog_settings`  (
                                    `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
                                    `logo` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '博客Logo',
                                    `name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '博客名称',
                                    `author` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '作者名',
                                    `introduction` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '介绍语',
                                    `avatar` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '作者头像',
                                    `github_homepage` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'GitHub 主页访问地址',
                                    `csdn_homepage` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'CSDN 主页访问地址',
                                    `gitee_homepage` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'Gitee 主页访问地址',
                                    `zhihu_homepage` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '知乎主页访问地址',
                                    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '博客设置表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category`  (
                               `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '分类id',
                               `name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '分类名称',
                               `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
                               `is_deleted` tinyint(2) NOT NULL DEFAULT 0 COMMENT '逻辑删除标志位：0：未删除 1：已删除',
                               PRIMARY KEY (`id`) USING BTREE,
                               UNIQUE INDEX `uk_name`(`name`) USING BTREE,
                               INDEX `idx_create_time`(`create_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章分类表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_statistics_article_pv
-- ----------------------------
DROP TABLE IF EXISTS `t_statistics_article_pv`;
CREATE TABLE `t_statistics_article_pv`  (
                                            `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
                                            `pv_date` date NOT NULL COMMENT '被统计的日期',
                                            `pv_count` bigint(20) UNSIGNED NOT NULL COMMENT 'pv浏览量',
                                            `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                            `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
                                            PRIMARY KEY (`id`) USING BTREE,
                                            UNIQUE INDEX `uk_pv_date`(`pv_date`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '统计表 - 文章 PV (浏览量)' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag`  (
                          `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '标签id',
                          `name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '标签名称',
                          `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                          `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
                          `is_deleted` tinyint(2) NOT NULL DEFAULT 0 COMMENT '逻辑删除标志位：0：未删除 1：已删除',
                          PRIMARY KEY (`id`) USING BTREE,
                          UNIQUE INDEX `uk_name`(`name`) USING BTREE,
                          INDEX `idx_create_time`(`create_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章标签表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
                           `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
                           `username` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
                           `password` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
                           `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                           `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
                           `is_deleted` tinyint(2) NOT NULL DEFAULT 0 COMMENT '删除标志位：0：未删除 1：已删除',
                           PRIMARY KEY (`id`) USING BTREE,
                           INDEX `idx_create_time`(`create_time`) USING BTREE,
                           INDEX `idx_username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
                                `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
                                `username` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
                                `role` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色',
                                `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                PRIMARY KEY (`id`) USING BTREE,
                                INDEX `idx_username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色表' ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;


-- Weblog 所需的初始化数据，如登录用户、用户角色、博客设置信息
INSERT INTO `weblog`.`t_user` (`id`, `username`, `password`, `create_time`, `update_time`, `is_deleted`) VALUES (1, 'hejuzs', '$2a$10$I7Xb8FxyLjhmN5yYtqNgluMjlPvPFSI3p5luVCL2PblA3mgBkjxoe', '2025-07-21 11:57:18', '2025-07-21 16:23:29', 0);
INSERT INTO `weblog`.`t_user` (`id`, `username`, `password`, `create_time`, `update_time`, `is_deleted`) VALUES (2, 'test', '$2a$10$oGwuH3kXpkZugq7579xS3e522NUsdySehIxqUiOZz0TXgMKZDHpoC', '2025-07-21 01:22:05', '2025-07-21 01:22:05', 0);
INSERT INTO `weblog`.`t_user_role` (`id`, `username`, `role`, `create_time`) VALUES (1, 'hejuzs', 'ROLE_ADMIN', '2025-07-21 01:21:15');
INSERT INTO `weblog`.`t_user_role` (`id`, `username`, `role`, `create_time`) VALUES (2, 'test', 'ROLE_VISITOR', '2025-07-21 01:23:33');
INSERT INTO `weblog`.`t_blog_settings` (`id`, `logo`, `name`, `author`, `introduction`, `avatar`, `github_homepage`, `csdn_homepage`, `gitee_homepage`, `zhihu_homepage`) VALUES (1, 'https://img.quanxiaoha.com/quanxiaoha/f97361c0429d4bb1bc276ab835843065.jpg', '犬小哈的博客', '犬小哈', '平安喜乐test', 'https://img.quanxiaoha.com/quanxiaoha/f97361c0429d4bb1bc276ab835843065.jpg', 'https://www.quanxiaoha.com', 'https://www.quanxiaoha.com', 'https://www.quanxiaoha.com', 'https://www.quanxiaoha.com');


-- 二期


alter table t_category add column articles_total int(11) NOT NULL DEFAULT '0' COMMENT '此分类下文章总数';
alter table t_tag add column articles_total int(11) NOT NULL DEFAULT '0' COMMENT '此标签下文章总数';

alter table t_article add column `weight` int(6) unsigned NOT NULL DEFAULT '0' COMMENT '文章权重，用于是否置顶（0: 未置顶；>0: 参与置顶，权重值越高越靠前）';


CREATE TABLE `t_wiki` (
                          `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
                          `title` varchar(120) NOT NULL DEFAULT '' COMMENT '标题',
                          `cover` varchar(120) NOT NULL DEFAULT '' COMMENT '封面',
                          `summary` varchar(160) DEFAULT '' COMMENT '摘要',
                          `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                          `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
                          `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '删除标志位：0：未删除 1：已删除',
                          `weight` int(6) unsigned NOT NULL DEFAULT '0' COMMENT '权重，用于是否置顶（0: 未置顶；>0: 参与置顶，权重值越高越靠前）',
                          `is_publish` tinyint(2) NOT NULL DEFAULT '1' COMMENT '是否发布：0：未发布 1：已发布',
                          PRIMARY KEY (`id`) USING BTREE,
                          KEY `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='知识库表';


CREATE TABLE `t_wiki_catalog` (
                                  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
                                  `wiki_id` bigint(20) unsigned NOT NULL COMMENT '知识库id',
                                  `article_id` bigint(20) unsigned DEFAULT NULL COMMENT '文章id',
                                  `title` text NOT NULL COMMENT '标题',
                                  `level` tinyint(2) NOT NULL DEFAULT '1' COMMENT '目录层级',
                                  `parent_id` bigint(20) unsigned DEFAULT NULL COMMENT '父目录id',
                                  `sort` tinyint(2) unsigned NOT NULL DEFAULT '1' COMMENT '排序',
                                  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
                                  `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '删除标志位：0：未删除 1：已删除',
                                  PRIMARY KEY (`id`) USING BTREE,
                                  UNIQUE KEY `uk_article_id` (`article_id`) USING BTREE,
                                  KEY `idx_sort` (`sort`) USING BTREE,
                                  KEY `idx_wiki_id` (`wiki_id`) USING BTREE,
                                  KEY `idx_parent_id` (`parent_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='知识库目录表';




alter table t_article add column `type` tinyint(2) NOT NULL DEFAULT '1' COMMENT '文章类型 - 1：普通文章，2：收录于知识库';


CREATE TABLE `t_comment` (
                             `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
                             `content` varchar(120) NOT NULL DEFAULT '' COMMENT '评论内容',
                             `avatar` varchar(160) DEFAULT NULL COMMENT '头像',
                             `nickname` varchar(60) NOT NULL DEFAULT '' COMMENT '昵称',
                             `mail` varchar(60) NOT NULL DEFAULT '' COMMENT '邮箱',
                             `website` varchar(60) DEFAULT NULL COMMENT '网站地址',
                             `router_url` varchar(60) NOT NULL DEFAULT '' COMMENT '评论所属的路由',
                             `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
                             `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '删除标志位：0：未删除 1：已删除',
                             `reply_comment_id` bigint(20) unsigned DEFAULT NULL COMMENT '回复的评论 ID',
                             `parent_comment_id` bigint(20) unsigned DEFAULT NULL COMMENT '父评论 ID',
                             `reason` varchar(300) DEFAULT '' COMMENT '原因描述',
                             `status` tinyint(2) NOT NULL DEFAULT '1' COMMENT '1: 待审核；2：正常；3：审核未通过;',
                             PRIMARY KEY (`id`) USING BTREE,
                             KEY `idx_router_url` (`router_url`) USING BTREE,
                             KEY `idx_create_time` (`create_time`) USING BTREE,
                             KEY `idx_reply_comment_id` (`reply_comment_id`) USING BTREE,
                             KEY `idx_parent_comment_id` (`parent_comment_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='评论表';


alter table t_blog_settings add column `mail` varchar(60) DEFAULT '' COMMENT '博主邮箱地址';
alter table t_blog_settings add column `is_comment_sensi_word_open` tinyint(2) NOT NULL DEFAULT '1' COMMENT '是否开启评论敏感词过滤, 0:不开启；1：开启';
alter table t_blog_settings add column `is_comment_examine_open` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否开启评论审核, 0: 未开启；1：开启';


















