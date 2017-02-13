package com.example.turate.arraylistdynamic;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ListView mlistview;
    Button mascending;
    Button mdescending;
    int flag;
    ArrayAdapter<String> Adapter;
    String[] months = {"January", "June", "July", "February", "March", "April", "May",
                                    "August", "September", "October", "November", "December"};
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mlistview = (ListView) findViewById(R.id.List_view);
        mascending = (Button) findViewById(R.id.Ascending);
        mdescending = (Button) findViewById(R.id.Descending);

        Adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, months);
        mlistview.setAdapter(Adapter);

//        When Ascending Button is clicked
        mascending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag == 1){
                    Toast.makeText(MainActivity.this, "Already in Ascending Order", Toast.LENGTH_SHORT).show();
                }
                else{
                    flag=1;
                    Changelist(flag);
                }
            }
        });

//        When Descending Button is clicked
        mdescending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag == 2){
                    Toast.makeText(MainActivity.this, "Already in Descending Order", Toast.LENGTH_SHORT).show();
                }
                else {
                    flag = 2;
                    Changelist(flag);
                }
            }
        });


    }



//    function where list is ordered
    private void Changelist(int i) {
//        sorting the list for Ascending order
        list = new ArrayList<>(Arrays.asList(months));
        Collections.sort(list);
        Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_SHORT).show();

//        Reversing the sorted list for Descending order
        if(i == 2){
            Collections.reverse(list);
        }

        mlistview.setAdapter(null);
        Adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        mlistview.setAdapter(Adapter);
        Adapter.notifyDataSetChanged();
    }
}
