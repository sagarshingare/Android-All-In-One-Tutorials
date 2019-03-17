package com.example.dialogs;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.all_in_one_tutorials.R;

public class DialogsActivity extends AppCompatActivity {

    private static final String TAG = "DialogsActivity";
    private final int D_ALERT = 1;
    private Button btnAlert, btnDate, btnTime, btnProgress, btnCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);
        Log.i(TAG, "onCreate: onCreate Method");

        btnAlert = findViewById(R.id.btnAlert);
        btnDate = findViewById(R.id.btnDate);
        btnTime = findViewById(R.id.btnTime);
        btnProgress = findViewById(R.id.btnProgress);
        btnCustom = findViewById(R.id.btnCustom);


        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(D_ALERT);
            }
        });
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dateDialog = new DatePickerDialog(DialogsActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        btnDate.setText(year + "/" + (int) ((int) month + 1) + "/" + dayOfMonth);
                    }
                }, 2014, 9, 4);
                dateDialog.show();
            }
        });

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timeDialog = new TimePickerDialog(DialogsActivity.this, new OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        btnTime.setTypeface(null, Typeface.BOLD);
                        btnTime.setText(hourOfDay + " : " + minute);
                    }
                }, 19, 45, true);
                timeDialog.show();
            }
        });

        btnProgress.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(DialogsActivity.this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.setTitle("SDSTech");
                progressDialog.setMessage("Downlaoding.....");
                progressDialog.setIcon(R.mipmap.ic_launcher);
                progressDialog.show();
            }
        });

        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog customDialog = new Dialog(DialogsActivity.this);
                customDialog.setContentView(R.layout.customdialogview);
                Button btnLogin = customDialog.findViewById(R.id.btnLogin);
                btnLogin.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Toast.makeText(DialogsActivity.this, "Logging ...In....", Toast.LENGTH_SHORT).show();
                    }
                });
                customDialog.show();
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        mt("On create dialog: " + id);

        if (id == D_ALERT) {
            AlertDialog.Builder builder = new AlertDialog.Builder(DialogsActivity.this);
            builder.setTitle("SDSTech");
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setMessage("Something like questions ?");

            AlertListener listener = new AlertListener();

            builder.setPositiveButton("Yes", listener);
            builder.setNegativeButton("No", listener);

            AlertDialog alertDialog = builder.create();
            alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    mt("Dialog onDismiss");
                }
            });
            alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    mt("Dialog onCancel");
                }
            });
            return alertDialog;
        }
        return null;
    }

    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        mt("Dialog onPrepareDialog");
    }

    private void mt(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    class AlertListener implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialog, int which) {
            if (which == DialogInterface.BUTTON_POSITIVE) {
                mt("You choose \"Yes\" option");
            } else {
                mt("You choose \"No\" option");
            }
        }
    }
}
