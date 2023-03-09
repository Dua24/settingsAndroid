package com.example.preferences;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences mPreferences;

    int colorCur;
    TextView num;
    Button btnAdd,btnBlack,btnRed,btnBlue,btnGreen;
    int cur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = findViewById(R.id.textView);
        btnAdd = findViewById(R.id.btnadd);
        btnBlack = findViewById(R.id.btnBlack);
        btnRed = findViewById(R.id.btnRed);
        btnBlue = findViewById(R.id.btnBlue);
        btnGreen = findViewById(R.id.btnGreen);

        mPreferences= getPreferences(MODE_PRIVATE);

            int numStore = mPreferences.getInt(String.valueOf(R.id.textView),1);
            String colorStore = String.valueOf(mPreferences.getInt("storeColor",colorCur));
            num.setText(String.valueOf(numStore));
            num.setBackgroundColor(Integer.valueOf(colorStore));



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cur =Integer.parseInt(num.getText().toString());
                cur = cur + 1;
                num.setText(String.valueOf(cur));

            }
        });

        btnBlack.setOnClickListener(clickListener);
        btnRed.setOnClickListener(clickListener);
        btnBlue.setOnClickListener(clickListener);
        btnGreen.setOnClickListener(clickListener);

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putInt(String.valueOf(R.id.textView),cur);
        editor.putInt("storeColor",colorCur);
        editor.apply();
    }

    public View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            SharedPreferences.Editor editor = mPreferences.edit();
           switch (view.getId()){
               case R.id.btnBlack:
                   num.setBackgroundColor(Color.BLACK);
                   colorCur=Color.BLACK;
                   break;
               case R.id.btnRed:
                   num.setBackgroundColor(Color.RED);
                   colorCur=Color.RED;
                   break;
               case R.id.btnBlue:
                   colorCur=Color.BLUE;
                   num.setBackgroundColor(Color.BLUE);
                   break;
               case R.id.btnGreen:
                   colorCur=Color.GREEN;
                   num.setBackgroundColor(Color.GREEN);
                   break;
           }
        }
    };
}