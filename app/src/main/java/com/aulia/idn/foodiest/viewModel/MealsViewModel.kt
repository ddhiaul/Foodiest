package com.aulia.idn.foodiest.viewModel

import com.aulia.idn.foodiest.AppBaseInterface
import com.aulia.idn.foodiest.food.MealsItem
import com.aulia.idn.foodiest.viewModel.MealsViewModelInterface

class MealsViewModel (private var view: AppBaseInterface<List<MealsItem>>): OnFinishedListener<List<MealsItem>>{

    override fun success(data: List<MealsItem>) {
        view?.hideProgressBar()
        view?.showData()
    }

    override fun failure(message: String?) {
        view?.hideProgressBar()
        view?.showError(message)
    }

}