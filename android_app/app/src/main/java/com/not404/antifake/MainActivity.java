package com.not404.antifake;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.not404.antifake.databinding.ActivityMainBinding;
import com.not404.antifake.ui.CheckClaim;

import java.io.IOException;
import java.util.HashMap;

public class MainActivity  extends AppCompatActivity implements CheckClaim.AsyncTaskCallback {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    public static String url="https://8f81-171-76-80-155.in.ngrok.io/quicktool?claim1=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        URLtool here = (URLtool)this.getApplication();
        here.url="https://8f81-171-76-80-155.in.ngrok.io/quicktool?claim1=";
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarMain.toolbar);
        getResources();
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        ImageView iv = findViewById(R.id.homeLogo);
//
//        iv.setImageResource();
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    public void checkClaim(){

    }
    public void onPostExecute(HashMap<String,String> map){
        Intent intent = new Intent(this, QuestionAndQuery.class);
        startActivity(intent);
    }
}