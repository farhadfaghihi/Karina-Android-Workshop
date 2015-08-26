package com.karinaco.androidcourse.intenttest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityFirst extends Activity implements Walk
{
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView tv = (TextView)findViewById(R.id.tvOne);

        tv.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("http://www.example.com"));
                startActivity(new Intent(ActivityFirst.this,ActivitySecond.class));

                Intent intent1 = new Intent();

//
//                Intent intentSecond = new Intent(ActivityFirst.this, ActivitySecond.class);
//
//                intentSecond.putExtra(Consts.KEY,"Android Course");
//
//                startActivity(intentSecond);
            }
        });


    }

    @Override
    public void walk() {

    }
}
