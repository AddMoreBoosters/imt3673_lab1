package com.example.herma.labtest1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

/**
 * Created by herma on 01.02.2018.
 */

public class ThirdActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_third);
    }

    public void onSendDataBack(View view) {

        //  Send the whatever was typed back to activity 2
        EditText userDataET = (EditText) findViewById(R.id.A3T4);

        String userData = String.valueOf(userDataET.getText());

        Intent sendBack = new Intent();

        sendBack.putExtra("UserData", userData);

        setResult(RESULT_OK, sendBack);

        finish();

    }
}
