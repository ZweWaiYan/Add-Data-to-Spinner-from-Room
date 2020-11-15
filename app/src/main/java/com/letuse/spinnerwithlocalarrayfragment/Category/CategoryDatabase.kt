package com.letuse.pos.room.Category

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(Category::class)],version = 1)
abstract class CategoryDatabase : RoomDatabase(){
    abstract fun categoryDao() : CategoryDao

    companion object{
        private var INSTANCE : CategoryDatabase?= null
        fun getDatabase(context: Context): CategoryDatabase{
            val temInstance = INSTANCE
            if(temInstance != null){
                return temInstance
            }
            synchronized(this){
                var instance = Room.databaseBuilder(context,CategoryDatabase::class.java,"ItemDB").build()
                instance = Room.databaseBuilder(context.getApplicationContext(), CategoryDatabase::class.java, "Sample.db").fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}