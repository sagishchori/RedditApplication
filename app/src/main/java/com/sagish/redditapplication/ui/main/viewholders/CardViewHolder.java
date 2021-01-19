package com.sagish.redditapplication.ui.main.viewholders;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.sagish.redditapplication.databinding.CardViewHolderBinding;

public class CardViewHolder<T> extends RecyclerView.ViewHolder {

    private CardViewHolderBinding binding;

    public CardViewHolder(CardViewHolderBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bindChildView(ViewDataBinding childViewBinding) {
        binding.card.removeAllViews();
        binding.card.addView(childViewBinding.getRoot());
    }

    public void bindData(T data) {

    };
}
