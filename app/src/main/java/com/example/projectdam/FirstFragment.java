package com.example.projectdam;

import static android.graphics.Color.*;

import android.app.Dialog;
import android.content.ClipData;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import android.widget.AdapterView.OnItemSelectedListener;
import java.util.ArrayList;
import java.util.List;

import com.example.projectdam.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private String jud;
    private String loc;
    Dialog dialog_j;
    Dialog dialog_l;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        return inflater.inflate(R.layout.fragment_first, container, false);

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btn = view.findViewById(R.id.button_first);
        TextView tvj = view.findViewById(R.id.textViewJud);
        TextView tvl = view.findViewById(R.id.textViewLoc);
        loc = "";
        jud = "";
        ArrayList<String> judete = new ArrayList<>();
        judete.add("Alba");
        judete.add("Arad");
        judete.add("Argeș");
        judete.add("Bacău");
        judete.add("Bihor");
        judete.add("Bistrița-Năsăud");
        judete.add("Botoșani");
        judete.add("Brăila");
        judete.add("Brașov");
        judete.add("București - Sector 1");
        judete.add("București - Sector 2");
        judete.add("București - Sector 3");
        judete.add("București - Sector 4");
        judete.add("București - Sector 5");
        judete.add("București - Sector 6");
        judete.add("Buzău");
        judete.add("Călărași");
        judete.add("Caraș-Severin");
        judete.add("Cluj");
        judete.add("Constanța");
        judete.add("Covasna");
        judete.add("Dâmbovița");
        judete.add("Dolj");
        judete.add("Galați");
        judete.add("Giurgiu");
        judete.add("Gorj");
        judete.add("Harghita");
        judete.add("Hunedoara");
        judete.add("Ialomița");
        judete.add("Iași");
        judete.add("Ilfov");
        judete.add("Maramureș");
        judete.add("Mehedinți");
        judete.add("Mureș");
        judete.add("Neamț");
        judete.add("Olt");
        judete.add("Prahova");
        judete.add("Sălaj");
        judete.add("Satu-Mare");
        judete.add("Sibiu");
        judete.add("Suceava");
        judete.add("Teleorman");
        judete.add("Timiș");
        judete.add("Tulcea");
        judete.add("Vâlcea");
        judete.add("Vaslui");
        judete.add("Vrancea");
        tvj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_j = new Dialog(getContext());
                dialog_j.setContentView(R.layout.dialog_search_jud);
                dialog_j.getWindow().setLayout(1090,2200);
                dialog_j.getWindow().setBackgroundDrawable(new ColorDrawable(TRANSPARENT));
                dialog_j.show();
                EditText et = dialog_j.findViewById(R.id.edit_text);
                ListView lv = dialog_j.findViewById(R.id.ls_jud);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),R.layout.fragment1_listview,judete);
                lv.setAdapter(adapter);

                et.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                          adapter.getFilter().filter(charSequence);
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        tvj.setText(adapter.getItem(i));
                        jud = adapter.getItem(i);
                        dialog_j.dismiss();
                    }
                });
            }
        });;
        ArrayList<String> localitati = new ArrayList<>();
        localitati.add("Abud");
        localitati.add("Abus");
        localitati.add("Acatari");
        localitati.add("Adamus");
        localitati.add("Adrian");
        localitati.add("Adrianu Mare");
        localitati.add("Adrianu Mic");
        localitati.add("Agristeu");
        localitati.add("Albesti");
        localitati.add("Alunis");
        localitati.add("Andreneasa");
        localitati.add("Angofa");
        localitati.add("Apalina");
        localitati.add("Apold");
        localitati.add("Archita");
        localitati.add("Arsita");
        localitati.add("Atintis");
        localitati.add("Aurel Vlaicu");
        localitati.add("Avramesti");
        localitati.add("Bagaciu");
        localitati.add("Bahnea");
        localitati.add("Baita");
        localitati.add("Bala");
        localitati.add("Balauseri");
        localitati.add("Balda");
        localitati.add("Band");
        localitati.add("Bara");
        localitati.add("Barbosi");
        localitati.add("Bardesti");
        localitati.add("Barlibas");
        localitati.add("Barlibasoaia");
        localitati.add("Barza");
        localitati.add("Batos");
        localitati.add("Bereni");
        localitati.add("Berghia");
        localitati.add("Bernadea");
        localitati.add("Beu");
        localitati.add("Bezid");
        localitati.add("Bezidu Nou");
        localitati.add("Bicasu");
        localitati.add("Bichis");
        localitati.add("Bistra Muresului");
        localitati.add("Blidireasa");
        localitati.add("Bobohalma");
        localitati.add("Bogata");
        localitati.add("Boiu");
        localitati.add("Bolintineni");
        localitati.add("Bologaia");
        localitati.add("Bord");
        localitati.add("Bordosiu");
        localitati.add("Borzia");
        localitati.add("Botei");
        localitati.add("Botez");
        localitati.add("Botorca");
        localitati.add("Bozed");
        localitati.add("Bozeni");
        localitati.add("Bradetelu");
        localitati.add("Brancovenesti");
        localitati.add("Breaza");
        localitati.add("Budiu Mic");
        localitati.add("Bujor");
        localitati.add("Bujor-Hodaie");
        localitati.add("Caciulata");
        localitati.add("Cacuciu");
        localitati.add("Calimanesti");
        localitati.add("Calugareni");
        localitati.add("Caluseri");
        localitati.add("Campenita");
        localitati.add("Campu Cetatii");
        localitati.add("Candu");
        localitati.add("Capalna de Sus");
        localitati.add("Capeti");
        localitati.add("Capusu de Campie");
        localitati.add("Casva");
        localitati.add("Cecalaca");
        localitati.add("Ceie");
        localitati.add("Cerghid");
        localitati.add("Cerghizel");
        localitati.add("Ceuas");
        tvl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_l = new Dialog(getContext());
                dialog_l.setContentView(R.layout.dialog_search_loc);
                dialog_l.getWindow().setLayout(1090,2200);
                dialog_l.getWindow().setBackgroundDrawable(new ColorDrawable(TRANSPARENT));
                dialog_l.show();
                EditText et2 = dialog_l.findViewById(R.id.edit_text2);
                ListView lv2 = dialog_l.findViewById(R.id.ls_loc);
                ArrayAdapter<String> adapter2 = new ArrayAdapter<>(getActivity(),R.layout.fragment1_listview,localitati);
                lv2.setAdapter(adapter2);

                et2.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        adapter2.getFilter().filter(charSequence);
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });
                lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        tvl.setText(adapter2.getItem(i));;
                        loc = adapter2.getItem(i);
                        dialog_l.dismiss();
                    }
                });
            }
        });
                btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(jud.toString().equals("")||loc.toString().equals(""))
                {
                    Toast.makeText(getActivity(),"Judetul sau localitatea nu au fost introduse!",Toast.LENGTH_SHORT).show();
                }
                else if(!jud.toString().equals("")&&!loc.toString().equals(""))
                {
                    NavHostFragment.findNavController(FirstFragment.this)
                            .navigate(R.id.action_FirstFragment_to_SecondFragment);
                }
                else
                {
                    Toast.makeText(getActivity(),"Judetul si localitatea nu sunt introduse!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");
//        localitati.add("");