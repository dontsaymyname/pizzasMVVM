package com.example.pizzariafamiliahappy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pizzariafamiliahappy.adapter.PizzaAdapter;
import com.example.pizzariafamiliahappy.viewmodel.PizzaViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PizzaAdapter pizzaAdapter = new PizzaAdapter();
    private PizzaViewModel pizzaViewModel;
    private FloatingActionButton fabAdicionarPizza;
    private FloatingActionButton fabCalcularTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.pizzas_recycler_view_id);
        recyclerView.setAdapter(pizzaAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        pizzaViewModel = ViewModelProviders.of(this).get(PizzaViewModel.class);

        pizzaViewModel.atualizarPizza();

        pizzaViewModel.getPizzaLiveData().observe(this, pizzaList -> {
            pizzaAdapter.updatePizzaList(pizzaList);
        });

        fabAdicionarPizza = findViewById(R.id.fab_adicionar_pizza);
        fabCalcularTotal = findViewById(R.id.fab_calcular_total);

        fabAdicionarPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irParaAdicionarPizza();
            }
        });

        fabCalcularTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irParaCalcularTotal();
            }
        });


    }

    private void irParaAdicionarPizza() {
        Intent intent = new Intent(this, AdicionarPizza.class);
        startActivity(intent);
    }

    private void irParaCalcularTotal() {
        Intent intent = new Intent(this, CalcularTotal.class);
        startActivity(intent);
    }


}
