package View;

import java.util.Objects;
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

        public static int readInt2(String msg, int nMin, int nMax) {
            Scanner teclado = new Scanner(System.in);

            int numberToReturn = 0;
            do {
                try{
                    System.out.println(msg + ": ");
                    numberToReturn = teclado.nextInt();
                }catch (Exception e){
                    teclado.nextLine();
                    System.out.println("El valor introducido no es un número, pruebe de nuevo");

                }
            } while (numberToReturn < nMin || numberToReturn > nMax);

            return numberToReturn;

        }


        public static String readString(String msg){
            System.out.print(msg + ": ");
            Scanner teclado = new Scanner(System.in);
            String mensaje;
            mensaje = teclado.nextLine();

            return mensaje;
        }


        public static String readOption(String msg){

            Scanner teclado = new Scanner(System.in);
            String option = "";

            do {
                System.out.println(msg + ": ");
                option = teclado.nextLine();

                if (!Objects.equals(option, "s") && !Objects.equals(option, "n"))
                    System.out.println("La opción introducida no se contempla, pruebe de nuevo.");





            }while(!Objects.equals(option, "s") && !Objects.equals(option, "n"));

            return option;
        }

}
