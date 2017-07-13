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
    public String category;
    public void setCategory(String category){
        this.category = category;

    }
    public int getCount() {
        if(category == "foodIds") {
            return foodIds.length;
        } else if(category == "workIds") {
            return workIds.length;
        } else if(category == "technologyIds") {
            return technologyIds.length;
        } else if(category == "commuteIds") {
            return commuteIds.length;
        } else if(category == "familyIds") {
            return familyIds.length;
        } else if(category == "waterIds") {
            return waterIds.length;
        } else {
            return 0;
        }
    }
    public Object getItem(int position) {
        return position;
    }
    public long getItemId(int position) {
        return id;
    }

    public int getDrawableName(int position) {
        if(category == "foodIds") {
            return foodIds[position];
        } else if(category == "workIds") {
            return workIds[position];
        } else if(category == "technologyIds") {
            return technologyIds[position];
        } else if(category == "commuteIds") {
            return commuteIds[position];
        } else if(category == "familyIds") {
            return familyIds[position];
        } else if(category == "waterIds") {
            return waterIds[position];
        } else {
            return 0;
        }

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



        if(category == "foodIds") {
            imageView.setImageResource(foodIds[position]);
        } else if(category == "workIds") {
            imageView.setImageResource(workIds[position]);
        } else if(category == "technologyIds") {
            imageView.setImageResource(technologyIds[position]);
        } else if(category == "commuteIds") {
            imageView.setImageResource(commuteIds[position]);
        } else if(category == "familyIds") {
            imageView.setImageResource(familyIds[position]);
        } else if(category == "waterIds") {
            imageView.setImageResource(waterIds[position]);
        }
        return imageView;
    }


    private Integer[] foodIds = {
            R.drawable.hunger1, R.drawable.hunger2
    };
    private Integer[] workIds = {
    };
    private Integer[] technologyIds = {
    };
    private Integer[] commuteIds = {
    };
    private Integer[] familyIds = {
    };
    private Integer[] waterIds = {
    };



}
