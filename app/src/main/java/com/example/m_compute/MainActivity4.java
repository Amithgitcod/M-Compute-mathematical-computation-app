package com.example.m_compute;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity4 extends AppCompatActivity {

    Button button8,button9;
    EditText octvalue,decovalue;
    TextView textView15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        octvalue = findViewById(R.id.octvalue);
        decovalue = findViewById(R.id.decovalue);
        textView15 = findViewById(R.id.textView15);

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String octal = octvalue.getText().toString();
                int l = octal.length();
                if(l == 0){
                    Toast.makeText(MainActivity4.this, "please enter the octal value", Toast.LENGTH_SHORT).show();
                }
                else{
                   int octnum = Integer.parseInt(octal);
                   int res = octalToDeci(octnum);
                   if(res == -1){
                       Toast.makeText(MainActivity4.this, "please enter valid octal value", Toast.LENGTH_SHORT).show();
                   }
                   else{
                       String str = Integer.valueOf(res).toString();
                       textView15.setText(str);
                   }
                }
            }
        });


        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String s = decovalue.getText().toString();
                    if(s.length() == 0){
                        Toast.makeText(MainActivity4.this, "please enter decimal value", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        int deci = Integer.parseInt(s);
                        String str = decToOctal(deci);
                        textView15.setText(str);
                    }
            }
        });
    }

    static int octalToDeci(int n)
    {
        int num = n;
        int dec_value = 0;

        // Initializing base value to 1, i.e 8^0
        int base = 1;

        int temp = num;
        while (temp > 0) {

            int last_digit = temp % 10;
            if(last_digit > 7 || last_digit < 0){
                return -1;
            }
            temp = temp / 10;

            dec_value += last_digit * base;

            base = base * 8;
        }
        return dec_value;
    }

    static String decToOctal(int n)
    {

        int[] octalNum = new int[100];

        int i = 0;
        while (n != 0) {

            octalNum[i] = n % 8;
            n = n / 8;
            i++;
        }

        int l = octalNum.length;
        char[] crr = new char[l];
        int a=0;
        int REDIX = 10;
        for (int j = i - 1; j >= 0; j--) {
            crr[a] = Character.forDigit(octalNum[j],REDIX);
            a++;
        }

        String str = String.copyValueOf(crr);

        return str;
    }

}