package com.example.android.subiequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int question1 = 0;
    int question2 = 0;
    int question3 = 0;
    int question4 = 0;
    int question5 = 0;
    int question6 = 0;
    int totalQuestions = 6;
    int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswers(View view) {
        // Calculates the total number of correct answers, calls the displayMessage method, then starts the exit screen
        calculateCorrectAnswers();
        displayMessage();
        Intent intent = new Intent(this, Exit_Screen.class);
        startActivity(intent);
    }

    // Checks the answer for question 1
    public void radioButtonQ1(View view) {
        // Import correct answer button for question 1
        RadioButton correctRadioButtonQ1 = findViewById(R.id.radio_button1C_yes);

        // Check if correct answer is clicked
        if (correctRadioButtonQ1.isChecked()) {
            question1 = 1;
            System.out.print("question1 = " + question1);
        } else {
            question1 = 0;
            System.out.print("question1 = " + question1);
        }
    }

    // Checks the answer for question 2
    public void radioButtonQ2(View view) {
        // Import correct answer button for question 2
        RadioButton correctRadioButtonQ2 = findViewById(R.id.radio_button2D_yes);

        // Check if correct answer was clicked
        if (correctRadioButtonQ2.isChecked()) {
            question2 = 1;
        } else {
            question2 = 0;
        }
    }

    // Checks the answer for question 3
    public void radioButtonQ3(View view) {
        // Import correct answer button for question 3
        RadioButton correctRadioButtonQ3 = findViewById(R.id.radio_button3B_yes);

        // Check if correct answer was clicked
        if (correctRadioButtonQ3.isChecked()) {
            question3 = 1;
        } else {
            question3 = 0;
        }
    }

    // Checks the answer for question 4
    public void radioButtonQ4(View view) {
        // Import correct answer button for question 4
        RadioButton correctRadioButtonQ4 = findViewById(R.id.radio_button4A_yes);

        // Check if correct answer was clicked
        if (correctRadioButtonQ4.isChecked()) {
            question4 = 1;
        } else {
            question4 = 0;
        }
    }

    // Checks the answer for question 5
    public void checkBoxQ5(View view) {
        // Import correct answer boxes for question 5
        CheckBox cBox5BCorrect = findViewById(R.id.questionFiveBCorrect);
        CheckBox cBox5CCorrect = findViewById(R.id.questionFiveCCorrect);

        // Check if correct checkbox was clicked
              if ((cBox5BCorrect.isChecked()) && (cBox5CCorrect.isChecked())) {
                question5 = 1;
            } else {
                question5 = 0;
            }
        }

    // Checks the EditText answer for question 6
    public int editTextQ6 () {
        // Import the editText for question 6
        EditText editTextQ6Correct = findViewById(R.id.questionSixText);

        // Creates a string variable to hold the entered text
        String answerQuestion6 = editTextQ6Correct.getText().toString();
        answerQuestion6 = answerQuestion6.toLowerCase();

        // Checks if answer is correct and adds 1 to int question6 if so, otherwise it stays as 0 for int question6
        if ((answerQuestion6.equals("ascent") ||
            answerQuestion6.equals("Ascent"))) {
            question6 = 1;
        } else {
            question6 = 0;
        }

        return question6;
    }

        public int calculateCorrectAnswers() {
            // calls the editTextQ6 method to retrieve the score for question6
            question6 = editTextQ6();

            // Adds all of the correct answers
            correctAnswers = (question1 + question2 + question3 + question4 + question5 + question6);

            return correctAnswers;
        }

    // method to display the Toast of the final score percentage
    public void displayMessage() {
        Toast.makeText(this, "You answered " + calculateCorrectAnswers() + " of " + totalQuestions +" Correct!", Toast.LENGTH_LONG).show();
    }
 }