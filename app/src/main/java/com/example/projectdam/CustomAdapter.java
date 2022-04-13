package com.example.projectdam;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
        ArrayList<Materials> mydata;
        FragmentActivity context;
        private Dialog dialog_cumparare;
        private static double pretTotal = 0;
//        private static int contor = 0;
        CustomAdapter(FragmentActivity context)
        {
            this.context=context;
            mydata = new ArrayList<Materials>();
            mydata.add(new Materials("caramizi",48.5,R.drawable.caramizi));
            mydata.add(new Materials("lemne",16.5,R.drawable.lemne));
            mydata.add(new Materials("ciment",143.5,R.drawable.ciment));
            mydata.add(new Materials("tabla",138.5,R.drawable.tabla));

        }
        @Override
        public int getCount() {
            return mydata.size();
        }

        @Override
        public Object getItem(int i) {
            return mydata.get(i).getContor();
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            View row = convertView;
            LayoutInflater inflater = context.getLayoutInflater();
            if(convertView==null)
                row = inflater.inflate(R.layout.row_item,null,true);
            TextView textViewProduse = row.findViewById(R.id.textViewProduse);
            TextView textViewPreturi = row.findViewById(R.id.textViewPreturi);
            ImageView img = row.findViewById(R.id.imageViewFlag);
            Button btnCos = row.findViewById(R.id.buttonCos);
            final Materials mtemp = mydata.get(i);
            btnCos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog_cumparare = new Dialog(context);
                    dialog_cumparare.setContentView(R.layout.dialog_comandare_produse);
                    dialog_cumparare.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    LinearLayout ll = dialog_cumparare.findViewById(R.id.linearlayout);
                    ll.setBackgroundResource(mtemp.getImagine());
                    Button btnExit = dialog_cumparare.findViewById(R.id.btnClose);
                    Button btnMinus = dialog_cumparare.findViewById(R.id.btnMInus);
                    TextView cant = dialog_cumparare.findViewById(R.id.cantitate);
                    Button btnPlus = dialog_cumparare.findViewById(R.id.btnPlus);
                    TextView nume = dialog_cumparare.findViewById(R.id.nume_textView);
                    TextView pret = dialog_cumparare.findViewById(R.id.pret);
                    nume.setText(mtemp.getNume());
                    final int[] cantitate = {mtemp.getContor()};
                    if(cantitate[0]==0) {
                        ++cantitate[0];
                        pretTotal += mtemp.getCost();
                    }
                    pret.setText(String.valueOf(mtemp.getCost()*cantitate[0])+" lei");
                    cant.setText(String.valueOf(cantitate[0]));
                    double price = mtemp.getCost();
                    final double[] total = {0};
                    btnPlus.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            cantitate[0] = Integer.parseInt(cant.getText().toString());
                            ++cantitate[0];
                            pretTotal += price;
                            total[0] = price * cantitate[0];
                            pret.setText(total[0] + " lei");
                            mtemp.setContor(cantitate[0]);
                            cant.setText(String.valueOf(mtemp.getContor()));
                        }
                    });
                    btnMinus.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            cantitate[0] = Integer.parseInt(cant.getText().toString());
                            if (cantitate[0] > 0) {
                                    --cantitate[0];
                                    pretTotal+=price;
                            }
                            total[0] = price * cantitate[0];
                            pret.setText(total[0] + " lei");
                            mtemp.setContor(cantitate[0]);
                            cant.setText(String.valueOf(mtemp.getContor()));
                        }
                    });
                    btnExit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog_cumparare.dismiss();
                        }
                    });
                    dialog_cumparare.show();
                }
            });

            textViewProduse.setText(mtemp.getNume());
            textViewPreturi.setText(String.valueOf(mtemp.getCost())+ " lei");
            img.setImageResource(mtemp.getImagine());
            return row;
        }
    }

