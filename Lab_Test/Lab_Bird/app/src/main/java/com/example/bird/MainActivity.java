package com.example.bird;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private int[] imageResources = {R.drawable.b1, R.drawable.b2, R.drawable.b3,R.drawable.b4, R.drawable.b5, R.drawable.b6,R.drawable.b7,R.drawable.b8};
    //private int[] imageResources = {R.drawable.image1, R.drawable.image2, R.drawable.image3};
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        // Start initial animation
        animateImage(imageResources[currentIndex]);
    }

    private void animateImage(int imageResource) {
        // Load animation
        Animation fadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                // Load next image and apply animation
                currentIndex = (currentIndex + 1) % imageResources.length; // Wrap around to the beginning if reached the end
                animateImage(imageResources[currentIndex]);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        // Load image and apply animation
        imageView.setImageResource(imageResource);
        imageView.startAnimation(fadeIn);
    }
}