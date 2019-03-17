package com.example.all_in_one_tutorials;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class ActNew extends AppCompatActivity {

    private EditText edtInfo;
    private Button btnSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        edtInfo = new EditText(this);
        edtInfo.setLayoutParams(lp);
        layout.addView(edtInfo);

        btnSet = new Button(this);
        btnSet.setLayoutParams(lp);
        btnSet.setText(R.string.buttonName);
        layout.addView(btnSet);

        setContentView(layout);

        Intent intent = getIntent();
        //TODO : bundle example need to add
        //Bundle bundle = intent.getExtras();

        String name = intent.getStringExtra("name");
        int code = intent.getIntExtra("Code", 890987);

        edtInfo.setText(name + R.string.blancktab + code);

        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("res", edtInfo.getText().toString());
                setResult(1, intent);
                finish();
            }
        });


    }
}
