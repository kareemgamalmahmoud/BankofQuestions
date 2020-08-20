package com.example.bankofquestions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class scoreActivity extends AppCompatActivity {

    TextView textView_score_id , textView_2;

    Button back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        //--------------geting score partion---------
        textView_score_id = (TextView) findViewById(R.id.textview_score_id);
        Intent intent = getIntent();
        String above_username = "Your Score is:" + intent.getStringExtra(Intent.EXTRA_TEXT);
        textView_score_id.setText(above_username);

        //----------------show all questios and thir answers partion------
        textView_2 = (TextView) findViewById(R.id.textview_2);
        for(int i = 0 ; i <= 9 ; i++)
        {
            textView_2.append(
                    "Q" + (i+1) + ") " + quizActivity.bank_Of_Questions_Array.get(i) + " \n " +
                            " Ans: " + quizActivity.answers_Array.get(i)+" \n\n "
            );
        }
    }
    //-------------------------------------------
    public void back_button_function(View view) {
        back_button = (Button) findViewById(R.id.back_button_id);
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
