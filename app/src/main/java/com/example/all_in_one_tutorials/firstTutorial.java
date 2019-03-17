package com.example.all_in_one_tutorials;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class firstTutorial extends AppCompatActivity {
    private EditText edtData;
    private Button btnSet, btnNext;
    private ImageView imageView;
    private TextView txtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        imageView = findViewById(R.id.img);
        txtData = findViewById(R.id.txtData);
        edtData = findViewById(R.id.edtData);
        btnSet = findViewById(R.id.btnSet);
        btnNext = findViewById(R.id.btnNext);

        imageView.setImageResource(R.mipmap.ic_launcher);

        btnSet.setOnClickListener(new BtnSetListener());

        txtData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                txtData.setText("");
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(firstTutorial.this, ActNew.class);

                intent.putExtra("name", edtData.getText().toString());
                intent.putExtra("code", 101);

                //startActivity(intent);
                startActivityForResult(intent, 1);

            }
        });


    }


    @Override
    protected void onNewIntent(Intent intent) {
        // TODO Auto-generated method stub
        super.onNewIntent(intent);
        mt("On New Intent");
    }


    @Override
    protected void onStart() {
        super.onStart();
        mt("onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mt("onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        mt("onResume");
    }

    @Override
    protected void onPause() {
        mt("onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        mt("onSTop");
        super.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        mt("onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        mt("onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mt("Request Code is :   " + requestCode + " Result code is :   " + resultCode);
        txtData.setText(data.getStringExtra("res"));
    }

    private void mt(String text) {
        Log.i("APP: ", "Toast Data " + text);
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    class BtnSetListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            txtData.setText(edtData.getText().toString());
        }

    }

}
