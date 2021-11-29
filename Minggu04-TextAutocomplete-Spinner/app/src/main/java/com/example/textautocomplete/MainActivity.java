package com.example.textautocomplete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] Jurusan = {"Teknologi Informasi", "Teknik", "Kesehatan", "Peternakan", "Bahasa, Komunikasi dan Pariwisata", "Produksi Pertanian", "Teknologi Pertanian", "Manajemen Agribisnis"};
    String[] Prodi = {"Teknik Komputer", "Teknik Informatika", "Manajemen Informatika", "Bahasa Inggris","Teknik Energi Terbarukan", "Teknologi Rekayasa Mekatronika", "Rekam Medik", "Gizi Klinik", "Mesin Otomotif", "Manajemen Agribisnis", "Manajemen Agroindustri", "Akuntansi Sektor Publik", "Produksi Ternak"};
    Spinner agama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button simpan;
        EditText nim, nama;
        TextView hasil;
        RadioGroup jkelamin;
        Spinner sagama;
        AutoCompleteTextView aprodi, ajurusan;

        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.prodi);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Prodi);
        autoCompleteTextView.setAdapter(arrayAdapter);
        autoCompleteTextView.setThreshold(1);

        autoCompleteTextView = findViewById(R.id.jurusan);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Jurusan);
        autoCompleteTextView.setAdapter(arrayAdapter);
        autoCompleteTextView.setThreshold(1);

        agama = findViewById(R.id.agama);
        ArrayAdapter<CharSequence> adapter = arrayAdapter.createFromResource(this, R.array.agama, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        agama.setAdapter(adapter);
//        agama.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String agama = parent.getItemAtPosition(position).toString();
//                Toast.makeText(parent.getContext(), agama + " is selected", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

        simpan = (Button) findViewById(R.id.simpan);
        nim = (EditText) findViewById(R.id.nim);
        nama = (EditText) findViewById(R.id.nama);
        hasil = (TextView) findViewById(R.id.hasil);
        jkelamin = (RadioGroup) findViewById(R.id.kelamin);
        ajurusan = (AutoCompleteTextView) findViewById(R.id.jurusan);
        aprodi = (AutoCompleteTextView) findViewById(R.id.prodi);
        sagama = (Spinner) findViewById(R.id.agama);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputnim = String.valueOf(nim.getText().toString());
                String inputnama = String.valueOf(nama.getText().toString());
                String inputjurusan = String.valueOf(ajurusan.getText().toString());
                String inputprodi = String.valueOf(aprodi.getText().toString());

                int gender = jkelamin.getCheckedRadioButtonId();
                RadioButton kelamin = (RadioButton) findViewById(gender);
                String inputkelamin = String.valueOf(kelamin.getText().toString());

                hasil.setText("Data Mahasiswa" +
                        "\n" + "NIM\t\t\t\t\t\t\t\t\t\t\t\t\t: " + inputnim + "\n" +
                        "Nama Lengkap\t\t\t: " + inputnama + "\n" +
                        "Jenis Kelamin\t\t\t\t\t: " + inputkelamin + "\n" +
                        "Agama\t\t\t\t\t\t\t\t\t\t: " + sagama.getSelectedItem().toString() + "\n" +
                        "Jurusan\t\t\t\t\t\t\t\t\t: " + inputjurusan + "\n" +
                        "Program Studi\t\t\t\t: " + inputprodi + "\n");
            }
        });

    }
}