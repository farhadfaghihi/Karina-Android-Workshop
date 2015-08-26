package com.karinaco.androidcourse.sample.FragmentIntents;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Farhad on 8/25/2015.
 */
public class FragmentSecond extends Fragment
{
    private String message ;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.frg_first, container, false);

        TextView textView = (TextView)fragmentView.findViewById(R.id.frg_first_tvTile);

        textView.setText(getMessage());


        return fragmentView;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}