/**
 * 
 */
package com.ufgov.zc.client.zc.expertselection;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 * 这个模式不再使用，使用PasswdCheckDialog模式，PasswdCheckDialog的模式是java自己提供的模式
 * @author Administrator
 */
public class PasswordDialogTest {

  static JPasswordField passwd = new JPasswordField(10);

  public static String showInputDialog() {
    JOptionPane localJOptionPane = new JOptionPane("Please input this subject's password:", JOptionPane.QUESTION_MESSAGE);
    localJOptionPane.add(passwd, 1);
    passwd.setEchoChar('*');
    JDialog localJDialog = localJOptionPane.createDialog(localJOptionPane, "Input");
    localJDialog.setVisible(true);
    String localObject = String.valueOf(passwd.getPassword());
    localJDialog.dispose();
    return localObject;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(showInputDialog());
  }

}