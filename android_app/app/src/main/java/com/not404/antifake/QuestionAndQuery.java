package com.not404.antifake;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.not404.antifake.databinding.ActivityQuestionAndQueryBinding;

import java.net.MalformedURLException;
import java.net.URL;

public class QuestionAndQuery extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityQuestionAndQueryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestionAndQueryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        TextView question,answer;
        question=(TextView) findViewById(R.id.question1);
        answer = (TextView) findViewById(R.id.answer1);
        Intent i = getIntent();
        String q,ans,claim,response,url;
        url=i.getStringExtra("url");
        if(i.getStringExtra("questions").equals(""))
            q="Generating questions";
        else
            q = i.getStringExtra("questions");
        ans=i.getStringExtra("answers");
        if(ans==null)
            ans="Obtaining answers";
        claim=i.getStringExtra("claim");
        response=i.getStringExtra("response");
        question.setText(q);
        answer.setText(ans);
        ImageView white = findViewById(R.id.white);
        VideoView videoView = findViewById(R.id.video_view1);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.questions;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.setZOrderOnTop(true);
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(null);
        WebView webView = findViewById(R.id.webpage);
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                white.setVisibility(View.GONE);
                videoView.setVisibility(View.GONE); //need to make transition seamless.
                if(question.getText().toString().equals(q)) {
                    Handler handle = new Handler();
                    handle.postDelayed(new Runnable() {
                        public void run() {
                            white.setVisibility(View.VISIBLE);
                            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.response;
                            Uri uri = Uri.parse(videoPath);
                            videoView.setVideoURI(uri);
                            videoView.start();
                            question.setText(claim);
                            answer.setText(response);
                            videoView.setVisibility(View.VISIBLE);
                        }
                    }, 3000);
                }
                else{
                    if(webView.getVisibility()==View.GONE&&url!=null){
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println(url);
                                webView.loadUrl(url);
                                webView.setWebViewClient(new WebViewClient(){
                                    public void onPageFinished(WebView view, String url){
                                        webView.setVisibility(View.VISIBLE);
                                    }
                                });
                            }
                        },1000);
                    }
                }
            }
        });
        videoView.start();
        mediaController.setAnchorView(videoView);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_question_and_query);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}