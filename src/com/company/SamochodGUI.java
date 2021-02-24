package com.company;

import samochod.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SamochodGUI extends Thread{
    public JFrame frame;
    private JPanel panel1;
    private JTextField samochodModelTx;
    private JTextField nrRejestracyjnyTx;
    private JTextField samochodWagaTx;
    private JTextField samochodPredkoscTx;
    private JButton wlaczSamochod;
    private JButton wylaczSamochod;
    public JComboBox lista;
    private JButton dodajNowy;
    private JButton usunButton;
    private JButton zwiekszBieg;
    private JButton zmniejszBieg;
    private JButton zwiekszObroty;
    private JButton zmniejszObroty;
    private JButton nacisnijSprzeglo;
    private JButton zwolnijSprzeglo;
    private JTextField skrzyniaNazwaTx;
    private JTextField skrzyniaCenaTx;
    private JTextField skrzyniaWagaTx;
    private JTextField skrzyniaBiegTx;
    private JTextField silnikNazwaTx;
    private JTextField silnikCenaTx;
    private JTextField silnikWagaTx;
    private JTextField silnikObrotyTx;
    private JTextField sprzegloNazwaTx;
    private JTextField sprzegloCenaTx;
    private JTextField sprzegloWagaTx;
    private JTextField sprzegloStanTx;
    private JLabel ikonaSamochod;
    private JPanel mapa;
    private JTextField stanWlTx;
    private JLabel stanWl;
    private Samochod samochod;
 //   ImageIcon ikona = new ImageIcon("samochod/car.png");


//
//    Silnik silnik = new Silnik(100, 50, "silnikA", 80, 1000);
//    Sprzeglo sprzeglo = new Sprzeglo(true,"sprzegloA", 10, 10);
//    SkrzyniaBiegow skrzyniaBiegow = new SkrzyniaBiegow(2,6,10, sprzeglo,"skrzyniaBiegowA", 20, 500);
//    Pozycja pozycjaA = new Pozycja(0,0);
//    Samochod samochod = new Samochod(true, "1", "Kia", 200, silnik, skrzyniaBiegow, pozycjaA);

    public void zmienBieg(){
        if (samochod.silnik.getObroty() > 400){
            System.out.println("zwieksz bieg!");
        }
        if (samochod.silnik.getObroty() < 200)
            System.out.println("zmniejsz bieg!");
    }

    public SamochodGUI() {

        lista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                samochod = (Samochod)lista.getSelectedItem();
            }

        });
        //samochod
        wlaczSamochod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!samochod.getsStanWlaczenia())
                    samochod.wlacz();
                refresh();

            }
        });
        wylaczSamochod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (samochod.getsStanWlaczenia())
                    samochod.wylacz();
                samochod.silnik.setObroty(0);
                refresh();

            }
        });
        //skrzynia
        zwiekszBieg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (samochod.skrzyniaBiegow.getAktBieg() < samochod.skrzyniaBiegow.getIloscbiegow() && samochod.skrzyniaBiegow.sprzeglo.getStanSprzegla() && samochod.silnik.getObroty() > 400) {
                    samochod.skrzyniaBiegow.zwiekszBieg();
                    double obrotyTeraz = samochod.silnik.getObroty();
                    samochod.silnik.setObroty(obrotyTeraz - 200);
                }
                refresh();
            }
        });
        zmniejszBieg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (samochod.skrzyniaBiegow.getAktBieg() > 0  && samochod.skrzyniaBiegow.sprzeglo.getStanSprzegla() && samochod.silnik.getObroty() < 200) {
                    samochod.skrzyniaBiegow.zmniejszzBieg();
                    double obrotyTeraz = samochod.silnik.getObroty();
                    samochod.silnik.setObroty(obrotyTeraz + 200);
                }
                refresh();
            }
        });
        //silnik
        zwiekszObroty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                refresh();
                if (samochod.silnik.getObroty() < 600 && !samochod.skrzyniaBiegow.sprzeglo.getStanSprzegla()) {
                    samochod.silnik.zwiekszObroty();
                }
            }
        });
        zmniejszObroty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                refresh();
                if (samochod.silnik.getObroty() > 0 && !samochod.skrzyniaBiegow.sprzeglo.getStanSprzegla()){
                    samochod.silnik.zmniejszzObroty();
                }
            }
        });
        //sprzeglo
        nacisnijSprzeglo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!samochod.skrzyniaBiegow.sprzeglo.getStanSprzegla() || samochod.getsStanWlaczenia())
                    samochod.skrzyniaBiegow.sprzeglo.wcisnij();
                refresh();
            }
        });
        zwolnijSprzeglo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (samochod.skrzyniaBiegow.sprzeglo.getStanSprzegla())
                    samochod.skrzyniaBiegow.sprzeglo.zwolnij();
                refresh();
            }
        });
        dodajNowy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new DodajNowyGUI(lista);
                refresh();
            }
        });
        usunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                samochod.interrupt();
                samochod.stop();
                lista.removeItem(samochod);

            }
        });
        //mapa
        mapa.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (samochod != null) {
                    if (samochod.getsStanWlaczenia())
                        samochod.jedzDoCel(new Pozycja(e.getX(), e.getY()));
                }
                else
                    System.out.println("dodaj najpierw samochod");
            }
        });




        start();


    }
    private void refresh(){
        if (samochod != null) {
            stanWlTx.setText(Boolean.toString(samochod.getsStanWlaczenia()));
            nrRejestracyjnyTx.setText(samochod.getNrRejetr());
            samochodModelTx.setText(samochod.getModel());
            samochodPredkoscTx.setText(Double.toString(samochod.getAktPredkosc()));
            samochodWagaTx.setText(Double.toString(samochod.getWaga()));

            skrzyniaNazwaTx.setText(samochod.skrzyniaBiegow.getNazwa());
            skrzyniaWagaTx.setText(Double.toString(samochod.skrzyniaBiegow.getWaga()));
            skrzyniaBiegTx.setText(Integer.toString(samochod.skrzyniaBiegow.getAktBieg()));
            skrzyniaCenaTx.setText(Double.toString(samochod.skrzyniaBiegow.getCena()));

            silnikNazwaTx.setText(samochod.silnik.getNazwa());
            silnikCenaTx.setText(Double.toString(samochod.silnik.getCena()));
            silnikWagaTx.setText(Double.toString(samochod.silnik.getWaga()));
            silnikObrotyTx.setText(Double.toString(samochod.silnik.getObroty()));

            sprzegloNazwaTx.setText(samochod.skrzyniaBiegow.sprzeglo.getNazwa());
            sprzegloCenaTx.setText(Double.toString(samochod.skrzyniaBiegow.sprzeglo.getCena()));
            sprzegloWagaTx.setText(Double.toString(samochod.skrzyniaBiegow.sprzeglo.getWaga()));
            sprzegloStanTx.setText(Boolean.toString(samochod.skrzyniaBiegow.sprzeglo.getStanSprzegla()));
            ikonaSamochod.setVisible(true);
            ikonaSamochod.setEnabled(true);
            ikonaSamochod.setLocation((int) samochod.getAktPozycja().getX(), (int) samochod.getAktPozycja().getY());

            //blokada przyciskow
            wlaczSamochod.setEnabled(true);
            wylaczSamochod.setEnabled(true);
            zwiekszBieg.setEnabled(true);
            zmniejszBieg.setEnabled(true);
            zwiekszObroty.setEnabled(true);
            zmniejszObroty.setEnabled(true);
            nacisnijSprzeglo.setEnabled(true);
            zwolnijSprzeglo.setEnabled(true);
            usunButton.setEnabled(true);
            if (samochod.getAktPredkosc() != 0)
                zmienBieg();

        }
        else{
            nrRejestracyjnyTx.setText(null);
            samochodModelTx.setText(null);
            samochodPredkoscTx.setText(null);
            samochodWagaTx.setText(null);

            skrzyniaNazwaTx.setText(null);
            skrzyniaWagaTx.setText(null);
            skrzyniaBiegTx.setText(null);
            skrzyniaCenaTx.setText(null);

            silnikNazwaTx.setText(null);
            silnikCenaTx.setText(null);
            silnikWagaTx.setText(null);
            silnikObrotyTx.setText(null);

            sprzegloNazwaTx.setText(null);
            sprzegloCenaTx.setText(null);
            sprzegloWagaTx.setText(null);
            sprzegloStanTx.setText(null);
            //ikonaSamochod.setIcon(null);
            ikonaSamochod.setVisible(false);
            stanWlTx.setText(null);

            wlaczSamochod.setEnabled(false);
            wylaczSamochod.setEnabled(false);
            zwiekszBieg.setEnabled(false);
            zmniejszBieg.setEnabled(false);
            zwiekszObroty.setEnabled(false);
            zmniejszObroty.setEnabled(false);
            nacisnijSprzeglo.setEnabled(false);
            zwolnijSprzeglo.setEnabled(false);
            usunButton.setEnabled(false);

        }
    }

    public void run(){
        while (true){
            refresh();
            try {
                Thread.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("SamochodGUI");
        frame.setContentPane(new SamochodGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

}
