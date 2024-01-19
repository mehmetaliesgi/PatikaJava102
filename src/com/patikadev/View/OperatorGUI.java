package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Helper.Item;
import com.patikadev.Model.Course;
import com.patikadev.Model.Operator;
import com.patikadev.Model.Patika;
import com.patikadev.Model.User;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

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
    private JLabel lblUserID;
    private JTextField fldUserID;
    private JButton btnDeleteUser;
    private JTextField fldsearchUser;
    private JLabel lblsearchUser;
    private JTextField fldSearchNameSurname;
    private JLabel lblNameSurname;
    private JLabel lblUserType;
    private JComboBox cmbSearchUserType;
    private JButton btnFilter;
    private JPanel pnlPatikaList;
    private JScrollPane scrlPatika;
    private JTable tblPatikaList;
    private JLabel lblPatikaName;
    private JTextField fldPatikaName;
    private JButton btnAddPatika;
    private JPanel pnlCourseList;
    private JScrollPane scrlCourseList;
    private JTable tblCourseList;
    private JPanel pnlCourseAdd;
    private JTextField fldCourseName;
    private JLabel lblProgramLang;
    private JLabel lblCourseName;
    private JTextField fldPragramLang;
    private JComboBox cmbPatikas;
    private JLabel lblPatika;
    private JLabel lblEducator;
    private JComboBox cmbCourseEducator;
    private JButton btnAddCourse;
    private DefaultTableModel mdlUserList;  // Tabloda veri tutmak için gerekli olan değişken tanımlandı.
    private Object[] rowUserList;
    private final Operator operator;
    private DefaultTableModel mdlPatikaList;
    private Object[] rowPatikaList;
    private JPopupMenu patikaMenu;
    private DefaultTableModel mdlCourseList;
    private Object[] rowCourseList;


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
        mdlUserList = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) // ID alanının edit edilebilmesini önledik.
                    return false;
                return super.isCellEditable(row, column);
            }
        };
        Object[] colUserList = {"id", "Ad Soyad", "Kullanici Adi", "Sifre", "Uyelik Tipi"};
        mdlUserList.setColumnIdentifiers(colUserList);
        rowUserList = new Object[colUserList.length];
        /*
        Object[] firstRow = {1, "Ali Kalander", "alikalender", "123456", "OPERATOR"};
        mdlUserList.addRow(firstRow);
         */
        loadUserModel();

        tblUserList.setModel(mdlUserList);
        tblUserList.getTableHeader().setReorderingAllowed(false);

        // Silmek istediğimiz satıra tıkladığımızda id değerini bulduğumuz kod parçası.
        tblUserList.getSelectionModel().addListSelectionListener(e -> {
            try {
                String selectUserID = tblUserList.getValueAt(tblUserList.getSelectedRow(), 0).toString();
                fldUserID.setText(selectUserID);
            } catch (Exception ex) {

            }
        });

        tblUserList.getModel().addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int userID = Integer.parseInt(tblUserList.getValueAt(tblUserList.getSelectedRow(), 0).toString());
                String name = tblUserList.getValueAt(tblUserList.getSelectedRow(), 1).toString();
                String userName = tblUserList.getValueAt(tblUserList.getSelectedRow(), 2).toString();
                String password = tblUserList.getValueAt(tblUserList.getSelectedRow(), 3).toString();
                String userType = tblUserList.getValueAt(tblUserList.getSelectedRow(), 4).toString();

                User.updateUser(userID, name, userName, password, userType);
                loadUserModel();
                fldUserID.setText(null);
                fldUserName.setText(null);
                fldName.setText(null);
                fldPassword.setText(null);
                cmbUsetType.setSelectedItem(null);
            }
        });

        // Ekleme işlemi
        btnUserSubmit.addActionListener(e -> {
            if (Helper.isFieldEmpty(fldName) || Helper.isFieldEmpty(fldUserName) || Helper.isFieldEmpty(fldPassword) || cmbUsetType.getSelectedItem().equals("")) {
                Helper.showMessage("fill");
            }
            else {
                String name = fldName.getText();
                String username = fldUserName.getText();
                String password = fldPassword.getText();
                String userType = cmbUsetType.getSelectedItem().toString();

                if (User.addUser(name, username, password, userType)) {
                    Helper.showMessage("done");
                    loadUserModel();
                    fldUserName.setText(null);
                    fldName.setText(null);
                    fldPassword.setText(null);
                    cmbUsetType.setSelectedItem(null);
                    loadEducatorCombo();
                }
            }
        });

        // Silme işlemi
        btnDeleteUser.addActionListener(e -> {
            if (Helper.isFieldEmpty(fldUserID)) {
                Helper.showMessage("error");
            }
            else {
                if (Helper.confirm("sure")) {
                    int userID = Integer.parseInt(fldUserID.getText());
                    if (User.deleteUser(userID)) {
                        Helper.showMessage("done");
                        loadUserModel();
                        fldUserID.setText(null);
                        loadEducatorCombo();
                    }
                    else {
                        Helper.showMessage("error");
                    }
                }
            }
        });

        // Filtreleme işlemi
        btnFilter.addActionListener(e -> {
            String name = fldSearchNameSurname.getText();
            String username = fldsearchUser.getText();
            String userType = cmbSearchUserType.getSelectedItem().toString();

            String query = User.searchQuery(name, username, userType);
            ArrayList<User> searchingUser = User.searchUserList(query);
            loadUserModel(searchingUser);
        });

        patikaMenu = new JPopupMenu();
        JMenuItem updateMenu = new JMenuItem("Güncelle");
        JMenuItem deleteMenu = new JMenuItem("Sil");
        patikaMenu.add(updateMenu);
        patikaMenu.add(deleteMenu);

        updateMenu.addActionListener(e -> {
            int selectedID = Integer.parseInt(tblPatikaList.getValueAt(tblPatikaList.getSelectedRow(), 0).toString());
            UpdatePatikaGUI updatePatikaGUI = new UpdatePatikaGUI(Patika.getFetch(selectedID));
            updatePatikaGUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadPatikaModel();
                    loadPatikaCombo();
                }
            });
        });

        deleteMenu.addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int selectedID = Integer.parseInt(tblPatikaList.getValueAt(tblPatikaList.getSelectedRow(), 0).toString());
                if (Patika.deletePatika(selectedID)) {
                    Helper.showMessage("done");
                    loadPatikaModel();
                    loadPatikaCombo();
                }
                else {
                    Helper.showMessage("error");
                }
            }
        });

        mdlPatikaList = new DefaultTableModel();
        Object[] colPatikaList = {"ID", "Patika Adı"};
        mdlPatikaList.setColumnIdentifiers(colPatikaList);
        rowPatikaList = new Object[colPatikaList.length];
        loadPatikaModel();

        tblPatikaList.setModel(mdlPatikaList);
        tblPatikaList.setComponentPopupMenu(patikaMenu);
        tblPatikaList.getTableHeader().setReorderingAllowed(false);
        tblPatikaList.getColumnModel().getColumn(0).setMaxWidth(75);

        tblPatikaList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int selectedRow = tblPatikaList.rowAtPoint(point);
                tblPatikaList.setRowSelectionInterval(selectedRow, selectedRow);
            }
        });

        btnAddPatika.addActionListener(e -> {
            if (Helper.isFieldEmpty(fldPatikaName)) {
                Helper.showMessage("fill");
            }
            else {
                if (Patika.addPatika(fldPatikaName.getText().toString())) {
                    Helper.showMessage("done");
                    loadPatikaModel();
                    loadPatikaCombo();
                    fldPatikaName.setText(null);
                }
                else {
                    Helper.showMessage("error");
                }
            }
        });

        // ---------- CourseList ----------
        mdlCourseList = new DefaultTableModel();
        Object [] colCourseList = {"ID", "Ders Adi", "Programlama Dili", "Patika", "Eğitmen"};
        mdlCourseList.setColumnIdentifiers(colCourseList);
        rowCourseList = new Object[colCourseList.length];
        loadCourseList();
        tblCourseList.setModel(mdlCourseList);
        tblCourseList.getColumnModel().getColumn(0).setMaxWidth(75);
        tblCourseList.getTableHeader().setReorderingAllowed(false);
        loadPatikaCombo();
        loadEducatorCombo();
        // ---------- CourseList ----------

        btnLogout.addActionListener(e -> {
            dispose();
        });
    }

    // Tablo anlık güncelleme işlemi
    public void loadUserModel() {
        String query = "SELECT * FROM users";
        DefaultTableModel clearModel = (DefaultTableModel) tblUserList.getModel();
        clearModel.setRowCount(0);
            int i;
        for (User obj : User.getList(query)) {
            i = 0;
            rowUserList[i++] = obj.getId();
            rowUserList[i++] = obj.getName();
            rowUserList[i++] = obj.getUsername();
            rowUserList[i++] = obj.getPassword();
            rowUserList[i++] = obj.getUserType();

            mdlUserList.addRow(rowUserList);
        }
    }

    public void loadPatikaModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tblPatikaList.getModel();
        clearModel.setRowCount(0);

        int i;
        for (Patika obj : Patika.getListPatika()) {
            i = 0;
            rowPatikaList[i++] = obj.getId();
            rowPatikaList[i++] = obj.getName();

            mdlPatikaList.addRow(rowPatikaList);
        }
    }

    public void loadUserModel(ArrayList<User> arrayList) {
        DefaultTableModel clearModel = (DefaultTableModel) tblUserList.getModel();
        clearModel.setRowCount(0);

        int i = 0;
        for (User obj : arrayList) {
            rowUserList[i++] = obj.getId();
            rowUserList[i++] = obj.getName();
            rowUserList[i++] = obj.getUsername();
            rowUserList[i++] = obj.getPassword();
            rowUserList[i++] = obj.getUserType();

            mdlUserList.addRow(rowUserList);
        }
    }
    private void loadCourseList() {
        DefaultTableModel clearModel = (DefaultTableModel) tblCourseList.getModel();
        clearModel.setRowCount(0);
        int i = 0;
        for (Course obj : Course.getList()) {
            rowCourseList[i++] = obj.getId();
            rowCourseList[i++] = obj.getName();
            rowCourseList[i++] = obj.getLang();
            rowCourseList[i++] = obj.getPatika().getName();
            rowCourseList[i++] = obj.getEducator().getName();

            mdlCourseList.addRow(rowCourseList);

        }
    }

    public void loadPatikaCombo() {
        cmbPatikas.removeAllItems();
        for (Patika obj : Patika.getListPatika()) {
            cmbPatikas.addItem(new Item(obj.getId(), obj.getName()));
        }
    }

    public void loadEducatorCombo() {
        String query = "SELECT * FROM users WHERE \"userType\" = 'EDUCATOR'";
        cmbCourseEducator.removeAllItems();
        for (User obj : User.getList(query)) {
            cmbCourseEducator.addItem(new Item(obj.getId(), obj.getName()));

        }
        System.out.println(query);
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
