package com.example.darntoncm.yylit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gwc.yylit.R;

import com.example.gwc.yylit.R.id.*;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Intent changeScreen = new Intent(MainActivity.this, SelectionActivity.class);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnFood = (Button) findViewById(R.id.btnFood);
        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FOOD = "I\'m hungry...";
                changeScreen.putExtra("title_string", FOOD);
                String foodIds = "foodIds";
                changeScreen.putExtra("array_name", foodIds);
                MainActivity.this.startActivity(changeScreen);
            }
          });

        Button btnWater = (Button) findViewById(R.id.btnWater);
        btnWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String WATER = "I\'m thirsty...";
                changeScreen.putExtra("title_string", WATER);
                String waterIds = "waterIds";
                changeScreen.putExtra("array_name", waterIds);
                MainActivity.this.startActivity(changeScreen);

            }
        });

        Button btnWork = (Button) findViewById(R.id.btnWork);
        btnWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String WORK = "Work is crushing my soul...";
                changeScreen.putExtra("title_string", WORK);
                String workIds = "workIds";
                changeScreen.putExtra("array_name", workIds);
                MainActivity.this.startActivity(changeScreen);
            }
        });

        Button btnTechnology = (Button) findViewById(R.id.btnTechnology);
        btnTechnology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String TECHNOLOGY = "My phone/laptop/tablet won\'t work...";
                changeScreen.putExtra("title_string", TECHNOLOGY);
                String technologyIds = "technologyIds";
                changeScreen.putExtra("array_name", technologyIds);
                MainActivity.this.startActivity(changeScreen);
            }
        });

        Button btnFamily = (Button) findViewById(R.id.btnFamily);
        btnFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String FAMILY = "My family is a nightmare...";
                changeScreen.putExtra("title_string", FAMILY);
                String familyIds = "familyIds";
                changeScreen.putExtra("array_name", familyIds);
                MainActivity.this.startActivity(changeScreen);
            }
        });

        Button btnCommute = (Button) findViewById(R.id.btnCommute);
        btnCommute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String COMMUTE = "This traffic is ridiculous...";
                changeScreen.putExtra("title_string", COMMUTE);
                String commuteIds = "commuteIds";
                changeScreen.putExtra("array_name", commuteIds);
                MainActivity.this.startActivity(changeScreen);
            }
        });

    }
}
