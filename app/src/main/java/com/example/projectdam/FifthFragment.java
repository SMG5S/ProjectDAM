package com.example.projectdam;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FifthFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FifthFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    CustomAdapter ca;
    ListView lview;
    ArrayList<String> Names1;
    double[] Prices1;
    ArrayList<Integer> Counters1;
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View rootView;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FifthFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FifthFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FifthFragment newInstance(String param1, String param2) {
        FifthFragment fragment = new FifthFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_fifth, container, false);
        Names1 = new ArrayList<String>();
        Prices1 = new double[4];
        Counters1 = new ArrayList<Integer>();
        Bundle extras = this.getArguments();
        Names1 = extras.getStringArrayList("Names");
        Prices1 = extras.getDoubleArray("Prices");
        Counters1 = extras.getIntegerArrayList("Counters");

        Button end = rootView.findViewById(R.id.btnComanda);
        Button minus = rootView.findViewById(R.id.buttonMinus);
        Button plus = rootView.findViewById(R.id.buttonPlus);
        TextView inputCantitate = rootView.findViewById(R.id.textViewCantitate);
        TextView textNume = rootView.findViewById(R.id.textViewNume);
        TextView inputPret = rootView.findViewById(R.id.textViewInputPret);
        TextView inputPretTotal = rootView.findViewById(R.id.inputTxtTotal);
        lview = rootView.findViewById(R.id.list_view);
        //TODO...
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inputPretTotal.getText().equals("0.0 lei"))
                {
                    TextView txt_hidden = rootView.findViewById(R.id.cos_gol);
                    txt_hidden.setVisibility(View.VISIBLE);
                }
                else
                {
                    SixthFragment sf = new SixthFragment();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main,sf).commit();
                }
            }
        });
        return rootView;
    }
}