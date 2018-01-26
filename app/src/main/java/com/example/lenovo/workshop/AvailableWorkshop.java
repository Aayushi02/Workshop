package com.example.lenovo.workshop;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class AvailableWorkshop extends Fragment {

String username = " ";
    public AvailableWorkshop() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_available_workshop,container,false);
        ListView listView = (ListView) view.findViewById(R.id.worshoplist);
        ArrayList<String> workshop_name = new ArrayList<String>();
        workshop_name.add("Java");
        workshop_name.add("Python");
        workshop_name.add("Machine learning");
        workshop_name.add("Cryptocurrency");
        username = getArguments().getString("username");
        MyAdaptor myadaptor = new MyAdaptor(getActivity().getBaseContext(),workshop_name,username);
        listView.setAdapter(myadaptor);
        return view;
    }



}
