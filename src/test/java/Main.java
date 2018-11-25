import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

         Book  b= Book.book();

        Method method = Class.forName("Book").getMethod("book");
        Book b1 = (Book) method.invoke(null);
    }
}
