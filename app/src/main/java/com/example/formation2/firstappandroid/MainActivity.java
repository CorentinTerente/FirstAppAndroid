package com.example.formation2.firstappandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonDigit0, buttonDigit1, buttonDigit2, buttonDigit3, buttonDigit4, buttonDigit5, buttonDigit6, buttonDigit7, buttonDigit8, buttonDigit9;
    private Button buttonEquals, buttonDot, buttonTimes, buttonPlus, buttonMinus, buttonDivide;
    private Button buttonInfo;
    private TextView result;
    private String currentOperation;
    private float previousResult;
    private boolean showResult;

    //listener for digits, add the value of the button to the current result and enable operations buttons
    private View.OnClickListener digitListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String buttonValue = ((Button)v).getText().toString();

            if(result.getText().equals("0") || showResult ) {
                result.setText(buttonValue);
                showResult = false;
            } else {
                result.append(buttonValue);
            }

            buttonEquals.setEnabled(true);
            buttonMinus.setEnabled(true);
            buttonPlus.setEnabled(true);
            buttonTimes.setEnabled(true);
            buttonDivide.setEnabled(true);
        }
    };

    //listener for the dot, add the dot to the current result, disable operations buttons and itself
    private View.OnClickListener dotListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String buttonValue = ((Button)v).getText().toString();

            result.append(buttonValue);

            buttonDot.setEnabled(false);
            buttonPlus.setEnabled(false);
            buttonMinus.setEnabled(false);
            buttonTimes.setEnabled(false);
            buttonDivide.setEnabled(false);
            buttonEquals.setEnabled(false);
        }
    };

    //listener for equals
    private View.OnClickListener equalsListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            float currentValue = Float.parseFloat(result.getText().toString());

            if(currentOperation.equals("+")){

                 result.setText(previousResult+currentValue + "");
            }

            if(currentOperation.equals("-")){

                result.setText(previousResult - currentValue + "");
            }

            if(currentOperation.equals("*")){

                result.setText(previousResult * currentValue + "");
            }

            if(currentOperation.equals("/")){
                if(currentValue != 0) {
                    result.setText(previousResult / currentValue + "");
                } else {
                    result.setText("ERREUR");
                }
            }

            previousResult = 0;
            showResult = true;
        }
    };

    //listener for operations
    private View.OnClickListener operationListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            float currentResult = Float.parseFloat(result.getText().toString());

            if(previousResult != 0) {
                if(currentOperation.equals("+")) {
                    previousResult += currentResult;

                }

                if(currentOperation.equals("-")){
                    previousResult -= currentResult;

                }

                if(currentOperation.equals("*")){
                    previousResult *= currentResult;

                }

                if(currentOperation.equals("/")){

                    if(Float.parseFloat(result.getText().toString()) != 0) {
                        previousResult /= currentResult;

                    } else {
                        result.setText("ERREUR");

                    }
                }
                currentOperation = ((Button) v).getText().toString();
            } else {
                previousResult = Float.parseFloat(result.getText().toString());

                currentOperation = ((Button) v).getText().toString();
            }
            
            buttonDot.setEnabled(true);
            result.setText("0");
        }
    };

    private View.OnClickListener onClickButtonInfo = v -> {

                Intent intent = new Intent(MainActivity.this,InfoActivity.class);
                MainActivity.this.startActivity(intent);
        };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonDigit0 = findViewById(R.id.button_digit0);
        buttonDigit1 = findViewById(R.id.button_digit1);
        buttonDigit2 = findViewById(R.id.button_digit2);
        buttonDigit3 = findViewById(R.id.button_digit3);
        buttonDigit4 = findViewById(R.id.button_digit4);
        buttonDigit5 = findViewById(R.id.button_digit5);
        buttonDigit6 = findViewById(R.id.button_digit6);
        buttonDigit7 = findViewById(R.id.button_digit7);
        buttonDigit8 = findViewById(R.id.button_digit8);
        buttonDigit9 = findViewById(R.id.button_digit9);
        buttonPlus = findViewById(R.id.button_plus);
        buttonMinus = findViewById(R.id.button_minus);
        buttonTimes = findViewById(R.id.button_times);
        buttonDivide = findViewById(R.id.button_divide);
        buttonEquals = findViewById(R.id.button_equals);
        buttonDot = findViewById(R.id.button_dot);
        result = findViewById(R.id.textView_result);
        buttonInfo = findViewById(R.id.button_info);


        //setting the listener on each button
        buttonDigit0.setOnClickListener(digitListener);
        buttonDigit1.setOnClickListener(digitListener);
        buttonDigit2.setOnClickListener(digitListener);
        buttonDigit3.setOnClickListener(digitListener);
        buttonDigit4.setOnClickListener(digitListener);
        buttonDigit5.setOnClickListener(digitListener);
        buttonDigit6.setOnClickListener(digitListener);
        buttonDigit7.setOnClickListener(digitListener);
        buttonDigit8.setOnClickListener(digitListener);
        buttonDigit9.setOnClickListener(digitListener);
        buttonEquals.setOnClickListener(equalsListener);
        buttonPlus.setOnClickListener(operationListener);
        buttonMinus.setOnClickListener(operationListener);
        buttonTimes.setOnClickListener(operationListener);
        buttonDivide.setOnClickListener(operationListener);
        buttonDot.setOnClickListener(dotListener);
        buttonInfo.setOnClickListener(onClickButtonInfo);



    }
}
