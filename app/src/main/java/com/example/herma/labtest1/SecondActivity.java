package com.example.herma.labtest1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

/**
 * Created by herma on 01.02.2018.
 */

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_second);

        Intent getUsersName = getIntent();

        String usersName = getUsersName.getExtras().getString("UsersName");

        TextView greeting = (TextView) findViewById(R.id.A2T2);
        greeting.append(" " + usersName);
    }

    public void onStartThirdActivity(View view) {

        Intent getThirdActivity = new Intent(this, ThirdActivity.class);

        final int result = 1;

        startActivityForResult(getThirdActivity, result);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK)
        {
            TextView messageFromA3 = (TextView) findViewById(R.id.A2T3);

            String dataSentBack = data.getStringExtra("UserData");

            messageFromA3.append(" " + dataSentBack);
        }
    }
}
