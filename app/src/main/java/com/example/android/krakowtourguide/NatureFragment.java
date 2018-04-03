package com.example.android.krakowtourguide;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NatureFragment extends Fragment {

    public NatureFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        // Get the title of every card from array resource file and put them in Array object
        String[] cardTitle = getResources().getStringArray(R.array.nature_title);
        // Get the text for body of every card from array resource file and put them in Array object
        String[] cardBody = getResources().getStringArray(R.array.nature_body);
        // Get the resource ID of images for cards from array resource file and put them in TypedArray object
        final TypedArray cardImage = getResources().obtainTypedArray(R.array.nature_image);

        // Create a list of Card objects
        final ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i < cardTitle.length; i++) {
            cards.add(new Card(cardImage.getResourceId(i, -1), cardTitle[i], cardBody[i]));
        }
        cardImage.recycle();

        // Find the RecyclerView in the layout
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        // Set the adapter on the RecyclerView
        RecyclerView.Adapter adapter = new ListAdapter(cards);
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}