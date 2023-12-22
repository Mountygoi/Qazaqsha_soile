package com.example.qazaqshasoile;

import static androidx.browser.customtabs.CustomTabsClient.getPackageName;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class Film1 extends Fragment {
 @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_film1, container, false);
        VideoView videoView = view.findViewById(R.id.videoView);
        ImageView imageView = view.findViewById(R.id.bk);
        String path = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.filmm;
        Uri uri = Uri.parse(path);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(requireContext());
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment film2 = new Filmkoru();
                FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_container,film2).addToBackStack(null).commit();
            }
        });

        return view;
    }
}