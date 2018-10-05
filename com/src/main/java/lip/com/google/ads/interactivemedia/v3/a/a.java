package lip.com.google.ads.interactivemedia.v3.a;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: IMASDK */
final class a implements k<Date>, s<Date> {
    private final DateFormat a;
    private final DateFormat b;
    private final DateFormat c;

    public final /* synthetic */ Object a(l lVar, Type type) throws p {
        if (lVar instanceof q) {
            Date a = a(lVar);
            if (type == Date.class) {
                return a;
            }
            if (type == Timestamp.class) {
                return new Timestamp(a.getTime());
            }
            if (type == java.sql.Date.class) {
                return new java.sql.Date(a.getTime());
            }
            throw new IllegalArgumentException(getClass() + " cannot deserialize to " + type);
        }
        throw new p("The date should be a string value");
    }

    a() {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    a(String str) {
        this(new SimpleDateFormat(str, Locale.US), new SimpleDateFormat(str));
    }

    public a(int i, int i2) {
        this(DateFormat.getDateTimeInstance(i, i2, Locale.US), DateFormat.getDateTimeInstance(i, i2));
    }

    private a(DateFormat dateFormat, DateFormat dateFormat2) {
        this.a = dateFormat;
        this.b = dateFormat2;
        this.c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        this.c.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    private l a(Date date) {
        l qVar;
        synchronized (this.b) {
            qVar = new q(this.a.format(date));
        }
        return qVar;
    }

    private Date a(l lVar) {
        Date parse;
        synchronized (this.b) {
            try {
                parse = this.b.parse(lVar.b());
            } catch (ParseException e) {
                try {
                    parse = this.a.parse(lVar.b());
                } catch (ParseException e2) {
                    try {
                        parse = this.c.parse(lVar.b());
                    } catch (Throwable e3) {
                        throw new t(lVar.b(), e3);
                    }
                }
            }
        }
        return parse;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a.class.getSimpleName());
        stringBuilder.append('(').append(this.b.getClass().getSimpleName()).append(')');
        return stringBuilder.toString();
    }
}
