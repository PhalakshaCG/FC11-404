package com.not404.antifake.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.not404.antifake.Loading;
import com.not404.antifake.MainActivity;
import com.not404.antifake.QuestionAndQuery;
import com.not404.antifake.R;
import com.not404.antifake.URLtool;
import com.not404.antifake.databinding.FragmentHomeBinding;
import com.not404.antifake.ui.CheckClaim;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

public class HomeFragment extends Fragment implements CheckClaim.AsyncTaskCallback {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        View root = binding.getRoot();
        return root;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Button claim = (Button) getView().findViewById(R.id.check);
        claim.setOnClickListener(this::checkClaim);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public String sendClaim(String claim) throws IOException {
        return null;
        }
    public void checkClaim(View view) {
        String claim = String.valueOf(((EditText)getView().findViewById(R.id.claimText)).getText());
        URLtool app = ((URLtool)getActivity().getApplication());
        String url = app.url;
        new CheckClaim(this).execute(claim,url);
        Intent intent = new Intent(getActivity(), Loading.class);
        startActivity(intent);
    }
    public void onPostExecute(HashMap<String,String> map){

        Intent intent = new Intent(getActivity(), QuestionAndQuery.class);
        intent.putExtra("questions",map.get("question"));
        intent.putExtra("answers",map.get("statement"));
        intent.putExtra("claim",map.get("claim"));
        intent.putExtra("response",map.get("truth"));
        intent.putExtra("url",map.get("url"));
        startActivity(intent);
    }
}