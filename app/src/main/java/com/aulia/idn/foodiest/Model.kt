package com.aulia.idn.foodiest

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Model(
    var name: String,
    var address: String,
    var kind: String,
    var desc: String,
    var price: String,
    var image: Int
) : Parcelable