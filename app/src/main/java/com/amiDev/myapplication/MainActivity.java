package com.amiDev.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public TextView tvTitle;
    public TextView tvRes ;
    public EditText etOG ;
    public EditText etFG ;
    public Button btnCal ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         tvTitle = findViewById(R.id.tvTitle);
         tvRes = findViewById(R.id.tvRes);
         etOG = findViewById(R.id.etOG);
         etFG = findViewById(R.id.etFG);
         btnCal = findViewById(R.id.btnCal);



        tvTitle.setText("מחשבון אלכוהול בבירה");


        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard(MainActivity.this);
                String sOG = etOG.getText().toString();
                String sFG = etFG.getText().toString();

                if(TextUtils.isEmpty(sOG) && sFG.matches("")){
                    Toast.makeText(MainActivity.this,"אנא הכנס ערך",Toast.LENGTH_LONG).show();
                    return;
                }

//xghfhdfgh
                double og = Integer.parseInt(sOG);
                double fg = Integer.parseInt(sFG);

                if (og < 1000 || fg < 1000 || fg > og){
                    Toast.makeText(MainActivity.this, "ערך לא תקין", Toast.LENGTH_SHORT).show();
                    return;
                }

                double res = (og - fg) * 131.25;

                if (res > 1000){
                    res /= 1000;
                }

                tvRes.setText(String.format("%.2f", res) + "%");
            }
        });

        tvTitle.setTextSize(40);
        tvTitle.setTextColor(getResources().getColor(R.color.my));



    }

    public void hideKeyboard(Activity activity){
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();

        if (view == null){
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(),0);
    }


}
