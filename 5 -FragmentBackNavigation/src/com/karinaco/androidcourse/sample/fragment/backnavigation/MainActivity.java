package com.karinaco.androidcourse.sample.fragment.backnavigation;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity
{
    FragmentManager fragmentManager ;

    Button btnOne , btnTwo , btnThree ;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        fragmentManager = getFragmentManager();

        btnOne = (Button)findViewById(R.id.btn_frg_one);
        btnTwo = (Button)findViewById(R.id.btn_frg_two);
        btnThree = (Button)findViewById(R.id.btn_frg_three);

        btnOne.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentSample fragmentSample = new FragmentSample();
                fragmentSample.setMessage("Fragment One");
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragmentSample);
                fragmentTransaction.addToBackStack("one");
                fragmentTransaction.commit();
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentSample fragmentSample = new FragmentSample();
                fragmentSample.setMessage("Fragment Two");
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragmentSample);
                fragmentTransaction.addToBackStack("two");
                fragmentTransaction.commit();
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentSample fragmentSample = new FragmentSample();
                fragmentSample.setMessage("Fragment Three");
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container,fragmentSample);
                fragmentTransaction.addToBackStack("three");
                fragmentTransaction.commit();
            }
        });

    }

    @Override
    public void onBackPressed()
    {
        if(fragmentManager.getBackStackEntryCount() == 0)
        {
            btnOne.setBackgroundResource(R.color.white);
            btnTwo.setBackgroundResource(R.color.white);
            btnThree.setBackgroundResource(R.color.white);

        }

        else
        {
            fragmentManager.popBackStack();
        }

        //super.onBackPressed();
    }
}
