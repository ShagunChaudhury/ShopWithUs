package com.example.android.shopwithus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FrontPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);
        Button b11,b22,b33,b44;
        b11=(Button)findViewById(R.id.b1);
        b22=(Button)findViewById(R.id.b2);
        b33=(Button)findViewById(R.id.b3);
        b44=(Button)findViewById(R.id.b4);
        b11.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v)
                    {
                        startActivity(new Intent(FrontPage.this, LoginActivity.class));
                    }
                }

        );
        b22.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v)
                    {
                        startActivity(new Intent(FrontPage.this, LoginActivity.class));
                    }
                }

        );
        b33.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v)
                    {
                        startActivity(new Intent(FrontPage.this, LoginActivity.class));
                    }
                }

        );
        b44.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v)
                    {
                        startActivity(new Intent(FrontPage.this, LoginActivity.class));
                    }
                }

        );
    }
}
