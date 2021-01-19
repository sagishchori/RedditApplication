package com.sagish.redditapplication.ui.main.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.sagish.redditapplication.R;
import com.sagish.redditapplication.databinding.CardViewHolderBinding;
import com.sagish.redditapplication.databinding.MainCardViewItemBinding;
import com.sagish.redditapplication.ui.main.models.ChildrenItem;
import com.sagish.redditapplication.ui.main.viewholders.CardViewHolder;
import com.sagish.redditapplication.ui.main.viewholders.MainCardViewHolder;

public class MainAdapter extends CardViewAdapter<ChildrenItem> {

    public MainAdapter(OnItemClickListener listener) {
        super(listener);
    }

    @NonNull
    @Override
    public MainCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardViewHolderBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.card_view_holder, parent, false);
        return new MainCardViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);

        MainCardViewItemBinding mainCardViewItemBinding = MainCardViewItemBinding
                .inflate(LayoutInflater.from(holder.itemView.getContext()));
        holder.bindChildView(mainCardViewItemBinding);
        final ChildrenItem item = list.get(position);
        holder.bindData(item);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClicked(item);
                }
            }
        });
    }
}
