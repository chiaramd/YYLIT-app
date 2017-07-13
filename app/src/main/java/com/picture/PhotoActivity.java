package com.picture;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.gwc.yylit.R;

import static com.example.gwc.yylit.R.id.imageView;

public class PhotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        ImageView myImage = (ImageView) findViewById(R.id.imageView);

        //CHECK IF WORKS WITH OTHER ACTIVITY!!!
        Intent getimage = getIntent();
        int variable = getimage.getIntExtra("pic_name",0);  //add parameters
        String picID = getResources().getResourceEntryName(variable);


        Drawable drawable = getDrawable(variable);
        myImage.setImageDrawable(drawable);








        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(PhotoActivity.this,
          android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);


    }
}









