package com.crisspian.logotrivia;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavAction;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.NavGraph;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;
import androidx.navigation.Navigator;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.crisspian.logotrivia.databinding.FragmentTitleBinding;


public class TitleFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    FragmentTitleBinding binding;

    public TitleFragment() {
        // Required empty public constructor
    }

    public static TitleFragment newInstance() {
        TitleFragment fragment = new TitleFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTitleBinding.inflate(inflater, container,false);
        View view = binding.getRoot();


        binding.comenzarTriviaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!binding.nameTv.getText().toString().isEmpty()) {
                    Bundle args = new Bundle();
                    args.putString(ARG_PARAM1, binding.nameTv.getText().toString());
                    Navigation.findNavController(binding.getRoot()).navigate(R.id.action_titleFragment_to_logoTriviaFragment, args);
                } else {
                    Toast.makeText(getContext(), "Debes escribir tu nombre", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;
    }
}