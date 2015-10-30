package com.example.jcai.intents;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private EditText editText;
    private String gottenText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        View v1 = (View) findViewById(R.id.btn);
        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchView();
            }
        });

        String val = getIntent().getStringExtra("value");
        TextView valueview = (TextView) findViewById(R.id.displayvalue);
        valueview.setText(val);

        editText = (EditText) findViewById(R.id.thisedittext);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                gottenText = editText.getText().toString();
                handled = true;

                return handled;
            }
        });

    }

    public void launchView(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("value", gottenText);
        startActivity(intent);
    }

}
