package com.crisspian.logotrivia;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavAction;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.crisspian.logotrivia.databinding.FragmentLogoTriviaBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LogoTriviaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LogoTriviaFragment extends Fragment {
    FragmentLogoTriviaBinding binding;
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    public static final int OPT_01 = 0;
    public static final int OPT_02 = 1;
    public static final int OPT_03 = 2;
    public static final int OPT_04 = 3;

    private int choice;

    public LogoTriviaFragment() {
        // Required empty public constructor
    }

    public static LogoTriviaFragment newInstance(String param1, String param2) {
        LogoTriviaFragment fragment = new LogoTriviaFragment();
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
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLogoTriviaBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        String greeting = getString(R.string.greeting, mParam1);
        binding.triviaNameTv.setText(greeting);

        binding.triviaRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = binding.triviaRg.findViewById(checkedId);
                int index = binding.triviaRg.indexOfChild(radioButton);
                switch (index) {
                    case OPT_01:
                        choice = OPT_01;
                        break;
                    case OPT_02:
                        choice = OPT_02;
                        break;
                    case OPT_03:
                        choice = OPT_03;
                        break;
                    case OPT_04:
                        choice = OPT_04;
                        break;
                    default:
                        choice = 5;
                        break;
                }

            }
        });

        binding.triviaSendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (choice == OPT_03) {
                    Navigation.findNavController(binding.getRoot()).navigate(R.id.action_logoTriviaFragment_to_winFragment, getArguments());
                } else {
                    Navigation.findNavController(binding.getRoot()).navigate(R.id.action_logoTriviaFragment_to_tryAgainFragment, getArguments());
                }
            }
        });

        return view;
    }
}