package com.example.lenovo.workshop;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Mainfragment extends Fragment {


    ViewPager viewPager;
    public static final int tabcount = 2;
    public static final String[] tabname = {
            "Workshop available","Workshop joined"
    };
    Bundle b = new Bundle();

    public Mainfragment() {

           }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_mainfragment,container,false);
        viewPager = (ViewPager) v.findViewById(R.id.viewpager);
        return v;
    }


}
