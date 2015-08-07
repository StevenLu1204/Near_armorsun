package com.example.jay.fragmentbasics;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ExpandableListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SettingActivity extends AppCompatActivity {
    /*
    * the file  pro_field_list_child.xml defines the layout of the professional field subtitles
    * the file  pro_field_list_parent.xml defines the layout of the professional field titles
    */

    ExpandableListView proFieldListView;
    HashMap<String,List<String>> proField;
    List<String> proFieldDetail;        //stores the professional field data(titles and subtitles)(check the proFieldDataProvider.java)
    proFieldAdapter adapter;            //an adapter linked the data and expandable listview

    AlertDialog.Builder proFieldDialogBuilder;
    AlertDialog proFieldDialog;
    Button btnProField;

    ListView LVSelected;                                        //a listview displays what you select
    ArrayList<String> selectedItems=new ArrayList<String>();    //an arraylist stores what you select
    ArrayAdapter slctItemsAdapter;                              //an adapter links data and listview

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        //an expandable List View displays the professional fields
        proFieldListView= new ExpandableListView(this);    //the expandable listview displays the professional fields
        proField=proFieldDataProvider.getInfo();                      //get the data
        proFieldDetail=new ArrayList<String>(proField.keySet());    //get the proField-hashmap key and put it into the proFieldDetail-ArrayList
        adapter=new proFieldAdapter(this,proField,proFieldDetail);  //put proField-hashmap and the proFieldDetail-ArrayList into the adapter
        proFieldListView.setAdapter(adapter);

        //initialize the dialog contain the professional field
        proFieldDialogBuilder=new AlertDialog.Builder(SettingActivity.this);
        proFieldDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                proFieldDialog.dismiss();
            }
        });
        proFieldDialogBuilder.setView(proFieldListView);
        proFieldDialogBuilder.setTitle("Please select : ");
        proFieldDialog=proFieldDialogBuilder.create();

        //initialize the listview  which displays the selected items
        LVSelected=(ListView)findViewById(R.id.listViewSelected);
        slctItemsAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,selectedItems);
        LVSelected.setAdapter(slctItemsAdapter);

        btnProField =(Button)findViewById(R.id.btnProField);
        btnProField.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                proFieldDialog.show();
            }
        });

        /*
        *  a listener checks which item(child) is selected
        *  if an item(child) is selected it will toast which item is selected and add to the listview under the professional field.
        */

        proFieldListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getBaseContext(), proField.get(proFieldDetail.get(groupPosition)).get(childPosition) + " is selected.", Toast.LENGTH_SHORT).show();

                selectedItems.add(proField.get(proFieldDetail.get(groupPosition)).get(childPosition));
                slctItemsAdapter.notifyDataSetChanged();
                return false;
            }
        });
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

    public void btnSave_click(View view){
        Intent intent = new Intent(this,UserInfo.class);
        startActivity(intent);
        finish();
    }
}

