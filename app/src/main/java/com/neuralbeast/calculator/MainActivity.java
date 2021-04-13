package com.neuralbeast.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    boolean isNewOp = true;
    String op = "+";
    String Oldval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.editText);
    }

    public void numberEvent(View view) {
        if (isNewOp)
            et1.setText("");
        isNewOp = false;
        String number = et1.getText().toString();
        switch (view.getId()){
            case R.id.bu7:
                number += "7";
                break;
            case R.id.bu8:
                number += "8";
                break;
            case R.id.bu9:
                number += "9";
                break;
            case R.id.bu4:
                number += "4";
                break;
            case R.id.bu5:
                number += "5";
                break;
            case R.id.bu6:
                number += "6";
                break;
            case R.id.bu1:
                number += "1";
                break;
            case R.id.bu2:
                number += "2";
                break;
            case R.id.bu3:
                number += "3";
                break;
            case R.id.bu0:
                number += "0";
                break;
            case R.id.buDot:
                number += ".";
                break;
            case R.id.buPlusMinus:
                number = "-"+number;
                break;
        }

        et1.setText(number);

    }

    public void operatorEvent(View view) {
        isNewOp = true;
        Oldval = et1.getText().toString();
        switch (view.getId()){
            case R.id.buDivide:
                op = "/";
                break;
            case R.id.buMulti:
                op = "*";
                break;
            case R.id.buPlus:
                op = "+";
                break;
            case R.id.buMuins:
                op = "-";
                break;
        }

    }

    public void equalEvent(View view) {
        String newNum = et1.getText().toString();
        double result = 0.0;
        switch (op){
            case "+":
                result = Double.parseDouble(Oldval) + Double.parseDouble(newNum);
                break;
            case "-":
                result = Double.parseDouble(Oldval) - Double.parseDouble(newNum);
                break;
            case "/":
                result = Double.parseDouble(Oldval) / Double.parseDouble(newNum);
                break;
            case "*":
                result = Double.parseDouble(Oldval) * Double.parseDouble(newNum);
                break;
        }
        et1.setText(result+"");
    }

    public void acEvent(View view) {
        et1.setText("0");
        isNewOp = true;
    }

    public void percentageEvent(View view) {
        double no = Double.parseDouble(et1.getText().toString())/100;
        et1.setText(no +"");
        isNewOp = true;
    }
}