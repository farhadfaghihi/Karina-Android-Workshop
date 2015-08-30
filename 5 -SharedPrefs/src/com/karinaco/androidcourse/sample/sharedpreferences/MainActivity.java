package com.karinaco.androidcourse.sample.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView textView ;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        textView = (TextView)findViewById(R.id.textview);
    }

    @Override
    public void onResume()
    {
        SharedPreferences sharedPrefs = getSharedPreferences("myprefs", MODE_WORLD_READABLE);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("my_key","Karina Android Course");
        editor.putInt("my_int",2522);
        editor.commit();

        String my_key = sharedPrefs.getString("my_key", "No value added yet !");
        textView.setText(my_key);
    }

}
