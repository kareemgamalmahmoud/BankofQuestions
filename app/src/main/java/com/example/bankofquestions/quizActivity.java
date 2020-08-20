package com.example.bankofquestions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class quizActivity extends AppCompatActivity {

    Button back_button;
    Button submet_button;

    int score = 0 ;
    boolean no_answer1 = true , no_answer2 = true , no_answer3 = true , no_answer4 = true , no_answer5 = true;

    TextView t1, t2, t3, t4, t5;

    RadioGroup rg1 , rg2 , rg3 , rg4 , rg5;

    RadioButton rb1_1, rb1_2 , rb1_3 , rb2_1 , rb2_2 , rb2_3 , rb3_1 , rb3_2 , rb3_3
                , rb4_1 , rb4_2 , rb4_3 , rb5_1 , rb5_2 , rb5_3;

    int a1,a2,a3,a4,a5 , min = 0 , max = 1;

    //---------------------arraylists for data-------------------------------
    public static ArrayList<String> bank_Of_Questions_Array = new ArrayList<>();
    public static ArrayList<String> answers_Array = new ArrayList<>();
    public static ArrayList<String> choices_Array = new ArrayList<>();

    //-----------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //----------------------------------------------------

        t1  = (TextView) findViewById(R.id.textview_rg_1);
        t2  = (TextView) findViewById(R.id.textview_rg_2);
        t3  = (TextView) findViewById(R.id.textview_rg_3);
        t4  = (TextView) findViewById(R.id.textview_rg_4);
        t5  = (TextView) findViewById(R.id.textview_rg_5);

        rg1  = (RadioGroup) findViewById(R.id.radioGroup_1);
        rg2  = (RadioGroup) findViewById(R.id.radioGroup_2);
        rg3  = (RadioGroup) findViewById(R.id.radioGroup_3);
        rg4  = (RadioGroup) findViewById(R.id.radioGroup_4);
        rg5  = (RadioGroup) findViewById(R.id.radioGroup_5);

        rb1_1 = (RadioButton) findViewById(R.id.choose_1_1);
        rb1_2 = (RadioButton) findViewById(R.id.choose_1_2);
        rb1_3 = (RadioButton) findViewById(R.id.choose_1_3);

        rb2_1 = (RadioButton) findViewById(R.id.choose_2_1);
        rb2_2 = (RadioButton) findViewById(R.id.choose_2_2);
        rb2_3 = (RadioButton) findViewById(R.id.choose_2_3);

        rb3_1 = (RadioButton) findViewById(R.id.choose_3_1);
        rb3_2 = (RadioButton) findViewById(R.id.choose_3_2);
        rb3_3 = (RadioButton) findViewById(R.id.choose_3_3);

        rb4_1 = (RadioButton) findViewById(R.id.choose_4_1);
        rb4_2 = (RadioButton) findViewById(R.id.choose_4_2);
        rb4_3 = (RadioButton) findViewById(R.id.choose_4_3);

        rb5_1 = (RadioButton) findViewById(R.id.choose_5_1);
        rb5_2 = (RadioButton) findViewById(R.id.choose_5_2);
        rb5_3 = (RadioButton) findViewById(R.id.choose_5_3);


        //-------------------to get back to the main page-----
        back_button = findViewById(R.id.back_button_id);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        //------------this part for sending username in an intent-------------
        Intent intent = getIntent();
        String above_username = "Hi," + intent.getStringExtra(Intent.EXTRA_TEXT);
        back_button.setText(above_username);

        //-------to get a random numbers-------------------------------
        a1 = (int)(Math.random() * (max - min + 1) + min);
        a2 = 2+(int)((Math.random() * (max - min + 1) + min));
        a3 = 4+(int)((Math.random() * (max - min + 1) + min));
        a4 = 6+(int)((Math.random() * (max - min + 1) + min));
        a5 = 8+(int)((Math.random() * (max - min + 1) + min));

        //------------------questions----------------------------------
        /*1*/  bank_Of_Questions_Array.add("What is the area of Egypt?");
        /*2*/  bank_Of_Questions_Array.add("How many Arab countries are there?");
        /*3*/  bank_Of_Questions_Array.add("In which year was the October war?");
        /*4*/  bank_Of_Questions_Array.add("When was the January revolution?");
        /*5*/  bank_Of_Questions_Array.add("How long is the Egyptian civilization?");
        /*6*/  bank_Of_Questions_Array.add("Who is the founder of chemistry?");
        /*7*/  bank_Of_Questions_Array.add("When was Ahmed Zewail Noble taken?");
        /*8*/  bank_Of_Questions_Array.add("What is the most radioactive chemical element?");
        /*9*/  bank_Of_Questions_Array.add("The most famous physicist?");
        /*10*/ bank_Of_Questions_Array.add("Where is Ain Shams University located?");

        //---------answers-----------
        /*1*/  answers_Array.add("1 million km²");
        /*2*/  answers_Array.add("22");
        /*3*/  answers_Array.add("1973");
        /*4*/  answers_Array.add("2011");
        /*5*/  answers_Array.add("30 centuries");
        /*6*/  answers_Array.add("Jabir ibn Hayyan (Geber)");
        /*7*/  answers_Array.add("1999");
        /*8*/  answers_Array.add("Polonium");
        /*9*/  answers_Array.add("Albert Einstein");
        /*10*/ answers_Array.add("Cairo");

        //--------choices--------------
        /*1*/  choices_Array.add("5 million km²");
        /*2*/  choices_Array.add("1 million km²");
        /*3*/  choices_Array.add("10 million km²");
        /*4*/  choices_Array.add("22");
        /*5*/  choices_Array.add("50");
        /*6*/  choices_Array.add("40");
        /*7*/  choices_Array.add("1985");
        /*8*/  choices_Array.add("1975");
        /*9*/  choices_Array.add("1973");
        /*10*/ choices_Array.add("2011");
        /*11*/ choices_Array.add("2015");
        /*12*/ choices_Array.add("2010");
        /*13*/ choices_Array.add("10 centuries");
        /*14*/ choices_Array.add("30 centuries");
        /*15*/ choices_Array.add("50 centuries");
        /*16*/ choices_Array.add("Jabir ibn Hayyan (Geber)");
        /*17*/ choices_Array.add("Dr.Ahmed Zewail");
        /*18*/ choices_Array.add("Ibn Batot");
        /*19*/ choices_Array.add("1999");
        /*20*/ choices_Array.add("2005");
        /*21*/ choices_Array.add("2010");
        /*22*/ choices_Array.add("Polonium");
        /*23*/ choices_Array.add("nitrogen");
        /*24*/ choices_Array.add("carbon");
        /*25*/ choices_Array.add("Paul Dirac");
        /*26*/ choices_Array.add("Albert Einstein");
        /*27*/ choices_Array.add("Niels Bohr");
        /*28*/ choices_Array.add("Cairo");
        /*29*/ choices_Array.add("Giza");
        /*30*/ choices_Array.add("Alexandria");

        //------------to insert questoins and choises randomly-----------------------------
        String ss = bank_Of_Questions_Array.get(a1);
            t1.setText("Q1) " + ss);
            if(a1 == 0) {
                rb1_1.setText(choices_Array.get(a1));
                rb1_2.setText(choices_Array.get(a1+1));
                rb1_3.setText(choices_Array.get(a1+2));
            }else{
                a1 *= 3;
                rb1_1.setText(choices_Array.get(a1));
                rb1_2.setText(choices_Array.get(a1+1));
                rb1_3.setText(choices_Array.get(a1+2));
            }

        ss = bank_Of_Questions_Array.get(a2);
            t2.setText("Q2) " + ss);
            if(a2 == 2){
                a2 *= 3;
                rb2_1.setText(choices_Array.get(a2));
                rb2_2.setText(choices_Array.get(a2+1));
                rb2_3.setText(choices_Array.get(a2+2));
            }else{
                a2 *= 3;
                rb2_1.setText(choices_Array.get(a2));
                rb2_2.setText(choices_Array.get(a2+1));
                rb2_3.setText(choices_Array.get(a2+2));
            }

        ss = bank_Of_Questions_Array.get(a3);
            t3.setText("Q3) " + ss);
            if(a3 == 4){
                a3 *= 3;
                rb3_1.setText(choices_Array.get(a3));
                rb3_2.setText(choices_Array.get(a3+1));
                rb3_3.setText(choices_Array.get(a3+2));
            }else{
                a3 *= 3;
                rb3_1.setText(choices_Array.get(a3));
                rb3_2.setText(choices_Array.get(a3+1));
                rb3_3.setText(choices_Array.get(a3+2));
            }

        ss = bank_Of_Questions_Array.get(a4);
            t4.setText("Q4) " + ss);
            if(a4 == 6){
                a4 *= 3;
                rb4_1.setText(choices_Array.get(a4));
                rb4_2.setText(choices_Array.get(a4+1));
                rb4_3.setText(choices_Array.get(a4+2));
            }else{
                a4 *= 3;
                rb4_1.setText(choices_Array.get(a4));
                rb4_2.setText(choices_Array.get(a4+1));
                rb4_3.setText(choices_Array.get(a4+2));
            }

        ss = bank_Of_Questions_Array.get(a5);
            t5.setText("Q5) " + ss);
            if(a5 == 8){
                a5 *= 3;
                rb5_1.setText(choices_Array.get(a5));
                rb5_2.setText(choices_Array.get(a5+1));
                rb5_3.setText(choices_Array.get(a5+2));
            }else{
                a5 *= 3;
                rb5_1.setText(choices_Array.get(a5));
                rb5_2.setText(choices_Array.get(a5+1));
                rb5_3.setText(choices_Array.get(a5+2));
            }

        //----------------to calculate the score for the user----------------
        submet_button = (Button) findViewById(R.id.submet_button);
        submet_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                score = 0 ;
                if(rb1_1.isChecked()){
                    no_answer1 = true;
                    if(answers_Array.contains(rb1_1.getText().toString()) && rb1_1.isChecked())
                        score++; }
                else if (rb1_2.isChecked()){
                    no_answer1 = true;
                    if(answers_Array.contains(rb1_2.getText().toString()) && rb1_2.isChecked())
                        score++;}
                else if (rb1_3.isChecked()){
                    no_answer1 = true;
                    if(answers_Array.contains(rb1_3.getText().toString()) && rb1_3.isChecked())
                        score++; }
                else if (rb1_1.isChecked() == false || rb1_2.isChecked() == false ||rb1_3.isChecked() == false )
                    no_answer1 = false;
                //---------------------------------
                if(rb2_1.isChecked()){
                    no_answer2 = true;
                    if(answers_Array.contains(rb2_1.getText().toString()) && rb2_1.isChecked())
                        score++; }
                else if (rb2_2.isChecked()){
                    no_answer2 = true;
                    if(answers_Array.contains(rb2_2.getText().toString()) && rb2_2.isChecked())
                        score++; }
                else if (rb2_3.isChecked()){
                    no_answer2 = true;
                    if(answers_Array.contains(rb2_3.getText().toString()) && rb2_3.isChecked())
                        score++; }
                else if (rb2_1.isChecked() == false || rb2_2.isChecked() == false ||rb2_3.isChecked() == false )
                    no_answer2 = false;
                //---------------------------------
                if(rb3_1.isChecked()){
                    no_answer3 = true;
                    if(answers_Array.contains(rb3_1.getText().toString()) && rb3_1.isChecked())
                        score++; }
                else if (rb3_2.isChecked()){
                    no_answer3 = true;
                    if(answers_Array.contains(rb3_2.getText().toString()) && rb3_2.isChecked())
                        ++score; }
                else if (rb3_3.isChecked()){
                    no_answer3 = true;
                    if(answers_Array.contains(rb3_3.getText().toString()) && rb3_3.isChecked())
                        score++; }
                else if (rb3_1.isChecked() == false || rb3_2.isChecked() == false ||rb3_3.isChecked() == false )
                    no_answer3 = false;
                //---------------------------------
                if(rb4_1.isChecked()){
                    no_answer4 = true;
                    if(answers_Array.contains(rb4_1.getText().toString()) && rb4_1.isChecked())
                        score++; }
                else if (rb4_2.isChecked()){
                    no_answer4 = true;
                    if(answers_Array.contains(rb4_2.getText().toString()) && rb4_2.isChecked())
                        score++; }
                else if (rb4_3.isChecked()){
                    no_answer4 = true;
                    if(answers_Array.contains(rb4_3.getText().toString()) && rb4_3.isChecked())
                        score++; }
                else if (rb4_1.isChecked() == false || rb4_2.isChecked() == false ||rb4_3.isChecked() == false )
                    no_answer4 = false;
                //---------------------------------
                if(rb5_1.isChecked()){
                    no_answer5 = true;
                    if(answers_Array.contains(rb5_1.getText().toString()) && rb5_1.isChecked())
                        score++; }
                else if (rb5_2.isChecked()){
                    no_answer5 = true;
                    if(answers_Array.contains(rb5_2.getText().toString()) && rb5_2.isChecked())
                        score++; }
                else if (rb5_3.isChecked()){
                    no_answer5 = true;
                    if(answers_Array.contains(rb5_3.getText().toString()) && rb5_3.isChecked())
                        score++; }
                else if (rb5_1.isChecked() == false || rb5_2.isChecked() == false ||rb5_3.isChecked() == false )
                    no_answer5 = false;

                //-------send score partion------------
                if(no_answer1 && no_answer2 && no_answer3 && no_answer4 && no_answer5 ) {
                    String finalScore = " " + score;

                    /*------------This is the notification feature,
                                  but it does not work.
                                  I don't know why it makes the application suddenly shut down,
                                  and I researched this, but I could not solve the problem.

                     NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this)
                            .setContentTitle("Bank of Questions")
                            .setContentText("Good luck, good questions right? ")
                            .setAutoCancel(true);

                     NotificationManager nfm = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                     nfm.notify(1,builder.build());
                    */

                    Intent intent = new Intent(getApplicationContext(),scoreActivity.class);
                    intent.putExtra(Intent.EXTRA_TEXT, finalScore );
                    startActivity(intent);
                }
                else
                    Toast.makeText(quizActivity.this, "Please,answer all the questions !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
