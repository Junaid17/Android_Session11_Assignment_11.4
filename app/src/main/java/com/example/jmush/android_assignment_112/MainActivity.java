package com.example.jmush.android_assignment_112;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        // Inserting Names
        Log.d("Insert: ", "Inserting ..");
        db.addName(new NameModel("ANIL","BAKALE"));
        db.addName(new NameModel("JUNAID","AHMED"));
        db.addName(new NameModel("PRATEEK","MULGUNDMATH"));
        db.addName(new NameModel("SOURABH","THAKUR"));
        db.addName(new NameModel("SAUD","KHAJAPUR"));
        db.addName(new NameModel("WASIM","MITHAIGER"));

        // Reading all names
        Log.d("Reading: ", "Reading all contacts..");
        List<NameModel> names = db.getAllContacts();

        for (NameModel cn : names) {
            String log = "Id: "+cn.getId()+" ,Name: "+cn.getName()+",Last Name: "+cn.getLastName();
            // Writing names to log
            Log.d("Name: ", log);
            TextView textView= (TextView) findViewById(R.id.text);
            textView.append(log);
            textView.append("\n");



        }


    }

}
