package com.example.jay.fragmentbasics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static android.widget.ListView.*;

public class UserInfo extends AppCompatActivity {

    private ListView acceptedList;
    private ListView helpedList;
    private String[] accepted;
    private String[] helped;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        /*
                * the lists.xm file in vlaues/  list the  accepted list item and the helped list item
                * */
        //set the accepted litview
        accepted=getResources().getStringArray(R.array.accepted);
        acceptedList=(ListView)findViewById(R.id.listViewAccepted);
        ArrayAdapter<String> a =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,accepted);
        acceptedList.setAdapter(a);
        //set the helped listview
        helped=getResources().getStringArray(R.array.helped);
        helpedList=(ListView)findViewById(R.id.listViewHelped);
        ArrayAdapter<String> b=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,helped);
        helpedList.setAdapter(b);
        helpedList.setVisibility(INVISIBLE);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_info, menu);
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
    //when the accepted button i s pressed acceptedList will be visble and helpedList will hide
    public void btnAccepted_click(View view){
        acceptedList.setVisibility(ListView.VISIBLE);
        helpedList.setVisibility(ListView.INVISIBLE);
    }
    //when the helped button i s pressed acceptedList will hide and helpedList will be visble
    public void btnHelped_click(View view){
        helpedList.setVisibility(ListView.VISIBLE);
        acceptedList.setVisibility(ListView.INVISIBLE);
    }
    //when the setting button(an image button) is pressed start the settingactivity
    public void imgBtnSetting_click(View view){
        Intent intent=new Intent(this,SettingActivity.class);
        startActivity(intent);
    }
}
