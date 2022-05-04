package com.example.myapplication.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.R
import com.example.myapplication.ui.gallery.items.CategoryUi

class GalleryViewModel : ViewModel() {

    val actionOnclick: ((Int) -> Unit) = { id ->
        toNextPage.postValue(id)
    }

    val data = MutableLiveData<List<CategoryUi>>()
    val toNextPage = MutableLiveData<Int>()

    fun getCategoryUi() {
        data.postValue(
            listOf(
                CategoryUi(
                    1,
                    "lorem ipsum",
                    R.drawable.ic_menu_gallery,
                    "lorem ipsum",
                    actionOnclick
                ),
                CategoryUi(
                    1,
                    "lorem ipsum",
                    R.drawable.ic_menu_gallery,
                    "lorem ipsum",
                    actionOnclick
                ),
                CategoryUi(
                    1,
                    "lorem ipsum",
                    R.drawable.ic_menu_gallery,
                    "lorem ipsum",
                    actionOnclick
                ),
            )
        )
    }
}