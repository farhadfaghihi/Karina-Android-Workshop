package com.karinaco.ui_xml_class;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by haniyeh on 21/08/15.
 */
public class ShowLayouts extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int groupPosition = getIntent().getIntExtra("g_pos", 0);
        int childPosition = getIntent().getIntExtra("ch_pos", 0);

        switch (groupPosition) {
            case 0:
                switch (childPosition) {
                    case 0:
                        // Linear Layout
                        setContentView(R.layout.a01_linear_layout);
                        break;
                    case 1:
                        // Frame Layout
                        setContentView(R.layout.a02_frame_layout);
                        break;
                    case 2:
                        // Table Layout
                        setContentView(R.layout.a04_table_layout);
                        break;
                    case 3:
                        // Relative Layout
                        setContentView(R.layout.a03_relative_layout);
                        break;
                    case 4:
                        // Scroll View
                        setContentView(R.layout.a05_scroll_view);
                        break;
                    case 5:
                        // List View
                        setContentView(R.layout.s06_list_view);
                        break;
                    case 6:
                        // Grid View
                        //TODO data
                        setContentView(R.layout.s07_grid_view);
                        break;
                    case 7:
                        // include
                        //TODO actionbar
                        setContentView(R.layout.a06_include);
                        break;
                    case 8:
                        // Radio Group
                        setContentView(R.layout.s09_radio_group);
                        break;
                }
                break;
            case 1:
                switch (childPosition) {
                    case 0:
                        // Text View
                        setContentView(R.layout.a07_text_view);
                        break;
                    case 1:
                        // Edit Text
                        setContentView(R.layout.a08_edit_text);
                        break;
                    case 2:
                        // Button
                        setContentView(R.layout.a09_button);
                        break;
                    case 3:
                        // Image Button
                        setContentView(R.layout.a10_image_button);
                        break;
                    case 4:
                        // Image View
                        setContentView(R.layout.a11_image_view);
                        break;
                    case 5:
                        // Check Box
                        setContentView(R.layout.a13_check_box);
                        break;
                    case 6:
                        // Toggle Button
                        setContentView(R.layout.s16_toggle_button);
                        break;
                    case 7:
                        // Radio Button
                        setContentView(R.layout.a12_radio_button);
                        break;
                    case 8:
                        // Progress Bar
                        setContentView(R.layout.a14_progress_bar);
                        break;
                    case 9:
                        // Spinner
                        setContentView(R.layout.s19_spinner);
                        break;
                    case 10:
                        // Switch
                        setContentView(R.layout.s20_switch);
                        break;
                    case 11:
                        // Seek Bar
                        setContentView(R.layout.s21_seek_bar);
                        break;
                    case 12:
                        // Rating Bar
                        setContentView(R.layout.activity_main);
                        break;
                    case 13:
                        // Web View
                        setContentView(R.layout.activity_main);
                        break;
                }
                break;
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
