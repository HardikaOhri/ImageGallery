package com.example.hardika.imagegallery;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by hardika on 4/5/17.
 */

public class mySingleton {

    private static  mySingleton minstance;
    private static Context ctx;
    private RequestQueue requestQueue;

        private  mySingleton(Context ctx)
        {
            this.ctx=ctx;
            requestQueue=getRequestQueue();
        }
    private RequestQueue getRequestQueue()
    {
    if(requestQueue==null)
    {
        requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
    }
    return  requestQueue;
    }
public  static synchronized mySingleton getMinstance(Context  context)
{
    if(minstance==null)
    {
        minstance= new mySingleton(context);

    }
    return  minstance;
}
public <T> void  addrequestqueue(Request <T> request)
{
getRequestQueue().add(request);

}
}
