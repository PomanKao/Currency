package com.home.currency;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edNTD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
    }

    private void findViews() {
        edNTD = findViewById(R.id.ntd);
        Button btnGO = findViewById(R.id.button);
        btnGO.setOnClickListener(goOnClick);
    }

    View.OnClickListener goOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String strNTD = edNTD.getText().toString();
            if (strNTD.equals("")) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Problem")
                        .setMessage("Please enter you NTD amount")
                        .setPositiveButton("OK",null)
                        .show();
            } else {
                int intNTD = Integer.parseInt(strNTD);
                float toUSD = intNTD / 30.9f;
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Result")
                        .setMessage("USD is " + toUSD)
                        .setPositiveButton("OK",null)
                        .show();
            }
        }
    };
}
