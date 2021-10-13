package com.aulia.idn.foodiest.sources

import android.database.Observable
import com.aulia.idn.foodiest.food.ResponseFood
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

//inisialisasi API
interface ApiSevice {
    @GET ("filter.php?c=Seafood")
    fun getListFood():io.reactivex.Observable<ResponseFood>
//    fun getListFood(@Query("c")category: String):io.reactivex.Observable<ResponseFood>
}