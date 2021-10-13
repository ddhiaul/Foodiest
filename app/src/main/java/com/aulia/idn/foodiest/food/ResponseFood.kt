package com.aulia.idn.foodiest.food

import com.google.gson.annotations.SerializedName

data class ResponseFood(

	@field:SerializedName("meals")
	val meals: List<MealsItem?>? = null
)