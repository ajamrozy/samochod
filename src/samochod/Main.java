package samochod;

public class Main {
    public static void main(String[] args){
        Silnik silnikA = new Silnik(100, 50, "silnikA", 80, 1000);
        Sprzeglo sprzegloA = new Sprzeglo(true,"sprzegloA", 10, 10);
        SkrzyniaBiegow skrzyniaBiegowA = new SkrzyniaBiegow(2,6,10, sprzegloA,"skrzyniaBiegowA", 20, 500);
        Pozycja pozycjaA = new Pozycja(10,15);
        Samochod samochod1 = new Samochod(true, "1", "Kia", 200, silnikA, skrzyniaBiegowA, pozycjaA);

        Silnik silnikB = new Silnik(90, 50, "silnikB", 70, 800);
        Sprzeglo sprzegloB = new Sprzeglo(false,"sprzegloB", 15, 40);
        SkrzyniaBiegow skrzyniaBiegowB = new SkrzyniaBiegow(3,5,20, sprzegloA,"skrzyniaBiegowB", 30, 550);
        Pozycja pozycjaB = new Pozycja(7,90);
        Samochod samochod2 = new Samochod(true, "2", "Honda", 250, silnikB, skrzyniaBiegowB, pozycjaB);

        //(new Thread(new Samochod(false, 1, "Subaru", 200, silnikA, skrzyniaBiegowA, pozycjaA))).start();
        samochod1.jedzDoCel(new Pozycja(3000,1500));

    }
}
