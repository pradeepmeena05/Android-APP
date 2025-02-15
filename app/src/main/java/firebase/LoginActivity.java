package firebase;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText emailEditText,passwordEditText;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        Button loginButton = findViewById(R.id.loginButton);
         emailEditText = findViewById(R.id.emailEditText);
         passwordEditText = findViewById(R.id.passwordEditText);
        mAuth = FirebaseAuth.getInstance();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login_User();
            }
        });


    }
      public void Login_User()
      {
          String email_id = emailEditText.getText().toString();
          String password = passwordEditText.getText().toString();

          if(TextUtils.isEmpty(email_id))
          {
              Toast.makeText(this, "Email should not be Empty", Toast.LENGTH_SHORT).show();
          }
          if(TextUtils.isEmpty(password))
          {
              Toast.makeText(this, "password should not be Empty", Toast.LENGTH_SHORT).show();
          }

          mAuth.signInWithEmailAndPassword(email_id,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
              @Override
              public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful())
                    {
                        Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                        intent.putExtra("login","Login Successfully");
                        startActivity(intent);
                    }else{
                        if(task.getException()!=null)
                        {
                            String Error=task.getException().getMessage();
                            Toast.makeText(getApplicationContext(),Error,Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Unknown Error",Toast.LENGTH_SHORT).show();
                        }
                    }
              }
          });

      }

}