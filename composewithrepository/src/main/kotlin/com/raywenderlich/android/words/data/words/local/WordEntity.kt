package com.raywenderlich.android.words.data.words.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word")
data class WordEntity(
    @PrimaryKey val value: String
)
