package com.ufgov.zc.server.zc.util;

public class GeneralFunc {

  public static String encodePwd(String passwd) {
    String encodeStr = "$#TGDF*FAA&21we@VGXD532w23413!";
    String tempStr = "";
    if (passwd == null) {
      passwd = "";
    }

    for (int i = 0; i < passwd.length(); i++) {
      tempStr = tempStr + (char) (passwd.charAt(i) ^ encodeStr.charAt(i));
    }

    return tempStr;
  }

  public static String _encodePwd(String paramString) {
    /*String str1 = "$#TGDF*FAA&21we@VGXD532w23413!";
    String str2 = "";
    if (paramString == null) paramString = "";
    for (int i = 0; i < paramString.length(); i++)
      str2 = str2 + (char) (paramString.charAt(i) ^ str1.charAt(i));
    return str2;*/
    return encodePwd(paramString);
  }

  public static String recodePwd(String encodedPasswd) {
    String encodeStr = "$#TGDF*FAA&21we@VGXD532w23413!";
    String tempStr = "";
    if (encodedPasswd == null) {
      encodedPasswd = "";
    }

    for (int i = 0; i < encodedPasswd.length(); i++) {
      char truePass = (char) (encodedPasswd.charAt(i) ^ (encodeStr.charAt(i) ^ 0xFFFFFFFF) ^ 0xFFFFFFFF);

      tempStr = tempStr + truePass;
    }

    return tempStr;
  }

  private static String _encodePwd2(String passwd) {

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

  public static void main(String[] args) {
    String name = "abcdefg";
    String s1 = GeneralFunc.encodePwd(name);
    String s2 = GeneralFunc.recodePwd(s1);
    System.out.println(name);
    System.out.println(s1);
    System.out.println(s2);

    String t1 = com.anyi.gp.pub.GeneralFunc.encodePwd(name);
    String t2 = com.anyi.gp.pub.GeneralFunc.recodePwd(t1);
    System.out.println(t1);
    System.out.println(t2);

    name = "NZ.?ut";
    //    name = "f~}v";
    s2 = GeneralFunc.recodePwd(name);
    s1 = GeneralFunc.encodePwd(s2);
    System.out.println(name);
    System.out.println(s2);
    System.out.println(s1);

  }
}
