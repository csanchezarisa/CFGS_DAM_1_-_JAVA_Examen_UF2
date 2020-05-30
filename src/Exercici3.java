import java.util.Scanner;

public class Exercici3 {

    public static void main(String[] args) {
        char[][] sopa = new char[5][5];
        Scanner e = new Scanner(System.in);

        OmplenaSopaLletres();
        char quinaLletra = e.next().charAt(0);

        int nombreAparicions = comptarAparicionsLletra(quinaLletra, sopa);
        System.out.println("El nombre d'aparicions és de: " + nombreAparicions);
    }

    public static void OmplenaSopaLletres() {
        // Codi per omplenar la sopa de lletres...
    }

    public static int comptarAparicionsLletra(char lletra, char[][] sopa) {
        int aparicions = 0;

        for (int y = 0; y < sopa.length; y++) {
            for (int x = 0; x < sopa[y].length; x++) {
                if (sopa[y][x] == lletra)
                    aparicions++;
            }
        }

        return aparicions;
    }

}
