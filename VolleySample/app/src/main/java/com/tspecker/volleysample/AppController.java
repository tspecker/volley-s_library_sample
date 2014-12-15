package com.tspecker.volleysample;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.tspecker.volleysample.utilities.LruBitmapCache;

/**
 * Created by tspecker on 11/12/14.
 */
public class AppController extends Application {

    public static final String TAG = AppController.class
            .getSimpleName();
    private static AppController mInstance;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        // Set DefaultCookieManager : http://stackoverflow.com/a/21271347
        //CookieManager manager = new CookieManager();
        //CookieHandler.setDefault(manager);
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    public ImageLoader getImageLoader() {
        getRequestQueue();
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(this.mRequestQueue,
                    new LruBitmapCache());
        }
        return this.mImageLoader;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    @SuppressWarnings("UnusedDeclaration")
    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    @SuppressWarnings("UnusedDeclaration")
    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
