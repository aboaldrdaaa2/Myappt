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
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

class ca implements at {
    private static final String wP = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", new Object[]{"gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time"});
    private ij aef;
    private final b agq;
    private volatile ab agr;
    private final au ags;
    private final Context mContext;
    private final String wS;
    private long wU;
    private final int wV;

    class b extends SQLiteOpenHelper {
        private boolean wX;
        private long wY = 0;

        b(Context context, String str) {
            super(context, str, null, 1);
        }

        private void a(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (!hashSet.remove("hit_id") || !hashSet.remove("hit_url") || !hashSet.remove("hit_time") || !hashSet.remove("hit_first_send_time")) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.ca.b.a(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
        }

        public SQLiteDatabase getWritableDatabase() {
            if (!this.wX || this.wY + 3600000 <= ca.this.aef.currentTimeMillis()) {
                SQLiteDatabase sQLiteDatabase = null;
                this.wX = true;
                this.wY = ca.this.aef.currentTimeMillis();
                try {
                    sQLiteDatabase = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    ca.this.mContext.getDatabasePath(ca.this.wS).delete();
                }
                if (sQLiteDatabase == null) {
                    sQLiteDatabase = super.getWritableDatabase();
                }
                this.wX = false;
                return sQLiteDatabase;
            }
            throw new SQLiteException("Database creation failed");
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
            if (a("gtm_hits", db)) {
                a(db);
            } else {
                db.execSQL(ca.wP);
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    class a implements com.google.android.gms.tagmanager.da.a {
        a() {
        }

        public void a(ap apVar) {
            ca.this.y(apVar.dl());
        }

        public void b(ap apVar) {
            ca.this.y(apVar.dl());
            bh.C("Permanent failure dispatching hitId: " + apVar.dl());
        }

        public void c(ap apVar) {
            long lN = apVar.lN();
            if (lN == 0) {
                ca.this.c(apVar.dl(), ca.this.aef.currentTimeMillis());
            } else if (lN + 14400000 < ca.this.aef.currentTimeMillis()) {
                ca.this.y(apVar.dl());
                bh.C("Giving up on failed hitId: " + apVar.dl());
            }
        }
    }

    ca(au auVar, Context context) {
        this(auVar, context, "gtm_urls.db", 2000);
    }

    ca(au auVar, Context context, String str, int i) {
        this.mContext = context.getApplicationContext();
        this.wS = str;
        this.ags = auVar;
        this.aef = il.gb();
        this.agq = new b(this.mContext, this.wS);
        this.agr = new da(new DefaultHttpClient(), this.mContext, new a());
        this.wU = 0;
        this.wV = i;
    }

    private SQLiteDatabase S(String str) {
        try {
            return this.agq.getWritableDatabase();
        } catch (SQLiteException e) {
            bh.D(str);
            return null;
        }
    }

    private void c(long j, long j2) {
        SQLiteDatabase S = S("Error opening database for getNumStoredHits.");
        if (S != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_first_send_time", Long.valueOf(j2));
            try {
                S.update("gtm_hits", contentValues, "hit_id=?", new String[]{String.valueOf(j)});
            } catch (SQLiteException e) {
                bh.D("Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + j);
                y(j);
            }
        }
    }

    private void dr() {
        int dt = (dt() - this.wV) + 1;
        if (dt > 0) {
            List A = A(dt);
            bh.C("Store full, deleting " + A.size() + " hits to make room.");
            a((String[]) A.toArray(new String[0]));
        }
    }

    private void g(long j, String str) {
        SQLiteDatabase S = S("Error opening database for putHit");
        if (S != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_time", Long.valueOf(j));
            contentValues.put("hit_url", str);
            contentValues.put("hit_first_send_time", Integer.valueOf(0));
            try {
                S.insert("gtm_hits", null, contentValues);
                this.ags.s(false);
            } catch (SQLiteException e) {
                bh.D("Error storing hit");
            }
        }
    }

    private void y(long j) {
        a(new String[]{String.valueOf(j)});
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0082  */
    List<String> A(int r14) {
        /*
        r13 = this;
        r10 = 0;
        r9 = new java.util.ArrayList;
        r9.<init>();
        if (r14 > 0) goto L_0x000f;
    L_0x0008:
        r0 = "Invalid maxHits specified. Skipping";
        com.google.android.gms.tagmanager.bh.D(r0);
        r0 = r9;
    L_0x000e:
        return r0;
    L_0x000f:
        r0 = "Error opening database for peekHitIds.";
        r0 = r13.S(r0);
        if (r0 != 0) goto L_0x0019;
    L_0x0017:
        r0 = r9;
        goto L_0x000e;
    L_0x0019:
        r1 = "gtm_hits";
        r2 = 1;
        r2 = new java.lang.String[r2];	 Catch:{ SQLiteException -> 0x005c, all -> 0x007e }
        r3 = 0;
        r4 = "hit_id";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x005c, all -> 0x007e }
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = "%s ASC";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ SQLiteException -> 0x005c, all -> 0x007e }
        r11 = 0;
        r12 = "hit_id";
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
        r3 = "Error in peekHits fetching hitIds: ";
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.ca.A(int):java.util.List<java.lang.String>");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:83:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0169 A:{ExcHandler: all (th java.lang.Throwable), Splitter: B:6:0x003e} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f0  */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:35:0x00e8, code:
            r3.close();
     */
    /* JADX WARNING: Missing block: B:38:0x00f0, code:
            r11.close();
     */
    /* JADX WARNING: Missing block: B:65:0x0169, code:
            r1 = th;
     */
    /* JADX WARNING: Missing block: B:66:0x016a, code:
            r11 = r12;
     */
    /* JADX WARNING: Missing block: B:69:0x016f, code:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:70:0x0170, code:
            r2 = r1;
            r3 = r12;
            r1 = r10;
     */
    /* JADX WARNING: Missing block: B:83:?, code:
            return r1;
     */
    /* JADX WARNING: Missing block: B:84:?, code:
            return r1;
     */
    public List<com.google.android.gms.tagmanager.ap> B(int r16) {
        /*
        r15 = this;
        r10 = new java.util.ArrayList;
        r10.<init>();
        r1 = "Error opening database for peekHits";
        r1 = r15.S(r1);
        if (r1 != 0) goto L_0x000f;
    L_0x000d:
        r1 = r10;
    L_0x000e:
        return r1;
    L_0x000f:
        r11 = 0;
        r2 = "gtm_hits";
        r3 = 3;
        r3 = new java.lang.String[r3];	 Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
        r4 = 0;
        r5 = "hit_id";
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
        r4 = 1;
        r5 = "hit_time";
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
        r4 = 2;
        r5 = "hit_first_send_time";
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = "%s ASC";
        r9 = 1;
        r9 = new java.lang.Object[r9];	 Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
        r12 = 0;
        r13 = "hit_id";
        r9[r12] = r13;	 Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
        r8 = java.lang.String.format(r8, r9);	 Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
        r9 = java.lang.Integer.toString(r16);	 Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
        r12 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9);	 Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
        r11 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r11.<init>();	 Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        r2 = r12.moveToFirst();	 Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
        if (r2 == 0) goto L_0x0066;
    L_0x0049:
        r2 = new com.google.android.gms.tagmanager.ap;	 Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
        r3 = 0;
        r3 = r12.getLong(r3);	 Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
        r5 = 1;
        r5 = r12.getLong(r5);	 Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
        r7 = 2;
        r7 = r12.getLong(r7);	 Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
        r2.<init>(r3, r5, r7);	 Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
        r11.add(r2);	 Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
        r2 = r12.moveToNext();	 Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
        if (r2 != 0) goto L_0x0049;
    L_0x0066:
        if (r12 == 0) goto L_0x006b;
    L_0x0068:
        r12.close();
    L_0x006b:
        r10 = 0;
        r2 = "gtm_hits";
        r3 = 2;
        r3 = new java.lang.String[r3];	 Catch:{ SQLiteException -> 0x0167 }
        r4 = 0;
        r5 = "hit_id";
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x0167 }
        r4 = 1;
        r5 = "hit_url";
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x0167 }
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = "%s ASC";
        r9 = 1;
        r9 = new java.lang.Object[r9];	 Catch:{ SQLiteException -> 0x0167 }
        r13 = 0;
        r14 = "hit_id";
        r9[r13] = r14;	 Catch:{ SQLiteException -> 0x0167 }
        r8 = java.lang.String.format(r8, r9);	 Catch:{ SQLiteException -> 0x0167 }
        r9 = java.lang.Integer.toString(r16);	 Catch:{ SQLiteException -> 0x0167 }
        r2 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9);	 Catch:{ SQLiteException -> 0x0167 }
        r1 = r2.moveToFirst();	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        if (r1 == 0) goto L_0x00c0;
    L_0x009b:
        r3 = r10;
    L_0x009c:
        r0 = r2;
        r0 = (android.database.sqlite.SQLiteCursor) r0;	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        r1 = r0;
        r1 = r1.getWindow();	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        r1 = r1.getNumRows();	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        if (r1 <= 0) goto L_0x00f4;
    L_0x00aa:
        r1 = r11.get(r3);	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        r1 = (com.google.android.gms.tagmanager.ap) r1;	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        r4 = 1;
        r4 = r2.getString(r4);	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        r1.R(r4);	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
    L_0x00b8:
        r1 = r3 + 1;
        r3 = r2.moveToNext();	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        if (r3 != 0) goto L_0x017b;
    L_0x00c0:
        if (r2 == 0) goto L_0x00c5;
    L_0x00c2:
        r2.close();
    L_0x00c5:
        r1 = r11;
        goto L_0x000e;
    L_0x00c8:
        r1 = move-exception;
        r2 = r1;
        r3 = r11;
        r1 = r10;
    L_0x00cc:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x016c }
        r4.<init>();	 Catch:{ all -> 0x016c }
        r5 = "Error in peekHits fetching hitIds: ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x016c }
        r2 = r2.getMessage();	 Catch:{ all -> 0x016c }
        r2 = r4.append(r2);	 Catch:{ all -> 0x016c }
        r2 = r2.toString();	 Catch:{ all -> 0x016c }
        com.google.android.gms.tagmanager.bh.D(r2);	 Catch:{ all -> 0x016c }
        if (r3 == 0) goto L_0x000e;
    L_0x00e8:
        r3.close();
        goto L_0x000e;
    L_0x00ed:
        r1 = move-exception;
    L_0x00ee:
        if (r11 == 0) goto L_0x00f3;
    L_0x00f0:
        r11.close();
    L_0x00f3:
        throw r1;
    L_0x00f4:
        r4 = "HitString for hitId %d too large.  Hit will be deleted.";
        r1 = 1;
        r5 = new java.lang.Object[r1];	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        r6 = 0;
        r1 = r11.get(r3);	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        r1 = (com.google.android.gms.tagmanager.ap) r1;	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        r7 = r1.dl();	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        r1 = java.lang.Long.valueOf(r7);	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        r5[r6] = r1;	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        r1 = java.lang.String.format(r4, r5);	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        com.google.android.gms.tagmanager.bh.D(r1);	 Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        goto L_0x00b8;
    L_0x0112:
        r1 = move-exception;
        r12 = r2;
    L_0x0114:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x015d }
        r2.<init>();	 Catch:{ all -> 0x015d }
        r3 = "Error in peekHits fetching hit url: ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x015d }
        r1 = r1.getMessage();	 Catch:{ all -> 0x015d }
        r1 = r2.append(r1);	 Catch:{ all -> 0x015d }
        r1 = r1.toString();	 Catch:{ all -> 0x015d }
        com.google.android.gms.tagmanager.bh.D(r1);	 Catch:{ all -> 0x015d }
        r2 = new java.util.ArrayList;	 Catch:{ all -> 0x015d }
        r2.<init>();	 Catch:{ all -> 0x015d }
        r3 = 0;
        r4 = r11.iterator();	 Catch:{ all -> 0x015d }
    L_0x0138:
        r1 = r4.hasNext();	 Catch:{ all -> 0x015d }
        if (r1 == 0) goto L_0x0150;
    L_0x013e:
        r1 = r4.next();	 Catch:{ all -> 0x015d }
        r1 = (com.google.android.gms.tagmanager.ap) r1;	 Catch:{ all -> 0x015d }
        r5 = r1.lO();	 Catch:{ all -> 0x015d }
        r5 = android.text.TextUtils.isEmpty(r5);	 Catch:{ all -> 0x015d }
        if (r5 == 0) goto L_0x0159;
    L_0x014e:
        if (r3 == 0) goto L_0x0158;
    L_0x0150:
        if (r12 == 0) goto L_0x0155;
    L_0x0152:
        r12.close();
    L_0x0155:
        r1 = r2;
        goto L_0x000e;
    L_0x0158:
        r3 = 1;
    L_0x0159:
        r2.add(r1);	 Catch:{ all -> 0x015d }
        goto L_0x0138;
    L_0x015d:
        r1 = move-exception;
    L_0x015e:
        if (r12 == 0) goto L_0x0163;
    L_0x0160:
        r12.close();
    L_0x0163:
        throw r1;
    L_0x0164:
        r1 = move-exception;
        r12 = r2;
        goto L_0x015e;
    L_0x0167:
        r1 = move-exception;
        goto L_0x0114;
    L_0x0169:
        r1 = move-exception;
        r11 = r12;
        goto L_0x00ee;
    L_0x016c:
        r1 = move-exception;
        r11 = r3;
        goto L_0x00ee;
    L_0x016f:
        r1 = move-exception;
        r2 = r1;
        r3 = r12;
        r1 = r10;
        goto L_0x00cc;
    L_0x0175:
        r1 = move-exception;
        r2 = r1;
        r3 = r12;
        r1 = r11;
        goto L_0x00cc;
    L_0x017b:
        r3 = r1;
        goto L_0x009c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.ca.B(int):java.util.List<com.google.android.gms.tagmanager.ap>");
    }

    void a(String[] strArr) {
        boolean z = true;
        if (strArr != null && strArr.length != 0) {
            SQLiteDatabase S = S("Error opening database for deleteHits.");
            if (S != null) {
                try {
                    S.delete("gtm_hits", String.format("HIT_ID in (%s)", new Object[]{TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                    au auVar = this.ags;
                    if (dt() != 0) {
                        z = false;
                    }
                    auVar.s(z);
                } catch (SQLiteException e) {
                    bh.D("Error deleting hits");
                }
            }
        }
    }

    public void cq() {
        bh.C("GTM Dispatch running...");
        if (this.agr.cC()) {
            List B = B(40);
            if (B.isEmpty()) {
                bh.C("...nothing to dispatch");
                this.ags.s(true);
                return;
            }
            this.agr.g(B);
            if (mb() > 0) {
                cx.mQ().cq();
            }
        }
    }

    int ds() {
        boolean z = true;
        long currentTimeMillis = this.aef.currentTimeMillis();
        if (currentTimeMillis <= this.wU + 86400000) {
            return 0;
        }
        this.wU = currentTimeMillis;
        SQLiteDatabase S = S("Error opening database for deleteStaleHits.");
        if (S == null) {
            return 0;
        }
        int delete = S.delete("gtm_hits", "HIT_TIME < ?", new String[]{Long.toString(this.aef.currentTimeMillis() - 2592000000L)});
        au auVar = this.ags;
        if (dt() != 0) {
            z = false;
        }
        auVar.s(z);
        return delete;
    }

    int dt() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase S = S("Error opening database for getNumStoredHits.");
        if (S != null) {
            try {
                cursor = S.rawQuery("SELECT COUNT(*) from gtm_hits", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                bh.D("Error getting numStoredHits");
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

    public void f(long j, String str) {
        ds();
        dr();
        g(j, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040  */
    int mb() {
        /*
        r10 = this;
        r8 = 0;
        r9 = 0;
        r0 = "Error opening database for getNumStoredHits.";
        r0 = r10.S(r0);
        if (r0 != 0) goto L_0x000b;
    L_0x000a:
        return r8;
    L_0x000b:
        r1 = "gtm_hits";
        r2 = 2;
        r2 = new java.lang.String[r2];	 Catch:{ SQLiteException -> 0x002f, all -> 0x003d }
        r3 = 0;
        r4 = "hit_id";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x002f, all -> 0x003d }
        r3 = 1;
        r4 = "hit_first_send_time";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x002f, all -> 0x003d }
        r3 = "hit_first_send_time=0";
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ SQLiteException -> 0x002f, all -> 0x003d }
        r0 = r1.getCount();	 Catch:{ SQLiteException -> 0x004b, all -> 0x0044 }
        if (r1 == 0) goto L_0x002d;
    L_0x002a:
        r1.close();
    L_0x002d:
        r8 = r0;
        goto L_0x000a;
    L_0x002f:
        r0 = move-exception;
        r0 = r9;
    L_0x0031:
        r1 = "Error getting num untried hits";
        com.google.android.gms.tagmanager.bh.D(r1);	 Catch:{ all -> 0x0047 }
        if (r0 == 0) goto L_0x004e;
    L_0x0038:
        r0.close();
        r0 = r8;
        goto L_0x002d;
    L_0x003d:
        r0 = move-exception;
    L_0x003e:
        if (r9 == 0) goto L_0x0043;
    L_0x0040:
        r9.close();
    L_0x0043:
        throw r0;
    L_0x0044:
        r0 = move-exception;
        r9 = r1;
        goto L_0x003e;
    L_0x0047:
        r1 = move-exception;
        r9 = r0;
        r0 = r1;
        goto L_0x003e;
    L_0x004b:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0031;
    L_0x004e:
        r0 = r8;
        goto L_0x002d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.ca.mb():int");
    }
}
