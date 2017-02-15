package com.example.bharris.androidcontacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import static android.widget.AdapterView.*;
import static com.example.bharris.androidcontacts.R.id.listView;



public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnItemLongClickListener{
    ListView list;
    EditText name;
    EditText number;
    Button addButton;
    ArrayAdapter<String> contacts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(listView);
        name = (EditText) findViewById(R.id.name);
        number = (EditText) findViewById(R.id.number);
        addButton = (Button) findViewById(R.id.button);

        contacts = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(contacts);

        addButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        String contact = name.getText().toString();
        String pNumber = number.getText().toString();
        contacts.add(contact + " " + pNumber);
        name.setText("");
        number.setText("");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String contact = contacts.getItem(position);
        contacts.remove(contact);
        contacts.notifyDataSetChanged();
        return true;
    }
}
