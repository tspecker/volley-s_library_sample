package com.tspecker.volleysample.utilities;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.tspecker.volleysample.AppController;
import com.tspecker.volleysample.models.ParamsRequest;
import com.tspecker.volleysample.models.interfaces.IVolley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by tspecker on 10/12/14.
 */
public class VolleyUtils {

    public static void makePostStringRequest(String url, final ArrayList<ParamsRequest> paramObj,
                                             final IVolley callback) {
        String language = Locale.getDefault().getLanguage();
        String tag_json_obj = "json_obj_req";
        final String TAG = VolleyUtils.class.getSimpleName() + "." + "makePostStringRequest()";
        StringRequest jsonObjReq = new StringRequest(Method.POST,
                url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        VolleyLog.d(TAG, "Response: " + response);
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                // TODO
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                for (ParamsRequest param : paramObj) {
                    params.put(param.key, param.value);
                }
                return params;
            }
        };

        // Adding request to request queue
        int socketTimeout = 30000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, 1, 1);
        jsonObjReq.setRetryPolicy(policy);
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
    }

    public static void makeGetStringRequest(String url, final ArrayList<ParamsRequest> paramObj,
                                            final IVolley callback) {
        String language = Locale.getDefault().getLanguage();
        String tag_json_obj = "json_obj_req";
        final String TAG = VolleyUtils.class.getSimpleName() + "." + "makeGetStringRequest()";
        StringRequest jsonObjReq = new StringRequest(Method.GET,
                url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        VolleyLog.d(TAG, "Response: " + response);
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                // TODO
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                for (ParamsRequest param : paramObj) {
                    params.put(param.key, param.value);
                }
                return params;
            }
        };

        // Adding request to request queue
        int socketTimeout = 30000; // 30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, 1, 1);
        jsonObjReq.setRetryPolicy(policy);
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
    }
}
