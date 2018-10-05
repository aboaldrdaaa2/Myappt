package lip.com.google.android.gms.internal;

public abstract class em {
    private final Runnable lg = new Runnable() {
        public final void run() {
            em.this.sf = Thread.currentThread();
            em.this.bh();
        }
    };
    private volatile Thread sf;

    public abstract void bh();

    public final void cancel() {
        onStop();
        if (this.sf != null) {
            this.sf.interrupt();
        }
    }

    public abstract void onStop();

    public final void start() {
        en.execute(this.lg);
    }
}
