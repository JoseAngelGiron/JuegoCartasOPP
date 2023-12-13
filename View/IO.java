package View;

import java.util.Objects;
import java.util.Scanner;

public class IO {
    /**
     * Función que recibe un mensaje y permite introducir un número
     * @param  msg que se va a imprimir por pantalla
     * @return la opción que le hemos dado por teclado
     */
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

    /**
     * Función que recibe un mensaje por pantalla que va a imprimir y 2 numeros, un min y un max con el cual usara para validar el número que
     * se le introduce
     * @param msg un mensaje que mostrara por pantalla
     * @param nMin número que funcionara como tope por mínimo
     * @param nMax numero que funcionara como tope máximo
     * @return un numero entre nMin y nMax
     */
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

    /**
     * Función que imprime un mensaje y permite introducir otro que se devolvera
     * @param msg el mensaje que se va a imprimir
     * @return el mensaje que nosotros introduzcamos
     */
    public static String readString(String msg){
            System.out.print(msg + ": ");
            Scanner teclado = new Scanner(System.in);
            String mensaje;
            mensaje = teclado.nextLine();

            return mensaje;
        }

    /**
     * Función que imprime un mensaje por pantalla y permite escribir una cadena de texto
     * Se asegura que introduzcamos alguna opción entre las que se contemplan
     * @param msg el mensaje que se va a imprimir
     * @return la cadena de texto que le hemos introducido por teclado.
     */
    public static String readOption(String msg){

            Scanner teclado = new Scanner(System.in);
            String option;

            do {
                System.out.println(msg + ": ");
                option = teclado.nextLine();

                if (!Objects.equals(option, "s") && !Objects.equals(option, "n"))
                    System.out.println("La opción introducida no se contempla, pruebe de nuevo.");





            }while(!Objects.equals(option, "s") && !Objects.equals(option, "n"));

            return option;
        }

}
