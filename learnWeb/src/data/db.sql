/*
Navicat MySQL Data Transfer

Source Server         : dblocal
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : forlearn

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2016-10-25 15:21:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ld_all_in_pay_transaction_detail`
-- ----------------------------
DROP TABLE IF EXISTS `ld_all_in_pay_transaction_detail`;
CREATE TABLE `ld_all_in_pay_transaction_detail` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`uid`  int(10) NULL DEFAULT NULL COMMENT '用户uid' ,
`req_sn`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '交易流水号' ,
`business_code`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务代码' ,
`amount`  decimal(12,4) NULL DEFAULT NULL COMMENT '提交金额' ,
`bank_card_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行卡号' ,
`mobile_phone`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '持卡人手机号码' ,
`real_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '持卡人姓名' ,
`id_type`  int(3) UNSIGNED NULL DEFAULT 0 COMMENT '持卡人证件类型:0：身份证,1: 户口簿，2：护照,3.军官证,4.士兵证，5. 港澳居民来往内地通行证,6. 台湾同胞来往内地通行证,7. 临时身份证,8. 外国人居留证,9. 警官证, X.其他证件' ,
`id_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证件号码' ,
`status`  int(3) NULL DEFAULT NULL COMMENT '状态：0：处理中；1：交易成功；2:交易失败；3:已撤销' ,
`create_time`  datetime NULL DEFAULT NULL COMMENT '提交时间' ,
`update_time`  datetime NULL DEFAULT NULL COMMENT '更新时间' ,
`remark`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
`withdraw_id`  int(10) NULL DEFAULT NULL COMMENT '提现ID' ,
`batch_sn`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '批次号' ,
`type`  int(3) UNSIGNED NULL DEFAULT 1 COMMENT '1 批量代付\r\n2 实时付款\r\n3 绑卡' ,
`finish_time`  datetime NULL DEFAULT NULL COMMENT '完成时间' ,
PRIMARY KEY (`id`),
UNIQUE INDEX `idx_reqbatch_sn` (`req_sn`, `batch_sn`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='通联支付交易日志表'
AUTO_INCREMENT=2550

;

-- ----------------------------
-- Table structure for `ld_all_in_pay_withdraw_log`
-- ----------------------------
DROP TABLE IF EXISTS `ld_all_in_pay_withdraw_log`;
CREATE TABLE `ld_all_in_pay_withdraw_log` (
`id`  int(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
`uid`  int(11) NULL DEFAULT NULL ,
`withdraw_id`  int(11) NULL DEFAULT NULL ,
`batch_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`req_sn`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`system_trace_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`code`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`err_msg`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`money`  decimal(11,2) NULL DEFAULT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1419

;

-- ----------------------------
-- Table structure for `ld_bank_info`
-- ----------------------------
DROP TABLE IF EXISTS `ld_bank_info`;
CREATE TABLE `ld_bank_info` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '1 国有商业银行 2 股份制商业银行 3 邮政储蓄银行 4 城市商业银行' ,
`bank_code`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '银行编码' ,
`bank_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '银行名称' ,
`status`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '0 无效 1 有效' ,
`alias_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '银行别名' ,
`update_time`  datetime NOT NULL ,
`create_time`  datetime NOT NULL ,
`type`  int(4) NOT NULL COMMENT '银行类型' ,
`bank_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '银行行号' ,
`all_in_bank_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通联银行编码' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='银行信息表'
AUTO_INCREMENT=221

;

-- ----------------------------
-- Table structure for `ld_bank_info_remark`
-- ----------------------------
DROP TABLE IF EXISTS `ld_bank_info_remark`;
CREATE TABLE `ld_bank_info_remark` (
`id`  int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '1 国有商业银行 2 股份制商业银行 3 邮政储蓄银行 4 城市商业银行' ,
`bank_code`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '银行编码' ,
`bank_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '银行名称' ,
`status`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '0 无效 1 有效' ,
`alias_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '银行别名' ,
`update_time`  datetime NOT NULL ,
`create_time`  datetime NOT NULL ,
`type`  int(4) NOT NULL COMMENT '银行类型' ,
`bank_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '银行行号' ,
`all_in_bank_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通联银行编码' 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `ld_borrow_investor`
-- ----------------------------
DROP TABLE IF EXISTS `ld_borrow_investor`;
CREATE TABLE `ld_borrow_investor` (
`id`  int(10) NOT NULL AUTO_INCREMENT ,
`from_source`  char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '投资来源 0 网站 1 安卓 2 苹果' ,
`product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`investor_uid`  int(10) NOT NULL ,
`borrow_uid`  int(10) NOT NULL ,
`investor_capital`  decimal(15,2) NOT NULL COMMENT '投资本金' ,
`investor_interest`  decimal(15,2) NOT NULL COMMENT '投资利息' ,
`receive_capital`  decimal(15,2) NULL DEFAULT NULL ,
`receive_interest`  decimal(15,2) NULL DEFAULT NULL ,
`substitute_money`  decimal(15,2) NOT NULL ,
`expired_money`  decimal(15,2) NOT NULL ,
`invest_fee`  decimal(15,2) NOT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
`deadline`  datetime NULL DEFAULT NULL ,
`is_auto`  int(3) NULL DEFAULT 0 COMMENT '是否自动投标' ,
`reward_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '奖励金额' ,
`debt_status`  int(3) NULL DEFAULT 0 COMMENT ' 转让标志：0=未转让，1=转让中，2=已转让' ,
`update_time`  datetime NULL DEFAULT NULL ,
`system_trace_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`status`  int(1) NULL DEFAULT NULL COMMENT '0 投资中 1 还款中 2 还款成功' ,
`assignment_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '分配金额' ,
`debt_uid`  int(10) NULL DEFAULT NULL COMMENT '转让给谁的uid' ,
`reward_id`  int(10) NULL DEFAULT NULL COMMENT '奖励id' ,
`reward_type`  int(4) NULL DEFAULT NULL COMMENT '奖励类型 1 现金红包 2 加息券 3 理财金红包 ' ,
`recast_flag`  int(2) NULL DEFAULT 0 COMMENT '是否复投 0 为不复投 1 为复投' ,
`recast_rate`  float(5,2) NULL DEFAULT NULL COMMENT '复投利率' ,
`recast_dead_date`  date NULL DEFAULT NULL COMMENT '复投结束日期' ,
`product_type`  int(2) NOT NULL COMMENT '产品类型： 1 新手标 2 体验标 3散标 4 季季涨\r\n5 双季涨\r\n6 年年涨\r\n7 天天涨\r\n8 私募基金 9 盈享理财' ,
`debt_price`  decimal(15,2) NULL DEFAULT NULL COMMENT '转让价格' ,
`invest_ip`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资ip' ,
`sales_uid`  int(11) NULL DEFAULT NULL COMMENT '销售工号' ,
`ext_field`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '折让率' ,
PRIMARY KEY (`id`),
INDEX `idx_borrow_investor_investor_uid` (`investor_uid`) USING BTREE ,
INDEX `idx_borrow_investor_sales_uid` (`sales_uid`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1091

;

-- ----------------------------
-- Table structure for `ld_borrow_plan`
-- ----------------------------
DROP TABLE IF EXISTS `ld_borrow_plan`;
CREATE TABLE `ld_borrow_plan` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`repayment_time`  datetime NOT NULL COMMENT '还款时间' ,
`product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`borrow_uid`  int(10) UNSIGNED NOT NULL COMMENT '借款人id' ,
`capital`  decimal(15,2) NULL DEFAULT NULL COMMENT '本金' ,
`interest`  decimal(15,2) NULL DEFAULT NULL COMMENT '利息' ,
`interest_fee`  decimal(15,2) NULL DEFAULT NULL COMMENT '费用' ,
`status`  tinyint(3) UNSIGNED NULL DEFAULT NULL COMMENT '还款状态(1.待还款2.还款成功,3,还款失败' ,
`sort_order`  tinyint(3) UNSIGNED NULL DEFAULT NULL COMMENT '第几期（还款的期数）' ,
`total`  tinyint(3) UNSIGNED NULL DEFAULT NULL COMMENT '总共分多少期还款' ,
`product_type`  int(2) NOT NULL COMMENT '产品类型： 1 新手标 2 体验标 3  散标 4 季季涨\r\n	5 双季涨\r\n	6 年年涨\r\n              7 天天涨\r\n              8 私募\r\n              9 盈享理财\r\n            ' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='借款人还款计划表'
AUTO_INCREMENT=963

;

-- ----------------------------
-- Table structure for `ld_cash_account`
-- ----------------------------
DROP TABLE IF EXISTS `ld_cash_account`;
CREATE TABLE `ld_cash_account` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '现金账户ID(nextval增长)' ,
`uid`  int(10) NULL DEFAULT NULL COMMENT '用户ID' ,
`account_money`  decimal(15,2) NULL DEFAULT 0.00 COMMENT '账户金额=(申购总金额+累计收益)' ,
`cash_freeze`  decimal(15,2) NULL DEFAULT 0.00 COMMENT '冻结金额' ,
`cash_income`  decimal(15,2) NULL DEFAULT 0.00 COMMENT '累计收益' ,
`cash_yester_income`  decimal(15,2) NULL DEFAULT 0.00 COMMENT '昨日收益' ,
`cash_status`  int(1) NULL DEFAULT 0 COMMENT '账户状态' ,
`create_time`  datetime NULL DEFAULT NULL COMMENT '账户首次申购时间' ,
`update_time`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=10

;

-- ----------------------------
-- Table structure for `ld_cash_account_detail`
-- ----------------------------
DROP TABLE IF EXISTS `ld_cash_account_detail`;
CREATE TABLE `ld_cash_account_detail` (
`id`  int(10) NOT NULL AUTO_INCREMENT ,
`cash_id`  int(10) NULL DEFAULT NULL COMMENT '现金账户关联ID' ,
`rate_id`  int(10) NULL DEFAULT NULL COMMENT '收益率ID' ,
`uid`  int(10) NULL DEFAULT NULL ,
`cash_amount`  decimal(15,2) NULL DEFAULT NULL COMMENT '账户金额' ,
`cash_income`  decimal(15,2) NULL DEFAULT NULL COMMENT '收益金额' ,
`cash_time`  datetime NULL DEFAULT NULL COMMENT '收益日' ,
`cash_rate`  float(6,4) NULL DEFAULT NULL COMMENT '每万份收益' ,
`cash_avg_rate`  float(6,4) NULL DEFAULT NULL COMMENT '近七日平均收益率' ,
`cash_type`  int(3) NULL DEFAULT NULL COMMENT '1 申购 2赎回 3收益' ,
`cash_status`  int(1) NULL DEFAULT NULL COMMENT '明细状态' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=638

;

-- ----------------------------
-- Table structure for `ld_cash_log`
-- ----------------------------
DROP TABLE IF EXISTS `ld_cash_log`;
CREATE TABLE `ld_cash_log` (
`id`  int(10) NOT NULL AUTO_INCREMENT ,
`batch_time`  datetime NULL DEFAULT NULL COMMENT '批量日期' ,
`success_count`  int(10) NULL DEFAULT NULL COMMENT '成功笔数' ,
`fail_count`  int(11) NULL DEFAULT NULL COMMENT '失败笔数' ,
`batch_type`  int(1) NULL DEFAULT 0 COMMENT '批量类型(0 收益计算)' ,
`batch_status`  int(1) NULL DEFAULT NULL COMMENT '批量状态(0 全部成功 1全部失败 2部分失败)' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `ld_cash_product`
-- ----------------------------
DROP TABLE IF EXISTS `ld_cash_product`;
CREATE TABLE `ld_cash_product` (
`id`  int(10) NOT NULL AUTO_INCREMENT ,
`money_limit`  decimal(15,2) NULL DEFAULT NULL COMMENT '总金额上限' ,
`collect_status`  int(3) NULL DEFAULT NULL COMMENT '募集状态' ,
`borrow_phone`  varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '借款人手机号' ,
`borrow_uid`  int(10) NULL DEFAULT NULL COMMENT '借款人UID' ,
`password`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品密码' ,
`invest_max`  decimal(15,2) NULL DEFAULT NULL COMMENT '单笔投资上限' ,
`invest_min`  decimal(15,2) NULL DEFAULT NULL COMMENT '单笔起投金额' ,
`increase_progressively`  decimal(15,2) NULL DEFAULT NULL COMMENT '递增金额' ,
`product_contract`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品合同' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=2

;

-- ----------------------------
-- Table structure for `ld_cash_transit`
-- ----------------------------
DROP TABLE IF EXISTS `ld_cash_transit`;
CREATE TABLE `ld_cash_transit` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`uid`  int(10) NOT NULL COMMENT '用户编号' ,
`cash_money`  decimal(15,2) NOT NULL COMMENT '在途金额' ,
`create_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
`update_time`  datetime NULL DEFAULT NULL COMMENT '审核时间' ,
`cash_type`  int(1) NULL DEFAULT NULL COMMENT '操作类型(1 转入 2转出)' ,
`cash_status`  int(1) NULL DEFAULT 0 COMMENT '状态 (0 初审 1通过 2不通过 3过期系统自动退回 4已完成)' ,
`check_uid`  int(10) NULL DEFAULT NULL COMMENT '审核人UID' ,
`special_date`  date NULL DEFAULT NULL COMMENT '收益起始日/赎回到账日' ,
`system_trace_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统跟踪号' ,
`remark`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '说明' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='现金理财在途表'
AUTO_INCREMENT=136

;

-- ----------------------------
-- Table structure for `ld_check_user_name_log`
-- ----------------------------
DROP TABLE IF EXISTS `ld_check_user_name_log`;
CREATE TABLE `ld_check_user_name_log` (
`id`  int(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
`uid`  int(10) NOT NULL COMMENT '用户id' ,
`message_content`  varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '短信内容' ,
`send_date`  datetime(6) NOT NULL COMMENT '发送时间' ,
`send_status`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '1:成功2:失败\r\n' ,
`update_time`  datetime(6) NOT NULL ,
`create_time`  datetime(6) NOT NULL ,
`type`  int(3) NOT NULL COMMENT '1为实名认证' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='实名认证记录表'
AUTO_INCREMENT=118

;

-- ----------------------------
-- Table structure for `ld_ci_product`
-- ----------------------------
DROP TABLE IF EXISTS `ld_ci_product`;
CREATE TABLE `ld_ci_product` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`product_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '借款名称' ,
`borrow_uid`  int(11) NULL DEFAULT NULL COMMENT '借款人id' ,
`borrow_month_duration`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款期' ,
`borrow_day_duration`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款期' ,
`borrow_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '借款金额' ,
`borrow_interest`  decimal(15,2) NULL DEFAULT NULL COMMENT '利息' ,
`borrow_interest_rate`  float(6,4) NULL DEFAULT NULL COMMENT '借款利率（年化）' ,
`borrow_fee`  decimal(15,2) NULL DEFAULT NULL COMMENT '借款费' ,
`repayment_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '偿还本金' ,
`repayment_interest`  decimal(15,2) NULL DEFAULT NULL COMMENT '偿还利息' ,
`expired_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '逾期还款金额' ,
`repayment_type`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '还款类型\r\n (1、每月还利息、到期还本息\r\n  2、到期本息一次性返还\r\n 3、等额本息)' ,
`borrow_type`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款类型' ,
`borrow_procedures_rate`  float(6,4) NULL DEFAULT NULL COMMENT '手续费率' ,
`borrow_status`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款状态 (0 新增 1 初审核 2复审 3 投资中 4 满标 5 流标 6 还款中 7 停止发布 8 完成 9 逾期)' ,
`contractID`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合同编号' ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
`collect_start_time`  datetime NULL DEFAULT NULL COMMENT '筹集开始时间' ,
`full_time`  datetime NULL DEFAULT NULL COMMENT '满标时间' ,
`deadline`  datetime NULL DEFAULT NULL COMMENT '结束时间' ,
`check_time`  datetime NULL DEFAULT NULL COMMENT '审核时间' ,
`contract_template`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合同模板' ,
`check_user`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '初审后台用户' ,
`check_user2`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '复审后台用户' ,
`check_time2`  datetime NULL DEFAULT NULL COMMENT '复审核时间' ,
`invest_fee`  decimal(15,2) NULL DEFAULT NULL ,
`invest_rate`  float(5,2) NULL DEFAULT NULL ,
`collect_end_time`  datetime NULL DEFAULT NULL ,
`borrow_days`  int(4) UNSIGNED NULL DEFAULT NULL COMMENT '借款天数' ,
`borrow_id`  int(11) NULL DEFAULT NULL COMMENT '借款编号' ,
`product_sort`  int(3) NULL DEFAULT 0 COMMENT '产品排序id 从大到小' ,
PRIMARY KEY (`id`),
UNIQUE INDEX `idx_ci_product_id` (`product_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='涨中宝产品表'
AUTO_INCREMENT=54

;

-- ----------------------------
-- Table structure for `ld_ci_product_detail`
-- ----------------------------
DROP TABLE IF EXISTS `ld_ci_product_detail`;
CREATE TABLE `ld_ci_product_detail` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '借款人id' ,
`borrow_type`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款用途' ,
`datetime`  datetime NULL DEFAULT NULL ,
`add_ip`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`borrow_info`  varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '借款备注' ,
`total`  int(4) NULL DEFAULT NULL COMMENT '排名(数字大排在前)' ,
`has_pay`  int(4) NULL DEFAULT NULL ,
`substitute_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '部分金额' ,
`reward_vouch_rate`  float(5,2) NULL DEFAULT NULL COMMENT '活动奖励担保汇率' ,
`reward_vouch_money`  decimal(15,2) UNSIGNED NULL DEFAULT NULL COMMENT '奖励担保金额' ,
`reward_type`  int(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '奖励类型 0 没有，1红包，2体验金 3积分' ,
`reward_min`  decimal(10,2) UNSIGNED NULL DEFAULT NULL COMMENT '奖励需投资最低金额' ,
`reward_value`  float UNSIGNED NOT NULL COMMENT '奖励值' ,
`invest_min`  decimal(15,2) UNSIGNED NOT NULL COMMENT '最小投资' ,
`invest_max`  decimal(15,2) UNSIGNED NOT NULL COMMENT '最大投资' ,
`vouch_member`  int(10) NULL DEFAULT NULL COMMENT '提保会员' ,
`password`  char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '明码' ,
`is_recommend`  int(2) UNSIGNED NOT NULL COMMENT '是否推荐0：不推荐；1：推荐' ,
`can_auto`  int(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '是否自动投标 0 否 1是' ,
`information_disclosure`  varchar(3000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '信息披露' ,
`vouch_uid`  int(10) NULL DEFAULT NULL COMMENT '担保公司id' ,
`vouch_money`  decimal(15,2) NOT NULL COMMENT '担保金额' ,
`auto_max_limit`  decimal(15,2) NOT NULL DEFAULT 0.00 COMMENT '自动投标最大金额，默认为0，即无限制' ,
`risk_control`  varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '风控描述' ,
`update_time`  datetime NULL DEFAULT NULL ,
`expired_rate`  float(6,4) NULL DEFAULT NULL COMMENT '罚息利率(按日配置）' ,
`reward_total_score`  int(10) NULL DEFAULT NULL ,
`reward_experience_gold`  decimal(15,2) NULL DEFAULT NULL COMMENT '奖励体验金' ,
`reward_way`  int(3) NULL DEFAULT NULL COMMENT '奖励方式1按比例 2按数值累计返 3按数值一次返' ,
`can_bonus`  int(3) NULL DEFAULT NULL COMMENT '1为可用红包' ,
`can_add_interest`  int(3) NULL DEFAULT NULL COMMENT ' 加息券' ,
`recast_flag`  int(2) NULL DEFAULT 0 COMMENT '是否复投 0 为不复投 1为复投' ,
`recast_rate`  float(6,4) NULL DEFAULT NULL COMMENT '复投利率' ,
`product_type`  int(2) NOT NULL COMMENT '1为季季涨，2为双季涨 3 年年涨,4:天天涨' ,
`safeguard_mode`  int(2) UNSIGNED NULL DEFAULT NULL COMMENT '保障方式 1本息保障 2本金保障 3 收益保障' ,
`invest_target`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资目标说明' ,
`invest_dead_date`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资到期日期说明' ,
`safeguard_level`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '保障级别' ,
`interest_distribution`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '利息分配' ,
`exit_mechanism`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退出机制' ,
`fee_info`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '费用说明' ,
`contract_type`  int(3) NULL DEFAULT NULL COMMENT '产权类型： 0：线上债权转让合同 1：金融产品收益权转让协议 ' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='涨中宝产品详情表'
AUTO_INCREMENT=37

;

-- ----------------------------
-- Table structure for `ld_ci_si_product`
-- ----------------------------
DROP TABLE IF EXISTS `ld_ci_si_product`;
CREATE TABLE `ld_ci_si_product` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`ci_product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '涨中宝产品id' ,
`si_product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '散标产品id' ,
`type`  int(3) UNSIGNED NOT NULL COMMENT '1第一次绑定，2第一次复投绑定' ,
`create_time`  datetime NOT NULL ,
`update_time`  datetime NOT NULL ,
`check_user`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成后台用户' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='涨中宝、散标关系表'
AUTO_INCREMENT=49

;

-- ----------------------------
-- Table structure for `ld_experience_product`
-- ----------------------------
DROP TABLE IF EXISTS `ld_experience_product`;
CREATE TABLE `ld_experience_product` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`product_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '借款名称' ,
`borrow_uid`  int(11) NULL DEFAULT NULL COMMENT '借款人id' ,
`borrow_month_duration`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款期' ,
`borrow_day_duration`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款期' ,
`borrow_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '借款金额' ,
`borrow_interest`  decimal(15,2) NULL DEFAULT NULL COMMENT '利息' ,
`borrow_interest_rate`  float(6,4) NULL DEFAULT NULL COMMENT '借款利率（年化）' ,
`borrow_fee`  decimal(15,2) NULL DEFAULT NULL COMMENT '借款费' ,
`repayment_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '偿还本金' ,
`repayment_interest`  decimal(15,2) NULL DEFAULT NULL COMMENT '偿还利息' ,
`expired_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '逾期还款金额' ,
`repayment_type`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '还款类型\r\n            (1、每月还利息、到期还本息\r\n              2、到期本息一次性返还\r\n              3、等额本息)\r\n              4、到期付息' ,
`borrow_type`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款类型' ,
`borrow_procedures_rate`  float(6,4) NULL DEFAULT NULL COMMENT '手续费率' ,
`borrow_status`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款状态 3:开放投资，9::关闭投资 10:自动开放/关闭投资' ,
`contractID`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合同编号' ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
`collect_start_time`  datetime NULL DEFAULT NULL COMMENT '筹集开始时间' ,
`full_time`  datetime NULL DEFAULT NULL COMMENT '满标时间' ,
`deadline`  datetime NULL DEFAULT NULL COMMENT '结束时间' ,
`check_time`  datetime NULL DEFAULT NULL COMMENT '审核时间' ,
`contract_template`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合同模板' ,
`check_user`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '初审后台用户' ,
`check_user2`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '复审后台用户' ,
`check_time2`  datetime NULL DEFAULT NULL COMMENT '复审核时间' ,
`invest_fee`  decimal(15,2) NULL DEFAULT NULL ,
`invest_rate`  float NULL DEFAULT NULL ,
`collect_end_time`  datetime NULL DEFAULT NULL ,
`borrow_days`  int(4) UNSIGNED NULL DEFAULT NULL COMMENT '借款天数' ,
`borrow_id`  int(11) NULL DEFAULT NULL COMMENT '借款编号' ,
PRIMARY KEY (`id`),
UNIQUE INDEX `idx_ex_product_id` (`product_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='体验投资产品表'
AUTO_INCREMENT=7

;

-- ----------------------------
-- Table structure for `ld_experience_product_detail`
-- ----------------------------
DROP TABLE IF EXISTS `ld_experience_product_detail`;
CREATE TABLE `ld_experience_product_detail` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '借款人id' ,
`borrow_type`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款用途' ,
`datetime`  datetime NULL DEFAULT NULL ,
`add_ip`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`borrow_info`  varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '借款备注' ,
`total`  int(4) NULL DEFAULT NULL COMMENT '排名(数字大排在前)' ,
`has_pay`  int(4) NULL DEFAULT NULL ,
`substitute_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '部分金额' ,
`reward_vouch_rate`  float(5,2) NULL DEFAULT NULL COMMENT '活动奖励担保汇率' ,
`reward_vouch_money`  decimal(15,2) UNSIGNED NULL DEFAULT NULL COMMENT '奖励担保金额' ,
`reward_type`  int(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '奖励类型 0 没有，1红包，2体验金 3积分' ,
`reward_min`  decimal(10,2) UNSIGNED NULL DEFAULT NULL COMMENT '奖励需投资最低金额' ,
`reward_value`  float UNSIGNED NOT NULL COMMENT '奖励值' ,
`invest_min`  decimal(15,2) UNSIGNED NOT NULL COMMENT '最小投资' ,
`invest_max`  decimal(15,2) UNSIGNED NOT NULL COMMENT '最大投资' ,
`vouch_member`  int(10) NULL DEFAULT NULL COMMENT '提保会员' ,
`password`  char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '明码' ,
`is_recommend`  int(2) UNSIGNED NOT NULL COMMENT '是否推荐0：不推荐；1：推荐' ,
`can_auto`  int(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '是否自动投标 0 否 1是' ,
`information_disclosure`  varchar(3000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '信息披露' ,
`vouch_uid`  int(10) NULL DEFAULT NULL COMMENT '担保公司id' ,
`vouch_money`  decimal(15,2) NOT NULL COMMENT '担保金额' ,
`auto_max_limit`  decimal(15,2) NOT NULL DEFAULT 0.00 COMMENT '自动投标最大金额，默认为0，即无限制' ,
`risk_control`  varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '风控描述' ,
`update_time`  datetime NULL DEFAULT NULL ,
`expired_rate`  float(6,4) NULL DEFAULT NULL COMMENT '罚息利率(按日配置）' ,
`reward_total_score`  int(10) NULL DEFAULT NULL ,
`reward_experience_gold`  decimal(15,0) NULL DEFAULT NULL COMMENT '奖励体验金' ,
`reward_way`  int(3) NULL DEFAULT NULL COMMENT '奖励方式1按比例 2按数值累计返 3按数值一次返' ,
`progressive_investment`  decimal(15,2) NULL DEFAULT NULL COMMENT '递进投资额度' ,
`oper_type`  int(3) NULL DEFAULT NULL COMMENT '操作类型' ,
`invest_total`  decimal(15,2) NULL DEFAULT NULL COMMENT '每周累积投资总金额上限' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='体验投资产品详情表'
AUTO_INCREMENT=10

;

-- ----------------------------
-- Table structure for `ld_image_config`
-- ----------------------------
DROP TABLE IF EXISTS `ld_image_config`;
CREATE TABLE `ld_image_config` (
`id`  int(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
`type`  int(3) UNSIGNED NOT NULL COMMENT '类型，1为网站 2为app' ,
`url`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '图片路径和名称' ,
`memo`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
`create_time`  datetime NOT NULL ,
`image_index`  int(3) NOT NULL DEFAULT 0 COMMENT '排序' ,
`expire_time`  datetime NULL DEFAULT NULL COMMENT '过期时间' ,
`in_operation_time`  datetime NULL DEFAULT NULL COMMENT '生效时间' ,
`image_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片名称' ,
`status`  int(1) NULL DEFAULT 0 COMMENT '上架状态(0：上架 1：下架)' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='图片配置记录表'
AUTO_INCREMENT=81

;

-- ----------------------------
-- Table structure for `ld_income_rate`
-- ----------------------------
DROP TABLE IF EXISTS `ld_income_rate`;
CREATE TABLE `ld_income_rate` (
`id`  int(10) NOT NULL AUTO_INCREMENT ,
`income_rate`  float(6,4) NULL DEFAULT NULL COMMENT '每万份收益' ,
`avg_income_rate`  float(6,4) NULL DEFAULT NULL COMMENT '近七日平均收益率' ,
`rate_time`  datetime NULL DEFAULT NULL COMMENT '收益率创建时间' ,
`update_time`  datetime NULL DEFAULT NULL COMMENT '更新时间' ,
`rate_type`  int(1) NULL DEFAULT 0 COMMENT '收益类型(0现金理财)' ,
`sub_uid`  int(10) NULL DEFAULT NULL COMMENT '提交人UID' ,
`check_uid`  int(10) NULL DEFAULT NULL COMMENT '审核人UID' ,
`rate_date`  date NULL DEFAULT NULL COMMENT '所属计息日' ,
`rate_status`  int(1) NULL DEFAULT NULL COMMENT '收益状态(0 初审 1通过 2不通过)' ,
`ext_field`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用' ,
`ext_field2`  int(11) NULL DEFAULT NULL COMMENT '备用1' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=42

;

-- ----------------------------
-- Table structure for `ld_lucky_draw`
-- ----------------------------
DROP TABLE IF EXISTS `ld_lucky_draw`;
CREATE TABLE `ld_lucky_draw` (
`id`  int(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
`uid`  int(11) NOT NULL COMMENT '用户uid' ,
`award_type`  int(3) NOT NULL COMMENT '奖品类型:1:\"再抽一次\",2:\"精美小礼品\",3:\"0.5%加息卷\",4:\"投资红包10\",5:\"投资红包20\",6:\"投资体验金1000\",7:\"投资体验金5000\",8:\"现金5\",9:\"iphone6s\",10:\"奔驰GLK\"' ,
`award_time`  datetime NOT NULL COMMENT '抽奖时间' ,
`user_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`consume_core`  int(11) NOT NULL COMMENT '消费积分' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户抽奖记录'
AUTO_INCREMENT=622

;

-- ----------------------------
-- Table structure for `ld_mc_refund_detail`
-- ----------------------------
DROP TABLE IF EXISTS `ld_mc_refund_detail`;
CREATE TABLE `ld_mc_refund_detail` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`mer_order_id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商户订单号' ,
`ori_ref_no`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原消费交易系统参考号	oriRefNo	非必输	原消费交易系统参考号与原消费交易商户订单号必须填写一个' ,
`ori_merorder_id`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原消费交易商户订单号	oriMerOrderId	非必输	原消费交易系统参考号与原消费交易商户订单号必须填写一个' ,
`ori_trans_date`  datetime NOT NULL COMMENT '原交易日期	oriTransDate	必输	原消费交易商户端日期YYYYMMDDHHMMSS' ,
`amount`  decimal(15,2) NOT NULL COMMENT '金额' ,
`backUrl`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '回调地址	backUrl	可选	快捷支付平台主动通知' ,
`msg_ext`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附加信息' ,
`create_time`  datetime NOT NULL ,
`refund_status`  int(1) UNSIGNED NOT NULL COMMENT '退款状态 0：退款中 1退款成功 2退款失败' ,
`cust_id`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'uid' ,
PRIMARY KEY (`id`),
INDEX `idx_mer_order_id` (`mer_order_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='民生支付快捷支付退款日志表'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `ld_mc_transaction_detail`
-- ----------------------------
DROP TABLE IF EXISTS `ld_mc_transaction_detail`;
CREATE TABLE `ld_mc_transaction_detail` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`mer_order_id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商户订单号' ,
`subject`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品种类' ,
`bank_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付银行号' ,
`card_no`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卡号' ,
`expired_date`  datetime NULL DEFAULT NULL COMMENT '卡有效期' ,
`cvv2`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卡校验码' ,
`amount`  decimal(15,2) NOT NULL COMMENT '金额' ,
`cust_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '持卡人姓名' ,
`cust_id_no`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '持卡人证件号' ,
`cust_id_type`  int(3) UNSIGNED NULL DEFAULT 0 COMMENT '持卡人证件类型' ,
`save_cust_flag`  int(2) UNSIGNED NULL DEFAULT 1 COMMENT '是否保存客户信息 0-不保存（默认）1-保存' ,
`cust_id`  int(10) UNSIGNED NOT NULL COMMENT '客户号' ,
`phone_no`  varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号' ,
`phone_vercode`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机验证码' ,
`phoneToken`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机校验码令牌' ,
`storable_card_no`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '短卡号' ,
`backUrl`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '回调地址' ,
`msg_ext`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附加信息' ,
`create_time`  datetime NOT NULL ,
`status`  int(1) NULL DEFAULT NULL COMMENT '1充值中 2充值成功 3充值失败' ,
PRIMARY KEY (`id`),
UNIQUE INDEX `idx_mer_order_id` (`mer_order_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='民生支付快捷支付交易日志表'
AUTO_INCREMENT=151

;

-- ----------------------------
-- Table structure for `ld_member_bank_card_info`
-- ----------------------------
DROP TABLE IF EXISTS `ld_member_bank_card_info`;
CREATE TABLE `ld_member_bank_card_info` (
`id`  int(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
`uid`  int(10) UNSIGNED NOT NULL ,
`address`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`province`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`city`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`area`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
`bank_card_no`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
`card_bank`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`card_branch_bank`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`memo`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`status`  int(3) NULL DEFAULT 1 COMMENT '状态：1为有效，0为无效' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=210

;

-- ----------------------------
-- Table structure for `ld_member_borrow`
-- ----------------------------
DROP TABLE IF EXISTS `ld_member_borrow`;
CREATE TABLE `ld_member_borrow` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`uid`  int(10) UNSIGNED NULL DEFAULT NULL ,
`telphone_number`  varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`is_vouch`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '是否担保0 未担保 1 有担保' ,
`memo`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
`borrow_duration`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款期限： 1个月 3个月 6个月 9个月 12个月 24个月' ,
`borrow_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '借款金额' ,
`borrow_title`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_time`  datetime NOT NULL ,
`province`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`city`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`borrow_status`  int(3) UNSIGNED NOT NULL COMMENT '借款状态 0 申请中 1 办理中 2 失败 3 成功' ,
`real_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `ld_member_certificate_check`
-- ----------------------------
DROP TABLE IF EXISTS `ld_member_certificate_check`;
CREATE TABLE `ld_member_certificate_check` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`uid`  int(10) NULL DEFAULT NULL ,
`check_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`check_card`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
`status`  int(3) NULL DEFAULT NULL COMMENT '100:待审核,101:通过，102:不通过；' ,
`front_image`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '正面图片' ,
`back_image`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '反面图片' ,
`card_type`  int(3) NULL DEFAULT NULL COMMENT '证件类型：2:港澳，3:台湾' ,
`reason`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=22

;

-- ----------------------------
-- Table structure for `ld_member_contact_info`
-- ----------------------------
DROP TABLE IF EXISTS `ld_member_contact_info`;
CREATE TABLE `ld_member_contact_info` (
`uid`  int(10) UNSIGNED NOT NULL ,
`address`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '现居住地址' ,
`tel`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '住宅电话' ,
`contact1`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '第一联系人' ,
`contact1_re`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '关系： 1 家庭成员 2 朋友 3 商业伙伴 ' ,
`contact1_tel`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系人手机号码' ,
`memo`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
`create_time`  datetime NOT NULL ,
`update_time`  datetime NOT NULL ,
PRIMARY KEY (`uid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='会员联系表'

;

-- ----------------------------
-- Table structure for `ld_member_data_info`
-- ----------------------------
DROP TABLE IF EXISTS `ld_member_data_info`;
CREATE TABLE `ld_member_data_info` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`uid`  int(10) UNSIGNED NOT NULL ,
`data_url`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`type`  smallint(5) NOT NULL ,
`status`  tinyint(3) NOT NULL ,
`add_time`  datetime NOT NULL ,
`data_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`size`  int(10) NOT NULL ,
`ext`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`deal_info`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`deal_credits`  smallint(5) NOT NULL ,
`deal_user`  int(11) NOT NULL ,
`deal_time`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`),
INDEX `inx_uid2` (`uid`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='会员上传附件信息表'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `ld_member_experience_gold_detail`
-- ----------------------------
DROP TABLE IF EXISTS `ld_member_experience_gold_detail`;
CREATE TABLE `ld_member_experience_gold_detail` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`uid`  int(10) UNSIGNED NOT NULL ,
`type`  int(3) UNSIGNED NOT NULL COMMENT '类型：1.增加 2,减少' ,
`affect_experience_gold`  int(11) NOT NULL ,
`total_experience_gold`  int(11) NOT NULL COMMENT '总体验金' ,
`info`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注' ,
`create_time`  datetime NOT NULL ,
`add_ip`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人员的外网IP地址' ,
`system_trace_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`operate_mode`  int(3) NOT NULL COMMENT ' 操作类型:1, \"用户注册奖励\",2, \"推荐好友注册奖励\",3, \"实名认证奖励\",4, \"推荐好友实名认证奖励\",5, \"银行卡绑定奖励\",6, \"推荐好友银行卡绑定奖励\",7, \"邮件绑定奖励\",8, \"用户购买标的推荐人奖励\",9, \"用户充值奖励\",10, \"散标购买奖励\",11, \"涨中宝购买奖励\",12, \"新手标购买奖励\",13, \"体验标购买奖励\"\r\n,14, \"兑换投资红包\",15,\"兑换体验金\",16,\"签到\",17,\"抽奖\",18,\"被推荐注册奖励\"' ,
PRIMARY KEY (`id`),
INDEX `idx_experience_gold_detail_uid` (`uid`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户体验金详情表'
AUTO_INCREMENT=502

;

-- ----------------------------
-- Table structure for `ld_member_financial_info`
-- ----------------------------
DROP TABLE IF EXISTS `ld_member_financial_info`;
CREATE TABLE `ld_member_financial_info` (
`uid`  int(10) UNSIGNED NOT NULL ,
`fin_monthin`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '月均收入' ,
`fin_incomedes`  varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '月均收入描述' ,
`fin_monthout`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '月均支出' ,
`fin_outdes`  varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '月均支出描述' ,
`work_years`  int(10) NOT NULL COMMENT '工作年限' ,
`fin_house`  char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '房产价值:0无房产，1 有商品房 2有其他（非商品房） 3 无房 ' ,
`fin_car`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否有车，0无，1有' ,
`fin_carvalue`  int(10) NOT NULL COMMENT '车价值' ,
`fin_stockcompany`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参股企业名称' ,
`fin_stockcompanyvalue`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参股企业出资额' ,
`fin_otheremark`  varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '其他说明' ,
PRIMARY KEY (`uid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户财务信息表'

;

-- ----------------------------
-- Table structure for `ld_member_first_award`
-- ----------------------------
DROP TABLE IF EXISTS `ld_member_first_award`;
CREATE TABLE `ld_member_first_award` (
`id`  int(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
`uid`  int(11) NOT NULL ,
`operate_mode`  int(5) NOT NULL ,
`award_type`  int(3) NOT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `ld_member_house_info`
-- ----------------------------
DROP TABLE IF EXISTS `ld_member_house_info`;
CREATE TABLE `ld_member_house_info` (
`uid`  int(10) UNSIGNED NOT NULL ,
`house_address`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`house_size`  float(10,2) NOT NULL ,
`house_picture_url`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`house_price`  decimal(15,2) NOT NULL ,
`house_filed1`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`house_filed2`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`house_loan`  int(11) NOT NULL ,
`house_year`  int(10) NOT NULL COMMENT '建筑年份' ,
`house_loan_status`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供款状态：0，按揭中，1，已供完房款' ,
`house_loan_balance`  decimal(15,2) NOT NULL COMMENT '欠款余额' ,
`house_monthly_payment`  decimal(15,2) NOT NULL ,
`house_loan_bank`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`create_time`  datetime NOT NULL ,
`update_time`  datetime NOT NULL ,
PRIMARY KEY (`uid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `ld_member_info`
-- ----------------------------
DROP TABLE IF EXISTS `ld_member_info`;
CREATE TABLE `ld_member_info` (
`uid`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`sex`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`zy`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`info`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`marry`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`education`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' ,
`income`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`age`  int(11) NULL DEFAULT NULL ,
`idcard`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`card_img_background`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证背面图片url' ,
`card_img_front`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证前面图片url' ,
`real_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`address`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`province`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`city`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`area`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
`bank_card_no`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
`card_bank`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`card_branch_bank`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`can_auto`  int(1) NULL DEFAULT NULL COMMENT '是否自动投标 0 否 1是' ,
`qq`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'qq号' ,
`headshot_url`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT ' 个人头像url' ,
`two_dimension_code_url`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '二维码url' ,
`first_add_card`  int(3) NULL DEFAULT 0 COMMENT '是否第一次绑定银行卡，0未绑定过，1绑定过一次或多次' ,
`third_user_id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '第三方支付userid' ,
`sales_uid`  int(11) UNSIGNED NULL DEFAULT NULL COMMENT '销售工号' ,
`ext_field`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否有修改用户名：null无，1有' ,
`ext_field2`  int(11) NULL DEFAULT NULL COMMENT '证件类型：1:大陆，2:港澳，3:台湾' ,
`first_buy`  int(1) NULL DEFAULT NULL COMMENT '第一次购买：0:是，1:否；' ,
`reward_type_ids`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '奖品码类型id' ,
PRIMARY KEY (`uid`),
INDEX `idx_member_info_real_name` (`real_name`) USING BTREE ,
INDEX `idx_member_info_uid` (`uid`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1000000275

;

-- ----------------------------
-- Table structure for `ld_member_login`
-- ----------------------------
DROP TABLE IF EXISTS `ld_member_login`;
CREATE TABLE `ld_member_login` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`uid`  int(10) UNSIGNED NOT NULL ,
`ip`  varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`create_time`  datetime NOT NULL ,
`type`  int(4) NOT NULL COMMENT '登录类型：1.前台用户，2.后台用户' ,
PRIMARY KEY (`id`),
INDEX `idx_member_uid` (`uid`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=7543

;

-- ----------------------------
-- Table structure for `ld_member_money`
-- ----------------------------
DROP TABLE IF EXISTS `ld_member_money`;
CREATE TABLE `ld_member_money` (
`uid`  int(10) UNSIGNED NOT NULL ,
`money_freeze`  decimal(15,2) NOT NULL COMMENT '冻结金额' ,
`money_collect`  decimal(15,2) NULL DEFAULT NULL COMMENT '待收金额' ,
`account_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '充值资金存放池_账户余额' ,
`back_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '回款资金存放池_可用余额' ,
`credit_limit`  decimal(15,2) NULL DEFAULT NULL ,
`credit_cuse`  decimal(15,2) NULL DEFAULT NULL ,
`borrow_vouch_limit`  decimal(15,2) NULL DEFAULT NULL ,
`borrow_vouch_cuse`  decimal(15,2) NULL DEFAULT NULL ,
`invest_vouch_limit`  decimal(15,2) NULL DEFAULT NULL ,
`invest_vouch_cuse`  decimal(15,2) NULL DEFAULT NULL ,
`total_score`  int(15) NULL DEFAULT NULL COMMENT '积分' ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
`experience_gold`  decimal(15,2) NOT NULL COMMENT '体验金' ,
`income_money`  decimal(15,2) NOT NULL DEFAULT 0.00 COMMENT '总收益金额' ,
`free_withdraw`  decimal(15,2) NOT NULL DEFAULT 0.00 COMMENT '可免费提现金额' ,
`version`  int(11) NOT NULL DEFAULT 0 COMMENT '版本号' ,
PRIMARY KEY (`uid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `ld_member_money_detail`
-- ----------------------------
DROP TABLE IF EXISTS `ld_member_money_detail`;
CREATE TABLE `ld_member_money_detail` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`uid`  int(10) UNSIGNED NOT NULL ,
`type`  int(3) UNSIGNED NOT NULL COMMENT 'FREEZE(\"1\", \"冻结\"),\r\n	UNFREEZE(\"2\", \"解冻\"),\r\n	RECHARGE(\"3\", \"充值\"),\r\n	WITHDRAW(\"4\", \"提现\"),\r\n	INVEST(\"5\",\"投标\"),\r\n	RECEIVEMONEY(\"6\",\"收到还款本金\"),\r\n	DEBTASSIGNMENT(\"7\",\"债权转让\"),\r\n	BUYDEBT(\"8\",\"购买债权\"),\r\n	INTERESTMANAGEMENTFEE(\"9\",\"利息管理费\"),\r\n	BORROW(\"10\",\"借款\"),\r\n	REPAYBORROW(\"11\",\"归还借款\"),\r\n	ENCOURAGE(\"12\",\"奖励\"),\r\n	SERVICECHARGE(\"13\",\"收到手续费\"),\r\n	SERVICEINTEREST(\"14\",\"收到还款利息\"),\r\n	SERVICEADMIN(\"15\",\"平台管理费\"),\r\n	PRODUCTEXPERIENCE(\"16\",\"体验标\"),\r\n	PRODUCTNEWHAND(\"17\",\"新手标投资\"),\r\n	PRODUCTSI(\"18\",\"专享理财投资\"),\r\n	PRODUCTJJ(\"19\",\"涨中宝季季涨投资\"),\r\n	PRODUCTDJ(\"20\",\"涨中宝双季涨投资\"),\r\n	PRODUCTYY(\"21\",\"涨中宝年年涨投资\"),\r\n	COMPOUNDINTEREST(\"22\",\"涨中宝复投利息\"),\r\n	PAYREFUND(\"23\",\"充值退款\"),\r\n	NEWHANDCOLLECTCAPITAL(\"24\",\"新手标应收本金\"),\r\n	NEWHANDCOLLECTINTEREST(\"25\",\"新手标应收利息\"),\r\n	REPAYINTEREST(\"26\",\"归还利息\"),\r\n	EXPERIENCEINTEREST(\"27\",\"收到体验标还款利息\"),\r\n	CIPRODUCTCOLLECTINTEREST(\"28\",\"涨中宝应收利息\"),\r\n	SIPRODUCTCOLLECTINTEREST(\"29\",\"专享理财应收利息\"),\r\n	PEPRODUCTCOLLECTINTEREST(\"291\",\"私募应收利息\"),\r\n	YINGXIANGCOLLECTINTEREST(\"292\",\"盈享理财应收利息\"),\r\n	HIKE(\"30\",\"加息券\"),\r\n	RED(\"31\",\"红包\"),\r\n	RECEIVEINT' ,
`affect_money`  decimal(15,2) NOT NULL COMMENT '影响金额' ,
`account_money`  decimal(15,2) NOT NULL COMMENT '充值资金存放池_可用余额' ,
`back_money`  decimal(15,2) NOT NULL COMMENT '回款资金存放池_可用余额' ,
`collect_money`  decimal(15,2) NOT NULL COMMENT '待收金额' ,
`freeze_money`  decimal(15,2) NOT NULL COMMENT '冻结金额' ,
`info`  varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`create_time`  datetime NOT NULL ,
`add_ip`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人员的外网IP地址' ,
`target_uid`  int(11) NULL DEFAULT 0 COMMENT '前台=menbers的UID  后台=t_user的UID' ,
`target_uname`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前台=menbers的name  后台=t_user的name' ,
`update_time`  datetime NULL DEFAULT NULL ,
`system_trace_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`income_money`  decimal(15,2) NOT NULL COMMENT '收入金额' ,
PRIMARY KEY (`id`),
INDEX `idx_detail_uid` (`uid`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=4461

;

-- ----------------------------
-- Table structure for `ld_member_pay`
-- ----------------------------
DROP TABLE IF EXISTS `ld_member_pay`;
CREATE TABLE `ld_member_pay` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`uid`  int(10) UNSIGNED NOT NULL ,
`system_trace_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`recharge_money`  decimal(15,2) NOT NULL ,
`recharge_fee`  decimal(15,2) NOT NULL ,
`way`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '1:民生支付-网关支付,2:民生支付-快捷支付,3:线下支付 4 \":通联支付-网关支付,5：通联支付-快捷支付' ,
`status`  int(3) NOT NULL DEFAULT 0 COMMENT '1充值中 2充值成功 3充值失败' ,
`create_time`  datetime NOT NULL ,
`recharge_ip`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`bank_card`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '打款账号' ,
`off_bank`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`off_branch_bank`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`off_user`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`deal_uid`  int(11) NULL DEFAULT NULL ,
`pay_img_url`  varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上传打款凭证' ,
`update_time`  datetime NOT NULL ,
`check_memo`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`third_system_trace_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`type`  int(2) NOT NULL COMMENT '充值方式 1为线上充值 2为线下充值' ,
`bank_sign`  varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '第三方支付返回报文' ,
PRIMARY KEY (`id`),
UNIQUE INDEX `idx_pay_system_trace_no` (`system_trace_no`) USING BTREE ,
INDEX `idx_pay_uid` (`uid`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户充值表'
AUTO_INCREMENT=504

;

-- ----------------------------
-- Table structure for `ld_member_pid_info`
-- ----------------------------
DROP TABLE IF EXISTS `ld_member_pid_info`;
CREATE TABLE `ld_member_pid_info` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`uid`  int(11) NULL DEFAULT NULL ,
`pid`  varchar(8000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户pid记录表'
AUTO_INCREMENT=4

;

-- ----------------------------
-- Table structure for `ld_member_questionnaire`
-- ----------------------------
DROP TABLE IF EXISTS `ld_member_questionnaire`;
CREATE TABLE `ld_member_questionnaire` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`uid`  int(10) UNSIGNED NOT NULL ,
`total_core`  int(10) UNSIGNED NOT NULL COMMENT '得分' ,
`financial_situation`  int(3) NOT NULL COMMENT ' 财务条件' ,
`age_range`  int(3) UNSIGNED NOT NULL COMMENT '年龄范围' ,
`education`  int(3) NOT NULL COMMENT '学历' ,
`job`  int(3) NOT NULL COMMENT '职业' ,
`disposable_income`  int(3) NOT NULL COMMENT '可支配年收入' ,
`investment_proportion`  int(3) UNSIGNED NOT NULL COMMENT '大概有多少可以用于投资比例' ,
`investment_knowledge`  int(3) NOT NULL COMMENT '投资知识' ,
`investment_experience`  int(3) UNSIGNED NOT NULL COMMENT '投资经验' ,
`investment_life`  int(3) UNSIGNED NOT NULL COMMENT '投资的年限' ,
`investment_cycle`  int(3) NOT NULL COMMENT '投资期限' ,
`investment_objective`  int(3) UNSIGNED NOT NULL COMMENT '投资目标' ,
`primary_objective`  int(3) UNSIGNED NOT NULL COMMENT '首要目标' ,
`investment_attitude`  int(3) NOT NULL COMMENT '投资态度' ,
`investment_distribution`  int(3) UNSIGNED NOT NULL COMMENT '投资资产分配' ,
`future_investment_attitude`  int(3) UNSIGNED NOT NULL COMMENT '今后三年投资表现的态度' ,
`risk_bearing_type`  int(3) UNSIGNED NOT NULL COMMENT '风险承受类型' ,
`create_time`  datetime NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户调查问券'
AUTO_INCREMENT=56

;

-- ----------------------------
-- Table structure for `ld_member_recommender_detail`
-- ----------------------------
DROP TABLE IF EXISTS `ld_member_recommender_detail`;
CREATE TABLE `ld_member_recommender_detail` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`uid`  int(10) UNSIGNED NOT NULL ,
`mobile_phone`  varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '推荐人手机号' ,
`mobile_phone2`  varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '被推荐人手机号' ,
`info`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
`create_time`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`),
INDEX `idx_member_recommender_uid` (`uid`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='推荐人详情表'
AUTO_INCREMENT=39

;

-- ----------------------------
-- Table structure for `ld_member_reward`
-- ----------------------------
DROP TABLE IF EXISTS `ld_member_reward`;
CREATE TABLE `ld_member_reward` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`type`  int(4) NOT NULL COMMENT '奖励类型 1 注册基本奖励 2 完善基本信息奖励 3 产品基本奖励' ,
`pro_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '选项名称' ,
`pro_value`  int(10) NULL DEFAULT NULL COMMENT '属性值' ,
`create_time`  datetime NOT NULL ,
`update_time`  datetime NOT NULL ,
`status`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '0 无效 1 有效' ,
`reward_type`  int(4) NULL DEFAULT NULL COMMENT '奖励类型 1现金红包，2体验金 3积分，4投资红包' ,
`pro_object`  int(4) NULL DEFAULT NULL COMMENT '1:推荐人,2:投资人' ,
`pro_way`  int(4) NULL DEFAULT NULL COMMENT '1:按投资额的比例(%),2:按绝对数值' ,
`reward_limit`  int(1) NULL DEFAULT NULL COMMENT '奖励品类限制：1.首次奖励；2.每次奖励' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='会员奖励设置表'
AUTO_INCREMENT=72

;

-- ----------------------------
-- Table structure for `ld_member_sale_relation`
-- ----------------------------
DROP TABLE IF EXISTS `ld_member_sale_relation`;
CREATE TABLE `ld_member_sale_relation` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`jobNumber`  int(13) NOT NULL COMMENT '工号' ,
`uid`  int(10) NULL DEFAULT NULL COMMENT '绑定用户ID' ,
`sale_group`  int(3) NULL DEFAULT NULL COMMENT '所属小组:1(所属小组1) 2(所属小组2)' ,
`createTime`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
`state`  int(1) NULL DEFAULT 0 COMMENT '是否有效 0有效 1无效' ,
PRIMARY KEY (`id`),
INDEX `idx_member_sale_relation_jobid` (`jobNumber`) USING BTREE ,
INDEX `idx_member_sale_relation_uid` (`uid`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='销售人员关系表'
AUTO_INCREMENT=47

;

-- ----------------------------
-- Table structure for `ld_member_score_detail`
-- ----------------------------
DROP TABLE IF EXISTS `ld_member_score_detail`;
CREATE TABLE `ld_member_score_detail` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`uid`  int(10) UNSIGNED NOT NULL ,
`type`  int(3) UNSIGNED NOT NULL COMMENT '类型：1.增加 2,减少' ,
`affect_score`  int(11) NOT NULL ,
`total_score`  int(11) NOT NULL COMMENT '总积分' ,
`info`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注' ,
`create_time`  datetime NOT NULL ,
`add_ip`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人员的外网IP地址' ,
`system_trace_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operate_mode`  int(2) NOT NULL COMMENT ' 操作类型:1, \"用户注册奖励\",2, \"推荐好友注册奖励\",3, \"实名认证奖励\",4, \"推荐好友实名认证奖励\",5, \"银行卡绑定奖励\",6, \"推荐好友银行卡绑定奖励\",7, \"邮件绑定奖励\",8, \"用户购买标的推荐人奖励\",9, \"用户充值奖励\",10, \"散标购买奖励\",11, \"涨中宝购买奖励\",12, \"新手标购买奖励\",13, \"体验标购买奖励\",14, \"兑换投资红包\",15,\"兑换体验金\",16,\"签到\",17,\"抽奖\",18,\"被推荐注册奖励\"' ,
PRIMARY KEY (`id`),
INDEX `idx_score_detail_uid` (`uid`) USING BTREE ,
INDEX `idx_score_detail_create_time` (`create_time`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户积分详情表'
AUTO_INCREMENT=1673245

;

-- ----------------------------
-- Table structure for `ld_member_unit_info`
-- ----------------------------
DROP TABLE IF EXISTS `ld_member_unit_info`;
CREATE TABLE `ld_member_unit_info` (
`uid`  int(10) UNSIGNED NOT NULL ,
`unit_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '单位名称' ,
`unit_address`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '单位地址' ,
`unit_tel`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '单位电话' ,
`work_seniority`  int(2) NOT NULL COMMENT '工作年限: 1, 一年以下2, 1-3年 3, 3-5年 4, 5-10年 5, 10年以上' ,
`reterence`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '证明人' ,
`reterence_tel`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '证明人手机手机号码' ,
`memo`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
`create_time`  datetime NOT NULL ,
`update_time`  datetime NOT NULL ,
PRIMARY KEY (`uid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='会员单位表'

;

-- ----------------------------
-- Table structure for `ld_member_withdraw`
-- ----------------------------
DROP TABLE IF EXISTS `ld_member_withdraw`;
CREATE TABLE `ld_member_withdraw` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`uid`  int(10) UNSIGNED NOT NULL ,
`withdraw_money`  decimal(15,2) NOT NULL ,
`withdraw_status`  int(4) NOT NULL COMMENT '1为待审核提现，2初审通过，3提现成功，4审核未通过 ，5 已撤销,6 通联支付处理中,7.同意提现待复核,8.提现失败,9，失败待处理，10，提现失效,11，付款审核通过' ,
`withdraw_fee`  decimal(15,2) NULL DEFAULT NULL ,
`create_time`  datetime NOT NULL ,
`add_ip`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`check_time`  datetime NULL DEFAULT NULL ,
`check_user`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '后台管理员' ,
`deal_info`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`second_fee`  decimal(15,2) NULL DEFAULT NULL COMMENT '修改后的提现手续费' ,
`success_money`  decimal(15,2) NOT NULL COMMENT '实际到账金额' ,
`system_trace_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '出款业务流水号' ,
`update_time`  datetime NULL DEFAULT NULL ,
`free_withdraw_money`  decimal(15,2) NULL DEFAULT 0.00 COMMENT '本次免费提现金额' ,
`bank_card_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行卡号' ,
`card_bank`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行名称' ,
`card_branch_bank`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卡分行名称' ,
`export_flag`  int(3) NULL DEFAULT 0 COMMENT '是否导出标志，0为未导出 1为已导出' ,
`account_type`  int(3) NULL DEFAULT NULL COMMENT '打款账户类型：0：对私；1：对公；' ,
PRIMARY KEY (`id`),
INDEX `idx_withdraw_uid` (`uid`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='提现表'
AUTO_INCREMENT=307

;

-- ----------------------------
-- Table structure for `ld_members`
-- ----------------------------
DROP TABLE IF EXISTS `ld_members`;
CREATE TABLE `ld_members` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`user_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`user_pass`  char(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`user_type`  int(3) NULL DEFAULT NULL COMMENT '1:个人，2：企业，3：内部发标, 4 : 涨呗内部账户 5 销售' ,
`pay_pass`  char(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '交易密码' ,
`user_email`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`user_phone`  varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`reg_time`  varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`is_real_name`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '是否实名：0否； 1：是' ,
`is_addCard`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' ,
`is_vip`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '是否vip 0：否； 1：是' ,
`status`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '会员状态 0：正常； 1：冻结' ,
`uid`  int(10) NOT NULL ,
`recommender`  varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '推荐人' ,
`promotionperson`  varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '推广人' ,
`error_count`  int(3) UNSIGNED NULL DEFAULT 0 COMMENT '实名认证错误次数' ,
PRIMARY KEY (`id`),
UNIQUE INDEX `user_phone_UNIQUE` (`user_phone`) USING BTREE ,
UNIQUE INDEX `idx_uid` (`uid`) USING BTREE ,
UNIQUE INDEX `user_name_2` (`user_name`) USING BTREE ,
INDEX `idx_members_user_name` (`user_name`) USING BTREE ,
INDEX `idx_members_recommender` (`recommender`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=70000243

;

-- ----------------------------
-- Table structure for `ld_message_log`
-- ----------------------------
DROP TABLE IF EXISTS `ld_message_log`;
CREATE TABLE `ld_message_log` (
`id`  int(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
`uid`  int(10) NOT NULL COMMENT '用户id' ,
`message_content`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '短信内容' ,
`send_date`  datetime(6) NOT NULL COMMENT '发送时间' ,
`send_status`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发送状态 I为初始状态 S 发送成功 F 发送失败\r\n' ,
`update_time`  datetime(6) NOT NULL ,
`create_time`  datetime(6) NOT NULL ,
`type`  int(3) NOT NULL COMMENT '1为短信 2为站内信' ,
`mobile`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发送的手机号' ,
`read_status`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'T' COMMENT '读取状态\r\nH:为已读状态， T:为未读状态 D:为删除状态' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='短信记录表'
AUTO_INCREMENT=3456

;

-- ----------------------------
-- Table structure for `ld_message_template`
-- ----------------------------
DROP TABLE IF EXISTS `ld_message_template`;
CREATE TABLE `ld_message_template` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`uid`  int(10) NOT NULL COMMENT '用户id' ,
`message_content`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '短信内容' ,
`status`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '0 无效 1 有效' ,
`update_time`  datetime(6) NOT NULL ,
`create_time`  datetime(6) NOT NULL ,
`type`  int(4) NOT NULL COMMENT '类型:1.线上充值成功2.线下充值成功3.还款到帐4.提现成功5.提现失败6.投标成功7.VIP认证通过8.发标初审通过9.发标复审通过10.手机发送验证码内容11.手机找回密码验证码12.安全中心更改手机号码13.安全中心新手机验证码14.会员设置的新标提醒15.新用户注册验证码16.更换手机老手机验证码17.更换手机新手机验证码18.忘记登录密码验证码19.忘记交易密码验证码20.修改登录密码提醒21.修改交易密码提醒22.提现请求23.标的满标24.用户注册成功25.借款申请审核通过' ,
`message_type`  int(4) NOT NULL COMMENT '信息类型 1为短信 2为站内信 3 为邮件' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='短信模板表'
AUTO_INCREMENT=1416

;

-- ----------------------------
-- Table structure for `ld_mobile_verifycode`
-- ----------------------------
DROP TABLE IF EXISTS `ld_mobile_verifycode`;
CREATE TABLE `ld_mobile_verifycode` (
`id`  int(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
`mobile`  varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`verify_code`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_time`  datetime NOT NULL ,
`update_time`  datetime NOT NULL ,
`invalid_time`  datetime NULL DEFAULT NULL ,
`status`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '0 无效 1 有效' ,
`message_type`  int(3) NULL DEFAULT NULL COMMENT '短信类型' ,
PRIMARY KEY (`id`),
INDEX `idx_mobile_phone` (`mobile`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='短信手机验证表'
AUTO_INCREMENT=947

;

-- ----------------------------
-- Table structure for `ld_newhand_product`
-- ----------------------------
DROP TABLE IF EXISTS `ld_newhand_product`;
CREATE TABLE `ld_newhand_product` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`product_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '借款名称' ,
`borrow_uid`  int(11) NULL DEFAULT NULL COMMENT '借款人id' ,
`borrow_month_duration`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款期' ,
`borrow_day_duration`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款期' ,
`borrow_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '借款金额' ,
`borrow_interest`  decimal(15,2) NULL DEFAULT NULL COMMENT '利息' ,
`borrow_interest_rate`  float(6,4) NULL DEFAULT NULL COMMENT '借款利率（年化）' ,
`borrow_fee`  decimal(15,2) NULL DEFAULT NULL COMMENT '借款费' ,
`repayment_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '偿还本金' ,
`repayment_interest`  decimal(15,2) NULL DEFAULT NULL COMMENT '偿还利息' ,
`expired_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '逾期还款金额' ,
`repayment_type`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '还款类型\r\n            (1、每月还利息、到期还本息\r\n              2、到期本息一次性返还\r\n              3、等额本息)' ,
`borrow_type`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款类型' ,
`borrow_procedures_rate`  float NULL DEFAULT NULL COMMENT '手续费率' ,
`borrow_status`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款状态 (0 新增 1 初审核 2复审 3 投资中 4 满标 5 流标 6 还款中 7 停止发布 8 完成 9 即将开始)' ,
`contractID`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合同编号' ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
`collect_start_time`  datetime NULL DEFAULT NULL COMMENT '筹集开始时间' ,
`full_time`  datetime NULL DEFAULT NULL COMMENT '满标时间' ,
`deadline`  datetime NULL DEFAULT NULL COMMENT '结束时间' ,
`check_time`  datetime NULL DEFAULT NULL COMMENT '审核时间' ,
`contract_template`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合同模板' ,
`check_user`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '初审后台用户' ,
`check_user2`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '复审后台用户' ,
`check_time2`  datetime NULL DEFAULT NULL COMMENT '复审核时间' ,
`invest_fee`  decimal(15,2) NULL DEFAULT NULL ,
`invest_rate`  float NULL DEFAULT NULL ,
`collect_end_time`  datetime NULL DEFAULT NULL ,
`borrow_days`  int(4) UNSIGNED NULL DEFAULT NULL COMMENT '借款天数' ,
`borrow_id`  int(11) NULL DEFAULT NULL COMMENT '借款编号' ,
PRIMARY KEY (`id`),
UNIQUE INDEX `idx_new_product_id` (`product_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='新手投资产品表'
AUTO_INCREMENT=9

;

-- ----------------------------
-- Table structure for `ld_newhand_product_detail`
-- ----------------------------
DROP TABLE IF EXISTS `ld_newhand_product_detail`;
CREATE TABLE `ld_newhand_product_detail` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '借款人id' ,
`borrow_type`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款用途' ,
`datetime`  datetime NULL DEFAULT NULL ,
`add_ip`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`borrow_info`  varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '借款备注' ,
`total`  int(4) NULL DEFAULT NULL COMMENT '排名(数字大排在前)' ,
`has_pay`  int(4) NULL DEFAULT NULL ,
`substitute_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '部分金额' ,
`reward_vouch_rate`  float(5,2) NULL DEFAULT NULL COMMENT '活动奖励担保汇率' ,
`reward_vouch_money`  decimal(15,2) UNSIGNED NULL DEFAULT NULL COMMENT '奖励担保金额' ,
`reward_type`  int(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '奖励类型 0 没有，1红包，2体验金 3积分' ,
`reward_min`  decimal(10,2) UNSIGNED NULL DEFAULT NULL COMMENT '奖励需投资最低金额' ,
`reward_value`  float UNSIGNED NOT NULL COMMENT '奖励值' ,
`invest_min`  decimal(15,2) UNSIGNED NOT NULL COMMENT '最小投资' ,
`invest_max`  decimal(15,2) UNSIGNED NOT NULL COMMENT '最大投资' ,
`vouch_member`  int(10) NULL DEFAULT NULL COMMENT '提保会员' ,
`password`  char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '明码' ,
`is_recommend`  int(2) UNSIGNED NOT NULL COMMENT '是否推荐0：不推荐；1：推荐' ,
`can_auto`  int(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '是否自动投标 0 否 1是' ,
`information_disclosure`  varchar(3000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '信息披露' ,
`vouch_uid`  int(10) NULL DEFAULT NULL COMMENT '担保公司id' ,
`vouch_money`  decimal(15,2) NOT NULL COMMENT '担保金额' ,
`auto_max_limit`  decimal(15,2) NOT NULL DEFAULT 0.00 COMMENT '自动投标最大金额，默认为0，即无限制' ,
`risk_control`  varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '风控描述' ,
`update_time`  datetime NULL DEFAULT NULL ,
`expired_rate`  float NULL DEFAULT NULL COMMENT '罚息利率(按日配置）' ,
`reward_total_score`  int(10) NULL DEFAULT NULL ,
`reward_experience_gold`  decimal(15,2) NULL DEFAULT NULL COMMENT '奖励体验金' ,
`reward_way`  int(3) NULL DEFAULT NULL COMMENT '奖励方式1按比例 2按数值累计返 3按数值一次返' ,
`progressive_investment`  decimal(15,2) NULL DEFAULT NULL COMMENT '递进投资额度' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='新手投资产品详情表'
AUTO_INCREMENT=13

;

-- ----------------------------
-- Table structure for `ld_news_information`
-- ----------------------------
DROP TABLE IF EXISTS `ld_news_information`;
CREATE TABLE `ld_news_information` (
`news_id`  int(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
`news_title`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`news_content`  varchar(20000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`news_url`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_date`  timestamp NULL DEFAULT NULL ,
`news_order`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`news_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=334

;

-- ----------------------------
-- Table structure for `ld_news_notice`
-- ----------------------------
DROP TABLE IF EXISTS `ld_news_notice`;
CREATE TABLE `ld_news_notice` (
`news_id`  int(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
`news_title`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`news_content`  varchar(20000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`news_url`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_date`  timestamp NULL DEFAULT NULL ,
`news_order`  int(11) NULL DEFAULT NULL ,
`status`  int(1) NULL DEFAULT NULL COMMENT '状态：1：待审核；2：已发布' ,
PRIMARY KEY (`news_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=45

;

-- ----------------------------
-- Table structure for `ld_off_product_transaction`
-- ----------------------------
DROP TABLE IF EXISTS `ld_off_product_transaction`;
CREATE TABLE `ld_off_product_transaction` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`product_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称' ,
`borrow_month_duration`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款期（月数）' ,
`borrow_day_duration`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款期（天数）' ,
`invest_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '投资金额' ,
`invest_interest_rate`  float(6,4) NULL DEFAULT NULL COMMENT '利率（年化）' ,
`repayment_type`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '还款类型 (1,每月付息，到期还本 2 到期还本付息 3, 每月等额本息 6,每季度付息，到期还本 7, 每半年付息，到期还本，8, 每月等额本金 9自定义)' ,
`uid`  int(11) NULL DEFAULT NULL ,
`invest_phone`  varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资人手机号' ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
`value_date`  datetime NULL DEFAULT NULL COMMENT '起息日' ,
`last_return_time`  datetime NULL DEFAULT NULL COMMENT '最终还款日' ,
`income`  decimal(15,2) NULL DEFAULT NULL COMMENT '收益' ,
`borrow_days`  int(4) UNSIGNED NULL DEFAULT NULL COMMENT '借款天数' ,
`borrow_duration`  int(4) UNSIGNED NULL DEFAULT NULL COMMENT '借款期数' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='线下产品交易记录表'
AUTO_INCREMENT=1964

;

-- ----------------------------
-- Table structure for `ld_parameter`
-- ----------------------------
DROP TABLE IF EXISTS `ld_parameter`;
CREATE TABLE `ld_parameter` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参数名' ,
`status`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '0 无效 1 有效' ,
`title`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参数显示名称' ,
`value`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参数值' ,
PRIMARY KEY (`id`),
UNIQUE INDEX `idx_name` (`name`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='参数表'
AUTO_INCREMENT=56

;

-- ----------------------------
-- Table structure for `ld_pe_product`
-- ----------------------------
DROP TABLE IF EXISTS `ld_pe_product`;
CREATE TABLE `ld_pe_product` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`product_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '借款名称' ,
`borrow_uid`  int(11) NULL DEFAULT NULL COMMENT '借款人id' ,
`borrow_month_duration`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款期' ,
`borrow_day_duration`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款期' ,
`borrow_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '借款金额' ,
`borrow_interest`  decimal(15,2) NULL DEFAULT NULL COMMENT '利息' ,
`borrow_interest_rate`  float(6,4) NULL DEFAULT NULL COMMENT '借款利率（年化）' ,
`borrow_fee`  decimal(15,2) NULL DEFAULT NULL COMMENT '借款费' ,
`repayment_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '偿还本金' ,
`repayment_interest`  decimal(15,2) NULL DEFAULT NULL COMMENT '偿还利息' ,
`expired_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '逾期还款金额' ,
`repayment_type`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '还款类型\r\n            (1、每月还利息、到期还本息\r\n              2、到期本息一次性返还\r\n              3、等额本息)' ,
`borrow_type`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款类型' ,
`borrow_procedures_rate`  float(6,4) NULL DEFAULT NULL COMMENT '手续费率' ,
`borrow_status`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款状态 (0 新增 1 初审核 2复审 3 投资中 4 满标 5 流标 6 还款中 7 停止发布 8 完成)' ,
`contractID`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合同编号' ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
`collect_start_time`  datetime NULL DEFAULT NULL COMMENT '筹集开始时间' ,
`full_time`  datetime NULL DEFAULT NULL COMMENT '满标时间' ,
`deadline`  datetime NULL DEFAULT NULL COMMENT '结束时间' ,
`check_time`  datetime NULL DEFAULT NULL COMMENT '审核时间' ,
`contract_template`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合同模板' ,
`check_user`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '初审后台用户' ,
`check_user2`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '复审后台用户' ,
`check_time2`  datetime NULL DEFAULT NULL COMMENT '复审核时间' ,
`invest_fee`  decimal(15,2) NULL DEFAULT NULL ,
`invest_rate`  float NULL DEFAULT NULL ,
`collect_end_time`  datetime NULL DEFAULT NULL ,
`borrow_days`  int(4) UNSIGNED NULL DEFAULT NULL COMMENT '借款天数' ,
`borrow_id`  int(11) NULL DEFAULT NULL COMMENT '借款编号' ,
`ci_product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '涨中宝产品id' ,
`product_adapted_type`  int(2) NULL DEFAULT NULL COMMENT '产品适用类型 1为涨中宝专用产品 2 散标,3:私募基金' ,
`product_sort`  int(3) NULL DEFAULT NULL COMMENT '产品排序id 从大到小' ,
`display_flag`  int(2) NULL DEFAULT 1 COMMENT '显示标记：1显示，2 为不显示' ,
`interest_way`  int(3) UNSIGNED NULL DEFAULT 1 COMMENT '计息方式：1为满标日起息, 2 为筹集结束日起息' ,
PRIMARY KEY (`id`),
UNIQUE INDEX `idx_product_id` (`product_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='私募产品表'
AUTO_INCREMENT=2

;

-- ----------------------------
-- Table structure for `ld_pe_product_detail`
-- ----------------------------
DROP TABLE IF EXISTS `ld_pe_product_detail`;
CREATE TABLE `ld_pe_product_detail` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '借款人id' ,
`borrow_type`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款用途' ,
`datetime`  datetime NULL DEFAULT NULL ,
`add_ip`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`borrow_info`  varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '借款备注' ,
`total`  int(4) NULL DEFAULT NULL COMMENT '排名(数字大排在前)' ,
`has_pay`  decimal(15,2) NULL DEFAULT NULL ,
`substitute_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '部分金额' ,
`reward_vouch_rate`  float(5,2) NULL DEFAULT NULL COMMENT '活动奖励担保汇率' ,
`reward_vouch_money`  decimal(15,2) UNSIGNED NULL DEFAULT NULL COMMENT '奖励担保金额' ,
`reward_type`  int(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '奖励类型 0 没有，1红包，2体验金 3积分' ,
`reward_min`  decimal(10,2) UNSIGNED NULL DEFAULT NULL COMMENT '奖励需投资最低金额' ,
`reward_value`  float UNSIGNED NOT NULL COMMENT '奖励值' ,
`invest_min`  decimal(15,2) UNSIGNED NOT NULL COMMENT '最小投资' ,
`invest_max`  decimal(15,2) UNSIGNED NOT NULL COMMENT '最大投资' ,
`vouch_member`  int(10) NULL DEFAULT NULL COMMENT '提保会员' ,
`password`  char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '明码' ,
`is_recommend`  int(2) UNSIGNED NOT NULL COMMENT '是否推荐0：不推荐；1：推荐' ,
`can_auto`  int(3) UNSIGNED NULL DEFAULT 1 COMMENT '是否自动投标 0 否 1是' ,
`information_disclosure`  varchar(3000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '信息披露' ,
`vouch_uid`  int(10) NULL DEFAULT NULL COMMENT '担保公司id' ,
`vouch_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '担保金额' ,
`auto_max_limit`  decimal(15,2) NULL DEFAULT 0.00 COMMENT '自动投标最大金额，默认为0，即无限制' ,
`risk_control`  varchar(8000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '风控描述' ,
`update_time`  datetime NULL DEFAULT NULL ,
`expired_rate`  float(6,4) NULL DEFAULT NULL COMMENT '罚息利率(按日配置）' ,
`reward_total_score`  int(10) NULL DEFAULT NULL ,
`reward_experience_gold`  decimal(15,2) NULL DEFAULT NULL COMMENT '奖励体验金' ,
`reward_way`  int(3) NULL DEFAULT NULL COMMENT '0:没有奖励方式1按比例 2按数值累计返 3按数值一次返' ,
`can_bonus`  int(3) NULL DEFAULT 0 COMMENT '1为可用红包,0为不可用红包' ,
`can_add_interest`  int(3) NULL DEFAULT 0 COMMENT '加息券 1为可用加息券 0为不可用加息券' ,
`contract_type`  int(3) NULL DEFAULT NULL COMMENT '产权类型： 0：线上债权转让合同 1：金融产品收益权转让协议 ' ,
`increase_progressively`  int(11) UNSIGNED NULL DEFAULT 0 COMMENT '投资递增金额' ,
`ext_field`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段' ,
`ext_field2`  int(11) UNSIGNED NULL DEFAULT NULL COMMENT '备用字段' ,
`version`  int(11) NULL DEFAULT 0 COMMENT '投资金额版本号' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='私募产品详情表'
AUTO_INCREMENT=2

;

-- ----------------------------
-- Table structure for `ld_pe_product_detail_extend`
-- ----------------------------
DROP TABLE IF EXISTS `ld_pe_product_detail_extend`;
CREATE TABLE `ld_pe_product_detail_extend` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '借款人id' ,
`risk_tip_book`  varchar(8000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '风控提示书' ,
`update_time`  datetime NULL DEFAULT NULL ,
`ext_field`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段' ,
`ext_field2`  int(11) UNSIGNED NULL DEFAULT NULL COMMENT '备用字段' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='私募产品详情扩展表'
AUTO_INCREMENT=137

;

-- ----------------------------
-- Table structure for `ld_pe_product_off_info`
-- ----------------------------
DROP TABLE IF EXISTS `ld_pe_product_off_info`;
CREATE TABLE `ld_pe_product_off_info` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`product_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称' ,
`status`  int(2) NOT NULL COMMENT '状态：1待审核 2 募集中 3 募集结束(新增时为待审核状态)' ,
`financing_scale`  int(11) NOT NULL COMMENT '融资规模(万元)' ,
`invest_limit`  int(11) NULL DEFAULT NULL COMMENT '投资门槛（元）' ,
`duration_content`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '存续期限(内容)' ,
`duration_way`  int(2) NOT NULL COMMENT '存续期限方式：1 年 2 个月 3天' ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
`info`  varchar(8000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详情' ,
`shelves_flag`  int(2) NULL DEFAULT NULL COMMENT '上/下架状态：1，已上架；2，已下架' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='私募基金线下产品表'
AUTO_INCREMENT=5

;

-- ----------------------------
-- Table structure for `ld_pe_product_risk`
-- ----------------------------
DROP TABLE IF EXISTS `ld_pe_product_risk`;
CREATE TABLE `ld_pe_product_risk` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品id' ,
`uid`  int(11) UNSIGNED NOT NULL COMMENT '用户uid' ,
`create_time`  datetime NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='产品风险关系表'
AUTO_INCREMENT=31

;

-- ----------------------------
-- Table structure for `ld_product_appointment_info`
-- ----------------------------
DROP TABLE IF EXISTS `ld_product_appointment_info`;
CREATE TABLE `ld_product_appointment_info` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`appointment_uid`  int(11) NOT NULL COMMENT '预约用户uid' ,
`sale_uid`  varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属销售uid' ,
`appointment_amount`  int(11) NULL DEFAULT NULL COMMENT '预约金额（万元）' ,
`apply_time`  datetime NULL DEFAULT NULL COMMENT '申请时间' ,
`type`  int(2) NULL DEFAULT NULL COMMENT '产品类型 1为私募基金 2 券商理财' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='产品预约记录表'
AUTO_INCREMENT=28

;

-- ----------------------------
-- Table structure for `ld_product_contract`
-- ----------------------------
DROP TABLE IF EXISTS `ld_product_contract`;
CREATE TABLE `ld_product_contract` (
`id`  int(11) UNSIGNED NOT NULL ,
`product_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品名称' ,
`product_desc`  varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品描述' ,
`memo`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
`create_time`  datetime NOT NULL ,
`update_time`  datetime NOT NULL ,
`status`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '0 无效 1 有效' ,
`html_url`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合同模板url' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='产品合同模板表'

;

-- ----------------------------
-- Table structure for `ld_product_extend_info`
-- ----------------------------
DROP TABLE IF EXISTS `ld_product_extend_info`;
CREATE TABLE `ld_product_extend_info` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`product_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称' ,
`system_trace_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统跟踪号' ,
`invest_uid`  int(11) NULL DEFAULT NULL COMMENT '投资人uid' ,
`borrow_interest_rate`  float(6,4) NULL DEFAULT NULL COMMENT '借款利率（年化）' ,
`invest_limit`  int(11) NULL DEFAULT NULL COMMENT '投资期限' ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
`product_adapted_type`  int(2) NULL DEFAULT NULL COMMENT '产品适用类型 1为新手标 2 体验标' ,
PRIMARY KEY (`id`),
UNIQUE INDEX `idx_system_trace_no` (`system_trace_no`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='产品扩展表'
AUTO_INCREMENT=15

;

-- ----------------------------
-- Table structure for `ld_repayement_detail`
-- ----------------------------
DROP TABLE IF EXISTS `ld_repayement_detail`;
CREATE TABLE `ld_repayement_detail` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`repayment_time`  datetime NULL DEFAULT NULL COMMENT '还款时间' ,
`product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`system_trace_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`investor_uid`  int(10) UNSIGNED NULL DEFAULT NULL ,
`borrow_uid`  int(10) UNSIGNED NULL DEFAULT NULL ,
`capital`  decimal(15,2) NULL DEFAULT NULL ,
`interest`  decimal(15,2) NULL DEFAULT NULL COMMENT '利息' ,
`interest_fee`  decimal(15,2) NULL DEFAULT NULL ,
`status`  tinyint(3) UNSIGNED NULL DEFAULT NULL COMMENT '收款状态(1.待收款2.收款成功,3,收款失败,4体验标收益回收)' ,
`receive_interest`  decimal(15,2) NULL DEFAULT NULL ,
`receive_capital`  decimal(15,2) NULL DEFAULT NULL ,
`sort_order`  tinyint(3) UNSIGNED NULL DEFAULT NULL COMMENT '第几期（还款的期数）' ,
`total`  tinyint(3) UNSIGNED NULL DEFAULT NULL COMMENT '总共分多少期还款' ,
`deadline`  datetime NULL DEFAULT NULL COMMENT '项目到期时间' ,
`expired_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '逾期金额' ,
`expired_days`  tinyint(3) UNSIGNED NULL DEFAULT 0 COMMENT '逾期天数' ,
`call_fee`  decimal(5,2) NULL DEFAULT NULL ,
`substitute_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '部分还款' ,
`substitute_time`  datetime NULL DEFAULT NULL ,
`return_type`  int(3) NULL DEFAULT 1 COMMENT ' 还款类 1为普通 2 加息券 3 :红包 ' ,
`real_return_date`  datetime NULL DEFAULT NULL COMMENT '实际还款时间' ,
PRIMARY KEY (`id`),
INDEX `index_repayement_trano` (`system_trace_no`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='还款计划表'
AUTO_INCREMENT=2016

;

-- ----------------------------
-- Table structure for `ld_repayment_record`
-- ----------------------------
DROP TABLE IF EXISTS `ld_repayment_record`;
CREATE TABLE `ld_repayment_record` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`repayment_time`  datetime NOT NULL ,
`product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`system_trace_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`investor_uid`  int(10) UNSIGNED NOT NULL ,
`borrow_uid`  int(10) UNSIGNED NOT NULL ,
`capital`  decimal(15,2) NOT NULL ,
`interest`  decimal(15,2) NOT NULL ,
`interest_fee`  decimal(15,2) NULL DEFAULT NULL ,
`status`  tinyint(3) UNSIGNED NOT NULL COMMENT '还款状态(1.还款成功,2,还款失败)' ,
`receive_interest`  decimal(15,2) NOT NULL ,
`receive_capital`  decimal(15,2) NOT NULL ,
`sort_order`  tinyint(3) UNSIGNED NOT NULL COMMENT '第几期（还款的期数）' ,
`total`  tinyint(3) UNSIGNED NOT NULL COMMENT '总共分多少期还款' ,
`deadline`  datetime NOT NULL ,
`expired_money`  decimal(15,2) NOT NULL COMMENT '逾期金额' ,
`expired_days`  tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '逾期天数' ,
`call_fee`  decimal(5,2) NOT NULL ,
`substitute_money`  decimal(15,2) NOT NULL COMMENT '部分还款' ,
`substitute_time`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`),
INDEX `idx_product_id` (`product_id`) USING BTREE ,
INDEX `idx_investor_uid` (`investor_uid`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='还款记录'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `ld_reward_code`
-- ----------------------------
DROP TABLE IF EXISTS `ld_reward_code`;
CREATE TABLE `ld_reward_code` (
`id`  int(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
`uid`  int(11) NULL DEFAULT NULL ,
`code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '奖励发送码' ,
`reward_type_id`  int(11) NULL DEFAULT NULL COMMENT '奖励使用类型' ,
`is_used`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否被使用，0：未使用；1：已使用' ,
`create_time`  datetime NULL DEFAULT NULL ,
`use_time`  datetime NULL DEFAULT NULL COMMENT '使用时间' ,
`source`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '来源渠道' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=5

;

-- ----------------------------
-- Table structure for `ld_reward_record`
-- ----------------------------
DROP TABLE IF EXISTS `ld_reward_record`;
CREATE TABLE `ld_reward_record` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`type`  int(4) NOT NULL COMMENT '奖励类型 1 现金红包 2 加息券 3 理财金红包(投资红包) ' ,
`pro_value`  decimal(15,4) NOT NULL ,
`create_time`  datetime NOT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
`system_trace_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资system_trace_no' ,
`use_status`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '0 绑定未使用 1 已使用 2未绑定' ,
`uid`  int(10) NULL DEFAULT NULL COMMENT '发给谁' ,
`content`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '校验码' ,
`expire_time`  datetime NOT NULL COMMENT '过期时间' ,
`use_time`  datetime NULL DEFAULT NULL COMMENT '领取时间' ,
`memo`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='会员奖励记录表'
AUTO_INCREMENT=694

;

-- ----------------------------
-- Table structure for `ld_reward_type`
-- ----------------------------
DROP TABLE IF EXISTS `ld_reward_type`;
CREATE TABLE `ld_reward_type` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`create_time`  datetime NULL DEFAULT NULL ,
`reward_type`  int(3) NULL DEFAULT NULL COMMENT '奖品码类型' ,
`reward_desc`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '奖品码内容' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=5

;

-- ----------------------------
-- Table structure for `ld_sale_proxy_borrow_invest`
-- ----------------------------
DROP TABLE IF EXISTS `ld_sale_proxy_borrow_invest`;
CREATE TABLE `ld_sale_proxy_borrow_invest` (
`id`  int(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
`invest_id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户投资id' ,
`product_name`  varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`merchant_product_id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`borrow_rate`  decimal(11,2) NULL DEFAULT NULL ,
`serial_number`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`merchant_uid`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`invest_money`  decimal(11,2) NULL DEFAULT NULL ,
`expect_money`  decimal(11,2) NULL DEFAULT NULL ,
`borrow_end_time`  datetime NULL DEFAULT NULL ,
`borrow_status`  int(5) NULL DEFAULT NULL ,
`remark`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='代销产品投资记录'
AUTO_INCREMENT=6

;

-- ----------------------------
-- Table structure for `ld_sale_proxy_members`
-- ----------------------------
DROP TABLE IF EXISTS `ld_sale_proxy_members`;
CREATE TABLE `ld_sale_proxy_members` (
`id`  int(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
`merchant_uid`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`real_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`mobile_phone`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`certificate_type`  int(5) NULL DEFAULT NULL ,
`certificate_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
`proxy_merchant_no`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商户号' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='代销商家用户'
AUTO_INCREMENT=6

;

-- ----------------------------
-- Table structure for `ld_sale_proxy_merchant`
-- ----------------------------
DROP TABLE IF EXISTS `ld_sale_proxy_merchant`;
CREATE TABLE `ld_sale_proxy_merchant` (
`id`  int(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
`merchant_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商家名称' ,
`merchant_no`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商家商户号' ,
`password`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商户密码' ,
`status`  int(1) NULL DEFAULT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='代销商家表'
AUTO_INCREMENT=2

;

-- ----------------------------
-- Table structure for `ld_sale_proxy_product`
-- ----------------------------
DROP TABLE IF EXISTS `ld_sale_proxy_product`;
CREATE TABLE `ld_sale_proxy_product` (
`id`  int(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
`product_name`  varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`product_id`  int(11) NULL DEFAULT NULL ,
`merchant_product_id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`borrow_money`  decimal(11,2) NULL DEFAULT NULL ,
`borrow_rate`  decimal(11,2) NULL DEFAULT NULL ,
`borrow_status`  int(11) NULL DEFAULT NULL ,
`product_end_time`  datetime NULL DEFAULT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='代销产品表'
AUTO_INCREMENT=3

;

-- ----------------------------
-- Table structure for `ld_sb_product_off_info`
-- ----------------------------
DROP TABLE IF EXISTS `ld_sb_product_off_info`;
CREATE TABLE `ld_sb_product_off_info` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`product_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称' ,
`status`  int(2) NOT NULL COMMENT '状态：1待审核 2 募集中 3 募集结束(新增时为待审核状态)' ,
`financing_scale`  int(11) NOT NULL COMMENT '融资规模(万元)' ,
`invest_limit`  int(11) NULL DEFAULT NULL COMMENT '投资门槛（元）' ,
`duration_content`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '存续期限(内容)' ,
`duration_way`  int(2) NOT NULL COMMENT '存续期限方式：1 年 2 个月 3天' ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
`info`  varchar(8000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详情' ,
`shelves_flag`  int(2) NULL DEFAULT NULL COMMENT '上/下架状态：1，已上架；2，已下架' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='券商理财线下产品表'
AUTO_INCREMENT=22

;

-- ----------------------------
-- Table structure for `ld_si_product`
-- ----------------------------
DROP TABLE IF EXISTS `ld_si_product`;
CREATE TABLE `ld_si_product` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`product_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '借款名称' ,
`borrow_uid`  int(11) NULL DEFAULT NULL COMMENT '借款人id' ,
`borrow_month_duration`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款期' ,
`borrow_day_duration`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款期' ,
`borrow_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '借款金额' ,
`borrow_interest`  decimal(15,2) NULL DEFAULT NULL COMMENT '利息' ,
`borrow_interest_rate`  float(6,4) NULL DEFAULT NULL COMMENT '借款利率（年化）' ,
`borrow_fee`  decimal(15,2) NULL DEFAULT NULL COMMENT '借款费' ,
`repayment_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '偿还本金' ,
`repayment_interest`  decimal(15,2) NULL DEFAULT NULL COMMENT '偿还利息' ,
`expired_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '逾期还款金额' ,
`repayment_type`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '还款类型\r\n            (1、每月还利息、到期还本息\r\n              2、到期本息一次性返还\r\n              3、等额本息)' ,
`borrow_type`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款类型' ,
`borrow_procedures_rate`  float(6,4) NULL DEFAULT NULL COMMENT '手续费率' ,
`borrow_status`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款状态 (0 新增 1 初审核 2复审 3 投资中 4 满标 5 流标 6 还款中 7 停止发布 8 完成)' ,
`contractID`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合同编号' ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
`collect_start_time`  datetime NULL DEFAULT NULL COMMENT '筹集开始时间' ,
`full_time`  datetime NULL DEFAULT NULL COMMENT '满标时间' ,
`deadline`  datetime NULL DEFAULT NULL COMMENT '结束时间' ,
`check_time`  datetime NULL DEFAULT NULL COMMENT '审核时间' ,
`contract_template`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合同模板' ,
`check_user`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '初审后台用户' ,
`check_user2`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '复审后台用户' ,
`check_time2`  datetime NULL DEFAULT NULL COMMENT '复审核时间' ,
`invest_fee`  decimal(15,2) NULL DEFAULT NULL ,
`invest_rate`  float NULL DEFAULT NULL ,
`collect_end_time`  datetime NULL DEFAULT NULL COMMENT '筹集结束时间' ,
`borrow_days`  int(4) UNSIGNED NULL DEFAULT NULL COMMENT '借款天数' ,
`borrow_id`  int(11) NULL DEFAULT NULL COMMENT '借款编号' ,
`ci_product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '涨中宝产品id' ,
`product_adapted_type`  int(2) NULL DEFAULT NULL COMMENT '产品适用类型 1为涨中宝专用产品 2 散标,3:私募基金, 4 盈享理财' ,
`product_sort`  int(3) NULL DEFAULT NULL COMMENT '产品排序id 从大到小' ,
`display_flag`  int(2) NULL DEFAULT 1 COMMENT '显示标记：1显示，2 为不显示' ,
`interest_way`  int(3) UNSIGNED NULL DEFAULT 1 COMMENT '计息方式：1为满标日起息, 2 为筹集结束日起息' ,
PRIMARY KEY (`id`),
UNIQUE INDEX `idx_product_id` (`product_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='散标产品表'
AUTO_INCREMENT=178

;

-- ----------------------------
-- Table structure for `ld_si_product_detail`
-- ----------------------------
DROP TABLE IF EXISTS `ld_si_product_detail`;
CREATE TABLE `ld_si_product_detail` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '借款人id' ,
`borrow_type`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款用途' ,
`datetime`  datetime NULL DEFAULT NULL ,
`add_ip`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`borrow_info`  varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '借款备注' ,
`total`  int(4) NULL DEFAULT NULL COMMENT '排名(数字大排在前)' ,
`has_pay`  decimal(15,2) NULL DEFAULT NULL ,
`substitute_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '部分金额' ,
`reward_vouch_rate`  float(5,2) NULL DEFAULT NULL COMMENT '活动奖励担保汇率' ,
`reward_vouch_money`  decimal(15,2) UNSIGNED NULL DEFAULT NULL COMMENT '奖励担保金额' ,
`reward_type`  int(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '奖励类型 0 没有，1红包，2体验金 3积分' ,
`reward_min`  decimal(10,2) UNSIGNED NULL DEFAULT NULL COMMENT '奖励需投资最低金额' ,
`reward_value`  float UNSIGNED NOT NULL COMMENT '奖励值' ,
`invest_min`  decimal(15,2) UNSIGNED NOT NULL COMMENT '最小投资' ,
`invest_max`  decimal(15,2) UNSIGNED NOT NULL COMMENT '最大投资' ,
`vouch_member`  int(10) NULL DEFAULT NULL COMMENT '提保会员' ,
`password`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '明码' ,
`is_recommend`  int(2) UNSIGNED NOT NULL COMMENT '是否推荐0：不推荐；1：推荐' ,
`can_auto`  int(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '是否自动投标 0 否 1是' ,
`information_disclosure`  varchar(3000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '信息披露' ,
`vouch_uid`  int(10) NULL DEFAULT NULL COMMENT '担保公司id' ,
`vouch_money`  decimal(15,2) NOT NULL COMMENT '担保金额' ,
`auto_max_limit`  decimal(15,2) NOT NULL DEFAULT 0.00 COMMENT '自动投标最大金额，默认为0，即无限制' ,
`risk_control`  varchar(8000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '风控描述' ,
`update_time`  datetime NULL DEFAULT NULL ,
`expired_rate`  float(6,4) NULL DEFAULT NULL COMMENT '罚息利率(按日配置）' ,
`reward_total_score`  int(10) NULL DEFAULT NULL ,
`reward_experience_gold`  decimal(15,2) NULL DEFAULT NULL COMMENT '奖励体验金' ,
`reward_way`  int(3) NULL DEFAULT NULL COMMENT '0:没有奖励方式1按比例 2按数值累计返 3按数值一次返' ,
`can_bonus`  int(3) NULL DEFAULT 0 COMMENT '1为可用红包,0为不可用红包' ,
`can_add_interest`  int(3) NULL DEFAULT 0 COMMENT '加息券 1为可用加息券 0为不可用加息券' ,
`contract_type`  int(3) NULL DEFAULT 0 COMMENT '产权类型： 0：线上债权转让合同 1：金融产品收益权转让协议 2：非公开发行产品协议' ,
`increase_progressively`  int(11) UNSIGNED NULL DEFAULT 0 COMMENT '投资递增金额' ,
`ext_field`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段' ,
`ext_field2`  int(11) UNSIGNED NULL DEFAULT NULL COMMENT '备用字段' ,
`version`  int(11) NULL DEFAULT 0 COMMENT '投资金额版本号' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='散标产品详情表'
AUTO_INCREMENT=151

;

-- ----------------------------
-- Table structure for `ld_si_risk_image_config`
-- ----------------------------
DROP TABLE IF EXISTS `ld_si_risk_image_config`;
CREATE TABLE `ld_si_risk_image_config` (
`id`  int(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
`product_id`  int(11) NULL DEFAULT NULL ,
`memo`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
`create_time`  datetime NOT NULL ,
`image_index`  int(3) NOT NULL DEFAULT 0 COMMENT '排序' ,
`image_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片名称' ,
`image_title`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片标题' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='散标风险控制图片配置记录表'
AUTO_INCREMENT=18

;

-- ----------------------------
-- Table structure for `ld_uid`
-- ----------------------------
DROP TABLE IF EXISTS `ld_uid`;
CREATE TABLE `ld_uid` (
`uid`  int(10) NOT NULL 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `ld_user_operator_log`
-- ----------------------------
DROP TABLE IF EXISTS `ld_user_operator_log`;
CREATE TABLE `ld_user_operator_log` (
`id`  int(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
`userId`  int(11) NULL DEFAULT NULL COMMENT '用户id' ,
`url`  varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作url' ,
`login_IP`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作ip' ,
`operation_content`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作内容' ,
`create_time`  datetime(6) NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='后台操作日志'
AUTO_INCREMENT=37035

;

-- ----------------------------
-- Table structure for `ld_user_sign_in_log`
-- ----------------------------
DROP TABLE IF EXISTS `ld_user_sign_in_log`;
CREATE TABLE `ld_user_sign_in_log` (
`id`  int(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
`uid`  int(10) NOT NULL COMMENT '用户id' ,
`status`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '1:成功2:失败\r\n' ,
`update_time`  datetime NOT NULL ,
`create_time`  datetime NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='签到记录表'
AUTO_INCREMENT=277

;

-- ----------------------------
-- Table structure for `ld_user_signature_log`
-- ----------------------------
DROP TABLE IF EXISTS `ld_user_signature_log`;
CREATE TABLE `ld_user_signature_log` (
`id`  int(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
`uid`  int(11) NOT NULL COMMENT '用户id' ,
`file_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件名称' ,
`type`  int(3) NOT NULL COMMENT '类型' ,
`pid`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件id' ,
`create_time`  datetime(6) NOT NULL ,
`time_syn`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '时间磋' ,
`system_trace_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投资记录系统跟踪号' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户签章日志'
AUTO_INCREMENT=362

;

-- ----------------------------
-- Table structure for `ld_yingxiang_product`
-- ----------------------------
DROP TABLE IF EXISTS `ld_yingxiang_product`;
CREATE TABLE `ld_yingxiang_product` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`product_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '借款名称' ,
`borrow_uid`  int(11) NULL DEFAULT NULL COMMENT '借款人id' ,
`borrow_month_duration`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款期' ,
`borrow_day_duration`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款期' ,
`borrow_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '借款金额' ,
`borrow_interest`  decimal(15,2) NULL DEFAULT NULL COMMENT '利息' ,
`borrow_interest_rate`  float(6,4) NULL DEFAULT NULL COMMENT '借款利率（年化）' ,
`borrow_fee`  decimal(15,2) NULL DEFAULT NULL COMMENT '借款费' ,
`repayment_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '偿还本金' ,
`repayment_interest`  decimal(15,2) NULL DEFAULT NULL COMMENT '偿还利息' ,
`expired_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '逾期还款金额' ,
`repayment_type`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '还款类型 (8 每月等额本金)' ,
`borrow_type`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款类型' ,
`borrow_procedures_rate`  float(6,4) NULL DEFAULT NULL COMMENT '手续费率' ,
`borrow_status`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款状态 (0 新增 1 初审核 2复审 3 投资中 4 满标 5 流标 6 还款中 7 停止发布 8 完成)' ,
`contractID`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合同编号' ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
`collect_start_time`  datetime NULL DEFAULT NULL COMMENT '筹集开始时间' ,
`full_time`  datetime NULL DEFAULT NULL COMMENT '满标时间' ,
`deadline`  datetime NULL DEFAULT NULL COMMENT '结束时间' ,
`last_time`  datetime NULL DEFAULT NULL COMMENT '最终还款日' ,
`check_time`  datetime NULL DEFAULT NULL COMMENT '审核时间' ,
`contract_template`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合同模板' ,
`check_user`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '初审后台用户' ,
`check_user2`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '复审后台用户' ,
`check_time2`  datetime NULL DEFAULT NULL COMMENT '复审核时间' ,
`invest_fee`  decimal(15,2) NULL DEFAULT NULL ,
`invest_rate`  float NULL DEFAULT NULL ,
`collect_end_time`  datetime NULL DEFAULT NULL COMMENT '筹集结束时间' ,
`borrow_id`  int(11) NULL DEFAULT NULL COMMENT '借款编号' ,
`ci_product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '涨中宝产品id' ,
`product_adapted_type`  int(2) NULL DEFAULT NULL COMMENT '产品适用类型 1为涨中宝专用产品 2 散标,3:私募基金;4 盈享理财' ,
`product_sort`  int(3) NULL DEFAULT NULL COMMENT '产品排序id 从大到小' ,
`display_flag`  int(2) NULL DEFAULT 1 COMMENT '显示标记：1显示，2 为不显示' ,
`interest_way`  int(3) UNSIGNED NULL DEFAULT 1 COMMENT '计息方式：1为满标日起息, 2 为筹集结束日起息' ,
PRIMARY KEY (`id`),
UNIQUE INDEX `idx_product_id` (`product_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='盈享理财产品表'
AUTO_INCREMENT=201

;

-- ----------------------------
-- Table structure for `ld_yingxiang_product_detail`
-- ----------------------------
DROP TABLE IF EXISTS `ld_yingxiang_product_detail`;
CREATE TABLE `ld_yingxiang_product_detail` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '借款人id' ,
`borrow_type`  int(3) UNSIGNED NULL DEFAULT NULL COMMENT '借款用途' ,
`datetime`  datetime NULL DEFAULT NULL ,
`add_ip`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`borrow_info`  varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '借款备注' ,
`total`  int(4) NULL DEFAULT NULL COMMENT '排名(数字大排在前)' ,
`has_pay`  decimal(15,2) NULL DEFAULT NULL ,
`substitute_money`  decimal(15,2) NULL DEFAULT NULL COMMENT '部分金额' ,
`reward_vouch_rate`  float(5,2) NULL DEFAULT NULL COMMENT '活动奖励担保汇率' ,
`reward_vouch_money`  decimal(15,2) UNSIGNED NULL DEFAULT NULL COMMENT '奖励担保金额' ,
`reward_type`  int(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '奖励类型 0 没有，1红包，2体验金 3积分' ,
`reward_min`  decimal(10,2) UNSIGNED NULL DEFAULT NULL COMMENT '奖励需投资最低金额' ,
`reward_value`  float UNSIGNED NOT NULL COMMENT '奖励值' ,
`invest_min`  decimal(15,2) UNSIGNED NOT NULL COMMENT '最小投资' ,
`invest_max`  decimal(15,2) UNSIGNED NOT NULL COMMENT '最大投资' ,
`vouch_member`  int(10) NULL DEFAULT NULL COMMENT '提保会员' ,
`password`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '明码' ,
`is_recommend`  int(2) UNSIGNED NULL DEFAULT NULL COMMENT '是否推荐0：不推荐；1：推荐' ,
`information_disclosure`  varchar(3000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '信息披露' ,
`vouch_uid`  int(10) NULL DEFAULT NULL COMMENT '担保公司id' ,
`vouch_money`  decimal(15,2) NOT NULL COMMENT '担保金额' ,
`auto_max_limit`  decimal(15,2) NOT NULL DEFAULT 0.00 COMMENT '自动投标最大金额，默认为0，即无限制' ,
`risk_control`  varchar(8000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '风控描述' ,
`update_time`  datetime NULL DEFAULT NULL ,
`expired_rate`  float(6,4) NULL DEFAULT NULL COMMENT '罚息利率(按日配置）' ,
`reward_total_score`  int(10) NULL DEFAULT NULL ,
`reward_experience_gold`  decimal(15,2) NULL DEFAULT NULL COMMENT '奖励体验金' ,
`reward_way`  int(3) NULL DEFAULT NULL COMMENT '0:没有奖励方式1按比例 2按数值累计返 3按数值一次返' ,
`can_bonus`  int(3) NULL DEFAULT 0 COMMENT '1为可用红包,0为不可用红包' ,
`can_add_interest`  int(3) NULL DEFAULT 0 COMMENT '加息券 1为可用加息券 0为不可用加息券' ,
`contract_type`  int(3) NULL DEFAULT 0 COMMENT '网签合同类型： 0：线上债权转让合同 1：金融产品收益权转让协议 2：非公开发行产品协议' ,
`increase_progressively`  int(11) UNSIGNED NULL DEFAULT 0 COMMENT '投资递增金额' ,
`ext_field`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段' ,
`ext_field2`  int(11) UNSIGNED NULL DEFAULT NULL COMMENT '备用字段' ,
`version`  int(11) NULL DEFAULT 0 COMMENT '投资金额版本号' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='盈享理财产品详情表'
AUTO_INCREMENT=175

;

-- ----------------------------
-- Table structure for `persistent_logins`
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
`USERNAME`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`SERIES`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`TOKEN`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`LAST_USED`  datetime NOT NULL DEFAULT 'CURRENT_TIMESTAMP' ,
PRIMARY KEY (`SERIES`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='Spring Remember me 持久化'

;

-- ----------------------------
-- Table structure for `rebate_product`
-- ----------------------------
DROP TABLE IF EXISTS `rebate_product`;
CREATE TABLE `rebate_product` (
`id`  int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID(自动增长)' ,
`product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品ID' ,
`product_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称' ,
`uid`  int(10) NULL DEFAULT NULL COMMENT '坐席UID' ,
`phone`  int(11) NULL DEFAULT NULL COMMENT '坐席手机号' ,
`issue_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布机构名称' ,
`price`  decimal(15,2) NULL DEFAULT NULL COMMENT '产品单价' ,
`sub_max`  int(7) NULL DEFAULT NULL COMMENT '最大认购数量' ,
`commission`  decimal(15,2) NULL DEFAULT NULL COMMENT '佣金比例' ,
`product_status`  int(1) NULL DEFAULT NULL COMMENT '产品上架状态(0未上架，1上架，2下架)' ,
`product_sort`  int(5) NULL DEFAULT NULL COMMENT '排列顺序' ,
`create_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
`update_time`  datetime NULL DEFAULT NULL COMMENT '修改时间' ,
`check_time`  datetime NULL DEFAULT NULL COMMENT '审核时间' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `rebate_product_detail`
-- ----------------------------
DROP TABLE IF EXISTS `rebate_product_detail`;
CREATE TABLE `rebate_product_detail` (
`id`  int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID(自动增长)' ,
`product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品ID' ,
`total_amount`  int(10) NULL DEFAULT NULL COMMENT '总数量' ,
`surplus_amount`  int(10) NULL DEFAULT NULL COMMENT '剩余数量' ,
`product_detail`  varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品详情' ,
`create_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
`update_time`  datetime NULL DEFAULT NULL COMMENT '调整时间' ,
`version`  int(11) NULL DEFAULT NULL COMMENT '版本号' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `sequence`
-- ----------------------------
DROP TABLE IF EXISTS `sequence`;
CREATE TABLE `sequence` (
`name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`current_value`  int(11) NOT NULL ,
`increment`  int(11) NOT NULL DEFAULT 1 ,
`memo`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注' ,
PRIMARY KEY (`name`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `t_relation`
-- ----------------------------
DROP TABLE IF EXISTS `t_relation`;
CREATE TABLE `t_relation` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`uid`  int(15) NULL DEFAULT NULL ,
`jid`  int(15) NULL DEFAULT NULL ,
`relation`  varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`disable`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'F' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=49725

;

-- ----------------------------
-- Table structure for `t_resource`
-- ----------------------------
DROP TABLE IF EXISTS `t_resource`;
CREATE TABLE `t_resource` (
`resource_id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`resource_code`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源编码' ,
`resource_name`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源名称' ,
`resource_type`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源类型 M 菜单 B 按钮 H 超链接' ,
`father_resource`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父节点id' ,
`is_leaf`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否叶节点Y是N否' ,
`menu_index`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单排序' ,
`status`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '0.不可用1.可用' ,
`create_time`  datetime NOT NULL ,
`update_time`  datetime NOT NULL ,
`menu_url`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单链接' ,
`menu_picture`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`menu_level`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单级别(1级,2级,3级,4级)' ,
PRIMARY KEY (`resource_id`),
UNIQUE INDEX `idx_resource_code` (`resource_code`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='后台资源表'
AUTO_INCREMENT=1198

;

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
`role_id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`role_name`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`remark`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`status`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '0.不可用1.可用' ,
`create_time`  datetime NOT NULL ,
`update_time`  datetime NOT NULL ,
PRIMARY KEY (`role_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=31

;

-- ----------------------------
-- Table structure for `t_role_resource`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_resource`;
CREATE TABLE `t_role_resource` (
`role_id`  int(10) UNSIGNED NOT NULL ,
`resource_id`  int(10) UNSIGNED NOT NULL ,
`status`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '0.不可用1.可用' ,
`create_time`  datetime NOT NULL ,
`update_time`  datetime NOT NULL ,
PRIMARY KEY (`role_id`, `resource_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='角色资源关系表'

;

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
`uid`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`login_name`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录名' ,
`user_name`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户真实姓名' ,
`user_dept`  int(10) UNSIGNED NOT NULL ,
`login_pw`  varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码 md5加密' ,
`memo`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`status`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户状态：0正常 1为锁定 2 已删除' ,
`create_time`  datetime NOT NULL ,
`update_time`  datetime NOT NULL ,
`qq`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`telphone`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`vip`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否 1为客服,0为非客服 ' ,
`command_pwd`  varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '口令' ,
`macinfo`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电脑硬件信息' ,
`macinfoback`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电脑硬件信息备份' ,
`check_mac`  int(1) NULL DEFAULT 0 COMMENT '是否校验机器码(0 不校验 1校验)' ,
PRIMARY KEY (`uid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='后台用户表'
AUTO_INCREMENT=6

;

-- ----------------------------
-- Table structure for `t_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
`user_id`  int(10) UNSIGNED NOT NULL ,
`role_id`  int(10) UNSIGNED NOT NULL ,
`status`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '0.不可用1.可用' ,
`create_time`  datetime NOT NULL ,
`update_time`  datetime NOT NULL ,
PRIMARY KEY (`user_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='后台用户角色表'

;

-- ----------------------------
-- View structure for `ld_borrow_summary`
-- ----------------------------
DROP VIEW IF EXISTS `ld_borrow_summary`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `ld_borrow_summary` AS select `lep`.`borrow_uid` AS `borrow_uid`,`lep`.`product_id` AS `product_id`,`lep`.`product_name` AS `product_name`,`lep`.`repayment_type` AS `repayment_type`,`lep`.`borrow_day_duration` AS `borrow_day_duration`,`lep`.`borrow_month_duration` AS `borrow_month_duration`,`lep`.`borrow_money` AS `borrow_money`,`lep`.`borrow_interest_rate` AS `borrow_interest_rate`,`lep`.`borrow_fee` AS `borrow_fee`,`lep`.`borrow_procedures_rate` AS `borrow_procedures_rate`,`lep`.`collect_start_time` AS `collect_start_time`,`lep`.`collect_end_time` AS `collect_end_time`,('interest_way' = NULL) AS `interest_way`,('last_time' = NULL) AS `last_time`,`lep`.`full_time` AS `full_time` from `ld_experience_product` `lep` union all select `lnp`.`borrow_uid` AS `borrow_uid`,`lnp`.`product_id` AS `product_id`,`lnp`.`product_name` AS `product_name`,`lnp`.`repayment_type` AS `repayment_type`,`lnp`.`borrow_day_duration` AS `borrow_day_duration`,`lnp`.`borrow_month_duration` AS `borrow_month_duration`,`lnp`.`borrow_money` AS `borrow_money`,`lnp`.`borrow_interest_rate` AS `borrow_interest_rate`,`lnp`.`borrow_fee` AS `borrow_fee`,`lnp`.`borrow_procedures_rate` AS `borrow_procedures_rate`,`lnp`.`collect_start_time` AS `collect_start_time`,`lnp`.`collect_end_time` AS `collect_end_time`,('interest_way' = NULL) AS `interest_way`,('last_time' = NULL) AS `last_time`,`lnp`.`full_time` AS `full_time` from `ld_newhand_product` `lnp` union all select `lsp`.`borrow_uid` AS `borrow_uid`,`lsp`.`product_id` AS `product_id`,`lsp`.`product_name` AS `product_name`,`lsp`.`repayment_type` AS `repayment_type`,`lsp`.`borrow_day_duration` AS `borrow_day_duration`,`lsp`.`borrow_month_duration` AS `borrow_month_duration`,`lsp`.`borrow_money` AS `borrow_money`,`lsp`.`borrow_interest_rate` AS `borrow_interest_rate`,`lsp`.`borrow_fee` AS `borrow_fee`,`lsp`.`borrow_procedures_rate` AS `borrow_procedures_rate`,`lsp`.`collect_start_time` AS `collect_start_time`,`lsp`.`collect_end_time` AS `collect_end_time`,`lsp`.`interest_way` AS `interest_way`,('last_time' = NULL) AS `last_time`,`lsp`.`full_time` AS `full_time` from `ld_si_product` `lsp` where ((`lsp`.`borrow_status` in (6,8)) and (`lsp`.`display_flag` = 1)) union all select `lpp`.`borrow_uid` AS `borrow_uid`,`lpp`.`product_id` AS `product_id`,`lpp`.`product_name` AS `product_name`,`lpp`.`repayment_type` AS `repayment_type`,`lpp`.`borrow_day_duration` AS `borrow_day_duration`,`lpp`.`borrow_month_duration` AS `borrow_month_duration`,`lpp`.`borrow_money` AS `borrow_money`,`lpp`.`borrow_interest_rate` AS `borrow_interest_rate`,`lpp`.`borrow_fee` AS `borrow_fee`,`lpp`.`borrow_procedures_rate` AS `borrow_procedures_rate`,`lpp`.`collect_start_time` AS `collect_start_time`,`lpp`.`collect_end_time` AS `collect_end_time`,`lpp`.`interest_way` AS `interest_way`,('last_time' = NULL) AS `last_time`,`lpp`.`full_time` AS `full_time` from `ld_pe_product` `lpp` where (`lpp`.`borrow_status` in (6,8)) union all select `lyxp`.`borrow_uid` AS `borrow_uid`,`lyxp`.`product_id` AS `product_id`,`lyxp`.`product_name` AS `product_name`,`lyxp`.`repayment_type` AS `repayment_type`,`lyxp`.`borrow_day_duration` AS `borrow_day_duration`,`lyxp`.`borrow_month_duration` AS `borrow_month_duration`,`lyxp`.`borrow_money` AS `borrow_money`,`lyxp`.`borrow_interest_rate` AS `borrow_interest_rate`,`lyxp`.`borrow_fee` AS `borrow_fee`,`lyxp`.`borrow_procedures_rate` AS `borrow_procedures_rate`,`lyxp`.`collect_start_time` AS `collect_start_time`,`lyxp`.`collect_end_time` AS `collect_end_time`,`lyxp`.`interest_way` AS `interest_way`,`lyxp`.`last_time` AS `last_time`,`lyxp`.`full_time` AS `full_time` from `ld_yingxiang_product` `lyxp` where (`lyxp`.`borrow_status` in (6,8)) ;

-- ----------------------------
-- View structure for `ld_index_product`
-- ----------------------------
DROP VIEW IF EXISTS `ld_index_product`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `ld_index_product` AS select `t`.`product_id` AS `product_id`,`t`.`product_name` AS `product_name`,`t`.`repayment_type` AS `repayment_type`,`t`.`borrow_day_duration` AS `borrow_day_duration`,`t`.`borrow_month_duration` AS `borrow_month_duration`,`t`.`product_sort` AS `product_sort`,`t`.`borrow_interest_rate` AS `borrow_interest_rate`,`t`.`borrow_status` AS `borrow_status`,`t`.`borrow_money` AS `borrow_money`,`t`.`collect_start_time` AS `collect_start_time`,`t`.`collect_end_time` AS `collect_end_time`,`t`.`create_time` AS `create_time`,`t`.`product_adapted_type` AS `product_adapted_type`,`td`.`can_bonus` AS `can_bonus`,`td`.`can_add_interest` AS `can_add_interest`,`td`.`invest_min` AS `invest_min`,`td`.`invest_max` AS `invest_max`,`t`.`borrow_uid` AS `borrow_uid`,`t`.`deadline` AS `deadline` from (`ld_si_product` `t` left join `ld_si_product_detail` `td` on((`t`.`product_id` = `td`.`product_id`))) where ((`t`.`display_flag` = 1) and (`t`.`borrow_status` in (3,4,6,8)) and (`t`.`product_adapted_type` = 2)) union all select `tpe`.`product_id` AS `product_id`,`tpe`.`product_name` AS `product_name`,`tpe`.`repayment_type` AS `repayment_type`,`tpe`.`borrow_day_duration` AS `borrow_day_duration`,`tpe`.`borrow_month_duration` AS `borrow_month_duration`,`tpe`.`product_sort` AS `product_sort`,`tpe`.`borrow_interest_rate` AS `borrow_interest_rate`,`tpe`.`borrow_status` AS `borrow_status`,`tpe`.`borrow_money` AS `borrow_money`,`tpe`.`collect_start_time` AS `collect_start_time`,`tpe`.`collect_end_time` AS `collect_end_time`,`tpe`.`create_time` AS `create_time`,`tpe`.`product_adapted_type` AS `product_adapted_type`,`tped`.`can_bonus` AS `can_bonus`,`tped`.`can_add_interest` AS `can_add_interest`,`tped`.`invest_min` AS `invest_min`,`tped`.`invest_max` AS `invest_max`,`tpe`.`borrow_uid` AS `borrow_uid`,`tpe`.`deadline` AS `deadline` from (`ld_pe_product` `tpe` left join `ld_pe_product_detail` `tped` on((`tpe`.`product_id` = `tped`.`product_id`))) where ((`tpe`.`display_flag` = 1) and (`tpe`.`borrow_status` in (3,4,6,8)) and (`tpe`.`product_adapted_type` = 3)) ;

-- ----------------------------
-- View structure for `ld_interest_way`
-- ----------------------------
DROP VIEW IF EXISTS `ld_interest_way`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `ld_interest_way` AS select `ld_si_product`.`product_id` AS `product_id`,`ld_si_product`.`interest_way` AS `interest_way`,`ld_si_product`.`collect_end_time` AS `collect_end_time` from `ld_si_product` union all select `ld_pe_product`.`product_id` AS `product_id`,`ld_pe_product`.`interest_way` AS `interest_way`,`ld_pe_product`.`collect_end_time` AS `collect_end_time` from `ld_pe_product` union all select `ld_yingxiang_product`.`product_id` AS `product_id`,`ld_yingxiang_product`.`interest_way` AS `interest_way`,`ld_yingxiang_product`.`collect_end_time` AS `collect_end_time` from `ld_yingxiang_product` ;

-- ----------------------------
-- View structure for `ld_product_name`
-- ----------------------------
DROP VIEW IF EXISTS `ld_product_name`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `ld_product_name` AS select `ld_si_product`.`product_id` AS `product_id`,`ld_si_product`.`product_name` AS `product_name` from `ld_si_product` union all select `ld_ci_product`.`product_id` AS `product_id`,`ld_ci_product`.`product_name` AS `product_name` from `ld_ci_product` union all select `ld_newhand_product`.`product_id` AS `product_id`,`ld_newhand_product`.`product_name` AS `product_name` from `ld_newhand_product` union all select `ld_experience_product`.`product_id` AS `product_id`,`ld_experience_product`.`product_name` AS `product_name` from `ld_experience_product` union all select `ld_yingxiang_product`.`product_id` AS `product_id`,`ld_yingxiang_product`.`product_name` AS `product_name` from `ld_yingxiang_product` ;

-- ----------------------------
-- View structure for `ld_product_status_view`
-- ----------------------------
DROP VIEW IF EXISTS `ld_product_status_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `ld_product_status_view` AS select `ld_si_product`.`product_id` AS `product_id`,`ld_si_product`.`borrow_money` AS `borrow_money`,`ld_si_product`.`borrow_status` AS `borrow_status`,'1' AS `pro_type` from `ld_si_product` union all select `ld_newhand_product`.`product_id` AS `product_id`,`ld_newhand_product`.`borrow_money` AS `borrow_money`,`ld_newhand_product`.`borrow_status` AS `borrow_status`,'2' AS `pro_type` from `ld_newhand_product` union all select `ld_yingxiang_product`.`product_id` AS `product_id`,`ld_yingxiang_product`.`borrow_money` AS `borrow_money`,`ld_yingxiang_product`.`borrow_status` AS `borrow_status`,'3' AS `pro_type` from `ld_yingxiang_product` ;

-- ----------------------------
-- View structure for `ld_product_view`
-- ----------------------------
DROP VIEW IF EXISTS `ld_product_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `ld_product_view` AS select `ld_si_product`.`product_id` AS `product_id`,`ld_si_product`.`product_name` AS `product_name`,`ld_si_product`.`borrow_uid` AS `borrow_uid`,`ld_si_product`.`borrow_month_duration` AS `borrow_month_duration`,`ld_si_product`.`borrow_day_duration` AS `borrow_day_duration`,`ld_si_product`.`repayment_type` AS `repayment_type`,`ld_si_product`.`borrow_interest_rate` AS `borrow_interest_rate`,`ld_si_product`.`borrow_procedures_rate` AS `borrow_procedures_rate`,`ld_si_product`.`borrow_fee` AS `borrow_fee`,(case `ld_si_product`.`interest_way` when 1 then `ld_si_product`.`full_time` else `ld_si_product`.`collect_end_time` end) AS `interest_time`,'3' AS `pro_type` from `ld_si_product` union all select `ld_ci_product`.`product_id` AS `product_id`,`ld_ci_product`.`product_name` AS `product_name`,`ld_ci_product`.`borrow_uid` AS `borrow_uid`,`ld_ci_product`.`borrow_month_duration` AS `borrow_month_duration`,`ld_ci_product`.`borrow_day_duration` AS `borrow_day_duration`,`ld_ci_product`.`repayment_type` AS `repayment_type`,`ld_ci_product`.`borrow_interest_rate` AS `borrow_interest_rate`,`ld_ci_product`.`borrow_procedures_rate` AS `borrow_procedures_rate`,`ld_ci_product`.`borrow_fee` AS `borrow_fee`,NULL AS `interest_time`,'4' AS `pro_type` from `ld_ci_product` union all select `ld_newhand_product`.`product_id` AS `product_id`,`ld_newhand_product`.`product_name` AS `product_name`,`ld_newhand_product`.`borrow_uid` AS `borrow_uid`,`ld_newhand_product`.`borrow_month_duration` AS `borrow_month_duration`,`ld_newhand_product`.`borrow_day_duration` AS `borrow_day_duration`,`ld_newhand_product`.`repayment_type` AS `repayment_type`,`ld_newhand_product`.`borrow_interest_rate` AS `borrow_interest_rate`,`ld_newhand_product`.`borrow_procedures_rate` AS `borrow_procedures_rate`,`ld_newhand_product`.`borrow_fee` AS `borrow_fee`,NULL AS `interest_time`,'1' AS `pro_type` from `ld_newhand_product` union all select `ld_experience_product`.`product_id` AS `product_id`,`ld_experience_product`.`product_name` AS `product_name`,`ld_experience_product`.`borrow_uid` AS `borrow_uid`,`ld_experience_product`.`borrow_month_duration` AS `borrow_month_duration`,`ld_experience_product`.`borrow_day_duration` AS `borrow_day_duration`,`ld_experience_product`.`repayment_type` AS `repayment_type`,`ld_experience_product`.`borrow_interest_rate` AS `borrow_interest_rate`,`ld_experience_product`.`borrow_procedures_rate` AS `borrow_procedures_rate`,`ld_experience_product`.`borrow_fee` AS `borrow_fee`,NULL AS `interest_time`,'2' AS `pro_type` from `ld_experience_product` union all select `ld_yingxiang_product`.`product_id` AS `product_id`,`ld_yingxiang_product`.`product_name` AS `product_name`,`ld_yingxiang_product`.`borrow_uid` AS `borrow_uid`,`ld_yingxiang_product`.`borrow_month_duration` AS `borrow_month_duration`,`ld_yingxiang_product`.`borrow_day_duration` AS `borrow_day_duration`,`ld_yingxiang_product`.`repayment_type` AS `repayment_type`,`ld_yingxiang_product`.`borrow_interest_rate` AS `borrow_interest_rate`,`ld_yingxiang_product`.`borrow_procedures_rate` AS `borrow_procedures_rate`,`ld_yingxiang_product`.`borrow_fee` AS `borrow_fee`,(case `ld_yingxiang_product`.`interest_way` when 1 then `ld_yingxiang_product`.`full_time` else `ld_yingxiang_product`.`collect_end_time` end) AS `interest_time`,'5' AS `pro_type` from `ld_yingxiang_product` ;

-- ----------------------------
-- View structure for `ld_view_product_info`
-- ----------------------------
DROP VIEW IF EXISTS `ld_view_product_info`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `ld_view_product_info` AS select `ld_si_product`.`product_id` AS `product_id`,`ld_si_product`.`product_name` AS `product_name` from `ld_si_product` union all select `ld_pe_product`.`product_id` AS `product_id`,`ld_pe_product`.`product_name` AS `product_name` from `ld_pe_product` union all select `ld_yingxiang_product`.`product_id` AS `product_id`,`ld_yingxiang_product`.`product_name` AS `product_name` from `ld_yingxiang_product` ;

-- ----------------------------
-- View structure for `ld_view_product_off_info`
-- ----------------------------
DROP VIEW IF EXISTS `ld_view_product_off_info`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `ld_view_product_off_info` AS select `sbof`.`product_id` AS `product_id`,`sbof`.`product_name` AS `product_name`,`sbof`.`financing_scale` AS `financing_scale`,`sbof`.`invest_limit` AS `invest_limit`,`sbof`.`status` AS `status`,`sbof`.`info` AS `info` from `ld_sb_product_off_info` `sbof` union all select `peof`.`product_id` AS `product_id`,`peof`.`product_name` AS `product_name`,`peof`.`financing_scale` AS `financing_scale`,`peof`.`invest_limit` AS `invest_limit`,`peof`.`status` AS `status`,`peof`.`info` AS `info` from `ld_pe_product_off_info` `peof` ;

-- ----------------------------
-- View structure for `ld_view_repayment`
-- ----------------------------
DROP VIEW IF EXISTS `ld_view_repayment`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `ld_view_repayment` AS select (`lrd`.`capital` + `lrd`.`interest`) AS `capital`,`lrd`.`status` AS `status`,`lpn`.`product_name` AS `product_name`,`lrd`.`product_id` AS `product_id`,`lrd`.`repayment_time` AS `repayment_time`,`lrd`.`investor_uid` AS `investor_uid` from (`ld_repayement_detail` `lrd` left join `ld_product_extend_info` `lpn` on((`lrd`.`system_trace_no` = `lpn`.`system_trace_no`))) ;

-- ----------------------------
-- View structure for `v_relation`
-- ----------------------------
DROP VIEW IF EXISTS `v_relation`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `v_relation` AS select `t_relation`.`id` AS `id`,`t_relation`.`uid` AS `uid`,`t_relation`.`jid` AS `jid`,`t_relation`.`relation` AS `relation`,`t_relation`.`disable` AS `disable` from `t_relation` ;

-- ----------------------------
-- Procedure structure for `genUsers`
-- ----------------------------
DROP PROCEDURE IF EXISTS `genUsers`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `genUsers`()
begin

  declare i int default 0;

  while i < 40 do

    insert into users(userID,userName,password) values(i,concat('username',i),concat('password',i));

    set i = i + 1;

  end while;

end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `GreetWorld`
-- ----------------------------
DROP PROCEDURE IF EXISTS `GreetWorld`;
DELIMITER ;;
CREATE DEFINER=`haopeizi`@`localhost` PROCEDURE `GreetWorld`()
select CONCAT(@greeting,'world')
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `p1`
-- ----------------------------
DROP PROCEDURE IF EXISTS `p1`;
DELIMITER ;;
CREATE DEFINER=`haopeizi`@`localhost` PROCEDURE `p1`()
SET @last_procedure='p1'
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `p2`
-- ----------------------------
DROP PROCEDURE IF EXISTS `p2`;
DELIMITER ;;
CREATE DEFINER=`haopeizi`@`localhost` PROCEDURE `p2`()
SELECT CONCAT('Last procedure was ',@last_procedure)
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `p3`
-- ----------------------------
DROP PROCEDURE IF EXISTS `p3`;
DELIMITER ;;
CREATE DEFINER=`haopeizi`@`localhost` PROCEDURE `p3`()
SELECT CONCAT('Last procedure was ',@last_proc)
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `p4`
-- ----------------------------
DROP PROCEDURE IF EXISTS `p4`;
DELIMITER ;;
CREATE DEFINER=`haopeizi`@`localhost` PROCEDURE `p4`()
SET @last_proc='p1'
;;
DELIMITER ;

-- ----------------------------
-- Function structure for `currval`
-- ----------------------------
DROP FUNCTION IF EXISTS `currval`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `currval`(seq_name VARCHAR(50)) RETURNS int(11)
    DETERMINISTIC
BEGIN  
	 DECLARE value INTEGER;  
	 SET value = 0;  
	 SELECT current_value INTO value  
						 FROM sequence  
						 WHERE name = seq_name;  
	 RETURN value;  
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for `nextval`
-- ----------------------------
DROP FUNCTION IF EXISTS `nextval`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `nextval`(seq_name VARCHAR(50)) RETURNS int(11)
    DETERMINISTIC
BEGIN  
		 UPDATE sequence  
							 SET current_value = current_value + increment  
							 WHERE name = seq_name;  
		 RETURN currval(seq_name);  
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for `setval`
-- ----------------------------
DROP FUNCTION IF EXISTS `setval`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `setval`(seq_name VARCHAR(50), value INTEGER) RETURNS int(11)
    DETERMINISTIC
BEGIN  
		 UPDATE sequence  
							 SET current_value = value  
							 WHERE name = seq_name;  
		 RETURN currval(seq_name);  
END
;;
DELIMITER ;

-- ----------------------------
-- Auto increment value for `ld_all_in_pay_transaction_detail`
-- ----------------------------
ALTER TABLE `ld_all_in_pay_transaction_detail` AUTO_INCREMENT=2550;

-- ----------------------------
-- Auto increment value for `ld_all_in_pay_withdraw_log`
-- ----------------------------
ALTER TABLE `ld_all_in_pay_withdraw_log` AUTO_INCREMENT=1419;

-- ----------------------------
-- Auto increment value for `ld_bank_info`
-- ----------------------------
ALTER TABLE `ld_bank_info` AUTO_INCREMENT=221;

-- ----------------------------
-- Auto increment value for `ld_borrow_investor`
-- ----------------------------
ALTER TABLE `ld_borrow_investor` AUTO_INCREMENT=1091;

-- ----------------------------
-- Auto increment value for `ld_borrow_plan`
-- ----------------------------
ALTER TABLE `ld_borrow_plan` AUTO_INCREMENT=963;

-- ----------------------------
-- Auto increment value for `ld_cash_account`
-- ----------------------------
ALTER TABLE `ld_cash_account` AUTO_INCREMENT=10;

-- ----------------------------
-- Auto increment value for `ld_cash_account_detail`
-- ----------------------------
ALTER TABLE `ld_cash_account_detail` AUTO_INCREMENT=638;

-- ----------------------------
-- Auto increment value for `ld_cash_log`
-- ----------------------------
ALTER TABLE `ld_cash_log` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `ld_cash_product`
-- ----------------------------
ALTER TABLE `ld_cash_product` AUTO_INCREMENT=2;

-- ----------------------------
-- Auto increment value for `ld_cash_transit`
-- ----------------------------
ALTER TABLE `ld_cash_transit` AUTO_INCREMENT=136;

-- ----------------------------
-- Auto increment value for `ld_check_user_name_log`
-- ----------------------------
ALTER TABLE `ld_check_user_name_log` AUTO_INCREMENT=118;

-- ----------------------------
-- Auto increment value for `ld_ci_product`
-- ----------------------------
ALTER TABLE `ld_ci_product` AUTO_INCREMENT=54;

-- ----------------------------
-- Auto increment value for `ld_ci_product_detail`
-- ----------------------------
ALTER TABLE `ld_ci_product_detail` AUTO_INCREMENT=37;

-- ----------------------------
-- Auto increment value for `ld_ci_si_product`
-- ----------------------------
ALTER TABLE `ld_ci_si_product` AUTO_INCREMENT=49;

-- ----------------------------
-- Auto increment value for `ld_experience_product`
-- ----------------------------
ALTER TABLE `ld_experience_product` AUTO_INCREMENT=7;

-- ----------------------------
-- Auto increment value for `ld_experience_product_detail`
-- ----------------------------
ALTER TABLE `ld_experience_product_detail` AUTO_INCREMENT=10;

-- ----------------------------
-- Auto increment value for `ld_image_config`
-- ----------------------------
ALTER TABLE `ld_image_config` AUTO_INCREMENT=81;

-- ----------------------------
-- Auto increment value for `ld_income_rate`
-- ----------------------------
ALTER TABLE `ld_income_rate` AUTO_INCREMENT=42;

-- ----------------------------
-- Auto increment value for `ld_lucky_draw`
-- ----------------------------
ALTER TABLE `ld_lucky_draw` AUTO_INCREMENT=622;

-- ----------------------------
-- Auto increment value for `ld_mc_refund_detail`
-- ----------------------------
ALTER TABLE `ld_mc_refund_detail` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `ld_mc_transaction_detail`
-- ----------------------------
ALTER TABLE `ld_mc_transaction_detail` AUTO_INCREMENT=151;

-- ----------------------------
-- Auto increment value for `ld_member_bank_card_info`
-- ----------------------------
ALTER TABLE `ld_member_bank_card_info` AUTO_INCREMENT=210;

-- ----------------------------
-- Auto increment value for `ld_member_borrow`
-- ----------------------------
ALTER TABLE `ld_member_borrow` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `ld_member_certificate_check`
-- ----------------------------
ALTER TABLE `ld_member_certificate_check` AUTO_INCREMENT=22;

-- ----------------------------
-- Auto increment value for `ld_member_data_info`
-- ----------------------------
ALTER TABLE `ld_member_data_info` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `ld_member_experience_gold_detail`
-- ----------------------------
ALTER TABLE `ld_member_experience_gold_detail` AUTO_INCREMENT=502;

-- ----------------------------
-- Auto increment value for `ld_member_first_award`
-- ----------------------------
ALTER TABLE `ld_member_first_award` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `ld_member_info`
-- ----------------------------
ALTER TABLE `ld_member_info` AUTO_INCREMENT=1000000275;

-- ----------------------------
-- Auto increment value for `ld_member_login`
-- ----------------------------
ALTER TABLE `ld_member_login` AUTO_INCREMENT=7543;

-- ----------------------------
-- Auto increment value for `ld_member_money_detail`
-- ----------------------------
ALTER TABLE `ld_member_money_detail` AUTO_INCREMENT=4461;

-- ----------------------------
-- Auto increment value for `ld_member_pay`
-- ----------------------------
ALTER TABLE `ld_member_pay` AUTO_INCREMENT=504;

-- ----------------------------
-- Auto increment value for `ld_member_pid_info`
-- ----------------------------
ALTER TABLE `ld_member_pid_info` AUTO_INCREMENT=4;

-- ----------------------------
-- Auto increment value for `ld_member_questionnaire`
-- ----------------------------
ALTER TABLE `ld_member_questionnaire` AUTO_INCREMENT=56;

-- ----------------------------
-- Auto increment value for `ld_member_recommender_detail`
-- ----------------------------
ALTER TABLE `ld_member_recommender_detail` AUTO_INCREMENT=39;

-- ----------------------------
-- Auto increment value for `ld_member_reward`
-- ----------------------------
ALTER TABLE `ld_member_reward` AUTO_INCREMENT=72;

-- ----------------------------
-- Auto increment value for `ld_member_sale_relation`
-- ----------------------------
ALTER TABLE `ld_member_sale_relation` AUTO_INCREMENT=47;

-- ----------------------------
-- Auto increment value for `ld_member_score_detail`
-- ----------------------------
ALTER TABLE `ld_member_score_detail` AUTO_INCREMENT=1673245;

-- ----------------------------
-- Auto increment value for `ld_member_withdraw`
-- ----------------------------
ALTER TABLE `ld_member_withdraw` AUTO_INCREMENT=307;

-- ----------------------------
-- Auto increment value for `ld_members`
-- ----------------------------
ALTER TABLE `ld_members` AUTO_INCREMENT=70000243;

-- ----------------------------
-- Auto increment value for `ld_message_log`
-- ----------------------------
ALTER TABLE `ld_message_log` AUTO_INCREMENT=3456;

-- ----------------------------
-- Auto increment value for `ld_message_template`
-- ----------------------------
ALTER TABLE `ld_message_template` AUTO_INCREMENT=1416;

-- ----------------------------
-- Auto increment value for `ld_mobile_verifycode`
-- ----------------------------
ALTER TABLE `ld_mobile_verifycode` AUTO_INCREMENT=947;

-- ----------------------------
-- Auto increment value for `ld_newhand_product`
-- ----------------------------
ALTER TABLE `ld_newhand_product` AUTO_INCREMENT=9;

-- ----------------------------
-- Auto increment value for `ld_newhand_product_detail`
-- ----------------------------
ALTER TABLE `ld_newhand_product_detail` AUTO_INCREMENT=13;

-- ----------------------------
-- Auto increment value for `ld_news_information`
-- ----------------------------
ALTER TABLE `ld_news_information` AUTO_INCREMENT=334;

-- ----------------------------
-- Auto increment value for `ld_news_notice`
-- ----------------------------
ALTER TABLE `ld_news_notice` AUTO_INCREMENT=45;

-- ----------------------------
-- Auto increment value for `ld_off_product_transaction`
-- ----------------------------
ALTER TABLE `ld_off_product_transaction` AUTO_INCREMENT=1964;

-- ----------------------------
-- Auto increment value for `ld_parameter`
-- ----------------------------
ALTER TABLE `ld_parameter` AUTO_INCREMENT=56;

-- ----------------------------
-- Auto increment value for `ld_pe_product`
-- ----------------------------
ALTER TABLE `ld_pe_product` AUTO_INCREMENT=2;

-- ----------------------------
-- Auto increment value for `ld_pe_product_detail`
-- ----------------------------
ALTER TABLE `ld_pe_product_detail` AUTO_INCREMENT=2;

-- ----------------------------
-- Auto increment value for `ld_pe_product_detail_extend`
-- ----------------------------
ALTER TABLE `ld_pe_product_detail_extend` AUTO_INCREMENT=137;

-- ----------------------------
-- Auto increment value for `ld_pe_product_off_info`
-- ----------------------------
ALTER TABLE `ld_pe_product_off_info` AUTO_INCREMENT=5;

-- ----------------------------
-- Auto increment value for `ld_pe_product_risk`
-- ----------------------------
ALTER TABLE `ld_pe_product_risk` AUTO_INCREMENT=31;

-- ----------------------------
-- Auto increment value for `ld_product_appointment_info`
-- ----------------------------
ALTER TABLE `ld_product_appointment_info` AUTO_INCREMENT=28;

-- ----------------------------
-- Auto increment value for `ld_product_extend_info`
-- ----------------------------
ALTER TABLE `ld_product_extend_info` AUTO_INCREMENT=15;

-- ----------------------------
-- Auto increment value for `ld_repayement_detail`
-- ----------------------------
ALTER TABLE `ld_repayement_detail` AUTO_INCREMENT=2016;

-- ----------------------------
-- Auto increment value for `ld_repayment_record`
-- ----------------------------
ALTER TABLE `ld_repayment_record` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `ld_reward_code`
-- ----------------------------
ALTER TABLE `ld_reward_code` AUTO_INCREMENT=5;

-- ----------------------------
-- Auto increment value for `ld_reward_record`
-- ----------------------------
ALTER TABLE `ld_reward_record` AUTO_INCREMENT=694;

-- ----------------------------
-- Auto increment value for `ld_reward_type`
-- ----------------------------
ALTER TABLE `ld_reward_type` AUTO_INCREMENT=5;

-- ----------------------------
-- Auto increment value for `ld_sale_proxy_borrow_invest`
-- ----------------------------
ALTER TABLE `ld_sale_proxy_borrow_invest` AUTO_INCREMENT=6;

-- ----------------------------
-- Auto increment value for `ld_sale_proxy_members`
-- ----------------------------
ALTER TABLE `ld_sale_proxy_members` AUTO_INCREMENT=6;

-- ----------------------------
-- Auto increment value for `ld_sale_proxy_merchant`
-- ----------------------------
ALTER TABLE `ld_sale_proxy_merchant` AUTO_INCREMENT=2;

-- ----------------------------
-- Auto increment value for `ld_sale_proxy_product`
-- ----------------------------
ALTER TABLE `ld_sale_proxy_product` AUTO_INCREMENT=3;

-- ----------------------------
-- Auto increment value for `ld_sb_product_off_info`
-- ----------------------------
ALTER TABLE `ld_sb_product_off_info` AUTO_INCREMENT=22;

-- ----------------------------
-- Auto increment value for `ld_si_product`
-- ----------------------------
ALTER TABLE `ld_si_product` AUTO_INCREMENT=178;

-- ----------------------------
-- Auto increment value for `ld_si_product_detail`
-- ----------------------------
ALTER TABLE `ld_si_product_detail` AUTO_INCREMENT=151;

-- ----------------------------
-- Auto increment value for `ld_si_risk_image_config`
-- ----------------------------
ALTER TABLE `ld_si_risk_image_config` AUTO_INCREMENT=18;

-- ----------------------------
-- Auto increment value for `ld_user_operator_log`
-- ----------------------------
ALTER TABLE `ld_user_operator_log` AUTO_INCREMENT=37035;

-- ----------------------------
-- Auto increment value for `ld_user_sign_in_log`
-- ----------------------------
ALTER TABLE `ld_user_sign_in_log` AUTO_INCREMENT=277;

-- ----------------------------
-- Auto increment value for `ld_user_signature_log`
-- ----------------------------
ALTER TABLE `ld_user_signature_log` AUTO_INCREMENT=362;

-- ----------------------------
-- Auto increment value for `ld_yingxiang_product`
-- ----------------------------
ALTER TABLE `ld_yingxiang_product` AUTO_INCREMENT=201;

-- ----------------------------
-- Auto increment value for `ld_yingxiang_product_detail`
-- ----------------------------
ALTER TABLE `ld_yingxiang_product_detail` AUTO_INCREMENT=175;

-- ----------------------------
-- Auto increment value for `rebate_product`
-- ----------------------------
ALTER TABLE `rebate_product` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `rebate_product_detail`
-- ----------------------------
ALTER TABLE `rebate_product_detail` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `t_relation`
-- ----------------------------
ALTER TABLE `t_relation` AUTO_INCREMENT=49725;

-- ----------------------------
-- Auto increment value for `t_resource`
-- ----------------------------
ALTER TABLE `t_resource` AUTO_INCREMENT=1198;

-- ----------------------------
-- Auto increment value for `t_role`
-- ----------------------------
ALTER TABLE `t_role` AUTO_INCREMENT=31;

-- ----------------------------
-- Auto increment value for `t_user`
-- ----------------------------
ALTER TABLE `t_user` AUTO_INCREMENT=6;
