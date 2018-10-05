package lip.com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d;
import java.util.Locale;
import java.util.Map;

class bc extends aj {
    private static final String ID = a.LANGUAGE.toString();

    public bc() {
        super(ID, new String[0]);
    }

    public boolean lh() {
        return false;
    }

    public d.a w(Map<String, d.a> map) {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return dh.nd();
        }
        String language = locale.getLanguage();
        return language == null ? dh.nd() : dh.r(language.toLowerCase());
    }
}
