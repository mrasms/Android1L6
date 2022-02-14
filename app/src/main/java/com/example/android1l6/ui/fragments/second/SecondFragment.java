package com.example.android1l6.ui.fragments.second;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android1l6.R;
import com.example.android1l6.databinding.FragmentSecondBinding;
import com.example.android1l6.model.Model;
import com.example.android1l6.ui.fragments.first.FirstFragment;

import java.util.Locale;

public class SecondFragment extends Fragment {
    Model modelData;
    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listeners();
        getData();
    }

    private void listeners() {
        binding.btnToSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = (TextView) binding.timer;
                CountDownTimer Timer = new CountDownTimer(6000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        textView.setText(String.format(Locale.getDefault(), "%d ", millisUntilFinished / 1000L));
                    }

                    public void onFinish() {
                        /*textView.setText("");
                        String message = binding.etData.getText().toString().trim();
                        Bundle bundle = new Bundle();
                        bundle.putString("sendMessage", message);
                        FirstFragment firstFragment = new FirstFragment();
                        firstFragment.setArguments(bundle);
                        getParentFragmentManager().beginTransaction().replace(R.id.container_fragment, firstFragment).commit();*/
                        save();
                    }
                }.start();
            }
        });
    }

    private void save() {
        String data = binding.etData.getText().toString().trim();
        if (data.isEmpty()) {
            binding.etData.setError("Input text");
            /*SecondFragment secondFragment = new SecondFragment();
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment, secondFragment).commit();*/

        } else {
            modelData = new Model(data);
            Bundle bundle = new Bundle();
            bundle.putSerializable("key", modelData);
            FirstFragment firstFragment = new FirstFragment();
            firstFragment.setArguments(bundle);
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.container_fragment, firstFragment).commit();
        }
    }

    private void getData() {
        if (getArguments() != null) {
            modelData = (Model) getArguments().getSerializable("key1");
            binding.etData.setText(modelData.getData());
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}