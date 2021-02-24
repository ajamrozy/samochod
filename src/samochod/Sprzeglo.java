package samochod;

public class Sprzeglo extends Komponent {
    public boolean getStanSprzegla() {
        return stanSprzegla;
    }

    private boolean stanSprzegla;
    public void wcisnij(){ this.stanSprzegla = true;}
    public void zwolnij(){this.stanSprzegla = false;}


    public Sprzeglo(boolean stanSprzegla, String nazwa, double waga, double cena){
        super(nazwa, waga, cena);
        this.stanSprzegla = stanSprzegla;

    }
}
