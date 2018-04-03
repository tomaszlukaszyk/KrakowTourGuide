package com.example.android.krakowtourguide;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    // List of all cards to display
    private final ArrayList<Card> cards;

    // Provides a reference to the views for each data item
    static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView cardTitleView;
        private final TextView cardBodyView;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.card_image);
            cardTitleView = itemView.findViewById(R.id.card_title);
            cardBodyView = itemView.findViewById(R.id.card_body);
        }
    }

    // Constructor for adapter
    ListAdapter(ArrayList<Card> cards) {
        this.cards = cards;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        // - get Card object at this position
        // - replace the contents of the view with data form Card object
        viewHolder.imageView.setImageResource(cards.get(position).getImage());
        viewHolder.cardTitleView.setText(cards.get(position).getTitle());
        viewHolder.cardBodyView.setText(cards.get(position).getBody());
    }

    // Return the size of list (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return cards.size();
    }
}