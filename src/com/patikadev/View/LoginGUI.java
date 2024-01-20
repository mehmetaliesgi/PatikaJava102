package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Operator;
import com.patikadev.Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame{
    private JPanel pnlLogin;
    private JPanel wtop;
    private JPanel wbottom;
    private JTextField fldUserName;
    private JButton btnLogin;
    private JPasswordField fldPassword;

    public LoginGUI() {
        add(pnlLogin);
        setSize(400, 400);
        setLocation(Helper.screenCenterLocation("x", getSize()), Helper.screenCenterLocation("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        btnLogin.addActionListener(e -> {
            if (Helper.isFieldEmpty(fldUserName) || Helper.isFieldEmpty(fldPassword)) {
                Helper.showMessage("fill");
            } else {
                User user = User.getFetch(fldUserName.getText(), fldPassword.getText());
                if (user == null) {
                    Helper.showMessage("Kullanıcı bulunamadı!!");
                } else {
                    switch (user.getUserType()) {
                        case "OPERATOR":
                            OperatorGUI operatorGUI = new OperatorGUI((Operator) user);
                            break;
                        case "STUDENT":
                            StudentGUI studentGUI = new StudentGUI();
                            break;
                        case "EDUCATOR":
                            EducatorGUI educatorGUI = new EducatorGUI();
                            break;
                    }
                    dispose();
                }
            }
        });
    }

    public static void main(String[] args) {
        LoginGUI loginGUI = new LoginGUI();
    }
}
