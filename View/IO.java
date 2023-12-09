package View;

import java.util.Scanner;

public class IO {

        public static int readInt(String msg) {
            Scanner teclado = new Scanner(System.in);
            System.out.print(msg + ": ");
            int opcionteclado = -1;
            try {
                opcionteclado = teclado.nextInt();
            } catch (Exception e) {
                teclado.nextLine();
                System.out.println("La opción introducida no es valida, pruebe de nuevo");
            }
            return opcionteclado;
        }
        public static String readString(String msg){
            Scanner teclado = new Scanner(System.in);
            System.out.print(msg+": ");
            return teclado.nextLine();
        }

}
