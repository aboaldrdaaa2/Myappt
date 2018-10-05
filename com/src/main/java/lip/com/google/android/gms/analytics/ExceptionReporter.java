package lip.com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.HitBuilders.ExceptionBuilder;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;

public class ExceptionReporter implements UncaughtExceptionHandler {
    private final Context mContext;
    private final UncaughtExceptionHandler tO;
    private final Tracker tP;
    private ExceptionParser tQ;

    public ExceptionReporter(Tracker tracker, UncaughtExceptionHandler originalHandler, Context context) {
        if (tracker == null) {
            throw new NullPointerException("tracker cannot be null");
        } else if (context == null) {
            throw new NullPointerException("context cannot be null");
        } else {
            this.tO = originalHandler;
            this.tP = tracker;
            this.tQ = new StandardExceptionParser(context, new ArrayList());
            this.mContext = context.getApplicationContext();
            aa.C("ExceptionReporter created, original handler is " + (originalHandler == null ? "null" : originalHandler.getClass().getName()));
        }
    }

    UncaughtExceptionHandler cD() {
        return this.tO;
    }

    public ExceptionParser getExceptionParser() {
        return this.tQ;
    }

    public void setExceptionParser(ExceptionParser exceptionParser) {
        this.tQ = exceptionParser;
    }

    public void uncaughtException(Thread t, Throwable e) {
        String str = "UncaughtException";
        if (this.tQ != null) {
            str = this.tQ.getDescription(t != null ? t.getName() : null, e);
        }
        aa.C("Tracking Exception: " + str);
        this.tP.send(new ExceptionBuilder().setDescription(str).setFatal(true).build());
        GoogleAnalytics.getInstance(this.mContext).dispatchLocalHits();
        if (this.tO != null) {
            aa.C("Passing exception to original handler.");
            this.tO.uncaughtException(t, e);
        }
    }
}
