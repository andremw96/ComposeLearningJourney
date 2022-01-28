package com.raywenderlich.android.words

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.raywenderlich.android.words.data.words.Word
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val wordRepository = getApplication<WordsApp>().wordRepository

    private val allWords = MutableStateFlow(emptyFlow<PagingData<Word>>())
    private val searchWords = MutableStateFlow(emptyFlow<PagingData<Word>>())

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _search = MutableStateFlow(null as String?)
    var search: StateFlow<String?> = _search

    @ExperimentalCoroutinesApi
    val words: StateFlow<Flow<PagingData<Word>>> =
        search
            .flatMapLatest { search -> words(search) }
            .stateInViewModel(initialValue = emptyFlow())

    fun load() = effect {
        _isLoading.value = true
        allWords.value = wordRepository.allWords()
        _isLoading.value = false
    }

    private fun effect(block: suspend () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            block()
        }
    }

    private fun words(search: String?) = when {
        search.isNullOrEmpty() -> allWords
        else -> searchWords
    }

    private fun <T> Flow<T>.stateInViewModel(initialValue: T): StateFlow<T> =
        stateIn(viewModelScope, started = SharingStarted.Lazily, initialValue = initialValue)

    fun search(term: String?) = effect {
        _search.value = term

        if (term != null) {
            searchWords.value = wordRepository.allWords(term = term)
        }
    }
}
