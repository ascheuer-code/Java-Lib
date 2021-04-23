import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.lang.reflect.TypeVariable;
import java.util.Scanner;

public class Lib_Constructor {

    private static Scanner input;

    public static void createObject(String className) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {

        input = new Scanner(System.in);

        Class<?> cls = Class.forName(className);
        // Object o = cls.getDeclaredConstructor().newInstance();

        Field[] list = cls.getFields();

        for (Field param : list) {

            System.out.print(String.format("%s: ", param.getName()));
            input.nextLine();
        }

    }

}