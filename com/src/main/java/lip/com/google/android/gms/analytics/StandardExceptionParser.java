package lip.com.google.android.gms.analytics;

import android.content.Context;
import android.support.v4.os.EnvironmentCompat;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

public class StandardExceptionParser implements ExceptionParser {
    private final TreeSet<String> xd = new TreeSet();

    public StandardExceptionParser(Context context, Collection<String> additionalPackages) {
        setIncludedPackages(context, additionalPackages);
    }

    protected StackTraceElement getBestStackTraceElement(Throwable t) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        if (stackTrace == null || stackTrace.length == 0) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Iterator it = this.xd.iterator();
            while (it.hasNext()) {
                if (className.startsWith((String) it.next())) {
                    return stackTraceElement;
                }
            }
        }
        return stackTrace[0];
    }

    protected Throwable getCause(Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    public String getDescription(String threadName, Throwable t) {
        return getDescription(getCause(t), getBestStackTraceElement(getCause(t)), threadName);
    }

    protected String getDescription(Throwable cause, StackTraceElement element, String threadName) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cause.getClass().getSimpleName());
        if (element != null) {
            String[] split = element.getClassName().split("\\.");
            String str = EnvironmentCompat.MEDIA_UNKNOWN;
            if (split != null && split.length > 0) {
                str = split[split.length - 1];
            }
            stringBuilder.append(String.format(" (@%s:%s:%s)", new Object[]{str, element.getMethodName(), Integer.valueOf(element.getLineNumber())}));
        }
        if (threadName != null) {
            stringBuilder.append(String.format(" {%s}", new Object[]{threadName}));
        }
        return stringBuilder.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0049 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007c  */
    public void setIncludedPackages(Context r8, Collection<String> r9) {
        /*
        r7 = this;
        r3 = 0;
        r0 = r7.xd;
        r0.clear();
        r1 = new java.util.HashSet;
        r1.<init>();
        if (r9 == 0) goto L_0x0010;
    L_0x000d:
        r1.addAll(r9);
    L_0x0010:
        if (r8 == 0) goto L_0x0045;
    L_0x0012:
        r0 = r8.getApplicationContext();	 Catch:{ NameNotFoundException -> 0x003f }
        r0 = r0.getPackageName();	 Catch:{ NameNotFoundException -> 0x003f }
        r2 = r7.xd;	 Catch:{ NameNotFoundException -> 0x003f }
        r2.add(r0);	 Catch:{ NameNotFoundException -> 0x003f }
        r2 = r8.getApplicationContext();	 Catch:{ NameNotFoundException -> 0x003f }
        r2 = r2.getPackageManager();	 Catch:{ NameNotFoundException -> 0x003f }
        r4 = 15;
        r0 = r2.getPackageInfo(r0, r4);	 Catch:{ NameNotFoundException -> 0x003f }
        r2 = r0.activities;	 Catch:{ NameNotFoundException -> 0x003f }
        if (r2 == 0) goto L_0x0045;
    L_0x0031:
        r4 = r2.length;	 Catch:{ NameNotFoundException -> 0x003f }
        r0 = r3;
    L_0x0033:
        if (r0 >= r4) goto L_0x0045;
    L_0x0035:
        r5 = r2[r0];	 Catch:{ NameNotFoundException -> 0x003f }
        r5 = r5.packageName;	 Catch:{ NameNotFoundException -> 0x003f }
        r1.add(r5);	 Catch:{ NameNotFoundException -> 0x003f }
        r0 = r0 + 1;
        goto L_0x0033;
    L_0x003f:
        r0 = move-exception;
        r0 = "No package found";
        com.google.android.gms.analytics.aa.B(r0);
    L_0x0045:
        r4 = r1.iterator();
    L_0x0049:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x0084;
    L_0x004f:
        r0 = r4.next();
        r0 = (java.lang.String) r0;
        r1 = 1;
        r2 = r7.xd;
        r5 = r2.iterator();
        r2 = r1;
    L_0x005d:
        r1 = r5.hasNext();
        if (r1 == 0) goto L_0x007a;
    L_0x0063:
        r1 = r5.next();
        r1 = (java.lang.String) r1;
        r6 = r0.startsWith(r1);
        if (r6 != 0) goto L_0x0082;
    L_0x006f:
        r5 = r1.startsWith(r0);
        if (r5 == 0) goto L_0x007a;
    L_0x0075:
        r5 = r7.xd;
        r5.remove(r1);
    L_0x007a:
        if (r2 == 0) goto L_0x0049;
    L_0x007c:
        r1 = r7.xd;
        r1.add(r0);
        goto L_0x0049;
    L_0x0082:
        r2 = r3;
        goto L_0x005d;
    L_0x0084:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.StandardExceptionParser.setIncludedPackages(android.content.Context, java.util.Collection):void");
    }
}
