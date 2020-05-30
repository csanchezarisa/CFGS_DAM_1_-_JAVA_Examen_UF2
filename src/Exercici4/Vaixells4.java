package Exercici4;

public class Vaixells4 {

    private static int nombreVaixells = 0;
    private int posFila;
    private int posColumna;
    private int vides;

    public Vaixells4(int posFila, int posColumna, int vides) {
        this.posFila = posFila;
        this.posColumna = posColumna;
        this.vides = vides;
        nombreVaixells++;
    }

    // .: GETTERS :.

    public static int getNombreVaixells() {
        return nombreVaixells;
    }

    public int getPosFila() {
        return this.posFila;
    }

    public int getPosColumna() {
        return this.posColumna;
    }

    public int getVides() {
        return this.vides;
    }

    // .: SETTERS :.

    public static void inicialitzarNombreVaixells() {
        nombreVaixells = 0;
    }

    // S'encarrega de restar les vides i fer les operacions quan un vaixell és tocat
    public void tocat() {
        if (this.vides > 0) {
            this.vides--;

            if (this.vides == 0)
                nombreVaixells--;
        }
    }

}
