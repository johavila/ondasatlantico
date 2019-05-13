package ondasatlantico.com.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import ondasatlantico.com.MainActivity;
import ondasatlantico.com.R;
import ondasatlantico.com.Validate;

import static ondasatlantico.com.R.*;


public class LoginActivity extends AppCompatActivity {
    private Activity _activity;
    private LoginViewModel loginViewModel;
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
       // Inicializa Firebase
       mAuth = FirebaseAuth.getInstance();

        loginButton.setOnClickListener(v -> {
            String email = EmailText.getText().toString();
            String password = PasswordText.getText().toString();
            loadingProgressBar.setVisibility(View.VISIBLE);
            if (!validateEmail(EmailText.getText().toString())){
                EmailText.setError(getText(string.invalid_username));
                EmailText.requestFocus();
            }else if (!validatePassword(PasswordText.getText().toString())){
                PasswordText.setError(getText(string.invalid_password));
                PasswordText.requestFocus();
            }else {

//               startActivity(new Intent (LoginActivity.this, MainActivity.class));
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(intent);
                                } else {
                                    Toast toast = Toast.makeText(LoginActivity.this, Res.getText(string.errorauth),Toast.LENGTH_LONG);
                                   toast.show();
                                   EmailText.setError("*");
                                    PasswordText .setError("*");
                                }
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
