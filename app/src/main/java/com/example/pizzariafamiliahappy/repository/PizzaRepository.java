package com.example.pizzariafamiliahappy.repository;

import com.example.pizzariafamiliahappy.model.Pizza;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;


public class PizzaRepository {

    public Observable<List<Pizza>> buscarListaPizzas (){
        return Observable.create(emitter -> {
            List<Pizza> pizzaList = new ArrayList<>();
            Pizza pizza1 = new Pizza("calabresa", 23.00F);
            Pizza pizza2 = new Pizza("mussarela", 23.00F);
            Pizza pizza3 = new Pizza("atum", 23.00F);
            Pizza pizza4 = new Pizza("portuguesa", 23.00F);
            Pizza pizza5 = new Pizza("frango", 23.00F);
            Pizza pizza6 = new Pizza("bacon", 23.00F);
            pizzaList.add(pizza1);
            pizzaList.add(pizza2);
            pizzaList.add(pizza3);
            pizzaList.add(pizza4);
            pizzaList.add(pizza5);
            pizzaList.add(pizza6);

            emitter.onNext(pizzaList);
            emitter.onComplete();
        } );
    }
}
