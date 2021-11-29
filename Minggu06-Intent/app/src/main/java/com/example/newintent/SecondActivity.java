package com.example.newintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    // inisialisasi variable
    TextView txtnim, txtnama, txtprodi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // mengakses layout TextView berdasarkan id
        txtnim = (TextView) findViewById(R.id.txtnim);
        txtnama = (TextView) findViewById(R.id.txtnama);
        txtprodi = (TextView) findViewById(R.id.txtprodi);

        // mengambil data dari extra yang input
        Bundle extras = getIntent().getExtras();
        String nim = extras.getString("nim");
        String nama = extras.getString("nama");
        String prodi = extras.getString("prodi");

        // menampilkan data ke masing-masing TextView
        txtnim.setText(nim);
        txtnama.setText(nama);
        txtprodi.setText(prodi);
    }
}