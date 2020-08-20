package com.example.bankofquestions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.bankofquestions.App.CHANNEL_1_ID;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManager;

    Button signup_button;
    Button login_button;

    EditText userName_edittext_id, password_edittext_id ;

    public static ArrayList<String> nameArray = new ArrayList<>();
    public static ArrayList<String> passArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-------------notifications-----------
        notificationManager = NotificationManagerCompat.from(this);

        //----------------This is default values has putted this arraylist
        nameArray.add("Search number 01201");
        passArray.add("01201");

        //In this part will check the name and password and use intent to go to the next activity with user name above.
        login_button = findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                userName_edittext_id = (EditText) findViewById(R.id.userName_edittext_id);
                password_edittext_id = (EditText) findViewById(R.id.password_edittext_id);

                final String n = userName_edittext_id.getText().toString();
                final String p = password_edittext_id.getText().toString();

                Intent intent = new Intent(getApplicationContext(),quizActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT, n);

                if(nameArray.indexOf(n) >= 0)
                    if(p.equals(passArray.get(nameArray.indexOf(n))))
                    {
                        /*------------This is the notification feature,
                                      but it does not work.
                                      I don't know why it makes the application suddenly shut down,
                                      and I researched this, but I could not solve the problem.

                         NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this)
                                .setContentTitle("Bank of Questions")
                                .setContentText("Congratulations, your login has been successful.")
                                .setAutoCancel(true);

                        NotificationManager nfm = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                        nfm.notify(1,builder.build());
                        */

                        /*-------and i I tried a second time to create it using class , but did not work also.
                                    -->give me this(error: incompatible types: <anonymous OnClickListener>
                                       cannot be converted to Context)
                                       which i search for , and did not found the solution.

                        Notification notification = new NotificationCompat.Builder(this , CHANNEL_1_ID)
                                .setLargeIcon(R.drawable.ic_brain)
                                .setContentTitle("Bank of Questions")
                                .setContentText("Congratulations, your login has been successful.")
                                .build();

                        notificationManager.notify(1,notification);
                        */

                        startActivity(intent);
                    }
                    else
                        Toast.makeText(MainActivity.this, "The password is incorrect", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Name not found, create an account!", Toast.LENGTH_SHORT).show();
            }
        });
        //--------------------an intent for sign_up_activity----------------------------------------
        signup_button = findViewById(R.id.signup_button);
        signup_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(),signUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
