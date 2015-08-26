package com.karinaco.ui_xml_class;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements ExpandableListView.OnChildClickListener {

    ExpandableListView expControls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expControls = (ExpandableListView) findViewById(R.id.expControls);
        expControls.setOnChildClickListener(this);
        String[] groups = {"View Groups", "View Controls"};
        ArrayList<String[]> children = new ArrayList<String[]>();
        String[] viewGroupChildren = {"Linear Layout", "Frame Layout", "Table Layout",
                "Relative Layout", "Scroll View", "List View", "Grid View", "include", "Radio Group"};
        String[] viewControlChildren = {"Text View", "Edit Text", "Button",
                "Image Button", "Image View", "Check Box", "Toggle Button", "Radio Button",
                "Progress Bar", "Spinner", "Switch", "Seek Bar", "Rating Bar", "Web View"};
        children.add(viewGroupChildren);
        children.add(viewControlChildren);
        MainMenuAdapter adapter = new MainMenuAdapter(this, groups, children);
        expControls.setAdapter(adapter);

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

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        Intent i = new Intent(this, ShowLayouts.class);
        i.putExtra("g_pos", groupPosition);
        i.putExtra("ch_pos", childPosition);
        startActivity(i);

        return false;
    }
}
