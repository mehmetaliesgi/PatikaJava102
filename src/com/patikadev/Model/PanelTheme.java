package com.patikadev.Model;

import javax.swing.*;
import java.util.ArrayList;

public class PanelTheme {
    public static void pickTheme(String themeName) {
        // Burada da tema seçimi yapabiliriz.
        try {
            switch (themeName) {
                case "Nimbus":
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                    break;
                case "Metal":
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                    break;
                case "CDE/Motif":
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                    break;
                case "Windows":
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    break;
                case "Windows Classic":
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                    break;
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException |
                 UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<UIManager.LookAndFeelInfo> listTheme() {
        ArrayList<UIManager.LookAndFeelInfo> themes = new ArrayList<>();

        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            themes.add(info);
        }
        return themes;
    }
}

