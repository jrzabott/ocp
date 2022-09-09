import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class RB {
    public static void main(String[] args) {
        Locale myLoc = new Locale.Builder().setLanguage("english").setRegion("UK").build();
        ResourceBundle rb = ResourceBundle.getBundle("mymsgs", myLoc);

        final Enumeration<String> keys = rb.getKeys();
        while (keys.hasMoreElements()) {
            System.out.println(keys.nextElement());
        }
//
//Console c = System.console();
//c.printf("%s", "Qualquer coisa... >");
//c.readLine();



    }
}

