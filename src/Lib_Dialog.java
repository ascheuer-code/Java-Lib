import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lib_Dialog {

    // TODO : Replace Dialog dialog with the Dialog Class name

    private static final int ENDE = 0;
    private int option = -1;
    private Dialog dialog;
    private static Scanner input;

    /**
     * Eigentliche Startmethode
     */

    public void start(ArrayList<String> menue) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        dialog = new Dialog();
        input = new Scanner(System.in);
        Class<?> cls = Class.forName("Dialog");
        Object o = cls.getDeclaredConstructor().newInstance();

        while (option != ENDE) {
            try {
                printMenue(menue);
                option = chooseOption();
                ausfuehrenFunktion(menue, option, o);
            } catch (IllegalArgumentException msg) {
                System.out.println("\n" + msg);
            } catch (InputMismatchException msg) {
                System.out.println("\n" + msg + ": Kein korrekter Wert");
                input.nextLine();
            } catch (Exception msg) {
                msg.printStackTrace();
            }
        }
    }

    public static <T> void printMenue(ArrayList<T> arraylist) {

        StringBuilder sb = new StringBuilder();
        int optioncounter = 0;

        for (T string : arraylist) {

            optioncounter++;
            sb.append(String.format("%d: %s\n", optioncounter, string));

        }
        System.out.println(sb);

    }

    public static int chooseOption() {

        System.out.print("\nBitte wählen sie eine Option\n");
        return input.nextInt();
    }

    public static void ausfuehrenFunktion(ArrayList<String> menue, int option, Object o)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Method method = Dialog.class.getDeclaredMethod(Lib_String.RemoveAllWhitespaces(menue.get(option - 1)));
        method.invoke(o);

    }

}