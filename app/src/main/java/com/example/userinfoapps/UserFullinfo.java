package com.example.userinfoapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class UserFullinfo extends AppCompatActivity {


    ImageView tvDimage;

    TextView tvDname, tvDusername, tvDnumber, tvDemail, tvDage, tvDgender, tvDbirthday, tvDbloodgroup, tvDhight, tvDweight, tvDaddress ;
    public static String FIRSTNAME,MAIDENNAME,LASTNAME,AGE, GENDER, EMAIL, PHONE,USERNAME, PASSWORD,BIRTHDATE,IMAGE,BLOODGROUP,HEIGHT,WEIGHT = "";
    public static String EYECOLOR, HAIRCOLOR, HAIRTYPE, DOMAIN, IP, MACADDRESS, UNIVERSITY,EIN, SSN, USERAGENT = " ";


    // ADDRESS HERE=============================================
    public static String ADDRESS, CITY, LAT, LNG, POSTALCODE, STATE;

    //======================Bank=======================
    public static String CARDEXPIRE, CARDNUMBER, CARDTYPE, CURRENCY, IBAN;
    //======================company=======================
    public static String CPADDRESS, CPLNG, CPPOSTALCODE, CPSTATE, NAME, TITLE, DEPARTMENT;
    //======================crypto=======================
    public static String COIN, WALLET, NETWORK;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_fullinfo);


        tvDimage = findViewById(R.id.tvDimage);
        tvDname = findViewById(R.id.tvDname);
        tvDusername = findViewById(R.id.tvDusername);
        tvDnumber = findViewById(R.id.tvDnumber);
        tvDemail = findViewById(R.id.tvDemail);
        tvDage = findViewById(R.id.tvDage);
        tvDgender = findViewById(R.id.tvDgender);
        tvDbirthday = findViewById(R.id.tvDbirthday);
        tvDbloodgroup = findViewById(R.id.tvDbloodgroup);
        tvDhight = findViewById(R.id.tvDhight);
        tvDweight = findViewById(R.id.tvDweight);
        tvDaddress = findViewById(R.id.tvDaddress);




        tvDname.setText(FIRSTNAME+" "+MAIDENNAME+" "+LASTNAME);
        tvDusername.setText("UserName: "+USERNAME);
        tvDnumber.setText(PHONE);
        tvDemail.setText(EMAIL);
        tvDage.setText("Age: "+AGE);
        tvDgender.setText("Gender: "+GENDER);
        tvDbirthday.setText("Birthdate: "+BIRTHDATE);
        tvDbloodgroup.setText("Blood group: "+BLOODGROUP);
        tvDhight.setText("Height: "+HEIGHT);
        tvDweight.setText("Weight: "+WEIGHT);
        tvDaddress.setText("Address: "+ADDRESS+", "+CITY+", coordinates: "+LAT+", "+LNG+", "+POSTALCODE+" "+STATE);

        Picasso.get().load(IMAGE).placeholder(R.drawable.itempic).into(tvDimage);



        tvDnumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent callingIntent = new Intent(Intent.ACTION_DIAL);
                callingIntent.setData(Uri.parse("tel:"+PHONE));
                startActivities(new Intent[]{callingIntent});


            }
        });




        tvDemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.setPackage("com.google.android.gm");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{EMAIL});
                startActivity(sharingIntent);

            }
        });



    }//oncrate ====close here=============



}