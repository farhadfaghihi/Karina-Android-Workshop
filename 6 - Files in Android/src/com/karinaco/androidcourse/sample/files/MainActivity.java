package com.karinaco.androidcourse.sample.files;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);



        try
        {
            String data = "Karina Android Course - Data Data Storage Test" ;

            //File file = new File(Environment.getExternalStorageDirectory() + File.separator +"karina-file.txt" );
            //File file = new File(Environment.getDataDirectory() + File.separator +"karina-file.txt" );

            File file = new File(Environment.getDataDirectory() + File.separator +"karina-file-data.txt" );

            file.createNewFile() ;

            FileOutputStream fileOutputStream = new FileOutputStream(file);

            fileOutputStream.write(data.getBytes());

            fileOutputStream.close();

            Toast.makeText(this,"File Created Successfully",Toast.LENGTH_SHORT).show();


        }

        catch (IOException ioExc)
        {
            Toast.makeText(this,"IOException happened",Toast.LENGTH_SHORT).show();
        }



    }
}
