package com.example.projectdam;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThirdFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThirdFragment extends Fragment implements View.OnClickListener {
    View rootView;
    Button btn3;
    EditText Email;
    EditText Password;
    String email;
    String parola;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ThirdFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ThirdFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ThirdFragment newInstance(String param1, String param2) {
        ThirdFragment fragment = new ThirdFragment();
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
        rootView = inflater.inflate(R.layout.fragment_third, container, false);
        btn3 = rootView.findViewById(R.id.buttonAutentificare);
        Email = rootView.findViewById(R.id.editTextEmail);
        Password = rootView.findViewById(R.id.editTextPassword);
        Bundle bndl = this.getArguments();
        email = bndl.getString("Email");
        parola = bndl.getString("Parola");
        btn3.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        if(Email.getText().toString().equals(email)&&Password.getText().toString().equals(parola))
        {
              Bundle bundle = new Bundle();
              bundle.putString("e-mail",email);
              bundle.putString("pass word",parola);
              FourthFragment ff = new FourthFragment();
              ff.setArguments(bundle);
              getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main,ff).commit();
        }
        else if(!Email.getText().toString().equals(email)&&!Email.getText().toString().equals(""))
        {
            Toast.makeText(getActivity(),"Email-ul este scris gresit!",Toast.LENGTH_SHORT).show();
        }
        else if(!Password.getText().toString().equals(parola)&&!Password.getText().toString().equals(""))
        {
            Toast.makeText(getActivity(),"Parola este incorecta",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getActivity(),"Email-ul si parola nu au fost introduse corect sau sunt libere.",Toast.LENGTH_SHORT).show();
        }
    }
}