package com.example.homeworke32;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainFragment extends Fragment {

    private Button btnNext;
    private TextView textView;
    private TextView secondText;
    private Button btnPlus;
    private Button btnMinus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();
        initListener();
    }

    private void initListener() {
        btnNext.setOnClickListener(view -> {

            Bundle bundle = new Bundle();
            bundle.putString("key", textView.getText().toString());

            SecondFragment secondFragment = new SecondFragment();
            secondFragment.setArguments(bundle);

                requireActivity().getSupportFragmentManager().beginTransaction().replace
                (R.id.fragment_container, secondFragment).addToBackStack(null).commit();
        });

        btnPlus.setOnClickListener(view -> {
            Integer one = 1;
            Integer text = Integer.valueOf(textView.getText().toString());
            Integer result = one + text;
            textView.setText(result.toString());
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer one = 1;
                Integer text = Integer.valueOf(textView.getText().toString());
                Integer result = text - one;
                textView.setText(result.toString());
            }
        });
    }

    private void initView() {
        btnNext = requireActivity().findViewById(R.id.btn_next);
        btnPlus = requireActivity().findViewById(R.id.btn_plus);
        textView = requireActivity().findViewById(R.id.text_view);
        btnMinus = requireActivity().findViewById(R.id.btn_minus);
    }
}