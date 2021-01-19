package com.sagish.redditapplication.ui.main.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.sagish.redditapplication.R;
import com.sagish.redditapplication.databinding.ArticleCardViewItemBinding;
import com.sagish.redditapplication.databinding.CardViewHolderBinding;
import com.sagish.redditapplication.ui.main.models.ChildrenItem;
import com.sagish.redditapplication.ui.main.viewholders.ArticleCardViewHolder;
import com.sagish.redditapplication.ui.main.viewholders.CardViewHolder;

public class ArticleAdapter extends CardViewAdapter<ChildrenItem> {

    public ArticleAdapter(OnItemClickListener listener) {
        super(listener);
    }

    @NonNull
    @Override
    public ArticleCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardViewHolderBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.card_view_holder, parent, false);
        return new ArticleCardViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);

        ArticleCardViewItemBinding articleCardViewItemBinding = ArticleCardViewItemBinding
                .inflate(LayoutInflater.from(holder.itemView.getContext()));
        holder.bindChildView(articleCardViewItemBinding);

        holder.bindData(list.get(position));
    }
}
