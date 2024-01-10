package com.patikadev.Helper;

import javax.swing.*;
import java.awt.*;

public class Helper {

    public static int screenCenterLocation(String axis, Dimension size) {
        int point;
        switch (axis) {
            case "x":
                point = (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
                break;
            case "y":
                point = (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
                break;
            default:
                point = 0;
        }
        return point;
    }

    public static boolean isFieldEmpty(JTextField textField) {

        return textField.getText().trim().isEmpty();
    }

    public static void showMessage(String str) {
        optionPageTR();
        String mesaj;
        String title;

        switch (str) {
            case "fill":
                mesaj = "Lütfen tüm alanları doldurunuz!";
                title = "Hata!";
                break;
            case "done":
                mesaj = "İşlemi başarılı!";
                title = "Başarılı";
                break;
            case "error":
                mesaj = "Bir hata oluştu!";
                title = "Hata!";
                break;
            default:
                mesaj = str;
                title = "Mesaj";
        }
        if (str.equals("error")) {
            JOptionPane.showMessageDialog(null, mesaj, title, JOptionPane.ERROR_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, mesaj, title, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void optionPageTR() {
        UIManager.put("OptionPane.okButtonText", "Tamam");
    }
}
