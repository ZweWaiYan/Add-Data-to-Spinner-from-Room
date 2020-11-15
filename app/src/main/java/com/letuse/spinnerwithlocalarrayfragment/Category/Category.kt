package com.letuse.pos.room.Category

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Category_table")
class Category (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Category_ID")
    var category_id : Int,

    @ColumnInfo(name = "Category_Name")
    var category_name : String
)