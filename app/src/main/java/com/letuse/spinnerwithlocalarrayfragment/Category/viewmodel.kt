package com.letuse.spinnerwithlocalarrayfragment.Category

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.letuse.pos.room.Category.Category
import com.letuse.pos.room.Category.CategoryDatabase
import com.letuse.pos.room.Category.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class viewmodel(application: Application): AndroidViewModel(application){
    private val repository: CategoryRepository
    val allItem: LiveData<List<Category>>

    init {
        val productDao = CategoryDatabase.getDatabase(application).categoryDao()
        repository = CategoryRepository(productDao)
        allItem = repository.allcategory
    }

    fun insert(item: Category) = viewModelScope.launch {
        repository.itemInsert(item)
    }

    fun deleteID(id: String)=viewModelScope.launch {
        repository.itemdelete(id)
    }

    fun delete()=viewModelScope.launch {
        repository.delete()
    }
}