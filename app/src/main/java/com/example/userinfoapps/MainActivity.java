package com.example.userinfoapps;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ProgressBar progressBar;

    ArrayList <HashMap<String, String>> arrayList = new ArrayList<>();
    HashMap<String, String> hashMap;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        progressBar = findViewById(R.id.progressBar);

        // image slider =====start==================================

        ImageSlider imageSlider = findViewById(R.id.image_slider);
        ArrayList<SlideModel> imageList = new ArrayList<>(); // Create image list

        // imageList.add(new SlideModel("String Url" or R.drawable, "title")) You can add title
        //imageList.add(new SlideModel(R.drawable.coverphoto,"this is a title", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://bit.ly/2YoJ77H", "The animal population ", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://bit.ly/2BteuF2", "Elephants and tigers",ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://bit.ly/3fLJf72", "And people do that.",ScaleTypes.CENTER_CROP));

        imageSlider.setImageList(imageList);
        // image slider =====end==================================


//=======comment for test=============

        progressBar.setVisibility(View.VISIBLE);
        String url = "https://dummyjson.com/users";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressBar.setVisibility(View.GONE);
                        try {
                            JSONArray jsonArray = response.getJSONArray("users");

                            for (int x=0; x<jsonArray.length(); x++){
                                JSONObject jsonObjectRequest1 = jsonArray.getJSONObject(x);
                                String firstName = jsonObjectRequest1.getString("firstName");
                                String maidenName = jsonObjectRequest1.getString("firstName");
                                String lastName = jsonObjectRequest1.getString("lastName");
                                String age = jsonObjectRequest1.getString("age");
                                String gender = jsonObjectRequest1.getString("gender");
                                String email = jsonObjectRequest1.getString("email");
                                String phone = jsonObjectRequest1.getString("phone");
                                String username = jsonObjectRequest1.getString("username");
                                String password = jsonObjectRequest1.getString("password");
                                String birthDate = jsonObjectRequest1.getString("birthDate");
                                String image = jsonObjectRequest1.getString("image");
                                String bloodGroup = jsonObjectRequest1.getString("bloodGroup");
                                String height = jsonObjectRequest1.getString("height");
                                String weight = jsonObjectRequest1.getString("weight");
                                String eyeColor = jsonObjectRequest1.getString("eyeColor");

                                String domain = jsonObjectRequest1.getString("domain");
                                String ip = jsonObjectRequest1.getString("ip");
                                String macAddress = jsonObjectRequest1.getString("macAddress");
                                String university = jsonObjectRequest1.getString("university");
                                String ein = jsonObjectRequest1.getString("ein");
                                String ssn = jsonObjectRequest1.getString("ssn");
                                String userAgent = jsonObjectRequest1.getString("userAgent");


                                //======================HAIR=======================
                                JSONObject hairObject = jsonObjectRequest1.getJSONObject("hair");
                                String color = hairObject.getString("color");
                                String type = hairObject.getString("type");

                                //======================address=======================
                                JSONObject addressObject = jsonObjectRequest1.getJSONObject("address");
                                String address = addressObject.getString("address");
                                String city = addressObject.getString("city");

                                JSONObject coordinatesObject = addressObject.getJSONObject("coordinates");
                                String lat = coordinatesObject.getString("lat");
                                String lng = coordinatesObject.getString("lng");

                                String postalCode = addressObject.getString("postalCode");
                                String state = addressObject.getString("state");


                                //======================Bank=======================
                                JSONObject bankObject = jsonObjectRequest1.getJSONObject("bank");
                                String cardExpire = bankObject.getString("cardExpire");
                                String cardNumber = bankObject.getString("cardNumber");
                                String cardType = bankObject.getString("cardType");
                                String currency = bankObject.getString("currency");
                                String iban = bankObject.getString("iban");
                                //=================================================

                                //======================company=======================
                                JSONObject companyObject = jsonObjectRequest1.getJSONObject("company");
                                JSONObject companyaddreesObject = companyObject.getJSONObject("address");
                                String CPaddress = companyaddreesObject.getString("address");
                             //   String cpcity = companyaddreesObject.getString("city");  //not working this string


                                JSONObject CPcoordinatesObject = companyaddreesObject.getJSONObject("coordinates");
                               String CPlat = CPcoordinatesObject.getString("lat");
                               String CPlng = CPcoordinatesObject.getString("lng");

                               String CPpostalCode = companyaddreesObject.getString("postalCode");
                               String CPstate = companyaddreesObject.getString("state");

                                String department = companyObject.getString("department");
                                String name = companyObject.getString("name");
                                String title = companyObject.getString("title");
                                //=================================================

                                //======================crypto=======================
                                JSONObject cryptoObject = jsonObjectRequest1.getJSONObject("crypto");
                                String coin = cryptoObject.getString("coin");
                                String wallet = cryptoObject.getString("wallet");
                                String network = cryptoObject.getString("network");





                                hashMap = new HashMap<>();
                                hashMap.put("firstName", firstName);
                                hashMap.put("maidenName", maidenName);
                                hashMap.put("lastName", lastName);
                                hashMap.put("age", age);
                                hashMap.put("gender", gender);
                                hashMap.put("email", email);
                                hashMap.put("phone", phone);
                                hashMap.put("username", username);
                                hashMap.put("password", password);
                                hashMap.put("birthDate", birthDate);
                                hashMap.put("image", image);
                                hashMap.put("bloodGroup", bloodGroup);
                                hashMap.put("height", height);
                                hashMap.put("weight", weight);
                                hashMap.put("eyeColor", eyeColor);
                                hashMap.put("domain", domain);
                                hashMap.put("ip", ip);
                                hashMap.put("macAddress", macAddress);
                                hashMap.put("university", university);
                                hashMap.put("ein", ein);
                                hashMap.put("ssn", ssn);
                                hashMap.put("userAgent", userAgent);

                                //HAIR===============
                                hashMap.put("color", color);
                                hashMap.put("type", type);

                                //======================address=======================
                                hashMap.put("address", address);
                                hashMap.put("city", city);
                                hashMap.put("lat", lat);
                                hashMap.put("lng", lng);
                                hashMap.put("postalCode", postalCode);
                                hashMap.put("state", state);

                                //======================Bank=======================
                                hashMap.put("cardExpire", cardExpire);
                                hashMap.put("cardNumber", cardNumber);
                                hashMap.put("cardType", cardType);
                                hashMap.put("currency", currency);
                                hashMap.put("iban", iban);

                                //======================company=======================
                                hashMap.put("CPaddress", CPaddress);
                                hashMap.put("CPlng", CPlng);
                                hashMap.put("CPpostalCode", CPpostalCode);
                                hashMap.put("CPstate", CPstate);
                                hashMap.put("name", name);
                                hashMap.put("title", title);
                                hashMap.put("department", department);

                                //======================crypto=======================
                                hashMap.put("coin", coin);
                                hashMap.put("wallet", wallet);
                                hashMap.put("network", network);
                                arrayList.add(hashMap);



                            }

                            Myadapter myadapter = new Myadapter();
                            listView.setAdapter(myadapter);



                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        progressBar.setVisibility(View.GONE);

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(jsonObjectRequest);





    }

    //====adapter create==========================start=========
    private class Myadapter extends BaseAdapter{

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myview = layoutInflater.inflate(R.layout.iteminfo,parent,false);


            TextView tvName = myview.findViewById(R.id.tvName);
            TextView tvGender = myview.findViewById(R.id.tvGender);
            TextView tvAge = myview.findViewById(R.id.tvAge);
            TextView tvAddress = myview.findViewById(R.id.tvAddress);
            ImageView tvImage = myview.findViewById(R.id.tvImage);
            ImageView tvCall = myview.findViewById(R.id.tvCall);
            ImageView tvEmail = myview.findViewById(R.id.tvEmail);


            hashMap = arrayList.get(position);
            String firstName = hashMap.get("firstName");
            String maidenName = hashMap.get("maidenName");
            String lastName = hashMap.get("maidenName");
            String age = hashMap.get("age");
            String gender = hashMap.get("gender");
            String email = hashMap.get("email");
            String phone = hashMap.get("phone");
            String username = hashMap.get("username");
            String password = hashMap.get("password");
            String birthDate = hashMap.get("birthDate");
            String image = hashMap.get("image");
            String bloodGroup = hashMap.get("bloodGroup");
            String height = hashMap.get("height");
            String weight = hashMap.get("weight");
            String eyeColor = hashMap.get("eyeColor");
            String domain = hashMap.get("domain");
            String ip = hashMap.get("ip");
            String macAddress = hashMap.get("macAddress");
            String university = hashMap.get("university");
            String ein = hashMap.get("eyeColor");
            String ssn = hashMap.get("ssn");
            String userAgent = hashMap.get("userAgent");

            //HAIR===============
            String color = hashMap.get("color");
            String type = hashMap.get("type");

            //======================address=======================
            String address = hashMap.get("address");
            String city = hashMap.get("city");

            // coordinates=====================
            String lat = hashMap.get("lat");
            String lng = hashMap.get("lng");

            String postalCode = hashMap.get("postalCode");
            String state = hashMap.get("state");

            //======================Bank=======================
            String cardExpire = hashMap.get("cardExpire");
            String cardNumber = hashMap.get("cardNumber");
            String cardType = hashMap.get("cardType");
            String currency = hashMap.get("currency");
            String iban = hashMap.get("iban");

            //======================company=======================
            String CPaddress = hashMap.get("CPaddress");
            String CPlat = hashMap.get("CPlat");
            String CPlng = hashMap.get("CPlng");
            String CPpostalCode = hashMap.get("CPpostalCode");
            String CPstate = hashMap.get("CPstate");
            String department = hashMap.get("department");
            String name = hashMap.get("name");
            String title = hashMap.get("title");

            //======================crypto=======================
            String coin = hashMap.get("coin");
            String wallet = hashMap.get("wallet");
            String network = hashMap.get("network");





            tvName.setText(firstName+" "+maidenName+" "+lastName);
            tvGender.setText("Gender: "+gender);
            tvAge.setText("Age: "+age);
            tvAddress.setText("Address: "+address+","+city+","+state);
            Picasso.get().load(image).placeholder(R.drawable.itempic).into(tvImage);


            //Email and call ======onclick listener===========start====
            tvEmail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    sharingIntent.setPackage("com.google.android.gm");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                    sharingIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
                    startActivity(sharingIntent);
                }
            });

            tvCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callingIntent = new Intent(Intent.ACTION_DIAL);
                    callingIntent.setData(Uri.parse("tel:"+phone));
                    startActivities(new Intent[]{callingIntent});
                }
            });
            //Email and call ======onclick listener===========end====



            tvImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    UserFullinfo.FIRSTNAME = firstName;
                    UserFullinfo.MAIDENNAME = maidenName;
                    UserFullinfo.LASTNAME = lastName;
                    UserFullinfo.USERNAME = username;
                    UserFullinfo.PHONE = phone;
                    UserFullinfo.EMAIL = email;
                    UserFullinfo.AGE = age;
                    UserFullinfo.GENDER = gender;
                    UserFullinfo.BIRTHDATE = birthDate;
                    UserFullinfo.HEIGHT = height;
                    UserFullinfo.WEIGHT = weight;
                    UserFullinfo.PASSWORD = password;
                    UserFullinfo.EYECOLOR = eyeColor;
                    UserFullinfo.IMAGE = image;
                    UserFullinfo.HAIRCOLOR= color;
                    UserFullinfo.HAIRTYPE= type;

                    UserFullinfo.DOMAIN= domain;
                    UserFullinfo.IP= ip;
                    UserFullinfo.MACADDRESS= macAddress;
                    UserFullinfo.UNIVERSITY= university;
                    UserFullinfo.EIN= ein;
                    UserFullinfo.SSN= ssn;
                    UserFullinfo.USERAGENT= userAgent;
                    UserFullinfo.ADDRESS= address;
                    UserFullinfo.CITY= city;
                    UserFullinfo.LAT= lat;
                    UserFullinfo.LNG= lng;
                    UserFullinfo.POSTALCODE= postalCode;
                    UserFullinfo.STATE= state;

                    UserFullinfo.CARDEXPIRE= cardExpire;
                    UserFullinfo.CARDNUMBER= cardNumber;
                    UserFullinfo.CARDTYPE= cardType;
                    UserFullinfo.CURRENCY= currency;
                    UserFullinfo.IBAN= iban;
                    UserFullinfo.CPADDRESS= CPaddress;
                    UserFullinfo.CPLNG= CPlng;
                    UserFullinfo.CPPOSTALCODE= CPpostalCode;
                    UserFullinfo.CPSTATE= CPstate;
                    UserFullinfo.NAME= name;
                    UserFullinfo.TITLE= title;
                    UserFullinfo.DEPARTMENT= department;
                    UserFullinfo.COIN= coin;
                    UserFullinfo.WALLET= wallet;
                    UserFullinfo.NETWORK= network;



                    Intent myIntent = new Intent(MainActivity.this, UserFullinfo.class);
                    startActivity(myIntent);
                }
            });







            return myview;
        }
    }



}