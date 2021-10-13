package com.aulia.idn.foodiest.viewModel

import android.app.PendingIntent
import com.aulia.idn.foodiest.food.MealsItem
import com.aulia.idn.foodiest.food.ResponseFood
import com.aulia.idn.foodiest.sources.ApiSevice
import com.aulia.idn.foodiest.sources.RetrofitConfig
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class BaseMealsViewModel(private val listener:OnFinishedListener<List<MealsItem>>) {
    private val compositeDisposable = CompositeDisposable()
    fun fetchMealsData(){
        compositeDisposable.add(
            RetrofitConfig.apiSevicesClient.getListFood()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleNext, this::handleError)
        )
    }
    private fun handleNext(mealsItem: ResponseFood){
        val mealsItem = mealsItem.meals
        listener.success(mealsItem as List<MealsItem>)
    }

    private fun handleError(throwable: Throwable){
        listener.failure(throwable.message)
    }
}