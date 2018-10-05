package lip.com.google.a.a;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.b.a.b;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* compiled from: IMASDK */
public final class e extends d {
    static boolean c = false;
    private static Method d = null;
    private static Method e = null;
    private static Method f = null;
    private static Method g = null;
    private static Method h = null;
    private static String i = null;
    private static long j = 0;

    /* compiled from: IMASDK */
    static class a extends Exception {
        public a(Throwable th) {
            super(th);
        }
    }

    public static e a(String str, Context context) {
        b(str, context);
        return new e(context);
    }

    private static synchronized void b(String str, Context context) {
        synchronized (e.class) {
            if (!c) {
                try {
                    i = str;
                    byte[] a = b.a("PiVF+7GzK6qkWIpmH3go6EW+4lv1AHMXPqUYcpA8Jgk=");
                    if (a.length != 32) {
                        throw new com.google.a.a.h.a();
                    }
                    byte[] bArr = new byte[16];
                    ByteBuffer.wrap(a, 4, 16).get(bArr);
                    for (int i = 0; i < bArr.length; i++) {
                        bArr[i] = (byte) (bArr[i] ^ 68);
                    }
                    a = h.a(bArr, "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");
                    File cacheDir = context.getCacheDir();
                    if (cacheDir == null) {
                        cacheDir = context.getDir("dex", 0);
                        if (cacheDir == null) {
                            throw new a();
                        }
                    }
                    File createTempFile = File.createTempFile("ads", ".jar", cacheDir);
                    FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                    fileOutputStream.write(a, 0, a.length);
                    fileOutputStream.close();
                    DexClassLoader dexClassLoader = new DexClassLoader(createTempFile.getAbsolutePath(), cacheDir.getAbsolutePath(), null, context.getClassLoader());
                    Class loadClass = dexClassLoader.loadClass(a(bArr, "BtW5PZeLxighmDuoMSUeXkLIRLxUj47N/h+6hMKhxq4uW/pNaURvNv6NAvXNGBu3"));
                    Class loadClass2 = dexClassLoader.loadClass(a(bArr, "A1NsX1sZeMOU9OiiP732RlBd4ah08giPkcFj25F547+C86S73YI73udKtZIw0B6X"));
                    Class loadClass3 = dexClassLoader.loadClass(a(bArr, "MLBkAVR8uzOmqT8ygVDVZVRSvzWCFXs1i+7cIH/ZEYOiENHaiM9lAgkf6370cqek"));
                    Class loadClass4 = dexClassLoader.loadClass(a(bArr, "Uy6/KvzRj6tjiVYC+YUCyvVawnoBOmxJD5YQwY9JMoQNuY4LEOmpfr6IA1RyetsK"));
                    Class loadClass5 = dexClassLoader.loadClass(a(bArr, "wtYFzsg2H0glAntKwuU5A41e9QruyMNxi77xJ9T868BjRmcAnrghKHz0wfm9FQne"));
                    d = loadClass.getMethod(a(bArr, "Gv+MhHMd+McrZ9XAP+glRpe5frBWJTxuuUMrkUfXpfA="), new Class[0]);
                    e = loadClass2.getMethod(a(bArr, "KX9YmwKB03DGqeXplYhlSFPFRu0EtMGso01yyiBxVNg="), new Class[0]);
                    f = loadClass3.getMethod(a(bArr, "ZFmakVgmSJd9pFKg1XrssC9EKMPxmiJqEFO4851brfQ="), new Class[]{Context.class});
                    g = loadClass4.getMethod(a(bArr, "hOTY3z2FyAdpcBJdHzJQSYhyxdBFsyTqWFUmXDV6Tus="), new Class[]{MotionEvent.class, DisplayMetrics.class});
                    h = loadClass5.getMethod(a(bArr, "SMvPno8CccLs8l9Oz9z3o6AgspYE132lbNrhhlLP10U="), new Class[]{Context.class});
                    String name = createTempFile.getName();
                    createTempFile.delete();
                    new File(cacheDir, name.replace(".jar", ".dex")).delete();
                    j = a().longValue();
                    c = true;
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
                } catch (Throwable e222222) {
                    throw new a(e222222);
                } catch (a e3) {
                } catch (UnsupportedOperationException e4) {
                }
            }
        }
    }

    private e(Context context) {
        super(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0031 A:{ExcHandler: java.io.IOException (e java.io.IOException), Splitter: B:1:0x0001} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0031 A:{ExcHandler: java.io.IOException (e java.io.IOException), Splitter: B:1:0x0001} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0031 A:{ExcHandler: java.io.IOException (e java.io.IOException), Splitter: B:1:0x0001} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:23:?, code:
            return;
     */
    protected final void b(Context r4) {
        /*
        r3 = this;
        r0 = 1;
        r1 = b();	 Catch:{ a -> 0x0037, IOException -> 0x0031 }
        r3.a(r0, r1);	 Catch:{ a -> 0x0037, IOException -> 0x0031 }
    L_0x0008:
        r0 = 2;
        r1 = i;	 Catch:{ a -> 0x0013, IOException -> 0x0031 }
        if (r1 != 0) goto L_0x002b;
    L_0x000d:
        r0 = new com.google.a.a.e$a;	 Catch:{ a -> 0x0013, IOException -> 0x0031 }
        r0.<init>();	 Catch:{ a -> 0x0013, IOException -> 0x0031 }
        throw r0;	 Catch:{ a -> 0x0013, IOException -> 0x0031 }
    L_0x0013:
        r0 = move-exception;
    L_0x0014:
        r0 = 25;
        r1 = a();	 Catch:{ a -> 0x0035, IOException -> 0x0031 }
        r1 = r1.longValue();	 Catch:{ a -> 0x0035, IOException -> 0x0031 }
        r3.a(r0, r1);	 Catch:{ a -> 0x0035, IOException -> 0x0031 }
    L_0x0021:
        r0 = 24;
        r1 = c(r4);	 Catch:{ a -> 0x0033, IOException -> 0x0031 }
        r3.a(r0, r1);	 Catch:{ a -> 0x0033, IOException -> 0x0031 }
    L_0x002a:
        return;
    L_0x002b:
        r1 = i;	 Catch:{ a -> 0x0013, IOException -> 0x0031 }
        r3.a(r0, r1);	 Catch:{ a -> 0x0013, IOException -> 0x0031 }
        goto L_0x0014;
    L_0x0031:
        r0 = move-exception;
        goto L_0x002a;
    L_0x0033:
        r0 = move-exception;
        goto L_0x002a;
    L_0x0035:
        r0 = move-exception;
        goto L_0x0021;
    L_0x0037:
        r0 = move-exception;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.a.e.b(android.content.Context):void");
    }

    private static Long a() throws a {
        if (d == null) {
            throw new a();
        }
        try {
            return (Long) d.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new a(e);
        } catch (Throwable e2) {
            throw new a(e2);
        }
    }

    private static String c(Context context) throws a {
        if (h == null) {
            throw new a();
        }
        try {
            String str = (String) h.invoke(null, new Object[]{context});
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

    private static String b() throws a {
        if (e == null) {
            throw new a();
        }
        try {
            return (String) e.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new a(e);
        } catch (Throwable e2) {
            throw new a(e2);
        }
    }

    private static String a(byte[] bArr, String str) throws a {
        try {
            return new String(h.a(bArr, str), "UTF-8");
        } catch (Throwable e) {
            throw new a(e);
        } catch (Throwable e2) {
            throw new a(e2);
        } catch (Throwable e22) {
            throw new a(e22);
        }
    }
}
