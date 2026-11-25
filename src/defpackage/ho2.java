package defpackage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.yunbao.live.music.LiveMusicBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ho2 {
    public static ho2 b;
    public go2 a = new go2();

    public static ho2 b() {
        if (b == null) {
            synchronized (ho2.class) {
                try {
                    if (b == null) {
                        b = new ho2();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public void a(String str) {
        SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
        if (writableDatabase.isOpen()) {
            try {
                writableDatabase.execSQL("DELETE FROM music WHERE id='" + str + "'");
            } finally {
                writableDatabase.close();
            }
        }
    }

    public List c() {
        SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
        Cursor cursor = null;
        if (!writableDatabase.isOpen()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            cursor = writableDatabase.rawQuery("SELECT * FROM music", null);
            while (cursor.moveToNext()) {
                LiveMusicBean liveMusicBean = new LiveMusicBean();
                liveMusicBean.setId(cursor.getString(cursor.getColumnIndex("id")));
                liveMusicBean.setName(cursor.getString(cursor.getColumnIndex("name")));
                liveMusicBean.setArtist(cursor.getString(cursor.getColumnIndex("artist")));
                liveMusicBean.setProgress(100);
                arrayList.add(liveMusicBean);
            }
            cursor.close();
            writableDatabase.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            writableDatabase.close();
            throw th;
        }
    }

    public void d(LiveMusicBean liveMusicBean) {
        SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
        if (writableDatabase.isOpen()) {
            if (writableDatabase.rawQuery("SELECT * FROM music WHERE id='" + liveMusicBean.getId() + "'", null).moveToNext()) {
                SQLiteStatement compileStatement = writableDatabase.compileStatement("UPDATE music SET name=?,artist=? WHERE id=?");
                writableDatabase.beginTransaction();
                try {
                    compileStatement.bindString(1, liveMusicBean.getName());
                    compileStatement.bindString(2, liveMusicBean.getArtist());
                    compileStatement.bindString(3, liveMusicBean.getId());
                    compileStatement.executeUpdateDelete();
                    writableDatabase.setTransactionSuccessful();
                    return;
                } finally {
                }
            }
            SQLiteStatement compileStatement2 = writableDatabase.compileStatement("INSERT INTO music VALUES(?, ?, ?)");
            writableDatabase.beginTransaction();
            try {
                compileStatement2.bindString(1, liveMusicBean.getId());
                compileStatement2.bindString(2, liveMusicBean.getName());
                compileStatement2.bindString(3, liveMusicBean.getArtist());
                compileStatement2.executeInsert();
                writableDatabase.setTransactionSuccessful();
            } finally {
            }
        }
    }
}
