package lip.com.google.android.gms.games.internal.events;

import java.util.concurrent.atomic.AtomicReference;

public abstract class EventIncrementManager {
    private final AtomicReference<EventIncrementCache> Rs = new AtomicReference();

    public void flush() {
        EventIncrementCache eventIncrementCache = (EventIncrementCache) this.Rs.get();
        if (eventIncrementCache != null) {
            eventIncrementCache.flush();
        }
    }

    protected abstract EventIncrementCache hx();

    public void l(String str, int i) {
        EventIncrementCache eventIncrementCache = (EventIncrementCache) this.Rs.get();
        if (eventIncrementCache == null) {
            eventIncrementCache = hx();
            if (!this.Rs.compareAndSet(null, eventIncrementCache)) {
                eventIncrementCache = (EventIncrementCache) this.Rs.get();
            }
        }
        eventIncrementCache.u(str, i);
    }
}
