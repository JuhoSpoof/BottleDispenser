package com.example.bottledispenser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button addMoneyButton;
    Button returnMoneyButton;
    Button buyBottleButton;
    TextView naytto;
    TextView moneyNaytto;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottleDispenser BD = BottleDispenser.getInstance();
        //BottleDispenser BD = new BottleDispenser();

        naytto = (TextView) findViewById(R.id.naytto);
        moneyNaytto = (TextView) findViewById(R.id.moneyNaytto);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        /*seekBar.setMax(2);
        seekBar.setProgress(1); // default value
        */
        addMoneyButton = (Button) findViewById(R.id.addMoneyButton);
        addMoneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BD.addMoney(naytto, seekBar, moneyNaytto);
            }
        });

        returnMoneyButton = (Button) findViewById(R.id.returnMoneyButton);
        returnMoneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BD.returnMoney(naytto, moneyNaytto);
            }
        });

        buyBottleButton = (Button) findViewById(R.id.buyBottleButton);
        buyBottleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BD.buyBottle(naytto, moneyNaytto);
            }
        });


        /*
        BD.addMoney();
        BD.buyBottle();
        BD.returnMoney();
        BD.bottleList();
        */
    }


    //BottleDispenser BD = BottleDispenser.getInstance();
    //BottleDispenser BD = new BottleDispenser();
    /*
    BD.addMoney(View v);
    BD.buyBottle();
    BD.returnMoney();
    BD.bottleList();
    */



}

