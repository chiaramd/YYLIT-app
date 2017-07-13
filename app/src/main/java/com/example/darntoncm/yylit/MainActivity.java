package com.example.darntoncm.yylit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gwc.yylit.R;

import static com.example.gwc.yylit.R.id.btnFood;
import com.example.gwc.yylit.R.id.btnCommute;
import com.example.gwc.yylit.R.id.btnFamily;
import com.example.gwc.yylit.R.id.btnTechnology;
import com.example.gwc.yylit.R.id.btnWork;

public class MainActivity extends AppCompatActivity {

    Intent changeScreen = new Intent(MainActivity.this, SelectionActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFood = (Button) findViewById(R.id.btnFood);
        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();
//                String FOOD = "@id/foodChoice";
//                changeScreen.putExtra("title_string", FOOD);
            }
        });

        Button btnWork = (Button) findViewById(R.id.btnWork);
        btnWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.startActivity(changeScreen);
                String WORK = "@id/workChoice";
                changeScreen.putExtra("title_string", WORK);
            }
        });

        Button btnTechnology = (Button) findViewById(R.id.btnTecnology);
        btnTechnology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.startActivity(changeScreen);
                String TECHNOLOGY = "@id/technologyChoice";
                changeScreen.putExtra("title_string", TECHNOLOGY);
            }
        });

        Button btnFamily = (Button) findViewById(R.id.btnFamily);
        btnFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.startActivity(changeScreen);
                String FAMILY = "@id/familyChoice";
                changeScreen.putExtra("title_string", FAMILY);
            }
        });

        Button btnCommute = (Button) findViewById(R.id.btnCommute);
        btnCommute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.startActivity(changeScreen);
                String COMMUTE = "@id/commuteChoice";
                changeScreen.putExtra("title_string", COMMUTE);
            }
        });

    }
}
