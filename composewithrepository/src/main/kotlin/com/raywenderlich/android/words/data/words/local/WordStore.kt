package com.raywenderlich.android.words.data.words.local

import androidx.paging.*
import com.raywenderlich.android.words.data.words.Word
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class WordStore(database: AppDatabase) {

    private val dao = database.wordsDao

    fun getAll(): Flow<PagingData<Word>> = pagingWord { dao.queryAll() }

    fun getAll(term: String): Flow<PagingData<Word>> = pagingWord { dao.searchAll(term = term) }

    suspend fun save(words: List<Word>) {
        dao.insert(words = words.map {
            it.toEntity()
        })
    }

    suspend fun isEmpty(): Boolean = dao.count() == 0L
}

private fun Word.toEntity() = WordEntity(
    value = value
)

private fun WordEntity.fromEntity() = Word(
    value = value
)

private fun pagingWord(block: () -> PagingSource<Int, WordEntity>): Flow<PagingData<Word>> =
    Pager(PagingConfig(30)) {
        block()
    }.flow.map { page ->
        page.map { wordEntity ->
            wordEntity.fromEntity()
        }
    }
