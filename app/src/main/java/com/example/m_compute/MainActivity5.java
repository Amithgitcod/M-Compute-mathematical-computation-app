package com.example.m_compute;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {
    Button button10,button11;
    EditText hexvalue,dechvalue;
    TextView textView18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        hexvalue = findViewById(R.id.hexvalue);
        dechvalue = findViewById(R.id.dechvalue);
        textView18 = findViewById(R.id.textView18);

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = hexvalue.getText().toString();
                if(s.length() == 0){
                    Toast.makeText(MainActivity5.this, "please enter hexadecimal value", Toast.LENGTH_SHORT).show();
                }
                else {

                    int res = hexadecimalToDecimal(s);
                    if (res == -1) {
                        Toast.makeText(MainActivity5.this, "please enter valid hexadecimal value", Toast.LENGTH_SHORT).show();
                    } else {
                        String result = String.valueOf(res);
                        textView18.setText(result);
                    }
                }

            }
        });

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = dechvalue.getText().toString();
                if(s.length() == 0){
                    Toast.makeText(MainActivity5.this, "please enter decimal value", Toast.LENGTH_SHORT).show();
                }
                else{
                    int num = Integer.parseInt(s);
                    String res = deciTohex(num);
                    textView18.setText(res);
                }
            }
        });
    }

    public static int hexadecimalToDecimal(String hexVal)
    {
        int len = hexVal.length();
        int base = 1;
        int dec_val = 0;

        for (int i = len - 1; i >= 0; i--) {
            // if character lies in '0'-'9', converting
            // it to integral 0-9 by subtracting 48 from ASCII value

            if (hexVal.charAt(i) >= '0'
                    && hexVal.charAt(i) <= '9') {
                dec_val += (hexVal.charAt(i) - 48) * base;

                base = base * 16;
            }

            // if character lies in 'A'-'F' , converting
            // it to integral 10 - 15 by subtracting 55 from ASCII value

            else if (hexVal.charAt(i) >= 'A'
                    && hexVal.charAt(i) <= 'F') {
                dec_val += (hexVal.charAt(i) - 55) * base;

                base = base * 16;
            }
            else{
                return -1;
            }
        }
        return dec_val;
    }

   public static String deciTohex(int n)
    {

        int[] hexNum = new int[100];

        int i = 0;
        while (n != 0) {

            // Storing remainder in hexadecimal array
            hexNum[i] = n % 16;
            n = n / 16;
            i++;
        }

        int l = hexNum.length;
        char[] crr = new char[l];
        int a=0;
        int REDIX = 10;
        for (int j = i - 1; j >= 0; j--) {
            if (hexNum[j] > 9) {
                crr[a] = (char)(55 + hexNum[j]);
            }
            else{
                crr[a] = Character.forDigit(hexNum[j], REDIX);
            }
            a++;
        }
        String result = String.copyValueOf(crr);

        return result;
    }


}