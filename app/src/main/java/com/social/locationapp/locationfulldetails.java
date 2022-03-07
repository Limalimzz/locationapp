package com.social.locationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class locationfulldetails extends AppCompatActivity {
    String name, addess_1,  address_2,  pincode,  mobile,telephone_1,telephone_2,comm_email,alt_email,website,reservation_link,place,image;
    TextView txtname,txtaddress1,txtaddress2,txtpincode,txtmobile,txttelephone1,txttelephone2,txtcommemail,txtalemail,txtwebsite,txtrlink,txtplace,tztimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locationfulldetails);

        Intent in=getIntent();

        name= in.getStringExtra("name");
        addess_1=in.getStringExtra("address1");
        address_2=in.getStringExtra("address2");
        pincode= in.getStringExtra("pincode");
        mobile= in.getStringExtra("mobile");
        telephone_1= in.getStringExtra("telephone1");
        telephone_2=in.getStringExtra("telephone2");
        comm_email= in.getStringExtra("commemail");
        alt_email= in.getStringExtra("altemail");
        website=in.getStringExtra("website");
        reservation_link=in.getStringExtra("relink");
        place=in.getStringExtra("place");
        image= in.getStringExtra("image");

        txtname=findViewById(R.id.name);
        txtaddress1=findViewById(R.id.address1);
        txtaddress2 =findViewById(R.id.address2);
        txtpincode=findViewById(R.id.pincode);
        txtmobile=findViewById(R.id.mobile);
        txttelephone1=findViewById(R.id.telephone1);
        txttelephone2=findViewById(R.id.telephone2);
        txtcommemail=findViewById(R.id.comm_email);
        txtalemail =findViewById(R.id.alt_email);
        txtwebsite=findViewById(R.id.website);
        txtrlink=findViewById(R.id.reservation_link);
        txtplace=findViewById(R.id.place);
        tztimage=findViewById(R.id.image);


        txtname.setText(name);
        txtaddress1.setText(addess_1);
        txtaddress2 .setText(address_2);
        txtpincode.setText(pincode);
        txtmobile.setText(mobile);
        txttelephone1.setText(telephone_1);
        txttelephone2.setText(telephone_2);
        txtcommemail.setText(comm_email);
        txtalemail .setText(alt_email);
        txtwebsite.setText(website);
        txtrlink.setText(reservation_link);
        txtplace.setText(place);
        String s="https://www.google.com/search?q="+image;

        tztimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(s));
                startActivity(i);
            }
        });


    }
}