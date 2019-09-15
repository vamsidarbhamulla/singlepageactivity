package com.example.singlepageactivityproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private static String IMG_URL = "https://www.gstatic.com/webp/gallery/1.jpg";

    private TextView topBartext;
    private ImageView rlImageView;
    private ImageView flImageView;
    private TextView collapsibleDescription;
    private int counter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topBartext = findViewById(R.id.main_s_l_r1_text);
        rlImageView = findViewById(R.id.main_s_l_r2_image);
        flImageView = findViewById(R.id.main_s_l_f_image);
        collapsibleDescription = findViewById(R.id.main_s_l_l1_desc);
        setTopBarText();
        setRelativeLayoutImageFromInternet();
        collapsibleTextViews();
        setFrameLayoutImage();
        counter = 0;
        buttonCounterToast();
    }

    private void setTopBarText() {
        topBartext.setText(topBartext.getText()+ " from java");
    }

    private void setRelativeLayoutImageFromInternet(){
        Picasso.get()
                .load(IMG_URL)
                .into(rlImageView);

        /*try {
            Uri uri = Uri.parse("https://www.gstatic.com/webp/gallery/1.jpg");
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
            rlImageView.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    private void collapsibleTextViews() {
        View img = findViewById(R.id.main_s_l_l1_image);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(collapsibleDescription.getVisibility() == View.GONE) {
                    view.setBackgroundResource(android.R.drawable.arrow_down_float);
                    view.setPadding(0,0,20,0);
                    collapsibleDescription.setVisibility(View.VISIBLE);
                } else {
                    view.setBackgroundResource(android.R.drawable.arrow_up_float);
                    view.setPadding(0,0,20,0);
                    collapsibleDescription.setVisibility(View.GONE);
                }
            }
        });
    }

    private void setFrameLayoutImage() {
        Picasso.get()
                .load(IMG_URL)
                .into(flImageView);
    }

    private void buttonCounterToast() {
        Button hitMe = findViewById(R.id.main_s_l_r3_hitme_btn);
        hitMe.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtnToast(counter++);
            }
        });

    }

    private void setBtnToast(int counter) {
        Toast toast = Toast.makeText(this,
                "Button hit counter is: "+ counter, Toast.LENGTH_SHORT);
        if(toast != null) {
            toast.show();
        }
    }
}
