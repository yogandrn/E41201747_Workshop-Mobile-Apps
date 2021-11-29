package com.example.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    //Deklarasi variable
    BottomNavigationView bottomNav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // mengakses id layout "navigasi"
        bottomNav = findViewById(R.id.navigasi);

        // membuat fragment home sebagai fragment default
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        // membuat aksi di bottom_navigation
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // membuat objek dari fragment, dan set nilai awal null(kosong)
                Fragment selectedFragment = null;

                // pengkondisian untuk menentukan fragment yang ditampilkan
                switch(item.getItemId()) {
                    case R.id.nav_home: //jika yang terpilih nav_home
                        selectedFragment = new HomeFragment(); // tampilkan fragment home
                        break;
                    case R.id.nav_wishlist: //jika yang terpilih nav_wishlist
                        selectedFragment = new WishlistFragment(); // tampilkan fragment wishlist
                        break;
                    case R.id.nav_profil: //jika yang terpilih nav_profil
                        selectedFragment = new ProfilFragment(); // tampilkan fragment profil
                        break;
                    case R.id.nav_setting: //jika yang terpilih nav_setting
                        selectedFragment = new SettingFragment(); // tampilkan fragment setting
                        break;
                }

                //memanggil fungsi untuk mengubah setiap fragment
                // replace "fragment_container" dengan fragment yang baru yaitu "selectedFragment"
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                return true;
            }
        });
    }
}