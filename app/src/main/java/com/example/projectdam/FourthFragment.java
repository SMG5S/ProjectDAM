package com.example.projectdam;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FourthFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FourthFragment extends Fragment {

    View rootView;
    private ListView listView;
    private CustomAdapter customAdapter;
    // TODO: Rename parameter arguments, choose names that matchs
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FourthFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FourthFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FourthFragment newInstance(String param1, String param2) {
        FourthFragment fragment = new FourthFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_fourth, container, false);
        TextView tv = new TextView(getContext());
        tv.setTypeface(Typeface.DEFAULT_BOLD);
        tv.setText(R.string.l_d_p);
        listView = rootView.findViewById(R.id.list);
        listView.addHeaderView(tv);
        customAdapter = new CustomAdapter(getActivity());
        listView.setAdapter(customAdapter);
        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main,menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id==R.id.shopping_cart)
        {
            customAdapter = new CustomAdapter(getActivity());
            for(int i = 0 ; i < 4; ++i)
            {
                    Bundle extras = new Bundle();
                    ArrayList<String> Names = new ArrayList<String>();
                    Names.add(customAdapter.mydata.get(i).getNume());
                    double[] Prices = {customAdapter.mydata.get(i).getCost()};
                    ArrayList<Integer> Counters = new ArrayList<>();
                    Counters.add(customAdapter.mydata.get(i).getContor());
                    extras.putStringArrayList("Names", Names);
                    extras.putDoubleArray("Prices", Prices);
                    extras.putIntegerArrayList("Counters", Counters);
                    FifthFragment fifithF = new FifthFragment();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main, fifithF).commit();
            }
        }

        return super.onOptionsItemSelected(item);
    }
}