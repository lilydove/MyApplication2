package com.example.administrator.myapplication;

import android.content.Intent;
//import android.app.ActionBar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.administrator.myapplication.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the Activity of ActionBar
        ActionBar actionBar = getSupportActionBar();
        //Set the operating model of ActionBar
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        //Get rid of the head of Activity
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle("Tab 测试");
        //create Tab
        ActionBar.Tab tab1 = actionBar.newTab().setText("No1");
        ActionBar.Tab tab2 = actionBar.newTab().setText("No2");
        ActionBar.Tab tab3 = actionBar.newTab().setText("No3");
        //Add Listener for every Tab
        MyTabListener tab1Listener = new MyTabListener();
        tab1.setTabListener(tab1Listener);
        MyTabListener tab2Listener = new MyTabListener();
        tab2.setTabListener(tab2Listener);
        MyTabListener tab3Listener = new MyTabListener();
        tab3.setTabListener(tab3Listener);
        //Add Tab into ActionBar
        actionBar.addTab(tab1);
        actionBar.addTab(tab2);
        actionBar.addTab(tab3);

    }

    /** called when the user clicks the Send button*/
    public void sendMessage(View view){
        Intent intent = new Intent(this,DisplayMessageActivity.class);
        EditText editText = (EditText)findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }

    protected void openSearch(){

    }

    protected void openSettings(){

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //extend menu item for actionBar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //processes the event of clicking button
        switch (item.getItemId()) {
            case R.id.action_search:
                openSearch();
                return true;
            case R.id.action_settings:
                openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
