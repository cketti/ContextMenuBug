package com.example.contextmenubug;


import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends Activity {
    private static final String[] ITEMS = {
            "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ITEMS));
        
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        
        int position = ((AdapterContextMenuInfo) menuInfo).position;
        menu.setHeaderTitle("Item: " + ITEMS[position]);
    }
}
