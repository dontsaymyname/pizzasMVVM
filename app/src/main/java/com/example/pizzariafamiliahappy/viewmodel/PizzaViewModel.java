package com.example.pizzariafamiliahappy.viewmodel;

import android.app.Application;

import com.example.pizzariafamiliahappy.model.Pizza;
import com.example.pizzariafamiliahappy.repository.PizzaRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class PizzaViewModel extends AndroidViewModel {

    private MutableLiveData<List<Pizza>> listMutableLiveData = new MutableLiveData<>();
    private PizzaRepository repository = new PizzaRepository();
    private CompositeDisposable disposable = new CompositeDisposable();


    public PizzaViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Pizza>> getPizzaLiveData (){
        return listMutableLiveData;
    }

    public void atualizarPizza (){
        disposable.add(repository.buscarListaPizzas()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(pizzas -> listMutableLiveData.setValue(pizzas))
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
