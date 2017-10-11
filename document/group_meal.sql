/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : group_meal

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-10-11 21:20:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `group_company`
-- ----------------------------
DROP TABLE IF EXISTS `group_company`;
CREATE TABLE `group_company` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `status` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '状态（1=正常，0=停用）',
  `full_name` varchar(100) NOT NULL COMMENT '公司全名',
  `short_name` varchar(50) NOT NULL COMMENT '公司简称',
  `owner_city` varchar(100) NOT NULL COMMENT '所属城市',
  `area` varchar(50) NOT NULL COMMENT '区域',
  `address` varchar(255) NOT NULL COMMENT '配送地址',
  `contact_person` varchar(50) NOT NULL COMMENT '联系人',
  `contact_phone` varchar(30) NOT NULL COMMENT '联系人电话',
  `cooperation_start_time` datetime NOT NULL COMMENT '合作开始时间',
  `cooperation_end_time` datetime NOT NULL COMMENT '合作结束时间',
  `is_del` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除（1=删除，0=未删除）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_unique` (`full_name`,`contact_phone`),
  KEY `idx_select` (`status`,`full_name`,`contact_phone`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='企业公司表';

-- ----------------------------
-- Records of group_company
-- ----------------------------
INSERT INTO `group_company` VALUES ('1', '2017-09-25 19:23:57', '2017-09-25 19:23:57', '1', 'fullName', 'sortName', 'ownerCity', 'area', 'address', 'contactPerson', 'contactPhone', '2017-09-25 19:23:56', '2017-09-25 19:23:56', '0');
INSERT INTO `group_company` VALUES ('2', '2017-10-11 18:02:25', '2017-10-11 18:02:25', '1', '1', '1', '1', '1', '1', '1', '1', '2017-10-11 00:00:00', '2017-10-28 18:02:05', '0');
INSERT INTO `group_company` VALUES ('3', '2017-10-11 20:28:10', '2017-10-11 20:28:10', '1', '2', '2', '2', '2', '2', '2', '2', '2017-10-11 00:00:00', '2017-10-31 00:00:00', '0');
INSERT INTO `group_company` VALUES ('4', '2017-10-11 20:32:10', '2017-10-11 20:32:10', '1', '3', '3', '3', '3', '3', '3', '3', '2017-10-19 00:00:00', '2017-10-30 00:00:00', '0');
INSERT INTO `group_company` VALUES ('5', '2017-10-11 20:48:55', '2017-10-11 20:48:55', '1', '4', '4', '4', '4', '4', '4', '4', '2017-10-26 00:00:00', '2017-10-25 00:00:00', '0');
INSERT INTO `group_company` VALUES ('6', '2017-10-11 20:54:54', '2017-10-11 20:54:54', '1', '5', '5', '5', '5', '5', '5', '5', '2017-10-19 00:00:00', '2017-10-29 00:00:00', '0');
INSERT INTO `group_company` VALUES ('7', '2017-10-11 21:10:26', '2017-10-11 21:10:26', '1', '6', '6', '6', '6', '6', '6', '6', '2017-10-05 00:00:00', '2017-10-11 21:10:22', '0');
INSERT INTO `group_company` VALUES ('8', '2017-10-11 21:11:02', '2017-10-11 21:11:02', '1', '8', '8', '8', '8', '8', '8', '8', '2017-10-01 00:00:00', '2017-10-11 21:11:01', '0');
INSERT INTO `group_company` VALUES ('9', '2017-10-11 21:12:44', '2017-10-11 21:12:44', '1', '9', '9', '9', '9', '9', '9', '9', '2017-10-02 00:00:00', '2017-10-11 21:12:43', '0');
INSERT INTO `group_company` VALUES ('10', '2017-10-11 21:14:41', '2017-10-11 21:14:41', '1', '10', '10', '10', '10', '10', '10', '10', '2017-10-05 00:00:00', '2017-10-31 00:00:00', '0');
INSERT INTO `group_company` VALUES ('11', '2017-10-11 21:14:55', '2017-10-11 21:14:55', '1', '11', '11', '11', '11', '11', '11', '11', '2017-10-17 00:00:00', '2017-10-24 00:00:00', '0');

-- ----------------------------
-- Table structure for `group_company_item_rel`
-- ----------------------------
DROP TABLE IF EXISTS `group_company_item_rel`;
CREATE TABLE `group_company_item_rel` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `company_id` bigint(20) unsigned NOT NULL COMMENT '公司id',
  `sku_code` varchar(100) NOT NULL COMMENT '商品code',
  `status` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '状态（1=正常，0=停用）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_unique` (`company_id`,`sku_code`),
  KEY `idx_select` (`company_id`,`sku_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公司商品关系表';

-- ----------------------------
-- Records of group_company_item_rel
-- ----------------------------

-- ----------------------------
-- Table structure for `group_employee`
-- ----------------------------
DROP TABLE IF EXISTS `group_employee`;
CREATE TABLE `group_employee` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `status` tinyint(3) unsigned NOT NULL COMMENT '状态(0=新建，激活，停用)',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `company_id` bigint(20) unsigned NOT NULL COMMENT '公司id，关联company的id',
  `phone` varchar(30) NOT NULL COMMENT '员工电话',
  `employee_number` varchar(30) NOT NULL COMMENT '员工工号',
  `post_name` varchar(50) NOT NULL COMMENT '岗位',
  `department_name` varchar(50) NOT NULL COMMENT '部门名称',
  `is_del` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除（1=删除，0=未删除）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_unique` (`company_id`,`employee_number`,`phone`),
  KEY `idx_select` (`status`,`name`,`company_id`,`phone`,`employee_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业员工';

-- ----------------------------
-- Records of group_employee
-- ----------------------------

-- ----------------------------
-- Table structure for `group_item`
-- ----------------------------
DROP TABLE IF EXISTS `group_item`;
CREATE TABLE `group_item` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `sku_name` varchar(100) NOT NULL COMMENT '商品名称',
  `price` decimal(20,3) NOT NULL COMMENT '商品单价',
  `picture_path` varchar(300) NOT NULL COMMENT '图片路径',
  `sku_code` varchar(100) NOT NULL COMMENT '商品编码',
  `category_id` bigint(20) unsigned NOT NULL COMMENT '商品类目id',
  `status` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '状态(0=未发布，1=已发布)',
  `is_del` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除（1=删除，0=未删除）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_unique` (`sku_code`,`category_id`),
  KEY `idx_select` (`sku_name`,`sku_code`,`category_id`,`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of group_item
-- ----------------------------

-- ----------------------------
-- Table structure for `group_item_category`
-- ----------------------------
DROP TABLE IF EXISTS `group_item_category`;
CREATE TABLE `group_item_category` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `category_name` varchar(100) NOT NULL COMMENT '类目名称',
  `status` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '状态（1=正常，0=停用）',
  `is_del` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除（1=删除，0=未删除）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_unique` (`id`,`category_name`),
  KEY `idx_select` (`category_name`,`status`,`is_del`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品分类表';

-- ----------------------------
-- Records of group_item_category
-- ----------------------------

-- ----------------------------
-- Table structure for `group_main_order`
-- ----------------------------
DROP TABLE IF EXISTS `group_main_order`;
CREATE TABLE `group_main_order` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `status` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '状态（未取消，已取消）',
  `main_order_code` varchar(100) NOT NULL COMMENT '订单编号',
  `warehouse_code` varchar(100) NOT NULL COMMENT '仓编码，分表字段',
  `company_id` bigint(20) unsigned NOT NULL COMMENT '企业id',
  `employee_id` bigint(20) unsigned NOT NULL COMMENT '企业员工id',
  `meal_type` tinyint(3) unsigned NOT NULL COMMENT '餐次（早、中、晚、夜）',
  `deadline_time` datetime NOT NULL COMMENT '订单截止修改时间',
  `remark` varchar(255) NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_unique` (`warehouse_code`,`main_order_code`),
  KEY `idx_select` (`status`,`main_order_code`,`warehouse_code`,`company_id`,`employee_id`,`meal_type`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='主订单表';

-- ----------------------------
-- Records of group_main_order
-- ----------------------------
INSERT INTO `group_main_order` VALUES ('1', '2017-09-21 18:25:24', '2017-09-21 18:25:30', '0', '1', '1', '1', '1', '1', '2017-09-21 18:25:42', '[{\"id\": 1,\"type\": \"PREPARE_MATERIAL\",\"sort\": 1,\"minute\": 30,\"second\": 15},{\"id\": 2,\"type\": \"SPLIT_MATERIAL\",\"sort\": 2,\"minute\": 30,\"second\": 15},{\"id\": 3,\"type\": \"SIMPLE_PRODUCING\",\"sort\": 3,\"minute\": 30,\"second\": 15}]');

-- ----------------------------
-- Table structure for `group_meal_rule`
-- ----------------------------
DROP TABLE IF EXISTS `group_meal_rule`;
CREATE TABLE `group_meal_rule` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `company_id` bigint(20) unsigned NOT NULL COMMENT '公司表id',
  `week_day` tinyint(3) unsigned NOT NULL COMMENT '周几，1（周一)，7（周日）',
  `meal_type` tinyint(3) unsigned NOT NULL COMMENT '点餐场次，如 10（早餐）',
  `meal_start_time` time NOT NULL COMMENT '点餐开始时间（24小时制）',
  `meal_end_time` time NOT NULL COMMENT '点餐结束时间',
  `status` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '状态（1=正常，0=停用）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_unique` (`company_id`,`meal_type`),
  KEY `idx_select` (`company_id`,`meal_type`,`week_day`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='团餐规则表';

-- ----------------------------
-- Records of group_meal_rule
-- ----------------------------

-- ----------------------------
-- Table structure for `group_role`
-- ----------------------------
DROP TABLE IF EXISTS `group_role`;
CREATE TABLE `group_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `role_name` varchar(60) NOT NULL COMMENT '角色名称',
  `status` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '状态（1=正常，0=停用）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_unique` (`role_name`),
  KEY `idx_select` (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of group_role
-- ----------------------------

-- ----------------------------
-- Table structure for `group_sub_order`
-- ----------------------------
DROP TABLE IF EXISTS `group_sub_order`;
CREATE TABLE `group_sub_order` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `main_order_code` varchar(100) NOT NULL COMMENT '主订单编号',
  `sku_name` varchar(100) NOT NULL COMMENT '商品名称',
  `sku_code` varchar(100) NOT NULL COMMENT '商品code',
  `sale_amount` decimal(20,3) NOT NULL COMMENT '销售数量',
  `sale_unit` varchar(20) NOT NULL COMMENT '销售单位',
  `price` decimal(20,3) NOT NULL COMMENT '销售单价',
  `status` tinyint(3) unsigned NOT NULL COMMENT '状态',
  `warehouse_code` varchar(100) NOT NULL COMMENT '仓code，分表字段',
  `sub_order_code` varchar(100) NOT NULL COMMENT '子订单编号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_unique` (`warehouse_code`,`sub_order_code`),
  KEY `idx_select` (`main_order_code`,`sku_code`,`status`,`warehouse_code`,`sub_order_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单子表';

-- ----------------------------
-- Records of group_sub_order
-- ----------------------------

-- ----------------------------
-- Table structure for `group_user`
-- ----------------------------
DROP TABLE IF EXISTS `group_user`;
CREATE TABLE `group_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `user_nickname` varchar(50) NOT NULL COMMENT '用户昵称',
  `phone` varchar(30) NOT NULL COMMENT '手机',
  `status` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '状态（1=正常，0=停用）',
  `warehouse_code` varchar(100) NOT NULL COMMENT '仓code',
  `password` varchar(100) NOT NULL COMMENT '密码（加密）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_unique` (`user_nickname`,`phone`,`warehouse_code`),
  KEY `idx_select` (`user_nickname`,`phone`,`warehouse_code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='人员表';

-- ----------------------------
-- Records of group_user
-- ----------------------------
INSERT INTO `group_user` VALUES ('1', '2017-09-18 17:55:07', '2017-09-18 17:55:14', 'a', '1235689', '1', '1', '123');

-- ----------------------------
-- Table structure for `group_user_role_rel`
-- ----------------------------
DROP TABLE IF EXISTS `group_user_role_rel`;
CREATE TABLE `group_user_role_rel` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `status` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '状态（1=正常，0=停用）',
  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户id',
  `user_nickname` varchar(50) NOT NULL COMMENT '用户昵称',
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_unique` (`user_id`,`role_id`),
  KEY `idx_select` (`status`,`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色用户关系表';

-- ----------------------------
-- Records of group_user_role_rel
-- ----------------------------

-- ----------------------------
-- Table structure for `sequence`
-- ----------------------------
DROP TABLE IF EXISTS `sequence`;
CREATE TABLE `sequence` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `name` varchar(64) NOT NULL COMMENT 'sequence名字',
  `value` bigint(20) NOT NULL COMMENT 'sequence值',
  `gmt_create` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='sequence';

-- ----------------------------
-- Records of sequence
-- ----------------------------
