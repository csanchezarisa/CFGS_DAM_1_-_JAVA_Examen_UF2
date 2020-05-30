import javax.swing.text.StringContent;

public class Exercici1 {

    /* El codi no funcionarà ja que el mètode main, el qual es estàtic, està cridant a un
    * mètode dinàmic, sense haver inicialitzat cap objecte de la classe.
    * Per solucionar-ho, o bé s'inicialitza un objecte de la classe exercici1 i s'executa
    * el mètode amb aquest objecte, o s'executa tot dins del main, o es crea el mètode
    * principal com a un mètode static */
/*
    // Primera opció, crear un objecte de la classe
    public static void main(String[] args) {
        Exercici1 launcher = new Exercici1();
        launcher.principal();
    }

    public void principal() {
        System.out.println("Hola");
    }

    // Segona opció, definir el mètode com static
    public static void principal() {
        System.out.println("Hola");
    }

    // Tercera opció, traslladar l'execució al main
    public static void main(String[] args) {
        System.out.println("Hola");
    }

 */
}
