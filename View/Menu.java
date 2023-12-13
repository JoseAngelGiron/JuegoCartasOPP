package View;

public class Menu {
        /**
         * Función que muestra el menu principal
         * @return devuelve la opción que se le introduce por teclado, como consecuencia de la llamada que hace a la función readInt
         */
        public static int mainMenu() {
                String casino = ".######.....###.....######..####.##....##...#######.\n" +
                                ".##....##...##.##...##....##..##..###...##.##.....##\n" +
                                ".##........##...##..##........##..####..##.##.....##\n" +
                                ".##.......##.....##..######...##..##.##.##.##.....##\n" +
                                ".##.......#########.......##..##..##..####.##.....##\n" +
                                ".##....##.##.....##.##....##..##..##...###.##.....##\n" +
                                "..######..##.....##..######..####.##....##..#######.";

                System.out.println(casino);
                System.out.println();
                System.out.println();
                System.out.println("********** Menú **********");
                System.out.println("1. Iniciar Juego de Blackjack");
                System.out.println("2. Ver las reglas");
                System.out.println("3. Salir \n");


                System.out.println("Próximamente, mas juegos......\n");

                return IO.readInt("Elija una opción");


        }

        /**
         * Función que imprime por pantalla las reglas del juego
         */
        public static void rules(){
                System.out.println("---------------------------------------------------------------------------------------------------------------------");
                System.out.println("---------------------------------------------------------------------------------------------------------------------");
                System.out.println("|                                                    Reglas                                                         |");
                System.out.println("---------------------------------------------------------------------------------------------------------------------");
                System.out.println("---------------------------------------------------------------------------------------------------------------------");
                System.out.println("| 1. El objetivo es que de conseguir 21 sin pasarte, si te pasas pierdes. En su defecto, sacar la puntuación mas alta|");
                System.out.println("| 2. El As vale 1, pero si tienes menos de 11, el AS vale 11. La J, Q y la K valen 10                                |");
                System.out.println("| 3. Si tienes 2 cartas y la suma de ambas son 21, tienes un Blackjack, deberías plantarte para intentar ganar       |");
                System.out.println("| 4. La IA siempre intentara superarte, o empatarte, incluso si ello conlleva perder                                 |");
                System.out.println("|                                                                                                                    |");
                System.out.println("---------------------------------------------------------------------------------------------------------------------");
                System.out.println("---------------------------------------------------------------------------------------------------------------------");

        }

        /**
         * Función que permite seleccionar el número de jugadores
         * @return un número entre 1 y 4, como consecuencia de la llamada a la función readInt2
         */
        public static int selectNPlayers(){

                return IO.readInt2("Inserte un número de jugadores, mínimo 1 y máximo 4", 1,4);
        }

        /**
         * Función que sirve para obtener el nombre del jugador
         * @param nPlayer recibe el número del jugador
         * @return el nombre del jugador
         */
        public static String selectNamePlayer(int nPlayer){
                int count = nPlayer+1;
                return IO.readString("Inserte el nombre del jugador "+count);
        }

        /**
         * Función para mostrar el submenu del turno del jugador.
         *
         * @return la opción introducida, con el llamado a la función readInt2
         */
        public static int selectOption(){
                try {
                        Thread.sleep(1000);
                        System.out.println("********** ¿Que desea hacer a continuación? **********");
                        Thread.sleep(1000);
                        System.out.println("1. Terminar turno");
                        Thread.sleep(320);
                        System.out.println("2. Ver tu mano");
                        Thread.sleep(320);
                        System.out.println("3. Ver el estado de la partida");
                        Thread.sleep(320);
                        System.out.println("4. Pedir otra carta");
                }catch (InterruptedException e) {

                }
                return IO.readInt2("Seleccione que quiere hacer a continuación: ", 1, 4);


        }

        /**
         * Función que sirve para mostrar un mensaje y devolver una opción
         * @return una opción concreta, como consecuencia del llamado a la función readOption
         */
        public static String selectAnotherRound(){
                return IO.readOption("¿Desea jugar otra ronda? pulse 's' para si y 'n' para no");



        }

        /**
         * Función que sirve para mostrar un mensaje y devolver una opción
         * @return un carácter texto en concreto, como consecuencia del llamado a la función readOption
         */
        public static String printResults(){
                return IO.readOption("¿Desea imprimir el resultado de los ganadores? pulse 's' para si y 'n' para no");
        }
}
