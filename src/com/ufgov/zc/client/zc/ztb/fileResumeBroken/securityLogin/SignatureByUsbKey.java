package com.ufgov.zc.client.zc.ztb.fileResumeBroken.securityLogin;import com.pheox.jcapi.CoreKeyStoreJNI;import com.pheox.jcapi.CoreUtilJNI;import com.pheox.jcapi.JCAPIRSAPrivateKey;import com.pheox.jcapi.SignatureUtils;import com.ufgov.zc.client.zc.ztb.util.GV;import sun.misc.BASE64Encoder;import java.io.BufferedReader;import java.io.ByteArrayInputStream;import java.io.InputStreamReader;import java.security.InvalidKeyException;import java.security.SignatureException;import java.security.cert.CertificateException;import java.security.cert.CertificateFactory;import java.security.cert.X509Certificate;import java.text.SimpleDateFormat;import java.util.Date;import java.util.Hashtable;import java.util.Iterator;import java.util.Random;public class SignatureByUsbKey {  Hashtable certs = new Hashtable();  Hashtable signCerts = new Hashtable();  public Hashtable getCertificates() {    try {      System.loadLibrary("jcapi");    } catch (UnsatisfiedLinkError e) {      e.printStackTrace();    }    CoreUtilJNI core;    try {      core = new CoreUtilJNI();    } catch (Exception e) {      e.printStackTrace();    }    this.certs.clear();    String certClass = "My";    String[] aliase;    int k = (aliase = CoreKeyStoreJNI.aliases(certClass, false)).length;    for (int i = 0; i < k; ++i) {      try {        byte[] certByte;        if ((certByte = CoreKeyStoreJNI.getCertificate(aliase[i])) == null)          return null;        X509Certificate x509certificate = null;        CertificateFactory certificatefactory = CertificateFactory.getInstance("X.509");        try {          x509certificate = (X509Certificate) certificatefactory.generateCertificate(new ByteArrayInputStream(certByte));          this.certs.put(aliase[i], x509certificate);        } catch (CertificateException e) {          e.printStackTrace();        }      } catch (Exception e) {        e.printStackTrace();      }    }    return this.certs;  }  public Hashtable getSignCertificates() {    try {      System.loadLibrary("jcapi");    } catch (UnsatisfiedLinkError e) {      e.printStackTrace();    }    CoreUtilJNI core;    try {      core = new CoreUtilJNI();    } catch (Exception e) {      e.printStackTrace();    }    this.signCerts.clear();    String certClass = "My";    String[] aliase;    int k = (aliase = CoreKeyStoreJNI.aliases(certClass, false)).length;    for (int i = 0; i < k; ++i) {      try {        byte[] certByte;        if ((certByte = CoreKeyStoreJNI.getCertificate(aliase[i])) == null) {          return null;        }        X509Certificate x509certificate = null;        CertificateFactory certificatefactory = CertificateFactory.getInstance("X.509");        try {          x509certificate = (X509Certificate) certificatefactory.generateCertificate(new ByteArrayInputStream(certByte));          boolean[] keyUsage = x509certificate.getKeyUsage();          if ((keyUsage != null) && (keyUsage[0])) {            this.signCerts.put(aliase[i], x509certificate);          }        } catch (CertificateException e) {          e.printStackTrace();        }      } catch (Exception e) {        e.printStackTrace();      }    }    return this.signCerts;  }  public String signByAlias(String alias, String datetime) throws Exception {    String result = "";    try {      System.loadLibrary("jcapi");    } catch (UnsatisfiedLinkError e) {      e.printStackTrace();      throw new Exception("JCAPI.dll加载出错！");    }    String myalias = alias;    byte[][] exportByte;    try {      if ((exportByte = CoreKeyStoreJNI.getKey(myalias)) == null) {        return result;      }    } catch (Exception e) {      e.printStackTrace();      throw new Exception(GV.getSimpleMsg("caReadErrAndCheck"));    }    if (exportByte.length == 0) {      JCAPIRSAPrivateKey jcapikey = new JCAPIRSAPrivateKey(myalias.getBytes());      byte[] data = (byte[]) null;      String dataString = generateRandom(512);      data = dataString.getBytes();      byte[] signature = (byte[]) null;      SignatureUtils sigutil = new SignatureUtils("MD5");      try {        sigutil.initSign(jcapikey);        sigutil.update(data, 0, data.length);        signature = sigutil.sign();        X509Certificate cert = selectCertificate(alias);        BASE64Encoder encoder = new BASE64Encoder();        result = result + datetime;        result = result + ":";        result = result + new String(encoder.encode(data));        result = result + ":";        result = result + new String(encoder.encode(signature));        result = result + ":";        result = result + new String(encoder.encode(cert.getEncoded()));        return result;      } catch (InvalidKeyException e) {        e.printStackTrace();      } catch (SignatureException e) {        e.printStackTrace();      } catch (Exception e) {        e.printStackTrace();      }    }    return result;  }  private X509Certificate selectCertificate(String alias) {    X509Certificate selectedCert = null;    try {      String[] certAlias;      int k = (certAlias = CoreKeyStoreJNI.aliases("My", false)).length;      for (int i1 = 0; i1 < k; ++i1) {        if (!(alias.equals(certAlias[i1]))) {          continue;        }        byte[] certbyte;        if ((certbyte = CoreKeyStoreJNI.getCertificate(certAlias[i1])) == null)          return null;        X509Certificate x509certificate = null;        CertificateFactory certificatefactory = CertificateFactory.getInstance("X.509");        try {          x509certificate = (X509Certificate) certificatefactory.generateCertificate(new ByteArrayInputStream(certbyte));          selectedCert = x509certificate;        } catch (CertificateException e) {          e.printStackTrace();        }      }    } catch (Exception e) {      e.printStackTrace();    }    return selectedCert;  }  public static String generateRandom(int length) {    if (length < 0) {      length = 128;    }    StringBuffer sourceBuffer = new StringBuffer("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");    String result = "";    Random rand = new Random();    for (int i = 0; i < length; ++i) {      result = result + sourceBuffer.charAt(rand.nextInt(sourceBuffer.length()));    }    return result;  }  public static void main(String[] args) throws Exception {    SignatureByUsbKey s = new SignatureByUsbKey();    System.out.println("----------------------------------");    Hashtable scs = s.getSignCertificates();    System.out.println("Cert list:");    int count = 0;    // 这里是需要形成的证书列表的选择界面，然后显示证书列表信息，列表信息需以keySet序号保持一致    for (Iterator i = scs.keySet().iterator(); i.hasNext();) {      String alias = (String) i.next();      X509Certificate cert = (X509Certificate) scs.get(alias);      ++count;      System.out.print(count + " - Alias:" + alias);      System.out.println(" Cert:" + cert.getSubjectDN());    }    //将scs.keySet()中已选择的证书序号赋值到select里    System.out.println("Please select a cert[1-...]:");    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));    int select = 0;    try {      select = Integer.parseInt(reader.readLine());    } catch (Exception e) {      e.printStackTrace();    }    if ((select <= count) && (select > 0)) {      int index = 0;      String al = "";      for (Iterator i = scs.keySet().iterator(); i.hasNext();) {        String alias = (String) i.next();        X509Certificate cert = (X509Certificate) scs.get(alias);        ++index;        if (index == select) {          al = alias;          SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");          String datetime = tempDate.format(new Date());          String signstr = s.signByAlias(al, datetime);          System.out.println();          System.out.println("signstr:" + signstr);        }      }    }    System.out.println("----------------------------------");  }}