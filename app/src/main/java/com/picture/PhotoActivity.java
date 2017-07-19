package com.picture;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
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

import com.example.gwc.yylit.R;

import java.net.URL;
import java.util.Random;

import static android.R.color.white;
import static android.graphics.Paint.EMBEDDED_BITMAP_TEXT_FLAG;

public class PhotoActivity extends AppCompatActivity {


    public Button btnCaption;
    Context context = this;

    Bitmap anImage;
    String picID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        EditText caption = (EditText) findViewById(R.id.edittext);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);


        btnCaption=(Button) findViewById(R.id.btnCaption);

        btnCaption.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("TAGJDKAL", "btnCaption is working");

                showInputDialog();
            }
        });

        ImageView myImage = (ImageView) findViewById(R.id.imageView);

        //CHECK IF WORKS WITH OTHER ACTIVITY!!!
        Intent getimage = getIntent();
        int variable = getimage.getIntExtra("pic_name",0);  //add parameters
        picID = getResources().getResourceEntryName(variable);


        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), variable);
        anImage = ((BitmapDrawable) drawable).getBitmap();


        myImage.setImageDrawable(drawable);


        registerForContextMenu(myImage);

    }


    protected void showInputDialog() {
        LayoutInflater layoutInflater = LayoutInflater.from(PhotoActivity.this);
        View promptView = layoutInflater.inflate(R.layout.input_caption, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PhotoActivity.this);
        Log.i("TAGEJKLSLDKF", "setView to promptView in alertDialogBuilder");


        final EditText editText = (EditText) findViewById(R.id.edittext);

        alertDialogBuilder.setView(promptView);

        alertDialogBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                String name = editText.toString();
                btnCaption.setVisibility(View.INVISIBLE);
//                URL url = new URL(name);
//                Drawable captionDraw = new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(url.openConnection().getInputStream()));
                Canvas c = new Canvas(anImage);
                Paint White = new Paint();
                int myColor = ContextCompact.getColor(white);
                White.setTypeface(Typeface )
                White.setColor(myColor);
                White.setFlags(EMBEDDED_BITMAP_TEXT_FLAG);

                Bitmap result = Bitmap.createBitmap(anImage.getWidth(), anImage.getHeight(), anImage.getConfig());
                Canvas canvas = new Canvas(result);
                canvas.drawBitmap(anImage, 0f, 0f, null);
                canvas.drawText(name, 10, 10, White);
                return result;

                c.drawText(name, 100, 100, White);
                c.setBitmap(anImage);
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
                btnCaption.setVisibility(View.INVISIBLE);
            }
        });
        alertDialogBuilder.show();
    }
    Drawable d = new BitmapDrawable(getResources(), anImage);

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
//        Log.d("TAG22", "menu created");

    }
    public boolean onContextItemSelected(MenuItem item) {
//        Log.d("TAG23", "item selected");
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();



//        Log.d("TAG24", "info retrieved");
        switch (item.getItemId()) {
            case R.id.save_to_gallery:
                ActivityCompat.requestPermissions(PhotoActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);


//                Log.d("TAG21", "case1");

                break;
            case R.id.send_to_friends:

                Intent picMessageIntent = new Intent(android.content.Intent.ACTION_SEND);
                picMessageIntent.setType("image/jpeg");
                Log.d("TAG40", picID);

                Uri imageUri = Uri.parse("android.resource://com.example.gwc.yylit/drawable/" + picID);
                picMessageIntent.putExtra(Intent.EXTRA_STREAM, imageUri);

                startActivity(Intent.createChooser(picMessageIntent, "Share images to..."));



                break;
//                deleteNote(info.id);
        }
        return super.onContextItemSelected(item);
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
    private void saveImageToExternalStorage(Bitmap finalBitmap) {
//        Log.d("TAG20", "saveImageToExternalStorage");
//        String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();
//        File myDir = new File(root + "/saved_images_1");
//        myDir.mkdirs();
        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        String fname = "Image-" + n + ".jpg";
        Log.d("TAG30", fname);

        String description = "this is a description";
        MediaStore.Images.Media.insertImage(getContentResolver(), anImage, fname, description);



        // Tell the media scanner about the new file so that it is
        // immediately available to the user.
//        MediaScannerConnection.scanFile(this, new String[]{file.toString()}, null,
//                new MediaScannerConnection.OnScanCompletedListener() {
//                    public void onScanCompleted(String path, Uri uri) {
//                        Log.i("ExternalStorage", "Scanned " + path + ":");
//                        Log.i("ExternalStorage", "-> uri=" + uri);
//                    }
//                });
    }

}