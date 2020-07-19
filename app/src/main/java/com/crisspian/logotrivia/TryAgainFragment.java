package com.crisspian.logotrivia;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crisspian.logotrivia.databinding.FragmentTryAgainBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TryAgainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TryAgainFragment extends Fragment {

    FragmentTryAgainBinding binding;
    private static final String ARG_PARAM1 = "param1";


    // TODO: Rename and change types of parameters
    private String mParam1;


    public TryAgainFragment() {
        // Required empty public constructor
    }


    public static TryAgainFragment newInstance(String param1, String param2) {
        TryAgainFragment fragment = new TryAgainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTryAgainBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        String text = getString(R.string.try_again_msg, mParam1);
        binding.trayAgainTv.setText(text);

        binding.tryAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_tryAgainFragment_to_logoTriviaFragment, getArguments());
            }
        });

        return view;
    }
}