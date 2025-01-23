//package com.example.my;
//
//import android.annotation.SuppressLint;
//import android.os.Bundle;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.android.volley.Request;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonObjectRequest;
//import com.android.volley.toolbox.Volley;
//import com.example.myapplication.R;
//import com.squareup.picasso.Picasso;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//public class news extends AppCompatActivity { // Keep the name 'news'
//
//    LinearLayout containerLayout;
//
//    @SuppressLint("MissingInflatedId")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_news); // Ensure this corresponds to the actual layout file
//
//        containerLayout = findViewById(R.id.main); // Ensure 'main' is the correct ID in your layout
//
//        String url = "https://www.inshorts.com/api/en/news?category=top_stories&max_limit=10&include_card_data=true&news_offset=xtnqdv2g-1";
//
//        // Create JsonObjectRequest
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            JSONObject dataObj = response.getJSONObject("data");
//                            JSONArray arr = dataObj.getJSONArray("news_list");
//
//                            for (int i = 0; i < arr.length(); i++) {
//                                JSONObject listObj = arr.getJSONObject(i);
//                                JSONObject newsData = listObj.getJSONObject("news_obj");
//
//                                // Extract title and image URL
//                                String title = newsData.getString("title");
//                                String imageUrl = newsData.getString("image_url");
//
//                                // Create TextView for the title
//                                TextView titleView = new TextView(news.this);
//                                titleView.setText(title);
//                                titleView.setTextSize(18);
//                                titleView.setPadding(16, 16, 16, 8);
//                                titleView.setTextColor(getResources().getColor(android.R.color.black));
//
//                                // Create ImageView for the image
//                                ImageView imageView = new ImageView(news.this);
//                                Picasso.get().load(imageUrl).into(imageView);
//
//                                // Set image size dynamically (optional)
//                                LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(
//                                        LinearLayout.LayoutParams.MATCH_PARENT,
//                                        500 // Adjust the height to fit better
//                                );
//                                imageParams.setMargins(16, 8, 16, 16);
//                                imageView.setLayoutParams(imageParams);
//
//                                // Add title and image to container
//                                containerLayout.addView(titleView);
//                                containerLayout.addView(imageView);
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                            Toast.makeText(news.this, "Error parsing JSON", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        // Handle error
//                        Toast.makeText(news.this, "Failed to fetch data: " + error.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//        // Add request to the request queue
//        Volley.newRequestQueue(this).add(request);
//    }
//}
