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
import android.widget.Toast;

import com.example.gwc.yylit.R;
import com.picture.PhotoActivity;

import com.example.gwc.yylit.R;

import java.util.Random;

public class SelectionActivity extends AppCompatActivity {
    static String TAG = "SelectionActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);


        Intent getCategoryNameFromEllie = getIntent();
        String arrayName = getCategoryNameFromEllie.getExtras("array_name");
//        String arrayName = "foodIds";


//        public static String arrayName = getCategoryNameFromEllie.getExtra("ELLIE--FILL IN THE ID HERE. IT SHOULD BE IN THE FORM OF foodIds, workIds, etc. BECAUSE BRIANA IS MAKING THOSE ARRAYS WITH IMAGE");

//        public static String test = "Hello World";

        Button btnRandomGenerate = (Button) (findViewById(R.id.btnRandomGenerate));
        final GridView gridview = (GridView) findViewById(R.id.gridview);
        final ImageAdapter myImageAdapter = new ImageAdapter(this);
        //get category from intent and pass to this function as a string
        myImageAdapter.setCategory(arrayName);

        gridview.setAdapter(myImageAdapter);


        Intent getTitle = getIntent();
        String title = getTitle.getExtras("title_string");


        btnRandomGenerate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                Log.d("TAG", "Random Generation");
                //code to randomly generate image
//                ImageView img=(ImageView)findViewById(R.id.imageButton);
//
                final TypedArray imgs = getResources().obtainTypedArray(R.array.apptour);
                final Random rand = new Random();
                final int rndInt = rand.nextInt(imgs.length());
                final int resID = imgs.getResourceId(rndInt, 0);
                String randomID = getResources().getResourceEntryName(resID);

                Log.d("TAG2", randomID);

//                Random rand = new Random();
//                int rndInt = rand.nextInt(52) + 1;
//                String drawableName = "hunger" + rndInt;
//                int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
//                img.setImageResource(resID);

                Intent sendRandomPic = new Intent(SelectionActivity.this, PhotoActivity.class);
                sendRandomPic.putExtra("pic_name", randomID);

                startActivity(sendRandomPic);

            }
       });

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int iii, long id) {
                int position = (int) v.getTag();
                Log.d("TAG4", "position=" + position);
                int drawableName = myImageAdapter.getDrawableName(position);
                Log.d("TAG10", "drawable:" + drawableName);

                String drawableNameString = Integer.toString(drawableName);
                Log.d("TAG11", drawableNameString);

                String picID = getResources().getResourceEntryName(drawableName);
                Log.d("TAG12", picID);

//                String selectedItem = parent.getItemAtPosition(position).toString();
//                Log.d("Tag3","selected item=" + selectedItem );
////                String idString = getResources().getResourceName(id);
//                ImageAdapter i = (ImageAdapter)parent.getAdapter();
//                long gridPicId = i.getItemId(position);
//                Log.d("TAG5.5", "long id:" + gridPicId);
//                int gridPicIntId = (int) gridPicId;
//                String gridPicName = v.getResources().getResourceEntryName(gridPicIntId);
//                Log.d("TAG6", "id:" + gridPicIntId);
//
//                Log.d("TAG7", gridPicName);
//
//
//                Object tagOfItem = v.getTag();
//                Log.d("TAG8", tagOfItem.toString());

                Intent sendSelectedPic = new Intent(SelectionActivity.this, PhotoActivity.class);
                sendSelectedPic.putExtra("pic_name", picID);
                startActivity(sendSelectedPic);
            }
        });






//        Button one = (Button) findViewById(R.id.gridview)
//
//        public void onClick(View v) {
//            switch (v.getId()) {
//                case R.id
//            }
//    }

//        Button btnRandomGenerate = (Button) (findViewById(R.id.btnRandomGenerate));
//        btnRandomGenerate.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
//
//                Log.d("TAG", "Random Generation");
//                //code to randomly generate image
////                ImageView img=(ImageView)findViewById(R.id.imageButton);
////
//                final TypedArray imgs = getResources().obtainTypedArray(R.array.apptour);
//                final Random rand = new Random();
//                final int rndInt = rand.nextInt(imgs.length());
//                final int resID = imgs.getResourceId(rndInt, 0);
//                String randomID = getResources().getResourceName(resID);
//
//
//                Log.d("TAG2", randomID);
////                Random rand = new Random();
////                int rndInt = rand.nextInt(52) + 1;
////                String drawableName = "hunger" + rndInt;
////                int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
////                img.setImageResource(resID);
//
//                Intent sendRandomPic = new Intent(SelectionActivity.this, PhotoActivity.class);
//                sendRandomPic.putExtra("pic_name", randomID);
//
//                startActivity(sendRandomPic);
//
//            }
//        });


    }

}

