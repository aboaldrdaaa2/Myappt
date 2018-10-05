package lip.com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class en {
    private static final ThreadFactory sh = new ThreadFactory() {
        private final AtomicInteger sk = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AdWorker #" + this.sk.getAndIncrement());
        }
    };
    private static final ThreadPoolExecutor si = new ThreadPoolExecutor(0, 10, 65, TimeUnit.SECONDS, new SynchronousQueue(true), sh);

    public static void execute(final Runnable task) {
        try {
            si.execute(new Runnable() {
                public void run() {
                    Process.setThreadPriority(10);
                    task.run();
                }
            });
        } catch (Throwable e) {
            eu.c("Too many background threads already running. Aborting task.  Current pool size: " + getPoolSize(), e);
        }
    }

    public static int getPoolSize() {
        return si.getPoolSize();
    }
}
