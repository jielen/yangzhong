package com.ufgov.zc.client.zc.ztb.util;import com.snca.assClient.CertificateAuthorityServicesClient;import com.snca.assClient.CertificateAuthorityServicesPortType;import com.ufgov.zc.client.zc.ztb.fileResumeBroken.authentication.Transfer;import com.ufgov.zc.client.zc.ztb.fileResumeBroken.securityLogin.SignatureByUsbKey;import javax.swing.*;import java.awt.*;import java.security.cert.X509Certificate;import java.text.SimpleDateFormat;import java.util.*;public class CALogin {  private Map parameterMap = new HashMap();  private Map returnMap = new HashMap();  private SignatureByUsbKey s;  private Hashtable scs;  private String[] item = new String[10]; // 证书个数一般情况下不会超出100个  public Map getParameterMap() {    return parameterMap;  }  public void setParameterMap(Map parameterMap) {    this.parameterMap = parameterMap;  }  public void readUKey() {    s = new SignatureByUsbKey();    scs = s.getSignCertificates();    int count = 0;    // 这里是需要形成的证书列表的选择界面，然后显示证书列表信息，列表信息需以keySet序号保持一致    for (Iterator i = scs.keySet().iterator(); i.hasNext();) {      String alias = (String) i.next();      if (alias == null || "".equals(alias))        continue;      X509Certificate cert = (X509Certificate) scs.get(alias);      // 取其中的有用字符，并拼装      System.out.println("UserVerify 805:" + alias);      String[] strArr = cert.getSubjectDN().toString().split(",");      String tempStr = "";      int k = 0;      if (strArr.length >= 4) {        k = strArr[3].indexOf("C=");        tempStr = tempStr + strArr[3].substring(k + 2);      }      System.out.println("UserVerify 810:" + tempStr);      if (strArr.length >= 3) {        k = strArr[2].indexOf("ST=");        tempStr = tempStr + strArr[2].substring(k + 3);      }      if (strArr.length >= 2) {        k = strArr[1].indexOf("L=");        tempStr = tempStr + strArr[1].substring(k + 2);      }      if (strArr.length >= 1) {        k = strArr[0].indexOf("CN=");        tempStr = tempStr + strArr[0].substring(k + 3);      }      // 将数据证书名称放到下拉列表中      item[count] = tempStr;      ++count;      System.out.print(count + " - Alias:" + alias);      System.out.println(" Cert:" + cert.getSubjectDN());    }  }  @SuppressWarnings("unchecked")  public String genVerifyCode(int select) throws Exception {    String signstr = "";    int index = 0;    String al = "";    for (Iterator i = scs.keySet().iterator(); i.hasNext();) {      String alias = (String) i.next();      ++index;      if (index == select) {        al = alias;        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");        String datetime = tempDate.format(new Date());        signstr = s.signByAlias(al, datetime);      }    }    return signstr;  }  public String getCaSerialCode(int selectedIndex) throws Exception {    // 得到key盘中的验证码    String identifyCode = genVerifyCode(selectedIndex);    System.out.println("UserVerify 161:" + identifyCode);    // 通过webService得到验证码    CertificateAuthorityServicesClient client = new CertificateAuthorityServicesClient();    CertificateAuthorityServicesPortType service = client.getCertificateAuthorityServicesHttpSoap11Endpoint();    String caCode = service.verifySignCS(identifyCode);    System.out.println("UserVerify 168:" + caCode);    return caCode;  }  public JComboBox getCAItemsComboBox() {    this.readUKey();    JComboBox caJComboBox = new JComboBox();    caJComboBox.setSize(new Dimension(300, 20));    DefaultComboBoxModel model = new DefaultComboBoxModel(item);    caJComboBox.setModel(model);    return caJComboBox;  }  public DefaultComboBoxModel getCAItemsComboBoxModel() {    this.readUKey();    if (item != null && item.length > 0 && item[0] != null) {      return new DefaultComboBoxModel(item);    } else {      return null;    }  }  @SuppressWarnings("unchecked")  public Map doCheckIn() {    Transfer transfer = new Transfer(parameterMap, "loginaction");    transfer.startTransfer();    returnMap = transfer.getReturnMap();    return this.returnMap;  }}