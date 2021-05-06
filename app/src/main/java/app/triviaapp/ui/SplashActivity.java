package app.triviaapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import app.triviaapp.R;
import app.triviaapp.helper.Helper;

public class SplashActivity extends AppCompatActivity {
    private ImageView ivSplash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ivSplash=findViewById(R.id.iv_splash);

        Log.d("MYDATES", "onCreate: dates "+ Helper.getCurrentDate());
        Animation aniSlide = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.image_zoom);
        ivSplash.startAnimation(aniSlide);

        //this will start splashfile for 2 sec and then move to next page for question .
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, Question1Activity.class));
                finish();
            }
        }, 2000);

    }
}