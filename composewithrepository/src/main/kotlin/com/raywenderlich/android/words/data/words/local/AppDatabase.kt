package com.raywenderlich.android.words.data.words.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [WordEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val wordsDao: WordDao
}
