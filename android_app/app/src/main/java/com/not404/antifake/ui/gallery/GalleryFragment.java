package com.not404.antifake.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.not404.antifake.MainActivity;
import com.not404.antifake.R;
import com.not404.antifake.URLtool;
import com.not404.antifake.databinding.FragmentGalleryBinding;
import com.not404.antifake.ui.CheckClaim;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        EditText text = getView().findViewById(R.id.text_gallery);
        Button button = (Button)getView().findViewById(R.id.bURL);
        URLtool app = ((URLtool)getActivity().getApplication());
        System.out.println(app.url);
        String U = app.url;
        if(app.url!=null)
            text.setText(U);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = text.getText().toString();
                if(app!=null)
                    app.url =s;
            }
        });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}