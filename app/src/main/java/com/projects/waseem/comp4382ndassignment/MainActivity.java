package com.projects.waseem.comp4382ndassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {//Variables
    TextView mainScreen;
    double num1 = Double.NaN, num2 = Double.NaN, mem = Double.NaN;
    char operation = '@';//default value


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainScreen = (TextView) findViewById(R.id.resultTextView);
    }

    public void clearAll(View v) {//Put all default values and clear main screen
        num1 = Double.NaN;
        num2 = Double.NaN;
        mem = Double.NaN;
        operation = '@';
        mainScreen.setText("");

    }

    public void clearMemory(View v) {
        mem = Double.NaN;//Put default value in mem variable

    }

    public void recallMemory(View v) {
        if (!Double.isNaN(mem) && mainScreen.getText().toString().equals(""))
            mainScreen.setText(mem + "");//put mem content on screen


    }

    public void addMemory(View v) {//make sure its a number and parse it into mem variable
        if (!mainScreen.getText().toString().equals("")) {
            try {
                mem = Double.parseDouble(mainScreen.getText().toString());
                num1 = Double.NaN;
                num2 = Double.NaN;
                operation = '@';
                mainScreen.setText("");
            } catch (Exception ex) {
            }
        }

    }

    public void backLastInp(View v) {

        if((mainScreen.getText().toString().charAt(0)=='-')&&(mainScreen.getText().toString().length()==2))
            mainScreen.setText("");//if its a minus make sure to clear both characters
        if (!mainScreen.getText().toString().equals(""))// remove last character in main screen
            mainScreen.setText(mainScreen.getText().subSequence(0, mainScreen.getText().length() - 1));

    }

    public void negateNum(View v) {//negate value
        if (!mainScreen.getText().toString().equals(""))
            mainScreen.setText((Double.parseDouble(mainScreen.getText().toString())*-1)+"");

    }

    public void divNum(View v) {// div operation
        if (!mainScreen.getText().toString().equals("") && !isOperator(operation)) {
            operation = '/';
            num1 = Double.parseDouble(mainScreen.getText().toString());
            mainScreen.setText("");

        }
    }

    public void multNum(View v) {// multiply operation
        if (!mainScreen.getText().toString().equals("") && !isOperator(operation)) {
            operation = '*';
            num1 = Double.parseDouble(mainScreen.getText().toString());
            mainScreen.setText("");
        }
    }

    public void subtractNum(View v) {// subtraction
        if (!mainScreen.getText().toString().equals("") && !isOperator(operation)) {
            operation = '-';
            num1 = Double.parseDouble(mainScreen.getText().toString());
            mainScreen.setText("");

        }
    }

    public void addNum(View v) {// addition
        if (!mainScreen.getText().toString().equals("") && !isOperator(operation)) {
            operation = '+';
            num1 = Double.parseDouble(mainScreen.getText().toString());
            mainScreen.setText("");

        }
    }

    public void result(View v) {
        if (isOperator(operation) && !Double.isNaN(num1) && !mainScreen.getText().toString().equals("")) {
            num2 = Double.parseDouble(mainScreen.getText().toString());
            num1 = evaluate();
            if (!Double.isInfinite(num1))// put answer to screen
                mainScreen.setText(num1 + "");
            else{// if answer is infinity clear all
                num1 = Double.NaN;
                num2 = Double.NaN;
                mem = Double.NaN;
                operation = '@';
                mainScreen.setText("");
            }
            num2 = Double.NaN;
            operation = '@';


        } else {
            Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_LONG).show();
        }

    }

    public void num0(View v) {//numbers to screen
        mainScreen.append("0");
    }

    public void num1(View v) {
        mainScreen.append("1");

    }

    public void num2(View v) {
        mainScreen.append("2");
    }

    public void num3(View v) {
        mainScreen.append("3");
    }

    public void num4(View v) {
        mainScreen.append("4");
    }

    public void num5(View v) {
        mainScreen.append("1");
    }

    public void num6(View v) {
        mainScreen.append("6");
    }

    public void num7(View v) {
        mainScreen.append("7");
    }

    public void num8(View v) {
        mainScreen.append("8");
    }

    public void num9(View v) {
        mainScreen.append("9");
    }

    private boolean isOperator(char operator) {//to check for operators
        return operator == '*' || operator == '/' || operator == '+' || operator == '-';
    }

    private double evaluate() {
        switch (operation) {//evaluate input
            case '-':
                return (num1 - num2);

            case '*':
                return (num1 * num2);

            case '/':
                return (num1 / num2);

            case '+':
                return (num1 + num2);

            default:
                return Double.NaN;
        }
    }
}
