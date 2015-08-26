package com.karinaco.androidcourse.intenttest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Farhad on 8/25/2015.
 */
public class ActivitySecond extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_second);

        Intent intent = getIntent();

        String value = intent.getStringExtra(Consts.KEY);

        TextView tvTwo = (TextView)findViewById(R.id.tvTwo);

        tvTwo.setText(value);

    }
}