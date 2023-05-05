
package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAdd, btnSub, btnMul, btnDiv, btnClear, btnEqual;
    private String operator;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the buttons in the layout by their IDs
        btnAdd = findViewById(R.id.btn_add);
        btnSub = findViewById(R.id.btn_sub);
        btnMul = findViewById(R.id.btn_mul);
        btnDiv = findViewById(R.id.btn_div);
        btnClear = findViewById(R.id.btn_clear);
        btnEqual = findViewById(R.id.btn_equal);

        // Set click listeners for the buttons
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnEqual.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                // Handle click for add button
                operator = "+";
                break;
            case R.id.btn_sub:
                // Handle click for subtract button
                operator = "-";
                break;
            case R.id.btn_mul:
                // Handle click for multiply
                operator = "*";
                break;
            case R.id.btn_div:
                // Handle click for divide
                operator = "/";
                break;
            case R.id.btn_clear:
                // Handle click for clear button
                clearValues();
                break;
            case R.id.btn_equal:
                // Handle click for equal button
                calculate();
                break;
        }
    }

    private void clearValues() {
        // Clear the input fields and operator
        EditText editText1 = findViewById(R.id.editText1);
        EditText editText2 = findViewById(R.id.editText2);
        TextView textViewOperator = findViewById(R.id.textViewOperator);

        editText1.setText("");
        editText2.setText("");
        textViewOperator.setText("");
    }

    private void enterValue() {
        // Check if an operator has been selected
        if (operator == null) {
            return;
        }

        // Get the input values
        EditText editText1 = findViewById(R.id.editText1);
        EditText editText2 = findViewById(R.id.editText2);
        TextView textViewOperator = findViewById(R.id.textViewOperator);

        String value1 = editText1.getText().toString();
        String value2 = editText2.getText().toString();

        // Check if both input fields are filled
        if (value1.isEmpty() || value2.isEmpty()) {
            return;
        }

        // Set the operator text
        textViewOperator.setText(operator);
    }

    private void calculate() {
        // Check if an operator has been selected
        if (operator == null) {
            return;
        }

        // Get the input values
        EditText editText1 = findViewById(R.id.editText1);
        EditText editText2 = findViewById(R.id.editText2);

        String value1 = editText1.getText().toString();
        String value2 = editText2.getText().toString();

        // Check if both input fields are filled
        if (value1.isEmpty() || value2.isEmpty()) {
            return;
        }

        // Calculate the result
        double result;
        switch (operator) {
            case "+":
                result = Double.parseDouble(value1) + Double.parseDouble(value2);
                break;
            case "-":
                result = Double.parseDouble(value1) - Double.parseDouble(value2);
                break;
            case "*":
                result = Double.parseDouble(value1) * Double.parseDouble(value2);
                break;
            case "/":
                result = Double.parseDouble(value1) / Double.parseDouble(value2);
                break;
            default:
                return;
        }

        // Store the result
        String resultString = String.valueOf(result);
        EditText editTextResult = findViewById(R.id.editTextResult);
        editTextResult.setText(resultString);
    }

    private void showResult() {
        // Get the result text
        EditText editTextResult = findViewById(R.id.editTextResult);
        String resultString = editTextResult.getText().toString();

        // Display the result in a toast message
        Toast.makeText(this, resultString, Toast.LENGTH_SHORT).show();
    }

}