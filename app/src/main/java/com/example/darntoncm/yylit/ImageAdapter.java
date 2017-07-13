package com.example.darntoncm.yylit;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.gwc.yylit.R;
import com.picture.PhotoActivity;

import static android.R.attr.id;
import static com.example.gwc.yylit.R.array.apptour;

/**
 * Created by darntoncm on 7/11/17.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    public ImageAdapter(Context c) {
        mContext = c;
    }
    public int getCount() {
        return apptour.;
    }
    public Object getItem(int position) {
        return position;
    }
    public long getItemId(int position) {
        return id;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView==null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85,85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,8,8,8);
            imageView.setTag(Integer.valueOf(position));
//            imageButton.setAttribute(View_onClick, "imageSelected");

        } else {
            imageView=(ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);

//        Log.d("TAG3", mThumbIds[position]);
//
//        imageButton.setOnClickListener(new View.OnClickListener() {
//
//
//            SelectionActivity.imageSelected(mThumbIds[position]) ;
//
//        });

        return imageView;
    }

//    private Integer[] mThumbIds = {
//            R.drawable.hunger1, R.drawable.hunger2
//    };
    private Integer[] foodIds = {
            R.drawable.hunger1, R.drawable.hunger2, R.drawable.hunger3, R.drawable.hunger4, R.drawable.hunger5, R.drawable.hunger6
            R.drawable.hunger7, R.drawable.hunger8, R.drawable.hunger9, R.drawable.hunger10
    };
    private Integer[] workIds = {
            R.drawable.work1, R.drawable.work2, R.drawable.work3, R.drawable.work4, R.drawable.work5, R.drawable.work6,
            R.drawable.work7, R.drawable.work8, R.drawable.work9, R.drawable.work10

    };
    private Integer[] waterIds = {
            R.drawable.water1, R.drawable.water2, R.drawable.water3, R.drawable.water4, R.drawable.water5, R.drawable.water6,
            R.drawable.water7, R.drawable.water8, R.drawable.water9, R.drawable.water10
    };
    private Integer familyIds[] = {
            R.drawable.family1, R.drawable.family2, R.drawable.family3, R.drawable.family4, R.drawable.family5, R.drawable.family6,
            R.drawable.family7, R.drawable.family8, R.drawable.family9, R.drawable.family0    };
}
