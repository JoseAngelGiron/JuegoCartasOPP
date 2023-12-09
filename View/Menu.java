package View;

public class Menu {
        public static int mainMenu() {
                System.out.println("********** Menú **********");
                System.out.println("1. Iniciar Juego de Blackjack");
                System.out.println("2. Salir");
                System.out.print("Selecciona una opción: ");
                return IO.readInt("Elija una opción");
        }
}
