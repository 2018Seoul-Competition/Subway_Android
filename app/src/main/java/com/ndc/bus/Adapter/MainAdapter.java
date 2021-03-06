package com.ndc.bus.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ndc.bus.BR;
import com.ndc.bus.Listener.LogRecyclerViewClickListener;
import com.ndc.bus.Listener.LogRemoveClickListener;
import com.ndc.bus.databinding.LogRowBinding;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {
    private final LogRecyclerViewClickListener listener;
    private final LogRemoveClickListener logRemoveClickListener;
    private ArrayList<String> vehNmList;


    public MainAdapter(ArrayList<String> vehNmList, LogRecyclerViewClickListener listener, LogRemoveClickListener logRemoveClickListener) {
        this.vehNmList = vehNmList;
        this.listener = listener;
        this.logRemoveClickListener = logRemoveClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LogRowBinding binding = LogRowBinding.
                inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MainAdapter.MyViewHolder holder, final int position) {
        holder.bind(vehNmList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return vehNmList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private LogRowBinding binding;

        MyViewHolder(LogRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(final String vehNm, final LogRecyclerViewClickListener listener) {
            binding.setVariable(BR.vehNm, vehNm);
            binding.vehNmTv.setText(vehNm);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(vehNm);
                }
            });
            binding.logRmvBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    logRemoveClickListener.removeLog(vehNm);
                }
            });
        }
    }
}