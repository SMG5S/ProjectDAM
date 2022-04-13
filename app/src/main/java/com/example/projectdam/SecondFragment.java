package com.example.projectdam;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.projectdam.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment implements View.OnClickListener {
    View rootView;
    EditText et;
    EditText et2;
    EditText et3;
    EditText et4;
    Button btn2;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        rootView = inflater.inflate(R.layout.fragment_second, container, false);
        et = rootView.findViewById(R.id.editNumePrenume);
        et2 = rootView.findViewById(R.id.editEmail);
        et3 = rootView.findViewById(R.id.editParola);
        et4= rootView.findViewById(R.id.editParolaRepetata);
        btn2 = rootView.findViewById(R.id.button_second);
        btn2.setOnClickListener(this);
        return rootView;

    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View view) {
       if(view.getId()==R.id.button_second)
       {
           if(et.getText().toString().isEmpty()&&et2.getText().toString().isEmpty()&&et3.getText().toString().isEmpty()&&et4.getText().toString().isEmpty())
           {
               Toast.makeText(getActivity(),"Campurile nu pot fi lasate libere!Acestea sunt obligatorii!",Toast.LENGTH_SHORT).show();
           }
           if(et.getText().toString().isEmpty())
           {
               Toast.makeText(getActivity(),"Numele si prenumele sunt lasate libere...",Toast.LENGTH_SHORT).show();
           }
           else if(et2.getText().toString().isEmpty())
           {
               Toast.makeText(getActivity(),"Email-ul este lasat liber...",Toast.LENGTH_SHORT).show();
           }
           else if(et3.getText().toString().isEmpty())
           {
               Toast.makeText(getActivity(),"Parola este lasata libera...",Toast.LENGTH_SHORT).show();
           }
           else if(et4.getText().toString().isEmpty())
           {
               Toast.makeText(getActivity(),"Repetarea parolei este lasata libera...",Toast.LENGTH_SHORT).show();
           }
           else if(!et3.getText().toString().equals(et4.getText().toString()))
           {
               Toast.makeText(getActivity(),"Parolele nu se potrivesc",Toast.LENGTH_SHORT).show();
           }
           else {
               Bundle extras = new Bundle();
               extras.putString("N.P", et.getText().toString());
               extras.putString("Email", et2.getText().toString());
               extras.putString("Parola", et3.getText().toString());
               extras.putString("ParolaIdentica", et4.getText().toString());
               ThirdFragment thirdFragment = new ThirdFragment();
               thirdFragment.setArguments(extras);
               getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main, thirdFragment).commit();
           }
       }
    }
}
