package com.example.android.shopwithus;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    Button b1,b2;
    EditText ed1,ed2,ed3,ed4,ed5,ed6;
    float f;
    Spinner dropdown;
  //  String loc="";

    public static Date addDay(Date date,int i){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, i);
        return cal.getTime();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb=new DatabaseHelper(this);
        ed1=(EditText) findViewById(R.id.Name);
        ed2=(EditText) findViewById(R.id.LName);
        ed3=(EditText) findViewById(R.id.email);
        ed4=(EditText) findViewById(R.id.password);
        ed5=(EditText) findViewById(R.id.product);
       // ed6=(EditText) findViewById(R.id.Location);
        // ed7=(EditText) findViewById(R.id.Confirm_password);
        //get the spinner from the xml.
         dropdown = findViewById(R.id.spinner1);
//create a list of items for the spinner.
        String[] items = new String[]{"Select Location","Lucknow", "Raipur", "Indore", "Mumbai", "Gurgaon", "Gujarat", "Chennai", "Bangalore", "Bengal", "Bihar"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);
       // loc=dropdown.getSelectedItem().toString();
        b1 = (Button) findViewById(R.id.button);

//       Add_data();

        myDb.insertData2("Lucknow",1.114f,31.0f,-1,0);
//        if(ans==true)
//            Toast.makeText(this, "data inserted in table ", Toast.LENGTH_LONG).show();
//        else
//            Toast.makeText(this, "data not inserted in table ", Toast.LENGTH_LONG).show();
        myDb.insertData2("Raipur",2.352f,25.0f,0,0);
        myDb.insertData2("Indore",1.592f,26.0f,0,0);
        myDb.insertData2("Mumbai",2.766f,28.0f,2,0);
        myDb.insertData2("Gurgaon",0.0f,30.0f,1,0);
        myDb.insertData2("Gujarat",2.112f,30.0f,2,0);
        myDb.insertData2("Chennai",4.32f,32.0f,2,0);
        myDb.insertData2("Bangalore",4.256f,25.0f,1,0);
        myDb.insertData2("Bengal",2.844f,30.0f,2,0);
        myDb.insertData2("Bihar",2.256f,32,2,0);

        b1.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v)
                    {
//                       boolean isInserted= myDb.insertData(ed1.getText().toString(),  ed2.getText().toString(), ed3.getText().toString(),ed4.getText().toString() , ed5.getText().toString(),ed6.getText().toString());
//                        if(isInserted==true  )
//                            Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
//                        else
//                            Toast.makeText(MainActivity.this,"Data Not Inserted",Toast.LENGTH_LONG).show();
                     //   Cursor res = myDb.getAllData(ed5.getText().toString());
                        Cursor res1=myDb.getAllData(dropdown.getSelectedItem().toString());   //myDb.getAllData(ed6.getText().toString());
                        StringBuffer buffer = new StringBuffer();
                        while(res1.moveToNext()){
                         //   buffer.append("Id :"+res.getString(0)+"\n");
                           // buffer.append("Name ")
                            f=res1.getFloat(2);
                            if(res1.getFloat(3)<20.0f || res1.getFloat(3)>45.0f)
                            {
                                f=f+3;
                            }
                            f=f+res1.getInt(4);
                        }
                        f=(float)Math.ceil(f);
                        int i=(int)f;
                        Date date= Calendar.getInstance().getTime();
                        Date d=addDay(date,i);
                        buffer.append("Product : "+ed5.getText().toString()+"\n");
                        buffer.append("Expected Delivery Date : "+d);
                        showMessage(buffer.toString());
                    }
                }

        );
//       b2.setOnClickListener(
//                new View.OnClickListener(){
//                    @Override
//                    public void onClick(View v)
//                    {
//                       startActivity(new Intent(MainActivity.this, LoginActivity.class));
//                    }
//                }
//
//        );

    }
    public void showMessage(String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        String title = "Order Summary";
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}


