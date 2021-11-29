package com.example.newintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //inisialisasi variable
    EditText txtnama, txtnim, txtprodi;
    Button explicitintent, implicitintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // mengakses id tombol masing masing
        explicitintent = (Button) findViewById(R.id.explicit);
        explicitintent.setOnClickListener(this);
        implicitintent = (Button) findViewById(R.id.implicit);
        implicitintent.setOnClickListener(this);

        //mengakses layout EditText dengan id
        txtnim = (EditText) findViewById(R.id.txtnim);
        txtnama = (EditText) findViewById(R.id.txtnama);
        txtprodi = (EditText) findViewById(R.id.txtprodi);


    }

    @Override
    public void onClick(View v) {
        //membuat pengkondisian untuk mentukan tombol mana yang dijalankan
        switch(v.getId()) {
            // memberi aksi untuk tombol explicit
            case (R.id.explicit) :
                String nama = txtnama.getText().toString(); // mengambil data nama
                String nim =  txtnim.getText().toString(); // mengambil data nim
                String prodi = txtprodi.getText().toString(); // mengambil data prodi
                Intent explicit = new Intent(MainActivity.this, SecondActivity.class); //mengarahkan intent ke activity lain
                explicit.putExtra("nim", nim); //menambahkan data nim
                explicit.putExtra("nama", nama); // menambahkan data nama
                explicit.putExtra("prodi", prodi); // menambahkan data prodi
                startActivity(explicit); // pindah activity
                break;

                // memberi aksi untuk tombol implisit
            case (R.id.implicit):
                // mengakses url tertentu, maka akan ada opsi membuka dengan app lain
                Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/file/d/1m4zl1pLrnAAZCx4l1JueMKGiWXTv1krs/view?usp=sharing"));
                startActivity(implicit);
                break;
            default:
                break;
        }
    }
}