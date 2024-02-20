package com.example.userinfoapps;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
                                String lastName = jsonObjectRequest1.getString("firstName");
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



                                hashMap = new HashMap<>();
                                hashMap.put("firstName", firstName);
                                hashMap.put("maidenName", maidenName);
                                hashMap.put("lastName", maidenName);
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


            tvName.setText(firstName+" "+maidenName+" "+lastName);
            tvGender.setText("Gender: "+gender);
            tvAge.setText("Age: "+age);
            Picasso.get().load(image).placeholder(R.drawable.itempic).into(tvImage);




            tvEmail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                   
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




            return myview;
        }
    }


}