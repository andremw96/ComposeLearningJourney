package com.raywenderlich.android.words.data.words;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ%\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\b*\u00020\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/raywenderlich/android/words/data/words/WordRepository;", "", "database", "Lcom/raywenderlich/android/words/data/words/local/AppDatabase;", "(Lcom/raywenderlich/android/words/data/words/local/AppDatabase;)V", "wordSource", "Lcom/raywenderlich/android/words/data/words/remote/WordSource;", "wordStore", "Lcom/raywenderlich/android/words/data/words/local/WordStore;", "(Lcom/raywenderlich/android/words/data/words/remote/WordSource;Lcom/raywenderlich/android/words/data/words/local/WordStore;)V", "allWords", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/raywenderlich/android/words/data/words/Word;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "term", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureIsNotEmpty", "(Lcom/raywenderlich/android/words/data/words/local/WordStore;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "composewithrepository_debug"})
public final class WordRepository {
    private final com.raywenderlich.android.words.data.words.remote.WordSource wordSource = null;
    private final com.raywenderlich.android.words.data.words.local.WordStore wordStore = null;
    
    public WordRepository(@org.jetbrains.annotations.NotNull()
    com.raywenderlich.android.words.data.words.remote.WordSource wordSource, @org.jetbrains.annotations.NotNull()
    com.raywenderlich.android.words.data.words.local.WordStore wordStore) {
        super();
    }
    
    public WordRepository(@org.jetbrains.annotations.NotNull()
    com.raywenderlich.android.words.data.words.local.AppDatabase database) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object allWords(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.raywenderlich.android.words.data.words.Word>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object allWords(@org.jetbrains.annotations.NotNull()
    java.lang.String term, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.raywenderlich.android.words.data.words.Word>>> continuation) {
        return null;
    }
    
    private final java.lang.Object ensureIsNotEmpty(com.raywenderlich.android.words.data.words.local.WordStore $this$ensureIsNotEmpty, kotlin.coroutines.Continuation<? super com.raywenderlich.android.words.data.words.local.WordStore> p1) {
        return null;
    }
}