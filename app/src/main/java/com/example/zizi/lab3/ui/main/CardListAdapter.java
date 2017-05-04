package com.example.zizi.lab3.ui.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zizi.lab3.R;
import com.example.zizi.lab3.model.Card;
import com.example.zizi.lab3.ui.details.DetailsActivity;
import com.example.zizi.lab3.ui.editor.EditorActivity;

import java.util.ArrayList;
import java.util.List;

public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.ViewHolder> {

    final private List<Card> cards = new ArrayList<>();

    private MainScreen mainScreen;

    public CardListAdapter(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Card card = cards.get(position);

        holder.name.setText(card.getName());
        holder.favourite.setText(card.isFavourite() ? "favourite" : "");

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Context context = v.getContext();
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra(DetailsActivity.INTENT_EXTRA_CARD_ID, card.getId());

                context.startActivity(intent);
            }
        });

        holder.edit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            Context context = v.getContext();
            Intent intent = new Intent(context, EditorActivity.class);
            intent.putExtra(EditorActivity.INTENT_EXTRA_CARD_ID, card.getId());

            context.startActivity(intent);
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            mainScreen.deleteCard(card.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView favourite;
        ImageView edit;
        ImageView delete;

        ViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.card_name);
            favourite = (TextView) itemView.findViewById(R.id.card_favourite);
            edit = (ImageView) itemView.findViewById(R.id.card_edit);
            delete = (ImageView) itemView.findViewById(R.id.card_delete);
        }
    }

    public List<Card> getCards() {
        return cards;
    }
}
