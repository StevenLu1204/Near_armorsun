package com.example.jay.fragmentbasics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SettingActivity extends AppCompatActivity {
    /*
        * the file  pro_field_list_child.xml define the layout of the professional field subtitles
        * the file  pro_field_list_parent.xml define the layout of the professional field titles
    */

    ExpandableListView proFieldListView;
    HashMap<String,List<String>> proField;
    List<String> proFieldDetail;//professional field title and subtitle
    proFieldAdapter adapter;//an aadapter link the data and expandable listview

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        proFieldListView=(ExpandableListView)findViewById(R.id.proFieldListView);
        proField=proFieldDataProvider.getInfo();//get the data
        proFieldDetail=new ArrayList<String>(proField.keySet());//put the data into the hashmap
        adapter=new proFieldAdapter(this,proField,proFieldDetail);
        proFieldListView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_setting, menu);
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
