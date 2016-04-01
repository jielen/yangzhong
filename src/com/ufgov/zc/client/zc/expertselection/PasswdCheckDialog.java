/**
 * 
 */
package com.ufgov.zc.client.zc.expertselection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import com.ufgov.zc.client.component.GkBaseDialog;

/**
 * 检查专家抽取密码
 * @author Administrator
 */
public class PasswdCheckDialog extends GkBaseDialog implements ActionListener, PropertyChangeListener {
  /**
   * 
   */
  private static final long serialVersionUID = -8855523688976184357L;

  private String typedText = null;

  private JPasswordField passwdFd;

  private ZcEmExpertSelectionEditPanel dd;

  private JOptionPane optionPane;

  private String btnString1 = "确认";

  private String btnString2 = "取消";

  private String pwd = "";

  /**
   * Returns null if the typed string was invalid; otherwise, returns the string
   * as the user entered it.
   */
  public String getValidatedText() {
    return typedText;
  }

  /** Creates the reusable dialog. */
  public PasswdCheckDialog(ZcEmExpertSelectionEditPanel selectPanel, String pwd) {
    super(selectPanel.getParentDialog(), true);
    dd = selectPanel;
    this.pwd = pwd;
    setTitle("密码");

    passwdFd = new JPasswordField(30);

    //Create an array of the text and components to be displayed.
    String msgString1 = "请输入专家抽取密码:";
    String msgString2 = "\n";
    Object[] array = { msgString1, msgString2, passwdFd };

    //Create an array specifying the number of dialog buttons
    //and their text.
    Object[] options = { btnString1, btnString2 };

    //Create the JOptionPane.
    optionPane = new JOptionPane(array, JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION, null, options, options[0]);

    //Make this dialog display it.
    setContentPane(optionPane);

    //Handle window closing correctly.
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
        /*
        * Instead of directly closing the window,
        * we're going to change the JOptionPane's
        * value property.
        */
        optionPane.setValue(new Integer(JOptionPane.CLOSED_OPTION));
      }
    });

    //Ensure the text field always gets the first focus.
    addComponentListener(new ComponentAdapter() {
      public void componentShown(ComponentEvent ce) {
        passwdFd.requestFocusInWindow();
      }
    });

    //Register an event handler that puts the text into the option pane.
    passwdFd.addActionListener(this);

    //Register an event handler that reacts to option pane state changes.
    optionPane.addPropertyChangeListener(this);
  }

  /** This method handles events for the text field. */
  public void actionPerformed(ActionEvent e) {
    optionPane.setValue(btnString1);
  }

  /** This method reacts to state changes in the option pane. */
  public void propertyChange(PropertyChangeEvent e) {
    String prop = e.getPropertyName();

    if (isVisible() && (e.getSource() == optionPane) && (JOptionPane.VALUE_PROPERTY.equals(prop) || JOptionPane.INPUT_VALUE_PROPERTY.equals(prop))) {
      Object value = optionPane.getValue();

      if (value == JOptionPane.UNINITIALIZED_VALUE) {
        //ignore reset
        return;
      }

      //Reset the JOptionPane's value.
      //If you don't do this, then if the user
      //presses the same button next time, no
      //property change event will be fired.
      optionPane.setValue(JOptionPane.UNINITIALIZED_VALUE);

      if (btnString1.equals(value)) {
        char[] np = passwdFd.getPassword();

        typedText = np == null ? "" : new String(np);

        if (pwd.equals(typedText.trim())) {
          clearAndHide();
          dd.beginSelect();
        } else {
          //text was invalid
          passwdFd.selectAll();
          JOptionPane.showMessageDialog(PasswdCheckDialog.this, "密码错误！", "请重试", JOptionPane.ERROR_MESSAGE);
          typedText = null;
          passwdFd.requestFocusInWindow();
        }

      } else { //user closed dialog or clicked cancel
        typedText = null;
        clearAndHide();
      }
    }
  }

  /** This method clears the dialog and hides it. */
  public void clearAndHide() {
    passwdFd.setText(null);
    setVisible(false);
  }
}
