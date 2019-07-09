package com.example.myapplication;

import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AlertDialog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private Button ok;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helloButtonClick();
    }

    public void  helloButtonClick()
    {
        name=(EditText)findViewById(R.id.editText);
        ok=(Button)findViewById(R.id.button);
        ok.setOnClickListener(
            new View.OnClickListener()
            {
                @Override
                public void onClick (View v)
                {
                    if (name.getText().length()==0)
                        Toast.makeText(
                                MainActivity.this,"ERROR! Please, write your name!",Toast.LENGTH_SHORT
                        ).show();
                    else
                    {
                        AlertDialog.Builder a_build = new AlertDialog.Builder(MainActivity.this);
                        a_build.setMessage("Hello, "+ name.getText() + "!")
                                .setCancelable(false)
                                .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        finish();
                                    }
                                })
                                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.cancel();
                                    }
                                });
                        AlertDialog newd =a_build.create();
                        newd.setTitle("Close application..");
                        newd.show();
                    }
                }
            }
    );

    }



}
