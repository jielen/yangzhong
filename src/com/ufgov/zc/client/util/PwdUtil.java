package com.ufgov.zc.client.util;

public class PwdUtil {
  /**
   * 口令加密与解密
   * 
   * @param passwd
   * @return
   * 
   */
  public static String _encodePwd(String passwd) {

    String encodeStr = "$#TGDF*FAA&21we@VGXD532w23413!";
    String tempStr = "";
    if (passwd == null) {
      passwd = "";
    }

    int i;
    for (i = 0; i < passwd.length(); i++) {
      tempStr = tempStr + (char) (passwd.charAt(i) ^ encodeStr.charAt(i));
    }

    return tempStr;
  }

  public static String recodePwd(String paramString) {
    String str1 = "$#TGDF*FAA&21we@VGXD532w23413!";
    String str2 = "";
    if (paramString == null)
      paramString = "";
    for (int i = 0; i < paramString.length(); i++) {
      char c = (char) (paramString.charAt(i) ^ (str1.charAt(i) ^ 0xFFFFFFFF) ^ 0xFFFFFFFF);
      str2 = str2 + c;
    }
    return str2;
  }
  
  public static void main(String[] args){
    String name="dt5chenjl2130";
    String rtn=PwdUtil._encodePwd(name);    
    System.out.println(rtn);
    String s2=PwdUtil.recodePwd(rtn);
    System.out.println(s2);
  }
}
