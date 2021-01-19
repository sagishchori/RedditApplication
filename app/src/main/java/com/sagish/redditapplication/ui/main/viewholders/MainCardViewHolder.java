package com.sagish.redditapplication.ui.main.viewholders;

import androidx.databinding.ViewDataBinding;

import com.sagish.redditapplication.databinding.CardViewHolderBinding;
import com.sagish.redditapplication.databinding.MainCardViewItemBinding;
import com.sagish.redditapplication.ui.main.models.ChildrenItem;
import com.squareup.picasso.Picasso;

public class MainCardViewHolder extends CardViewHolder<ChildrenItem> {

    private MainCardViewItemBinding childBinding;

    public MainCardViewHolder(CardViewHolderBinding binding) {
        super(binding);
    }

    @Override
    public void bindChildView(ViewDataBinding childViewBinding) {
        super.bindChildView(childViewBinding);
        this.childBinding = (MainCardViewItemBinding) childViewBinding;
    }

    @Override
    public void bindData(ChildrenItem data) {
        childBinding.setData(data);
        Picasso.get().load(data.getData().getThumbnail()).into(childBinding.image);
    }
}
