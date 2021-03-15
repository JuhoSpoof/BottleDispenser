package com.example.bottledispenser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;



public class BottleDispenser {

    private static BottleDispenser BD = new BottleDispenser();

    /*
    private BottleDispenser(){
    }
    */

    public static BottleDispenser getInstance(){
        return BD;
    }


    private int bottles;

    // The array for the Bottle-objects
    //private Bottle[] bottle_array;
    ArrayList<Bottle> bottle_array = new ArrayList<Bottle>();
    private int money;



    public BottleDispenser() {
        bottles = 5;
        money = 0;

        for(int i = 0; i<bottles; i++) {
            Bottle temp = new Bottle();
            bottle_array.add(temp);
        }



    }

    public void addMoney(TextView naytto, SeekBar seekBar, TextView moneyNaytto) {
        //int seekValue = seekBar.getProgress();
        //money += 1;
        money += seekBar.getProgress();
        System.out.println("Klink! Added more money!");
        naytto.setText("Klink! Added more money!");
        moneyNaytto.setText(("Money in machine: "+money));
    }

    public void buyBottle(TextView naytto, TextView moneyNaytto) {
        int i = bottles;
        if (bottles < 1){
            System.out.println("Out of bottles!");
            naytto.setText("Out of bottles!");
        }
        else if (money > 1.8){
            Bottle bArray = bottle_array.get(1);
            //for(Bottle bArray : bottle_array){
            bottles -= 1;
            money   -= bArray.getPrice();
            System.out.println("KACHUNK! "+ bArray.getName() +" came out of the dispenser!");
            naytto.setText("KACHUNK! "+ bArray.getName() +" came out of the dispenser!");
            moneyNaytto.setText(("Money in machine: "+money));

            //}
        }
        else{
            System.out.println("Add money first!");
            naytto.setText("Add money first!");
        }

    }

    public void returnMoney(TextView naytto, TextView moneyNaytto) {
        money = 0;
        System.out.println("Klink klink. Money came out!");
        naytto.setText("Klink klink. Money came out!");
        moneyNaytto.setText(("Money in machine: "+money));

    }

    public void bottleList(){
        for(int i=0; i < bottles; i++){
            Bottle bArray = bottle_array.get(i);
            int a = i+1;
            System.out.println((a)+". Name: "+bArray.getName());
            System.out.println("\t"+"Size: "+bArray.getSize()+"\t"+"Price: "+bArray.getPrice());
        }
    }

}