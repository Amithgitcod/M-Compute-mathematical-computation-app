package com.example.m_compute;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    EditText binvalue,decbvalue;
    Button button6,button7;
    TextView textView10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        binvalue = findViewById(R.id.binvalue);
        decbvalue = findViewById(R.id.decbvalue);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        textView10 = findViewById(R.id.textView10);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String binary = binvalue.getText().toString();
                int l = binary.length();
                if(l == 0){
                    Toast.makeText(MainActivity3.this, "please enter the binary value", Toast.LENGTH_SHORT).show();
                }
                else{
                    int sum=0;
                    StringBuilder input1 = new StringBuilder();

                    // append a string into StringBuilder input1
                    input1.append(binary);

                    // reverse StringBuilder input1
                    String str = input1.reverse().toString();
                    boolean check = true;
                    char[] ch = str.toCharArray();
                        for(int i=0;i<l;i++) {
                            int b = Integer.parseInt(String.valueOf(ch[i]));
                            if (b == 0 || b == 1) {
                                sum += Math.pow(2, i) * b;
                            }
                            else{
                                check = false;
                                break;
                            }
                        }
                        if(check == true) {
                            String res = Integer.valueOf(sum).toString();
                            textView10.setText(res);
                        }
                        else {
                            Toast.makeText(MainActivity3.this, "please enter only 0s and 1s ", Toast.LENGTH_SHORT).show();
                        }
                }
            }
        });


        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String decval = decbvalue.getText().toString();
                if(decval.length() == 0){
                    Toast.makeText(MainActivity3.this, "please enter decimal value", Toast.LENGTH_SHORT).show();
                }
                else{
                    int decinum = Integer.parseInt(decval);
                    String res = decimalToBinary(decinum);
                    textView10.setText(res);
                }
            }
        });
    }

    public static String decimalToBinary(int decNumber)
    {
        //base (or terminating) case
        if (decNumber == 0) return "0";
        if (decNumber == 1) return "1";

        if(decNumber >= 0)
        {
            return decimalToBinary(decNumber / 2) + decNumber % 2 + "" ;

        }
        else
            return null;
    }
}