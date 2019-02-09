package com.example.spinner_hint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private LinearLayout ll_hint_spinner;
    private Spinner sp_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll_hint_spinner = findViewById(R.id.ll_hint_spinner);
        sp_main = findViewById(R.id.sp_main);

        ArrayAdapter<String> ArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.arrays));
        sp_main.setAdapter(ArrayAdapter);

        //Action after clicking LinearLayout / Spinner;
        ll_hint_spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //By clicking "Select ..." the Spinner is requested;
                sp_main.performClick();
                //Make LinearLayout invisible
                setLinearVisibility(false);
                //Disable LinearLayout
                ll_hint_spinner.setEnabled(false);
                //After LinearLayout is off, Spinner will function normally;
                sp_main.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        sp_main.setSelection(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        setLinearVisibility(true);
                    }
                });
            }
        });
    }

    //Method to make LinearLayout invisible or visible;
    public void setLinearVisibility(boolean visible) {
        if (visible) {
            ll_hint_spinner.setVisibility(View.VISIBLE);
        } else {
            ll_hint_spinner.setVisibility(View.INVISIBLE);
        }
    }
}
