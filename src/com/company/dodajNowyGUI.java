package com.company;

import javax.swing.*;

public class dodajNowyGUI {
    private JPanel dodajNowyPanel;
    private JTextField nrRejestrNowyTx;
    private JTextField modelNowyTx;
    private JTextField markaNowyTx;
    private JCheckBox skrzyniaBiegNowy;
    private JCheckBox skrzynaBieg2Nowy;
    private JCheckBox silnik1Nowy;
    private JCheckBox silnik2Nowy;
    private JTextField predkoscMaxNoyTx;
    private JButton dodajNowyB;
    private JButton anulujNowyB;

    public static void main(String[] args) {
        JFrame frame = new JFrame("dodajNowyGUI");
        frame.setContentPane(new dodajNowyGUI().dodajNowyPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
