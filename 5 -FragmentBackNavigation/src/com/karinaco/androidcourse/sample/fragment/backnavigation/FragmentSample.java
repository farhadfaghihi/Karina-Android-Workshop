package com.karinaco.androidcourse.sample.fragment.backnavigation;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Farhad on 8/30/2015.
 */
public class FragmentSample extends Fragment
{
    private Activity activity ;
    private String message ;

    public FragmentSample()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
    {
        activity = getActivity() ;

        View rootView = inflater.inflate(R.layout.frg_my,container,false);

        TextView tvMessage = (TextView)rootView.findViewById(R.id.frg_textview_message);

        tvMessage.setText(getMessage());

        tvMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentSample fragmentSample = new FragmentSample();
                fragmentSample.setMessage("New Child Fragment");
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(container.getId(),fragmentSample);
                fragmentTransaction.commit();
            }
        });





        return rootView ;
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
