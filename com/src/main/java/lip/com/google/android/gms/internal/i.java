package lip.com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public abstract class i extends h {
    private static Method jS;
    private static Method jT;
    private static Method jU;
    private static Method jV;
    private static Method jW;
    private static Method jX;
    private static Method jY;
    private static Method jZ;
    private static String ka;
    private static o kb;
    static boolean kc = false;
    private static long startTime = 0;

    static class a extends Exception {
        public a(Throwable th) {
            super(th);
        }
    }

    protected i(Context context, m mVar, n nVar) {
        super(context, mVar, nVar);
    }

    static String a(Context context, m mVar) throws a {
        if (jV == null) {
            throw new a();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) jV.invoke(null, new Object[]{context});
            if (byteBuffer != null) {
                return mVar.a(byteBuffer.array(), true);
            }
            throw new a();
        } catch (Throwable e) {
            throw new a(e);
        } catch (Throwable e2) {
            throw new a(e2);
        }
    }

    static ArrayList<Long> a(MotionEvent motionEvent, DisplayMetrics displayMetrics) throws a {
        if (jW == null || motionEvent == null) {
            throw new a();
        }
        try {
            return (ArrayList) jW.invoke(null, new Object[]{motionEvent, displayMetrics});
        } catch (Throwable e) {
            throw new a(e);
        } catch (Throwable e2) {
            throw new a(e2);
        }
    }

    protected static synchronized void a(String str, Context context, m mVar) {
        synchronized (i.class) {
            if (!kc) {
                try {
                    kb = new o(mVar, null);
                    ka = str;
                    h(context);
                    startTime = w().longValue();
                    kc = true;
                } catch (a e) {
                } catch (UnsupportedOperationException e2) {
                }
            }
        }
    }

    static String b(Context context, m mVar) throws a {
        if (jY == null) {
            throw new a();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) jY.invoke(null, new Object[]{context});
            if (byteBuffer != null) {
                return mVar.a(byteBuffer.array(), true);
            }
            throw new a();
        } catch (Throwable e) {
            throw new a(e);
        } catch (Throwable e2) {
            throw new a(e2);
        }
    }

    private static String b(byte[] bArr, String str) throws a {
        try {
            return new String(kb.c(bArr, str), "UTF-8");
        } catch (Throwable e) {
            throw new a(e);
        } catch (Throwable e2) {
            throw new a(e2);
        }
    }

    static String f(Context context) throws a {
        if (jX == null) {
            throw new a();
        }
        try {
            String str = (String) jX.invoke(null, new Object[]{context});
            if (str != null) {
                return str;
            }
            throw new a();
        } catch (Throwable e) {
            throw new a(e);
        } catch (Throwable e2) {
            throw new a(e2);
        }
    }

    static ArrayList<Long> g(Context context) throws a {
        if (jZ == null) {
            throw new a();
        }
        try {
            ArrayList<Long> arrayList = (ArrayList) jZ.invoke(null, new Object[]{context});
            if (arrayList != null && arrayList.size() == 2) {
                return arrayList;
            }
            throw new a();
        } catch (Throwable e) {
            throw new a(e);
        } catch (Throwable e2) {
            throw new a(e2);
        }
    }

    private static void h(Context context) throws a {
        File file;
        File createTempFile;
        try {
            byte[] b = kb.b(q.getKey());
            byte[] c = kb.c(b, q.B());
            File cacheDir = context.getCacheDir();
            if (cacheDir == null) {
                cacheDir = context.getDir("dex", 0);
                if (cacheDir == null) {
                    throw new a();
                }
            }
            file = cacheDir;
            createTempFile = File.createTempFile("ads", ".jar", file);
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(c, 0, c.length);
            fileOutputStream.close();
            DexClassLoader dexClassLoader = new DexClassLoader(createTempFile.getAbsolutePath(), file.getAbsolutePath(), null, context.getClassLoader());
            Class loadClass = dexClassLoader.loadClass(b(b, q.C()));
            Class loadClass2 = dexClassLoader.loadClass(b(b, q.O()));
            Class loadClass3 = dexClassLoader.loadClass(b(b, q.I()));
            Class loadClass4 = dexClassLoader.loadClass(b(b, q.G()));
            Class loadClass5 = dexClassLoader.loadClass(b(b, q.Q()));
            Class loadClass6 = dexClassLoader.loadClass(b(b, q.E()));
            Class loadClass7 = dexClassLoader.loadClass(b(b, q.M()));
            Class loadClass8 = dexClassLoader.loadClass(b(b, q.K()));
            jS = loadClass.getMethod(b(b, q.D()), new Class[0]);
            jT = loadClass2.getMethod(b(b, q.P()), new Class[0]);
            jU = loadClass3.getMethod(b(b, q.J()), new Class[0]);
            jV = loadClass4.getMethod(b(b, q.H()), new Class[]{Context.class});
            jW = loadClass5.getMethod(b(b, q.R()), new Class[]{MotionEvent.class, DisplayMetrics.class});
            jX = loadClass6.getMethod(b(b, q.F()), new Class[]{Context.class});
            jY = loadClass7.getMethod(b(b, q.N()), new Class[]{Context.class});
            jZ = loadClass8.getMethod(b(b, q.L()), new Class[]{Context.class});
            String name = createTempFile.getName();
            createTempFile.delete();
            new File(file, name.replace(".jar", ".dex")).delete();
        } catch (Throwable e) {
            throw new a(e);
        } catch (Throwable e2) {
            throw new a(e2);
        } catch (Throwable e22) {
            throw new a(e22);
        } catch (Throwable e222) {
            throw new a(e222);
        } catch (Throwable e2222) {
            throw new a(e2222);
        } catch (Throwable e22222) {
            throw new a(e22222);
        } catch (Throwable th) {
            String name2 = createTempFile.getName();
            createTempFile.delete();
            new File(file, name2.replace(".jar", ".dex")).delete();
        }
    }

    static String v() throws a {
        if (ka != null) {
            return ka;
        }
        throw new a();
    }

    static Long w() throws a {
        if (jS == null) {
            throw new a();
        }
        try {
            return (Long) jS.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new a(e);
        } catch (Throwable e2) {
            throw new a(e2);
        }
    }

    static String x() throws a {
        if (jU == null) {
            throw new a();
        }
        try {
            return (String) jU.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new a(e);
        } catch (Throwable e2) {
            throw new a(e2);
        }
    }

    static Long y() throws a {
        if (jT == null) {
            throw new a();
        }
        try {
            return (Long) jT.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new a(e);
        } catch (Throwable e2) {
            throw new a(e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004f A:{ExcHandler: java.io.IOException (e java.io.IOException), Splitter: B:1:0x0001} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004f A:{ExcHandler: java.io.IOException (e java.io.IOException), Splitter: B:1:0x0001} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004f A:{ExcHandler: java.io.IOException (e java.io.IOException), Splitter: B:1:0x0001} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004f A:{ExcHandler: java.io.IOException (e java.io.IOException), Splitter: B:1:0x0001} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:21:?, code:
            return;
     */
    /* JADX WARNING: Missing block: B:22:?, code:
            return;
     */
    protected void c(Context r6) {
        /*
        r5 = this;
        r0 = 1;
        r1 = x();	 Catch:{ a -> 0x0059, IOException -> 0x004f }
        r5.a(r0, r1);	 Catch:{ a -> 0x0059, IOException -> 0x004f }
    L_0x0008:
        r0 = 2;
        r1 = v();	 Catch:{ a -> 0x0057, IOException -> 0x004f }
        r5.a(r0, r1);	 Catch:{ a -> 0x0057, IOException -> 0x004f }
    L_0x0010:
        r0 = 25;
        r1 = w();	 Catch:{ a -> 0x0055, IOException -> 0x004f }
        r1 = r1.longValue();	 Catch:{ a -> 0x0055, IOException -> 0x004f }
        r5.a(r0, r1);	 Catch:{ a -> 0x0055, IOException -> 0x004f }
    L_0x001d:
        r1 = g(r6);	 Catch:{ a -> 0x0053, IOException -> 0x004f }
        r2 = 31;
        r0 = 0;
        r0 = r1.get(r0);	 Catch:{ a -> 0x0053, IOException -> 0x004f }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x0053, IOException -> 0x004f }
        r3 = r0.longValue();	 Catch:{ a -> 0x0053, IOException -> 0x004f }
        r5.a(r2, r3);	 Catch:{ a -> 0x0053, IOException -> 0x004f }
        r2 = 32;
        r0 = 1;
        r0 = r1.get(r0);	 Catch:{ a -> 0x0053, IOException -> 0x004f }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x0053, IOException -> 0x004f }
        r0 = r0.longValue();	 Catch:{ a -> 0x0053, IOException -> 0x004f }
        r5.a(r2, r0);	 Catch:{ a -> 0x0053, IOException -> 0x004f }
    L_0x0041:
        r0 = 33;
        r1 = y();	 Catch:{ a -> 0x0051, IOException -> 0x004f }
        r1 = r1.longValue();	 Catch:{ a -> 0x0051, IOException -> 0x004f }
        r5.a(r0, r1);	 Catch:{ a -> 0x0051, IOException -> 0x004f }
    L_0x004e:
        return;
    L_0x004f:
        r0 = move-exception;
        goto L_0x004e;
    L_0x0051:
        r0 = move-exception;
        goto L_0x004e;
    L_0x0053:
        r0 = move-exception;
        goto L_0x0041;
    L_0x0055:
        r0 = move-exception;
        goto L_0x001d;
    L_0x0057:
        r0 = move-exception;
        goto L_0x0010;
    L_0x0059:
        r0 = move-exception;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.c(android.content.Context):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x008a A:{ExcHandler: java.io.IOException (e java.io.IOException), Splitter: B:6:0x0010} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008a A:{ExcHandler: java.io.IOException (e java.io.IOException), Splitter: B:6:0x0010} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008a A:{ExcHandler: java.io.IOException (e java.io.IOException), Splitter: B:6:0x0010} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008a A:{ExcHandler: java.io.IOException (e java.io.IOException), Splitter: B:6:0x0010} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008a A:{ExcHandler: java.io.IOException (e java.io.IOException), Splitter: B:6:0x0010} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:28:?, code:
            return;
     */
    /* JADX WARNING: Missing block: B:29:?, code:
            return;
     */
    protected void e(Context r7) {
        /*
        r6 = this;
        r0 = 2;
        r1 = v();	 Catch:{ a -> 0x0097, IOException -> 0x008a }
        r6.a(r0, r1);	 Catch:{ a -> 0x0097, IOException -> 0x008a }
    L_0x0008:
        r0 = 1;
        r1 = x();	 Catch:{ a -> 0x0094, IOException -> 0x008a }
        r6.a(r0, r1);	 Catch:{ a -> 0x0094, IOException -> 0x008a }
    L_0x0010:
        r0 = w();	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r0 = r0.longValue();	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r2 = 25;
        r6.a(r2, r0);	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r2 = startTime;	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r4 = 0;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x0034;
    L_0x0025:
        r2 = 17;
        r3 = startTime;	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r0 = r0 - r3;
        r6.a(r2, r0);	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r0 = 23;
        r1 = startTime;	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r6.a(r0, r1);	 Catch:{ a -> 0x0092, IOException -> 0x008a }
    L_0x0034:
        r0 = r6.jO;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r1 = r6.jP;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r1 = a(r0, r1);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r2 = 14;
        r0 = 0;
        r0 = r1.get(r0);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r3 = r0.longValue();	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r6.a(r2, r3);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r2 = 15;
        r0 = 1;
        r0 = r1.get(r0);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r3 = r0.longValue();	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r6.a(r2, r3);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = r1.size();	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r2 = 3;
        if (r0 < r2) goto L_0x0073;
    L_0x0063:
        r2 = 16;
        r0 = 2;
        r0 = r1.get(r0);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = r0.longValue();	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r6.a(r2, r0);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
    L_0x0073:
        r0 = 27;
        r1 = r6.jQ;	 Catch:{ a -> 0x008e, IOException -> 0x008a }
        r1 = a(r7, r1);	 Catch:{ a -> 0x008e, IOException -> 0x008a }
        r6.a(r0, r1);	 Catch:{ a -> 0x008e, IOException -> 0x008a }
    L_0x007e:
        r0 = 29;
        r1 = r6.jQ;	 Catch:{ a -> 0x008c, IOException -> 0x008a }
        r1 = b(r7, r1);	 Catch:{ a -> 0x008c, IOException -> 0x008a }
        r6.a(r0, r1);	 Catch:{ a -> 0x008c, IOException -> 0x008a }
    L_0x0089:
        return;
    L_0x008a:
        r0 = move-exception;
        goto L_0x0089;
    L_0x008c:
        r0 = move-exception;
        goto L_0x0089;
    L_0x008e:
        r0 = move-exception;
        goto L_0x007e;
    L_0x0090:
        r0 = move-exception;
        goto L_0x0073;
    L_0x0092:
        r0 = move-exception;
        goto L_0x0034;
    L_0x0094:
        r0 = move-exception;
        goto L_0x0010;
    L_0x0097:
        r0 = move-exception;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.e(android.content.Context):void");
    }
}
