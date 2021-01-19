package com.sagish.redditapplication.ui.main.viewholders;

import androidx.databinding.ViewDataBinding;

import com.sagish.redditapplication.databinding.ArticleCardViewItemBinding;
import com.sagish.redditapplication.databinding.CardViewHolderBinding;
import com.sagish.redditapplication.ui.main.models.ChildrenItem;
import com.squareup.picasso.Picasso;

public class ArticleCardViewHolder extends CardViewHolder<ChildrenItem> {

    private ArticleCardViewItemBinding childBinding;

    public ArticleCardViewHolder(CardViewHolderBinding binding) {
        super(binding);
    }

    @Override
    public void bindChildView(ViewDataBinding childViewBinding) {
        super.bindChildView(childViewBinding);
        this.childBinding = (ArticleCardViewItemBinding) childViewBinding;
    }

    @Override
    public void bindData(ChildrenItem data) {
        childBinding.setData(data);
        Picasso.get().load(data.getData().getThumbnail()).into(childBinding.image);
    }
}
