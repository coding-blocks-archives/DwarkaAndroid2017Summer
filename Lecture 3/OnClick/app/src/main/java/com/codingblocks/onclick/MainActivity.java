package com.codingblocks.onclick;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button holaButton = (Button) findViewById(R.id.holaButton);
        Button amigoButton = (Button) findViewById(R.id.amigoButton);

        /*
        First way to set onCLick listener is by adding a new anonymous inner class.
         */

        holaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Do some Stuff
            }
        });
        amigoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Do some stuff
            }
        });

        /*
        Second way is to make your activity implement the onClickListener
         */
        holaButton.setOnClickListener(this);
        amigoButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.amigoButton){
            //Do some stuff
        }
        else if (v.getId() == R.id.holaButton){
            //Do some stuff
        }
    }


}
