package com.example.pizzariafamiliahappy.model;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Pizza {


    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "sabor")
    private String nome;

    @ColumnInfo(name = "preco")
    private Float preco;


    public Pizza () {}

    public Pizza(String nome, float preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
