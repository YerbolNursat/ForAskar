package com.example.myapplication.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.R
import com.example.myapplication.ui.gallery.items.CategoryUi
import com.example.myapplication.utils.event.Event
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GalleryViewModel : ViewModel() {

    private val actionOnclick: ((Int) -> Unit) = { id ->
        toNextPage.postValue(Event(id))
    }

    val data = MutableLiveData<List<CategoryUi>>()
    val toNextPage = MutableLiveData<Event<Int>>()

    fun getCategoryUi() {
        viewModelScope.launch {
            // todo имитация на бэк
            delay(2000)
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
}