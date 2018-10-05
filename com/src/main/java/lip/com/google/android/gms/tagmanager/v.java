package lip.com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.internal.ij;
import com.google.android.gms.internal.il;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class v implements c {
    private static final String afj = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", "value", "expires"});
    private ij aef;
    private final Executor afk;
    private a afl;
    private int afm;
    private final Context mContext;

    class a extends SQLiteOpenHelper {
        a(Context context, String str) {
            super(context, str, null, 1);
        }

        private void a(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (!hashSet.remove("key") || !hashSet.remove("value") || !hashSet.remove("ID") || !hashSet.remove("expires")) {
                    throw new SQLiteException("Database column missing");
                } else if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
            } finally {
                rawQuery.close();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
        private boolean a(String r11, SQLiteDatabase r12) {
            /*
            r10 = this;
            r8 = 0;
            r9 = 0;
            r1 = "SQLITE_MASTER";
            r0 = 1;
            r2 = new java.lang.String[r0];	 Catch:{ SQLiteException -> 0x0026, all -> 0x0045 }
            r0 = 0;
            r3 = "name";
            r2[r0] = r3;	 Catch:{ SQLiteException -> 0x0026, all -> 0x0045 }
            r3 = "name=?";
            r0 = 1;
            r4 = new java.lang.String[r0];	 Catch:{ SQLiteException -> 0x0026, all -> 0x0045 }
            r0 = 0;
            r4[r0] = r11;	 Catch:{ SQLiteException -> 0x0026, all -> 0x0045 }
            r5 = 0;
            r6 = 0;
            r7 = 0;
            r0 = r12;
            r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ SQLiteException -> 0x0026, all -> 0x0045 }
            r0 = r1.moveToFirst();	 Catch:{ SQLiteException -> 0x0053, all -> 0x004c }
            if (r1 == 0) goto L_0x0025;
        L_0x0022:
            r1.close();
        L_0x0025:
            return r0;
        L_0x0026:
            r0 = move-exception;
            r0 = r9;
        L_0x0028:
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x004f }
            r1.<init>();	 Catch:{ all -> 0x004f }
            r2 = "Error querying for table ";
            r1 = r1.append(r2);	 Catch:{ all -> 0x004f }
            r1 = r1.append(r11);	 Catch:{ all -> 0x004f }
            r1 = r1.toString();	 Catch:{ all -> 0x004f }
            com.google.android.gms.tagmanager.bh.D(r1);	 Catch:{ all -> 0x004f }
            if (r0 == 0) goto L_0x0043;
        L_0x0040:
            r0.close();
        L_0x0043:
            r0 = r8;
            goto L_0x0025;
        L_0x0045:
            r0 = move-exception;
        L_0x0046:
            if (r9 == 0) goto L_0x004b;
        L_0x0048:
            r9.close();
        L_0x004b:
            throw r0;
        L_0x004c:
            r0 = move-exception;
            r9 = r1;
            goto L_0x0046;
        L_0x004f:
            r1 = move-exception;
            r9 = r0;
            r0 = r1;
            goto L_0x0046;
        L_0x0053:
            r0 = move-exception;
            r0 = r1;
            goto L_0x0028;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.v.a.a(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
        }

        public SQLiteDatabase getWritableDatabase() {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                v.this.mContext.getDatabasePath("google_tagmanager.db").delete();
            }
            return sQLiteDatabase == null ? super.getWritableDatabase() : sQLiteDatabase;
        }

        public void onCreate(SQLiteDatabase db) {
            ak.N(db.getPath());
        }

        public void onOpen(SQLiteDatabase db) {
            if (VERSION.SDK_INT < 15) {
                Cursor rawQuery = db.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            if (a("datalayer", db)) {
                a(db);
            } else {
                db.execSQL(v.afj);
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    private static class b {
        final String JL;
        final byte[] afs;

        b(String str, byte[] bArr) {
            this.JL = str;
            this.afs = bArr;
        }

        public String toString() {
            return "KeyAndSerialized: key = " + this.JL + " serialized hash = " + Arrays.hashCode(this.afs);
        }
    }

    public v(Context context) {
        this(context, il.gb(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
    }

    v(Context context, ij ijVar, String str, int i, Executor executor) {
        this.mContext = context;
        this.aef = ijVar;
        this.afm = i;
        this.afk = executor;
        this.afl = new a(this.mContext, str);
    }

    private SQLiteDatabase S(String str) {
        try {
            return this.afl.getWritableDatabase();
        } catch (SQLiteException e) {
            bh.D(str);
            return null;
        }
    }

    private synchronized void b(List<b> list, long j) {
        try {
            long currentTimeMillis = this.aef.currentTimeMillis();
            x(currentTimeMillis);
            do(list.size());
            c(list, currentTimeMillis + j);
            lF();
        } catch (Throwable th) {
            lF();
        }
    }

    private void bQ(String str) {
        SQLiteDatabase S = S("Error opening database for clearKeysWithPrefix.");
        if (S != null) {
            try {
                bh.C("Cleared " + S.delete("datalayer", "key = ? OR key LIKE ?", new String[]{str, str + ".%"}) + " items");
            } catch (SQLiteException e) {
                bh.D("Error deleting entries with key prefix: " + str + " (" + e + ").");
            } finally {
                lF();
            }
        }
    }

    private void c(List<b> list, long j) {
        SQLiteDatabase S = S("Error opening database for writeEntryToDatabase.");
        if (S != null) {
            for (b bVar : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("expires", Long.valueOf(j));
                contentValues.put("key", bVar.JL);
                contentValues.put("value", bVar.afs);
                S.insert("datalayer", null, contentValues);
            }
        }
    }

    private void do(int i) {
        int lE = (lE() - this.afm) + i;
        if (lE > 0) {
            List dp = dp(lE);
            bh.B("DataLayer store full, deleting " + dp.size() + " entries to make room.");
            g((String[]) dp.toArray(new String[0]));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0082  */
    private List<String> dp(int r14) {
        /*
        r13 = this;
        r10 = 0;
        r9 = new java.util.ArrayList;
        r9.<init>();
        if (r14 > 0) goto L_0x000f;
    L_0x0008:
        r0 = "Invalid maxEntries specified. Skipping.";
        com.google.android.gms.tagmanager.bh.D(r0);
        r0 = r9;
    L_0x000e:
        return r0;
    L_0x000f:
        r0 = "Error opening database for peekEntryIds.";
        r0 = r13.S(r0);
        if (r0 != 0) goto L_0x0019;
    L_0x0017:
        r0 = r9;
        goto L_0x000e;
    L_0x0019:
        r1 = "datalayer";
        r2 = 1;
        r2 = new java.lang.String[r2];	 Catch:{ SQLiteException -> 0x005c, all -> 0x007e }
        r3 = 0;
        r4 = "ID";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x005c, all -> 0x007e }
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = "%s ASC";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ SQLiteException -> 0x005c, all -> 0x007e }
        r11 = 0;
        r12 = "ID";
        r8[r11] = r12;	 Catch:{ SQLiteException -> 0x005c, all -> 0x007e }
        r7 = java.lang.String.format(r7, r8);	 Catch:{ SQLiteException -> 0x005c, all -> 0x007e }
        r8 = java.lang.Integer.toString(r14);	 Catch:{ SQLiteException -> 0x005c, all -> 0x007e }
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x005c, all -> 0x007e }
        r0 = r1.moveToFirst();	 Catch:{ SQLiteException -> 0x0088 }
        if (r0 == 0) goto L_0x0055;
    L_0x0043:
        r0 = 0;
        r2 = r1.getLong(r0);	 Catch:{ SQLiteException -> 0x0088 }
        r0 = java.lang.String.valueOf(r2);	 Catch:{ SQLiteException -> 0x0088 }
        r9.add(r0);	 Catch:{ SQLiteException -> 0x0088 }
        r0 = r1.moveToNext();	 Catch:{ SQLiteException -> 0x0088 }
        if (r0 != 0) goto L_0x0043;
    L_0x0055:
        if (r1 == 0) goto L_0x005a;
    L_0x0057:
        r1.close();
    L_0x005a:
        r0 = r9;
        goto L_0x000e;
    L_0x005c:
        r0 = move-exception;
        r1 = r10;
    L_0x005e:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0086 }
        r2.<init>();	 Catch:{ all -> 0x0086 }
        r3 = "Error in peekEntries fetching entryIds: ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0086 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x0086 }
        r0 = r2.append(r0);	 Catch:{ all -> 0x0086 }
        r0 = r0.toString();	 Catch:{ all -> 0x0086 }
        com.google.android.gms.tagmanager.bh.D(r0);	 Catch:{ all -> 0x0086 }
        if (r1 == 0) goto L_0x005a;
    L_0x007a:
        r1.close();
        goto L_0x005a;
    L_0x007e:
        r0 = move-exception;
        r1 = r10;
    L_0x0080:
        if (r1 == 0) goto L_0x0085;
    L_0x0082:
        r1.close();
    L_0x0085:
        throw r0;
    L_0x0086:
        r0 = move-exception;
        goto L_0x0080;
    L_0x0088:
        r0 = move-exception;
        goto L_0x005e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.v.dp(int):java.util.List<java.lang.String>");
    }

    private List<a> e(List<b> list) {
        List<a> arrayList = new ArrayList();
        for (b bVar : list) {
            arrayList.add(new a(bVar.JL, j(bVar.afs)));
        }
        return arrayList;
    }

    private List<b> f(List<a> list) {
        List<b> arrayList = new ArrayList();
        for (a aVar : list) {
            arrayList.add(new b(aVar.JL, j(aVar.afh)));
        }
        return arrayList;
    }

    private void g(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            SQLiteDatabase S = S("Error opening database for deleteEntries.");
            if (S != null) {
                try {
                    S.delete("datalayer", String.format("%s in (%s)", new Object[]{"ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                } catch (SQLiteException e) {
                    bh.D("Error deleting entries " + Arrays.toString(strArr));
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0029 A:{SYNTHETIC, Splitter: B:20:0x0029} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0038 A:{SYNTHETIC, Splitter: B:27:0x0038} */
    private Object j(byte[] r6) {
        /*
        r5 = this;
        r0 = 0;
        r2 = new java.io.ByteArrayInputStream;
        r2.<init>(r6);
        r1 = new java.io.ObjectInputStream;	 Catch:{ IOException -> 0x0018, ClassNotFoundException -> 0x0025, all -> 0x0032 }
        r1.<init>(r2);	 Catch:{ IOException -> 0x0018, ClassNotFoundException -> 0x0025, all -> 0x0032 }
        r0 = r1.readObject();	 Catch:{ IOException -> 0x0045, ClassNotFoundException -> 0x0043, all -> 0x0041 }
        if (r1 == 0) goto L_0x0014;
    L_0x0011:
        r1.close();	 Catch:{ IOException -> 0x0047 }
    L_0x0014:
        r2.close();	 Catch:{ IOException -> 0x0047 }
    L_0x0017:
        return r0;
    L_0x0018:
        r1 = move-exception;
        r1 = r0;
    L_0x001a:
        if (r1 == 0) goto L_0x001f;
    L_0x001c:
        r1.close();	 Catch:{ IOException -> 0x0023 }
    L_0x001f:
        r2.close();	 Catch:{ IOException -> 0x0023 }
        goto L_0x0017;
    L_0x0023:
        r1 = move-exception;
        goto L_0x0017;
    L_0x0025:
        r1 = move-exception;
        r1 = r0;
    L_0x0027:
        if (r1 == 0) goto L_0x002c;
    L_0x0029:
        r1.close();	 Catch:{ IOException -> 0x0030 }
    L_0x002c:
        r2.close();	 Catch:{ IOException -> 0x0030 }
        goto L_0x0017;
    L_0x0030:
        r1 = move-exception;
        goto L_0x0017;
    L_0x0032:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x0036:
        if (r1 == 0) goto L_0x003b;
    L_0x0038:
        r1.close();	 Catch:{ IOException -> 0x003f }
    L_0x003b:
        r2.close();	 Catch:{ IOException -> 0x003f }
    L_0x003e:
        throw r0;
    L_0x003f:
        r1 = move-exception;
        goto L_0x003e;
    L_0x0041:
        r0 = move-exception;
        goto L_0x0036;
    L_0x0043:
        r3 = move-exception;
        goto L_0x0027;
    L_0x0045:
        r3 = move-exception;
        goto L_0x001a;
    L_0x0047:
        r1 = move-exception;
        goto L_0x0017;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.v.j(byte[]):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x002e A:{SYNTHETIC, Splitter: B:20:0x002e} */
    private byte[] j(Object r6) {
        /*
        r5 = this;
        r0 = 0;
        r2 = new java.io.ByteArrayOutputStream;
        r2.<init>();
        r1 = new java.io.ObjectOutputStream;	 Catch:{ IOException -> 0x001b, all -> 0x0028 }
        r1.<init>(r2);	 Catch:{ IOException -> 0x001b, all -> 0x0028 }
        r1.writeObject(r6);	 Catch:{ IOException -> 0x0039, all -> 0x0037 }
        r0 = r2.toByteArray();	 Catch:{ IOException -> 0x0039, all -> 0x0037 }
        if (r1 == 0) goto L_0x0017;
    L_0x0014:
        r1.close();	 Catch:{ IOException -> 0x003b }
    L_0x0017:
        r2.close();	 Catch:{ IOException -> 0x003b }
    L_0x001a:
        return r0;
    L_0x001b:
        r1 = move-exception;
        r1 = r0;
    L_0x001d:
        if (r1 == 0) goto L_0x0022;
    L_0x001f:
        r1.close();	 Catch:{ IOException -> 0x0026 }
    L_0x0022:
        r2.close();	 Catch:{ IOException -> 0x0026 }
        goto L_0x001a;
    L_0x0026:
        r1 = move-exception;
        goto L_0x001a;
    L_0x0028:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x002c:
        if (r1 == 0) goto L_0x0031;
    L_0x002e:
        r1.close();	 Catch:{ IOException -> 0x0035 }
    L_0x0031:
        r2.close();	 Catch:{ IOException -> 0x0035 }
    L_0x0034:
        throw r0;
    L_0x0035:
        r1 = move-exception;
        goto L_0x0034;
    L_0x0037:
        r0 = move-exception;
        goto L_0x002c;
    L_0x0039:
        r3 = move-exception;
        goto L_0x001d;
    L_0x003b:
        r1 = move-exception;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.v.j(java.lang.Object):byte[]");
    }

    private List<a> lC() {
        try {
            x(this.aef.currentTimeMillis());
            List<a> e = e(lD());
            return e;
        } finally {
            lF();
        }
    }

    private List<b> lD() {
        SQLiteDatabase S = S("Error opening database for loadSerialized.");
        List<b> arrayList = new ArrayList();
        if (S == null) {
            return arrayList;
        }
        Cursor query = S.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new b(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    private int lE() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase S = S("Error opening database for getNumStoredEntries.");
        if (S != null) {
            try {
                cursor = S.rawQuery("SELECT COUNT(*) from datalayer", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                bh.D("Error getting numStoredEntries");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i;
    }

    private void lF() {
        try {
            this.afl.close();
        } catch (SQLiteException e) {
        }
    }

    private void x(long j) {
        SQLiteDatabase S = S("Error opening database for deleteOlderThan.");
        if (S != null) {
            try {
                bh.C("Deleted " + S.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)}) + " expired items");
            } catch (SQLiteException e) {
                bh.D("Error deleting old entries.");
            }
        }
    }

    public void a(final com.google.android.gms.tagmanager.DataLayer.c.a aVar) {
        this.afk.execute(new Runnable() {
            public void run() {
                aVar.d(v.this.lC());
            }
        });
    }

    public void a(List<a> list, final long j) {
        final List f = f(list);
        this.afk.execute(new Runnable() {
            public void run() {
                v.this.b(f, j);
            }
        });
    }

    public void bP(final String str) {
        this.afk.execute(new Runnable() {
            public void run() {
                v.this.bQ(str);
            }
        });
    }
}
