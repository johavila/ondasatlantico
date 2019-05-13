package ondasatlantico.com;

import android.util.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static Pattern pat= null;
    private static Matcher mat=null;

    // Valida que se escriba un Email Correctamente
    public static boolean isEmail (String email) {
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return false;
        } else {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
    }
    public static boolean isPassword (String password) {
        if (password!=null && password.length()>5){
            return true;
        }else{
            return false;
        }
    }
}
