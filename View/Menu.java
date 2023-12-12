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

        public static int selectOption(){
                try {
                        Thread.sleep(2500);
                        System.out.println("********** ¿Que desea hacer a continuación? **********");
                        System.out.println("1. Pasar");
                        System.out.println("2. Plantarse");
                        System.out.println("3. Ver tu mano");
                        System.out.println("4. Ver el estado de la partida");
                        System.out.println("5. Pedir otra carta");
                        return IO.readInt2("Seleccione que quiere hacer a continuación: ", 1, 5);
                }catch (InterruptedException e) {
                        throw new RuntimeException(e);
                }
        }
        public static String selectAnotherRound(){
                return IO.readOption("¿Desea jugar otra ronda?");

        }
        public static String printResults(){
                return IO.readOption("¿Desea imprimir el resultado de los ganadores?");
        }
}
