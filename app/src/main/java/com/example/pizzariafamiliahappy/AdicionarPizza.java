package com.example.pizzariafamiliahappy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class AdicionarPizza extends AppCompatActivity {

    private TextInputEditText sabor;
    private TextInputEditText preco;
    private Button adicionar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_pizza);


        sabor = findViewById(R.id.sabor_edit_text);
        preco = findViewById(R.id.preco_exit_text);
        adicionar =findViewById(R.id.adicionar_button);

        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voltarParaMain();
                adicionarPizza();
            }
        });
    }

    private void adicionarPizza() {


    }

    private void voltarParaMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
