package com.tutils.refreshlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }


    private void initialize()
    {
        mListView = (ListView) findViewById(R.id.pull_refresh_listview);
        mList.addAll(Arrays.asList(mArray));
        mListView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mList));
    }

    private ListView mListView;
    private ArrayList mList = new ArrayList<String>();
    private String[] mArray = new String[] {
        "Test1",
        "Test2",
        "Test3",
        "Test4",
        "Test5",
        "Test6",
        "Test7",
    };
}
