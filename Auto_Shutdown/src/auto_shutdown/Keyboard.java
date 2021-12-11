package auto_shutdown;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Eduardo Delgado
 */
public class Keyboard {
    
    public static String IntroString(String msg) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(msg);

        return keyboard.nextLine();
    }
    public static int IntroInteger(String msg) {
        Scanner teclado = new Scanner(System.in);
        boolean valid = false;
        int number = 0;
        do {
            System.out.println(msg);
            try {
                number = teclado.nextInt();
                valid = true;
            } catch (InputMismatchException io) {
                System.out.println("Data type incorrect, attempt again");
                teclado.next();
            }
        } while (!valid);
        return number;
    }
}
