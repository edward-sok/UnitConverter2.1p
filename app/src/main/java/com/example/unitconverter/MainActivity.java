package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private static final String[] paths = {"Centimetres", "Celsius", "Kilograms"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        ImageButton btnlengthconvert = findViewById(R.id.btnlengthconvert);
        ImageButton btntempconvert = findViewById(R.id.btntempconvert);
        ImageButton btnweightconvert = findViewById(R.id.btnweightconvert);

        final EditText EditTextFigure = findViewById(R.id.EditTextFigure);
        TextView textview1 = findViewById(R.id.textView1);
        TextView textview2 = findViewById(R.id.textView2);
        TextView textview3 = findViewById(R.id.textView3);
        TextView textview4 = findViewById(R.id.textView4);

        switch (position) {
            case 0:
                btnlengthconvert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (EditTextFigure.getText().toString().trim().length() > 0) {
                            String textValue = EditTextFigure.getText().toString();
                            lastValue = (int) Double.parseDouble(textValue);

                            double result = Double.parseDouble(EditTextFigure.getText().toString());
                            double milerounded = Math.round(result * 0.0000062137 * 100.00) / 100.00;
                            double footrounded = Math.round(result * 0.03281 * 100.00) / 100.00;
                            double inchrounded = Math.round(result * 0.03937 * 100.00) / 100.00;
                            double yardrounded = Math.round(result * 0.01093 * 100.00) / 100.00;

                            textview1.setText(milerounded + " Mile");
                            textview2.setText(footrounded + " Foot");
                            textview3.setText(inchrounded + " Inch");
                            textview4.setText(yardrounded + " Yard");
                        }
                    }
                });
                btnweightconvert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToast("Please select the correct conversion icon.");
                    }
                });
                btntempconvert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToast("Please select the correct conversion icon.");
                    }
                });

                break;
            case 1:
                btntempconvert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (EditTextFigure.getText().toString().trim().length() > 0) {
                            String textValue = EditTextFigure.getText().toString();
                            lastValue = (int) Double.parseDouble(textValue);
                            double result = Double.parseDouble(EditTextFigure.getText().toString());
                            double fahrenheitrounded = Math.round(result * 32.00 * 100.00) / 100.00;
                            double kelvinrounded = Math.round(result * 273.15 * 100.00) / 100.00;
                            textview1.setText(fahrenheitrounded + " Fahrenheit");
                            textview2.setText(kelvinrounded + " Kelvin");
                            textview3.setText(" ");
                            textview4.setText(" ");

                        }
                    }
                });
                btnlengthconvert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToast("Please select the correct conversion icon.");
                    }
                });
                btnweightconvert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToast("Please select the correct conversion icon.");
                    }
                });
                break;
            case 2:
                btnweightconvert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (EditTextFigure.getText().toString().trim().length() > 0) {
                            String textValue = EditTextFigure.getText().toString();
                            lastValue = (int) Double.parseDouble(textValue);
                            double result = Double.parseDouble(EditTextFigure.getText().toString());
                            double tonrounded = Math.round(result * 0.001 * 100.00) / 100.00;
                            double ouncerounded = Math.round(result * 35.274 * 100.00) / 100.00;
                            double poundrounded = Math.round(result * 2.20462 * 100.00) / 100.00;

                            textview1.setText(tonrounded + " Ton");
                            textview2.setText(ouncerounded + " Ounce(Oz)");
                            textview3.setText(poundrounded + " Pound(lb)");
                            textview4.setText(" ");

                        }
                    }
                });
                btnlengthconvert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToast("Please select the correct conversion icon.");
                    }
                });
                btntempconvert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToast("Please select the correct conversion icon.");
                    }
                });
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    int lastValue = 0;

    void showToast(CharSequence msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
