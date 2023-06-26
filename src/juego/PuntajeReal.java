
package juego;


public class PuntajeReal {
      private static int puntajeTotal = 0;

    public static int getPuntajeTotal() {
        return puntajeTotal;
    }

    public static void sumarPuntaje(int puntaje) {
        puntajeTotal += puntaje;
    }
    
}
