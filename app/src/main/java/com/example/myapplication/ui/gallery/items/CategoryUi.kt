package com.example.myapplication.ui.gallery.items

import androidx.annotation.DrawableRes

data class CategoryUi(
    val id: Int,
    val name: String,
    @DrawableRes
    val url: Int,
    val categoryName: String,
    val actionOnClick: ((Int) -> Unit)
)