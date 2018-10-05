package lip.com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

public final class ef {
    public final int errorCode;
    public final bl nM;
    public final bu nN;
    public final String nO;
    public final bo nP;
    public final List<String> nt;
    public final List<String> nu;
    public final long nx;
    public final int orientation;
    public final ex oy;
    public final ai pX;
    public final String qa;
    public final long qf;
    public final boolean qg;
    public final long qh;
    public final List<String> qi;
    public final String ql;
    public final al rA;
    public final long rB;
    public final long rC;
    public final JSONObject ry;
    public final bm rz;

    public ef(ai aiVar, ex exVar, List<String> list, int i, List<String> list2, List<String> list3, int i2, long j, String str, boolean z, bl blVar, bu buVar, String str2, bm bmVar, bo boVar, long j2, al alVar, long j3, long j4, long j5, String str3, JSONObject jSONObject) {
        this.pX = aiVar;
        this.oy = exVar;
        this.nt = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i;
        this.nu = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.qi = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.orientation = i2;
        this.nx = j;
        this.qa = str;
        this.qg = z;
        this.nM = blVar;
        this.nN = buVar;
        this.nO = str2;
        this.rz = bmVar;
        this.nP = boVar;
        this.qh = j2;
        this.rA = alVar;
        this.qf = j3;
        this.rB = j4;
        this.rC = j5;
        this.ql = str3;
        this.ry = jSONObject;
    }
}
