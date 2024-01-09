package com.patikadev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Example extends JFrame {
    private JPanel wrapper;
    private JPanel wbottom;
    private JPanel wtop;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton btnLogin;

    public Example() {
        /* Bu şekilde kullanabileceğimiz temaları öğrenebiliriz */
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            System.out.println(info.getName() + " --> " + info.getClassName());
        }
        // Burada da tema seçimi yapabiliriz.
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        add(wrapper);
        setSize(600,350);
        setTitle("Uygulama Adi");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Frame'i ekranın ortasından başlatır
        // setLocationRelativeTo(null);
        // başka bir yöntem olan awt sınıfından Toolkit kullanmak
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2;
        setLocation(x, y);

        setVisible(true);
        setResizable(false);

        btnLogin.addActionListener(e -> {
            if (textField1.getText().isBlank() || passwordField1.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Tüm alanları doldurunuz.", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
