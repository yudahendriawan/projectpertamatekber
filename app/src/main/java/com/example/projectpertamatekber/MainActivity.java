package com.example.projectpertamatekber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

//import butterknife.ButterKnife;
//import butterknife.BindView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.projectpertamatekber.R.id.rb_plus;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R2.id.rd_group)
    RadioGroup rd_group;

    @BindView(R2.id.rb_plus)
    RadioButton rbtambah;

    @BindView(R2.id.rb_minus)
    RadioButton rbkurang;

    @BindView(R2.id.rb_multiply)
    RadioButton rbkali;

    @BindView(R2.id.rb_bagi)
    RadioButton rbbagi;

    @BindView(R2.id.edt_bil1)
    EditText bil1;

    @BindView(R2.id.edt_bil2)
    EditText bil2;

    @BindView(R2.id.tv_hasil)
    TextView hasil;

    String pilihan = "Tambah";

    @BindView(R2.id.btn_hitung)
    Button hitung;

    @BindView(R2.id.btn_clear)
    Button clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Kalkulator Sederhana");

        ButterKnife.bind(this);

//        bil1 = findViewById(R.id.edt_bil1);
//        bil2 = findViewById(R.id.edt_bil2);
//        hasil = findViewById(R.id.tv_hasil);
//
//        hitung = findViewById(R.id.btn_hitung);
//        rbtambah = findViewById(rb_plus);
//        rbkurang = findViewById(R.id.rb_minus);
//        rbkali = findViewById(R.id.rb_multiply);
//        rbbagi = findViewById(R.id.rb_bagi);
//        rbtambah.isChecked();
//        rd_group = findViewById(R.id.rd_group);
//
//        clear = findViewById(R.id.btn_clear);

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbtambah.isChecked()) {
                    pilihan = "tambah";
                } else if (rbkurang.isChecked()) {
                    pilihan = "kurang";
                } else if (rbkali.isChecked()) {
                    pilihan = "kali";
                } else if (rbbagi.isChecked()) {
                    pilihan = "bagi";
                }

                String b1 = bil1.getText().toString().trim();
                String b2 = bil2.getText().toString().trim();

                double db1 = Double.parseDouble(b1);
                double db2 = Double.parseDouble(b2);

                double tvhasil = 0;

                if (pilihan.equalsIgnoreCase("tambah")) {
                    tvhasil = db1 + db2;
                } else if (pilihan.equalsIgnoreCase("kurang")) {
                    tvhasil = db1 - db2;
                } else if (pilihan.equalsIgnoreCase("kali")) {
                    tvhasil = db1 * db2;
                } else if (pilihan.equalsIgnoreCase("bagi")) {
                    tvhasil = db1 / db2;
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
                rbtambah.setChecked(true);
            }
        });

    }

}

