package lip.com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class d implements Creator<FilterHolder> {
    static void a(FilterHolder filterHolder, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.a(parcel, 1, filterHolder.KP, i, false);
        b.c(parcel, 1000, filterHolder.xM);
        b.a(parcel, 2, filterHolder.KQ, i, false);
        b.a(parcel, 3, filterHolder.KR, i, false);
        b.a(parcel, 4, filterHolder.KS, i, false);
        b.a(parcel, 5, filterHolder.KT, i, false);
        b.a(parcel, 6, filterHolder.KU, i, false);
        b.a(parcel, 7, filterHolder.KV, i, false);
        b.G(parcel, C);
    }

    /* renamed from: aI */
    public FilterHolder createFromParcel(Parcel parcel) {
        HasFilter hasFilter = null;
        int B = a.B(parcel);
        int i = 0;
        MatchAllFilter matchAllFilter = null;
        InFilter inFilter = null;
        NotFilter notFilter = null;
        LogicalFilter logicalFilter = null;
        FieldOnlyFilter fieldOnlyFilter = null;
        ComparisonFilter comparisonFilter = null;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    comparisonFilter = (ComparisonFilter) a.a(parcel, A, ComparisonFilter.CREATOR);
                    break;
                case 2:
                    fieldOnlyFilter = (FieldOnlyFilter) a.a(parcel, A, FieldOnlyFilter.CREATOR);
                    break;
                case 3:
                    logicalFilter = (LogicalFilter) a.a(parcel, A, LogicalFilter.CREATOR);
                    break;
                case 4:
                    notFilter = (NotFilter) a.a(parcel, A, NotFilter.CREATOR);
                    break;
                case 5:
                    inFilter = (InFilter) a.a(parcel, A, InFilter.CREATOR);
                    break;
                case 6:
                    matchAllFilter = (MatchAllFilter) a.a(parcel, A, MatchAllFilter.CREATOR);
                    break;
                case 7:
                    hasFilter = (HasFilter) a.a(parcel, A, HasFilter.CREATOR);
                    break;
                case 1000:
                    i = a.g(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new FilterHolder(i, comparisonFilter, fieldOnlyFilter, logicalFilter, notFilter, inFilter, matchAllFilter, hasFilter);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: bE */
    public FilterHolder[] newArray(int i) {
        return new FilterHolder[i];
    }
}
