package com.example.darntoncm.yylit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.gwc.yylit.R;

import static com.example.gwc.yylit.R.id.btnCommute;
import static com.example.gwc.yylit.R.id.btnFamily;
import static com.example.gwc.yylit.R.id.btnTecnology;
import static com.example.gwc.yylit.R.id.btnWork;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);

        Intent changeScreen = new Intent(MainActivity.this, SelectionActivity.class);
        changeScreen.putExtra("title_string", "Choice");

        Button btnFood = (Button) findViewById(R.id.btnFood);
        btnFood.setOnClickListener(new btnFood.onClickListener());{
                String Choice = "Food";
                String title_string = "foodChoice";
                startActivity(changeScreen);
            }
        }

        Button btnWork = (Button) findViewById(R.id.btnWork);
        btnWork.setOnClickListener(new btnWork.onClickListener());{
                String Choice = "Work";
                String title_string = "workChoice";
                startActivity(changeScreen);
            }
        }

        Button btnTechnology = (Button) findViewById(R.id.btnTecnology);
        btnTechnology.setOnClickListener(new btnTechnology.onClickListener());{
            public void onClick();{
                String Choice = "Technology";
                String title_string = "technologyChoice";
                startActivity(changeScreen);
            }
        }

        Button btnFamily = (Button) findViewById(R.id.btnFamily);
        btnFamily.setOnClickListener(new btnFamily.onClickListener());{
            public void onClick();{
                String Choice = "Family";
                String title_string = "familyChoice";
                startActivity(changeScreen);
            }
        }

        Button btnCommute = (Button) findViewById(R.id.btnCommute);
        btnCommute.setOnClickListener(new btnCommute.onClickListener());{
            public void onClick();{
                String Choice = "Commute";
                String title_string = "commuteChoice";
                startActivity(changeScreen);
            }
        }

    }


}
