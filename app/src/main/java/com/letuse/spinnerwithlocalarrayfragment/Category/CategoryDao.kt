package com.letuse.pos.room.Category

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CategoryDao {
    @Query(value = "SELECT * FROM category_table")
    fun getAllCategory() : LiveData<List<Category>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItem(category: Category)

    @Query(value = "DELETE FROM category_table WHERE Category_ID = :id")
    suspend fun deleteCategory(id : String)

    @Query("Delete from category_table")
    suspend fun deleteAll()
}