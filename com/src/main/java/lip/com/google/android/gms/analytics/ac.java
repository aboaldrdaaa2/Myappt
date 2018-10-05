package lip.com.google.android.gms.analytics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.internal.fd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

class ac implements d {
    private static final String wP = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
    private final Context mContext;
    private final e uc;
    private i uu;
    private final a wQ;
    private volatile n wR;
    private final String wS;
    private ab wT;
    private long wU;
    private final int wV;

    class a extends SQLiteOpenHelper {
        private boolean wX;
        private long wY = 0;

        a(Context context, String str) {
            super(context, str, null, 1);
        }

        private void a(SQLiteDatabase sQLiteDatabase) {
            Object obj = null;
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM hits2 WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (hashSet.remove("hit_id") && hashSet.remove("hit_url") && hashSet.remove("hit_string") && hashSet.remove("hit_time")) {
                    if (!hashSet.remove("hit_app_id")) {
                        obj = 1;
                    }
                    if (!hashSet.isEmpty()) {
                        throw new SQLiteException("Database has extra columns");
                    } else if (obj != null) {
                        sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id");
                        return;
                    } else {
                        return;
                    }
                }
                throw new SQLiteException("Database column missing");
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
            com.google.android.gms.analytics.aa.D(r1);	 Catch:{ all -> 0x004f }
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.ac.a.a(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
        }

        public SQLiteDatabase getWritableDatabase() {
            if (!this.wX || this.wY + 3600000 <= ac.this.uu.currentTimeMillis()) {
                SQLiteDatabase sQLiteDatabase = null;
                this.wX = true;
                this.wY = ac.this.uu.currentTimeMillis();
                try {
                    sQLiteDatabase = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    ac.this.mContext.getDatabasePath(ac.this.wS).delete();
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
            p.N(db.getPath());
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
            if (a("hits2", db)) {
                a(db);
            } else {
                db.execSQL(ac.wP);
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    ac(e eVar, Context context) {
        this(eVar, context, "google_analytics_v4.db", 2000);
    }

    ac(e eVar, Context context, String str, int i) {
        this.mContext = context.getApplicationContext();
        this.wS = str;
        this.uc = eVar;
        this.uu = new i() {
            public long currentTimeMillis() {
                return System.currentTimeMillis();
            }
        };
        this.wQ = new a(this.mContext, this.wS);
        this.wR = new ah(new DefaultHttpClient(), this.mContext);
        this.wU = 0;
        this.wV = i;
    }

    private SQLiteDatabase S(String str) {
        try {
            return this.wQ.getWritableDatabase();
        } catch (SQLiteException e) {
            aa.D(str);
            return null;
        }
    }

    private void a(Map<String, String> map, long j, String str) {
        SQLiteDatabase S = S("Error opening database for putHit");
        if (S != null) {
            long parseLong;
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_string", v(map));
            contentValues.put("hit_time", Long.valueOf(j));
            if (map.containsKey("AppUID")) {
                try {
                    parseLong = Long.parseLong((String) map.get("AppUID"));
                } catch (NumberFormatException e) {
                    parseLong = 0;
                }
            } else {
                parseLong = 0;
            }
            contentValues.put("hit_app_id", Long.valueOf(parseLong));
            if (str == null) {
                str = "http://www.google-analytics.com/collect";
            }
            if (str.length() == 0) {
                aa.D("Empty path: not sending hit");
                return;
            }
            contentValues.put("hit_url", str);
            try {
                S.insert("hits2", null, contentValues);
                this.uc.s(false);
            } catch (SQLiteException e2) {
                aa.D("Error storing hit");
            }
        }
    }

    private void a(Map<String, String> map, Collection<fd> collection) {
        String substring = "&_v".substring(1);
        if (collection != null) {
            for (fd fdVar : collection) {
                if ("appendVersion".equals(fdVar.getId())) {
                    map.put(substring, fdVar.getValue());
                    return;
                }
            }
        }
    }

    private void dr() {
        int dt = (dt() - this.wV) + 1;
        if (dt > 0) {
            List A = A(dt);
            aa.C("Store full, deleting " + A.size() + " hits to make room.");
            a((String[]) A.toArray(new String[0]));
        }
    }

    static String v(Map<String, String> map) {
        Iterable arrayList = new ArrayList(map.size());
        for (Entry entry : map.entrySet()) {
            arrayList.add(y.encode((String) entry.getKey()) + "=" + y.encode((String) entry.getValue()));
        }
        return TextUtils.join("&", arrayList);
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
        com.google.android.gms.analytics.aa.D(r0);
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
        r1 = "hits2";
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
        com.google.android.gms.analytics.aa.D(r0);	 Catch:{ all -> 0x0086 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.ac.A(int):java.util.List<java.lang.String>");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:83:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0173 A:{ExcHandler: all (th java.lang.Throwable), Splitter: B:6:0x0039} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00fa  */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:35:0x00f2, code:
            r3.close();
     */
    /* JADX WARNING: Missing block: B:38:0x00fa, code:
            r11.close();
     */
    /* JADX WARNING: Missing block: B:65:0x0173, code:
            r1 = th;
     */
    /* JADX WARNING: Missing block: B:66:0x0174, code:
            r11 = r12;
     */
    /* JADX WARNING: Missing block: B:69:0x0179, code:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:70:0x017a, code:
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
    public List<com.google.android.gms.analytics.x> B(int r16) {
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
        r2 = "hits2";
        r3 = 2;
        r3 = new java.lang.String[r3];	 Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
        r4 = 0;
        r5 = "hit_id";
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
        r4 = 1;
        r5 = "hit_time";
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = "%s ASC";
        r9 = 1;
        r9 = new java.lang.Object[r9];	 Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
        r12 = 0;
        r13 = "hit_id";
        r9[r12] = r13;	 Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
        r8 = java.lang.String.format(r8, r9);	 Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
        r9 = java.lang.Integer.toString(r16);	 Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
        r12 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9);	 Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
        r11 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x0179, all -> 0x0173 }
        r11.<init>();	 Catch:{ SQLiteException -> 0x0179, all -> 0x0173 }
        r2 = r12.moveToFirst();	 Catch:{ SQLiteException -> 0x017f, all -> 0x0173 }
        if (r2 == 0) goto L_0x005d;
    L_0x0044:
        r2 = new com.google.android.gms.analytics.x;	 Catch:{ SQLiteException -> 0x017f, all -> 0x0173 }
        r3 = 0;
        r4 = 0;
        r4 = r12.getLong(r4);	 Catch:{ SQLiteException -> 0x017f, all -> 0x0173 }
        r6 = 1;
        r6 = r12.getLong(r6);	 Catch:{ SQLiteException -> 0x017f, all -> 0x0173 }
        r2.<init>(r3, r4, r6);	 Catch:{ SQLiteException -> 0x017f, all -> 0x0173 }
        r11.add(r2);	 Catch:{ SQLiteException -> 0x017f, all -> 0x0173 }
        r2 = r12.moveToNext();	 Catch:{ SQLiteException -> 0x017f, all -> 0x0173 }
        if (r2 != 0) goto L_0x0044;
    L_0x005d:
        if (r12 == 0) goto L_0x0062;
    L_0x005f:
        r12.close();
    L_0x0062:
        r10 = 0;
        r2 = "hits2";
        r3 = 3;
        r3 = new java.lang.String[r3];	 Catch:{ SQLiteException -> 0x0171 }
        r4 = 0;
        r5 = "hit_id";
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x0171 }
        r4 = 1;
        r5 = "hit_string";
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x0171 }
        r4 = 2;
        r5 = "hit_url";
        r3[r4] = r5;	 Catch:{ SQLiteException -> 0x0171 }
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = "%s ASC";
        r9 = 1;
        r9 = new java.lang.Object[r9];	 Catch:{ SQLiteException -> 0x0171 }
        r13 = 0;
        r14 = "hit_id";
        r9[r13] = r14;	 Catch:{ SQLiteException -> 0x0171 }
        r8 = java.lang.String.format(r8, r9);	 Catch:{ SQLiteException -> 0x0171 }
        r9 = java.lang.Integer.toString(r16);	 Catch:{ SQLiteException -> 0x0171 }
        r2 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9);	 Catch:{ SQLiteException -> 0x0171 }
        r1 = r2.moveToFirst();	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        if (r1 == 0) goto L_0x00ca;
    L_0x0097:
        r3 = r10;
    L_0x0098:
        r0 = r2;
        r0 = (android.database.sqlite.SQLiteCursor) r0;	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        r1 = r0;
        r1 = r1.getWindow();	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        r1 = r1.getNumRows();	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        if (r1 <= 0) goto L_0x00fe;
    L_0x00a6:
        r1 = r11.get(r3);	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        r1 = (com.google.android.gms.analytics.x) r1;	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        r4 = 1;
        r4 = r2.getString(r4);	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        r1.Q(r4);	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        r1 = r11.get(r3);	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        r1 = (com.google.android.gms.analytics.x) r1;	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        r4 = 2;
        r4 = r2.getString(r4);	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        r1.R(r4);	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
    L_0x00c2:
        r1 = r3 + 1;
        r3 = r2.moveToNext();	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        if (r3 != 0) goto L_0x0185;
    L_0x00ca:
        if (r2 == 0) goto L_0x00cf;
    L_0x00cc:
        r2.close();
    L_0x00cf:
        r1 = r11;
        goto L_0x000e;
    L_0x00d2:
        r1 = move-exception;
        r2 = r1;
        r3 = r11;
        r1 = r10;
    L_0x00d6:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0176 }
        r4.<init>();	 Catch:{ all -> 0x0176 }
        r5 = "Error in peekHits fetching hitIds: ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0176 }
        r2 = r2.getMessage();	 Catch:{ all -> 0x0176 }
        r2 = r4.append(r2);	 Catch:{ all -> 0x0176 }
        r2 = r2.toString();	 Catch:{ all -> 0x0176 }
        com.google.android.gms.analytics.aa.D(r2);	 Catch:{ all -> 0x0176 }
        if (r3 == 0) goto L_0x000e;
    L_0x00f2:
        r3.close();
        goto L_0x000e;
    L_0x00f7:
        r1 = move-exception;
    L_0x00f8:
        if (r11 == 0) goto L_0x00fd;
    L_0x00fa:
        r11.close();
    L_0x00fd:
        throw r1;
    L_0x00fe:
        r4 = "HitString for hitId %d too large.  Hit will be deleted.";
        r1 = 1;
        r5 = new java.lang.Object[r1];	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        r6 = 0;
        r1 = r11.get(r3);	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        r1 = (com.google.android.gms.analytics.x) r1;	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        r7 = r1.dl();	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        r1 = java.lang.Long.valueOf(r7);	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        r5[r6] = r1;	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        r1 = java.lang.String.format(r4, r5);	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        com.google.android.gms.analytics.aa.D(r1);	 Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        goto L_0x00c2;
    L_0x011c:
        r1 = move-exception;
        r12 = r2;
    L_0x011e:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0167 }
        r2.<init>();	 Catch:{ all -> 0x0167 }
        r3 = "Error in peekHits fetching hitString: ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0167 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x0167 }
        r1 = r2.append(r1);	 Catch:{ all -> 0x0167 }
        r1 = r1.toString();	 Catch:{ all -> 0x0167 }
        com.google.android.gms.analytics.aa.D(r1);	 Catch:{ all -> 0x0167 }
        r2 = new java.util.ArrayList;	 Catch:{ all -> 0x0167 }
        r2.<init>();	 Catch:{ all -> 0x0167 }
        r3 = 0;
        r4 = r11.iterator();	 Catch:{ all -> 0x0167 }
    L_0x0142:
        r1 = r4.hasNext();	 Catch:{ all -> 0x0167 }
        if (r1 == 0) goto L_0x015a;
    L_0x0148:
        r1 = r4.next();	 Catch:{ all -> 0x0167 }
        r1 = (com.google.android.gms.analytics.x) r1;	 Catch:{ all -> 0x0167 }
        r5 = r1.dk();	 Catch:{ all -> 0x0167 }
        r5 = android.text.TextUtils.isEmpty(r5);	 Catch:{ all -> 0x0167 }
        if (r5 == 0) goto L_0x0163;
    L_0x0158:
        if (r3 == 0) goto L_0x0162;
    L_0x015a:
        if (r12 == 0) goto L_0x015f;
    L_0x015c:
        r12.close();
    L_0x015f:
        r1 = r2;
        goto L_0x000e;
    L_0x0162:
        r3 = 1;
    L_0x0163:
        r2.add(r1);	 Catch:{ all -> 0x0167 }
        goto L_0x0142;
    L_0x0167:
        r1 = move-exception;
    L_0x0168:
        if (r12 == 0) goto L_0x016d;
    L_0x016a:
        r12.close();
    L_0x016d:
        throw r1;
    L_0x016e:
        r1 = move-exception;
        r12 = r2;
        goto L_0x0168;
    L_0x0171:
        r1 = move-exception;
        goto L_0x011e;
    L_0x0173:
        r1 = move-exception;
        r11 = r12;
        goto L_0x00f8;
    L_0x0176:
        r1 = move-exception;
        r11 = r3;
        goto L_0x00f8;
    L_0x0179:
        r1 = move-exception;
        r2 = r1;
        r3 = r12;
        r1 = r10;
        goto L_0x00d6;
    L_0x017f:
        r1 = move-exception;
        r2 = r1;
        r3 = r12;
        r1 = r11;
        goto L_0x00d6;
    L_0x0185:
        r3 = r1;
        goto L_0x0098;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.ac.B(int):java.util.List<com.google.android.gms.analytics.x>");
    }

    public void a(Map<String, String> map, long j, String str, Collection<fd> collection) {
        ds();
        dr();
        a(map, collection);
        a(map, j, str);
    }

    void a(String[] strArr) {
        boolean z = true;
        if (strArr == null || strArr.length == 0) {
            aa.D("Empty hitIds passed to deleteHits.");
            return;
        }
        SQLiteDatabase S = S("Error opening database for deleteHits.");
        if (S != null) {
            try {
                S.delete("hits2", String.format("HIT_ID in (%s)", new Object[]{TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                e eVar = this.uc;
                if (dt() != 0) {
                    z = false;
                }
                eVar.s(z);
            } catch (SQLiteException e) {
                aa.D("Error deleting hits " + strArr);
            }
        }
    }

    @Deprecated
    void b(Collection<x> collection) {
        if (collection == null || collection.isEmpty()) {
            aa.D("Empty/Null collection passed to deleteHits.");
            return;
        }
        String[] strArr = new String[collection.size()];
        int i = 0;
        for (x dl : collection) {
            int i2 = i + 1;
            strArr[i] = String.valueOf(dl.dl());
            i = i2;
        }
        a(strArr);
    }

    public void cq() {
        boolean z = true;
        aa.C("Dispatch running...");
        if (this.wR.cC()) {
            List B = B(40);
            if (B.isEmpty()) {
                aa.C("...nothing to dispatch");
                this.uc.s(true);
                return;
            }
            if (this.wT == null) {
                this.wT = new ab("_t=dispatch&_v=ma4.0.2", true);
            }
            if (dt() > B.size()) {
                z = false;
            }
            int a = this.wR.a(B, this.wT, z);
            aa.C("sent " + a + " of " + B.size() + " hits");
            b(B.subList(0, Math.min(a, B.size())));
            if (a != B.size() || dt() <= 0) {
                this.wT = null;
            } else {
                GoogleAnalytics.getInstance(this.mContext).dispatchLocalHits();
            }
        }
    }

    public n cr() {
        return this.wR;
    }

    int ds() {
        boolean z = true;
        long currentTimeMillis = this.uu.currentTimeMillis();
        if (currentTimeMillis <= this.wU + 86400000) {
            return 0;
        }
        this.wU = currentTimeMillis;
        SQLiteDatabase S = S("Error opening database for deleteStaleHits.");
        if (S == null) {
            return 0;
        }
        int delete = S.delete("hits2", "HIT_TIME < ?", new String[]{Long.toString(this.uu.currentTimeMillis() - 2592000000L)});
        e eVar = this.uc;
        if (dt() != 0) {
            z = false;
        }
        eVar.s(z);
        return delete;
    }

    int dt() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase S = S("Error opening database for getNumStoredHits.");
        if (S != null) {
            try {
                cursor = S.rawQuery("SELECT COUNT(*) from hits2", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                aa.D("Error getting numStoredHits");
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

    public void l(long j) {
        boolean z = true;
        SQLiteDatabase S = S("Error opening database for clearHits");
        if (S != null) {
            if (j == 0) {
                S.delete("hits2", null, null);
            } else {
                S.delete("hits2", "hit_app_id = ?", new String[]{Long.valueOf(j).toString()});
            }
            e eVar = this.uc;
            if (dt() != 0) {
                z = false;
            }
            eVar.s(z);
        }
    }
}
