package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Helper.Item;
import com.patikadev.Model.PanelTheme;

import javax.swing.*;

public class TemplateGUI extends JFrame{
    private JComboBox cmbTheme;
    private JButton btnUpdateTemplate;
    private JPanel pnlwrapper;

    public TemplateGUI() {
        add(pnlwrapper);
        setSize(250, 150);
        setLocation(Helper.screenCenterLocation("x", getSize()), Helper.screenCenterLocation("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        loadThemeCombo();

        btnUpdateTemplate.addActionListener(e -> {
            String cmb = cmbTheme.getSelectedItem().toString();
            PanelTheme.pickTheme(cmb);
            dispose();
        });
    }

    public void loadThemeCombo() {
        cmbTheme.removeAllItems();
        for (UIManager.LookAndFeelInfo obj : PanelTheme.listTheme()) {
            cmbTheme.addItem(obj.getName());
        }
    }
}
