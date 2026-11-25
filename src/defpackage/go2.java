package defpackage;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.yunbao.common.CommonAppContext;

/* loaded from: /tmp/classes2.dex */
public class go2 extends SQLiteOpenHelper {
    public go2() {
        super(CommonAppContext.n(), "yunbao.music", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        lx1.b("MusicDbHelper----sql--->CREATE TABLE IF NOT EXISTS music(id VARCHAR PRIMARY KEY ,name VARCHAR, artist VARCHAR)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS music(id VARCHAR PRIMARY KEY ,name VARCHAR, artist VARCHAR)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
