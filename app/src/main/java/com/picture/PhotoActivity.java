package com.picture;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.darntoncm.yylit.MainActivity;
import com.example.gwc.yylit.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import static com.example.gwc.yylit.R.id.btnCaption;
import static com.example.gwc.yylit.R.id.edittext;
import static com.example.gwc.yylit.R.id.imageView;
import static com.example.gwc.yylit.R.string.caption;

public class PhotoActivity extends AppCompatActivity {

    public Button btnCaption;
    public TextView resultText;
    Bitmap anImage;

    protected void onCreate(Bundle savedInstanceState) {

        EditText caption = (EditText) findViewById(R.id.edittext);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        // components from main.xml
        btnCaption = (Button) findViewById(R.id.btnCaption);
        resultText = (TextView) findViewById(R.id.result);

        btnCaption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInputDialog();
            }
        });

        ImageView myImage = (ImageView) findViewById(R.id.imageView);

        //CHECK IF WORKS WITH OTHER ACTIVITY!!!
        Intent getimage = getIntent();
        int variable = getimage.getIntExtra("pic_name", 0);  //add parameters
        String picID = getResources().getResourceEntryName(variable);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), variable);

        anImage = ((BitmapDrawable) drawable).getBitmap();
        myImage.setImageDrawable(drawable);
        registerForContextMenu(myImage);
    }





        protected void showInputDialog() {

            // get prompts.xml view
            LayoutInflater layoutInflater = LayoutInflater.from(PhotoActivity.this);
            View promptView = layoutInflater.inflate(R.layout.input_caption, null);
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PhotoActivity.this);
            alertDialogBuilder.setView(promptView);

            final EditText editText = (EditText) promptView.findViewById(R.id.edittext);
            // setup a dialog window
            alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        resultText.setText(R.string.caption_Added);
                        String name = editText.getText().toString();

                        try {
                            URL url = new URL(name);
                            Drawable captiondraw = new BitmapDrawable(BitmapFactory.decodeStream(url.openConnection().getInputStream()));
                        } catch (Exception ex) {

                        }

                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        btnCaption.setVisibility(View.INVISIBLE);
                    }
                });

        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
            super.onCreateContextMenu(menu, view, menuInfo);
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu, menu);

        }

        public boolean onContextItemSelected(MenuItem item) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

            switch (item.getItemId()) {
                case R.id.save_to_gallery:
                    ActivityCompat.requestPermissions(PhotoActivity.this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);

                    break;
                case R.id.send_to_friends:
                    break;
            }
            ;
            return super.onContextItemSelected(item);
        }





    private void saveImageToExternalStorage(Drawable finalBitmap) {

        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        String fname = "Image-" + n + ".jpg";
        Log.d("TAG30", fname);

        String description = "this is a description";
        MediaStore.Images.Media.insertImage(getContentResolver(), anImage, fname, description);
    }




    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission granted and now can proceed
                    saveImageToExternalStorage(anImage);
                    Toast.makeText(getApplicationContext(), "Saved successfully. Check gallery.", Toast.LENGTH_SHORT).show();
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(PhotoActivity.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }
            // add other cases for more permissions
        }
    }
}
