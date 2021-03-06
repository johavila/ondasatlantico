package ondasatlantico.com.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import ondasatlantico.com.MainActivity;
import ondasatlantico.com.R;
import ondasatlantico.com.Validate;
import static ondasatlantico.com.R.*;


public class LoginActivity extends AppCompatActivity {
    private View _view;
    private Activity _activity;
     private Intent In;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private Resources Res ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_login);

       final EditText EmailText = findViewById(id.username);
       final EditText PasswordText = findViewById(id.password);
       final Button loginButton = findViewById(id.login);
       final ProgressBar loadingProgressBar = findViewById(id.loading);

        //Inicializa Firebase
        mAuth = FirebaseAuth.getInstance();

        loginButton.setOnClickListener(v -> {
            _view = v;
            String email = EmailText.getText().toString();
            String password = PasswordText.getText().toString();
            loadingProgressBar.setVisibility(View.VISIBLE);
            if (!validateEmail(EmailText.getText().toString())){
                EmailText.setError(getText(R.string.invalid_username));
                EmailText.requestFocus();
            }else if (!validatePassword(PasswordText.getText().toString())){
                PasswordText.setError(getText(R.string.invalid_password));
                PasswordText.requestFocus();
            }else {
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, task -> {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                PasswordText.setError(getText(R.string.invalid_auth));
                                PasswordText.requestFocus();
                            }
                        });

             }
        });
    }

    // Valida si el password es valido
    protected boolean validatePassword (String password){
        return Validate.isPassword(password);
    }

    // Valida un Email valido
    protected boolean validateEmail(String email) {return Validate.isEmail(email); }

}
