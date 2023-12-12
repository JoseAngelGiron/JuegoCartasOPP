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

        public static String selectNamePlayer(int nPlayer){
                int count = nPlayer+1;
                return IO.readString("Inserte del jugador "+count);
        }

        public static int selectOption(){
                try {
                        Thread.sleep(1000);
                        System.out.println("********** ¿Que desea hacer a continuación? **********");
                        Thread.sleep(1000);
                        System.out.println("1. Pasar");
                        Thread.sleep(320);
                        System.out.println("2. Plantarse");
                        Thread.sleep(320);
                        System.out.println("3. Ver tu mano");
                        Thread.sleep(320);
                        System.out.println("4. Ver el estado de la partida");
                        Thread.sleep(320);
                        System.out.println("5. Pedir otra carta");
                        Thread.sleep(1000);

                }catch (InterruptedException e) {

                }
                return IO.readInt2("Seleccione que quiere hacer a continuación: ", 1, 5);


        }
        public static String selectAnotherRound(){
                try{
                        Thread.sleep(320);
                        return IO.readOption("¿Desea jugar otra ronda? pulse 's' para si y 'n' para no");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


        }
        public static String printResults(){
                try {
                        Thread.sleep(320);
                        return IO.readOption("¿Desea imprimir el resultado de los ganadores? pulse 's' para si y 'n' para no");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

        }
}
