package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Operator;
import com.patikadev.Model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class OperatorGUI extends JFrame {
    private JPanel wrapper;
    private JTabbedPane tabOperator;
    private JLabel lblWelcome;
    private JPanel pnlTop;
    private JButton btnLogout;
    private JPanel pnlUserList;
    private JScrollPane scrlUserList;
    private JTable tblUserList;
    private JButton btnTheme;
    private JPanel pnlUserForm;
    private JLabel lbAdSoyad;
    private JTextField fldName;
    private JLabel lbKullaniciAdi;
    private JTextField fldUserName;
    private JLabel lbPassword;
    private JTextField fldPassword;
    private JLabel lbUyelikTipi;
    private JComboBox cmbUsetType;
    private JButton btnUserSubmit;
    private DefaultTableModel mdlUserList;  // Tabloda veri tutmak için gerekli olan değişken tanımlandı.
    private Object[] rowUserList;

    private final Operator operator;
    public OperatorGUI(Operator operator) {
        this.operator = operator;

        add(wrapper);
        setSize(1000, 500);
        int x = Helper.screenCenterLocation("x", getSize());
        int y = Helper.screenCenterLocation("y", getSize());
        setLocation(x, y);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        lblWelcome.setText("Hoşgeldiniz: " + operator.getName());

        // ModelUserList
        mdlUserList = new DefaultTableModel();
        Object[] colUserList = {"id", "Ad Soyad", "Kullanici Adi", "Sifre", "Uyelik Tipi"};
        mdlUserList.setColumnIdentifiers(colUserList);
        /*
        Object[] firstRow = {1, "Ali Kalander", "alikalender", "123456", "OPERATOR"};
        mdlUserList.addRow(firstRow);
         */

        for (User obj : User.getList()) {
            Object[] row = new Object[colUserList.length];
            row[0] = obj.getId();
            row[1] = obj.getName();
            row[2] = obj.getUsername();
            row[3] = obj.getPassword();
            row[4] = obj.getUserType();

            mdlUserList.addRow(row);
        }

        tblUserList.setModel(mdlUserList);
        tblUserList.getTableHeader().setReorderingAllowed(false);

        btnUserSubmit.addActionListener(e -> {
            if (Helper.isFieldEmpty(fldName) || Helper.isFieldEmpty(fldUserName) || Helper.isFieldEmpty(fldPassword) || cmbUsetType.getSelectedItem().equals("")) {
                Helper.showMessage("fill");
            }
            else {
                String name = fldName.getText();
                String username = fldUserName.getText();
                String password = fldPassword.getText();
                String userType = cmbUsetType.getSelectedItem().toString();
                System.out.println(userType);
                if (User.addUser(name, username, password, userType)) {
                    Helper.showMessage("done");
                }
                else {
                    Helper.showMessage("error");
                }

            }
        });
    }





    public static void main(String[] args) {
        Operator operator = new Operator();
        operator.setName("Mehmet Ali Eşgi");
        operator.setUsername("mehmetaliesgi");
        operator.setPassword("123456");
        operator.setUserType("OPERATOR");
        OperatorGUI operatorGUI = new OperatorGUI(operator);
    }
}
