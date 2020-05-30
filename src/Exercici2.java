import java.util.Scanner;

public class Exercici2 {


    Scanner e = new Scanner(System.in);
    char[][] lletres = new char[5][4];
    int numParaules = 0;


    public static void main(String[] args) {
        Exercici2 launcher = new Exercici2();
        launcher.principal();
    }


    public void principal() {
        int contLletres = 0;
        netejarTaula();

        while (numParaules < 5) {
            System.out.println("Entra la paraula de 4 lletres " + numParaules);
            introduirLletres(contLletres);

            System.out.println("La paraula introduida és:");
            mostrarParaula(numParaules);
            numParaules++;
        }

        System.out.println("Les paraules introduides són:");

        for (int contPar = 0; contPar < 5; contPar++) {
            System.out.println("La paraula " + contPar + " és: ");
            mostrarParaula(contPar);
        }

        netejarTaula();
    }


    public void netejarTaula() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++)
                lletres[i][j] = ' ';
        }
    }


    public void introduirLletres(int contLletres) {
        contLletres = 0;

        while (contLletres < 4) {
            System.out.println("Entra una lletra:");
            lletres[numParaules][contLletres] = e.nextLine().charAt(0);
            contLletres++;
        }
    }


    public void mostrarParaula(int posY) {
        for (int i = 0; i < 4; i++)
            System.out.print(lletres[posY][i]);
        System.out.println();
    }

}
