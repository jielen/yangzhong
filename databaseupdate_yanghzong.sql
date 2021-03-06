
 ----------------20160426---------------
--1
insert into ma_company (CO_CODE, CO_TYPE_CODE, GB_CODE, CO_NAME, CO_FULLNA, QUIC_CODE, MARK, POST_CODE, COMM_ADDR, ADDRESS, URL, LINK_MAN, CO_CLERK, CO_LEADER, FI_LEADER, LOCA_TELE, DIRECTOR_CODE, PARENT_CO_CODE, F_CO_CODE, IS_USED, F_ORG_CODE, IS_SELF, BANK_ACC, SHOP_CARD_NO, CORP_REPR, TRADE_NAME, COUNTRY, PROVINCE, CITY, REAL_CO_CODE, IS_LOWEST, ND, FINA_LEVEL, CO_KIND, IS_PILOT, IS_NEED_SEND_BANK, REGION_CODE, TRANS_DATE, IS_NEED_SEND_BANK_SL, CO_TYPE_CODE_1, CAN_GETBILL, GETBILL_ID, CAN_CHARGE, TURN_IN_ACCT, NT_ACC_ID, NT_ACC_NAME, NT_HESUAN_CO_CODE, GUID, TRIGGER_ENABLE, PR_BI_COCODE)
values ('910001', '02', null, '测试招标有限公司', '测试招标有限公司', null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'Y', '600', 'N', null, null, null, null, null, '*', '*', null, 'Y', 2016, '01', null, null, null, null, to_date('01-03-2016', 'dd-mm-yyyy'), 'N', null, 'Y', null, 'Y', null, null, null, null, 'AC12D45600000000300WE38500000005', 1, null);

--2

insert into as_role (ROLE_ID, ROLE_NAME, ROLE_DESC, CO_CODE)
values ('R_ZB_NORMAL', '招标通用角色', '目前用于数据权限，区分代理机构和交易中心', '*');


insert into as_role (ROLE_ID, ROLE_NAME, ROLE_DESC, CO_CODE)
values ('R_DLJG_ZX', '代理机构招标执行角色', '代理机构招标执行角色', '*');

--3

insert into AS_ROLE_NUM_LIM (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('R_ZB_NORMAL', 'fwatch', 'ZC_EB_ENTRUST', 'MASTER.AGENCY', '= ''@@svCoCode''', null, '0', 'N');

--4

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('R_DLJG_ZX', 'ZcEbEntrust_Tab', 'all');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('R_DLJG_ZX', 'ZcEbEntrust_Tab', 'draft');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('R_DLJG_ZX', 'ZcEbEntrust_Tab', 'exec');

--5

insert into AS_ROLE_FUNC (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_PROJ', 'faccepted', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_ROLE_FUNC (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_PROJ', 'fagreecommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_ROLE_FUNC (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_PROJ', 'fauditfinal', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_ROLE_FUNC (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_PROJ', 'fautocommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_ROLE_FUNC (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_PROJ', 'fback', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_ROLE_FUNC (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_PROJ', 'fcallback', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_ROLE_FUNC (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_PROJ', 'fdelete', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_ROLE_FUNC (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_PROJ', 'fdisagreecommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_ROLE_FUNC (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_PROJ', 'fedit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_ROLE_FUNC (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_PROJ', 'finterruptinstance', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_ROLE_FUNC (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_PROJ', 'fmanualcommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_ROLE_FUNC (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_PROJ', 'fnew', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_ROLE_FUNC (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_PROJ', 'fnewcommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_ROLE_FUNC (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_PROJ', 'fprint', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_ROLE_FUNC (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_PROJ', 'fprint_preview', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_ROLE_FUNC (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_PROJ', 'fprn_tpl_set', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_ROLE_FUNC (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_PROJ', 'fsave', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_ROLE_FUNC (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_PROJ', 'fsavesend', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_ROLE_FUNC (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_PROJ', 'fsendnextcommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_ROLE_FUNC (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_PROJ', 'fsendprocuunit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_ROLE_FUNC (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_PROJ', 'fsendtoxieban', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_ROLE_FUNC (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_PROJ', 'fshowOpinion', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_ROLE_FUNC (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_PROJ', 'fshowinstancetrace', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_ROLE_FUNC (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_PROJ', 'funaudit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_ROLE_FUNC (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_PROJ', 'funtread', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_ROLE_FUNC (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_PROJ', 'fopenNotepad', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_ROLE_FUNC (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_PROJ', 'fgetNo', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

--6

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('R_DLJG_ZX', 'ZcEbProj_ProjTab', 'all');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('R_DLJG_ZX', 'ZcEbProj_ProjTab', 'draft');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('R_DLJG_ZX', 'ZcEbProj_ProjTab', 'exec');

--7

insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('R_ZB_NORMAL', 'fwatch', 'ZC_EB_PROJ', 'ZC_EB_PROJ.AGENCY', '= ''@@svCoCode''', null, '0', 'N');

--8

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID', 'fnew', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID', 'fnewcommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID', 'frelease', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID', 'fsave', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID', 'fsendnextcommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID', 'fsendrecord', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID', 'fsendtoxieban', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID', 'fshowinstancetrace', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID', 'funtread', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID', 'fview', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID', 'fagreecommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID', 'fautocommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID', 'fcallback', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID', 'fdelete', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID', 'fdisagreecommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID', 'fdisplay', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID', 'fedit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID', 'fexit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID', 'floadMold', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID', 'fmanualcommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID', 'fopenNotepad', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID', 'funaudit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID', 'fbuildBulletin', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID', 'freserveChangdi', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID', 'fupdateZbWordFile', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

--9

insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('R_ZB_NORMAL', 'fwatch', 'ZC_EB_BULLETIN_BID', 'ZC_EB_BULLETIN.AGENCY', '= ''@@svCoCode''', null, '0', 'N');

insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('R_ZB_NORMAL', 'fwatch', 'ZC_EB_BULLETIN_BID_xj', 'ZC_EB_BULLETIN.AGENCY', '= ''@@svCoCode''', null, '0', 'N');

insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('R_ZB_NORMAL', 'fwatch', 'ZC_EB_BULLETIN_CHG', 'ZC_EB_BULLETIN.AGENCY', '= ''@@svCoCode''', null, '0', 'N');

insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('R_ZB_NORMAL', 'fwatch', 'ZC_EB_BULLETIN_WID', 'ZC_EB_BULLETIN.AGENCY', '= ''@@svCoCode''', null, '0', 'N');

--10

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID_xj', 'fnew', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID_xj', 'fsave', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID_xj', 'fshowinstancetrace', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID_xj', 'funtread', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID_xj', 'fcallback', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID_xj', 'fdelete', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID_xj', 'fedit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID_xj', 'fexit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID_xj', 'fmanualcommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID_xj', 'fbuildBulletin', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID_xj', 'funaudit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID_xj', 'fwatch', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID_xj', 'fnewcommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

--11

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_CHG', 'fautocommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_CHG', 'fcallback', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_CHG', 'fdelete', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_CHG', 'fedit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_CHG', 'fexit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_CHG', 'floadMold', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_CHG', 'fmanualcommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_CHG', 'fnew', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_CHG', 'fnewcommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_CHG', 'frelease', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_CHG', 'fsave', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_CHG', 'fsendnextcommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_CHG', 'fshowinstancetrace', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_CHG', 'funtread', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_CHG', 'fopenNotepad', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_WID', 'fagreecommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_WID', 'fautocommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_WID', 'fcallback', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_WID', 'fdelete', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_WID', 'fdisagreecommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_WID', 'fedit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_WID', 'fexit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_WID', 'floadMold', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_WID', 'fmanualcommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_WID', 'fnew', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_WID', 'fnewcommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_WID', 'frelease', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_WID', 'fsave', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_WID', 'fsendnextcommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_WID', 'fsendrecord', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_WID', 'fsendtoxieban', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_WID', 'fshowinstancetrace', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_WID', 'funtread', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_WID', 'fopenNotepad', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

--12

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('R_DLJG_ZX', 'ZcEbBulletin_bulletinTab', 'all');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('R_DLJG_ZX', 'ZcEbBulletin_bulletinTab', 'draft');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('R_DLJG_ZX', 'ZcEbBulletin_bulletinTab', 'exec');

--13

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID_xjTab', 'all');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID_xjTab', 'draft');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('R_DLJG_ZX', 'ZC_EB_BULLETIN_BID_xjTab', 'exec');

--14

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('R_DLJG_ZX', 'ZcEbSignup_signupTab', 'audit');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('R_DLJG_ZX', 'ZcEbSignup_signupTab', 'biding');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('R_DLJG_ZX', 'ZcEbSignup_signupTab', 'opened');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('R_DLJG_ZX', 'ZcEbSignup_signupTab', 'sellEnd');

--15

insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('R_DLJG_ZX', 'fwatch', 'ZC_EB_SIGNUP', 'zc_eb_proj.agency', '=''@@svCoCode''', null, '0', 'N');

--16

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT_OFF_LINE', 'fcallback', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT_OFF_LINE', 'fdelete', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT_OFF_LINE', 'fedit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT_OFF_LINE', 'fexit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT_OFF_LINE', 'fmanualcommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT_OFF_LINE', 'fnew', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT_OFF_LINE', 'fnewcommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT_OFF_LINE', 'fprint', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT_OFF_LINE', 'fsave', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT_OFF_LINE', 'fshowinstancetrace', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT_OFF_LINE', 'funtread', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

--17

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('R_DLJG_ZX', 'ZcEbEval_reportTab', 'all');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('R_DLJG_ZX', 'ZcEbEval_reportTab', 'draft');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('R_DLJG_ZX', 'ZcEbEval_reportTab', 'exec');

--18

insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('R_ZB_NORMAL', 'fwatch', 'ZC_EB_EVAL_REPORT_OFF_LINE', 'ZC_EB_EVAL_REPORT.AGENCY', '= ''@@svCoCode''', null, '0', 'N');

--19

insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('R_ZB_NORMAL', 'fwatch', 'ZC_EB_NOTICE', 'ZC_EB_NOTICE.AGENCY', '= ''@@svCoCode''', null, '0', 'N');

--20

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_NOTICE', 'fopenNotepad', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_NOTICE', 'fnewcommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_NOTICE', 'fprint', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_NOTICE', 'frelease', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_NOTICE', 'fsave', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_NOTICE', 'fsendnextcommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_NOTICE', 'fsendtoxieban', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_NOTICE', 'funtread', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_NOTICE', 'fagreecommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_NOTICE', 'fauditfinal', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_NOTICE', 'fautocommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_NOTICE', 'fcallback', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_NOTICE', 'fdelete', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_NOTICE', 'fdisagreecommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_NOTICE', 'fedit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_NOTICE', 'fexit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_NOTICE', 'floadMold', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_NOTICE', 'fmanualcommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_NOTICE', 'fnew', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_NOTICE', 'fshowinstancetrace', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

--21

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('R_DLJG_ZX', 'ZcEbNotice_moldTab', 'all');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('R_DLJG_ZX', 'ZcEbNotice_moldTab', 'draft');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('R_DLJG_ZX', 'ZcEbNotice_moldTab', 'exec');

--22

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_XMCG_HT', 'fopenNotepad', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_XMCG_HT', 'fagreecommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_XMCG_HT', 'fcalc', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_XMCG_HT', 'fcallback', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_XMCG_HT', 'fdelete', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_XMCG_HT', 'fdisagreecommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_XMCG_HT', 'fedit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_XMCG_HT', 'fexit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_XMCG_HT', 'floadMold', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_XMCG_HT', 'fmanualcommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_XMCG_HT', 'fnew', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_XMCG_HT', 'fnewcommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_XMCG_HT', 'fprint', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_XMCG_HT', 'fsave', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_XMCG_HT', 'fselectMold', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_XMCG_HT', 'fsendnextcommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_XMCG_HT', 'fsendprocuunit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_XMCG_HT', 'fsendtoxieban', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_XMCG_HT', 'fshowcomment', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_XMCG_HT', 'fshowinstancetrace', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_XMCG_HT', 'funtread', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_XMCG_HT', 'open', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_XMCG_HT', 'zc_fcancel_ht', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_XMCG_HT', 'zc_fgencontract', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_XMCG_HT', 'fadd', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_XMCG_HT', 'fsendToDanWei', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_XMCG_HT', 'fbackToSupplier', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

--23 

insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('R_DLJG_ZX', 'fwatch', 'ZC_XMCG_HT', 'SQL_CONDITION', 'exists (
 select 1  from V_WF_ACTION_HISTORY_GK53 wf
  where wf.executor = ''@@svUserID'' and wf.instance_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum

= 1
 union
 select 1 from as_wf_draft drf where drf.user_id = ''@@svUserID'' and drf.wf_draft_id =

ZC_XMCG_HT.PROCESS_INST_ID and rownum=1
 union
 select 1 from V_WF_CURRENT_TASK_ZC_TODO ct
 where ct.executor = ''@@svUserID'' and ct.instance_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum =

1
 union
 select 1 from V_WF_CURRENT_TASK_ZC_UNTREAD ct
 where ct.executor = ''@@svUserID'' and ct.instance_id = ZC_XMCG_HT.PROCESS_INST_ID and rownum =

1
 )', null, '0', 'N');
 
--24

insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('R_DLJG_ZX', 'fwatch', 'ZC_EB_BULLETIN_WID', 'SQL_CONDITION', 'exists (
 select 1  from V_WF_ACTION_HISTORY_GK53 wf
  where wf.executor = ''@@svUserID'' and wf.instance_id = ZC_EB_BULLETIN.PROCESS_INST_ID and rownum

= 1
 union
 select 1 from as_wf_draft drf where drf.user_id = ''@@svUserID'' and drf.wf_draft_id =

ZC_EB_BULLETIN.PROCESS_INST_ID and rownum=1
 union
 select 1 from V_WF_CURRENT_TASK_ZC_TODO ct
 where ct.executor = ''@@svUserID'' and ct.instance_id = ZC_EB_BULLETIN.PROCESS_INST_ID and rownum =

1
 union
 select 1 from V_WF_CURRENT_TASK_ZC_UNTREAD ct
 where ct.executor = ''@@svUserID'' and ct.instance_id = ZC_EB_BULLETIN.PROCESS_INST_ID and rownum =

1
 )', null, '0', 'N');
 
 --25

insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('R_DLJG_ZX', 'fwatch', 'ZC_EB_BULLETIN_CHG', 'SQL_CONDITION', 'exists (
 select 1  from V_WF_ACTION_HISTORY_GK53 wf
  where wf.executor = ''@@svUserID'' and wf.instance_id = ZC_EB_BULLETIN.PROCESS_INST_ID and rownum

= 1
 union
 select 1 from as_wf_draft drf where drf.user_id = ''@@svUserID'' and drf.wf_draft_id =

ZC_EB_BULLETIN.PROCESS_INST_ID and rownum=1
 union
 select 1 from V_WF_CURRENT_TASK_ZC_TODO ct
 where ct.executor = ''@@svUserID'' and ct.instance_id = ZC_EB_BULLETIN.PROCESS_INST_ID and rownum =

1
 union
 select 1 from V_WF_CURRENT_TASK_ZC_UNTREAD ct
 where ct.executor = ''@@svUserID'' and ct.instance_id = ZC_EB_BULLETIN.PROCESS_INST_ID and rownum =

1
 )', null, '0', 'N');

--26

insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('R_DLJG_ZX', 'fwatch', 'ZC_EB_RFQ', 'SQL_CONDITION', '  exists (

 select 1  from V_WF_ACTION_HISTORY_GK53 wf
  where wf.executor = ''@@svUserID'' and wf.instance_id = master.PROCESS_INST_ID and

rownum = 1
 union
 select 1 from as_wf_draft drf where drf.user_id = ''@@svUserID'' and drf.wf_draft_id =

master.PROCESS_INST_ID and rownum=1
 union
 select 1 from V_WF_CURRENT_TASK_ZC_TODO ct
 where ct.executor = ''@@svUserID'' and ct.instance_id = master.PROCESS_INST_ID and

rownum = 1
 union
 select 1 from V_WF_CURRENT_TASK_ZC_UNTREAD ct
 where ct.executor = ''@@svUserID'' and ct.instance_id = master.PROCESS_INST_ID and

rownum = 1
)
or
master.manager_code=''@@svUserID''', null, '0', 'N');

--27

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT', 'fopenNotepad', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT', 'fprint_preview', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT', 'fprn_tpl_set', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT', 'fsave', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT', 'fsavereport', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT', 'fsavesend', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT', 'fsendnextcommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT', 'fsendprocuunit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT', 'fsendtoxieban', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT', 'fshowOpinion', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT', 'fshowinstancetrace', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT', 'funtread', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT', 'fImportOpinion', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT', 'faccepted', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT', 'fagreecommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT', 'faudit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT', 'fauditfinal', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT', 'fautocommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT', 'fbatedit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT', 'fcallback', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT', 'fcancel_accepted', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT', 'fdelete', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT', 'fdisagreecommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT', 'fedit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT', 'fexit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT', 'finterruptinstance', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT', 'fmanualcommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT', 'fnew', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT', 'fnewcommit', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('R_DLJG_ZX', 'ZC_EB_EVAL_REPORT', 'fprint', to_date('17-04-2016 21:33:42', 'dd-mm-yyyy hh24:mi:ss'));

--28

insert into AS_ROLE_NUM_LIM (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('R_ZB_NORMAL', 'fwatch', 'ZC_EB_EVAL_REPORT', 'ZC_EB_EVAL_REPORT.AGENCY', '= ''@@svCoCode''', null, '0', 'N');


 ----------------20160408---------------
--1

delete FROM ZC_SEARCH_CONDITION S where s.compo_id='ZC_EB_SIGNUP' ;

insert into ZC_SEARCH_CONDITION (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbSignup_signupTab', 'todo', '我参与的项目', 3, 'ZC_EB_SIGNUP', '供应商投标', '我参与的项目', 'tab', '303');

insert into ZC_SEARCH_CONDITION (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbSignup_signupTab', 'biding', '正在招标的项目', 0, 'ZC_EB_SIGNUP', '供应商投标', '正在招标的项目', 'tab', '301');

insert into ZC_SEARCH_CONDITION (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbSignup_signupTab', 'opened', '招标结束的项目', 2, 'ZC_EB_SIGNUP', '供应商投标', '招标结束的项目', 'tab', '302');

insert into ZC_SEARCH_CONDITION (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbSignup_signupTab', 'cancel', '我撤销报名的项目', 4, 'ZC_EB_SIGNUP', '供应商投标', '我撤销报名的项目', 'tab', '303');

insert into ZC_SEARCH_CONDITION (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbSignup_signupTab', 'sellEnd', '报名结束项目', 1, 'ZC_EB_SIGNUP', '供应商投标', '审核报名供应商', 'tab', '303');

insert into ZC_SEARCH_CONDITION (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbSignup_signupTab', 'audit', '审核报名供应商', 5, 'ZC_EB_SIGNUP', '供应商投标', '审核报名供应商', 'tab', '303');

--2

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CGZX_KY_CG', 'ZcEbSignup_signupTab', 'sellEnd');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CGZX_KY_ZH', 'ZcEbSignup_signupTab', 'sellEnd');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CGZX_KZ_CG', 'ZcEbSignup_signupTab', 'sellEnd');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CGZX_KZ_ZH', 'ZcEbSignup_signupTab', 'sellEnd');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CG_CGZXLD', 'ZcEbSignup_signupTab', 'sellEnd');


 ----------------20160402---------------
--1

insert into as_option (OPT_ID, CO_CODE, COMPO_ID, TRANS_TYPE, OPT_VAL, IS_SYST_OPT)
values ('ZC_OPTION_SUPPLIER_MOBILE_MSG', '*', '*', '*', '贵单位报名的<>项目已发补充通知，请关注原公告信息发布媒体。【扬中市公共资源交易中心】', 'Y');

--2
-- Create table
create table ZC_MOBILE_MSG_NUMBER
(
  code        VARCHAR2(60),
  mobile_hide VARCHAR2(20),
  mobile      VARCHAR2(20)
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
  
 --3
 
insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_ZC_EB_BULLETIN_TYPE', 'zhaobiao_xxxj', '线下询价招标公告', 13, null, 'Y', to_date('02-04-2016 12:51:13', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_ZC_EB_BULLETIN_TYPE', 'zhongbiao_xxxj', '线下询价中标公告', 14, null, 'Y', to_date('02-04-2016 12:51:13', 'dd-mm-yyyy hh24:mi:ss'));

--4
CREATE OR REPLACE VIEW V_ZC_NORMAL_PACK AS
select vp."PACK_CODE",
       vp."PROJ_CODE",
       vp."PUR_TYPE",
       vp."PACK_NAME",
       vp."CO_CODE",
       vp."PACK_BUDGET",
       vp."ND",
       vp.sn as ZC_MAKE_CODE
  from zc_v_pro_pack vp
 where vp.pack_code not in (SELECT pack.PACK_CODE
                              from ZC_EB_PACK pack
                             where (pack.Status = '5'
                               or pack.Status = 'cancel')
                           /* union
                            select qp.packcode
                              from zc_eb_question q, zc_eb_question_pack qp
                             where q.id = qp.id
                               and q.ques_type = '1'
                               and q.handle_mode = '4'
                               and q.status = 'exec'*/

                               );

--5
-- Add/modify columns 
alter table ZC_MOBILE_MSG add proj_code VARCHAR2(60);
alter table ZC_MOBILE_MSG add proj_name VARCHAR2(200);

----------------20160318---------------	
--1

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_PITEM_OPIWAY', '10', '线下询价', 35, null, 'N', to_date('16-03-2016 22:03:42', 'dd-mm-yyyy hh24:mi:ss'));

----------------20160315---------------	
--1

insert into as_option (OPT_ID, CO_CODE, COMPO_ID, TRANS_TYPE, OPT_VAL, IS_SYST_OPT)
values ('OPT_ZC_SEND_TO_CZ_WEB', '*', '*', '*', 'y', 'N');

----------------20160313_2---------------	 
--1

insert into as_file (FILE_ID, FILE_CONTENT, FILE_NAME, FILE_DESC, FILE_CREATOR, CONTENT_TYPE, FILE_UPLOADTIME, SUFFIX_NAME, FULL_NAME, FILE_PATH)
values ('bulletin_zhaobiao_jzxtp', '<BLOB>', '扬中竞争性谈判.xml', 'application/msword', null, null, null, null, null, null);
 

----------------20160313---------------
--1

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'ADDRESS', 0, '地址', '地址', 'VARCHAR2', 100, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'AGENCY', 0, '代理机构编号', '代理机构编号', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'BID_DOC_ID', 0, '标书存放id', '标书存放id', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'BID_DOC_NAME', 0, '标书名称', '标书名称', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'EMAIL', 0, '邮件', '邮件', 'VARCHAR2', 40, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'GUARANTEE_DATE', 0, '保证金缴纳时间', '保证金缴纳时间', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'GUARANTEE_OPERATOR', 0, '保证金受理人', '保证金受理人', 'VARCHAR2', 20, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'GUARANTEE_PAY_BILL', 0, '保证金支付凭证', '保证金支付凭证', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'GUARANTEE_PAY_TYPE', 0, '保证金支付方式，1：现金
 2：支票
 3：汇票', '保证金支付方式，1：现金
 2：支票
 3：汇票', 'VARCHAR2', 2, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'GUARANTEE_SUM', 0, '保证金金额', '保证金金额', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'IS_PAY_GUARANTEE', 0, '是否支付了投标保证金，
 投标保证金，
 0：未缴纳
 1：已缴纳 2：已退回
 ', '是否支付了投标保证金，
 投标保证金，
 0：未缴纳
 1：已缴纳 2：已退回
 ', 'VARCHAR2', 2, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'IS_SITE', 0, '是否到现场', '是否到现场', 'VARCHAR2', 2, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'IS_SUBMIT_BID_DOC', 0, '是否提交了投标书，Y：是，N：否', '是否提交了投标书，Y：是，N：否', 'VARCHAR2', 2, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'LINKMAN', 0, '联系人', '联系人', 'VARCHAR2', 20, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'MOBILE_PHONE', 0, '手机', '手机', 'VARCHAR2', 40, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'ND', 0, '年度', '年度', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'OPERATOR', 0, '报名受理人', '报名受理人', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'ORG_CODE', 0, '处室编号', '处室编号', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'PHONE', 0, '电话', '电话', 'VARCHAR2', 40, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'PROJ_CODE', 0, '项目编号', '项目编号', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'N', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'PROVIDER_CODE', 0, '供应商代码', '供应商代码', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'PROVIDER_NAME', 0, '供应商名称', '供应商名称', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'PUR_DOC_BUY_DATE', 0, '采购文件购买日期', '采购文件购买日期', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'PUR_DOC_FEE', 0, '采购文件购买费用', '采购文件购买费用', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'PUR_DOC_FEE_BILL', 0, '采购文件费用支付凭证', '采购文件费用支付凭证', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'PUR_DOC_FEE_TYPE', 0, '采购文件费用支付方式，1：现金
 2：支票
 3：汇票', '采购文件费用支付方式，1：现金
 2：支票
 3：汇票', 'VARCHAR2', 2, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'REMARK', 0, '备注', '备注', 'VARCHAR2', 100, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'SIGNUP_FILE_ID', 0, '供应商报名上传的附件id', '供应商报名上传的附件id', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'SIGNUP_FILE_NAME', 0, '供应商报名上传的附件名称', '供应商报名上传的附件名称', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'SIGNUP_ID', 0, '报名编号', '报名编号', 'VARCHAR2', 100, null, null, null, 'Y', null, null, 'Y', null, null, 'N', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'SIGNUP_MANNER', 0, '报名方式', '报名方式', 'VARCHAR2', 20, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'SINGNUP_DATE', 0, '报名日期', '报名日期', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'STATUS', 0, '报名状态，ZC_VS_SIGNUP_STATUS,
0	未报名
1	已报名
', '报名状态，ZC_VS_SIGNUP_STATUS,
0	未报名
1	已报名
', 'VARCHAR2', 10, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'SUBMIT_BID_DOC_TYPE', 0, '提交标书方式，1：网络，2：现场', '提交标书方式，1：网络，2：现场', 'VARCHAR2', 2, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_SIGNUP', 'ZIPCODE', 0, '邮政编码', '邮政编码', 'VARCHAR2', 20, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

--2

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_ADDRESS', 'C', '地址');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_AGENCY', 'C', '代理机构编号');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_BID_DOC_ID', 'C', '标书存放id');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_BID_DOC_NAME', 'C', '标书名称');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_EMAIL', 'C', '邮件');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_GUARANTEE_DATE', 'C', '保证金缴纳时间');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_GUARANTEE_OPERATOR', 'C', '保证金受理人');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_GUARANTEE_PAY_BILL', 'C', '保证金支付凭证');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_GUARANTEE_PAY_TYPE', 'C', '保证金支付方式');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_GUARANTEE_SUM', 'C', '保证金金额');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_IS_PAY_GUARANTEE', 'C', '是否支付了投标保证金');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_IS_SITE', 'C', '是否到现场');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_IS_SUBMIT_BID_DOC', 'C', '是否提交了投标书');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_LINKMAN', 'C', '联系人');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_MOBILE_PHONE', 'C', '手机');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_ND', 'C', '年度');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_OPERATOR', 'C', '报名受理人');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_ORG_CODE', 'C', '处室编号');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_PHONE', 'C', '电话');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_PROJ_CODE', 'C', '项目编号');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_PROVIDER_CODE', 'C', '供应商代码');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_PROVIDER_NAME', 'C', '供应商名称');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_PUR_DOC_BUY_DATE', 'C', '采购文件购买日期');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_PUR_DOC_FEE', 'C', '采购文件购买费用');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_PUR_DOC_FEE_BILL', 'C', '采购文件费用支付凭证');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_PUR_DOC_FEE_TYPE', 'C', '采购文件费用支付方式');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_REMARK', 'C', '备注');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_SIGNUP_FILE_ID', 'C', '供应商报名上传的附件id');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_SIGNUP_FILE_NAME', 'C', '供应商报名上传的附件名称');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_SIGNUP_ID', 'C', '报名编号');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_SIGNUP_MANNER', 'C', '报名方式');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_SINGNUP_DATE', 'C', '报名日期');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_STATUS', 'C', '报名状态');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_SUBMIT_BID_DOC_TYPE', 'C', '提交标书方式');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_SIGNUP_ZIPCODE', 'C', '邮政编码');

--3

insert into as_table (TAB_ID, MASTER_TAB_ID, TAB_NA, TAB_DESC, DB_VER_NO, TRAD_VER_NO, LSTDATE, PRE_VALSET, IS_TABLE)
values ('ZC_EB_SIGNUP', 'ZC_EB_SIGNUP', '投标报名', '投标报名', null, null, null, null, 'Y');

insert into as_table (TAB_ID, MASTER_TAB_ID, TAB_NA, TAB_DESC, DB_VER_NO, TRAD_VER_NO, LSTDATE, PRE_VALSET, IS_TABLE)
values ('ZC_EB_SIGNUP_PACK', 'ZC_EB_SIGNUP', '投标报名子表', '投标报名子表', null, null, null, null, 'Y');

--4

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('AGENCY', 'C', '代理机构编号');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('BID_DOC_ID', 'C', '标书存放id');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('BID_DOC_NAME', 'C', '标书名称');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('GUARANTEE_DATE', 'C', '保证金缴纳时间');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('GUARANTEE_OPERATOR', 'C', '保证金受理人');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('GUARANTEE_PAY_BILL', 'C', '保证金支付凭证');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('GUARANTEE_PAY_TYPE', 'C', '"保证金支付方式，1：现金 2：支票 3：汇票"');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('GUARANTEE_SUM', 'C', '保证金金额');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('IS_PAY_GUARANTEE', 'C', '"是否支付了投标保证金， 投标保证金， 0：未缴纳 1：已缴纳 2：已退回 "');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('IS_SITE', 'C', '是否到现场');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('IS_SUBMIT_BID_DOC', 'C', '是否提交了投标书，Y：是，N：否');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('MOBILE_PHONE', 'C', '手机');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('PUR_DOC_BUY_DATE', 'C', '采购文件购买日期');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('PUR_DOC_FEE', 'C', '采购文件购买费用');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('PUR_DOC_FEE_BILL', 'C', '采购文件费用支付凭证');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('PUR_DOC_FEE_TYPE', 'C', '"采购文件费用支付方式，1：现金 2：支票 3：汇票"');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('SIGNUP_FILE_ID', 'C', '供应商报名上传的附件id');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('SIGNUP_FILE_NAME', 'C', '供应商报名上传的附件名称');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('SIGNUP_ID', 'C', '报名编号');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('SIGNUP_MANNER', 'C', '报名方式');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('SINGNUP_DATE', 'C', '报名日期');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('SUBMIT_BID_DOC_TYPE', 'C', '提交标书方式，1：网络，2：现场');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZIPCODE', 'C', '邮政编码');
--5

insert into AS_PRINT_JASPERTEMP (PRN_COMPO_ID, PRN_TPL_JPCODE, PRN_TPL_NAME, PRN_TPL_OUTTYPE, PRN_TPL_REPORTTYPE, PRN_TPL_FIXROWCOUNT, PRN_TPL_VERSION, PRN_TPL_HANDLER, PRN_TPL_HANDLETIME, CO_CODE, IS_REPORT_VIEW)
values ('ZC_EB_SIGNUP', 'ZC_EB_SIGNUP_L', '投标报名信息打印模板', 0, 'subTable_L', 15, 1, 'sa', null, '*', null);

insert into AS_PRINT_JASPERTEMP (PRN_COMPO_ID, PRN_TPL_JPCODE, PRN_TPL_NAME, PRN_TPL_OUTTYPE, PRN_TPL_REPORTTYPE, PRN_TPL_FIXROWCOUNT, PRN_TPL_VERSION, PRN_TPL_HANDLER, PRN_TPL_HANDLETIME, CO_CODE, IS_REPORT_VIEW)
values ('ZC_EB_RFQ', 'ZC_EB_RFQ_L', '询价开标结果', 1, 'subTable_L', 15, 1, 'sa', null, '*', null);

--6

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_SIGNUP', 'fprint', null, null, to_date('20-06-2013 22:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_SIGNUP', 'fprint_preview', null, null, to_date('20-06-2013 22:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_SIGNUP', 'fprn_tpl_set', null, null, to_date('20-06-2013 22:56:15', 'dd-mm-yyyy hh24:mi:ss'));
--7

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_RFQ', 'fprint', null, null, to_date('20-06-2013 22:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_RFQ', 'fprint_preview', null, null, to_date('20-06-2013 22:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_RFQ', 'fprn_tpl_set', null, null, to_date('20-06-2013 22:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_RFQ', 'fexport', null, null, to_date('20-06-2013 22:56:15', 'dd-mm-yyyy hh24:mi:ss'));

--8
-- Add/modify columns 
alter table HUIYUAN_UNITCOMINFO add execute_date date;
-- Add comments to the columns 
comment on column HUIYUAN_UNITCOMINFO.execute_date
  is '操作时间';

--9

insert into as_compo (COMPO_ID, COMPO_NAME, MASTER_TAB_ID, TRAD_ID, COMPO_TYPE, ICON_NAME, CONDITION, NO_FIELD, TYPE_FIELD, TYPE_TABLE, PARENT_COMPO, PAGE_FIELD, DATE_FIELD, VALSET_FIELD, WF_FLOW_TYPE, WF_LIST_TYPE, DEFAULT_WF_TEMPLATE, TEMPLATE_IS_USED, IS_AUTO_LIST, ORDER_BY, IS_GRANT_TO_ALL, PRINT_TYPE, TITLE_FIELD, TITLE_DATE, WF_BRIEF_FIELDS, IS_FUNC_CONTROL)
values ('ZC_PASSWORD', '用户密码统一管理', 'ZC_TEMP', null, 'M', null, null, null, null, null, null, null, null, null, null, null, null, 'N', 'Y', null, null, '0', null, null, null, 'ZC');

--10

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_PASSWORD', 'fexit', null, null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_PASSWORD', 'fsave', 'Y', null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_PASSWORD', 'fwatch', null, null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

--11

insert into ZC_SEARCH_CONDITION (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZC_PASSWORD_Tab', 'gys', '供应商', 0, 'ZC_PASSWORD', null, '密码管理页签', 'tab', '301');

insert into ZC_SEARCH_CONDITION (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZC_PASSWORD_Tab', 'ysdw', '采购人', 0, 'ZC_PASSWORD', null, '密码管理页签', 'tab', '301');

insert into ZC_SEARCH_CONDITION (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZC_PASSWORD_Tab', 'qt', '其他', 0, 'ZC_PASSWORD', null, '密码管理页签', 'tab', '301');

--12

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_PASSWORD', 'C', '用户密码管理');

--13

insert into AS_MENU_COMPO (MENU_ID, COMPO_ID, ORD_INDEX, IS_GOTO_EDIT, IS_IN_MENU, IS_ALWAYS_NEW, URL)
values ('ZC_B_XM', 'ZC_PASSWORD', 30, 'N', 'Y', 'N', '/GB/jsp/ZC/CommonPage.jsp?className=com.ufgov.zc.client.zc.password.ZcPasswordListPanel');

----------------20160303---------------
--1

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_MOBILE_MSG', 'CODE', 0, '编号', '编号', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'N', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_MOBILE_MSG', 'CONTENT', 0, '短信内容', '短信内容', 'VARCHAR2', 500, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_MOBILE_MSG', 'INPUTOR', 0, '录入人', '录入人', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_MOBILE_MSG', 'INPUTOR_NAME', 0, '录入人名称', '录入人名称', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_MOBILE_MSG', 'INPUT_DATE', 0, '录入时间', '录入时间', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_MOBILE_MSG', 'IS_SENDED', 0, '是否发送', '是否发送', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_MOBILE_MSG', 'MOBILES', 0, '电话号码，用,分割多个号码', '电话号码，用,分割多个号码', 'VARCHAR2', 500, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_MOBILE_MSG', 'ND', 0, '年度', '年度', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_MOBILE_MSG', 'SEND_TIME', 0, '发送时间', '发送时间', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

--2

create table ZC_MOBILE_MSG
(
  code         VARCHAR2(60) not null,
  mobiles      VARCHAR2(500),
  inputor      VARCHAR2(60),
  input_date   DATE,
  inputor_name VARCHAR2(60),
  send_time    DATE,
  is_sended    VARCHAR2(60),
  content      VARCHAR2(500),
  nd           NUMBER
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
comment on table ZC_MOBILE_MSG
  is '短信发送表';
-- Add comments to the columns 
comment on column ZC_MOBILE_MSG.code
  is '编号';
comment on column ZC_MOBILE_MSG.mobiles
  is '电话号码，用,分割多个号码';
comment on column ZC_MOBILE_MSG.inputor
  is '录入人';
comment on column ZC_MOBILE_MSG.input_date
  is '录入时间';
comment on column ZC_MOBILE_MSG.inputor_name
  is '录入人名称';
comment on column ZC_MOBILE_MSG.send_time
  is '发送时间';
comment on column ZC_MOBILE_MSG.is_sended
  is '是否发送';
comment on column ZC_MOBILE_MSG.content
  is '短信内容';
comment on column ZC_MOBILE_MSG.nd
  is '年度';
-- Create/Recreate primary, unique and foreign key constraints 
alter table ZC_MOBILE_MSG
  add constraint ZC_MOBILE_MSG_PK primary key (CODE)
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

--3

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_MOBILE_MSG_CODE', 'C', '编号');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_MOBILE_MSG_CONTENT', 'C', '短信内容');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_MOBILE_MSG_INPUTOR', 'C', '录入人');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_MOBILE_MSG_INPUTOR_NAME', 'C', '录入人名称');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_MOBILE_MSG_INPUT_DATE', 'C', '录入时间');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_MOBILE_MSG_IS_SENDED', 'C', '是否发送');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_MOBILE_MSG_MOBILES', 'C', '手机号码');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_MOBILE_MSG_ND', 'C', '年度');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_MOBILE_MSG_SEND_TIME', 'C', '发送时间');

--4

insert into as_table (TAB_ID, MASTER_TAB_ID, TAB_NA, TAB_DESC, DB_VER_NO, TRAD_VER_NO, LSTDATE, PRE_VALSET, IS_TABLE)
values ('ZC_MOBILE_MSG', null, '短信发送表', '短信发送表', null, null, null, null, 'Y');

--5

insert into as_compo (COMPO_ID, COMPO_NAME, MASTER_TAB_ID, TRAD_ID, COMPO_TYPE, ICON_NAME, CONDITION, NO_FIELD, TYPE_FIELD, TYPE_TABLE, PARENT_COMPO, PAGE_FIELD, DATE_FIELD, VALSET_FIELD, WF_FLOW_TYPE, WF_LIST_TYPE, DEFAULT_WF_TEMPLATE, TEMPLATE_IS_USED, IS_AUTO_LIST, ORDER_BY, IS_GRANT_TO_ALL, PRINT_TYPE, TITLE_FIELD, TITLE_DATE, WF_BRIEF_FIELDS, IS_FUNC_CONTROL)
values ('ZC_MOBILE_MSG', '短信发送', 'ZC_MOBILE_MSG', null, 'M', null, null, null, null, null, null, null, null, null, null, null, null, 'N', 'Y', null, null, '0', null, null, null, 'ZC');

--6

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_MOBILE_MSG', 'fdelete', 'Y', null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_MOBILE_MSG', 'fedit', 'Y', null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_MOBILE_MSG', 'fexit', null, null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_MOBILE_MSG', 'fnew', null, null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_MOBILE_MSG', 'fprint', 'Y', null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_MOBILE_MSG', 'fprint_preview', null, null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_MOBILE_MSG', 'fprn_tpl_set', null, null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_MOBILE_MSG', 'fsave', 'Y', null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_MOBILE_MSG', 'fwatch', null, null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_MOBILE_MSG', 'fsend', 'Y', null, to_date('06-01-2015 10:56:15', 'dd-mm-yyyy hh24:mi:ss'));

--7

insert into ZC_SEARCH_CONDITION (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcMobileMsg_Tab', 'my', '我的消息', 1, 'ZC_MOBILE_MSG', null, '采购任务页签', 'tab', '301');

insert into ZC_SEARCH_CONDITION (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcMobileMsg_Tab', 'other', '其它消息', 2, 'ZC_MOBILE_MSG', null, '采购任务页签', 'tab', '301');

--8

insert into ZC_SYS_BILL_ELEMENT (ELEMENT_ID, ND, BILL_TYPE_CODE, ELEMENT_CODE, ELEMENT_NAME, IS_INCLUDE, IS_INHERIT, INHERIT_ELEMENT_CODE, INHERIT_ELEMENT_NAME, IS_EDIT, IS_RANDOM_EDIT, DEC_FLAG, LEVEL_CTRL, IS_EDIT_PUTIN, IS_EDIT_AUDIT, IS_CONFIG, DEFAULT_VAL_CODE, DEFAULT_VAL_NAME, IS_NULL, PARENT_LEVEL_CTRL, EXTEND_ELEMENT_TYPE, LEVEL_STR, DISPLAY_ORDER_INDEX, GENBALANCE_LEVEL_CTRL)
values ('ZC_MOBILE_MSG_CONTENT', 9999, 'ZC_MOBILE_MSG', 'CONTENT', '短信内容', '1', '0', null, null, '1', '1', '0', 0, '0', '0', '1', null, null, '0', 0, '1', '1', 1, 0);

insert into ZC_SYS_BILL_ELEMENT (ELEMENT_ID, ND, BILL_TYPE_CODE, ELEMENT_CODE, ELEMENT_NAME, IS_INCLUDE, IS_INHERIT, INHERIT_ELEMENT_CODE, INHERIT_ELEMENT_NAME, IS_EDIT, IS_RANDOM_EDIT, DEC_FLAG, LEVEL_CTRL, IS_EDIT_PUTIN, IS_EDIT_AUDIT, IS_CONFIG, DEFAULT_VAL_CODE, DEFAULT_VAL_NAME, IS_NULL, PARENT_LEVEL_CTRL, EXTEND_ELEMENT_TYPE, LEVEL_STR, DISPLAY_ORDER_INDEX, GENBALANCE_LEVEL_CTRL)
values ('ZC_MOBILE_MSG_MOBILES', 9999, 'ZC_MOBILE_MSG', 'MOBILES', '手机号码', '1', '0', null, null, '1', '1', '0', 0, '0', '0', '1', null, null, '0', 0, '1', '1', 1, 0);

--9

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_IS_SENDED', '0', '草稿', 1, null, 'Y', to_date('01-03-2016 23:35:40', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_IS_SENDED', 'Y', '已发送', 2, null, 'Y', to_date('01-03-2016 23:35:40', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_IS_SENDED', 'N', '未发送', 3, null, 'Y', to_date('01-03-2016 23:35:40', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_IS_SENDED', 'fail', '发送失败', 4, null, 'Y', to_date('01-03-2016 23:35:40', 'dd-mm-yyyy hh24:mi:ss'));

--10

insert into AS_MENU_COMPO (MENU_ID, COMPO_ID, ORD_INDEX, IS_GOTO_EDIT, IS_IN_MENU, IS_ALWAYS_NEW, URL)
values ('ZC_B_XM', 'ZC_MOBILE_MSG', 35, 'N', 'Y', 'N', '/GB/jsp/ZC/CommonPage.jsp?className=com.ufgov.zc.client.zc.moblieMsg.ZcMobileMsgListPanel');

--11

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_MOBILE_MSG', 'C', '短信发送');

--12
-- Create sequence 
create sequence ZC_SEQ_MOBILE_MSG_CODE
minvalue 1
maxvalue 999999999999
start with 1
increment by 1
cache 2;

--13

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KY_ZH', 'ZC_MOBILE_MSG', 'fsend', to_date('02-07-2010 15:30:00', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KY_ZH', 'ZC_MOBILE_MSG', 'fexit', to_date('03-07-2010 15:30:00', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KY_ZH', 'ZC_MOBILE_MSG', 'fnew', to_date('04-07-2010 15:30:00', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KY_ZH', 'ZC_MOBILE_MSG', 'fwatch', to_date('05-07-2010 15:30:00', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KY_CG', 'ZC_MOBILE_MSG', 'fsend', to_date('06-07-2010 15:30:00', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KY_CG', 'ZC_MOBILE_MSG', 'fexit', to_date('07-07-2010 15:30:00', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KY_CG', 'ZC_MOBILE_MSG', 'fnew', to_date('08-07-2010 15:30:00', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KY_CG', 'ZC_MOBILE_MSG', 'fwatch', to_date('09-07-2010 15:30:00', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KZ_CG', 'ZC_MOBILE_MSG', 'fsend', to_date('10-07-2010 15:30:00', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KZ_CG', 'ZC_MOBILE_MSG', 'fexit', to_date('11-07-2010 15:30:00', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KZ_CG', 'ZC_MOBILE_MSG', 'fnew', to_date('12-07-2010 15:30:00', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KZ_CG', 'ZC_MOBILE_MSG', 'fwatch', to_date('13-07-2010 15:30:00', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KZ_ZH', 'ZC_MOBILE_MSG', 'fsend', to_date('14-07-2010 15:30:00', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KZ_ZH', 'ZC_MOBILE_MSG', 'fexit', to_date('15-07-2010 15:30:00', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KZ_ZH', 'ZC_MOBILE_MSG', 'fnew', to_date('16-07-2010 15:30:00', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KZ_ZH', 'ZC_MOBILE_MSG', 'fwatch', to_date('17-07-2010 15:30:00', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CG_CGZXLD', 'ZC_MOBILE_MSG', 'fsend', to_date('18-07-2010 15:30:00', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CG_CGZXLD', 'ZC_MOBILE_MSG', 'fexit', to_date('19-07-2010 15:30:00', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CG_CGZXLD', 'ZC_MOBILE_MSG', 'fnew', to_date('20-07-2010 15:30:00', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CG_CGZXLD', 'ZC_MOBILE_MSG', 'fwatch', to_date('21-07-2010 15:30:00', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CG_CGZXLD', 'ZC_MOBILE_MSG', 'fdelete', to_date('22-07-2010 15:30:00', 'dd-mm-yyyy hh24:mi:ss'));

--14

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CGZX_KY_ZH', 'ZcMobileMsg_Tab', 'my');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CGZX_KY_CG', 'ZcMobileMsg_Tab', 'my');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CGZX_KZ_CG', 'ZcMobileMsg_Tab', 'my');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CGZX_KZ_ZH', 'ZcMobileMsg_Tab', 'my');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CG_CGZXLD', 'ZcMobileMsg_Tab', 'my');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CG_CGZXLD', 'ZcMobileMsg_Tab', 'other');

--15

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'ATTACHFILENAME', 0, '附件名称', '附件名称', 'VARCHAR2', 500, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'ATTACHGUID', 0, '附件Guid', '附件Guid', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, 'N', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'ATTACHLENGTH', 0, '文件大小', '文件大小', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'ATTACH_CONNECTIONSTRINGNAME', 0, '附件连接名称', '附件连接名称', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'AUDITSTATUS', 0, '审核状态正式', '审核状态正式', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'AUDITSTATUS_TEMP', 0, '审核状态临时', '审核状态临时', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'BEIZHU', 0, '说明', '说明', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'BIANGENGDATE', 0, '变更日期', '变更日期', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'CLIENTGUID', 0, '拥有者ID', '拥有者ID', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, 'N', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'CLIENTTYPE', 0, '拥有者类型', '拥有者类型', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'CONTENTTYPE', 0, '文件类型', '文件类型', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'DANWEIGUID', 0, '单位唯一标识', '单位唯一标识', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'ISBIANGENG', 0, '是否变更', '是否变更', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'ISREALZUOFEI', 0, '是否已作废', '是否已作废', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'MODULETYPE', 0, '附件类型', '附件类型', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'SORT', 0, '排序', '排序', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'UPLOADDATETIME', 0, '上传时间', '上传时间', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'UPLOADUSERDISPLAYNAME', 0, '上传人的名称', '上传人的名称', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'UPLOADUSERGUID', 0, '上传人Guid', '上传人Guid', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'ZUOFEIREASON', 0, '作废原因', '作废原因', 'VARCHAR2', 500, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

--16

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_ATTACHFILENAME', 'C', '附件名称');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_ATTACHGUID', 'C', '附件Guid');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_ATTACHLENGTH', 'C', '文件大小');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_ATTACH_CONNECTIONSTRINGNAME', 'C', '附件连接名称');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_AUDITSTATUS', 'C', '审核状态正式');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_AUDITSTATUS_TEMP', 'C', '审核状态临时');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_BEIZHU', 'C', '说明');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_BIANGENGDATE', 'C', '变更日期');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_CLIENTGUID', 'C', '拥有者ID');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_CLIENTTYPE', 'C', '拥有者类型');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_CONTENTTYPE', 'C', '文件类型');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_DANWEIGUID', 'C', '单位唯一标识');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_ISBIANGENG', 'C', '是否变更');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_ISREALZUOFEI', 'C', '是否已作废');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_MODULETYPE', 'C', '附件类型');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_SORT', 'C', '排序');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_UPLOADDATETIME', 'C', '上传时间');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_UPLOADUSERDISPLAYNAME', 'C', '上传人的名称');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_UPLOADUSERGUID', 'C', '上传人Guid');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_ZUOFEIREASON', 'C', '作废原因');

--17

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A001', '企业法人营业执照', 1, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A002', '企业资质等级证书(工程类)', 2, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A003', '安全生产许可证', 3, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A004', '组织机构代码证', 4, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A006', '国家税务登记证', 5, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A007', '地方税务登记证', 6, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A050', '企业资质等级证书(监理类)', 7, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A051', '企业资质等级证书(服务货物类)', 8, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A060', '企业资质等级证书(工程建设招标代理类)', 9, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A062', '企业资质等级证书(项目管理类)', 10, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A063', '企业资质等级证书(勘察类)', 11, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A064', '企业资质等级证书(设计类)', 12, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A089', '法人授权委托书', 13, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A090', '诚信承诺书', 14, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A091', '企业基本账户开户许可证', 15, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A092', '法人个人照片', 16, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A1001', '安全、质量、环保等管理体系认证证书', 17, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A101', '建造师证书', 18, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A102', '项目经理身份证', 19, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A104', '项目经理学历证书', 20, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A105', '项目经理社保', 21, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A107', '项目经理个人照片', 22, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A108', '项目经理职称证', 23, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A111', '项目经理劳动合同', 24, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A191', '项目经理毕业证', 25, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A1101', '注册监理工程师证书', 26, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A1102', '总监身份证', 27, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A1103', '总监职称证书', 28, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A1104', '总监学历证书', 29, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A1105', '总监社会保险证明', 30, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A1106', '总监个人照片', 31, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A1109', '总监劳动合同', 32, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A1199', '总监其他材料', 33, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A1501', '勘察工程师执业人员注册证书', 34, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A1506', '勘察工程师个人照片', 35, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A1507', '勘察工程师身份证', 36, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A1508', '勘察工程师职称证', 37, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A1509', '勘察工程师学历证明', 38, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A1601', '设计工程师执业人员注册证书', 39, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A1602', '设计工程师个人照片', 40, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A1603', '设计工程师身份证', 41, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A1604', '设计工程师职称证', 42, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A1605', '设计工程师学历证明', 43, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A1701', '代理人员照片', 44, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A1702', '代理人员身份证', 45, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A1703', '代理人员职称证', 46, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A1704', '工程建设类执业人员注册证书', 47, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A1708', '代理人员劳动合同', 48, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A1709', '代理人员学历证明', 49, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A1710', '代理人员其他', 50, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A1711', '代理人员社会保险', 51, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A1712', '代理人员人事档案关系', 52, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A201', '企业主要负责人安全生产考核合格证', 53, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A202', '项目经理安全生产考核合格证书(B证)', 54, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A203', '专职安全生产管理人员的安全生产考核合格证', 55, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A2301', '勘察工程师劳动合同', 56, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A2302', '勘察工程师养老保险证明', 57, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A2399', '勘察工程师其他材料', 58, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A2401', '设计工程师劳动合同', 59, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A2402', '设计工程师养老保险证明', 60, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A2499', '设计工程师其他材料', 61, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A301', '五大员职称证（执业证或上岗证书）', 62, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A302', '五大员社保证明', 63, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A393', '五大员劳动合同', 64, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A394', '五大员个人照片', 65, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A399', '五大员其他', 66, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A4201', '咨询人员个人照片', 67, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A4202', '咨询人员身份证', 68, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A4203', '咨询人员职称证明', 69, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A4204', '咨询人员学历证明', 70, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A4205', '咨询人员执业资格', 71, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A5101', '咨询人员社会保险', 72, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A5102', '咨询人员劳动合同', 73, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A5001', '企业资质等级证书(咨询企业)', 74, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A501', '业绩中标通知书', 75, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A502', '业绩合同协议书', 76, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A503', '工程竣工验收证明', 77, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A601', '财务会计报表', 78, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A6601', '母公司营业执照', 79, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A6602', '母公司资质证书', 80, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A6603', '分支机构负责人和技术负责人简历', 81, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A6605', '办理分支机构备案的授权委托书', 82, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A6606', '人均不少于10平方米的分支机构办公场所证明文件或租赁合同', 83, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A701', '工程获奖证书或颁奖部门的相关文件', 84, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A702', '重合同守信用企业', 85, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A703', '银行资信等级等信誉证书', 86, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_ATTACH_TYPE', 'A799', '其他信誉相关类证书', 87, null, 'N', to_date('03-03-2016 05:04:11', 'dd-mm-yyyy hh24:mi:ss'));

--18

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_AUDIT_STATUS', '1', '编辑中', 1, null, 'N', to_date('03-03-2016 05:14:17', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_AUDIT_STATUS', '2', '待审核', 2, null, 'N', to_date('03-03-2016 05:14:17', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_AUDIT_STATUS', '3', '审核通过', 3, null, 'N', to_date('03-03-2016 05:14:17', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_AUDIT_STATUS', '4', '审核不通过', 4, null, 'N', to_date('03-03-2016 05:14:17', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_AUDIT_STATUS', '6', '作废', 5, null, 'N', to_date('03-03-2016 05:14:17', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_AUDIT_STATUS', '5', '删除', 6, null, 'N', to_date('03-03-2016 05:14:17', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_AUDIT_STATUS', '7', '退回', 7, null, 'N', to_date('03-03-2016 05:14:17', 'dd-mm-yyyy hh24:mi:ss'));

--19

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_SHI_FOU_ZUO_FEI', '0', '否', 1, null, 'N', to_date('03-03-2016 05:23:09', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('VS_HUIYUAN_SHI_FOU_ZUO_FEI', '1', '是', 2, null, 'N', to_date('03-03-2016 05:23:09', 'dd-mm-yyyy hh24:mi:ss'));

----------------20160229---------------
--1

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_ESTIMATE_TIME_STR', 0, '估计工时', '估计工时', 'VARCHAR2', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', 'N', 'Y', 'Y', null, null, null, 'N', null, null, null, null, null, null, null, 'N', 'N', null, null);

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_ESTIMATE_TIME_STR', 'C', '估计工时');

--2
delete from as_option O WHERE O.OPT_ID LIKE 'OPT_ZC_EVAL_BID_ADDRESS';

insert into as_option (OPT_ID, CO_CODE, COMPO_ID, TRANS_TYPE, OPT_VAL, IS_SYST_OPT)
values ('OPT_ZC_EVAL_BID_ADDRESS', '*', '*', '*', '五楼评标室', 'Y');

--3

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_EVALUATION', 'EM_MOBILE_XIUZHENG', 2.99, '手机', '手机', 'TEXT', 30, null, 'F_EM_B_EXPERT', 'EM_MOBILE', 'N', null, null, 'Y', null, 'N', 'Y', 'N', 'Y', 'Y', null, null, null, 'N', null, null, null, null, null, null, null, 'N', 'N', null, null);

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_MOBILE_XIUZHENG', 'C', '手机');

--4

insert into ZC_SYS_BILL_ELEMENT (ELEMENT_ID, ND, BILL_TYPE_CODE, ELEMENT_CODE, ELEMENT_NAME, IS_INCLUDE, IS_INHERIT, INHERIT_ELEMENT_CODE, INHERIT_ELEMENT_NAME, IS_EDIT, IS_RANDOM_EDIT, DEC_FLAG, LEVEL_CTRL, IS_EDIT_PUTIN, IS_EDIT_AUDIT, IS_CONFIG, DEFAULT_VAL_CODE, DEFAULT_VAL_NAME, IS_NULL, PARENT_LEVEL_CTRL, EXTEND_ELEMENT_TYPE, LEVEL_STR, DISPLAY_ORDER_INDEX, GENBALANCE_LEVEL_CTRL)
values ('ZC_EB_PROJ_PROJ_CODE', 9999, 'ZC_EB_PROJ', 'PROJ_CODE', '项目编号', '1', '0', null, null, '1', '1', '0', 0, '0', '0', '1', null, null, '0', 0, '1', '1', 0, 0);

--5
create or replace trigger TRIGGER_ZC_MA_COMPANY
   after insert ON MA_COMPANY
  FOR EACH ROW

DECLARE 
  V_DRAFT_ID    VARCHAR(100);
BEGIN

  IF (:NEW.CO_CODE LIKE '990%' ) THEN
    INSERT INTO as_org(Co_Code,Org_Code,Org_Name,Parent_Org_Code,Is_Lowest,Quic_CodE,Prin_Code,Linkman,Tele,Org_Id,Org_Type_Code,Nd,Is_Need_Send_Bank,Trans_Date,Guid,Trigger_Enable)
    VALUES(:NEW.CO_CODE,'cwk','财务科','','Y','','','','','12700114553236148780','',:NEW.ND,'',SYSDATE,SYS_GUID(),'1');
    
    INSERT INTO AS_ORG_POSITION(CO_CODE,POSI_CODE,ORG_CODE,LEADER_POSI_ID,ORG_POSI_ID,ND,TRANS_DATE)
    VALUES(:NEW.CO_CODE,'ysdwcg','cwk',:NEW.CO_CODE||'cwkysdwfz',:NEW.CO_CODE||'cwkysdwcg',:NEW.ND,SYSDATE);
    
    INSERT INTO AS_ORG_POSITION(CO_CODE,POSI_CODE,ORG_CODE,LEADER_POSI_ID,ORG_POSI_ID,ND,TRANS_DATE)
    VALUES(:NEW.CO_CODE,'ysdwfz','cwk','',:NEW.CO_CODE||'cwkysdwfz',:NEW.ND,SYSDATE);
    
    INSERT INTO as_emp(Emp_Code,Emp_Name,Sex,Title_Tech,Phone,Email,Identity_Card,Rtxuin,Emp_Index,Is_Login,User_Id,Photo,photo_blobid,ca_serial,Co_Name,Trans_Date,User_Birth,Mobile)
    VALUES(:NEW.CO_CODE||'01',:NEW.CO_NAME||'经办人','1','','','','','','','Y',:NEW.CO_CODE||'01','','','','',SYSDATE,'','');
    
    INSERT INTO as_emp(Emp_Code,Emp_Name,Sex,Title_Tech,Phone,Email,Identity_Card,Rtxuin,Emp_Index,Is_Login,User_Id,Photo,photo_blobid,ca_serial,Co_Name,Trans_Date,User_Birth,Mobile)
    VALUES(:NEW.CO_CODE||'02',:NEW.CO_NAME||'负责人','1','','','','','','','Y',:NEW.CO_CODE||'02','','','','',SYSDATE,'','');
    
    insert into as_emp_position
  (emp_code, posi_code, org_code, co_code, emp_posi_id, nd, trans_date)
values
  (:NEW.CO_CODE||'01','ysdwcg','cwk',:NEW.CO_CODE,:NEW.CO_CODE||'cwkysdwcg'||:NEW.CO_CODE||'01',:NEW.ND,SYSDATE); 
    insert into as_emp_position
  (emp_code, posi_code, org_code, co_code, emp_posi_id, nd, trans_date)
values
  (:NEW.CO_CODE||'02','ysdwfz','cwk',:NEW.CO_CODE,:NEW.CO_CODE||'cwkysdwfz'||:NEW.CO_CODE||'02',:NEW.ND,SYSDATE);
  
  insert into as_user
   (user_id, user_name, passwd, is_wr_log, cookie, rtxuin, modi_time, trans_date)
 values
   (:NEW.CO_CODE||'01',:NEW.CO_NAME||'经办人','','','','','',SYSDATE);
   
  insert into as_user
   (user_id, user_name, passwd, is_wr_log, cookie, rtxuin, modi_time, trans_date)
 values
   (:NEW.CO_CODE||'02',:NEW.CO_NAME||'负责人','','','','','',SYSDATE);
   
   insert into as_user_group
   (user_id, group_id)
 values
   (:NEW.CO_CODE||'01','yusuandanwei');
   
   insert into as_user_group
   (user_id, group_id)
 values
   (:NEW.CO_CODE||'02','yusuandanwei');
  
  END IF;

END TRIGGER_ZC_MA_COMPANY;



----------------20160222---------------
--1

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'ATTACHFILENAME', 0, '附件名称', '附件名称', 'VARCHAR2', 500, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'ATTACHGUID', 0, '附件Guid', '附件Guid', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, 'N', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'ATTACHLENGTH', 0, '文件大小', '文件大小', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'ATTACH_CONNECTIONSTRINGNAME', 0, '附件连接名称', '附件连接名称', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'AUDITSTATUS', 0, '审核状态正式', '审核状态正式', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'AUDITSTATUS_TEMP', 0, '审核状态临时', '审核状态临时', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'BEIZHU', 0, '说明', '说明', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'BIANGENGDATE', 0, '变更日期', '变更日期', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'CLIENTGUID', 0, '拥有者ID', '拥有者ID', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, 'N', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'CLIENTTYPE', 0, '拥有者类型', '拥有者类型', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'CONTENTTYPE', 0, '文件类型', '文件类型', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'DANWEIGUID', 0, '单位唯一标识', '单位唯一标识', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'ISBIANGENG', 0, '是否变更', '是否变更', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'ISREALZUOFEI', 0, '是否已作废', '是否已作废', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'MODULETYPE', 0, '附件类型', '附件类型', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'SORT', 0, '排序', '排序', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'UPLOADDATETIME', 0, '上传时间', '上传时间', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'UPLOADUSERDISPLAYNAME', 0, '上传人的名称', '上传人的名称', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'UPLOADUSERGUID', 0, '上传人Guid', '上传人Guid', 'VARCHAR2', 50, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('HUIYUAN_ATTACHINFO', 'ZUOFEIREASON', 0, '作废原因', '作废原因', 'VARCHAR2', 500, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

--2

insert into as_table (TAB_ID, MASTER_TAB_ID, TAB_NA, TAB_DESC, DB_VER_NO, TRAD_VER_NO, LSTDATE, PRE_VALSET, IS_TABLE)
values ('HUIYUAN_ATTACHINFO', 'HUIYUAN_ZFCG_GONGYINGZIZHI', '附件信息', '附件信息', null, null, null, null, 'Y');

--3

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_ATTACHFILENAME', 'C', '附件名称');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_ATTACHGUID', 'C', '附件Guid');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_ATTACHLENGTH', 'C', '文件大小');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_ATTACH_CONNECTIONSTRINGNAME', 'C', '附件连接名称');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_AUDITSTATUS', 'C', '审核状态正式');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_AUDITSTATUS_TEMP', 'C', '审核状态临时');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_BEIZHU', 'C', '说明');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_BIANGENGDATE', 'C', '变更日期');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_CLIENTGUID', 'C', '拥有者ID');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_CLIENTTYPE', 'C', '拥有者类型');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_CONTENTTYPE', 'C', '文件类型');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_DANWEIGUID', 'C', '单位唯一标识');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_ISBIANGENG', 'C', '是否变更');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_ISREALZUOFEI', 'C', '是否已作废');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_MODULETYPE', 'C', '附件类型');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_SORT', 'C', '排序');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_UPLOADDATETIME', 'C', '上传时间');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_UPLOADUSERDISPLAYNAME', 'C', '上传人的名称');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_UPLOADUSERGUID', 'C', '上传人Guid');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('HUIYUAN_ATTACHINFO_ZUOFEIREASON', 'C', '作废原因');

--4

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A001', '企业法人营业执照', 1, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A002', '企业资质等级证书(工程类)', 2, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A003', '安全生产许可证', 3, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A004', '组织机构代码证', 4, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A006', '国家税务登记证', 5, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A007', '地方税务登记证', 6, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A050', '企业资质等级证书(监理类)', 7, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A051', '企业资质等级证书(服务货物类)', 8, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A060', '企业资质等级证书(工程建设招标代理类)', 9, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A062', '企业资质等级证书(项目管理类)', 10, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A063', '企业资质等级证书(勘察类)', 11, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A064', '企业资质等级证书(设计类)', 12, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A089', '法人授权委托书', 13, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A090', '诚信承诺书', 14, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A091', '企业基本账户开户许可证', 15, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A092', '法人个人照片', 16, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A1001', '安全、质量、环保等管理体系认证证书', 17, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A101', '建造师证书', 18, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A102', '项目经理身份证', 19, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A104', '项目经理学历证书', 20, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A105', '项目经理社保', 21, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A107', '项目经理个人照片', 22, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A108', '项目经理职称证', 23, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A111', '项目经理劳动合同', 24, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A191', '项目经理毕业证', 25, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A1101', '注册监理工程师证书', 26, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A1102', '总监身份证', 27, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A1103', '总监职称证书', 28, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A1104', '总监学历证书', 29, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A1105', '总监社会保险证明', 30, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A1106', '总监个人照片', 31, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A1109', '总监劳动合同', 32, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A1199', '总监其他材料', 33, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A1501', '勘察工程师执业人员注册证书', 34, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A1506', '勘察工程师个人照片', 35, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A1507', '勘察工程师身份证', 36, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A1508', '勘察工程师职称证', 37, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A1509', '勘察工程师学历证明', 38, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A1601', '设计工程师执业人员注册证书', 39, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A1602', '设计工程师个人照片', 40, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A1603', '设计工程师身份证', 41, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A1604', '设计工程师职称证', 42, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A1605', '设计工程师学历证明', 43, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A1701', '代理人员照片', 44, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A1702', '代理人员身份证', 45, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A1703', '代理人员职称证', 46, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A1704', '工程建设类执业人员注册证书', 47, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A1708', '代理人员劳动合同', 48, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A1709', '代理人员学历证明', 49, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A1710', '代理人员其他', 50, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A1711', '代理人员社会保险', 51, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A1712', '代理人员人事档案关系', 52, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A201', '企业主要负责人安全生产考核合格证', 53, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A202', '项目经理安全生产考核合格证书(B证)', 54, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A203', '专职安全生产管理人员的安全生产考核合格证', 55, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A2301', '勘察工程师劳动合同', 56, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A2302', '勘察工程师养老保险证明', 57, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A2399', '勘察工程师其他材料', 58, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A2401', '设计工程师劳动合同', 59, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A2402', '设计工程师养老保险证明', 60, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A2499', '设计工程师其他材料', 61, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A301', '五大员职称证（执业证或上岗证书）', 62, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A302', '五大员社保证明', 63, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A393', '五大员劳动合同', 64, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A394', '五大员个人照片', 65, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A399', '五大员其他', 66, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A4201', '咨询人员个人照片', 67, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A4202', '咨询人员身份证', 68, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A4203', '咨询人员职称证明', 69, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A4204', '咨询人员学历证明', 70, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A4205', '咨询人员执业资格', 71, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A5101', '咨询人员社会保险', 72, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A5102', '咨询人员劳动合同', 73, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A5001', '企业资质等级证书(咨询企业)', 74, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A501', '业绩中标通知书', 75, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A502', '业绩合同协议书', 76, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A503', '工程竣工验收证明', 77, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A601', '财务会计报表', 78, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A6601', '母公司营业执照', 79, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A6602', '母公司资质证书', 80, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A6603', '分支机构负责人和技术负责人简历', 81, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A6605', '办理分支机构备案的授权委托书', 82, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A6606', '人均不少于10平方米的分支机构办公场所证明文件或租赁合同', 83, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A701', '工程获奖证书或颁奖部门的相关文件', 84, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A702', '重合同守信用企业', 85, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A703', '银行资信等级等信誉证书', 86, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_HUIYUAN_ATTACH_TYPE', 'A799', '其他信誉相关类证书', 87, null, 'N', to_date('02-02-2016 00:01:46', 'dd-mm-yyyy hh24:mi:ss'));

--5

----------20160201-----------------------
--1
 -- Drop primary, unique and foreign key constraints 
alter table ZC_EB_PROJ_ZBFILE
  drop constraint PK_ZC_EB_PROJ_ZBFILE cascade;
-- Create/Recreate primary, unique and foreign key constraints 
alter table ZC_EB_PROJ_ZBFILE
  add constraint PKK_ZC_EB_PROJ_ZBFILE primary key (PROJ_CODE)
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
  --2
  
alter table ZC_EB_PROJ_ZBFILE modify file_id null;




----------20160128-----------------------
--1

insert into as_option (OPT_ID, CO_CODE, COMPO_ID, TRANS_TYPE, OPT_VAL, IS_SYST_OPT)
values ('OPT_ZC_SAVE_BULLETIN_PUBLISH_FILE', '*', '*', '*', 'Y', 'Y');

----------20160115-----------------------
--1

   DELETE from as_lang_trans l where l.res_id in (
select t.data_item from as_tab_col t where t.tab_id='ZC_EM_EXPERT_PRO_BILL') and l.res_id like 'EM%';


insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_APPROVE_CODE', 'C', '采购批复文号');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_AVOID_COMPANY', 'C', '回避单位');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_AVOID_EXPERT', 'C', '回避专家');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_BILL_AMOUNT', 'C', '金额');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_BILL_CODE', 'C', '抽取登记编码');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_BILL_PLACE', 'C', '评标地点');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_BILL_PRINCIPAL', 'C', '项目负债人');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_BILL_STATUS', 'C', '状态');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_BZ', 'C', '备注');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_CALL_INFO', 'C', '语音呼叫信息');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_CATALOGUE_CODE', 'C', '品目代码');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_CHOUQ_NUM', 'C', '抽取次数');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_CONTACT_COMPANY', 'C', '申请单位名称');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_CONTACT_PERSON', 'C', '申请人');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_CONTACT_PHONE', 'C', '申请人电话');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_CO_CODE', 'C', '填报单位');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_DIYU_DAIMA', 'C', '品目地域代码');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_ECONOMY_MAJOR', 'C', '经济类专业');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_ECONOMY_NUM', 'C', '经济类人数');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_ESTIMATE_TIME', 'C', '估计工时');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_EXPERT_BILL_TYPE', 'C', '抽取单类别');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_FS', 'C', '采购方式');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_GUARDER_CODE', 'C', '监抽人');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_HWMC', 'C', '采购货物名称');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_INPUT_CODE', 'C', '填报人');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_INPUT_DATE', 'C', '填报时间');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_LEGAL_MAJOR', 'C', '法律类专业');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_LEGAL_NUM', 'C', '法律类人数');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_MAKE_CODE', 'C', '采购项目代码');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_MAKE_NAME', 'C', '采购项目名称');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_MSG_INFO', 'C', '短信信息');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_TECH_MAJOR', 'C', '技术类专业');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_TECH_NUM', 'C', '技术类人数');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_TENDERS_TIME', 'C', '开标时间');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_TOTAL_NUM', 'C', '专家人数');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_WJ_CODE', 'C', '招标文件编号');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_XMDIYU_DAIMA', 'C', '项目所在地域代码');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_YEAR', 'C', '财政年度');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_ZJDW', 'C', '采购（委托）单位');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_ZJDW_CODE', 'C', '委托单位代码');

insert into AS_LANG_TRANS (RES_ID, LANG_ID, RES_NA)
values ('EM_ZJDW_NAME', 'C', '委托单位名称');

--2 
DELETE from as_tab_col t where t.tab_id='ZC_EM_EXPERT_PRO_BILL';


insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_APPROVE_CODE', 0, '采购批复文号', '采购批复文号', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_AVOID_COMPANY', 0, '回避单位', '回避单位', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_AVOID_EXPERT', 0, '回避专家', '回避专家', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_BILL_AMOUNT', 0, '金额', '金额', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_BILL_CODE', 0, '抽取登记编码', '抽取登记编码', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, 'N', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_BILL_PLACE', 0, '评标地点', '评标地点', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_BILL_PRINCIPAL', 0, '项目负债人', '项目负债人', 'VARCHAR2', 20, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_BILL_STATUS', 0, '状态', '状态', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_BZ', 0, '备注', '备注', 'VARCHAR2', 2000, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_CALL_INFO', 0, '语音呼叫信息', '语音呼叫信息', 'VARCHAR2', 4000, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_CATALOGUE_CODE', 0, '品目代码', '品目代码', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_CHOUQ_NUM', 0, '抽取次数', '抽取次数', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_CONTACT_COMPANY', 0, '申请单位名称', '申请单位名称', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_CONTACT_PERSON', 0, '申请人', '申请人', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_CONTACT_PHONE', 0, '申请人电话', '申请人电话', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_CO_CODE', 0, '填报单位', '填报单位', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_DIYU_DAIMA', 0, '品目地域代码', '品目地域代码', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_ECONOMY_MAJOR', 0, '经济类专业', '经济类专业', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_ECONOMY_NUM', 0, '经济类人数', '经济类人数', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_ESTIMATE_TIME', 0, '估计工时', '估计工时', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_EXPERT_BILL_TYPE', 0, '抽取单类别', '抽取单类别', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_FS', 0, '采购方式', '采购方式', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_GUARDER_CODE', 0, '监抽人', '监抽人', 'VARCHAR2', 100, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_HWMC', 0, '采购货物名称', '采购货物名称', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_INPUT_CODE', 0, '填报人', '填报人', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_INPUT_DATE', 0, '填报时间', '填报时间', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_LEGAL_MAJOR', 0, '法律类专业', '法律类专业', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_LEGAL_NUM', 0, '法律类人数', '法律类人数', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_MAKE_CODE', 0, '采购项目代码', '采购项目代码', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_MAKE_NAME', 0, '采购项目名称', '采购项目名称', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_MSG_INFO', 0, '短信信息', '短信信息', 'VARCHAR2', 4000, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_TECH_MAJOR', 0, '技术类专业', '技术类专业', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_TECH_NUM', 0, '技术类人数', '技术类人数', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_TENDERS_TIME', 0, '开标时间', '开标时间', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_TOTAL_NUM', 0, '专家人数', '专家人数', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_WJ_CODE', 0, '招标文件编号', '招标文件编号', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_XMDIYU_DAIMA', 0, '项目所在地域代码', '项目所在地域代码', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_YEAR', 0, '财政年度', '财政年度', 'CHAR', 4, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_ZJDW', 0, '采购（委托）单位', '采购（委托）单位', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_ZJDW_CODE', 0, '委托单位代码', '委托单位代码', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'EM_ZJDW_NAME', 0, '委托单位名称', '委托单位名称', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'ND', 0, '年度', '年度', 'VARCHAR2', 10, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EM_EXPERT_PRO_BILL', 'PROCESS_INST_ID', 0, 'PROCESS_INST_ID', 'PROCESS_INST_ID', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

--3
update as_table t set t.master_tab_id='ZC_EM_EXPERT_PRO_BILL' where t.tab_id='ZC_EM_EXPERT_PRO_BILL';

--4
insert into as_option (OPT_ID, CO_CODE, COMPO_ID, TRANS_TYPE, OPT_VAL, IS_SYST_OPT)
values ('OPT_ZC_EXPERT_SELECT_NEED_PASSWD', '*', '*', '*', 'Y', 'Y');

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EM_EXPERT_SELECTION', 'fsetPwd', null, null, to_date('20-06-2013 22:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_func (FUNC_ID, FUNC_DESC, ORD_INDEX, IS_GRANT_TO_ALL, IS_LIST, SHORTCUT_KEY, IS_CTRL, IS_SHIFT, IS_ALT)
values ('fsetPwd', '设置密码', 42, null, 'N', null, null, null, null);

insert into as_option (OPT_ID, CO_CODE, COMPO_ID, TRANS_TYPE, OPT_VAL, IS_SYST_OPT)
values ('OPT_ZC_EXPERT_SELECT_PASSWD', '*', '*', '*', null, 'Y');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_FUNC_fsetPwd', 'C', '设置专家抽取密码');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('fsetPwd', 'C', '设置专家抽取密码');

--5
update as_option o set o.opt_val='' where o.opt_id='OPT_ZC_EXPERT_SELECT_PASSWD';



----------20160110-----------------------
--1

alter table ZC_EM_EXPERT_PRO_BILL add nd VARCHAR2(10);

update zc_em_expert_pro_bill B set b.nd=to_char(b.em_input_date,'yyyy');
--2
-- Create table
create table EM_EXPERT_BILL_FILTER_UNIT
(
  em_bill_code VARCHAR2(30),
  unit_name    varchar2(100)
)
;
-- Add comments to the table 
comment on table EM_EXPERT_BILL_FILTER_UNIT
  is '专家抽取过滤单位';
-- Add comments to the columns 
comment on column EM_EXPERT_BILL_FILTER_UNIT.em_bill_code
  is '抽取登记编号';
comment on column EM_EXPERT_BILL_FILTER_UNIT.unit_name
  is '专家单位';

----------20160108-----------------------
--1
CREATE OR REPLACE VIEW V_ZC_PRO_MAKE_EXPERT AS
SELECT P.ZC_MAKE_CODE,
 P.ZC_MAKE_NAME,
 C.CO_NAME,
 P.ZC_MAKE_LINKMAN,
 P.ZC_MAKE_TEL,
 P.Agency_Name,
 P.ZC_INPUT_DATE,
 p.agency,
 p.zc_pifu_cgfs
 FROM ZC_P_PRO_MAKE P, MA_COMPANY C, zc_b_agency a
 WHERE P.Co_Code = C.CO_CODE
 AND P.Nd = C.ND
 and p.agency = a.zc_agey_code(+)
 AND P.ZC_MAKE_STATUS IN('exec')
 AND P.ZC_FUKUAN_TYPE = 'Z01'
 UNION ALL
 SELECT O.CODE, O.NAME, O.CO_NAME, O.CONTACTOR, O.PHONE, O.AGENT_NAME,O.OPER_DATE,null,O.PURCHASE_TYPE
 FROM ZC_EB_PROMAKE_OUTER O
  union all
 select
 e.sn,
 e.zc_make_name,
 (select c.co_name from ma_company c where c.co_code=e.co_code and c.nd=e.nd) as co_name,
 e.zc_make_linkman,
 e.zc_make_tel,
 e.agency_name,
 e.zc_input_date,
 e.agency,
 e.zc_pifu_cgfs
 from zc_eb_entrust e 
/* union all 
 select p.proj_code,
        p.proj_name,
        '' as co_name,
        p.attn_name,
        p.attn_phone,
        '扬中市公共资源交易中心' as agency_name,
        p.execute_date,
        p.agency,
        p.pur_type
   from zc_eb_proj p;*/





--20160104
--1
insert into AS_OPTION (OPT_ID, CO_CODE, COMPO_ID, TRANS_TYPE, OPT_VAL, IS_SYST_OPT)
values ('OPT_ZC_EVAL_BID_ADDRESS', '*', '*', '*', '公共资源交易中心五楼评标室', 'Y');
--2
insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_EVAL_TIME', '0.5', '半天', 1, null, 'N', to_date('04-01-2016 21:46:49', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_EVAL_TIME', '1', '一天', 4, null, 'N', to_date('04-01-2016 21:46:49', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_EVAL_TIME', '1.5', '一天半', 8, null, 'N', to_date('04-01-2016 21:46:49', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_EVAL_TIME', '2', '两天', 16, null, 'N', to_date('04-01-2016 21:46:49', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_EVAL_TIME', '2.5', '两天半', 32, null, 'N', to_date('04-01-2016 21:57:06', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_EVAL_TIME', '3', '三天', 35, null, 'N', to_date('04-01-2016 21:57:06', 'dd-mm-yyyy hh24:mi:ss'));

--3
delete from as_lang_trans l where l.res_id='ZC_EB_CALL_INFO';
delete from as_lang_trans l where l.res_id='ZC_EB_MSG_INFO';

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_CALL_INFO', 'C', '您好！请勿挂机，这里是江苏扬中市公共资源交易中心。现邀请您于【日期】在【地点】参加政府采购项目【类别】工作，预计耗时【预计工时】天，如有疑问请致电：15309285785。');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_MSG_INFO', 'C', '扬中市公共资源交易中心请您于【日期】在【地点】参加政府采购项目【类别】工作，预计耗时【预计工时】天，如有疑问请致电：15309285785。');


--20160101
--1
delete FROM AS_MENU_COMPO MC WHERE MC.COMPO_ID LIKE 'ZC_EB_PROJ' ;

insert into AS_MENU_COMPO (MENU_ID, COMPO_ID, ORD_INDEX, IS_GOTO_EDIT, IS_IN_MENU, IS_ALWAYS_NEW, URL)
values ('ZC_EB_PM', 'ZC_EB_PROJ', 10, 'N', 'Y', 'N', '/GB/jsp/ZC/CommonPage.jsp?className=com.ufgov.zc.client.zc.project.integration_simple.ZcEbProjectSimpleListPanel');

--2
  update ap_menu_compo m set m.url='/GB/jsp/ZC/CommonPage.jsp?className=com.ufgov.zc.client.zc.bulletin.zhaobiao.yz.ZcEbBulletinZhaoBiaoListPanel_YZ'  where m.compo_id='ZC_EB_BULLETIN_BID';
  
--3

insert into ZC_SEARCH_CONDITION (CONDITION_ID, CONDITION_FIELD_CODE, CONDITION_FIELD_NAME, CONDITION_FIELD_ORDER, COMPO_ID, COMPO_NAME, CONDITION_NAME, CONDITION_TYPE, CONDITION_NAME_ORDER)
values ('ZcEbSignup_signupTab', 'audit', '审核报名供应商', 4, 'ZC_EB_SIGNUP', '供应商投标', '审核报名供应商', 'tab', '303');

--4

delete from zc_role_search_condition r where r.condition_id='ZcEbSignup_signupTab';

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CGZX_KY_CG', 'ZcEbSignup_signupTab', 'opened');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CGZX_KY_CG', 'ZcEbSignup_signupTab', 'biding');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CGZX_KY_CG', 'ZcEbSignup_signupTab', 'audit');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CG_CGZXLD', 'ZcEbSignup_signupTab', 'opened');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CG_CGZXLD', 'ZcEbSignup_signupTab', 'biding');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CG_CGZXLD', 'ZcEbSignup_signupTab', 'audit');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('gys_normal', 'ZcEbSignup_signupTab', 'todo');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('gys_normal', 'ZcEbSignup_signupTab', 'cancel');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('gys_normal', 'ZcEbSignup_signupTab', 'biding');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CGZX_KZ_CG', 'ZcEbSignup_signupTab', 'audit');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CGZX_KZ_CG', 'ZcEbSignup_signupTab', 'biding');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CGZX_KZ_CG', 'ZcEbSignup_signupTab', 'opened');

--5
delete from as_role_num_lim l where l.compo_id='ZC_EB_SIGNUP' and l.role_id not like 'gys%';

insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('CGZX_KY_CG', 'fwatch', 'ZC_EB_SIGNUP', 'SQL_CONDITION', 'exists (SELECT e.jbr
          from ZC_EB_ENTRUST E, ZC_EB_PACK K
         WHERE E.SN = K.ENTRUST_CODE
           AND E.JBR = ''@@svUserID''
           and ZC_EB_PROJ.Proj_Code = k.proj_code)', null, '0', 'N');

insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('CGZX_KZ_CG', 'fwatch', 'ZC_EB_SIGNUP', 'SQL_CONDITION', 'exists (SELECT e.jbr
          from ZC_EB_ENTRUST E, ZC_EB_PACK K
         WHERE E.SN = K.ENTRUST_CODE
           AND E.JBR = ''@@svUserID''
           and ZC_EB_PROJ.Proj_Code = k.proj_code)', null, '0', 'N');

insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('CGZX_KY_ZH', 'fwatch', 'ZC_EB_SIGNUP', 'SQL_CONDITION', 'exists (SELECT e.jbr
          from ZC_EB_ENTRUST E, ZC_EB_PACK K
         WHERE E.SN = K.ENTRUST_CODE
           AND E.JBR = ''@@svUserID''
           and ZC_EB_PROJ.Proj_Code = k.proj_code)', null, '0', 'N');

insert into as_role_num_lim (ROLE_ID, FUNC_ID, COMPO_ID, CTRL_FIELD, GRAN_RANGE, REVO_RANGE, IS_GRAN, IS_RELATION)
values ('CGZX_KZ_ZH', 'fwatch', 'ZC_EB_SIGNUP', 'SQL_CONDITION', 'exists (SELECT e.jbr
          from ZC_EB_ENTRUST E, ZC_EB_PACK K
         WHERE E.SN = K.ENTRUST_CODE
           AND E.JBR = ''@@svUserID''
           and ZC_EB_PROJ.Proj_Code = k.proj_code)', null, '0', 'N');
--6

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_BID_DEPOSIT', 'C', '投标保证金(元)');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_IS_CHECK_QUALIFICATION', 'C', '报名是否需要审核');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_CHECK_RESULT', 'C', '审核是否通过');

--7

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CGZX_KY_ZH', 'ZcEbSignup_signupTab', 'audit');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CGZX_KY_ZH', 'ZcEbSignup_signupTab', 'biding');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CGZX_KY_ZH', 'ZcEbSignup_signupTab', 'opened');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CGZX_KZ_ZH', 'ZcEbSignup_signupTab', 'audit');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CGZX_KZ_ZH', 'ZcEbSignup_signupTab', 'biding');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('CGZX_KZ_ZH', 'ZcEbSignup_signupTab', 'opened');

--20151227
--1
delete from zc_role_search_condition r  where r.condition_id like 'ZcXmcgHt_entrustTab' and r.role_id like 'CGZX_KY%' ;
--2
insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('gys_normal', 'ZcXmcgHt_entrustTab', 'todo');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('gys_normal', 'ZcXmcgHt_entrustTab', 'untread');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('gys_normal', 'ZcXmcgHt_entrustTab', 'exec');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('gys_normal', 'ZcXmcgHt_entrustTab', 'all');

insert into zc_role_search_condition (ROLE_ID, CONDITION_ID, CONDITION_FIELD_CODE)
values ('gys_normal', 'ZcXmcgHt_entrustTab', 'done');

--20151226
--1
insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_B_CATALOGUE', 'fjieZhuanBaseData', null, null, to_date('20-06-2013 22:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_func (FUNC_ID, FUNC_DESC, ORD_INDEX, IS_GRANT_TO_ALL, IS_LIST, SHORTCUT_KEY, IS_CTRL, IS_SHIFT, IS_ALT)
values ('fjieZhuanBaseData', '结转基础资料', 42, null, 'N', null, null, null, null);

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('fjieZhuanBaseData', 'C', '结转基础资料');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_FUNC_fjieZhuanBaseData', 'C', '基础资料结转');
--2

insert into AS_COMPO_FUNC (COMPO_ID, FUNC_ID, IS_WR_LOG, IS_NEVER_USE, TRANS_DATE)
values ('ZC_EB_PROJ', 'fgetNo', 'Y', null, to_date('20-06-2013 22:56:15', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_func (FUNC_ID, FUNC_DESC, ORD_INDEX, IS_GRANT_TO_ALL, IS_LIST, SHORTCUT_KEY, IS_CTRL, IS_SHIFT, IS_ALT)
values ('fgetNo', '获取编号', 42, null, 'N', null, null, null, null);

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('fgetNo', 'C', '获取编号');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_FUNC_fgetNo', 'C', '获取编号');

--3

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KZ_ZH', 'ZC_EB_PROJ', 'fgetNo', to_date('29-05-2013 09:44:44', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CG_ZD', 'ZC_EB_PROJ', 'fgetNo', to_date('29-05-2013 09:44:44', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KY_ZH', 'ZC_EB_PROJ', 'fgetNo', to_date('31-10-2013 19:12:53', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CZ', 'ZC_EB_PROJ', 'fgetNo', to_date('29-05-2013 09:44:44', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CG_CGZXLD', 'ZC_EB_PROJ', 'fgetNo', to_date('29-05-2013 09:44:44', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CG_CSZGY', 'ZC_EB_PROJ', 'fgetNo', to_date('29-05-2013 09:44:44', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KZ_CG', 'ZC_EB_PROJ', 'fgetNo', to_date('31-10-2013 19:12:53', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KZ_JS', 'ZC_EB_PROJ', 'fgetNo', to_date('29-05-2013 09:44:44', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CG_CGZXZHK', 'ZC_EB_PROJ', 'fgetNo', to_date('29-05-2013 09:44:44', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CG_CGCZGY', 'ZC_EB_PROJ', 'fgetNo', to_date('31-10-2013 19:12:53', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CG_CGZX_FZR', 'ZC_EB_PROJ', 'fgetNo', to_date('29-05-2013 09:44:44', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CG_CGCLD', 'ZC_EB_PROJ', 'fgetNo', to_date('29-05-2013 09:44:44', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CG_CGZXEK', 'ZC_EB_PROJ', 'fgetNo', to_date('31-10-2013 19:12:53', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CG_CGZXJSZ', 'ZC_EB_PROJ', 'fgetNo', to_date('29-05-2013 09:44:44', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CGZX_KY_CG', 'ZC_EB_PROJ', 'fgetNo', to_date('29-05-2013 09:44:44', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_role_func (ROLE_ID, COMPO_ID, FUNC_ID, TRANS_DATE)
values ('CG_CGZXYK', 'ZC_EB_PROJ', 'fgetNo', to_date('31-10-2013 19:12:53', 'dd-mm-yyyy hh24:mi:ss'));

--4

delete  FROM AS_MENU_COMPO MC WHERE MC.COMPO_ID LIKE 'ZC_EB_PROJ';

insert into AS_MENU_COMPO (MENU_ID, COMPO_ID, ORD_INDEX, IS_GOTO_EDIT, IS_IN_MENU, IS_ALWAYS_NEW, URL)
values ('ZC_EB_PM', 'ZC_EB_PROJ', 10, 'N', 'Y', 'N', '/GB/jsp/ZC/CommonPage.jsp?className=com.ufgov.zc.client.zc.project.integration_simple.ZcEbProjectSimpleListPanel');

--5 

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

--结转 wf_executor_source
delete  from wf_executor_source where extnd=curNd+1;
insert into wf_executor_source
select node_id, executor, source, responsibility, extcocode, extorgcode, extnd+1 from wf_executor_source where extnd=curNd;

--结转 as_wf_business_superior
delete  from as_wf_business_superior where nd=curNd+1;
 insert into as_wf_business_superior
    select newid, jun_co_code, jun_org_code, jun_posi_code, jun_emp_code, sup_condition, sup_co_code, sup_org_code, sup_posi_code, sup_emp_code, project_name, description, priority, curNd+1 from as_wf_business_superior where nd=curNd;

end sp_zc_jiChuZiLiaoJieZhuan;

--20151220
--1
CREATE OR REPLACE VIEW V_ZC_PRO_MAKE_EXPERT AS
SELECT P.ZC_MAKE_CODE,
 P.ZC_MAKE_NAME,
 C.CO_NAME,
 P.ZC_MAKE_LINKMAN,
 P.ZC_MAKE_TEL,
 P.Agency_Name,
 P.ZC_INPUT_DATE,
 p.agency,
 p.zc_pifu_cgfs
 FROM ZC_P_PRO_MAKE P, MA_COMPANY C, zc_b_agency a
 WHERE P.Co_Code = C.CO_CODE
 AND P.Nd = C.ND
 and p.agency = a.zc_agey_code(+)
 AND P.ZC_MAKE_STATUS IN('exec')
 AND P.ZC_FUKUAN_TYPE = 'Z01'
 UNION ALL
 SELECT O.CODE, O.NAME, O.CO_NAME, O.CONTACTOR, O.PHONE, O.AGENT_NAME,O.OPER_DATE,null,O.PURCHASE_TYPE
 FROM ZC_EB_PROMAKE_OUTER O 
 union all
 select 
 e.sn,
 e.zc_make_name,
 (select c.co_name from ma_company c where c.co_code=e.co_code and c.nd=e.nd) as co_name,
 e.zc_make_linkman,
 e.zc_make_tel,
 e.agency_name,
 e.zc_input_date,
 e.agency,
 e.zc_pifu_cgfs
 from zc_eb_entrust e;

--20151212-2
--1

delete from zc_search_condition s where s.condition_field_code='cancel' and s.condition_id='ZcEbBulletin_bulletinTab' and s.compo_id='ZC_EB_BULLETIN_BID';

delete from zc_role_search_condition r where r.condition_id='ZcEbBulletin_bulletinTab' and r.condition_field_code='cancel';

--2

delete from as_val v where v.valset_id='ZC_VS_QUES_TYPE';

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_QUES_TYPE', '1', '招标', 1, to_date('23-08-2012', 'dd-mm-yyyy'), 'N', to_date('13-12-2015 02:40:33', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_QUES_TYPE', '2', '中标', 2, to_date('23-08-2012', 'dd-mm-yyyy'), 'N', to_date('13-12-2015 02:40:33', 'dd-mm-yyyy hh24:mi:ss'));

insert into as_val (VALSET_ID, VAL_ID, VAL, ORD_INDEX, LSTDATE, IS_SYSTEM, TRANS_DATE)
values ('ZC_VS_QUES_TYPE', '3', '其他', 3, to_date('23-08-2012', 'dd-mm-yyyy'), 'N', to_date('13-12-2015 02:32:36', 'dd-mm-yyyy hh24:mi:ss'));
--3
-- Add/modify columns 
alter table ZC_EB_QUESTION add client_file_blobid VARCHAR2(50);
alter table ZC_EB_QUESTION add jb_file_blobid VARCHAR2(50);
-- Add comments to the columns 
comment on column ZC_EB_QUESTION.client_file_blobid
  is '相关文件ID';
comment on column ZC_EB_QUESTION.jb_file_blobid
  is '相关文件ID';

--20151212
--1

delete from as_option o where O.OPT_ID LIKE 'OPT_ZC_BULLETIN_ZHAOBIAO_BEFORE_PUBLISH_STATUS';

insert into as_option (OPT_ID, CO_CODE, COMPO_ID, TRANS_TYPE, OPT_VAL, IS_SYST_OPT)
values ('OPT_ZC_BULLETIN_ZHAOBIAO_BEFORE_PUBLISH_STATUS', '*', '*', '*', '5', 'Y');

--2
insert into as_posi_role (POSI_CODE, ROLE_ID, TRANS_DATE)
values ('CGZX_ZR', 'ROLE_PUBLISH_BULLETIN', to_date('24-10-2010 00:34:03', 'dd-mm-yyyy hh24:mi:ss'));

--3
update wf_node d set d.task_listener='' where d.node_id='10066059';
update wf_node d set d.task_listener='' where d.node_id='31083'; 
update wf_node d set d.task_listener='' where d.node_id='31089';
update wf_node d set d.task_listener='' where d.node_id='31077'; 

--20151109
--1
-- Add/modify columns 
alter table ZC_EB_ENTRUST add jbr varchar2(60);
alter table ZC_EB_ENTRUST add xbr varchar2(60);
-- Add comments to the columns 
comment on column ZC_EB_ENTRUST.jbr
  is '经办人';
comment on column ZC_EB_ENTRUST.xbr
  is '协办人';
-- Add/modify columns 
alter table ZC_EB_ENTRUST add jbr_name VARCHAR2(60);
alter table ZC_EB_ENTRUST add xbr_name VARCHAR2(60);
-- Add comments to the columns 
comment on column ZC_EB_ENTRUST.jbr_name
  is '经办人';
comment on column ZC_EB_ENTRUST.xbr_name
  is '协办人';
-- Add comments to the columns 
comment on column ZC_EB_ENTRUST.is_des_sup
  is '是否指定供应商';
comment on column ZC_EB_ENTRUST.is_pub
  is '是否公开预算';
comment on column ZC_EB_ENTRUST.is_car
  is '是否汽车采购';
comment on column ZC_EB_ENTRUST.jbr_name
  is '经办人姓名';
comment on column ZC_EB_ENTRUST.xbr_name
  is '协办人姓名';
  
--2

delete from as_tab_col t where t.tab_id='ZC_EB_ENTRUST';


insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'AGENCY', 0, '委托机构代码', '委托机构代码', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'AGENCY_NAME', 0, '委托机构名称', '委托机构名称', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'CO_CODE', 0, '单位代码(采购单位代码)', '单位代码(采购单位代码)', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'EXECUTE_DATE', 0, '受理时间（执行时间）', '受理时间（执行时间）', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'EXECUTOR', 0, '执行者', '执行者', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'IS_CAR', 0, '是否汽车采购', '是否汽车采购', 'VARCHAR2', 2, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'IS_DES_SUP', 0, '是否指定供应商', '是否指定供应商', 'VARCHAR2', 2, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'IS_PUB', 0, '是否公开预算', '是否公开预算', 'VARCHAR2', 2, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'JBR', 0, '经办人', '经办人', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'JBR_NAME', 0, '经办人姓名', '经办人姓名', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'LEADER_ID', 0, '项目负责人ID', '项目负责人ID', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'LEADER_TEL', 0, '项目负责人联系电话', '项目负责人联系电话', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'ND', 0, '预算年度', '预算年度', 'CHAR', 4, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'ORG_CODE', 0, '预算单位主管业务处室', '预算单位主管业务处室', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'PROCESS_INST_ID', 0, 'PROCESS_INST_ID', 'PROCESS_INST_ID', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'REMARK', 0, '项目备注', '项目备注', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'SN', 0, '采购委托编号', '采购委托编号', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, 'N', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'SN_CODE', 0, '中心任务单编号', '中心任务单编号', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'STATUS', 0, '单据状态', '单据状态', 'VARCHAR2', 10, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'UNTREAD_REASON', 0, '不予受理原因', '不予受理原因', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'XBR', 0, '协办人', '协办人', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'XBR_NAME', 0, '协办人姓名', '协办人姓名', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'ZC_DIYU_DAIMA', 0, '地域代码', '地域代码', 'VARCHAR2', 10, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'ZC_FUKUAN_TYPE', 0, '采购类型（项目采购，协议采购，定点采购）', '采购类型（项目采购，协议采购，定点采购）', 'VARCHAR2', 10, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'ZC_IMP_FILE', 0, '进出口相关附件', '进出口相关附件', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'ZC_IMP_FILE_BLOBID', 0, '进出口相关附件BLOBID', '进出口相关附件BLOBID', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'ZC_INPUT_CODE', 0, '录入人', '录入人', 'VARCHAR2', 30, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'ZC_INPUT_DATE', 0, '录入时间', '录入时间', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'ZC_IS_IMP', 0, '是否涉及进出口', '是否涉及进出口', 'VARCHAR2', 2, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'ZC_IS_NOTARY', 0, '是否公证', '是否公证', 'VARCHAR2', 2, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'ZC_MAKE_CODE', 0, '项目代码', '项目代码', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'ZC_MAKE_LINKMAN', 0, '预算单位联系人', '预算单位联系人', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'ZC_MAKE_NAME', 0, '项目名称', '项目名称', 'VARCHAR2', 200, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'ZC_MAKE_TEL', 0, '预算单位联系人电话', '预算单位联系人电话', 'VARCHAR2', 60, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'ZC_MONEY_BI_SUM', 0, '项目预算', '项目预算', 'NUMBER', 22, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'ZC_PIFU_CGFS', 0, '采购方式', '采购方式', 'VARCHAR2', 10, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

insert into as_tab_col (TAB_ID, DATA_ITEM, ORD_INDEX, DATA_ITEM_DESC, DATA_ITEM_NA, DATA_TYPE, DATA_LEN, DEC_LEN, F_REF_NAME, F_FIELD, IS_SAVE, VAL_SET_ID, IS_FPK, IS_USED, IS_PRE, IS_PK, IS_NULL, IS_NUM, IS_LIST, IS_SELE, DFLT_VAL, ADD_DATE, DB_VER_NO, IS_PAGE_FIELD, MIN_VALUE, MAX_VALUE, MIN_LENGTH, IS_EFFECT, VS_EFFECT_TABLE, URL, IS_KILO_STYLE, IS_TREEVIEW, IS_ONLYLEAF, EDIT_BOX_TYPE, IS_ORDER)
values ('ZC_EB_ENTRUST', 'ZC_WEITO_DATE', 0, '项目下达时间', '项目下达时间', 'DATE', 7, null, null, null, 'Y', null, null, 'Y', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

--3

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_AGENCY', 'C', '委托机构代码');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_AGENCY_NAME', 'C', '委托机构名称');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_CO_CODE', 'C', '单位代码');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_EXECUTE_DATE', 'C', '受理时间');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_EXECUTOR', 'C', '执行者');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_IS_CAR', 'C', '是否汽车采购');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_IS_DES_SUP', 'C', '是否指定供应商');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_IS_PUB', 'C', '是否公开预算');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_JBR', 'C', '经办人');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_JBR_NAME', 'C', '经办人姓名');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_LEADER_ID', 'C', '项目负责人ID');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_LEADER_TEL', 'C', '项目负责人联系电话');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_ND', 'C', '预算年度');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_ORG_CODE', 'C', '预算单位主管业务处室');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_PROCESS_INST_ID', 'C', 'PROCESS_INST_ID');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_REMARK', 'C', '项目备注');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_SN', 'C', '采购委托编号');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_SN_CODE', 'C', '中心任务单编号');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_STATUS', 'C', '单据状态');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_UNTREAD_REASON', 'C', '不予受理原因');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_XBR', 'C', '协办人');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_XBR_NAME', 'C', '协办人姓名');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_ZC_DIYU_DAIMA', 'C', '地域代码');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_ZC_FUKUAN_TYPE', 'C', '采购类型');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_ZC_IMP_FILE', 'C', '进出口相关附件');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_ZC_IMP_FILE_BLOBID', 'C', '进出口相关附件BLOBID');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_ZC_INPUT_CODE', 'C', '录入人');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_ZC_INPUT_DATE', 'C', '录入时间');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_ZC_IS_IMP', 'C', '是否涉及进出口');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_ZC_IS_NOTARY', 'C', '是否公证');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_ZC_MAKE_CODE', 'C', '项目代码');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_ZC_MAKE_LINKMAN', 'C', '预算单位联系人');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_ZC_MAKE_NAME', 'C', '项目名称');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_ZC_MAKE_TEL', 'C', '预算单位联系人电话');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_ZC_MONEY_BI_SUM', 'C', '项目预算');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_ZC_PIFU_CGFS', 'C', '采购方式');

insert into as_lang_trans (RES_ID, LANG_ID, RES_NA)
values ('ZC_EB_ENTRUST_ZC_WEITO_DATE', 'C', '项目下达时间');







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















