package com.example.herma.labtest1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Populates the drop-down list
        Spinner spinner = (Spinner) findViewById(R.id.view1_List1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.list1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        //  Checks if a choice is stored in shared preferences
        int startSelection = -1;
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        startSelection = sharedPref.getInt(getString(R.string.keySpinner), startSelection);

        //  If a choice was found, set that as the selected option
        if (startSelection != -1)
        {
            spinner.setSelection(startSelection);
        }

    }

    public void onStartSecondActivity(View view) {

        //  Send the user's name to the second activity
        Intent getSecondActivity = new Intent(this, SecondActivity.class);

        EditText ET_userName = (EditText) findViewById(R.id.view1_Text1);

        String userName = String.valueOf(ET_userName.getText());

        getSecondActivity.putExtra("UsersName", userName);

        startActivity(getSecondActivity);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        //  Save the users' selection
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(getString(R.string.keySpinner), i);
        editor.apply();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //  Do nothing
    }
}
