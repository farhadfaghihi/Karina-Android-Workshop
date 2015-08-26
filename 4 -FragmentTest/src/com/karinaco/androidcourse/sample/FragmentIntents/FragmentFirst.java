package com.karinaco.androidcourse.sample.FragmentIntents;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Farhad on 8/25/2015.
 */
public class FragmentFirst extends Fragment
{
    onClickFragmentFirst listenerClick ;

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            listenerClick = (onClickFragmentFirst)activity ;
        }

        catch (ClassCastException exc)
        {
            Toast.makeText(activity,"Exception happened !",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View fragmentView = inflater.inflate(R.layout.frg_first, container, false);

        TextView textView = (TextView)fragmentView.findViewById(R.id.frg_first_tvTile);

        textView.setText("This is Fragment First");


        textView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                listenerClick.textViewClicked("Message from Fragment First");
            }
        });

        return fragmentView;
    }

    public interface onClickFragmentFirst
    {
        void textViewClicked(String message) ;
    }
}