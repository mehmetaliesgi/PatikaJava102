package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Patika;

import javax.swing.*;

public class UpdatePatikaGUI extends JFrame{
    private JPanel pnlwrapper;
    private JLabel lblPatikaName;
    private JTextField fldPatikaName;
    private JButton btnUpdatePatika;
    private Patika patika;

    public UpdatePatikaGUI(Patika patika) {
        this.patika = patika;

        add(pnlwrapper);
        setSize(300, 150);
        setLocation(Helper.screenCenterLocation("x", getSize()), Helper.screenCenterLocation("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        fldPatikaName.setText(patika.getName());
        btnUpdatePatika.addActionListener(e -> {
            if (Helper.isFieldEmpty(fldPatikaName)) {
                Helper.showMessage("fill");
            }
            else {
                if (Patika.updatePatika(patika.getId(), fldPatikaName.getText())) {
                    Helper.showMessage("done");
                }
                dispose();
            }
        });
    }
}
