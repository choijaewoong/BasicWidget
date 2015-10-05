package com.torerov.basicwidget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

public class ProgressActivity extends AppCompatActivity {

    private static final String TAG = "ProgressActivity";
    ProgressBar progressBar;
    SeekBar seekBar;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        progressBar = (ProgressBar)findViewById(R.id.progressBar2);
        progressBar.setMax(15324);

        seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            private static final int NOT_CHANGED = -1;
            int progress = NOT_CHANGED;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i(TAG, "progress : " + progress + ", fromUser : " + fromUser);
                if(fromUser) {
                    this.progress = progress;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                progress = NOT_CHANGED;

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(progress != NOT_CHANGED){
                    Toast.makeText(ProgressActivity.this, "Progress Changed : " + progress, Toast.LENGTH_SHORT);
                }

            }
        });
        seekBar.setMax(1000);


        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.i(TAG, "Rating changed : " + rating);
            }
        });

        Button button = (Button)findViewById(R.id.btn_progvar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int progress = progressBar.getProgress();
                progress += 500;
                progressBar.setProgress(progress);
                progressBar.setSecondaryProgress(10240);
            }
        });
    }
}
