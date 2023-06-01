package com.example.screenspaceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class inicio_admin extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    private BottomNavigationView.OnItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.action_cines:
                            // Reemplazar con el fragmento que desees mostrar para "Cines"
                            replaceFragment(new CinesFragment());
                            return true;
                        case R.id.action_opciones:
                            // Reemplazar con el fragmento que desees mostrar para "Opciones"
                            replaceFragment(new OpcionesFragment());
                            return true;
                    }
                    return false;
                }
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_admin);

        bottomNavigationView = findViewById(R.id.navigation_view);
        bottomNavigationView.setOnItemSelectedListener(navigationItemSelectedListener);

        // Mostrar el fragmento inicial (por ejemplo, CinesFragment)
        replaceFragment(new CinesFragment());
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}