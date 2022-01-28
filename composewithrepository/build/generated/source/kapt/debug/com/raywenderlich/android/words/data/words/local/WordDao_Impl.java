package com.raywenderlich.android.words.data.words.local;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.paging.PagingSource;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.paging.LimitOffsetPagingSource;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class WordDao_Impl implements WordDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<WordEntity> __insertionAdapterOfWordEntity;

  public WordDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWordEntity = new EntityInsertionAdapter<WordEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `word` (`value`) VALUES (?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WordEntity value) {
        if (value.getValue() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getValue());
        }
      }
    };
  }

  @Override
  public Object insert(final List<WordEntity> words,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfWordEntity.insert(words);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public PagingSource<Integer, WordEntity> queryAll() {
    final String _sql = "SELECT * FROM word order by value";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new LimitOffsetPagingSource<WordEntity>(_statement, __db, "word") {
      @Override
      protected List<WordEntity> convertRows(Cursor cursor) {
        final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(cursor, "value");
        final List<WordEntity> _result = new ArrayList<WordEntity>(cursor.getCount());
        while(cursor.moveToNext()) {
          final WordEntity _item;
          final String _tmpValue;
          if (cursor.isNull(_cursorIndexOfValue)) {
            _tmpValue = null;
          } else {
            _tmpValue = cursor.getString(_cursorIndexOfValue);
          }
          _item = new WordEntity(_tmpValue);
          _result.add(_item);
        }
        return _result;
      }
    };
  }

  @Override
  public PagingSource<Integer, WordEntity> searchAll(final String term) {
    final String _sql = "SELECT * FROM word WHERE value like ? || '%' ORDER BY value";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (term == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, term);
    }
    return new LimitOffsetPagingSource<WordEntity>(_statement, __db, "word") {
      @Override
      protected List<WordEntity> convertRows(Cursor cursor) {
        final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(cursor, "value");
        final List<WordEntity> _result = new ArrayList<WordEntity>(cursor.getCount());
        while(cursor.moveToNext()) {
          final WordEntity _item;
          final String _tmpValue;
          if (cursor.isNull(_cursorIndexOfValue)) {
            _tmpValue = null;
          } else {
            _tmpValue = cursor.getString(_cursorIndexOfValue);
          }
          _item = new WordEntity(_tmpValue);
          _result.add(_item);
        }
        return _result;
      }
    };
  }

  @Override
  public Object count(final Continuation<? super Long> continuation) {
    final String _sql = "SELECT COUNT(*) FROM word";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Long _result;
          if(_cursor.moveToFirst()) {
            final Long _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
