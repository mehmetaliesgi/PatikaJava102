package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Helper.Item;
import com.patikadev.Model.Course;
import com.patikadev.Model.Patika;
import com.patikadev.Model.User;

import javax.swing.*;

public class UpdateCourseGUI extends JFrame{
    private JTextField fldCourseName;
    private JComboBox cmbEducator;
    private JTextField fldProgramLang;
    private JComboBox cmbPatika;
    private JButton btnUpdate;
    private JPanel pnlwrapper;
    private Course course;

    public UpdateCourseGUI(Course course) {
        this.course = course;

        add(pnlwrapper);
        setSize(500, 350);
        setLocation(Helper.screenCenterLocation("x", getSize()), Helper.screenCenterLocation("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);
        String query = "SELECT * FROM users WHERE \"userType\" = 'EDUCATOR'";

        fldCourseName.setText(course.getName());
        fldProgramLang.setText(course.getLang());
        loadPatikaCombo();
        loadEducatorCombo(query);
        int i = 0;
        for (Patika obj : Patika.getListPatika()) {
            if(obj.getId() == course.getPatika().getId()) {
                cmbPatika.setSelectedIndex(i);
                i = 0;
                break;
            }
            i++;
        }

        for (User obj : User.getList(query)) {
            if (obj.getId() == course.getEducator().getId()) {
                cmbEducator.setSelectedIndex(i);
                break;
            }
            i++;
        }

        btnUpdate.addActionListener(e -> {
            if (Helper.isFieldEmpty(fldCourseName) || Helper.isFieldEmpty(fldProgramLang)) {
                Helper.showMessage("fill");
            }
            else {
                Item patikaItem = (Item) cmbPatika.getSelectedItem();
                Item educatorItem = (Item) cmbEducator.getSelectedItem();
                if (Course.updateCourse(course.getId(), fldCourseName.getText(), fldProgramLang.getText(), patikaItem.getKey(), educatorItem.getKey())) {
                    Helper.showMessage("done");
                }
                dispose();
            }
        });
    }
    public void loadPatikaCombo() {
        for (Patika obj : Patika.getListPatika()) {
            cmbPatika.addItem(new Item(obj.getId(), obj.getName()));
        }
    }

    public void loadEducatorCombo(String query) {
        for (User obj : User.getList(query)) {
            cmbEducator.addItem(new Item(obj.getId(), obj.getName()));

        }
    }
    public Object selectedPatikaCombo() {
        return Patika.getFetch(course.getPatika().getId());
    }
}
