package com.company;

import samochod.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DodajNowyGUI extends Thread {
    public JFrame frame;
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

    Sprzeglo sprzeglo = new Sprzeglo(true, "sprzeglo", 10, 20);

    public Silnik silnikBenzynowy(){
        return new Silnik(80, 0, "silnik benzynowy", 50, 200);
    }
    public Silnik silnikDiesla(){
        return new Silnik(70, 0, "silnik diesla", 60, 100);
    }
    public Silnik ktorySilniki(){
        if (silnik1Nowy.isSelected()){
            return silnikDiesla();
        }
        return silnikBenzynowy();
    }
    public SkrzyniaBiegow piecBiegowMan(){
        return new SkrzyniaBiegow(1, 5, 1, sprzeglo, "5 biegow manualna", 30, 100);
    }
    public SkrzyniaBiegow szescBiegowMan(){
        return new SkrzyniaBiegow(1, 6, 1, sprzeglo, "6 biegow manualna", 30, 150);
    }
    public SkrzyniaBiegow ktoraSkryznia(){
        if (skrzynaBieg2Nowy.isSelected())
            return szescBiegowMan();
        return piecBiegowMan();
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
          double d = Double.parseDouble(strNum);

        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


    DodajNowyGUI(JComboBox lista){
        frame = new JFrame("dodajNowyGUI");
        frame.add(dodajNowyPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        dodajNowyB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (nrRejestrNowyTx != null && modelNowyTx != null && markaNowyTx != null && ((skrzyniaBiegNowy.isSelected() && !skrzynaBieg2Nowy.isSelected()) || (!skrzyniaBiegNowy.isSelected() && skrzynaBieg2Nowy.isSelected())) && ((silnik1Nowy.isSelected() && !silnik2Nowy.isSelected()) || (!silnik1Nowy.isSelected() && silnik2Nowy.isSelected())) && predkoscMaxNoyTx != null && isNumeric(predkoscMaxNoyTx.getText())) {
                    Silnik silnikWybrany = ktorySilniki();
                    SkrzyniaBiegow skrzyniaWybrana = ktoraSkryznia();

                    Pozycja poczatkowa = new Pozycja(0, 0);
                    Samochod nowySamochod = new Samochod(false, nrRejestrNowyTx.getText(), modelNowyTx.getText(), Double.parseDouble(predkoscMaxNoyTx.getText()), silnikWybrany, skrzyniaWybrana, poczatkowa);
                    lista.addItem(nowySamochod);
                    frame.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "wprowadz poprawne dane - wypelnij wszystkie pola, predkosc musi byc liczba", "dodaj nowy", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        anulujNowyB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
            }
        });
        start();
    }

}
