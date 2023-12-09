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
            } while (numberToReturn >= nMin && numberToReturn <= nMax);

            return numberToReturn;

        }


        public static String readString(String msg){
            System.out.print(msg + ": ");
            Scanner teclado = new Scanner(System.in);
            String mensaje = " ";
            try {
                mensaje = teclado.nextLine();

            }catch(Exception e ){
                teclado.nextLine();
                System.out.println("No ha introducido un mensaje valido, pruebe de nuevo por favor.");

            }
            return mensaje;
        }
        public static String[] readString2(String msg, int nPlayers){
                Scanner teclado = new Scanner(System.in);
                String[] names = new String[nPlayers];
                int nPlayer =0;
                System.out.println(msg);
                 for(String name: names) {
                     System.out.println("Introduzca el nombre del jugador "+ nPlayer++);
                     name = teclado.nextLine();
                 }


                return names;
            }



}
