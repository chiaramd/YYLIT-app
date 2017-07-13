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
        return mThumbIds.length;
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

    private Integer[] mThumbIds = {
            R.drawable.hunger1, R.drawable.hunger2
    };


    
    private Integer[] foodIds = {
            R.drawable.hunger1, R.drawable.hunger2
    };
}
