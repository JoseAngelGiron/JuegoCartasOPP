package View;

public class Menu {
        public static int mainMenu() {
                String casino = ".######.....###.....######..####.##....##..#######.\n" +
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

        public static int selectNPlayers(){

                return IO.readInt2("Inserte un número de jugadores, mínimo 1 y máximo 4", 1,4);
        }

        public static String selectNamePlayer(int nPlayer){
                int count = nPlayer+1;
                return IO.readString("Inserte el nombre del jugador "+count);
        }

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
