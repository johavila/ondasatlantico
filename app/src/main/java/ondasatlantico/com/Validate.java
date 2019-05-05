package ondasatlantico.com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static Pattern pat= null;
    private static Matcher mat=null;

    // Valida que se escriba un Email Correctamente
    public static boolean isEmail (String email) {
        pat = Pattern.compile("^[\\w\\-\\_\\+]+(\\.[\\w\\-\\_]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$");
        mat = pat.matcher(email);
        if (mat.find()) {
            return true;
        } else {
            return false;
        }
    }
}
