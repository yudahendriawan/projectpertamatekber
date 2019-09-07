package com.example.projectpertamatekber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup rd_group;
    RadioButton rbtambah, rbkurang, rbkali, rbbagi;
    EditText bil1;
    EditText bil2;
    TextView hasil;
    String pilihan = "Tambah";

    Button hitung, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bil1 = findViewById(R.id.edt_bil1);
        bil2 = findViewById(R.id.edt_bil2);
        hasil = findViewById(R.id.tv_hasil);

        hitung = findViewById(R.id.btn_hitung);
        rbtambah = findViewById(R.id.rb_plus);
        rbkurang = findViewById(R.id.rb_minus);
        rbkali = findViewById(R.id.rb_multiply);
        rbbagi = findViewById(R.id.rb_bagi);
        rbtambah.isChecked();
        rd_group = findViewById(R.id.rd_group);

        clear = findViewById(R.id.btn_clear);

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbtambah.isChecked()){
                    pilihan = "tambah";
                }
                else if (rbkurang.isChecked()){
                    pilihan = "kurang";
                }
                else if(rbkali.isChecked()){
                    pilihan = "kali";
                }
                else if(rbbagi.isChecked()){
                    pilihan = "bagi";
                }

                String b1 = bil1.getText().toString().trim();
                String b2 = bil2.getText().toString().trim();

                double db1 = Double.parseDouble(b1);
                double db2 = Double.parseDouble(b2);

                double tvhasil = 0;

                if(pilihan.equalsIgnoreCase("tambah")){
                    tvhasil = db1+db2;
                }
                else if (pilihan.equalsIgnoreCase("kurang")){
                    tvhasil = db1-db2;
                }
                else if (pilihan.equalsIgnoreCase("kali")){
                    tvhasil = db1*db2;
                }
                else if (pilihan.equalsIgnoreCase("bagi")){
                    tvhasil = db1/db2;
                }

                hasil.setText(String.valueOf(tvhasil));
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bil1.setText("");
                bil2.setText("");
                hasil.setText("");
            }
        });



        /*String bbil1 = bil1.getText().toString().trim();
        String bbil2 = bil2.getText().toString().trim();

        final Double bilangan1 = toDouble(bbil1);
        final Double bilangan2 = toDouble(bbil2);

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = rd_group.getCheckedRadioButtonId();
                switch (id){
                    case R.id.rb_plus:
                        double hasiltambah = bilangan1+bilangan2;
                        hasil.setText(String.valueOf(hasiltambah));
                        break;
                    case R.id.rb_minus:
                        double hasilkurang = bilangan1-bilangan2;
                        hasil.setText(String.valueOf(hasilkurang));
                        break;
                    case R.id.rb_multiply:
                        double hasilkali = bilangan1*bilangan2;
                        hasil.setText(String.valueOf(hasilkali));
                        break;
                    case R.id.rb_bagi:
                        double hasilbagi = bilangan1/bilangan2;
                        hasil.setText(String.valueOf(hasilbagi));
                        break;
                }

            }
        });*/

    }

//    public void setBtRadio() {
//
//
//
//        rd_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                int idChecked = rd_group.getCheckedRadioButtonId();
//                switch (idChecked){
//                    case R.id.rb_bagi:
//                        hasil.setText(String.valueOf(hasilbagi));
//                        break;
//                    case R.id.rb_plus:
//                        hasil.setText(String.valueOf(hasiltambah));
//                        break;
//                    case R.id.rb_multiply:
//                        hasil.setText(String.valueOf(hasilkali));
//                        break;
//                    case R.id.rb_minus:
//                        hasil.setText(String.valueOf(hasilkurang));
//                        break;
//                }
//            }
//        });
//
//    }
}
