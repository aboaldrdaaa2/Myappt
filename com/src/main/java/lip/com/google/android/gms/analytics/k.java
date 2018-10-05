package lip.com.google.android.gms.analytics;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

abstract class k<T extends j> {
    Context mContext;
    a<T> tM;

    public interface a<U extends j> {
        void a(String str, int i);

        void c(String str, String str2);

        void c(String str, boolean z);

        U cB();

        void d(String str, String str2);
    }

    public k(Context context, a<T> aVar) {
        this.mContext = context;
        this.tM = aVar;
    }

    private T a(XmlResourceParser xmlResourceParser) {
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String toLowerCase = xmlResourceParser.getName().toLowerCase();
                    String trim;
                    Object attributeValue;
                    if (toLowerCase.equals("screenname")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(trim))) {
                            this.tM.c(toLowerCase, trim);
                        }
                    } else if (toLowerCase.equals("string")) {
                        attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(attributeValue) || trim == null)) {
                            this.tM.d(attributeValue, trim);
                        }
                    } else if (toLowerCase.equals("bool")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(trim))) {
                            try {
                                this.tM.c(toLowerCase, Boolean.parseBoolean(trim));
                            } catch (NumberFormatException e) {
                                aa.A("Error parsing bool configuration value: " + trim);
                            }
                        }
                    } else if (toLowerCase.equals("integer")) {
                        attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(attributeValue) || TextUtils.isEmpty(trim))) {
                            try {
                                this.tM.a(attributeValue, Integer.parseInt(trim));
                            } catch (NumberFormatException e2) {
                                aa.A("Error parsing int configuration value: " + trim);
                            }
                        }
                    } else {
                        continue;
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (XmlPullParserException e3) {
            aa.A("Error parsing tracker configuration file: " + e3);
        } catch (IOException e4) {
            aa.A("Error parsing tracker configuration file: " + e4);
        }
        return this.tM.cB();
    }

    public T r(int i) {
        try {
            return a(this.mContext.getResources().getXml(i));
        } catch (NotFoundException e) {
            aa.D("inflate() called with unknown resourceId: " + e);
            return null;
        }
    }
}
