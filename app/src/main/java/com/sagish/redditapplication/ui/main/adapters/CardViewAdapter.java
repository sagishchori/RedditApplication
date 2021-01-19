package com.sagish.redditapplication.ui.main.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.sagish.redditapplication.R;
import com.sagish.redditapplication.databinding.CardViewHolderBinding;
import com.sagish.redditapplication.ui.main.models.ChildrenItem;
import com.sagish.redditapplication.ui.main.viewholders.CardViewHolder;

import java.util.ArrayList;

public class CardViewAdapter<T> extends RecyclerView.Adapter<CardViewHolder> {

    protected ArrayList<T> list = new ArrayList<>();
    protected OnItemClickListener listener;

    public CardViewAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardViewHolderBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.card_view_holder, parent, false);
        return new CardViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(ArrayList<T> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    /**
     * An interface for card item click event.
     */
    public interface OnItemClickListener {

        /**
         * Notify an item was clicked.
         *
         * @param item  The data object that this item holds
         */
        void onItemClicked(ChildrenItem item);
    }
}
