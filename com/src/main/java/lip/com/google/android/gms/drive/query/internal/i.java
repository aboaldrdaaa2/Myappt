package lip.com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class i implements Creator<MatchAllFilter> {
    static void a(MatchAllFilter matchAllFilter, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1000, matchAllFilter.xM);
        b.G(parcel, C);
    }

    /* renamed from: aM */
    public MatchAllFilter createFromParcel(Parcel parcel) {
        int B = a.B(parcel);
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1000:
                    i = a.g(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new MatchAllFilter(i);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: bI */
    public MatchAllFilter[] newArray(int i) {
        return new MatchAllFilter[i];
    }
}
