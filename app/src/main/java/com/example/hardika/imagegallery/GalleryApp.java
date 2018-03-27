package com.example.hardika.imagegallery;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;




public class GalleryApp extends AppCompatActivity {

    Toolbar toolbar;
    ArrayList<Album> arrayList=new ArrayList<>();
    RecyclerView recyclerView;
    RecycleAdapter adapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_app);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        JsonArrayRequest jsonArrayRequest;
        jsonArrayRequest = new JsonArrayRequest( Request.Method.POST, config.server_path, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                                      int count=0;
                                    while(count<response.length())
                                    {
                                        try
                                        {
                                            JSONObject jsonObject=response.getJSONObject(count);
                                            arrayList.add(new Album(jsonObject.getString("id"),jsonObject.getString("title")));
                                        count++;
                                        }
                                        catch (JSONException e)
                                        {
                                            e.printStackTrace();
                                        }
                                    }
                                    adapter=new RecycleAdapter(arrayList,GalleryApp.this);
                        recyclerView.setAdapter(adapter);
                                          }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
            }


        );
        mySingleton.getMinstance(GalleryApp.this).addrequestqueue(jsonArrayRequest);
    }


}
