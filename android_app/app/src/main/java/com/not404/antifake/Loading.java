package com.not404.antifake;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.not404.antifake.databinding.LoadingScreenBinding;

public class Loading extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private LoadingScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = LoadingScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        VideoView videoView = findViewById(R.id.video_view);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.loading;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.setZOrderOnTop(true);
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(null);
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                videoView.start(); //need to make transition seamless.
            }
        });
        videoView.start();
        mediaController.setAnchorView(videoView);

    }
    public void changeActivity(){
        Intent intent = new Intent(this,QuestionAndQuery.class);
        startActivity(intent);
    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_loading);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}