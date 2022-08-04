package com.example.m_compute;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText value1,value2,symbol;
    Button button5;
    TextView textView13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        value1 = findViewById(R.id.value1);
        value2 = findViewById(R.id.value2);
        symbol = findViewById(R.id.symbol);
        button5 = findViewById(R.id.button5);
        textView13 = findViewById(R.id.textView13);


        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = value1.getText().toString();
                String s2 = value2.getText().toString();

                if (s1.length() == 0 || s2.length() == 0) {
                    Toast.makeText(MainActivity2.this, "please enter all values", Toast.LENGTH_SHORT).show();
                } else {


                    double a = Double.parseDouble(s1);
                    double b = Double.parseDouble(s2);


                    String o = symbol.getText().toString();

                    if (o.length() > 1 || o.length() == 0) {
                        Toast.makeText(MainActivity2.this, "please enter valid symbol", Toast.LENGTH_SHORT).show();
                    } else {
                        char opr = o.charAt(0);
                        if (opr == '+') {
                            double res = a + b;
                            String result = Double.valueOf(res).toString();
                            textView13.setText(result);
                        } else if (opr == '-') {
                            double res = a - b;
                            String result = Double.valueOf(res).toString();
                            textView13.setText(result);
                        } else if (opr == '*') {
                            double res = a * b;
                            String result = Double.valueOf(res).toString();
                            textView13.setText(result);
                        } else if (opr == '/') {
                            double res = a / b;
                            String result = Double.valueOf(res).toString();
                            textView13.setText(result);
                        } else if (opr == '^') {
                            double res = Math.pow(a, b);
                            String result = Double.valueOf(res).toString();
                            textView13.setText(result);
                        } else {
                            Toast.makeText(MainActivity2.this, "please try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }

}