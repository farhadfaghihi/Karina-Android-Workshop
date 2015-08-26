package com.karinaco.androidcourse.sample.FragmentIntents;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Toast;

public class MyActivity extends Activity implements FragmentFirst.onClickFragmentFirst
{
    /**
     * Called when the activity is first created.
     */

    Fragment fragmentCurrent = null ;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        FragmentFirst fragmentFirst = new FragmentFirst();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.frgContainer, fragmentFirst);

        fragmentTransaction.commit();

    }

    private void showMessage()
    {
        Toast.makeText(this,"Message from Fragment ",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void textViewClicked(String message)
    {
        FragmentSecond fragmentSecond = new FragmentSecond() ;
        fragmentSecond.setMessage(message);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.frgContainer, fragmentSecond);

        fragmentTransaction.commit();
    }
}
