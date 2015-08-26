package com.karinaco.ui_xml_class;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by haniyeh on 21/08/15.
 */
public class MainMenuAdapter extends BaseExpandableListAdapter {

    String[] groups;
    ArrayList<String[]> children;
    Context context;
    LayoutInflater li;


    public MainMenuAdapter(Context context, String[] groups, ArrayList<String[]> children) {
        this.groups = groups;
        this.children = children;
        this.context = context;
        li = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getGroupCount() {
        return groups.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return children.get(groupPosition).length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return children.get(groupPosition)[childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return groupPosition * 10 + childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View v, ViewGroup parent) {
        v = li.inflate(R.layout.group_item_expandable, null);
        TextView tv = (TextView) v.findViewById(R.id.tvTitle);
        tv.setText(groups[groupPosition]);
        return v;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View v, ViewGroup parent) {
        v = li.inflate(R.layout.child_item_expandable, null);
        TextView tv = (TextView) v.findViewById(R.id.tvTitle);
        tv.setText(children.get(groupPosition)[childPosition]);
        return v;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
