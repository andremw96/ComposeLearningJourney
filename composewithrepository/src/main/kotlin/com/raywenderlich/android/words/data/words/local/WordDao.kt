package com.raywenderlich.android.words.data.words.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WordDao {
    @Query("SELECT * FROM word order by value")
    fun queryAll(): PagingSource<Int, WordEntity>

    @Query("SELECT * FROM word WHERE value like :term || '%' ORDER BY value")
    fun searchAll(term: String): PagingSource<Int, WordEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(words: List<WordEntity>)

    @Query("SELECT COUNT(*) FROM word")
    suspend fun count(): Long
}
