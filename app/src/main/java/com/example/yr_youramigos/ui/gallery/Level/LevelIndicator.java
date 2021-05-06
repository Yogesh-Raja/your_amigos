package com.example.yr_youramigos.ui.gallery.Level;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.yr_youramigos.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class LevelIndicator extends AppCompatActivity {
    private TextView title,percent,lastcheck;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_indicator);
        title=findViewById(R.id.title);
        percent=findViewById(R.id.size);
        lastcheck=findViewById(R.id.last);
        progressBar=findViewById(R.id.progress);
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        String formattedDate = df.format(c);
        lastcheck.setText("Last Check : "+formattedDate);
        title.setText(Data.getTitle());
        progressBar.setProgress(Data.getProgress());

    }
}