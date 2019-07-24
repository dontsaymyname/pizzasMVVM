package com.example.pizzariafamiliahappy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pizzariafamiliahappy.R;
import com.example.pizzariafamiliahappy.model.Pizza;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.ViewHolder> {

    private List<Pizza> pizzaList = new ArrayList<>();

    public void updatePizzaList (List<Pizza> pizzaList){
        this.pizzaList = pizzaList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pizza_cell, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pizza pizza = pizzaList.get(position);
        holder.bind(pizza);

    }

    @Override
    public int getItemCount() {
        return pizzaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nomeTextView;
        private TextView precoTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nomeTextView = itemView.findViewById(R.id.pizza_nome_text_view);
            precoTextView = itemView.findViewById(R.id.preco_text_view);

        }

        public void bind(Pizza pizza) {
            nomeTextView.setText(pizza.getNome());
            precoTextView.setText("" + pizza.getPreco());

        }
    }
}
