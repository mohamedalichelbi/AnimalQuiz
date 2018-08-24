package com.example.android.animalquizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the submit button is clicked.
     */
    public void submitAnswers(View view) {
        //find out  whether question 1 is answered right or not
        RadioButton q1Right = (RadioButton) findViewById(R.id.q1_right);
        boolean isQ1Right = q1Right.isChecked();

        //find out whether question 2 is answered right or not
        RadioButton q2Right = (RadioButton) findViewById(R.id.q2_right);
        boolean isQ2Right = q2Right.isChecked();

        //find out whether question 3 is answered right or not
        RadioButton q3Right = (RadioButton) findViewById(R.id.q3_right);
        boolean isQ3Right = q3Right.isChecked();

        //find out whether question 4 is answered right or not
        CheckBox q4RightAnswer1 = (CheckBox) findViewById(R.id.q4_right_answer1);
        boolean isQ4RightAnswer1 = q4RightAnswer1.isChecked();
        CheckBox q4RightAnswer2 = (CheckBox) findViewById(R.id.q4_right_answer2);
        boolean isQ4RightAnswer2 = q4RightAnswer2.isChecked();
        CheckBox q4WrongAnswer = (CheckBox) findViewById(R.id.q4_wrong_answer);
        boolean isQ4WrongAnswer = q4WrongAnswer.isChecked();

        //find out whether question 5 is answered right or not
        CheckBox q5RightAnswer1 = (CheckBox) findViewById(R.id.q5_right_answer1);
        boolean isQ5RightAnswer1 = q5RightAnswer1.isChecked();
        CheckBox q5RightAnswer2 = (CheckBox) findViewById(R.id.q5_right_answer2);
        boolean isQ5RightAnswer2 = q5RightAnswer2.isChecked();
        CheckBox q5WrongAnswer = (CheckBox) findViewById(R.id.q5_wrong_answer);
        boolean isQ5WrongAnswer = q5WrongAnswer.isChecked();

        //find out whether question 6 is answered right or not
        CheckBox q6RightAnswer1 = (CheckBox) findViewById(R.id.q6_right_answer1);
        boolean isQ6RightAnswer1 = q6RightAnswer1.isChecked();
        CheckBox q6RightAnswer2 = (CheckBox) findViewById(R.id.q6_right_answer2);
        boolean isQ6RightAnswer2 = q6RightAnswer2.isChecked();
        CheckBox q6WrongAnswer = (CheckBox) findViewById(R.id.q6_wrong_answer);
        boolean isQ6WrongAnswer = q6WrongAnswer.isChecked();

        //gets the customer's answer to question 7
        EditText q7Answer = (EditText) findViewById(R.id.q7_answer);
        String answerToQ7 = q7Answer.getText().toString();

        //gets the customer's answer to question 8
        EditText q8Answer = (EditText) findViewById(R.id.q8_answer);
        String answerToQ8 = q8Answer.getText().toString();

        //gets the customer's answer to question 9
        EditText q9Answer = (EditText) findViewById(R.id.q9_answer);
        String answerToQ9 = q9Answer.getText().toString();





        //calculate the price of the total order
        int score = calculateScore(isQ1Right, isQ2Right, isQ3Right, isQ4RightAnswer1, isQ4RightAnswer2, isQ4WrongAnswer, isQ5RightAnswer1, isQ5RightAnswer2, isQ5WrongAnswer, isQ6RightAnswer1, isQ6RightAnswer2, isQ6WrongAnswer, answerToQ7, answerToQ8, answerToQ9);
        Toast.makeText(this, "Your score is: "+ score +"/9", Toast.LENGTH_LONG).show();
    }

    /**
     * Calculates the score.
     *
     * @return total price
     */
    private int calculateScore(boolean isQ1Right, boolean isQ2Right, boolean isQ3Right, boolean isQ4RightAnswer1, boolean isQ4RightAnswer2, boolean isQ4WrongAnswer, boolean isQ5RightAnswer1, boolean isQ5RightAnswer2, boolean isQ5WrongAnswer, boolean isQ6RightAnswer1, boolean isQ6RightAnswer2, boolean isQ6WrongAnswer, String answerToQ7, String answerToQ8, String answerToQ9) {
        //price of one cup of coffee
        int totalScore = 0 ;

        //if the user has answered question 1 correctly
        if (isQ1Right == true) {
            totalScore += 1 ;
        }
        //if the user has answered question 2 correctly
        if (isQ2Right == true) {
            totalScore += 1 ;
        }
        //if the user has answered question 3 correctly
        if (isQ3Right == true) {
            totalScore += 1 ;
        }
        //if the user has answered question 4 correctly
        if ((isQ4RightAnswer1 == true)&&(isQ4RightAnswer2 == true)&&(isQ4WrongAnswer == false)) {
            totalScore += 1 ;
        }
        //if the user has answered question 5 correctly
        if ((isQ5RightAnswer1 == true)&&(isQ5RightAnswer2 == true)&&(isQ5WrongAnswer == false)) {
            totalScore += 1 ;
        }
        //if the user has answered question 6 correctly
        if ((isQ6RightAnswer1 == true)&&(isQ6RightAnswer2 == true)&&(isQ6WrongAnswer == false)) {
            totalScore += 1 ;
        }
        //if the user has answered question 7 correctly
        if (answerToQ7.equalsIgnoreCase("elephant")) {
            totalScore += 1 ;
        }
        //if the user has answered question 8 correctly
        if ((answerToQ8.equalsIgnoreCase("cows"))||(answerToQ8.equalsIgnoreCase("cow"))) {
            totalScore += 1 ;
        }
        //if the user has answered question 9 correctly
        if ((answerToQ9.equals("2"))||(answerToQ9.equalsIgnoreCase("two"))) {
            totalScore += 1 ;
        }
        return totalScore ;
    }

    /**
     * This method is called when the view answers button is clicked.
     */
    public void viewAnswers(View view) {
        String ANSWERS ;
        ANSWERS = "Question n1: false";
        ANSWERS +="\nQuestion n2: true";
        ANSWERS +="\nQuestion n3: true";
        ANSWERS +="\nQuestion n4: cat, pig";
        ANSWERS +="\nQuestion n5: frog, crow";
        ANSWERS +="\nQuestion n6: fish, mammals";
        ANSWERS +="\nQuestion n7: elephant";
        ANSWERS +="\nQuestion n8: cows(pl.), cow(sing.)";
        ANSWERS +="\nQuestion n9: two";
        displayMessage(ANSWERS);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.display_answer);
        orderSummaryTextView.setText(message);
    }

}
