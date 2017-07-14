package com.example.darntoncm.yylit;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Selection;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gwc.yylit.R;
import com.picture.PhotoActivity;

import com.example.gwc.yylit.R;

import java.util.Random;

public class SelectionActivity extends AppCompatActivity {
    static String TAG = "SelectionActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

// Create Activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

// set title to string from Main Activity
        Intent getTitle = getIntent();
        String title = getTitle.getStringExtra("title_string");
        TextView myAwesomeTextView = (TextView)findViewById(R.id.categoryTitle);
        myAwesomeTextView.setText(title);
// get name of category to draw pictures from
        Intent getCategoryNameFromEllie = getIntent();
        String arrayName = getCategoryNameFromEllie.getStringExtra("array_name");


//        String arrayName = "foodIds";

        final GridView gridview = (GridView) findViewById(R.id.gridview);
        final ImageAdapter myImageAdapter = new ImageAdapter(this);
        myImageAdapter.setCategory(arrayName);

        gridview.setAdapter(myImageAdapter);


// initiate random generator button, set on click method
        Button btnRandomGenerate = (Button) (findViewById(R.id.btnRandomGenerate));
        btnRandomGenerate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Log.d("TAG", "Random Generation");
// randomly generate image
                Intent getCategoryNameFromEllie = getIntent();
                String arrayName2 = getCategoryNameFromEllie.getStringExtra("array_name");

                TypedArray imgs = getResources().obtainTypedArray(R.array.apptour);

                if(arrayName2.equals("foodIds")) {
//                    Log.d("TAG13", "Food");
                      imgs = getResources().obtainTypedArray(R.array.FoodArray);
                } else if(arrayName2.equals("workIds")) {
                      imgs = getResources().obtainTypedArray(R.array.WorkArray);
                } else if(arrayName2.equals("technologyIds")) {
                      imgs = getResources().obtainTypedArray(R.array.TechArray);
                } else if(arrayName2.equals("commuteIds")) {
                      imgs = getResources().obtainTypedArray(R.array.CommuteArray);
                } else if(arrayName2.equals("familyIds")) {
                      imgs = getResources().obtainTypedArray(R.array.FamilyArray);
                } else if(arrayName2.equals("waterIds")) {
                      imgs = getResources().obtainTypedArray(R.array.WaterArray);
                } else {
//                    Log.d("TAG14", "ITS NOT WORKING");

                }
                Random rand = new Random();
                int rndInt = rand.nextInt(imgs.length());
//                Log.d("TAG13", "Random:" + rndInt);
                int resID = imgs.getResourceId(rndInt, 0);
                String randomID = getResources().getResourceEntryName(resID);
//                Log.d("TAG2", randomID);
// send image ID to Photo Activity
                Intent sendRandomPic = new Intent(SelectionActivity.this, PhotoActivity.class);
                sendRandomPic.putExtra("pic_name", resID);

                startActivity(sendRandomPic);

            }
       });

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int iii, long id) {
                int position = (int) v.getTag();
//                Log.d("TAG4", "position:" + position);
                int drawableName = myImageAdapter.getDrawableName(position);
//                Log.d("TAG10", "drawable:" + drawableName);

                String picID = getResources().getResourceEntryName(drawableName);
//                Log.d("TAG12", "image name:" + picID);

// send drawableName (id number)

                Intent sendSelectedPic = new Intent(SelectionActivity.this, PhotoActivity.class);
                sendSelectedPic.putExtra("pic_name", drawableName);
                startActivity(sendSelectedPic);
            }
        });
    }

}

