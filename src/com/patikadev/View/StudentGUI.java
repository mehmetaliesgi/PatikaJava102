package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;

import javax.swing.*;

public class StudentGUI extends JFrame {

    private JPanel wrapper;
    public StudentGUI() {
        add(wrapper);
        setSize(400, 400);
        setLocation(Helper.screenCenterLocation("x", getSize()), Helper.screenCenterLocation("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
    }
}
