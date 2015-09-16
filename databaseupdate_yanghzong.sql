
--20150908
--1.
insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_PITEM_OPIWAY', '7', '���߾���', 32, null, 'N', to_date('11-09-2015 23:11:43', 'dd-mm-yyyy hh24:mi:ss'));
--2
insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_ZC_EB_BULLETIN_TYPE', 'zhaobiao_zxjj', '���߾����б깫��', 13, null, 'Y', to_date('15-09-2015 15:19:57', 'dd-mm-yyyy hh24:mi:ss'));

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
  is '���߾���';
-- Add comments to the columns 
comment on column ZC_EB_ZXJJ.proj_code
  is '�ɹ����';
comment on column ZC_EB_ZXJJ.pack_code
  is '�ְ����';
comment on column ZC_EB_ZXJJ.co_code
  is '�ɹ���λ����';
comment on column ZC_EB_ZXJJ.pur_content
  is '�ɹ�����';
comment on column ZC_EB_ZXJJ.begin_time
  is '���ۿ�ʼʱ��';
comment on column ZC_EB_ZXJJ.jj_time_len
  is 'ÿ�־���ʱ��';
comment on column ZC_EB_ZXJJ.jj_all_rounds
  is '��������';
comment on column ZC_EB_ZXJJ.jj_cur_round
  is '��ǰ�ִ�';
comment on column ZC_EB_ZXJJ.status
  is '״̬ �ȴ���ʼ/������/�ȴ�����/���۽���/�ϱ�';
comment on column ZC_EB_ZXJJ.remark
  is '��ע';
comment on column ZC_EB_ZXJJ.fail_reason
  is '�ϱ�ԭ��';
comment on column ZC_EB_ZXJJ.jj_code
  is '���۱��';
comment on column ZC_EB_ZXJJ.jj_cur_quote
  is '��ͼ�';
comment on column ZC_EB_ZXJJ.jj_cur_quoter
  is '������';
comment on column ZC_EB_ZXJJ.inputor
  is '¼����';
comment on column ZC_EB_ZXJJ.input_date
  is '¼��ʱ��';
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
  is '���߾�����ʷ';
-- Add comments to the columns 
comment on column ZC_EB_ZXJJ_HISTORY.jj_code
  is '���۱��';
comment on column ZC_EB_ZXJJ_HISTORY.jj_round
  is '�����ִ�';
comment on column ZC_EB_ZXJJ_HISTORY.jj_quote
  is '����';
comment on column ZC_EB_ZXJJ_HISTORY.jj_quoter
  is '������';
comment on column ZC_EB_ZXJJ_HISTORY.jj_quote_time
  is '����ʱ��';
comment on column ZC_EB_ZXJJ_HISTORY.is_win
  is '�Ƿ��б�';

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
values ('ZC_EB_ZXJJ', 'C', '���߾���');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_BEGIN_TIME', 'C', '���ۿ�ʼʱ��');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_CO_CODE', 'C', '�ɹ���λ');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_FAIL_REASON', 'C', '�ϱ�ԭ��');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_INPUTOR', 'C', '¼����');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_INPUT_DATE', 'C', '¼��ʱ��');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_JJ_ALL_ROUNDS', 'C', '��������');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_JJ_CODE', 'C', '���۱��');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_JJ_CUR_QUOTE', 'C', '��ͼ�');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_JJ_CUR_QUOTER', 'C', '������');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_JJ_CUR_ROUND', 'C', '��ǰ�ִ�');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_JJ_TIME_LEN', 'C', 'ÿ�־���ʱ��');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_PACK_CODE', 'C', '�ְ����');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_PROJ_CODE', 'C', '�ɹ����');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_PUR_CONTENT', 'C', '�ɹ�����');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_REMARK', 'C', '��ע');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_STATUS', 'C', '״̬');

--7

insert into as_table (TAB_ID, MASTER_TAB_ID, TAB_NA, TAB_DESC, DB_VER_NO, TRAD_VER_NO, LSTDATE, PRE_VALSET, IS_TABLE)
values ('ZC_EB_ZXJJ', null, '���߾���', '���߾���', null, null, null, null, 'Y');

insert into as_table (TAB_ID, MASTER_TAB_ID, TAB_NA, TAB_DESC, DB_VER_NO, TRAD_VER_NO, LSTDATE, PRE_VALSET, IS_TABLE)
values ('ZC_EB_ZXJJ_HISTORY', 'ZC_EB_ZXJJ', '���߾�����ʷ', '���߾�����ʷ', null, null, null, null, 'Y');

--8


insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'BEGIN_TIME', 0, '���ۿ�ʼʱ��', '���ۿ�ʼʱ��', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'CO_CODE', 0, '�ɹ���λ����', '�ɹ���λ����', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'FAIL_REASON', 0, '�ϱ�ԭ��', '�ϱ�ԭ��', 'VARCHAR2', 600, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'INPUTOR', 0, '¼����', '¼����', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'INPUT_DATE', 0, '¼��ʱ��', '¼��ʱ��', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'JJ_ALL_ROUNDS', 0, '��������', '��������', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'JJ_CODE', 0, '���۱��', '���۱��', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'N', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'JJ_CUR_QUOTE', 0, '��ͼ�', '��ͼ�', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'JJ_CUR_QUOTER', 0, '������', '������', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'JJ_CUR_ROUND', 0, '��ǰ�ִ�', '��ǰ�ִ�', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'JJ_TIME_LEN', 0, 'ÿ�־���ʱ��', 'ÿ�־���ʱ��', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'PACK_CODE', 0, '�ְ����', '�ְ����', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'PROJ_CODE', 0, '�ɹ����', '�ɹ����', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'PUR_CONTENT', 0, '�ɹ�����', '�ɹ�����', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'REMARK', 0, '��ע', '��ע', 'VARCHAR2', 600, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ', 'STATUS', 0, '״̬ �ȴ���ʼ/������/�ȴ�����/���۽���/�ϱ�', '״̬ �ȴ���ʼ/������/�ȴ�����/���۽���/�ϱ�', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

--9

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ_HISTORY', 'IS_WIN', 0, '�Ƿ��б�', '�Ƿ��б�', 'VARCHAR2', 10, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ_HISTORY', 'JJ_CODE', 0, '���۱��', '���۱��', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ_HISTORY', 'JJ_QUOTE', 0, '����', '����', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ_HISTORY', 'JJ_QUOTER', 0, '������', '������', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ_HISTORY', 'JJ_QUOTE_TIME', 0, '����ʱ��', '����ʱ��', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ZXJJ_HISTORY', 'JJ_ROUND', 0, '�����ִ�', '�����ִ�', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

--10
insert into as_compo (COMPO_ID, COMPO_NAME, MASTER_TAB_ID, TRAD_ID, COMPO_TYPE, ICON_NAME, CONDITION, NO_FIELD, TYPE_FIELD, TYPE_TABLE, PARENT_COMPO, PAGE_FIELD, DATE_FIELD, VALSET_FIELD, WF_FLOW_TYPE, WF_LIST_TYPE, DEFAULT_WF_TEMPLATE, TEMPLATE_IS_USED, IS_AUTO_LIST, ORDER_BY, IS_GRANT_TO_ALL, PRINT_TYPE, TITLE_FIELD, TITLE_DATE, WF_BRIEF_FIELDS, IS_FUNC_CONTROL)
values ('ZC_EB_ZXJJ', '���߾���', 'ZC_EB_ZXJJ', null, 'M', null, null, null, null, null, null, null, null, null, 'workflow', 'WF_FILTER_COMPO_TODO', '10264', 'Y', 'Y', 'JJ_CODE', null, '0', 'PROJ_CODE', null, 'PROJ_CODE', 'ZC');

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
values ('fjjbj', '����', 48, null, 'N', null, null, null, null);

insert into as_func (FUNC_ID, FUNC_DESC, ORD_INDEX, IS_GRANT_TO_ALL, IS_LIST, SHORTCUT_KEY, IS_CTRL, IS_SHIFT, IS_ALT)
values ('fjjstart', '��ʼ', 48, null, 'N', null, null, null, null);

insert into as_func (FUNC_ID, FUNC_DESC, ORD_INDEX, IS_GRANT_TO_ALL, IS_LIST, SHORTCUT_KEY, IS_CTRL, IS_SHIFT, IS_ALT)
values ('fjjbjcancel', '�ջر���', 48, null, 'N', null, null, null, null);

insert into as_func (FUNC_ID, FUNC_DESC, ORD_INDEX, IS_GRANT_TO_ALL, IS_LIST, SHORTCUT_KEY, IS_CTRL, IS_SHIFT, IS_ALT)
values ('fjjfail', '�ϱ�', 48, null, 'N', null, null, null, null);

--13

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('fjjbj', 'C', '����');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('fjjstart', 'C', '��ʼ');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('fjjbjcancel', 'C', '�ջر���');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('fjjfail', 'C', '�ϱ�');

--14

insert into ZC_SEARCH_CONDITION (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbZxjj_Tab', 'all', '�鿴ȫ��', 7, 'ZC_EB_ZXJJ', null, '���߾���ҳǩ', 'tab', '301');

insert into ZC_SEARCH_CONDITION (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbZxjj_Tab', 'wait', 'δ��ʼ', 1, 'ZC_EB_ZXJJ', null, '���߾���ҳǩ', 'tab', '301');

insert into ZC_SEARCH_CONDITION (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbZxjj_Tab', 'quoting', '������', 2, 'ZC_EB_ZXJJ', null, '���߾���ҳǩ', 'tab', '301');

insert into ZC_SEARCH_CONDITION (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbZxjj_Tab', 'complete', '���۽���', 3, 'ZC_EB_ZXJJ', null, '���߾���ҳǩ', 'tab', '301');

--15

insert into ZC_SYS_BILL_ELEMENT (ELEMENT_ID, ND, BILL_TYPE_CODE, ELEMENT_CODE, ELEMENT_NAME, IS_INCLUDE, IS_INHERIT, INHERIT_ELEMENT_CODE, INHERIT_ELEMENT_NAME, IS_EDIT, IS_RANDOM_EDIT, DEC_FLAG, LEVEL_CTRL, IS_EDIT_PUTIN, IS_EDIT_AUDIT, IS_CONFIG, DEFAULT_VAL_CODE, DEFAULT_VAL_NAME, IS_NULL, PARENT_LEVEL_CTRL, EXTEND_ELEMENT_TYPE, LEVEL_STR, DISPLAY_ORDER_INDEX, GENBALANCE_LEVEL_CTRL)
values ('ZC_EB_ZXJJ_BEGIN_TIME', 9999, 'ZC_EB_ZXJJ', 'BEGIN_TIME', '���ۿ�ʼʱ��', '1', '0', null, null, '1', '1', '0', 0, '0', '0', '1', null, null, '0', 0, '1', '1', 1, 0);

insert into ZC_SYS_BILL_ELEMENT (ELEMENT_ID, ND, BILL_TYPE_CODE, ELEMENT_CODE, ELEMENT_NAME, IS_INCLUDE, IS_INHERIT, INHERIT_ELEMENT_CODE, INHERIT_ELEMENT_NAME, IS_EDIT, IS_RANDOM_EDIT, DEC_FLAG, LEVEL_CTRL, IS_EDIT_PUTIN, IS_EDIT_AUDIT, IS_CONFIG, DEFAULT_VAL_CODE, DEFAULT_VAL_NAME, IS_NULL, PARENT_LEVEL_CTRL, EXTEND_ELEMENT_TYPE, LEVEL_STR, DISPLAY_ORDER_INDEX, GENBALANCE_LEVEL_CTRL)
values ('ZC_EB_ZXJJ_JJ_TIME_LEN', 9999, 'ZC_EB_ZXJJ', 'JJ_TIME_LEN', 'ÿ�־���ʱ��', '1', '0', null, null, '1', '1', '0', 0, '0', '0', '1', null, null, '0', 0, '1', '1', 1, 0);

insert into ZC_SYS_BILL_ELEMENT (ELEMENT_ID, ND, BILL_TYPE_CODE, ELEMENT_CODE, ELEMENT_NAME, IS_INCLUDE, IS_INHERIT, INHERIT_ELEMENT_CODE, INHERIT_ELEMENT_NAME, IS_EDIT, IS_RANDOM_EDIT, DEC_FLAG, LEVEL_CTRL, IS_EDIT_PUTIN, IS_EDIT_AUDIT, IS_CONFIG, DEFAULT_VAL_CODE, DEFAULT_VAL_NAME, IS_NULL, PARENT_LEVEL_CTRL, EXTEND_ELEMENT_TYPE, LEVEL_STR, DISPLAY_ORDER_INDEX, GENBALANCE_LEVEL_CTRL)
values ('ZC_EB_ZXJJ_JJ_ALL_ROUNDS', 9999, 'ZC_EB_ZXJJ', 'JJ_ALL_ROUNDS', '��������', '1', '0', null, null, '1', '1', '0', 0, '0', '0', '1', null, null, '0', 0, '1', '1', 1, 0);

--16

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_ZXJJ_STATUS', '0', '�ȴ���ʼ', 0, null, 'Y', to_date('16-09-2015 04:27:36', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_ZXJJ_STATUS', '1', '������', 5, null, 'Y', to_date('16-09-2015 04:27:36', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_ZXJJ_STATUS', '2', '�ȴ�����', 10, null, 'Y', to_date('16-09-2015 04:27:36', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_ZXJJ_STATUS', '3', '���۽���', 15, null, 'Y', to_date('16-09-2015 04:27:36', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_ZXJJ_STATUS', '4', '�ϱ�', 20, null, 'Y', to_date('16-09-2015 04:27:36', 'dd-mm-yyyy hh24:mi:ss'));

--17
alter table ZC_EB_ZXJJ add process_inst_id number;

--18

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_HISTORY_IS_WIN', 'C', '�Ƿ��б�');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_HISTORY_JJ_CODE', 'C', '���۱��');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_HISTORY_JJ_QUOTE', 'C', '����');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_HISTORY_JJ_QUOTER', 'C', '������');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_HISTORY_JJ_QUOTE_TIME', 'C', '����ʱ��');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ZXJJ_HISTORY_JJ_ROUND', 'C', '�����ִ�');

--19
-- Add/modify columns 
alter table ZC_EB_ZXJJ add nd VARCHAR2(10);
-- Add comments to the columns 
comment on column ZC_EB_ZXJJ.nd
  is '���';
--20
insert into AS_MENU_COMPO (MENU_ID, COMPO_ID, ORD_INDEX, IS_GOTO_EDIT, IS_IN_MENU, IS_ALWAYS_NEW, URL)
values ('ZC_EB_BID', 'ZC_EB_ZXJJ', 5, 'N', 'Y', 'N', '/GB/jsp/ZC/CommonPage.jsp?className=com.ufgov.zc.client.zc.zxjj.ZcEbZxjjListPanel');

insert into AP_MENU_COMPO (MENU_ID, COMPO_ID, COMPO_NAME, ORD_INDEX, IS_GOTO_EDIT, IS_ALWAYS_NEW, IS_IN_MENU, URL)
values ('ZC_KBGL', 'ZC_EB_ZXJJ', '���߾���', 1, 'N', 'N', 'Y', '/GB/jsp/ZC/CommonPage.jsp?className=com.ufgov.zc.client.zc.zxjj.ZcEbZxjjListPanel');




--20131125
--1.
update as_option o set o.opt_val='N' where o.opt_id='OPT_ZC_USE_BUDGET_INTERFACE';

--2.
delete from as_option o where o.opt_id='ZC_OPTON_JIHUA_ZIJIN_HELP_MSG' ;

insert into as_option (OPT_ID, CO_CODE, COMPO_ID, TRANS_TYPE, OPT_VAL, IS_SYST_OPT)
values ('ZC_OPTON_JIHUA_ZIJIN_HELP_MSG', '*', '*', '*', '<html>�ɹ��ʽ����ʹ�ã�<strong>�����ʽ�</strong>��<strong>�Գ��ʽ�</strong>��<br>1.<strong>�����ʽ�</strong>ָ����Ԥ��ָ�꣬ʹ�ò����ʽ�ʱ����Ҫ�Ǽ�ָ�������Ϣ.<br>2.<strong>�Գ��ʽ�</strong>ָ�ɹ���λ����׼�����ʽ𣬲���Ҫͨ����������֧����ֱ����<font color=red><strong>���βɹ�ʹ�ý��(Ԫ)</strong></font>��д����.</html>', 'Y');

--3.

delete from as_val v where v.valset_id='ZC_VS_FUND_NAME';

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_FUND_NAME', '0', '�Գ��ʽ�', 99, null, 'N', to_date('09-07-2013 15:56:26', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_FUND_NAME', '1', 'Ԥ��ָ��', 1, null, 'N', to_date('25-11-2013 13:51:25', 'dd-mm-yyyy hh24:mi:ss'));

--20131126
--1.
delete from as_val v where v.valset_id like 'ZC_VS_MAKE_STATUS';

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_MAKE_STATUS', '0', '�ɹ��ƻ��౨', 1, null, 'N', to_date('26-11-2013 09:10:41', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_MAKE_STATUS', '5', '�ɹ������1', 4, null, 'N', to_date('26-11-2013 09:10:41', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_MAKE_STATUS', '10', '�ɹ������2', 6, null, 'N', to_date('26-11-2013 09:10:41', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_MAKE_STATUS', '15', '�ɹ��������', 8, null, 'N', to_date('26-11-2013 09:10:41', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_MAKE_STATUS', 'cancel', '����', 20, null, 'N', to_date('23-06-2013 19:36:03', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_MAKE_STATUS', 'exec', '����', 22, null, 'N', to_date('23-06-2013 19:36:03', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_MAKE_STATUS', 'jingjiaing', '���ھ���', 220, null, 'N', to_date('23-06-2013 19:36:03', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_MAKE_STATUS', 'yjx', '�ѽ���', 200, null, 'N', to_date('23-06-2013 19:36:03', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_MAKE_STATUS', 'yjz', '�ѽ�ת', 210, null, 'N', to_date('23-06-2013 19:36:03', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_MAKE_STATUS', 'zhongbiao', 'ȷ���б깩Ӧ��', 220, null, 'N', to_date('23-06-2013 19:36:03', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_MAKE_STATUS', '2', '�ɹ���λ���', 2, null, 'N', to_date('06-11-2013 16:57:45', 'dd-mm-yyyy hh24:mi:ss'));

--2.
insert into ma_company (CO_CODE, CO_TYPE_CODE, GB_CODE, CO_NAME, CO_FULLNA, QUIC_CODE, MARK, POST_CODE, COMM_ADDR, ADDRESS, URL, LINK_MAN, CO_CLERK, CO_LEADER, FI_LEADER, LOCA_TELE, DIRECTOR_CODE, PARENT_CO_CODE, F_CO_CODE, IS_USED, F_ORG_CODE, IS_SELF, BANK_ACC, SHOP_CARD_NO, CORP_REPR, TRADE_NAME, COUNTRY, PROVINCE, CITY, REAL_CO_CODE, IS_LOWEST, ND, FINA_LEVEL, CO_KIND, IS_PILOT, IS_NEED_SEND_BANK, REGION_CODE, TRANS_DATE, IS_NEED_SEND_BANK_SL, CO_TYPE_CODE_1, CAN_GETBILL, GETBILL_ID, CAN_CHARGE, TURN_IN_ACCT, NT_ACC_ID, NT_ACC_NAME, NT_HESUAN_CO_CODE, GUID, TRIGGER_ENABLE, PR_BI_COCODE)
values ('040009', '02', null, '�ɹ�����', '�ɹ�����', null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'Y', '600', 'N', null, null, null, null, null, '*', '*', null, 'Y', 2013, '01', null, null, null, null, to_date('12-03-2013 15:46:52', 'dd-mm-yyyy hh24:mi:ss'), 'N', null, 'Y', null, 'Y', null, null, null, null, '4CEABDEE0E0A4DFFAABF7275E7BF52DE', 1, null);

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
values ('ZC_P_PRO_MAKE', 'ZC_MAKE_CODE', '�ɹ���żƻ�', '��Ʋɼ�[', 4, 'Y', 'ZC_MAKE_CODE_GEN', 'ZC_MAKE_CODE', null, 'Y', '��', to_date('26-11-2013 10:56:44', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_NO_RULE (COMPO_ID, RULE_CODE, RULE_NAME, NO_PREFIX, NO_INDEX_LEN, IS_CONT, NUM_TOOL_ID, NO_FIELD, IS_INCL_ATOZ, IS_FILL_ZERO, NO_AFTFIX, TRANS_DATE)
values ('ZC_P_PRO_MAKE', 'ZC_MAKE_CODE_DZJJ', '���Ӿ��۲ɹ���żƻ�', '��Ʋɼ�[', 4, 'Y', 'ZC_MAKE_CODE_DZJJ_GEN', 'ZC_MAKE_CODE_DZJJ', null, 'Y', '��', to_date('26-11-2013 10:56:44', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_NO_RULE (COMPO_ID, RULE_CODE, RULE_NAME, NO_PREFIX, NO_INDEX_LEN, IS_CONT, NUM_TOOL_ID, NO_FIELD, IS_INCL_ATOZ, IS_FILL_ZERO, NO_AFTFIX, TRANS_DATE)
values ('ZC_P_PRO_MAKE', 'ZC_MAKE_CODE_XY', 'Э��ɹ���żƻ�', '��Ʋɼ�[', 4, 'Y', 'ZC_MAKE_CODE_XY_GEN', 'ZC_MAKE_CODE_XY', null, 'Y', '��', to_date('26-11-2013 10:56:44', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_NO_RULE (COMPO_ID, RULE_CODE, RULE_NAME, NO_PREFIX, NO_INDEX_LEN, IS_CONT, NUM_TOOL_ID, NO_FIELD, IS_INCL_ATOZ, IS_FILL_ZERO, NO_AFTFIX, TRANS_DATE)
values ('ZC_P_PRO_MAKE', 'ZC_TEMP_MAKE_CODE', '�ɹ���ʱ��żƻ�', '��Ʋɼ�[', 4, 'Y', 'ZC_TEMP_MAKE_CODE_GEN', 'ZC_TEMP_MAKE_CODE', null, 'Y', '��', to_date('26-11-2013 10:56:44', 'dd-mm-yyyy hh24:mi:ss'));

--5.
delete from as_option o where o.opt_id='OPT_ZC_CGZX_CODE' ;

insert into as_option (OPT_ID, CO_CODE, COMPO_ID, TRANS_TYPE, OPT_VAL, IS_SYST_OPT)
values ('OPT_ZC_CGZX_CODE', '*', '*', '*', '040009', 'Y');

--6
delete from  as_val v where v.valset_id like '%ZC_VS_AUDIT_SHEET_STATUS%';

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_AUDIT_SHEET_STATUS', '0', '�༭', 0, null, 'Y', to_date('23-06-2013 19:36:03', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_AUDIT_SHEET_STATUS', '1', '�������', 2, null, 'Y', to_date('11-07-2013 22:36:20', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_AUDIT_SHEET_STATUS', '3', '�����˽���', 4, null, 'Y', to_date('26-11-2013 16:11:18', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_AUDIT_SHEET_STATUS', 'exec', '�б���', 5, null, 'Y', to_date('11-07-2013 22:36:20', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_AUDIT_SHEET_STATUS', '2', '�鳤���', 3, null, 'Y', to_date('26-11-2013 16:11:18', 'dd-mm-yyyy hh24:mi:ss'));

--7
delete from as_lang_trans l where l.res_id='ZC_FIELD_SUPERINTENDENT_ORG';
insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_FIELD_SUPERINTENDENT_ORG', 'C', '��Ŀ������');

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
values ('ZC_CGRWGL', 'ZC_EB_AUDIT_SHEET', '���쵥', 2, 'N', 'N', 'Y', '/GB/jsp/ZC/CommonPage.jsp?className=com.ufgov.zc.client.zc.auditsheet.ZcEbAuditSheetListPanelExtends');

--10
DELETE from AS_NO_RULE    where COMPO_ID = 'ZC_EB_PROJ';

insert into AS_NO_RULE (COMPO_ID, RULE_CODE, RULE_NAME, NO_PREFIX, NO_INDEX_LEN, IS_CONT, NUM_TOOL_ID, NO_FIELD, IS_INCL_ATOZ, IS_FILL_ZERO, NO_AFTFIX, TRANS_DATE)
values ('ZC_EB_PROJ', 'PROJ_CODE', '����ְ�', 'YZCG', 4, 'Y', 'ZC_EB_PROJ_GEN', 'PROJ_CODE', null, 'Y', null, to_date('26-11-2013 23:59:12', 'dd-mm-yyyy hh24:mi:ss'));

--11
delete from ZC_B_AGENCY;

insert into ZC_B_AGENCY (ZC_AGEY_CODE, ZC_AGEY_NAME, ZC_AGEY_JGDM, ZC_AGEY_ADDR, ZC_AGEY_ZIP, ZC_AGEY_LINKMAN, ZC_AGEY_TEL, ZC_AGEY_TYPE, ZC_RANDOM_ID, ZC_INPUT_EMP_CODE, ZC_INPUT_DATE, ZC_INPUT_EMP_NAME, ZC_AUDIT_EMP_CODE, ZC_AUDIT_DATE, ZC_AUDIT_EMP_NAME, ZC_STAT_CODE, ZC_DIYU_DAIMA, ZC_ORDER_INDEX, START_TIME, END_TIME)
values ('040009', '�����������ɹ�����', null, '����ʡ������������·168��', '212299', null, '0511-88361205,88358235', '2', null, null, null, null, null, null, null, '1', null, 1, null, null);

--12
delete from as_val v where v.val like 'VS_ZC_OPEN_ADDRESS';

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_ZC_OPEN_ADDRESS', '����ʡ������������·168�� 1������', '����ʡ������������·168�� 1������', null, null, 'Y', to_date('27-11-2013 01:27:56', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_ZC_OPEN_ADDRESS', '����ʡ������������·168�� 2������', '����ʡ������������·168�� 2������', null, null, 'Y', to_date('27-11-2013 01:27:56', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_ZC_OPEN_ADDRESS', '����ʡ������������·168�� 3������', '����ʡ������������·168�� 3������', null, null, 'Y', to_date('27-11-2013 01:27:56', 'dd-mm-yyyy hh24:mi:ss'));

--13
insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_PROJ_STATUS', '80', '�ɹ������', 7, null, 'N', to_date('27-11-2013 01:38:33', 'dd-mm-yyyy hh24:mi:ss'));

--14
delete from as_val v where v.valset_id='VS_ZC_EB_MEMBER_TYPE';

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_ZC_EB_MEMBER_TYPE', '4', '�ɹ���λ����', 4, null, 'Y', to_date('01-01-2014 13:46:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_ZC_EB_MEMBER_TYPE', '5', '�ල��Ա', 5, null, 'Y', to_date('01-01-2014 13:46:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_ZC_EB_MEMBER_TYPE', '1', '������', 1, null, 'Y', to_date('01-01-2014 13:46:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_ZC_EB_MEMBER_TYPE', '2', '������', 2, null, 'Y', to_date('01-01-2014 13:46:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_ZC_EB_MEMBER_TYPE', '3', '��¼��', 3, null, 'Y', to_date('01-01-2014 13:46:42', 'dd-mm-yyyy hh24:mi:ss'));

--15
insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_ZC_EB_EVAL_COMPLIANCE_RESULT', 'N', '��ͨ��', 2, null, 'N', to_date('31-12-2013 16:17:55', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_ZC_EB_EVAL_COMPLIANCE_RESULT', 'Y', 'ͨ��', 1, null, 'N', to_date('31-12-2013 16:17:55', 'dd-mm-yyyy hh24:mi:ss'));

--16
-- Add/modify columns 
alter table ZC_EB_EVAL_REPORT add executor_name VARCHAR2(200);
-- Add comments to the columns 
comment on column ZC_EB_EVAL_REPORT.executor_name
  is 'ִ��������';

--20131128
--1
insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CSZGY', 'ZcXmcgHt_entrustTab', 'draft');

--2
insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HT_STATUS', '6', '�ɹ������', 5, null, 'Y', to_date('28-11-2013 14:13:43', 'dd-mm-yyyy hh24:mi:ss'));

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
values ('ZcEbAuditSheetTab', 'untread', '�˻�', 3, 'ZC_EB_AUDIT_SHEET', null, '���쵥', 'tab', '304');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbAuditSheetTab', 'all', 'ȫ��', 5, 'ZC_EB_AUDIT_SHEET', null, '���쵥', 'tab', '306');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbAuditSheetTab', 'done', '�����', 2, 'ZC_EB_AUDIT_SHEET', null, '���쵥', 'tab', '303');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbAuditSheetTab', 'draft', '�ݸ�', 7, 'ZC_EB_AUDIT_SHEET', null, '���쵥', 'tab', '301');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbAuditSheetTab', 'exec', '����', 4, 'ZC_EB_AUDIT_SHEET', null, '���쵥', 'tab', '305');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbAuditSheetTab', 'todo', '�����', 1, 'ZC_EB_AUDIT_SHEET', null, '���쵥', 'tab', '302');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbAuditSheetCondition', 'CO_CODE', '�ɹ���λ', 3, 'ZC_EB_AUDIT_SHEET', null, '�ɹ���λ', 'condition', '103');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbAuditSheetTab', 'cancel', 'ȡ��', 6, 'ZC_EB_AUDIT_SHEET', null, '���쵥', 'tab', '301');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbAuditSheetCondition', 'ZC_PIFU_CGFS', '�ɹ���ʽ', 5, 'ZC_EB_AUDIT_SHEET', null, '�ɹ���ʽ', 'condition', '103');



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
values ('fsendKsld', '�Ϳ����쵼', 1, null, 'N', null, null, null, null);

insert into as_compo_func (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_QUESTIONDTS', 'fsendKsld', 'Y', null, to_date('20-06-2013 22:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_FUNC_fsendKsld', 'C', '�Ϳ����쵼���');

--2
insert into AS_NO_RULE (COMPO_ID, RULE_CODE, RULE_NAME, NO_PREFIX, NO_INDEX_LEN, IS_CONT, NUM_TOOL_ID, NO_FIELD, IS_INCL_ATOZ, IS_FILL_ZERO, NO_AFTFIX, TRANS_DATE)
values ('ZC_EB_QUESTIONDTS', 'ZC_EB_QUESTIONDTS_ID', '����', 'QUR', null, 'Y', 'ZC_EB_QUESTIONDTS_ID_GEN', 'QUES_ID', null, 'Y', null, to_date('07-12-2013 06:26:06', 'dd-mm-yyyy hh24:mi:ss'));
insert into AS_NUM_TOOL (NUM_TOOL_ID, NUM_TOOL_NAME, IS_CONT, NUM_TOOL_DESC)
values ('ZC_EB_QUESTIONDTS_ID_GEN', '����', 'N', null);
insert into AS_NUM_TOOL_NO (NUM_TOOL_ID, FIX_PREFIX, ALT_PREFIX, NUM_NO)
values ('ZC_EB_QUESTIONDTS_ID_GEN', 'QUR', 'noPreFix', 0);

--3

delete from as_compo c where c.compo_id='ZC_EB_QUESTIONDTS' ;
insert into as_compo (COMPO_ID, COMPO_NAME, MASTER_TAB_ID, TRAD_ID, COMPO_TYPE, ICON_NAME, CONDITION, NO_FIELD, TYPE_FIELD, TYPE_TABLE, PARENT_COMPO, PAGE_FIELD, DATE_FIELD, VALSET_FIELD, WF_FLOW_TYPE, WF_LIST_TYPE, DEFAULT_WF_TEMPLATE, TEMPLATE_IS_USED, IS_AUTO_LIST, ORDER_BY, IS_GRANT_TO_ALL, PRINT_TYPE, TITLE_FIELD, TITLE_DATE, WF_BRIEF_FIELDS, IS_FUNC_CONTROL)
values ('ZC_EB_QUESTIONDTS', '����', 'ZC_EB_QUESTION', null, 'M', null, null, null, null, null, null, null, null, null, 'workflow', 'WF_COMPO', '30966', 'Y', 'Y', null, null, '0', 'PERSONORG', null, null, 'ZC');

--20131206 δ���µ����ݿ������
--1.
delete from zc_search_condition s where s.compo_id='ZC_EB_QUESTIONDTS';
insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZC_EB_QUESTIONDTS_Tab', 'draft', '�ݸ�', 1, 'ZC_EB_QUESTIONDTS', '����', '���ɲ�ѯҳǩ', 'tab', '301');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZC_EB_QUESTIONDTS_Tab', 'exec', '����', 4, 'ZC_EB_QUESTIONDTS', '����', '���ɲ�ѯҳǩ', 'tab', '301');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZC_EB_QUESTIONDTS_Tab', 'todo', '�����', 2, 'ZC_EB_QUESTIONDTS', '����', '���ɲ�ѯҳǩ', 'tab', '301');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZC_EB_QUESTIONDTS_Tab', 'done', '�����', 3, 'ZC_EB_QUESTIONDTS', '����', '���ɲ�ѯҳǩ', 'tab', '301');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZC_EB_QUESTIONDTS_Tab', 'untread', '�˻�', 6, 'ZC_EB_QUESTIONDTS', '����', '���ɲ�ѯҳǩ', 'tab', '301');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZC_EB_QUESTIONDTS_Tab', 'all', 'ȫ��', 7, 'ZC_EB_QUESTIONDTS', '����', '���ɲ�ѯҳǩ', 'tab', '301');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZC_EB_QUESTIONDTS_Tab', 'execing', '������', 8, 'ZC_EB_QUESTIONDTS', '����', '���ɲ�ѯҳǩ', 'tab', '301');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZC_EB_QUESTIONDTS_Tab', 'reply', '�ѻظ�', 9, 'ZC_EB_QUESTIONDTS', '����', '���ɲ�ѯҳǩ', 'tab', '301');

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
  is '����¼����';
  
----4
alter table AS_TAB_COL modify data_item_na VARCHAR2(300);

--5

delete from as_tab_col t where t.tab_id= 'ZC_EB_QUESTION';
insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'AGENCY', 0, '�������', '�������', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'CLIENT_FILENAME', 0, '��Ӧ����������ļ�', '��Ӧ����������ļ�', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'CLIENT_REASON', 0, '��Ӧ���������', '��Ӧ���������', 'VARCHAR2', 400, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'CLIENT_SUBMIT_TSDATE', 0, 'CLIENT_SUBMIT_TSDATE', 'CLIENT_SUBMIT_TSDATE', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'CLIENT_SUBMIT_ZYDATE', 0, '��Ӧ�������ύ����', '��Ӧ�������ύ����', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'CO_CODE', 0, '�ɹ���λ����', '�ɹ���λ����', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'CREATEDATE', 0, '��������', '��������', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'DW_FILENAME', 0, '�ɹ���λ����ļ�', '�ɹ���λ����ļ�', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'HANDLE_MODE', 0, '���ɴ���ģʽ ZC_VS_QUES_ALL_MODE 
1  ������
2  ���ɲ�����
3  ���ɳ������������б��ļ�
4  ���ɳ����������б��ļ�
5  ���ɳ�������ʣ�๩Ӧ��������
6	���ɳ���������ȷ������
7	���ɳ�������ͬ����
', '���ɴ���ģʽ ZC_VS_QUES_ALL_MODE 
1  ������
2  ���ɲ�����
3  ���ɳ������������б��ļ�
4  ���ɳ����������б��ļ�
5  ���ɳ�������ʣ�๩Ӧ��������
6	���ɳ���������ȷ������
7	���ɳ�������ͬ����
', 'VARCHAR2', 2, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'ID', 0, '����ID', '����ID', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'JB_DODATE', 0, '�б겿�Ŵ�������', '�б겿�Ŵ�������', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'JB_FILENAME', 0, '�б겿������ļ�', '�б겿������ļ�', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'JB_PERSON', 0, '�б���', '�б���', 'VARCHAR2', 20, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'JB_REASON', 0, '�б겿�����', '�б겿�����', 'VARCHAR2', 400, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'ND', 0, '���', '���', 'VARCHAR2', 4, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'ORG_CODE', 0, '�б긺����', '�б긺����', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'PERSON', 0, '��Ӧ�̸�����', '��Ӧ�̸�����', 'VARCHAR2', 20, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'PERSONORG', 0, '��Ӧ�̵�λ����', '��Ӧ�̵�λ����', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'PERSON_TEL', 0, '��Ӧ�̵绰', '��Ӧ�̵绰', 'VARCHAR2', 20, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'PROCESS_INST_ID', 0, 'PROCESS_INST_ID', 'PROCESS_INST_ID', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'PROJ', 0, '��Ŀ����', '��Ŀ����', 'VARCHAR2', 20, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'QUES_ID', 0, '����ID', '����ID', 'VARCHAR2', 38, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'QUES_TYPE', 0, '�������ͣ�1-�б��ļ���2-�б�����3-��ͬ���ɣ�', '�������ͣ�1-�б��ļ���2-�б�����3-��ͬ���ɣ�', 'VARCHAR2', 2, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'SENUSER', 0, 'SENUSER', 'SENUSER', 'VARCHAR2', 1, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'STATE', 0, '״̬', '״̬', 'VARCHAR2', 20, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'TEMP', 0, '�ɹ���λ���', '�ɹ���λ���', 'VARCHAR2', 40, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'TEMP1', 0, 'TEMP1', 'TEMP1', 'VARCHAR2', 40, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'TEMP2', 0, 'TEMP2', 'TEMP2', 'VARCHAR2', 40, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_QUESTION', 'TEMP3', 0, '����¼����id', '����¼����id', 'VARCHAR2', 40, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

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
  is '��ͬ����';
comment on column ZC_XMCG_HT.zc_diyu_daima
  is '�������';
comment on column ZC_XMCG_HT.zc_ht_name
  is '��ͬ����';
comment on column ZC_XMCG_HT.zc_ht_type
  is '��ͬ����';
comment on column ZC_XMCG_HT.zc_req_code
  is 'Э��ɹ��������';
comment on column ZC_XMCG_HT.zc_make_code
  is '�ɹ��ƻ����';
comment on column ZC_XMCG_HT.zc_bid_code
  is '�б����';
comment on column ZC_XMCG_HT.co_code
  is '��λ����';
comment on column ZC_XMCG_HT.nd
  is '���';
comment on column ZC_XMCG_HT.zc_sgn_date
  is '��ͬǩ������';
comment on column ZC_XMCG_HT.zc_su_name
  is '��Ӧ������';
comment on column ZC_XMCG_HT.zc_jckdl_mc
  is '�����ڴ���������';
comment on column ZC_XMCG_HT.zc_ht_num
  is '��ͬ���';
comment on column ZC_XMCG_HT.zc_cz_level
  is '��������';
comment on column ZC_XMCG_HT.zc_fukuan_type
  is '���ʽ';
comment on column ZC_XMCG_HT.zc_fukuan_yued
  is '����Լ��';
comment on column ZC_XMCG_HT.zc_check_type
  is '�����ʽ';
comment on column ZC_XMCG_HT.zc_con_text
  is '��ͬ�ı�';
comment on column ZC_XMCG_HT.zc_con_text_blobid
  is '��ͬ�ı�id';
comment on column ZC_XMCG_HT.zc_ht_status
  is '��ͬ״̬';
comment on column ZC_XMCG_HT.zc_agey_code
  is '�н��������';
comment on column ZC_XMCG_HT.zc_zg_cs_code
  is '���ܿ��Ҵ���';
comment on column ZC_XMCG_HT.zc_sm_pj1
  is '����1';
comment on column ZC_XMCG_HT.zc_sm_pj2
  is '����2';
comment on column ZC_XMCG_HT.zc_sm_pj3
  is '����3';
comment on column ZC_XMCG_HT.zc_sm_pj4
  is '����4';
comment on column ZC_XMCG_HT.executor
  is 'ִ���ߣ�¼���˴��룩';
comment on column ZC_XMCG_HT.execute_date
  is 'ִ��ʱ�䣨¼�����ڣ�';
comment on column ZC_XMCG_HT.zc_parht_code
  is '����ͬ����';
comment on column ZC_XMCG_HT.zc_su_code
  is '��Ӧ�̴���';
comment on column ZC_XMCG_HT.zc_su_acc_code
  is '��Ӧ���ʺ�';
comment on column ZC_XMCG_HT.zc_su_bank_code
  is '��Ӧ�̿������д���';
comment on column ZC_XMCG_HT.zc_su_bank_name
  is '��Ӧ�̿�����������';
comment on column ZC_XMCG_HT.zc_su_tel
  is '��Ӧ�̵绰';
comment on column ZC_XMCG_HT.zc_su_linkman
  is '��Ӧ����ϵ��';
comment on column ZC_XMCG_HT.zc_is_zxqy_zb
  is '�Ƿ���С��ҵ�б�';
comment on column ZC_XMCG_HT.zc_gnw
  is '������';
comment on column ZC_XMCG_HT.zc_snw
  is 'ʡ����';
comment on column ZC_XMCG_HT.zc_arrive_addr
  is '�����ص�';
comment on column ZC_XMCG_HT.zc_arrive_date
  is '����ʱ��';
comment on column ZC_XMCG_HT.zc_hangye_ctg
  is '��λ����';
comment on column ZC_XMCG_HT.zc_sk_ren
  is 'δ��';
comment on column ZC_XMCG_HT.zc_zb_name
  is '�б�������';
comment on column ZC_XMCG_HT.zc_zb_code
  is '�б��̴���';
comment on column ZC_XMCG_HT.zc_bi_nzjz_sum
  is '��ͬ��ת���';
comment on column ZC_XMCG_HT.zc_isrewrite
  is 'δ��';
comment on column ZC_XMCG_HT.zc_cg_leixing
  is '�ɹ�����';
comment on column ZC_XMCG_HT.zc_zg_cs_name
  is '���ܿ�������';
comment on column ZC_XMCG_HT.zc_bgsp_bh
  is '�������';
comment on column ZC_XMCG_HT.zc_delivery_evl
  is '��������';
comment on column ZC_XMCG_HT.zc_price_evl
  is '�۸�����';
comment on column ZC_XMCG_HT.zc_quantity_evl
  is '��������';
comment on column ZC_XMCG_HT.zc_service_evl
  is '��������';
comment on column ZC_XMCG_HT.zc_memo
  is '��ע';
comment on column ZC_XMCG_HT.zc_bid_content
  is 'ѡ���б�';
comment on column ZC_XMCG_HT.zc_delivery_date
  is '��������';
comment on column ZC_XMCG_HT.zc_delivery_addr
  is '�����ص�';
comment on column ZC_XMCG_HT.zc_delivery_type
  is '������ʽ';
comment on column ZC_XMCG_HT.agency
  is '����������';
comment on column ZC_XMCG_HT.org_code
  is '���ұ��';
comment on column ZC_XMCG_HT.zc_pro_limit_start_date
  is '���ڿ�ʼ����';
comment on column ZC_XMCG_HT.zc_pro_limit_end_date
  is '���ڽ�������';
comment on column ZC_XMCG_HT.zc_imp_file
  is '��ͬ����';
comment on column ZC_XMCG_HT.zc_imp_file_blobid
  is '��ͬ����id';
comment on column ZC_XMCG_HT.proj_code
  is '�б���Ŀ���';
comment on column ZC_XMCG_HT.proj_name
  is '�б���Ŀ����';
  
--2
      delete from as_tab_col t where t.tab_id='ZC_XMCG_HT';
      insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'AGENCY', 0, '����������', '����������', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'CO_CODE', 0, '��λ����', '��λ����', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'EXECUTE_DATE', 0, 'ִ��ʱ�䣨¼�����ڣ�', 'ִ��ʱ�䣨¼�����ڣ�', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'EXECUTOR', 0, 'ִ���ߣ�¼���˴��룩', 'ִ���ߣ�¼���˴��룩', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ND', 0, '���', '���', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ORG_CODE', 0, '���ұ��', '���ұ��', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'PROCESS_INST_ID', 0, 'PROCESS_INST_ID', 'PROCESS_INST_ID', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'PROJ_CODE', 0, '�б���Ŀ���', '�б���Ŀ���', 'VARCHAR2', 100, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'PROJ_NAME', 0, '�б���Ŀ����', '�б���Ŀ����', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'REG_CODE', 0, 'REG_CODE', 'REG_CODE', 'VARCHAR2', 42, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'SCALE', 0, 'SCALE', 'SCALE', 'VARCHAR2', 2, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_AGEY_CODE', 0, '�н��������', '�н��������', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_ARRIVE_ADDR', 0, '�����ص�', '�����ص�', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_ARRIVE_DATE', 0, '����ʱ��', '����ʱ��', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_BGSP_BH', 0, '�������', '�������', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_BID_CODE', 0, '�б����', '�б����', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_BID_CONTENT', 0, 'ѡ���б�', 'ѡ���б�', 'VARCHAR2', 100, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_BI_NZJZ_SUM', 0, '��ͬ��ת���', '��ͬ��ת���', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_CG_LEIXING', 0, '�ɹ�����', '�ɹ�����', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_CHECK_TYPE', 0, '�����ʽ', '�����ʽ', 'VARCHAR2', 10, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_CON_TEXT', 0, '��ͬ�ı�', '��ͬ�ı�', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_CON_TEXT_BLOBID', 0, '��ͬ�ı�id', '��ͬ�ı�id', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_CZ_LEVEL', 0, '��������', '��������', 'VARCHAR2', 1, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_DELIVERY_ADDR', 0, '�����ص�', '�����ص�', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_DELIVERY_DATE', 0, '��������', '��������', 'VARCHAR2', 100, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_DELIVERY_EVL', 0, '��������', '��������', 'VARCHAR2', 4, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_DELIVERY_TYPE', 0, '������ʽ', '������ʽ', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_DIYU_DAIMA', 0, '�������', '�������', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_FUKUAN_TYPE', 0, '���ʽ', '���ʽ', 'VARCHAR2', 4, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_FUKUAN_YUED', 0, '����Լ��', '����Լ��', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_GNW', 0, '������', '������', 'VARCHAR2', 10, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_HANGYE_CTG', 0, '��λ����', '��λ����', 'VARCHAR2', 10, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_HT_CODE', 0, '��ͬ����', '��ͬ����', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_HT_NAME', 0, '��ͬ����', '��ͬ����', 'VARCHAR2', 100, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_HT_NUM', 0, '��ͬ���', '��ͬ���', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_HT_STATUS', 0, '��ͬ״̬', '��ͬ״̬', 'VARCHAR2', 10, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_HT_TYPE', 0, '��ͬ����', '��ͬ����', 'VARCHAR2', 1, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_IMP_FILE', 0, '��ͬ����', '��ͬ����', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_IMP_FILE_BLOBID', 0, '��ͬ����id', '��ͬ����id', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_ISREWRITE', 0, 'δ��', 'δ��', 'VARCHAR2', 2, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_IS_ZXQY_ZB', 0, '�Ƿ���С��ҵ�б�', '�Ƿ���С��ҵ�б�', 'VARCHAR2', 10, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_JCKDL_MC', 0, '�����ڴ���������', '�����ڴ���������', 'VARCHAR2', 100, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_MAKE_CODE', 0, '�ɹ��ƻ����', '�ɹ��ƻ����', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_MEMO', 0, '��ע', '��ע', 'VARCHAR2', 300, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_PARHT_CODE', 0, '����ͬ����', '����ͬ����', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_PRICE_EVL', 0, '�۸�����', '�۸�����', 'VARCHAR2', 4, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_PRO_LIMIT_END_DATE', 0, '���ڽ�������', '���ڽ�������', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_PRO_LIMIT_START_DATE', 0, '���ڿ�ʼ����', '���ڿ�ʼ����', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_QUANTITY_EVL', 0, '��������', '��������', 'VARCHAR2', 4, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_REQ_CODE', 0, 'Э��ɹ��������', 'Э��ɹ��������', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_SERVICE_EVL', 0, '��������', '��������', 'VARCHAR2', 4, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_SGN_DATE', 0, '��ͬǩ������', '��ͬǩ������', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_SK_REN', 0, 'δ��', 'δ��', 'VARCHAR2', 100, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_SM_PJ1', 0, '����1', '����1', 'VARCHAR2', 1, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_SM_PJ2', 0, '����2', '����2', 'VARCHAR2', 1, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_SM_PJ3', 0, '����3', '����3', 'VARCHAR2', 1, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_SM_PJ4', 0, '����4', '����4', 'VARCHAR2', 1, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_SNW', 0, 'ʡ����', 'ʡ����', 'VARCHAR2', 10, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_SU_ACC_CODE', 0, '��Ӧ���ʺ�', '��Ӧ���ʺ�', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_SU_BANK_CODE', 0, '��Ӧ�̿������д���', '��Ӧ�̿������д���', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_SU_BANK_NAME', 0, '��Ӧ�̿�����������', '��Ӧ�̿�����������', 'VARCHAR2', 100, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_SU_CODE', 0, '��Ӧ�̴���', '��Ӧ�̴���', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_SU_LINKMAN', 0, '��Ӧ����ϵ��', '��Ӧ����ϵ��', 'VARCHAR2', 100, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_SU_NAME', 0, '��Ӧ������', '��Ӧ������', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_SU_TEL', 0, '��Ӧ�̵绰', '��Ӧ�̵绰', 'VARCHAR2', 100, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_ZB_CODE', 0, '�б��̴���', '�б��̴���', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_ZB_NAME', 0, '�б�������', '�б�������', 'VARCHAR2', 100, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_ZG_CS_CODE', 0, '���ܿ��Ҵ���', '���ܿ��Ҵ���', 'VARCHAR2', 10, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into AS_TAB_COL (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_XMCG_HT', 'ZC_ZG_CS_NAME', 0, '���ܿ�������', '���ܿ�������', 'VARCHAR2', 100, null, null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

--3
insert into as_option (OPT_ID, CO_CODE, COMPO_ID, TRANS_TYPE, OPT_VAL, IS_SYST_OPT)
values ('OPT_ZC_SUB_HT_SUM_IS_LIMITED', '*', '*', '*', 'Y', 'Y');

insert into as_option (OPT_ID, CO_CODE, COMPO_ID, TRANS_TYPE, OPT_VAL, IS_SYST_OPT)
values ('OPT_ZC_SUB_HT_SUM_PERCENT', '*', '*', '*', '0.1', 'Y');

--20131109
--1

delete from as_val v where v.valset_id like 'ZC_VS_HT_STATUS';
insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HT_STATUS', '2', '�ɹ���λ�������', 3, null, 'Y', to_date('14-08-2013 00:54:44', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HT_STATUS', '3', '�б긺�������', 4, null, 'Y', to_date('14-08-2013 00:54:44', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HT_STATUS', '4', '�������', 5, null, 'Y', to_date('14-08-2013 00:54:44', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HT_STATUS', '5', '�ɹ���λ���������', 2, null, 'Y', to_date('11-12-2013 18:18:41', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HT_STATUS', '1', '�ɹ���λ���������', 2, null, 'Y', to_date('11-12-2013 18:18:41', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HT_STATUS', '0', '��ͬ����', 1, null, 'Y', to_date('14-08-2013 00:54:44', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HT_STATUS', 'exec', '����', 6, null, 'Y', to_date('14-08-2013 00:54:44', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HT_STATUS', 'supplier_send', '��Ӧ���ύ', 7, null, 'Y', to_date('14-08-2013 11:06:58', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HT_STATUS', 'danwei_back', '��λ�˻�', 8, null, 'Y', to_date('14-08-2013 11:06:58', 'dd-mm-yyyy hh24:mi:ss'));


--20131210
--1
-- Add/modify columns 
alter table ZC_XMCG_HT_BI add gb_name VARCHAR2(60);
alter table ZC_XMCG_HT_BI add bt_name VARCHAR2(60);
-- Add comments to the columns 
comment on column ZC_XMCG_HT_BI.gb_name
  is '�Ƿ������ɹ�';
comment on column ZC_XMCG_HT_BI.bt_name
  is '�Ƿ�ලʹ��';     
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
values ('ZC_PRO_END_YEAR_END', '��Ŀ�������ת', 'ZC_P_PRO_MAKE', null, 'M', null, null, null, null, null, null, null, null, null, null, null, null, 'N', 'Y', null, null, '0', null, null, null, 'Y ');

--4
insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('ZC_PRO_END_YEAR_END', 'C', '��Ŀ�������ת');

--5
insert into jl_cgb.as_compo_func (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_PRO_END_YEAR_END', 'fcarraryNew', null, null, null);

insert into jl_cgb.as_compo_func (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_PRO_END_YEAR_END', 'fcarrarylock', null, null, null);

insert into jl_cgb.as_compo_func (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_PRO_END_YEAR_END', 'ffinishitem', null, null, null);


--6
insert into as_func (FUNC_ID, FUNC_DESC, ORD_INDEX, IS_GRANT_TO_ALL, IS_LIST, SHORTCUT_KEY, IS_CTRL, IS_SHIFT, IS_ALT)
values ('fcarrarylock', '��ת����', 913, null, 'Y', null, null, null, null);

insert into as_func (FUNC_ID, FUNC_DESC, ORD_INDEX, IS_GRANT_TO_ALL, IS_LIST, SHORTCUT_KEY, IS_CTRL, IS_SHIFT, IS_ALT)
values ('fcarraryNew', '��ת����', 913, null, 'Y', null, null, null, null);

--7
insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('fcarrarylock', 'C', '��ת����');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('fcarraryNew', 'C', '��ת����');

--8
insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcYearEnd_entrustTab', '30', '��ת���', 6, 'ZC_PRO_END_YEAR_END', null, '��ת����ҳǩ', 'tab', '301');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcYearEnd_entrustTab', '21', '��ת����(�ֶ�)', 5, 'ZC_PRO_END_YEAR_END', null, '��ת����ҳǩ', 'tab', '301');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcYearEnd_entrustTab', '20', '��ת����', 4, 'ZC_PRO_END_YEAR_END', null, '��ת����ҳǩ', 'tab', '301');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcYearEnd_entrustTab', '10', '�ѽ���', 2, 'ZC_PRO_END_YEAR_END', null, '��ת����ҳǩ', 'tab', '301');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcYearEnd_entrustTab', '11', '������', 1, 'ZC_PRO_END_YEAR_END', null, '��ת����ҳǩ', 'tab', '301');

insert into zc_search_condition (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcYearEnd_entrustTab', '00', '����ת', 3, 'ZC_PRO_END_YEAR_END', null, '��ת����ҳǩ', 'tab', '301');

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
values ('fjieZhuanBaseData', '��ת��������', 42, null, 'N', null, null, null, null);

insert into as_compo_func (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_PRO_END_YEAR_END', 'fjieZhuanBaseData', null, null, to_date('21-10-2010 16:43:33', 'dd-mm-yyyy hh24:mi:ss'));

--12
insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('ZC_FUNC_fjieZhuanBaseData', 'C', '�������Ͻ�ת');

--13
create or replace procedure sp_zc_jiChuZiLiaoJieZhuan(curNd in varchar2) is
begin
  --��תas_emp_position
  delete from as_emp_position where nd=curNd+1;
  insert into as_emp_position
  select emp_code, posi_code, org_code, co_code, emp_posi_id, nd+1, sysdate from as_emp_position where nd=curNd;

--��תas_org
  delete from as_org where nd=curNd+1;
  insert into as_org 
  select co_code, org_code, org_name, parent_org_code, is_lowest, quic_code, prin_code, linkman, tele, org_id, org_type_code, nd+1, is_need_send_bank, sysdate, SYS_GUID(), trigger_enable from as_org where nd=curNd;

--��תas_org_position
  delete from as_org_position where nd=curNd+1;
  insert into as_org_position 
  select co_code, posi_code, org_code, leader_posi_id, org_posi_id, nd+1, sysdate from as_org_position where nd=curNd;
 
--��ת as_wf_business_superior
/*delete from as_wf_business_superior where nd=curNd+1;
insert into as_wf_business_superior
select id, jun_co_code, jun_org_code, jun_posi_code, jun_emp_code, sup_condition, sup_co_code, sup_org_code, sup_posi_code, sup_emp_code, project_name, description, priority, nd+1 from as_wf_business_superior where nd=curNd;
*/
--��ת ma_company
delete from ma_company where nd=curNd+1;
insert into ma_company
select co_code, co_type_code, gb_code, co_name, co_fullna, quic_code, mark, post_code, comm_addr, address, url, link_man, co_clerk, co_leader, fi_leader, loca_tele, director_code, parent_co_code, f_co_code, is_used, f_org_code, is_self, bank_acc, shop_card_no, corp_repr, trade_name, country, province, city, real_co_code, is_lowest, nd+1, fina_level, co_kind, is_pilot, is_need_send_bank, region_code, sysdate, is_need_send_bank_sl, co_type_code_1, can_getbill, getbill_id, can_charge, turn_in_acct, nt_acc_id, nt_acc_name, nt_hesuan_co_code, sys_guid(), trigger_enable, pr_bi_cocode from ma_company where nd=curNd;

--��ת ZC_B_CATALOGUE
delete  from ZC_B_CATALOGUE where zc_year=curNd+1;
insert into ZC_B_CATALOGUE 
select zc_year+1, zc_catalogue_code, zc_catalogue_name, zc_catalogue_code_par, zc_catalogue_type, zc_quota, zc_metric_unit, zc_is_vital, zc_is_used, zc_target_type, zc_pinmu_ctlg, zc_is_cgzx_zg, zc_is_general, zc_year, zc_diyu_daima, zc_quota_unit, zc_cg_leixing, zc_zcgz_std, zc_is_assert, zc_catalogue_name_par, zc_is_dianzi_toubiao, zc_jj_pp_num, zc_jj_price_quota from zc_b_catalogue where zc_year=curNd;

end sp_zc_jiChuZiLiaoJieZhuan;















