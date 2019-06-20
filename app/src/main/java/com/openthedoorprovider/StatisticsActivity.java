package com.openthedoorprovider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class StatisticsActivity extends AppCompatActivity {

   // private BarChart chart;
    private SeekBar seekBarX, seekBarY;
    private TextView tvX, tvY;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
    }
}
