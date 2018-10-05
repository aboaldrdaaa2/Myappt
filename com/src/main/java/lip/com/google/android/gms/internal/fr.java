package lip.com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.iv.a;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;

public class fr implements SafeParcelable {
    public static final fs CREATOR = new fs();
    public final String mP;
    final int xM;
    final fi yq;
    final long yr;
    final int ys;
    final fg yt;

    fr(int i, fi fiVar, long j, int i2, String str, fg fgVar) {
        this.xM = i;
        this.yq = fiVar;
        this.yr = j;
        this.ys = i2;
        this.mP = str;
        this.yt = fgVar;
    }

    public fr(fi fiVar, long j, int i) {
        this(1, fiVar, j, i, null, null);
    }

    public fr(String str, Intent intent, String str2, Uri uri, String str3, List<AppIndexingLink> list) {
        this(1, a(str, intent), System.currentTimeMillis(), 0, null, a(intent, str2, uri, str3, list));
    }

    static fg a(Intent intent, String str, Uri uri, String str2, List<AppIndexingLink> list) {
        List arrayList = new ArrayList();
        arrayList.add(ab(str));
        if (uri != null) {
            arrayList.add(f(uri));
        }
        if (list != null) {
            arrayList.add(a(list));
        }
        String action = intent.getAction();
        if (action != null) {
            arrayList.add(f("intent_action", action));
        }
        action = intent.getDataString();
        if (action != null) {
            arrayList.add(f("intent_data", action));
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            arrayList.add(f("intent_activity", component.getClassName()));
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            action = extras.getString("intent_extra_data_key");
            if (action != null) {
                arrayList.add(f("intent_extra_data", action));
            }
        }
        return new fg(str2, true, (fk[]) arrayList.toArray(new fk[arrayList.size()]));
    }

    public static fi a(String str, Intent intent) {
        return new fi(str, "", f(intent));
    }

    private static fk a(List<AppIndexingLink> list) {
        me aVar = new a();
        a.a[] aVarArr = new a.a[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < aVarArr.length) {
                aVarArr[i2] = new a.a();
                AppIndexingLink appIndexingLink = (AppIndexingLink) list.get(i2);
                aVarArr[i2].UA = appIndexingLink.appIndexingUrl.toString();
                aVarArr[i2].UB = appIndexingLink.webUrl.toString();
                aVarArr[i2].viewId = appIndexingLink.viewId;
                i = i2 + 1;
            } else {
                aVar.Uy = aVarArr;
                return new fk(me.d(aVar), new fp.a("outlinks").w(true).aa(".private:outLinks").Z("blob").dQ());
            }
        }
    }

    private static fk ab(String str) {
        return new fk(str, new fp.a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE).I(1).x(true).aa("name").dQ(), "text1");
    }

    private static fk f(Uri uri) {
        return new fk(uri.toString(), new fp.a("web_url").I(4).w(true).aa("url").dQ());
    }

    private static fk f(String str, String str2) {
        return new fk(str2, new fp.a(str).w(true).dQ(), str);
    }

    private static String f(Intent intent) {
        String toUri = intent.toUri(1);
        CRC32 crc32 = new CRC32();
        try {
            crc32.update(toUri.getBytes("UTF-8"));
            return Long.toHexString(crc32.getValue());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public int describeContents() {
        fs fsVar = CREATOR;
        return 0;
    }

    public String toString() {
        return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d]", new Object[]{this.yq, Long.valueOf(this.yr), Integer.valueOf(this.ys)});
    }

    public void writeToParcel(Parcel dest, int flags) {
        fs fsVar = CREATOR;
        fs.a(this, dest, flags);
    }
}
