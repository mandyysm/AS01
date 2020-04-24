package com.example.as01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText h;
    private EditText w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void show(View view) {

        findViews();
     //commit 測試
        double w_value = Double.parseDouble(w.getText().toString());
        double h_value = Double.parseDouble(h.getText().toString());
        double bmi = w_value / (h_value / 100.0 * h_value / 100.0);
        DecimalFormat df = new DecimalFormat("#.##");

        TextView b = findViewById(R.id.tv_showbmi);

        String msg;
        if (bmi<18.5){
            msg="體重過輕";
            //Toast.makeText(this, "都不吃飯是要作仙嗎 您體重過輕", Toast.LENGTH_LONG).show();
        }
        else if (bmi>24){
            msg="體重過重";
            //Toast.makeText(this, "最近吃太好囉 您體重過重", Toast.LENGTH_SHORT).show();
        }
        else {msg="體重正常";
            //Toast.makeText(this, "老爺安康 賀喜夫人 體重正常", Toast.LENGTH_SHORT).show();
        }

            b.setText(name.getText().toString() + "你的BMI是\n" + df.format(bmi) + msg);
    }

    private void findViews() {
        name = findViewById(R.id.ed_name);
        h = (EditText) findViewById(R.id.ed_height);
        w = (EditText) findViewById(R.id.ed_weight);
    }

    public void NextPage(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("height",h.toString());
        bundle.putString("weight", w.toString());
        bundle.putString("name",name.toString());


        Intent intent = new Intent(this, ShowBMI.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
