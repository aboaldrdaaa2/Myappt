package lip.com.google.android.gms.internal;

import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

public final class bw implements MediationAdRequest {
    private final Date d;
    private final Set<String> f;
    private final boolean g;
    private final int ml;
    private final int nR;

    public bw(Date date, int i, Set<String> set, boolean z, int i2) {
        this.d = date;
        this.ml = i;
        this.f = set;
        this.g = z;
        this.nR = i2;
    }

    public Date getBirthday() {
        return this.d;
    }

    public int getGender() {
        return this.ml;
    }

    public Set<String> getKeywords() {
        return this.f;
    }

    public boolean isTesting() {
        return this.g;
    }

    public int taggedForChildDirectedTreatment() {
        return this.nR;
    }
}
