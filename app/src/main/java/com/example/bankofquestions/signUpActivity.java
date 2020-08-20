package com.example.bankofquestions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

public class signUpActivity extends AppCompatActivity {

    Button back_button;
    Button creat_it_button;
    Button creatyourAcount_button;

    EditText userName_edittext_id, password_edittext_id, confirmPassword_edittext_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        back_button = (Button) findViewById(R.id.back_button_id);
        creat_it_button = (Button) findViewById(R.id.creatyouracount_button);
        userName_edittext_id = (EditText) findViewById(R.id.userName_edittext_id);
        password_edittext_id = (EditText) findViewById(R.id.password_edittext_id);
        confirmPassword_edittext_id = (EditText) findViewById(R.id.confirmPassword_edittext_id);

        final String n1 = userName_edittext_id.getText().toString();

    }
    public void creatAcountFunction(View view) {

        String n1 = userName_edittext_id.getText().toString();
        String s1 = password_edittext_id.getText().toString();
        String s2 = password_edittext_id.getText().toString();

        //--------------create a new account part--------------
        if(n1.isEmpty())
            Toast.makeText(this, "Enter your name !", Toast.LENGTH_SHORT).show();
        else if (MainActivity.nameArray.indexOf(n1) >= 0)
            Toast.makeText(this, "This name is a duplicate!", Toast.LENGTH_SHORT).show();
        else if(s1.isEmpty() || s2.isEmpty())
        {
            Toast.makeText(this, "Enter a Password !", Toast.LENGTH_SHORT).show();
        }
        else if (s1.equals(s2))
        {
            MainActivity.nameArray.add(n1);
            MainActivity.passArray.add(s1);

            Intent intent = new Intent(getApplicationContext(),quizActivity.class);
            intent.putExtra(Intent.EXTRA_TEXT, n1);

            /*------------This is the notification feature,
                          but it does not work.
                          I don't know why it makes the application suddenly shut down,
                          and I researched this, but I could not solve the problem.

             NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this)
                    .setContentTitle("Bank of Questions")
                    .setContentText("Congratulations, your account has been created successfully.")
                    .setAutoCancel(true);

            NotificationManager nfm = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
            nfm.notify(1,builder.build());
            */

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                    .setContentTitle("Welcome Notification")
                    .setContentText("Hello Ahmed Gaber")
                    .setNumber(1);

            NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            manager.notify(1, builder.build());

            startActivity(intent);
        }
        else
            Toast.makeText(this, "Password does not match !", Toast.LENGTH_SHORT).show();
    }

    public void back_button_function(View view) {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
