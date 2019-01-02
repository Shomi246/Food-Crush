package com.example.shomi.foodcrush;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void decrement(View view) {
        quantity=quantity-1;
        displayquantity(quantity);

    }

    private void displayquantity(int quantity) {
        EditText quantity1 = (EditText) findViewById(R.id.quantityTxt);
        quantity1.setText(""+quantity);


    }

    public void increment(View view) {
        quantity = quantity + 1;
        displayquantity(quantity);
    }





    private void displayMessage(String finalMessage) {
        TextView Message = (TextView) findViewById(R.id.resultTxt);
        Message.setText(""+finalMessage);


    }

    private String createFinalMessage(String names, Boolean ice, Boolean dri, Boolean bur, Boolean piz,int price) {
        String Message = "Name: "+names+"\n"+"ice-crem ordered :"+ice+"\n"+"drinks ordered  :"+dri+"\n"+"burger ordered  :"+bur+"\n"+"pizza ordered  :"+piz+"\n"+" Total Price BDT: "+price;
        return  Message;


    }

    private int calculatePrice(Boolean ice, Boolean dri, Boolean bur, Boolean piz) {
        int price =25;
        if (ice)
        {
            price =price*2;
        }
        if (dri)
        {
            price =price*1;
        }
        if (bur)
        {
            price =price*8;
        }
        if (piz)
        {
            price=price*12;
        }
        return price*quantity;
    }


    public void orderButton(View view) {
        EditText name = (EditText) findViewById(R.id.nameTxt);

        String names = name.getText().toString();
        CheckBox icecream = (CheckBox) findViewById(R.id.icecream_checkbox);
        Boolean ice = icecream.isChecked();
        CheckBox drinks = (CheckBox) findViewById(R.id.drinks_checkbox);
        Boolean dri = drinks.isChecked();
        CheckBox burger = (CheckBox) findViewById(R.id.burger_checkbox);
        Boolean bur = burger.isChecked();
        CheckBox pizza = (CheckBox) findViewById(R.id.pizza_checkbox);
        Boolean piz = pizza.isChecked();
        int price = calculatePrice(ice,dri,bur,piz);
        String finalMessage =createFinalMessage (names,ice,dri,bur,piz,price);
        displayMessage(finalMessage);
    }
}