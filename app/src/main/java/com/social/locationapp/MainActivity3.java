package com.social.locationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity3 extends AppCompatActivity {
    String latitude,longitude;
    LocationManager locationManager;


    private String url= "https://invishost.in/api/list.php";
    ArrayList<locationmodel> datamodelList;

    private RecyclerView recyclerView;
    ProgressDialog dialog;
    locationadapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        dialog=new ProgressDialog(this);
        dialog.setTitle("Fetching data");
        dialog.show();


        recyclerView = findViewById(R.id.recycler1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity3.this, LinearLayoutManager.VERTICAL, false));
        datamodelList = new ArrayList<>();
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


        Intent in=getIntent();
        latitude=in.getStringExtra("latitide");
        longitude=in.getStringExtra("longitude");
        viewData();
        dialog.dismiss();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        MenuItem item=menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void viewData() {
        url=url+"?lat="+latitude+"&lon="+longitude;
        final StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject jsn = array.getJSONObject(i);
                                datamodelList.add(new locationmodel(jsn.getString("distance"),jsn.getString("name"),jsn.getString("address_1"),jsn.getString("address_2"),jsn.getString("pincode"),jsn.getString("mobile"),jsn.getString("telephone_1"),
                                        jsn.getString("telephone_2"),jsn.getString("comm_email"),jsn.getString("alt_email"),jsn.getString("website"),jsn.getString("reservation_link"),jsn.getString("place"),jsn.getString("image")));
                            }


                            adapter = new locationadapter(MainActivity3.this, (ArrayList<locationmodel>) datamodelList);
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> mp = new HashMap<>();
                mp.put("latitude",latitude);
                mp.put("longitude",longitude);

                return mp;

            }


        };
        System.out.println(stringRequest);
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity3.this);
        requestQueue.add(stringRequest);

    }

}