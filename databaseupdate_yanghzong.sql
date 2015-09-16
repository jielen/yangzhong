
--20150908
--1.
insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_PITEM_OPIWAY', '7', '在线竞价', 32, null, 'N', to_date('11-09-2015 23:11:43', 'dd-mm-yyyy hh24:mi:ss'));
--2
insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_ZC_EB_BULLETIN_TYPE', 'zhaobiao_zxjj', '在线竞价招标公告', 13, null, 'Y', to_date('15-09-2015 15:19:57', 'dd-mm-yyyy hh24:mi:ss'));

--3

create table ZC_EB_ZXJJ
(
  proj_code     VARCHAR2(60),
  pack_code     VARCHAR2(60),
  co_code       VARCHAR2(60),
  pur_content   VARCHAR2(200),
  begin_time    DATE,
  jj_time_len   NUMBER,
  jj_all_rounds NUMBER,
  jj_cur_round  NUMBER,
  status        VARCHAR2(60),
  remark        VARCHAR2(600),
  fail_reason   VARCHAR2(600),
  jj_code       VARCHAR2(60) not null,
  jj_cur_quote  NUMBER,
  jj_cur_quoter VARCHAR2(60),
  inputor       VARCHAR2(60),
  input_date    DATE
)
tablespace UFGOV
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table ZC_EB_ZXJJ
  is '在线竞价';
-- Add comments to the columns 
comment on column ZC_EB_ZXJJ.proj_code
  is '采购编号';
comment on column ZC_EB_ZXJJ.pack_code
  is '分包编号';
comment on column ZC_EB_ZXJJ.co_code
  is '采购单位代码';
comment on column ZC_EB_ZXJJ.pur_content
  is '采购内容';
comment on column ZC_EB_ZXJJ.begin_time
  is '竞价开始时间';
comment on column ZC_EB_ZXJJ.jj_time_len
  is '每轮竞价时长';
comment on column ZC_EB_ZXJJ.jj_all_rounds
  is '竞价轮数';
comment on column ZC_EB_ZXJJ.jj_cur_round
  is '当前轮次';
comment on column ZC_EB_ZXJJ.status
  is '状态 等待开始/竞价中/等待下轮/竞价结束/废标';
comment on column ZC_EB_ZXJJ.remark
  is '备注';
comment on column ZC_EB_ZXJJ.fail_reason
  is '废标原因';
comment on column ZC_EB_ZXJJ.jj_code
  is '竞价编号';
comment on column ZC_EB_ZXJJ.jj_cur_quote
  is '最低价';
comment on column ZC_EB_ZXJJ.jj_cur_quoter
  is '报价人';
comment on column ZC_EB_ZXJJ.inputor
  is '录入人';
comment on column ZC_EB_ZXJJ.input_date
  is '录入时间';
-- Create/Recreate primary, unique and foreign key constraints 
alter table ZC_EB_ZXJJ
  add constraint ZC_EB_ZXJJ_PK primary key (JJ_CODE)
  using index 
  tablespace UFGOV
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

--4
-- Create table
create table ZC_EB_ZXJJ_HISTORY
(
  jj_code       VARCHAR2(60),
  jj_round      NUMBER,
  jj_quote      NUMBER,
  jj_quoter     VARCHAR2(60),
  jj_quote_time DATE,
  is_win        VARCHAR2(10)
)
tablespace UFGOV
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table ZC_EB_ZXJJ_HISTORY
  is '在线竞价历史';
-- Add comments to the columns 
comment on column ZC_EB_ZXJJ_HISTORY.jj_code
  is '竞价编号';
comment on column ZC_EB_ZXJJ_HISTORY.jj_round
  is '竞价轮次';
comment on column ZC_EB_ZXJJ_HISTORY.jj_quote
  is '报价';
comment on column ZC_EB_ZXJJ_HISTORY.jj_quoter
  is '报价人';
comment on column ZC_EB_ZXJJ_HISTORY.jj_quote_time
  is '报价时间';
comment on column ZC_EB_ZXJJ_HISTORY.is_win
  is '是否中标';

--5
-- Create sequence 
create sequence ZC_SEQ_ZXJJ_CODE
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
cache 5;

--6

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ', 'C', '在线竞价');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_BEGIN_TIME', 'C', '竞价开始时间');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_CO_CODE', 'C', '采购单位');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_FAIL_REASON', 'C', '废标原因');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_INPUTOR', 'C', '录入人');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_INPUT_DATE', 'C', '录入时间');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_JJ_ALL_ROUNDS', 'C', '竞价轮数');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_JJ_CODE', 'C', '竞价编号');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_JJ_CUR_QUOTE', 'C', '最低价');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_JJ_CUR_QUOTER', 'C', '报价人');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_JJ_CUR_ROUND', 'C', '当前轮次');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_JJ_TIME_LEN', 'C', '每轮竞价时长');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_PACK_CODE', 'C', '分包编号');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_PROJ_CODE', 'C', '采购编号');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_PUR_CONTENT', 'C', '采购内容');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_REMARK', 'C', '备注');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_STATUS', 'C', '状态');

--7

insert into as_table (TAB_ID, MASTER_TAB_ID, TAB_NA, TAB_DESC, DB_VER_NO, TRAD_VER_NO, LSTDATE, PRE_VALSET, IS_TABLE)
values ('ZC_EB_ZXJJ', null, '在线竞价', '在线竞价', null, null, null, null, 'Y');

insert into as_table (TAB_ID, MASTER_TAB_ID, TAB_NA, TAB_DESC, DB_VER_NO, TRAD_VER_NO, LSTDATE, PRE_VALSET, IS_TABLE)
values ('ZC_EB_ZXJJ_HISTORY', 'ZC_EB_ZXJJ', '在线竞价历史', '在线竞价历史', null, null, null, null, 'Y');

--8


insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'BEGIN_TIME', 0, '竞价开始时间', '竞价开始时间', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'CO_CODE', 0, '采购单位代码', '采购单位代码', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'FAIL_REASON', 0, '废标原因', '废标原因', 'VARCHAR2', 600, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'INPUTOR', 0, '录入人', '录入人', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'INPUT_DATE', 0, '录入时间', '录入时间', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'JJ_ALL_ROUNDS', 0, '竞价轮数', '竞价轮数', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'JJ_CODE', 0, '竞价编号', '竞价编号', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'N', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'JJ_CUR_QUOTE', 0, '最低价', '最低价', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'JJ_CUR_QUOTER', 0, '报价人', '报价人', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'JJ_CUR_ROUND', 0, '当前轮次', '当前轮次', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'JJ_TIME_LEN', 0, '每轮竞价时长', '每轮竞价时长', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'PACK_CODE', 0, '分包编号', '分包编号', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'PROJ_CODE', 0, '采购编号', '采购编号', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'PUR_CONTENT', 0, '采购内容', '采购内容', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'REMARK', 0, '备注', '备注', 'VARCHAR2', 600, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'STATUS', 0, '状态 等待开始/竞价中/等待下轮/竞价结束/废标', '状态 等待开始/竞价中/等待下轮/竞价结束/废标', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

--9

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ_HISTORY', 'IS_WIN', 0, '是否中标', '是否中标', 'VARCHAR2', 10, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ_HISTORY', 'JJ_CODE', 0, '竞价编号', '竞价编号', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ_HISTORY', 'JJ_QUOTE', 0, '报价', '报价', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ_HISTORY', 'JJ_QUOTER', 0, '报价人', '报价人', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ_HISTORY', 'JJ_QUOTE_TIME', 0, '报价时间', '报价时间', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ_HISTORY', 'JJ_ROUND', 0, '竞价轮次', '竞价轮次', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

--10
insert into as_compo (COMPO_ID, COMPO_NAME, MASTER_TAB_ID, TRAD_ID, COMPO_TYPE, ICON_NAME, CONDITION, NO_FIELD, TYPE_FIELD, TYPE_TABLE, PARENT_COMPO, PAGE_FIELD, DATE_FIELD, VALSET_FIELD, WF_FLOW_TYPE, WF_LIST_TYPE, DEFAULT_WF_TEMPLATE, TEMPLATE_IS_USED, IS_AUTO_LIST, ORDER_BY, IS_GRANT_TO_ALL, PRINT_TYPE, TITLE_FIELD, TITLE_DATE, WF_BRIEF_FIELDS, IS_FUNC_CONTROL)
values ('ZC_EB_ZXJJ', '在线竞价', 'ZC_EB_ZXJJ', null, 'M', null, null, null, null, null, null, null, null, null, 'workflow', 'WF_FILTER_COMPO_TODO', '10264', 'Y', 'Y', 'JJ_CODE', null, '0', 'PROJ_CODE', null, 'PROJ_CODE', 'ZC');

--11

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_ZXJJ', 'fcallback', 'Y', null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_ZXJJ', 'fdelete', 'Y', null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_ZXJJ', 'fedit', 'Y', null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_ZXJJ', 'fexit', null, null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_ZXJJ', 'fmanualcommit', 'Y', null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_ZXJJ', 'fnew', null, null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_ZXJJ', 'fnewcommit', 'Y', null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_ZXJJ', 'fprint', 'Y', null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_ZXJJ', 'fprint_preview', null, null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_ZXJJ', 'fprn_tpl_set', null, null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_ZXJJ', 'fsave', 'Y', null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_ZXJJ', 'fshowinstancetrace', null, null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_ZXJJ', 'funaudit', 'Y', null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_ZXJJ', 'funtread', 'Y', null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_ZXJJ', 'fwatch', null, null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_ZXJJ', 'fjjbj', 'Y', null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_ZXJJ', 'fjjstart', 'Y', null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_ZXJJ', 'fjjbjcancel', 'Y', null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_ZXJJ', 'fjjfail', 'Y', null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

--12

insert into as_func (FUNC_ID, FUNC_DESC, ORD_INDEX, IS_GRANT_TO_ALL, IS_LIST, SHORTCUT_KEY, IS_CTRL, IS_SHIFT, IS_ALT)
values ('fjjbj', '报价', 48, null, 'N', null, null, null, null);

insert into as_func (FUNC_ID, FUNC_DESC, ORD_INDEX, IS_GRANT_TO_ALL, IS_LIST, SHORTCUT_KEY, IS_CTRL, IS_SHIFT, IS_ALT)
values ('fjjstart', '开始', 48, null, 'N', null, null, null, null);

insert into as_func (FUNC_ID, FUNC_DESC, ORD_INDEX, IS_GRANT_TO_ALL, IS_LIST, SHORTCUT_KEY, IS_CTRL, IS_SHIFT, IS_ALT)
values ('fjjbjcancel', '收回报价', 48, null, 'N', null, null, null, null);

insert into as_func (FUNC_ID, FUNC_DESC, ORD_INDEX, IS_GRANT_TO_ALL, IS_LIST, SHORTCUT_KEY, IS_CTRL, IS_SHIFT, IS_ALT)
values ('fjjfail', '废标', 48, null, 'N', null, null, null, null);

--13

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('fjjbj', 'C', '报价');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('fjjstart', 'C', '开始');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('fjjbjcancel', 'C', '收回报价');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('fjjfail', 'C', '废标');

--14

insert into ZC_SEARCH_CONDITION (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbZxjj_Tab', 'all', '查看全部', 7, 'ZC_EB_ZXJJ', null, '在线竞价页签', 'tab', '301');

insert into ZC_SEARCH_CONDITION (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbZxjj_Tab', 'wait', '未开始', 1, 'ZC_EB_ZXJJ', null, '在线竞价页签', 'tab', '301');

insert into ZC_SEARCH_CONDITION (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbZxjj_Tab', 'quoting', '竞价中', 2, 'ZC_EB_ZXJJ', null, '在线竞价页签', 'tab', '301');

insert into ZC_SEARCH_CONDITION (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbZxjj_Tab', 'complete', '竞价结束', 3, 'ZC_EB_ZXJJ', null, '在线竞价页签', 'tab', '301');

--15

insert into ZC_SYS_BILL_ELEMENT (ELEMENT_ID, ND, BILL_TYPE_CODE, ELEMENT_CODE, ELEMENT_NAME, IS_INCLUDE, IS_INHERIT, INHERIT_ELEMENT_CODE, INHERIT_ELEMENT_NAME, IS_EDIT, IS_RANDOM_EDIT, DEC_FLAG, LEVEL_CTRL, IS_EDIT_PUTIN, IS_EDIT_AUDIT, IS_CONFIG, DEFAULT_VAL_CODE, DEFAULT_VAL_NAME, IS_NULL, PARENT_LEVEL_CTRL, EXTEND_ELEMENT_TYPE, LEVEL_STR, DISPLAY_ORDER_INDEX, GENBALANCE_LEVEL_CTRL)
values ('ZC_EB_ZXJJ_BEGIN_TIME', 9999, 'ZC_EB_ZXJJ', 'BEGIN_TIME', '竞价开始时间', '1', '0', null, null, '1', '1', '0', 0, '0', '0', '1', null, null, '0', 0, '1', '1', 1, 0);

insert into ZC_SYS_BILL_ELEMENT (ELEMENT_ID, ND, BILL_TYPE_CODE, ELEMENT_CODE, ELEMENT_NAME, IS_INCLUDE, IS_INHERIT, INHERIT_ELEMENT_CODE, INHERIT_ELEMENT_NAME, IS_EDIT, IS_RANDOM_EDIT, DEC_FLAG, LEVEL_CTRL, IS_EDIT_PUTIN, IS_EDIT_AUDIT, IS_CONFIG, DEFAULT_VAL_CODE, DEFAULT_VAL_NAME, IS_NULL, PARENT_LEVEL_CTRL, EXTEND_ELEMENT_TYPE, LEVEL_STR, DISPLAY_ORDER_INDEX, GENBALANCE_LEVEL_CTRL)
values ('ZC_EB_ZXJJ_JJ_TIME_LEN', 9999, 'ZC_EB_ZXJJ', 'JJ_TIME_LEN', '每轮竞价时长', '1', '0', null, null, '1', '1', '0', 0, '0', '0', '1', null, null, '0', 0, '1', '1', 1, 0);

insert into ZC_SYS_BILL_ELEMENT (ELEMENT_ID, ND, BILL_TYPE_CODE, ELEMENT_CODE, ELEMENT_NAME, IS_INCLUDE, IS_INHERIT, INHERIT_ELEMENT_CODE, INHERIT_ELEMENT_NAME, IS_EDIT, IS_RANDOM_EDIT, DEC_FLAG, LEVEL_CTRL, IS_EDIT_PUTIN, IS_EDIT_AUDIT, IS_CONFIG, DEFAULT_VAL_CODE, DEFAULT_VAL_NAME, IS_NULL, PARENT_LEVEL_CTRL, EXTEND_ELEMENT_TYPE, LEVEL_STR, DISPLAY_ORDER_INDEX, GENBALANCE_LEVEL_CTRL)
values ('ZC_EB_ZXJJ_JJ_ALL_ROUNDS', 9999, 'ZC_EB_ZXJJ', 'JJ_ALL_ROUNDS', '竞价轮数', '1', '0', null, null, '1', '1', '0', 0, '0', '0', '1', null, null, '0', 0, '1', '1', 1, 0);

--16

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_ZXJJ_STATUS', '0', '等待开始', 0, null, 'Y', to_date('16-09-2015 04:27:36', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_ZXJJ_STATUS', '1', '竞价中', 5, null, 'Y', to_date('16-09-2015 04:27:36', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_ZXJJ_STATUS', '2', '等待下轮', 10, null, 'Y', to_date('16-09-2015 04:27:36', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_ZXJJ_STATUS', '3', '竞价结束', 15, null, 'Y', to_date('16-09-2015 04:27:36', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_ZXJJ_STATUS', '4', '废标', 20, null, 'Y', to_date('16-09-2015 04:27:36', 'dd-mm-yyyy hh24:mi:ss'));

--17
alter table ZC_EB_ZXJJ add process_inst_id number;

--18

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_HISTORY_IS_WIN', 'C', '是否中标');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_HISTORY_JJ_CODE', 'C', '竞价编号');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_HISTORY_JJ_QUOTE', 'C', '报价');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_HISTORY_JJ_QUOTER', 'C', '报价人');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_HISTORY_JJ_QUOTE_TIME', 'C', '报价时间');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_HISTORY_JJ_ROUND', 'C', '竞价轮次');

--19
-- Add/modify columns 
alter table ZC_EB_ZXJJ add nd VARCHAR2(10);
-- Add comments to the columns 
comment on column ZC_EB_ZXJJ.nd
  is '年度';
--20
insert into AS_MENU_COMPO (MENU_ID, COMPO_ID, ORD_INDEX, IS_GOTO_EDIT, IS_IN_MENU, IS_ALWAYS_NEW, URL)
values ('ZC_EB_BID', 'ZC_EB_ZXJJ', 5, 'N', 'Y', 'N', '/GB/jsp/ZC/CommonPage.jsp?className=com.ufgov.zc.client.zc.zxjj.ZcEbZxjjListPanel');

insert into AP_MENU_COMPO (MENU_ID, COMPO_ID, COMPO_NAME, ORD_INDEX, IS_GOTO_EDIT, IS_ALWAYS_NEW, IS_IN_MENU, URL)
values ('ZC_KBGL', 'ZC_EB_ZXJJ', '在线竞价', 1, 'N', 'N', 'Y', '/GB/jsp/ZC/CommonPage.jsp?className=com.ufgov.zc.client.zc.zxjj.ZcEbZxjjListPanel');




--20131125
--1.
update as_option o set o.opt_val='N' where o.opt_id='OPT_ZC_USE_BUDGET_INTERFACE';

--2.
delete from as_option o where o.opt_id='ZC_OPTON_JIHUA_ZIJIN_HELP_MSG' ;

insert into as_option (OPT_ID, CO_CODE, COMPO_ID, TRANS_TYPE, OPT_VAL, IS_SYST_OPT)
values ('ZC_OPTON_JIHUA_ZIJIN_HELP_MSG', '*', '*', '*', '<html>采购资金可以使用：<strong>财政资金</strong>和<strong>自筹资金</strong>。<br>1.<strong>财政资金</strong>指财政预算指标，使用财政资金时，需要登记指标相关信息.<br>2.<strong>自筹资金</strong>指采购单位自行准备的资金，不需要通过财政国库支付，直接在<font color=red><strong>本次采购使用金额(元)</strong></font>填写金额即可.</html>', 'Y');

--3.

delete from as_val v where v.valset_id='ZC_VS_FUND_NAME';

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_FUND_NAME', '0', '自筹资金', 99, null, 'N', to_date('09-07-2013 15:56:26', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_FUND_NAME', '1', '预算指标', 1, null, 'N', to_date('25-11-2013 13:51:25', 'dd-mm-yyyy hh24:mi:ss'));

--20131126
--1.
delete from as_val v where v.valset_id like 'ZC_VS_MAKE_STATUS';

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_MAKE_STATUS', '0', '采购计划编报', 1, null, 'N', to_date('26-11-2013 09:10:41', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_MAKE_STATUS', '5', '采购科审核1', 4, null, 'N', to_date('26-11-2013 09:10:41', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_MAKE_STATUS', '10', '采购科审核2', 6, null, 'N', to_date('26-11-2013 09:10:41', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_MAKE_STATUS', '15', '采购中心审核', 8, null, 'N', to_date('26-11-2013 09:10:41', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_MAKE_STATUS', 'cancel', '作废', 20, null, 'N', to_date('23-06-2013 19:36:03', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_MAKE_STATUS', 'exec', '终审', 22, null, 'N', to_date('23-06-2013 19:36:03', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_MAKE_STATUS', 'jingjiaing', '正在竞价', 220, null, 'N', to_date('23-06-2013 19:36:03', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_MAKE_STATUS', 'yjx', '已结项', 200, null, 'N', to_date('23-06-2013 19:36:03', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_MAKE_STATUS', 'yjz', '已结转', 210, null, 'N', to_date('23-06-2013 19:36:03', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_MAKE_STATUS', 'zhongbiao', '确认中标供应商', 220, null, 'N', to_date('23-06-2013 19:36:03', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_MAKE_STATUS', '2', '采购单位审核', 2, null, 'N', to_date('06-11-2013 16:57:45', 'dd-mm-yyyy hh24:mi:ss'));

--2.
insert into ma_company (CO_CODE, CO_TYPE_CODE, GB_CODE, CO_NAME, CO_FULLNA, QUIC_CODE, MARK, POST_CODE, COMM_ADDR, ADDRESS, URL, LINK_MAN, CO_CLERK, CO_LEADER, FI_LEADER, LOCA_TELE, DIRECTOR_CODE, PARENT_CO_CODE, F_CO_CODE, IS_USED, F_ORG_CODE, IS_SELF, BANK_ACC, SHOP_CARD_NO, CORP_REPR, TRADE_NAME, COUNTRY, PROVINCE, CITY, REAL_CO_CODE, IS_LOWEST, ND, FINA_LEVEL, CO_KIND, IS_PILOT, IS_NEED_SEND_BANK, REGION_CODE, TRANS_DATE, IS_NEED_SEND_BANK_SL, CO_TYPE_CODE_1, CAN_GETBILL, GETBILL_ID, CAN_CHARGE, TURN_IN_ACCT, NT_ACC_ID, NT_ACC_NAME, NT_HESUAN_CO_CODE, GUID, TRIGGER_ENABLE, PR_BI_COCODE)
values ('040009', '02', null, '采购中心', '采购中心', null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'Y', '600', 'N', null, null, null, null, null, '*', '*', null, 'Y', 2013, '01', null, null, null, null, to_date('12-03-2013 15:46:52', 'dd-mm-yyyy hh24:mi:ss'), 'N', null, 'Y', null, 'Y', null, null, null, null, '4CEABDEE0E0A4DFFAABF7275E7BF52DE', 1, null);

--3.
insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CGZX_KZ_ZH', 'ZcPProMake_entrustTab', 'all');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CGZX_KZ_ZH', 'ZcPProMake_entrustTab', 'done');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CGZX_KZ_ZH', 'ZcPProMake_entrustTab', 'exec');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CGZX_KZ_ZH', 'ZcPProMake_entrustTab', 'todo');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CGZX_KZ_ZH', 'ZcPProMake_entrustTab', 'untread');

--4.
delete from AS_NO_RULE    where COMPO_ID = 'ZC_P_PRO_MAKE';

insert into AS_NO_RULE (COMPO_ID, RULE_CODE, RULE_NAME, NO_PREFIX, NO_INDEX_LEN, IS_CONT, NUM_TOOL_ID, NO_FIELD, IS_INCL_ATOZ, IS_FILL_ZERO, NO_AFTFIX, TRANS_DATE)
values ('ZC_P_PRO_MAKE', 'ZC_MAKE_CODE', '采购编号计划', '扬财采计[', 4, 'Y', 'ZC_MAKE_CODE_GEN', 'ZC_MAKE_CODE', null, 'Y', '号', to_date('26-11-2013 10:56:44', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_NO_RULE (COMPO_ID, RULE_CODE, RULE_NAME, NO_PREFIX, NO_INDEX_LEN, IS_CONT, NUM_TOOL_ID, NO_FIELD, IS_INCL_ATOZ, IS_FILL_ZERO, NO_AFTFIX, TRANS_DATE)
values ('ZC_P_PRO_MAKE', 'ZC_MAKE_CODE_DZJJ', '电子竞价采购编号计划', '扬财采计[', 4, 'Y', 'ZC_MAKE_CODE_DZJJ_GEN', 'ZC_MAKE_CODE_DZJJ', null, 'Y', '号', to_date('26-11-2013 10:56:44', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_NO_RULE (COMPO_ID, RULE_CODE, RULE_NAME, NO_PREFIX, NO_INDEX_LEN, IS_CONT, NUM_TOOL_ID, NO_FIELD, IS_INCL_ATOZ, IS_FILL_ZERO, NO_AFTFIX, TRANS_DATE)
values ('ZC_P_PRO_MAKE', 'ZC_MAKE_CODE_XY', '协议采购编号计划', '扬财采计[', 4, 'Y', 'ZC_MAKE_CODE_XY_GEN', 'ZC_MAKE_CODE_XY', null, 'Y', '号', to_date('26-11-2013 10:56:44', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_NO_RULE (COMPO_ID, RULE_CODE, RULE_NAME, NO_PREFIX, NO_INDEX_LEN, IS_CONT, NUM_TOOL_ID, NO_FIELD, IS_INCL_ATOZ, IS_FILL_ZERO, NO_AFTFIX, TRANS_DATE)
values ('ZC_P_PRO_MAKE', 'ZC_TEMP_MAKE_CODE', '采购临时编号计划', '扬财采计[', 4, 'Y', 'ZC_TEMP_MAKE_CODE_GEN', 'ZC_TEMP_MAKE_CODE', null, 'Y', '号', to_date('26-11-2013 10:56:44', 'dd-mm-yyyy hh24:mi:ss'));

--5.
delete from as_option o where o.opt_id='OPT_ZC_CGZX_CODE' ;

insert into as_option (OPT_ID, CO_CODE, COMPO_ID, TRANS_TYPE, OPT_VAL, IS_SYST_OPT)
values ('OPT_ZC_CGZX_CODE', '*', '*', '*', '040009', 'Y');

--6
delete from  as_val v where v.valset_id like '%ZC_VS_AUDIT_SHEET_STATUS%';

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_AUDIT_SHEET_STATUS', '0', '编辑', 0, null, 'Y', to_date('23-06-2013 19:36:03', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_AUDIT_SHEET_STATUS', '1', '主任审核', 2, null, 'Y', to_date('11-07-2013 22:36:20', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_AUDIT_SHEET_STATUS', '3', '经办人接收', 4, null, 'Y', to_date('26-11-2013 16:11:18', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_AUDIT_SHEET_STATUS', 'exec', '招标中', 5, null, 'Y', to_date('11-07-2013 22:36:20', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_AUDIT_SHEET_STATUS', '2', '组长审核', 3, null, 'Y', to_date('26-11-2013 16:11:18', 'dd-mm-yyyy hh24:mi:ss'));

--7
delete from as_lang_trans l where l.res_id='ZC_FIELD_SUPERINTENDENT_ORG';
insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_FIELD_SUPERINTENDENT_ORG', 'C', '项目负责组');

--8
insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KZ_CG', 'ZC_EB_AUDIT_SHEET', 'fcallback', to_date('17-07-2013 21:36:32', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KZ_CG', 'ZC_EB_AUDIT_SHEET', 'fnewcommit', to_date('17-07-2013 21:36:32', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KZ_CG', 'ZC_EB_AUDIT_SHEET', 'fquote', to_date('17-07-2013 21:36:32', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KZ_CG', 'ZC_EB_AUDIT_SHEET', 'fsave', to_date('17-07-2013 21:36:32', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KZ_CG', 'ZC_EB_AUDIT_SHEET', 'fshowinstancetrace', to_date('17-07-2013 21:36:32', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KZ_CG', 'ZC_EB_AUDIT_SHEET', 'fwatch', to_date('17-07-2013 21:36:32', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KZ_CG', 'ZC_EB_AUDIT_SHEET', 'fmanualcommit', to_date('17-07-2013 21:36:32', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KZ_ZH', 'ZC_EB_AUDIT_SHEET', 'fcallback', to_date('17-07-2013 21:36:32', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KZ_ZH', 'ZC_EB_AUDIT_SHEET', 'fnewcommit', to_date('17-07-2013 21:36:32', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KZ_ZH', 'ZC_EB_AUDIT_SHEET', 'fquote', to_date('17-07-2013 21:36:32', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KZ_ZH', 'ZC_EB_AUDIT_SHEET', 'fsave', to_date('17-07-2013 21:36:32', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KZ_ZH', 'ZC_EB_AUDIT_SHEET', 'fshowinstancetrace', to_date('17-07-2013 21:36:32', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KZ_ZH', 'ZC_EB_AUDIT_SHEET', 'fwatch', to_date('17-07-2013 21:36:32', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KZ_ZH', 'ZC_EB_AUDIT_SHEET', 'fmanualcommit', to_date('17-07-2013 21:36:32', 'dd-mm-yyyy hh24:mi:ss'));

--9
delete from as_menu_compo m where m.compo_id like 'ZC_EB_AUDIT_SHEET';

insert into as_menu_compo (MENU_ID, COMPO_ID, ORD_INDEX, IS_GOTO_EDIT, IS_IN_MENU, IS_ALWAYS_NEW, URL)
values ('GRP_GFI_EM_EXPERT', 'ZC_EB_AUDIT_SHEET', 502, 'N', 'Y', 'N', '/GB/jsp/ZC/CommonPage.jsp?className=com.ufgov.zc.client.zc.auditsheet.ZcEbAuditSheetListPanelExtends');

delete from ap_menu_compo m where m.compo_id like 'ZC_EB_AUDIT_SHEET';
insert into ap_menu_compo (MENU_ID, COMPO_ID, COMPO_NAME, ORD_INDEX, IS_GOTO_EDIT, IS_ALWAYS_NEW, IS_IN_MENU, URL)
values ('ZC_CGRWGL', 'ZC_EB_AUDIT_SHEET', '批办单', 2, 'N', 'N', 'Y', '/GB/jsp/ZC/CommonPage.jsp?className=com.ufgov.zc.client.zc.auditsheet.ZcEbAuditSheetListPanelExtends');

--10
DELETE from AS_NO_RULE    where COMPO_ID = 'ZC_EB_PROJ';

insert into AS_NO_RULE (COMPO_ID, RULE_CODE, RULE_NAME, NO_PREFIX, NO_INDEX_LEN, IS_CONT, NUM_TOOL_ID, NO_FIELD, IS_INCL_ATOZ, IS_FILL_ZERO, NO_AFTFIX, TRANS_DATE)
values ('ZC_EB_PROJ', 'PROJ_CODE', '立项分包', 'YZCG', 4, 'Y', 'ZC_EB_PROJ_GEN', 'PROJ_CODE', null, 'Y', null, to_date('26-11-2013 23:59:12', 'dd-mm-yyyy hh24:mi:ss'));

--11
delete from ZC_B_AGENCY;

insert into ZC_B_AGENCY (ZC_AGEY_CODE, ZC_AGEY_NAME, ZC_AGEY_JGDM, ZC_AGEY_ADDR, ZC_AGEY_ZIP, ZC_AGEY_LINKMAN, ZC_AGEY_TEL, ZC_AGEY_TYPE, ZC_RANDOM_ID, ZC_INPUT_EMP_CODE, ZC_INPUT_DATE, ZC_INPUT_EMP_NAME, ZC_AUDIT_EMP_CODE, ZC_AUDIT_DATE, ZC_AUDIT_EMP_NAME, ZC_STAT_CODE, ZC_DIYU_DAIMA, ZC_ORDER_INDEX, START_TIME, END_TIME)
values ('040009', '扬中市政府采购中心', null, '江苏省扬中市扬子中路168号', '212299', null, '0511-88361205,88358235', '2', null, null, null, null, null, null, null, '1', null, 1, null, null);

--12
delete from as_val v where v.val like 'VS_ZC_OPEN_ADDRESS';

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_ZC_OPEN_ADDRESS', '江苏省扬中市扬子中路168号 1会议室', '江苏省扬中市扬子中路168号 1会议室', null, null, 'Y', to_date('27-11-2013 01:27:56', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_ZC_OPEN_ADDRESS', '江苏省扬中市扬子中路168号 2会议室', '江苏省扬中市扬子中路168号 2会议室', null, null, 'Y', to_date('27-11-2013 01:27:56', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_ZC_OPEN_ADDRESS', '江苏省扬中市扬子中路168号 3会议室', '江苏省扬中市扬子中路168号 3会议室', null, null, 'Y', to_date('27-11-2013 01:27:56', 'dd-mm-yyyy hh24:mi:ss'));

--13
insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_PROJ_STATUS', '80', '采购办审核', 7, null, 'N', to_date('27-11-2013 01:38:33', 'dd-mm-yyyy hh24:mi:ss'));

--14
delete from as_val v where v.valset_id='VS_ZC_EB_MEMBER_TYPE';

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_ZC_EB_MEMBER_TYPE', '4', '采购单位代表', 4, null, 'Y', to_date('01-01-2014 13:46:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_ZC_EB_MEMBER_TYPE', '5', '监督人员', 5, null, 'Y', to_date('01-01-2014 13:46:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_ZC_EB_MEMBER_TYPE', '1', '主持人', 1, null, 'Y', to_date('01-01-2014 13:46:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_ZC_EB_MEMBER_TYPE', '2', '唱标人', 2, null, 'Y', to_date('01-01-2014 13:46:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_ZC_EB_MEMBER_TYPE', '3', '记录人', 3, null, 'Y', to_date('01-01-2014 13:46:42', 'dd-mm-yyyy hh24:mi:ss'));

--15
insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_ZC_EB_EVAL_COMPLIANCE_RESULT', 'N', '不通过', 2, null, 'N', to_date('31-12-2013 16:17:55', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_ZC_EB_EVAL_COMPLIANCE_RESULT', 'Y', '通过', 1, null, 'N', to_date('31-12-2013 16:17:55', 'dd-mm-yyyy hh24:mi:ss'));

--16
-- Add/modify columns 
alter table ZC_EB_EVAL_REPORT add executor_name VARCHAR2(200);
-- Add comments to the columns 
comment on column ZC_EB_EVAL_REPORT.executor_name
  is '执行者名称';

--20131128
--1
insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CSZGY', 'ZcXmcgHt_entrustTab', 'draft');

--2
insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HT_STATUS', '6', '采购办审核', 5, null, 'Y', to_date('28-11-2013 14:13:43', 'dd-mm-yyyy hh24:mi:ss'));

--3
insert into AS_OPTION (OPT_ID, CO_CODE, COMPO_ID, TRANS_TYPE, OPT_VAL, IS_SYST_OPT)
values ('OPT_ZC_CREATE_HT_BY_CGZX', '*', '*', '*', 'Y', 'N');

--4
insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CG_CGZXLD', 'ZC_EB_SIGNUP', 'fquote', to_date('22-09-2011 19:07:14', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CG_CGZXLD', 'ZC_EB_SIGNUP', 'fwatch', to_date('22-09-2011 19:07:14', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KZ_ZH', 'ZC_EB_SIGNUP', 'fquote', to_date('22-09-2011 19:07:14', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KZ_ZH', 'ZC_EB_SIGNUP', 'fwatch', to_date('22-09-2011 19:07:14', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KZ_CG', 'ZC_EB_SIGNUP', 'fquote', to_date('22-09-2011 19:07:14', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KZ_CG', 'ZC_EB_SIGNUP', 'fwatch', to_date('22-09-2011 19:07:14', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KY_ZH', 'ZC_EB_SIGNUP', 'fquote', to_date('22-09-2011 19:07:14', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KY_ZH', 'ZC_EB_SIGNUP', 'fwatch', to_date('22-09-2011 19:07:14', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KY_CG', 'ZC_EB_SIGNUP', 'fquote', to_date('22-09-2011 19:07:14', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KY_CG', 'ZC_EB_SIGNUP', 'fwatch', to_date('22-09-2011 19:07:14', 'dd-mm-yyyy hh24:mi:ss'));


--5
insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('YSDWFZ', 'fwatch', 'ZC_P_PRO_MAKE', 'SQL_CONDITION', 'exists (select 1  from V_WF_ACTION_HISTORY_GK53 wf  where wf.executor = ''@@svUserID'' andwf.instance_id = ZC_P_PRO_MAKE.PROCESS_INST_ID and rownum = 1unionselect 1 from as_wf_draft drf where drf.user_id = ''@@svUserID'' and drf.wf_draft_id =ZC_P_PRO_MAKE.PROCESS_INST_ID and rownum=1unionselect 1 from V_WF_CURRENT_TASK_ZC_TODO ct where ct.executor = ''@@svUserID'' and ct.instance_id= ZC_P_PRO_MAKE.PROCESS_INST_ID and rownum = 1unionselect 1 from V_WF_CURRENT_TASK_ZC_UNTREAD ct where ct.executor = ''@@svUserID'' andct.instance_id = ZC_P_PRO_MAKE.PROCESS_INST_ID and rownum = 1unionselect 1 from V_WF_CURRENT_TASK_ZC_CANCEL  ct where ct.executor = ''@@svUserID'' andct.instance_id = ZC_P_PRO_MAKE.PROCESS_INST_ID and rownum = 1) ', null, '0', 'N');

--6
insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('YSDWFZ', 'ZcPProMake_entrustTab', 'all');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('YSDWFZ', 'ZcPProMake_entrustTab', 'done');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('YSDWFZ', 'ZcPProMake_entrustTab', 'exec');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('YSDWFZ', 'ZcPProMake_entrustTab', 'todo');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('YSDWFZ', 'ZcPProMake_entrustTab', 'untread');

--7

delete from 
   as_wf_activity_field t
 WHERE t.wf_node_id = '1061838'
 and t.compo_id='ZC_P_PRO_MAKE';
 
insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_FGKZBFS_SMWJ', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_FGKZBFS_SMWJ_BLOBID', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'INCEPTDOC_NAME', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'MANAGE_CODE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'MANAGE_NAME', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ND', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 1);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_BI_APD_FLAG', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_BI_DO_SUM', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_BI_HTBA_SUM', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_BI_JHUA_SUM', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_BI_NO', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_BI_SUM', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_BI_YJBA_SUM', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_CG_TYPE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_MAKE_CODE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 1);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_PLAN_TYPE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_YEP_SUM', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_MER_PRICE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'IS_CAR', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'PAYOUT_NAME', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'PAYTYPE_CODE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'PAYTYPE_NAME', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'PROJECT_CODE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'PROJECT_NAME', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_PITEM_CODE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_PITEM_NAME', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_PKG_BID_SUM', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_YEAR', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'BI_TARGET_CODE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'B_ACC_CODE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'B_ACC_NAME', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'CO_CODE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 1);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'CO_NAME', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 1);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'FUND_CODE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'FUND_NAME', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'INCEPTDOC_CODE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_FUKUAN_TYPE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'SENDDOC_NAME', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'SENDDOC_TYPE_CODE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'SENDDOC_TYPE_NAME', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'STATUS', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 1);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_HANGYE_CTG', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_IMP_FILE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_IMP_FILE_BLOBID', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'PROJECT_TYPE_CODE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'PROJECT_TYPE_NAME', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'SENDDOC_CODE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_INPUT_CODE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 1);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_INPUT_DATE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 1);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_INPUT_NAME', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 1);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_IS_IMP', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_IS_NOTARY', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_IS_REMARK', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_MAKE_APPR', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_MAKE_APPR_BLOBID', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_MAKE_APPR_SNO', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_MAKE_CODE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 1);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_MAKE_FROM', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_MAKE_LINKMAN', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_MAKE_NAME', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_MAKE_SEQUENCE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 1);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_MAKE_STATUS', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 1);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_MAKE_TEL', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_MAKE_ZHAOBIAO', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_MAKE_ZHAOBIAO_BLOBID', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_MAKE_ZHAOGG', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_MAKE_ZHAOGG_BLOBID', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_MAKE_ZHONGBIAO', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_MAKE_ZHONGBIAO_BLOBID', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_MONEY_BG_ZXS', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 1);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_MONEY_BI_SUM', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 1);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_MONEY_BI_YZX', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 1);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'OUTLAY_NAME', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'PAYOUT_CODE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'PROCESS_INST_ID', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 1);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_AGEY_CODE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_AGEY_NAME', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_BI_NZJZ_SUM', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'CO_CODE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 1);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ND', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 1);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_DIYU_DAIMA_ZJ', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 1);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_MONEY_HT_YBA', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ORG_CODE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 1);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ORG_NAME', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 1);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ORIGIN_CODE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ORIGIN_NAME', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'OUTLAY_CODE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM_BI', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_DIYU_NAME', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 1);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_AGEY_CODE', 'ZC_P_PRO_MAKE', 'ZC_TUIJ_AGENT', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_AGEY_NAME', 'ZC_P_PRO_MAKE', 'ZC_TUIJ_AGENT', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_DIYU_DAIMA', 'ZC_P_PRO_MAKE', 'ZC_TUIJ_AGENT', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_MAKE_CODE', 'ZC_P_PRO_MAKE', 'ZC_TUIJ_AGENT', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_TUIJ_CODE', 'ZC_P_PRO_MAKE', 'ZC_TUIJ_AGENT', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_MONEY_KY_BGS', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_PIFU_CGFS', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_PITEM_MODE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_PITEM_OPIWAY', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_PRINT_STATUS', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_PROJ_ORIGN', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_PRO_REMARK', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_REMARK', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_WEITO_DATE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_YEP_FLAG', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_YEP_SUM', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_ZG_CS_CODE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 1);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_ZG_CS_NAME', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MAKE', 1);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_BASE_GGYQ', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_CAIG_NUM', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_CATALOGUE_CODE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_CATALOGUE_NAME', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_ITEM_CTL_SUM', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_MAKE_CODE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_MAKE_NEW_CODE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_MER_M_PRICE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_PINMU_CTLG', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_PITEM_ARR_DATE', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_PITEM_ATTACH', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM', 2);

insert into as_wf_activity_field (WF_TEMPLATE_ID, WF_NODE_ID, DATA_ITEM, COMPO_ID, TAB_ID, READ_WRITE)
values (40080, 1061838, 'ZC_PITEM_ATTACH_BLOBID', 'ZC_P_PRO_MAKE', 'ZC_P_PRO_MITEM', 2);


--8
delete from zc_search_condition s where s.compo_id='ZC_EB_AUDIT_SHEET';

--9
insert into as_option (OPT_ID, CO_CODE, COMPO_ID, TRANS_TYPE, OPT_VAL, IS_SYST_OPT)
values ('OPT_ZC_ZHONG_BIAO_TUI_JIAN_NUM', '*', '*', '*', '1', 'Y');

--20131129
--1
delete from zc_search_condition s where s.compo_id='ZC_EB_AUDIT_SHEET';

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbAuditSheetTab', 'untread', '退回', 3, 'ZC_EB_AUDIT_SHEET', null, '批办单', 'tab', '304');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbAuditSheetTab', 'all', '全部', 5, 'ZC_EB_AUDIT_SHEET', null, '批办单', 'tab', '306');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbAuditSheetTab', 'done', '已审核', 2, 'ZC_EB_AUDIT_SHEET', null, '批办单', 'tab', '303');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbAuditSheetTab', 'draft', '草稿', 7, 'ZC_EB_AUDIT_SHEET', null, '批办单', 'tab', '301');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbAuditSheetTab', 'exec', '终审', 4, 'ZC_EB_AUDIT_SHEET', null, '批办单', 'tab', '305');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbAuditSheetTab', 'todo', '待审核', 1, 'ZC_EB_AUDIT_SHEET', null, '批办单', 'tab', '302');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbAuditSheetCondition', 'CO_CODE', '采购单位', 3, 'ZC_EB_AUDIT_SHEET', null, '采购单位', 'condition', '103');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbAuditSheetTab', 'cancel', '取消', 6, 'ZC_EB_AUDIT_SHEET', null, '批办单', 'tab', '301');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbAuditSheetCondition', 'ZC_PIFU_CGFS', '采购方式', 5, 'ZC_EB_AUDIT_SHEET', null, '采购方式', 'condition', '103');



--20131201---------------
--1
create or replace function getWorkDay(sellEndDate in date, days in int)
  return date is
  Result    date;
  times     varchar2(8);
  chinaDate VARCHAR2(20);
  i         int := 2;
  cursor c01 is
    select CHINA_DATE
      from zc_sys_work_day
     where CHINA_DATE > to_char(sellEndDate, 'yyyy-mm-dd')
       and date_type = 0
     order by china_date;
begin
  if sellEndDate is null then
    return null;
   end if;
  times := to_char(sysdate, 'hh24:mi:SS');
  open c01;
  loop
    fetch c01
      into chinaDate;
    EXIT WHEN c01%NOTFOUND or i > days;
    i := i + 1;
  end loop;
  close c01;
  Result := to_Date(trim(chinaDate) || ' ' || times,
                    'yyyy-mm-dd hh24:mi:SS');
  return(Result);
end getWorkDay;

--2
-- Create table
create table ZC_SYS_WORK_DAY
(
  set_year   NUMBER(4) not null,
  date_month VARCHAR2(20) not null,
  date_day   VARCHAR2(2) not null,
  week       NUMBER,
  date_type  NUMBER,
  china_date VARCHAR2(20),
  last_ver   VARCHAR2(30)
)
tablespace UFGOV
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );


--20131205
--1
insert into as_func (FUNC_ID, FUNC_DESC, ORD_INDEX, IS_GRANT_TO_ALL, IS_LIST, SHORTCUT_KEY, IS_CTRL, IS_SHIFT, IS_ALT)
values ('fsendKsld', '送科室领导', 1, null, 'N', null, null, null, null);

insert into as_compo_func (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_QUESTIONDTS', 'fsendKsld', 'Y', null, to_date('20-06-2013 22:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_FUNC_fsendKsld', 'C', '送科室领导审核');

--2
insert into AS_NO_RULE (COMPO_ID, RULE_CODE, RULE_NAME, NO_PREFIX, NO_INDEX_LEN, IS_CONT, NUM_TOOL_ID, NO_FIELD, IS_INCL_ATOZ, IS_FILL_ZERO, NO_AFTFIX, TRANS_DATE)
values ('ZC_EB_QUESTIONDTS', 'ZC_EB_QUESTIONDTS_ID', '质疑', 'QUR', null, 'Y', 'ZC_EB_QUESTIONDTS_ID_GEN', 'QUES_ID', null, 'Y', null, to_date('07-12-2013 06:26:06', 'dd-mm-yyyy hh24:mi:ss'));
insert into AS_NUM_TOOL (NUM_TOOL_ID, NUM_TOOL_NAME, IS_CONT, NUM_TOOL_DESC)
values ('ZC_EB_QUESTIONDTS_ID_GEN', '质疑', 'N', null);
insert into AS_NUM_TOOL_NO (NUM_TOOL_ID, FIX_PREFIX, ALT_PREFIX, NUM_NO)
values ('ZC_EB_QUESTIONDTS_ID_GEN', 'QUR', 'noPreFix', 0);

--3

delete from as_compo c where c.compo_id='ZC_EB_QUESTIONDTS' ;
insert into as_compo (COMPO_ID, COMPO_NAME, MASTER_TAB_ID, TRAD_ID, COMPO_TYPE, ICON_NAME, CONDITION, NO_FIELD, TYPE_FIELD, TYPE_TABLE, PARENT_COMPO, PAGE_FIELD, DATE_FIELD, VALSET_FIELD, WF_FLOW_TYPE, WF_LIST_TYPE, DEFAULT_WF_TEMPLATE, TEMPLATE_IS_USED, IS_AUTO_LIST, ORDER_BY, IS_GRANT_TO_ALL, PRINT_TYPE, TITLE_FIELD, TITLE_DATE, WF_BRIEF_FIELDS, IS_FUNC_CONTROL)
values ('ZC_EB_QUESTIONDTS', '质疑', 'ZC_EB_QUESTION', null, 'M', null, null, null, null, null, null, null, null, null, 'workflow', 'WF_COMPO', '30966', 'Y', 'Y', null, null, '0', 'PERSONORG', null, null, 'ZC');

--20131206 未更新到数据库的数据
--1.
delete from zc_search_condition s where s.compo_id='ZC_EB_QUESTIONDTS';
insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZC_EB_QUESTIONDTS_Tab', 'draft', '草稿', 1, 'ZC_EB_QUESTIONDTS', '质疑', '质疑查询页签', 'tab', '301');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZC_EB_QUESTIONDTS_Tab', 'exec', '终审', 4, 'ZC_EB_QUESTIONDTS', '质疑', '质疑查询页签', 'tab', '301');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZC_EB_QUESTIONDTS_Tab', 'todo', '待审核', 2, 'ZC_EB_QUESTIONDTS', '质疑', '质疑查询页签', 'tab', '301');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZC_EB_QUESTIONDTS_Tab', 'done', '已审核', 3, 'ZC_EB_QUESTIONDTS', '质疑', '质疑查询页签', 'tab', '301');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZC_EB_QUESTIONDTS_Tab', 'untread', '退回', 6, 'ZC_EB_QUESTIONDTS', '质疑', '质疑查询页签', 'tab', '301');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZC_EB_QUESTIONDTS_Tab', 'all', '全部', 7, 'ZC_EB_QUESTIONDTS', '质疑', '质疑查询页签', 'tab', '301');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZC_EB_QUESTIONDTS_Tab', 'execing', '处理中', 8, 'ZC_EB_QUESTIONDTS', '质疑', '质疑查询页签', 'tab', '301');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZC_EB_QUESTIONDTS_Tab', 'reply', '已回复', 9, 'ZC_EB_QUESTIONDTS', '质疑', '质疑查询页签', 'tab', '301');

--2
insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('gys_normal', 'ZC_EB_QUESTIONDTS_Tab', 'draft');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('gys_normal', 'ZC_EB_QUESTIONDTS_Tab', 'execing');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('gys_normal', 'ZC_EB_QUESTIONDTS_Tab', 'reply');

--3
-- Add comments to the columns 
comment on column ZC_EB_QUESTION.temp3
  is '质疑录入人';
  
----4
alter table AS_TAB_COL modify data_item_na VARCHAR2(300);

--5

delete from as_tab_col t where t.tab_id= 'ZC_EB_QUESTION';
insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'AGENCY', 0, '代理机构', '代理机构', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'CLIENT_FILENAME', 0, '供应商质疑相关文件', '供应商质疑相关文件', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'CLIENT_REASON', 0, '供应商质疑意见', '供应商质疑意见', 'VARCHAR2', 400, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'CLIENT_SUBMIT_TSDATE', 0, 'CLIENT_SUBMIT_TSDATE', 'CLIENT_SUBMIT_TSDATE', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'CLIENT_SUBMIT_ZYDATE', 0, '供应商质疑提交日期', '供应商质疑提交日期', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'CO_CODE', 0, '采购单位代码', '采购单位代码', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'CREATEDATE', 0, '创建日期', '创建日期', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'DW_FILENAME', 0, '采购单位相关文件', '采购单位相关文件', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'HANDLE_MODE', 0, '质疑处理模式 ZC_VS_QUES_ALL_MODE 
1  不受理
2  质疑不成立
3  质疑成立但不重做招标文件
4  质疑成立并重做招标文件
5  质疑成立并在剩余供应商中评标
6	质疑成立并重新确认需求
7	质疑成立并合同作废
', '质疑处理模式 ZC_VS_QUES_ALL_MODE 
1  不受理
2  质疑不成立
3  质疑成立但不重做招标文件
4  质疑成立并重做招标文件
5  质疑成立并在剩余供应商中评标
6	质疑成立并重新确认需求
7	质疑成立并合同作废
', 'VARCHAR2', 2, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'ID', 0, '主键ID', '主键ID', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'JB_DODATE', 0, '招标部门处理日期', '招标部门处理日期', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'JB_FILENAME', 0, '招标部门相关文件', '招标部门相关文件', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'JB_PERSON', 0, '招标人', '招标人', 'VARCHAR2', 20, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'JB_REASON', 0, '招标部门意见', '招标部门意见', 'VARCHAR2', 400, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'ND', 0, '年度', '年度', 'VARCHAR2', 4, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'ORG_CODE', 0, '招标负责部门', '招标负责部门', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'PERSON', 0, '供应商负责人', '供应商负责人', 'VARCHAR2', 20, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'PERSONORG', 0, '供应商单位名称', '供应商单位名称', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'PERSON_TEL', 0, '供应商电话', '供应商电话', 'VARCHAR2', 20, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'PROCESS_INST_ID', 0, 'PROCESS_INST_ID', 'PROCESS_INST_ID', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'PROJ', 0, '项目代码', '项目代码', 'VARCHAR2', 20, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'QUES_ID', 0, '质疑ID', '质疑ID', 'VARCHAR2', 38, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'QUES_TYPE', 0, '质疑类型（1-招标文件，2-中标结果，3-合同质疑）', '质疑类型（1-招标文件，2-中标结果，3-合同质疑）', 'VARCHAR2', 2, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'SENUSER', 0, 'SENUSER', 'SENUSER', 'VARCHAR2', 1, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'STATE', 0, '状态', '状态', 'VARCHAR2', 20, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'TEMP', 0, '采购单位意见', '采购单位意见', 'VARCHAR2', 40, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'TEMP1', 0, 'TEMP1', 'TEMP1', 'VARCHAR2', 40, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'TEMP2', 0, 'TEMP2', 'TEMP2', 'VARCHAR2', 40, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'TEMP3', 0, '质疑录入人id', '质疑录入人id', 'VARCHAR2', 40, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

--6
insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('YSDWCG', 'fwatch', 'ZC_EB_QUESTIONDTS', 'q.CO_CODE', ' ''@@svCoCode''', null, '0', 'N');

insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('YSDWFZ', 'fwatch', 'ZC_EB_QUESTIONDTS', 'q.CO_CODE', ' ''@@svCoCode''', null, '0', 'N');

--7
delete from as_compo_func c where c.compo_id='ZC_EB_QUESTIONDTS';

insert into as_compo_func (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_QUESTIONDTS', 'faccepted', 'Y', null, to_date('20-06-2013 22:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_compo_func (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_QUESTIONDTS', 'fcallback', 'Y', null, to_date('20-06-2013 22:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_compo_func (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_QUESTIONDTS', 'fdelete', 'Y', null, to_date('20-06-2013 22:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_compo_func (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_QUESTIONDTS', 'fexit', null, null, to_date('20-06-2013 22:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_compo_func (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_QUESTIONDTS', 'fmanualcommit', 'Y', null, to_date('20-06-2013 22:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_compo_func (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_QUESTIONDTS', 'fnew', null, null, to_date('20-06-2013 22:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_compo_func (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_QUESTIONDTS', 'freplyzy', 'Y', null, to_date('20-06-2013 22:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_compo_func (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_QUESTIONDTS', 'fsave', 'Y', null, to_date('20-06-2013 22:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_compo_func (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_QUESTIONDTS', 'fsendKsld', 'Y', null, to_date('20-06-2013 22:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_compo_func (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_QUESTIONDTS', 'fsendco', 'Y', null, to_date('20-06-2013 22:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_compo_func (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_QUESTIONDTS', 'fshowinstancetrace', null, null, to_date('20-06-2013 22:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_compo_func (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_QUESTIONDTS', 'fsubmitzy', 'Y', null, to_date('20-06-2013 22:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_compo_func (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_QUESTIONDTS', 'funaudit', null, null, to_date('20-06-2013 22:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_compo_func (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_QUESTIONDTS', 'funtread', 'Y', null, to_date('20-06-2013 22:56:15', 'dd-mm-yyyy hh24:mi:ss'));


--20131208
--1
-- Add comments to the columns 
comment on column ZC_XMCG_HT.zc_ht_code
  is '合同代码';
comment on column ZC_XMCG_HT.zc_diyu_daima
  is '地域代码';
comment on column ZC_XMCG_HT.zc_ht_name
  is '合同名称';
comment on column ZC_XMCG_HT.zc_ht_type
  is '合同类型';
comment on column ZC_XMCG_HT.zc_req_code
  is '协议采购需求编码';
comment on column ZC_XMCG_HT.zc_make_code
  is '采购计划编号';
comment on column ZC_XMCG_HT.zc_bid_code
  is '中标代码';
comment on column ZC_XMCG_HT.co_code
  is '单位名称';
comment on column ZC_XMCG_HT.nd
  is '年度';
comment on column ZC_XMCG_HT.zc_sgn_date
  is '合同签订日期';
comment on column ZC_XMCG_HT.zc_su_name
  is '供应商名称';
comment on column ZC_XMCG_HT.zc_jckdl_mc
  is '进出口代理商名称';
comment on column ZC_XMCG_HT.zc_ht_num
  is '合同金额';
comment on column ZC_XMCG_HT.zc_cz_level
  is '财政级别';
comment on column ZC_XMCG_HT.zc_fukuan_type
  is '付款方式';
comment on column ZC_XMCG_HT.zc_fukuan_yued
  is '付款约定';
comment on column ZC_XMCG_HT.zc_check_type
  is '验货方式';
comment on column ZC_XMCG_HT.zc_con_text
  is '合同文本';
comment on column ZC_XMCG_HT.zc_con_text_blobid
  is '合同文本id';
comment on column ZC_XMCG_HT.zc_ht_status
  is '合同状态';
comment on column ZC_XMCG_HT.zc_agey_code
  is '中介机构代码';
comment on column ZC_XMCG_HT.zc_zg_cs_code
  is '主管科室代码';
comment on column ZC_XMCG_HT.zc_sm_pj1
  is '评价1';
comment on column ZC_XMCG_HT.zc_sm_pj2
  is '评价2';
comment on column ZC_XMCG_HT.zc_sm_pj3
  is '评价3';
comment on column ZC_XMCG_HT.zc_sm_pj4
  is '评价4';
comment on column ZC_XMCG_HT.executor
  is '执行者（录入人代码）';
comment on column ZC_XMCG_HT.execute_date
  is '执行时间（录入日期）';
comment on column ZC_XMCG_HT.zc_parht_code
  is '主合同代码';
comment on column ZC_XMCG_HT.zc_su_code
  is '供应商代码';
comment on column ZC_XMCG_HT.zc_su_acc_code
  is '供应商帐号';
comment on column ZC_XMCG_HT.zc_su_bank_code
  is '供应商开户银行代码';
comment on column ZC_XMCG_HT.zc_su_bank_name
  is '供应商开户银行名称';
comment on column ZC_XMCG_HT.zc_su_tel
  is '供应商电话';
comment on column ZC_XMCG_HT.zc_su_linkman
  is '供应商联系人';
comment on column ZC_XMCG_HT.zc_is_zxqy_zb
  is '是否中小企业中标';
comment on column ZC_XMCG_HT.zc_gnw
  is '国内外';
comment on column ZC_XMCG_HT.zc_snw
  is '省内外';
comment on column ZC_XMCG_HT.zc_arrive_addr
  is '交货地点';
comment on column ZC_XMCG_HT.zc_arrive_date
  is '交货时间';
comment on column ZC_XMCG_HT.zc_hangye_ctg
  is '单位性质';
comment on column ZC_XMCG_HT.zc_sk_ren
  is '未用';
comment on column ZC_XMCG_HT.zc_zb_name
  is '中标商名称';
comment on column ZC_XMCG_HT.zc_zb_code
  is '中标商代码';
comment on column ZC_XMCG_HT.zc_bi_nzjz_sum
  is '合同结转金额';
comment on column ZC_XMCG_HT.zc_isrewrite
  is '未用';
comment on column ZC_XMCG_HT.zc_cg_leixing
  is '采购类型';
comment on column ZC_XMCG_HT.zc_zg_cs_name
  is '主管科室名称';
comment on column ZC_XMCG_HT.zc_bgsp_bh
  is '变更代码';
comment on column ZC_XMCG_HT.zc_delivery_evl
  is '交货评价';
comment on column ZC_XMCG_HT.zc_price_evl
  is '价格评价';
comment on column ZC_XMCG_HT.zc_quantity_evl
  is '质量评价';
comment on column ZC_XMCG_HT.zc_service_evl
  is '服务评价';
comment on column ZC_XMCG_HT.zc_memo
  is '备注';
comment on column ZC_XMCG_HT.zc_bid_content
  is '选择中标';
comment on column ZC_XMCG_HT.zc_delivery_date
  is '交货日期';
comment on column ZC_XMCG_HT.zc_delivery_addr
  is '交货地点';
comment on column ZC_XMCG_HT.zc_delivery_type
  is '交货方式';
comment on column ZC_XMCG_HT.agency
  is '代理机构编号';
comment on column ZC_XMCG_HT.org_code
  is '处室编号';
comment on column ZC_XMCG_HT.zc_pro_limit_start_date
  is '工期开始日期';
comment on column ZC_XMCG_HT.zc_pro_limit_end_date
  is '工期结束日期';
comment on column ZC_XMCG_HT.zc_imp_file
  is '合同附件';
comment on column ZC_XMCG_HT.zc_imp_file_blobid
  is '合同附件id';
comment on column ZC_XMCG_HT.proj_code
  is '招标项目编号';
comment on column ZC_XMCG_HT.proj_name
  is '招标项目名称';
  
--2
      delete from as_tab_col t where t.tab_id='ZC_XMCG_HT';
      insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'AGENCY', 0, '代理机构编号', '代理机构编号', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'CO_CODE', 0, '单位名称', '单位名称', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'EXECUTE_DATE', 0, '执行时间（录入日期）', '执行时间（录入日期）', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'EXECUTOR', 0, '执行者（录入人代码）', '执行者（录入人代码）', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ND', 0, '年度', '年度', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ORG_CODE', 0, '处室编号', '处室编号', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'PROCESS_INST_ID', 0, 'PROCESS_INST_ID', 'PROCESS_INST_ID', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'PROJ_CODE', 0, '招标项目编号', '招标项目编号', 'VARCHAR2', 100, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'PROJ_NAME', 0, '招标项目名称', '招标项目名称', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'REG_CODE', 0, 'REG_CODE', 'REG_CODE', 'VARCHAR2', 42, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'SCALE', 0, 'SCALE', 'SCALE', 'VARCHAR2', 2, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_AGEY_CODE', 0, '中介机构代码', '中介机构代码', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_ARRIVE_ADDR', 0, '交货地点', '交货地点', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_ARRIVE_DATE', 0, '交货时间', '交货时间', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_BGSP_BH', 0, '变更代码', '变更代码', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_BID_CODE', 0, '中标代码', '中标代码', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_BID_CONTENT', 0, '选择中标', '选择中标', 'VARCHAR2', 100, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_BI_NZJZ_SUM', 0, '合同结转金额', '合同结转金额', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_CG_LEIXING', 0, '采购类型', '采购类型', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_CHECK_TYPE', 0, '验货方式', '验货方式', 'VARCHAR2', 10, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_CON_TEXT', 0, '合同文本', '合同文本', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_CON_TEXT_BLOBID', 0, '合同文本id', '合同文本id', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_CZ_LEVEL', 0, '财政级别', '财政级别', 'VARCHAR2', 1, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_DELIVERY_ADDR', 0, '交货地点', '交货地点', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_DELIVERY_DATE', 0, '交货日期', '交货日期', 'VARCHAR2', 100, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_DELIVERY_EVL', 0, '交货评价', '交货评价', 'VARCHAR2', 4, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_DELIVERY_TYPE', 0, '交货方式', '交货方式', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_DIYU_DAIMA', 0, '地域代码', '地域代码', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_FUKUAN_TYPE', 0, '付款方式', '付款方式', 'VARCHAR2', 4, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_FUKUAN_YUED', 0, '付款约定', '付款约定', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_GNW', 0, '国内外', '国内外', 'VARCHAR2', 10, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_HANGYE_CTG', 0, '单位性质', '单位性质', 'VARCHAR2', 10, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_HT_CODE', 0, '合同代码', '合同代码', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_HT_NAME', 0, '合同名称', '合同名称', 'VARCHAR2', 100, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_HT_NUM', 0, '合同金额', '合同金额', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_HT_STATUS', 0, '合同状态', '合同状态', 'VARCHAR2', 10, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_HT_TYPE', 0, '合同类型', '合同类型', 'VARCHAR2', 1, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_IMP_FILE', 0, '合同附件', '合同附件', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_IMP_FILE_BLOBID', 0, '合同附件id', '合同附件id', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_ISREWRITE', 0, '未用', '未用', 'VARCHAR2', 2, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_IS_ZXQY_ZB', 0, '是否中小企业中标', '是否中小企业中标', 'VARCHAR2', 10, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_JCKDL_MC', 0, '进出口代理商名称', '进出口代理商名称', 'VARCHAR2', 100, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_MAKE_CODE', 0, '采购计划编号', '采购计划编号', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_MEMO', 0, '备注', '备注', 'VARCHAR2', 300, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_PARHT_CODE', 0, '主合同代码', '主合同代码', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_PRICE_EVL', 0, '价格评价', '价格评价', 'VARCHAR2', 4, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_PRO_LIMIT_END_DATE', 0, '工期结束日期', '工期结束日期', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_PRO_LIMIT_START_DATE', 0, '工期开始日期', '工期开始日期', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_QUANTITY_EVL', 0, '质量评价', '质量评价', 'VARCHAR2', 4, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_REQ_CODE', 0, '协议采购需求编码', '协议采购需求编码', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_SERVICE_EVL', 0, '服务评价', '服务评价', 'VARCHAR2', 4, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_SGN_DATE', 0, '合同签订日期', '合同签订日期', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_SK_REN', 0, '未用', '未用', 'VARCHAR2', 100, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_SM_PJ1', 0, '评价1', '评价1', 'VARCHAR2', 1, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_SM_PJ2', 0, '评价2', '评价2', 'VARCHAR2', 1, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_SM_PJ3', 0, '评价3', '评价3', 'VARCHAR2', 1, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_SM_PJ4', 0, '评价4', '评价4', 'VARCHAR2', 1, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_SNW', 0, '省内外', '省内外', 'VARCHAR2', 10, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_SU_ACC_CODE', 0, '供应商帐号', '供应商帐号', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_SU_BANK_CODE', 0, '供应商开户银行代码', '供应商开户银行代码', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_SU_BANK_NAME', 0, '供应商开户银行名称', '供应商开户银行名称', 'VARCHAR2', 100, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_SU_CODE', 0, '供应商代码', '供应商代码', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_SU_LINKMAN', 0, '供应商联系人', '供应商联系人', 'VARCHAR2', 100, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_SU_NAME', 0, '供应商名称', '供应商名称', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_SU_TEL', 0, '供应商电话', '供应商电话', 'VARCHAR2', 100, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_ZB_CODE', 0, '中标商代码', '中标商代码', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_ZB_NAME', 0, '中标商名称', '中标商名称', 'VARCHAR2', 100, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_ZG_CS_CODE', 0, '主管科室代码', '主管科室代码', 'VARCHAR2', 10, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_ZG_CS_NAME', 0, '主管科室名称', '主管科室名称', 'VARCHAR2', 100, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

--3
insert into as_option (OPT_ID, CO_CODE, COMPO_ID, TRANS_TYPE, OPT_VAL, IS_SYST_OPT)
values ('OPT_ZC_SUB_HT_SUM_IS_LIMITED', '*', '*', '*', 'Y', 'Y');

insert into as_option (OPT_ID, CO_CODE, COMPO_ID, TRANS_TYPE, OPT_VAL, IS_SYST_OPT)
values ('OPT_ZC_SUB_HT_SUM_PERCENT', '*', '*', '*', '0.1', 'Y');

--20131109
--1

delete from as_val v where v.valset_id like 'ZC_VS_HT_STATUS';
insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HT_STATUS', '2', '采购单位负责审核', 3, null, 'Y', to_date('14-08-2013 00:54:44', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HT_STATUS', '3', '招标负责人审核', 4, null, 'Y', to_date('14-08-2013 00:54:44', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HT_STATUS', '4', '主任审核', 5, null, 'Y', to_date('14-08-2013 00:54:44', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HT_STATUS', '5', '采购单位负责人审核', 2, null, 'Y', to_date('11-12-2013 18:18:41', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HT_STATUS', '1', '采购单位经办人审核', 2, null, 'Y', to_date('11-12-2013 18:18:41', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HT_STATUS', '0', '合同编制', 1, null, 'Y', to_date('14-08-2013 00:54:44', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HT_STATUS', 'exec', '终审', 6, null, 'Y', to_date('14-08-2013 00:54:44', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HT_STATUS', 'supplier_send', '供应商提交', 7, null, 'Y', to_date('14-08-2013 11:06:58', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HT_STATUS', 'danwei_back', '单位退回', 8, null, 'Y', to_date('14-08-2013 11:06:58', 'dd-mm-yyyy hh24:mi:ss'));


--20131210
--1
-- Add/modify columns 
alter table ZC_XMCG_HT_BI add gb_name VARCHAR2(60);
alter table ZC_XMCG_HT_BI add bt_name VARCHAR2(60);
-- Add comments to the columns 
comment on column ZC_XMCG_HT_BI.gb_name
  is '是否政府采购';
comment on column ZC_XMCG_HT_BI.bt_name
  is '是否监督使用';     
--2
insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('CGZX_KY_CG', 'fwatch', 'ZC_XMCG_HT_SUP', 'SQL_CONDITION', '"exists ( select 1  from V_WF_ACTION_HISTORY_GK53 wf  where wf.executor = ''@@svUserID'' and wf.instance_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum= 1 union select 1 from as_wf_draft drf where drf.user_id = ''@@svUserID'' and drf.wf_draft_id =ZC_XMCG_HT.PROCESS_INST_ID and rownum=1 union select 1 from V_WF_CURRENT_TASK_ZC_TODO ct where ct.executor = ''@@svUserID'' and ct.instance_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum =1 union select 1 from V_WF_CURRENT_TASK_ZC_UNTREAD ct where ct.executor = ''@@svUserID'' and ct.instance_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum =1 ) "', null, '0', 'N');

insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('CGZX_KY_ZH', 'fwatch', 'ZC_XMCG_HT_SUP', 'SQL_CONDITION', '"exists ( select 1  from V_WF_ACTION_HISTORY_GK53 wf  where wf.executor = ''@@svUserID'' and wf.instance_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum= 1 union select 1 from as_wf_draft drf where drf.user_id = ''@@svUserID'' and drf.wf_draft_id =ZC_XMCG_HT.PROCESS_INST_ID and rownum=1 union select 1 from V_WF_CURRENT_TASK_ZC_TODO ct where ct.executor = ''@@svUserID'' and ct.instance_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum =1 union select 1 from V_WF_CURRENT_TASK_ZC_UNTREAD ct where ct.executor = ''@@svUserID'' and ct.instance_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum =1 ) "', null, '0', 'N');

insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('CGZX_KZ_CG', 'fwatch', 'ZC_XMCG_HT_SUP', 'SQL_CONDITION', '"exists ( select 1  from V_WF_ACTION_HISTORY_GK53 wf  where wf.executor = ''@@svUserID'' and wf.instance_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum= 1 union select 1 from as_wf_draft drf where drf.user_id = ''@@svUserID'' and drf.wf_draft_id =ZC_XMCG_HT.PROCESS_INST_ID and rownum=1 union select 1 from V_WF_CURRENT_TASK_ZC_TODO ct where ct.executor = ''@@svUserID'' and ct.instance_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum =1 union select 1 from V_WF_CURRENT_TASK_ZC_UNTREAD ct where ct.executor = ''@@svUserID'' and ct.instance_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum =1 ) "', null, '0', 'N');

insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('CGZX_KZ_JS', 'fwatch', 'ZC_XMCG_HT_SUP', 'SQL_CONDITION', '"exists ( select 1  from V_WF_ACTION_HISTORY_GK53 wf  where wf.executor = ''@@svUserID'' and wf.instance_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum= 1 union select 1 from as_wf_draft drf where drf.user_id = ''@@svUserID'' and drf.wf_draft_id =ZC_XMCG_HT.PROCESS_INST_ID and rownum=1 union select 1 from V_WF_CURRENT_TASK_ZC_TODO ct where ct.executor = ''@@svUserID'' and ct.instance_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum =1 union select 1 from V_WF_CURRENT_TASK_ZC_UNTREAD ct where ct.executor = ''@@svUserID'' and ct.instance_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum =1 ) "', null, '0', 'N');

insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('CGZX_KZ_ZH', 'fwatch', 'ZC_XMCG_HT_SUP', 'SQL_CONDITION', '"exists ( select 1  from V_WF_ACTION_HISTORY_GK53 wf  where wf.executor = ''@@svUserID'' and wf.instance_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum= 1 union select 1 from as_wf_draft drf where drf.user_id = ''@@svUserID'' and drf.wf_draft_id =ZC_XMCG_HT.PROCESS_INST_ID and rownum=1 union select 1 from V_WF_CURRENT_TASK_ZC_TODO ct where ct.executor = ''@@svUserID'' and ct.instance_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum =1 union select 1 from V_WF_CURRENT_TASK_ZC_UNTREAD ct where ct.executor = ''@@svUserID'' and ct.instance_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum =1 ) "', null, '0', 'N');

insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('CG_CGCLD', 'fwatch', 'ZC_XMCG_HT_SUP', 'SQL_CONDITION', '"exists ( select 1  fromV_WF_ACTION_HISTORY_GK53 wf  where wf.executor = ''@@svUserID'' and wf.instance_id =ZC_XMCG_HT.PROCESS_INST_ID and rownum = 1 union select 1 from as_wf_draft drf where drf.user_id= ''@@svUserID'' and drf.wf_draft_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum=1 union select 1from V_WF_CURRENT_TASK_ZC_TODO ct where ct.executor = ''@@svUserID'' and ct.instance_id =ZC_XMCG_HT.PROCESS_INST_ID and rownum = 1 union select 1 from V_WF_CURRENT_TASK_ZC_UNTREAD ctwhere ct.executor = ''@@svUserID'' and ct.instance_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum =1 ) "', null, '0', 'N');

insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('CG_CGCZGY', 'fwatch', 'ZC_XMCG_HT_SUP', 'SQL_CONDITION', '"exists ( select 1  fromV_WF_ACTION_HISTORY_GK53 wf  where wf.executor = ''@@svUserID'' and wf.instance_id =ZC_XMCG_HT.PROCESS_INST_ID and rownum = 1 union select 1 from as_wf_draft drf where drf.user_id= ''@@svUserID'' and drf.wf_draft_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum=1 union select 1from V_WF_CURRENT_TASK_ZC_TODO ct where ct.executor = ''@@svUserID'' and ct.instance_id =ZC_XMCG_HT.PROCESS_INST_ID and rownum = 1 union select 1 from V_WF_CURRENT_TASK_ZC_UNTREAD ctwhere ct.executor = ''@@svUserID'' and ct.instance_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum =1 ) "', null, '0', 'N');

insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('CG_ZGSH', 'fwatch', 'ZC_XMCG_HT_SUP', 'SQL_CONDITION', '"exists ( select 1  from V_WF_ACTION_HISTORY_GK53 wf  where wf.executor = ''@@svUserID'' and wf.instance_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum= 1 union select 1 from as_wf_draft drf where drf.user_id = ''@@svUserID'' and drf.wf_draft_id =ZC_XMCG_HT.PROCESS_INST_ID and rownum=1 union select 1 from V_WF_CURRENT_TASK_ZC_TODO ct where ct.executor = ''@@svUserID'' and ct.instance_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum =1 union select 1 from V_WF_CURRENT_TASK_ZC_UNTREAD ct where ct.executor = ''@@svUserID'' and ct.instance_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum =1 ) "', null, '0', 'N');

insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('gys_huiyuan', 'fwatch', 'ZC_XMCG_HT_SUP', 'ZC_SU_CODE', '=''@@svUserID''', null, '0', 'N');

insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('gys_normal', 'fwatch', 'ZC_XMCG_HT_SUP', 'ZC_SU_CODE', '=''@@svUserID''', null, '0', 'N');

insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('YSDWCG', 'fwatch', 'ZC_XMCG_HT_SUP', 'SQL_CONDITION', '"exists ( select 1  from V_WF_ACTION_HISTORY_GK53 wf  where wf.executor = ''@@svUserID'' and wf.instance_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum= 1 union select 1 from as_wf_draft drf where drf.user_id = ''@@svUserID'' and drf.wf_draft_id =ZC_XMCG_HT.PROCESS_INST_ID and rownum=1 union select 1 from V_WF_CURRENT_TASK_ZC_TODO ct where ct.executor = ''@@svUserID'' and ct.instance_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum =1 union select 1 from V_WF_CURRENT_TASK_ZC_UNTREAD ct where ct.executor = ''@@svUserID'' and ct.instance_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum =1 ) "', null, '0', 'N');

insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('YSDWFZ', 'fwatch', 'ZC_XMCG_HT_SUP', 'SQL_CONDITION', '"exists ( select 1  from V_WF_ACTION_HISTORY_GK53 wf  where wf.executor = ''@@svUserID'' and wf.instance_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum= 1 union select 1 from as_wf_draft drf where drf.user_id = ''@@svUserID'' and drf.wf_draft_id =ZC_XMCG_HT.PROCESS_INST_ID and rownum=1 union select 1 from V_WF_CURRENT_TASK_ZC_TODO ct where ct.executor = ''@@svUserID'' and ct.instance_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum =1 union select 1 from V_WF_CURRENT_TASK_ZC_UNTREAD ct where ct.executor = ''@@svUserID'' and ct.instance_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum =1 ) "', null, '0', 'N');

--3
insert into as_compo (COMPO_ID, COMPO_NAME, MASTER_TAB_ID, TRAD_ID, COMPO_TYPE, ICON_NAME, CONDITION, NO_FIELD, TYPE_FIELD, TYPE_TABLE, PARENT_COMPO, PAGE_FIELD, DATE_FIELD, VALSET_FIELD, WF_FLOW_TYPE, WF_LIST_TYPE, DEFAULT_WF_TEMPLATE, TEMPLATE_IS_USED, IS_AUTO_LIST, ORDER_BY, IS_GRANT_TO_ALL, PRINT_TYPE, TITLE_FIELD, TITLE_DATE, WF_BRIEF_FIELDS, IS_FUNC_CONTROL)
values ('ZC_PRO_END_YEAR_END', '项目结项与结转', 'ZC_P_PRO_MAKE', null, 'M', null, null, null, null, null, null, null, null, null, null, null, null, 'N', 'Y', null, null, '0', null, null, null, 'Y ');

--4
insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('ZC_PRO_END_YEAR_END', 'C', '项目结项与结转');

--5
insert into jl_cgb.as_compo_func (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_PRO_END_YEAR_END', 'fcarraryNew', null, null, null);

insert into jl_cgb.as_compo_func (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_PRO_END_YEAR_END', 'fcarrarylock', null, null, null);

insert into jl_cgb.as_compo_func (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_PRO_END_YEAR_END', 'ffinishitem', null, null, null);


--6
insert into as_func (FUNC_ID, FUNC_DESC, ORD_INDEX, IS_GRANT_TO_ALL, IS_LIST, SHORTCUT_KEY, IS_CTRL, IS_SHIFT, IS_ALT)
values ('fcarrarylock', '结转锁定', 913, null, 'Y', null, null, null, null);

insert into as_func (FUNC_ID, FUNC_DESC, ORD_INDEX, IS_GRANT_TO_ALL, IS_LIST, SHORTCUT_KEY, IS_CTRL, IS_SHIFT, IS_ALT)
values ('fcarraryNew', '结转立项', 913, null, 'Y', null, null, null, null);

--7
insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('fcarrarylock', 'C', '结转锁定');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('fcarraryNew', 'C', '结转立项');

--8
insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcYearEnd_entrustTab', '30', '结转完成', 6, 'ZC_PRO_END_YEAR_END', null, '结转结项页签', 'tab', '301');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcYearEnd_entrustTab', '21', '结转锁定(手动)', 5, 'ZC_PRO_END_YEAR_END', null, '结转结项页签', 'tab', '301');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcYearEnd_entrustTab', '20', '结转锁定', 4, 'ZC_PRO_END_YEAR_END', null, '结转结项页签', 'tab', '301');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcYearEnd_entrustTab', '10', '已结项', 2, 'ZC_PRO_END_YEAR_END', null, '结转结项页签', 'tab', '301');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcYearEnd_entrustTab', '11', '待结项', 1, 'ZC_PRO_END_YEAR_END', null, '结转结项页签', 'tab', '301');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcYearEnd_entrustTab', '00', '待结转', 3, 'ZC_PRO_END_YEAR_END', null, '结转结项页签', 'tab', '301');

--9
-- Create table
create table ZC_JZ_MAKE_TEMP
(
  zc_make_code VARCHAR2(128),
  zc_bi_no     VARCHAR2(64),
  zc_jhua_sum  NUMBER(16,2) default 0,
  zc_ht_sum    NUMBER(16,2) default 0,
  zc_bal_sum   NUMBER(16,3) default 0
)
tablespace UFGOV
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );


--10
-- Create table
create table ZC_JZ_HT_TEMP
(
  zc_make_code VARCHAR2(128),
  zc_bi_no     VARCHAR2(64),
  zc_jhua_sum  NUMBER(16,2) default 0,
  zc_ht_sum    NUMBER(16,2) default 0,
  zc_bal_sum   NUMBER(16,3) default 0
)
tablespace UFGOV
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );


--11
insert into as_func (FUNC_ID, FUNC_DESC, ORD_INDEX, IS_GRANT_TO_ALL, IS_LIST, SHORTCUT_KEY, IS_CTRL, IS_SHIFT, IS_ALT)
values ('fjieZhuanBaseData', '结转基础资料', 42, null, 'N', null, null, null, null);

insert into as_compo_func (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_PRO_END_YEAR_END', 'fjieZhuanBaseData', null, null, to_date('21-10-2010 16:43:33', 'dd-mm-yyyy hh24:mi:ss'));

--12
insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('ZC_FUNC_fjieZhuanBaseData', 'C', '基础资料结转');

--13
create or replace procedure sp_zc_jiChuZiLiaoJieZhuan(curNd in varchar2) is
begin
  --结转as_emp_position
  delete from as_emp_position where nd=curNd+1;
  insert into as_emp_position
  select emp_code, posi_code, org_code, co_code, emp_posi_id, nd+1, sysdate from as_emp_position where nd=curNd;

--结转as_org
  delete from as_org where nd=curNd+1;
  insert into as_org 
  select co_code, org_code, org_name, parent_org_code, is_lowest, quic_code, prin_code, linkman, tele, org_id, org_type_code, nd+1, is_need_send_bank, sysdate, SYS_GUID(), trigger_enable from as_org where nd=curNd;

--结转as_org_position
  delete from as_org_position where nd=curNd+1;
  insert into as_org_position 
  select co_code, posi_code, org_code, leader_posi_id, org_posi_id, nd+1, sysdate from as_org_position where nd=curNd;
 
--结转 as_wf_business_superior
/*delete from as_wf_business_superior where nd=curNd+1;
insert into as_wf_business_superior
select id, jun_co_code, jun_org_code, jun_posi_code, jun_emp_code, sup_condition, sup_co_code, sup_org_code, sup_posi_code, sup_emp_code, project_name, description, priority, nd+1 from as_wf_business_superior where nd=curNd;
*/
--结转 ma_company
delete from ma_company where nd=curNd+1;
insert into ma_company
select co_code, co_type_code, gb_code, co_name, co_fullna, quic_code, mark, post_code, comm_addr, address, url, link_man, co_clerk, co_leader, fi_leader, loca_tele, director_code, parent_co_code, f_co_code, is_used, f_org_code, is_self, bank_acc, shop_card_no, corp_repr, trade_name, country, province, city, real_co_code, is_lowest, nd+1, fina_level, co_kind, is_pilot, is_need_send_bank, region_code, sysdate, is_need_send_bank_sl, co_type_code_1, can_getbill, getbill_id, can_charge, turn_in_acct, nt_acc_id, nt_acc_name, nt_hesuan_co_code, sys_guid(), trigger_enable, pr_bi_cocode from ma_company where nd=curNd;

--结转 ZC_B_CATALOGUE
delete  from ZC_B_CATALOGUE where zc_year=curNd+1;
insert into ZC_B_CATALOGUE 
select zc_year+1, zc_catalogue_code, zc_catalogue_name, zc_catalogue_code_par, zc_catalogue_type, zc_quota, zc_metric_unit, zc_is_vital, zc_is_used, zc_target_type, zc_pinmu_ctlg, zc_is_cgzx_zg, zc_is_general, zc_year, zc_diyu_daima, zc_quota_unit, zc_cg_leixing, zc_zcgz_std, zc_is_assert, zc_catalogue_name_par, zc_is_dianzi_toubiao, zc_jj_pp_num, zc_jj_price_quota from zc_b_catalogue where zc_year=curNd;

end sp_zc_jiChuZiLiaoJieZhuan;















