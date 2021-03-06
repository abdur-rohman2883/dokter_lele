package com.application.abdur_rohman.dokter_lele;

import android.content.Intent;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.application.abdur_rohman.dokter_lele.basis.RiwayatPenyakit;
import java.util.ArrayList;
import java.util.List;

public class MainMenu extends AppCompatActivity {
    //Mendefinisikan variabel
    private Toolbar toolbar;
    private RelativeLayout layout_root;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    public List<RiwayatPenyakit> list_penyakit = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Mensetting layout yang digunakan pada kelas MainMenu dengan activity_main_menu
        setContentView(R.layout.activity_main_menu);
        //Mensetting layout toolbar sebagai actionBar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView penjelasan = (TextView) findViewById(R.id.textViewAplikasiPenjelasan);
        //Mensetting text pada penjelasan
        penjelasan.setText(R.string.penjelasan_aplikasi);
        //Menginisialisasi  NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        int startEnd = getResources().getDimensionPixelOffset(R.dimen.sepuluh);
        int top = getResources().getDimensionPixelOffset(R.dimen.lima_puluh);
        layout_root = navigationView.getHeaderView(0).findViewById(R.id.layout_root);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(MainMenu.this, R.color.colorPrimaryDark));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(startEnd, top, startEnd, 0);
            layout_root.setLayoutParams(params);
        } else {

        }
        //Mengatur Item NavigationView yang akan dipanggil untuk menangani item klik menu navigasi
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            //This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                drawerLayout.closeDrawers();
                //Memeriksa untuk melihat item yang akan dilklik dan melalukan aksi
                switch (menuItem.getItemId()){
                    //Pilihan menu item navigasi
                    case R.id.menu_diagnosa:
                        //Menampilkan pesan
                        Toast.makeText(getApplicationContext(), R.string.toast_1,
                                Toast.LENGTH_SHORT).show();
                        //Mengubungkan ke tampilan gejala awal diagnosa
                        Intent mulai_diagnosa = new Intent(MainMenu.this, G03.class);
                        startActivity(mulai_diagnosa);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        return true;
                    case R.id.menu_penyakit:
                        Toast.makeText(getApplicationContext(),R.string.toast_2,
                                Toast.LENGTH_SHORT).show();
                        //Menghubungkan ke tampilan data penyakit
                        Intent data_penyakit = new Intent(MainMenu.this, DaftarPenyakit.class);
                        startActivity(data_penyakit);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        return true;
                    case R.id.menu_gejala:
                        Toast.makeText(getApplicationContext(),R.string.toast_3,
                                Toast.LENGTH_SHORT).show();
                        //Menghubungkan ke tampilan data penyakit
                        Intent data_gejala = new Intent(MainMenu.this, DaftarGejala .class);
                        startActivity(data_gejala);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        return true;
                    case R.id.riwayat_penyakit:
                        Toast.makeText(getApplicationContext(),R.string.toast_4,
                                Toast.LENGTH_SHORT).show();
                        //Menghubungkan ke tampilan data penyakit
                        Intent data_riwayat = new Intent(MainMenu.this, RiwayatPenyakiIkanLele .class);
                        list_penyakit.clear();
                        startActivity(data_riwayat);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        return true;
                    case R.id.keluar:
                        Toast.makeText(getApplicationContext(),R.string.toast_5,
                                Toast.LENGTH_SHORT).show();
                        //Menutup aplikasi
                        Intent intent = new Intent(MainMenu.this, SplashScreen.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        moveTaskToBack(true);
                        return true;
                }
                return true;
            }
        });
        //Menginisasi Drawer Layout dan ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.openDrawer, R.string.closeDrawer){
            @Override
            public void onDrawerClosed(View drawerView) {
                //Kode di bawah akan merespons setelah drawer menutup
                super.onDrawerClosed(drawerView);
            }
            @Override
            public void onDrawerOpened(View drawerView) {
                //Kode di bawah akan merespons setelah drawer terbuka
                super.onDrawerOpened(drawerView);
            }
        };
        //Mensetting actionbarToggle untuk drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        //Mensikronkan actionBarDrawerToggle
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed(){
        Toast.makeText(getApplicationContext(),R.string.toast_5,
                Toast.LENGTH_SHORT).show();
        finishAffinity();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
