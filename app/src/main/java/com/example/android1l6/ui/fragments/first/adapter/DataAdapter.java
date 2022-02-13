package com.example.android1l6.ui.fragments.first.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android1l6.databinding.HolderListDataBinding;
import com.example.android1l6.listener.OnClickListener;
import com.example.android1l6.model.ModelData;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.HolderData> {
    public ArrayList<ModelData> list = new ArrayList<>();
    OnClickListener onClickListener;

    public void setOnItemClickListener(OnClickListener onItemClickListener) {
        this.onClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HolderData(HolderListDataBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addData(ModelData modelData) {
        this.list.add(modelData);
        notifyDataSetChanged();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        private HolderListDataBinding binding;

        public HolderData(@NonNull HolderListDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(ModelData modelData) {
            binding.tvData.setText(modelData.getData());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickListener.onItemClickListener(getAdapterPosition(), modelData);
                }
            });


        }
    }
}
