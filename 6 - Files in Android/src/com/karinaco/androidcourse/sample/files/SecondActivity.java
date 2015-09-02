package com.karinaco.androidcourse.sample.files;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Farhad on 9/1/2015.
 */
public class SecondActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_second);

        TextView textView = (TextView)findViewById(R.id.textview);

        /**
         * Reading the files from External Storage
         */
        try
        {
            File file = new File(Environment.getExternalStorageDirectory() + File.separator + "karina-file-ext.txt");

            if(file.exists())
            {
                FileReader fileReader = new FileReader(file);

                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line ;

                String fileContent = "" ;

                while ((line = bufferedReader.readLine())!= null)
                {
                    fileContent += line ;
                }

                textView.setText(fileContent);

                fileReader.close();
                bufferedReader.close();

            }
            else
            {
                textView.setText("File does not exist");
            }

        }

        catch (IOException ioExc)
        {
            textView.setText("IOException happened : " + "\r\n" + ioExc.getMessage());
        }




    }
}