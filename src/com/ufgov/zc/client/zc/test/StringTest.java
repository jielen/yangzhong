/**
 * 
 */
package com.ufgov.zc.client.zc.test;

import com.anyi.gp.pub.GeneralFunc;
import com.ufgov.zc.client.zc.ZcUtil;

/**
 * @author Administrator
 */
public class StringTest {

  /**
   * @param args
   */
  public static void main(String[] args) {
    StringTest t = new StringTest();
    //    t.showStr();
    //    t.encode();
    //    t.longToInt();
    //    t.strIndx();
    t.subStr();
  }

  void strIndx() {
    String str = "asdc.jpg";
    System.out.println(str.substring(str.lastIndexOf('.') + 1));
  }

  void showStr() {
    String GET_EM_CALL_SERVER_LIST = "SELECT C.* FROM EM_CALL_SERVER_LIST C, ZC_EM_EXPERT_PRO_BILL B WHERE C.EM_BILL_CODE = B.EM_BILL_CODE  AND B.EM_BILL_STATUS = 'SELECTING' AND C.ISCALL < ? AND C.ISCALL >= ? "
      + " and c.em_expert_code not in("
      + " select e.em_expert_code from ZC_EM_EXPERT_EVALUATION e where e.em_bill_code = b.em_bill_code "
      + //同意参加的不再拨打电话
      " union "
      + " select distinct vr.em_expert_code from (select r.em_bill_code,r.em_expert_code from em_call_expert_record r where r.call_num = '3' or r.call_state = '8') vr where vr.em_bill_code = c.em_bill_code and vr.em_expert_code = c.em_expert_code)"; //呼叫记录达到3次、明确拒绝的不再拨打电话

    System.out.println(GET_EM_CALL_SERVER_LIST);
  }

  void encode() {
    String str = "hello world";
    System.out.println(str);
    str = GeneralFunc.encodePwd(str);
    System.out.println(str);
    str = GeneralFunc.recodePwd(str);
    System.out.println(str);
    str = ZcUtil.encodePwd(str);
    System.out.println(str);
    str = ZcUtil.recodePwd(str);
    System.out.println(str);

  }

  void longToInt() {
    byte bmax, bmin;
    short shmax, shmin;
    char cmax, cmin;
    int imax, imin;
    long lmax, lmin;
    float fmax, fmin;
    double dmax, dmin;
    fmax = Float.MAX_VALUE;
    fmin = Float.MIN_VALUE;
    dmax = Double.MAX_VALUE;
    dmin = Double.MIN_VALUE;
    bmax = Byte.MAX_VALUE;
    bmin = Byte.MIN_VALUE;
    cmax = Character.MAX_VALUE;
    cmin = Character.MIN_VALUE;
    shmax = Short.MAX_VALUE;
    shmin = Short.MIN_VALUE;
    imax = Integer.MAX_VALUE;
    imin = Integer.MIN_VALUE;
    lmax = Long.MAX_VALUE;
    lmin = Long.MIN_VALUE;
    System.out.println("float max=" + fmax);
    System.out.println("float min=" + fmin);
    System.out.println("double max=" + dmax);
    System.out.println("double max=" + dmin);
    System.out.println("byte max=" + bmax);
    System.out.println("byte min=" + bmin);
    System.out.println("char max=" + cmax);
    System.out.println("char min=" + cmin);
    System.out.println("short max=" + shmax);
    System.out.println("short min=" + shmin);
    System.out.println("int max=" + imax);
    System.out.println("int min=" + imin);
    System.out.println("long max=" + lmax);
    System.out.println("long min=" + lmin);
    Long ll = new Long(System.currentTimeMillis());
    System.out.println("currentTimeMillis=" + System.currentTimeMillis());
    System.out.println("currentTimeMillis int=" + ll.intValue());

  }

  void subStr() {
    String emMobile = "9ttt13611387417";
    emMobile = emMobile.substring(emMobile.length() - 11, emMobile.length());
    System.out.println(emMobile);
  }
}
