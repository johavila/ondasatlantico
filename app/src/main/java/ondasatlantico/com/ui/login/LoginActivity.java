package ondasatlantico.com.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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


public class LoginActivity extends AppCompatActivity {
    private Activity _activity;
    private LoginViewModel loginViewModel;
    private Intent In;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       final EditText EmailText = findViewById(R.id.username);
       final EditText PasswordText = findViewById(R.id.password);
       final Button loginButton = findViewById(R.id.login);
       final ProgressBar loadingProgressBar = findViewById(R.id.loading);


        loginButton.setOnClickListener(v -> {
            loadingProgressBar.setVisibility(View.VISIBLE);
            if (!validateEmail(EmailText.getText().toString())){
                EmailText.setError("Invalid Email");
                EmailText.requestFocus();
            }else if (!validatePassword(PasswordText.getText().toString())){
                PasswordText.setError("Invalid Password");
                PasswordText.requestFocus();
            }else {
//                  loginViewModel.login(EmailText.getText().toString(),PasswordText.getText().toString());
               startActivity(new Intent (LoginActivity.this, MainActivity.class));
                /*mAuth.signInWithEmailAndPassword(EmailText.toString(),PasswordText.toString()).addOnCompleteListener(_activity,(task)->{
                    if (task.isSuccessful()){
                        Toast.makeText(_activity,"exito de firebase", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(_activity,"fallo de firebase", Toast.LENGTH_SHORT).show();
                    }
                });*/
             }
        });
    }
    // Valida si el password es valido
    protected boolean validatePassword (String password){
        return Validate.isPassword(password);
    }

    // Valida un Email valido
    protected boolean validateEmail(String email) {

        return Validate.isEmail(email);

    }

}
