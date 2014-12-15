package com.tspecker.volleysample.controllers;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.tspecker.volleysample.R;
import com.tspecker.volleysample.controllers.sample.SampleFragment;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            SampleFragment sample = new SampleFragment();
            displayFragment(sample, SampleFragment.TAG, false);
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.container, new PlaceholderFragment())
//                    .commit();
        }
    }

    protected void displayFragment(final android.app.Fragment f, String t, boolean anim) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        // apply custom animation to fragment
        if (anim) { // TODO add anim
//            ft.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_right);
        }

        ft.add(R.id.container, f, t);
        ft.commit();
    }

    protected void displayFragment(final android.app.Fragment f, String t, boolean anim, boolean backStack) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        // apply custom animation to fragment
        if (anim) { // TODO add anim
//            ft.setCustomAnimations(R.animator.slide_in_right, R.animator.slide_out_left,
//                    R.animator.slide_in_left, R.animator.slide_out_right);
        }
        // add to BackStack
        ft.replace(R.id.container, f, t);

        if (backStack) {
            ft.addToBackStack(t);
        }

        ft.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.main_fragment, container, false);
            return rootView;
        }
    }
}
