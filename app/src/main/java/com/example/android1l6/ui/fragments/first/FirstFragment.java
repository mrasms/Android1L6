package com.example.android1l6.ui.fragments.first;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android1l6.R;
import com.example.android1l6.databinding.FirstFragmentBinding;
import com.example.android1l6.listener.OnClickListener;
import com.example.android1l6.model.ModelData;
import com.example.android1l6.ui.fragments.first.adapter.DataAdapter;
import com.example.android1l6.ui.fragments.second.SecondFragment;

import java.util.List;

public class FirstFragment extends Fragment {
    private FirstFragmentBinding binding;
    DataAdapter adapterData;
    ModelData modelData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FirstFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapterData = new DataAdapter();
        binding.recycleviewFirsFragment.setAdapter(adapterData);
        listener();
        getData();

    }

    private void listener() {
        binding.btnTransition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondFragment secondFragment = new SecondFragment();
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment, secondFragment).commit();
            }

        });

        adapterData.setOnItemClickListener(new OnClickListener() {
            @Override
            public void onItemClickListener(int position, ModelData modelData) {
                SecondFragment secondFragment = new SecondFragment();
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment, secondFragment).commit();
                ModelData modelData1 = new ModelData(adapterData.list.get(position).getData());
                Bundle bundle = new Bundle();
                bundle.putSerializable("key1", modelData1);
                secondFragment.setArguments(bundle);
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container_fragment, secondFragment).commit();


            }
        });
    }


    private void getData() {
        if (getArguments() != null) {
            modelData = (ModelData) getArguments().getSerializable("key");
            adapterData.addData(modelData);
        }


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}