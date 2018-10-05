package lip.com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class as extends Thread implements ar {
    private static as afI;
    private final LinkedBlockingQueue<Runnable> afH = new LinkedBlockingQueue();
    private volatile at afJ;
    private volatile boolean mClosed = false;
    private final Context mContext;
    private volatile boolean uL = false;

    private as(Context context) {
        super("GAThread");
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        start();
    }

    static as P(Context context) {
        if (afI == null) {
            afI = new as(context);
        }
        return afI;
    }

    private String a(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    public void a(Runnable runnable) {
        this.afH.add(runnable);
    }

    void b(String str, long j) {
        final long j2 = j;
        final String str2 = str;
        a(new Runnable() {
            public void run() {
                if (as.this.afJ == null) {
                    cx mQ = cx.mQ();
                    mQ.a(as.this.mContext, this);
                    as.this.afJ = mQ.mR();
                }
                as.this.afJ.f(j2, str2);
            }
        });
    }

    public void bU(String str) {
        b(str, System.currentTimeMillis());
    }

    public void run() {
        while (!this.mClosed) {
            try {
                Runnable runnable = (Runnable) this.afH.take();
                if (!this.uL) {
                    runnable.run();
                }
            } catch (InterruptedException e) {
                bh.B(e.toString());
            } catch (Throwable th) {
                bh.A("Error on GAThread: " + a(th));
                bh.A("Google Analytics is shutting down.");
                this.uL = true;
            }
        }
    }
}
