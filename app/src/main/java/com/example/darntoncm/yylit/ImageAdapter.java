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

import static android.R.attr.drawable;
import static android.R.attr.id;

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
        if(category.equals("foodIds")) {
//            Log.d("TAG13", "Food");
            return foodIds.length;
        } else if(category.equals("workIds")) {
            return workIds.length;
        } else if(category.equals("technologyIds")) {
            return technologyIds.length;
        } else if(category.equals("commuteIds")) {
            return commuteIds.length;
        } else if(category.equals("familyIds")) {
            return familyIds.length;
        } else if(category.equals("waterIds")) {
            return waterIds.length;
        } else {
//            Log.d("TAG13", "ITS NOT WORKING");
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
        if(category.equals("foodIds")) {
            return foodIds[position];
        } else if(category.equals("workIds")) {
            return workIds[position];
        } else if(category.equals("technologyIds")) {
            return technologyIds[position];
        } else if(category.equals("commuteIds")) {
            return commuteIds[position];
        } else if(category.equals("familyIds")) {
            return familyIds[position];
        } else if(category.equals("waterIds")) {
            return waterIds[position];
        } else {
            return 0;
        }

    }


    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView==null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(300,300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,8,8,8);
        } else {
            imageView=(ImageView) convertView;
        }

        imageView.setTag(Integer.valueOf(position));


        if(category.equals("foodIds")) {
            imageView.setImageResource(foodIds[position]);
        } else if(category.equals("workIds")) {
            imageView.setImageResource(workIds[position]);
        } else if(category.equals("technologyIds")) {
            imageView.setImageResource(technologyIds[position]);
        } else if(category.equals("commuteIds")) {
            imageView.setImageResource(commuteIds[position]);
        } else if(category.equals("familyIds")) {
            imageView.setImageResource(familyIds[position]);
        } else if(category.equals("waterIds")) {
            imageView.setImageResource(waterIds[position]);
        }
        return imageView;
    }


    private Integer[] foodIds = {
            R.drawable.hunger1, R.drawable.hunger2, R.drawable.hunger3, R.drawable.hunger4, R.drawable.hunger5, R.drawable.hunger6,
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
    private Integer[] familyIds = {
            R.drawable.family1, R.drawable.family2, R.drawable.family3, R.drawable.family4, R.drawable.family5, R.drawable.family6,
            R.drawable.family7, R.drawable.family8, R.drawable.family9, R.drawable.family10

    };
    private Integer technologyIds[] = {
            R.drawable.technology1, R.drawable.technology2, R.drawable.technology3, R.drawable.technology4, 
    };
    private Integer commuteIds[] = {
            R.drawable.commute1, R.drawable.commute2, R.drawable.commute3, R.drawable.commute4, R.drawable.commute5, R.drawable.commute6,
            R.drawable.commute7, R.drawable.commute8, R.drawable.commute9, R.drawable.commute10

    };


}
