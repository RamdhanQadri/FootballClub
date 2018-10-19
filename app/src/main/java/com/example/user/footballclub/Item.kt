package com.example.user.footballclub

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(val name: String?, val detail: String?, val image: Int?): Parcelable