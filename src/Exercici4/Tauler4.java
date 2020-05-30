package Exercici4;

import java.util.Scanner;

public class Tauler4 {

    public Scanner teclat = new Scanner(System.in);
    private Vaixells4[] vaixells = new Vaixells4[5];
    private char[][] tauler = new char[5][5];

    public static void main(String[] args) throws InterruptedException {
        Tauler4 launcher = new Tauler4();
        launcher.launch();
    }

    public void launch() throws InterruptedException {
        char opcioEscollida = ' ';

        do {

            netejaPantalla();
            mostraMenuPrincipal();
            opcioEscollida = teclat.next().charAt(0);

            switch (opcioEscollida) {
                case '1':
                    jocPrincipal();
                    break;

                case '2':
                    break;

                default:
                    System.out.println("Introdueix una opció vàlida!");
            }

        }
        while (opcioEscollida != '2');

    }

    // Mostra el menú principal del programa
    public void mostraMenuPrincipal() {
        System.out.println("+ - - - - - - - - - +");
        System.out.println("| JOC DELS VAIXELLS |");
        System.out.println("+ - - - - - - - - - +");
        System.out.println("| 1. Jugar          |");
        System.out.println("| 2. Sortir         |");
        System.out.println("+ - - - - - - - - - +");
    }


    // Mètode que conté el joc principal
    public void jocPrincipal() throws InterruptedException {
        netejarVaixells();
        inicialitzarVaixells();
        inicialitzarTauler();
        int numeroDeTirs = 0;

        do {

            netejaPantalla();
            mostrarTauler();
            System.out.println("Queden " + Vaixells4.getNombreVaixells() + " vaixells");
            System.out.println("Fila:");
            int fila = teclat.nextInt();
            System.out.println("Columna:");
            int columna = teclat.nextInt();

            if (fila >= 0 && fila <= 4 && columna >= 0 && columna <= 4) {
                int indexVaixellTocat = vaixellTocat(fila, columna);

                if (indexVaixellTocat >= 0) {
                    vaixells[indexVaixellTocat].tocat();
                    tauler[fila][columna] = Character.forDigit(vaixells[indexVaixellTocat].getVides(), 10);
                }
                else {
                    System.out.println("Aigua...");
                    tauler[fila][columna] = '~';
                }
            }
            else {
                System.out.println("Introdueix unes coordenades vàlides!");
                stop();
            }

            numeroDeTirs++;
        }
        while (Vaixells4.getNombreVaixells() > 0);
        System.out.println("Has necessitat " + numeroDeTirs + " tirs per enfonsar tots els vaixells!");
        stop();
    }

    // Deixa l'array de vaixells buit
    public void netejarVaixells() {
        for (int i = 0; i < 5 ; i++) {
            vaixells[i] = null;
            Vaixells4.inicialitzarNombreVaixells();
        }
    }

    // Omple l'array de vaixells
    public void inicialitzarVaixells() {
        for (int i = 0; i < 5; i++) {
            int y = (int) (Math.random() * (0 - 4) + 4);
            int x = (int) (Math.random() * (0 - 4) + 4);
            boolean posicioLliure = true;

            for (int j = 0; j < 5; j++) {
                if (vaixells[j] != null && vaixells[j].getPosColumna() == x && vaixells[j].getPosFila() == y) {
                    posicioLliure = false;
                    j = 5;
                }
            }

            if (posicioLliure) {
                int vides = (int) (Math.random() * (1 - 3) + 3);
                Vaixells4 vaixell = new Vaixells4(y, x, vides);
                vaixells[i] = vaixell;
            }
            else
                i--;
        }
    }

    // Inicialitza el tauler amb espais
    public void inicialitzarTauler() {
        for (int y = 0; y < tauler.length; y++) {
            for (int x = 0; x < tauler[0].length; x++)
                tauler[y][x] = ' ';
        }
    }

    // Mostra el tauler per l'usuari
    public void mostrarTauler() {
        System.out.println("  0  1  2  3  4");
        for (int y = 0; y < tauler.length; y++) {
            for (int x = 0; x < tauler[0].length; x++) {
                if (x == 0)
                    System.out.print(y + " " + tauler[y][x]);
                else
                    System.out.print("  " + tauler[y][x]);
            }
            System.out.println();
        }
    }

    // Cerca en la taula de vaixells quin és l'index de la posició del vaixell tocat, si no el troba retorna -1
    public int vaixellTocat(int fila, int columna) {
        int index = -1;

        for (int i = 0; i < 5; i++) {
            if (vaixells[i].getPosFila() == fila && vaixells[i].getPosColumna() == columna) {
                index = i;
                i = 5;
            }
        }

        return index;
    }


    // Neteja la pantalla
    public void netejaPantalla() {
        for (int i = 0; i <= 50; i++)
            System.out.println();
    }

    public void stop() throws InterruptedException {
        Thread.sleep(5000);
    }

}
