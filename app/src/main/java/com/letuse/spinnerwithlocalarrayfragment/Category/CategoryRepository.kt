package com.letuse.pos.room.Category

import androidx.lifecycle.LiveData

class CategoryRepository(private val categoryDao: CategoryDao) {
    val allcategory : LiveData<List<Category>> = categoryDao.getAllCategory()

    suspend fun itemInsert(category: Category){
        categoryDao.insertItem(category)
    }

    suspend fun itemdelete(id: String) {
        categoryDao.deleteCategory(id)
    }

    suspend fun delete() {
        categoryDao.deleteAll()
    }
}