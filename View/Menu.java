package View;

public class Menu {
        public static int mainMenu() {
                System.out.println("********** Menú **********");
                System.out.println("1. Iniciar Juego de Blackjack");
                System.out.println("2. Salir");
                System.out.print("Selecciona una opción: ");
                return IO.readInt("Elija una opción");
        }

        public static int selectNPlayers(){

                return IO.readInt2("Inserte un número de jugadores, mínimo 1 y máximo 4", 1,4);
        }

        public static String selectNamePlayer(){

                return IO.readString("Inserte el nombre del siguiente jugador ");
        }
}
