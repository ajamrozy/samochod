package samochod;

public class Samochod extends Thread{



    private boolean stanWlaczenia;
    private String model;
    private double waga;
    public Silnik silnik;
    public SkrzyniaBiegow skrzyniaBiegow;
    private double predkoscMax;
    private String nrRejetr;
    private double aktualnaPredkosc;
    private Pozycja aktualnaPozycja;
    private Pozycja cel;
    double dlugoscKola = 0.2;

    public void wlacz(){this.stanWlaczenia = true;}
    public void wylacz(){this.stanWlaczenia = false;}
    public void jedzDoCel(Pozycja cel){
        this.cel = cel;
    }
    public double getWaga(){return waga;}
    public String getNrRejetr(){return nrRejetr;}
    public double getAktPredkosc(){return aktualnaPredkosc;}
    public Pozycja getAktPozycja(){return aktualnaPozycja;}

    public void setPredkoscMax(double predkoscMax) {
        this.predkoscMax = predkoscMax;
    }

    public void setNrRejetr(String nrRejetr) {
        this.nrRejetr = nrRejetr;
    }

    public void setAktualnaPredkosc(double aktualnaPredkosc) {
        this.aktualnaPredkosc = aktualnaPredkosc;
    }

    public String getModel() {return model;}
    public boolean getsStanWlaczenia() {
        return stanWlaczenia;
    }
    public void setCel(Pozycja cel) {
        this.cel = cel;
    }
    public void setWaga(){
        this.waga = skrzyniaBiegow.getWaga() + skrzyniaBiegow.sprzeglo.getWaga() + silnik.getWaga() + 100;
    }

    public void run() {
        while(true){
            if (this.getAktPozycja().getX() != cel.getX() || this.getAktPozycja().getY() != cel.getY()){
                cel.setNazweSamochodu(nrRejetr);
//                System.out.println(nrRejetr);
//                System.out.println(cel.getNazwaSamochodu());
                if (aktualnaPredkosc + (silnik.getObroty() * skrzyniaBiegow.getAktBieg() * dlugoscKola) < predkoscMax) {
                    this.aktualnaPredkosc = silnik.getObroty() * skrzyniaBiegow.getAktBieg() * dlugoscKola;
                    aktualnaPozycja.przeniesc(cel, 100, aktualnaPredkosc);
                    if (this.getAktPozycja().getX() == cel.getX() && this.getAktPozycja().getY() == cel.getY())
                        setAktualnaPredkosc(0);
                }
                else {
                    aktualnaPredkosc = predkoscMax;
                    aktualnaPozycja.przeniesc(cel, 100, aktualnaPredkosc);
                    if (this.getAktPozycja().getX() == cel.getX() && this.getAktPozycja().getY() == cel.getY())
                        setAktualnaPredkosc(0);
                }
                System.out.println(aktualnaPozycja);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return nrRejetr ;

    }

    public Samochod(boolean stanWlaczenia, String nrRejetr, String model, double predkoscMax, Silnik silnik, SkrzyniaBiegow skrzyniaBiegow, Pozycja aktualnaPozycja){
        this.stanWlaczenia = stanWlaczenia;
        this.nrRejetr = nrRejetr;
        this.model = model;
        this.predkoscMax = predkoscMax;
        this.silnik = silnik;
        this.skrzyniaBiegow = skrzyniaBiegow;
        this.aktualnaPozycja = aktualnaPozycja;
        this.aktualnaPredkosc = 0;
        this.cel = aktualnaPozycja;
        setWaga();
        start();
    }
}
