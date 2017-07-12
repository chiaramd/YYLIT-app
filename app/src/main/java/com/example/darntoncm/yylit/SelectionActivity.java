package com.example.darntoncm.yylit;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.gwc.yylit.R;

import java.util.Random;

public class SelectionActivity extends AppCompatActivity {
    static String TAG = "SelectionActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

       Button btnRandomGenerate = (Button) (findViewById(R.id.btnRandomGenerate));
        btnRandomGenerate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i(TAG, "Random Generation");
                //code to randomly generate image
                ImageView img=(ImageView)findViewById(R.id.imageButton);

                final TypedArray imgs = getResources().obtainTypedArray(R.array.apptour);
                final Random rand = new Random();
                final int rndInt = rand.nextInt(imgs.length());
                final int resID = imgs.getResourceId(rndInt, 0);

//                Random rand = new Random();
//                int rndInt = rand.nextInt(52) + 1;
//                String drawableName = "hunger" + rndInt;
//                int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
                img.setImageResource(resID);
            }
       });

    }

}
