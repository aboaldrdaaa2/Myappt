package lip.com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.query.internal.LogicalFilter;

public class a implements Creator<Query> {
    static void a(Query query, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1000, query.xM);
        b.a(parcel, 1, query.KE, i, false);
        b.a(parcel, 3, query.KF, false);
        b.a(parcel, 4, query.KG, i, false);
        b.G(parcel, C);
    }

    /* renamed from: aD */
    public Query createFromParcel(Parcel parcel) {
        SortOrder sortOrder = null;
        int B = com.google.android.gms.common.internal.safeparcel.a.B(parcel);
        int i = 0;
        String str = null;
        LogicalFilter logicalFilter = null;
        while (parcel.dataPosition() < B) {
            int i2;
            LogicalFilter logicalFilter2;
            SortOrder sortOrder2;
            String str2;
            int A = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
            SortOrder sortOrder3;
            switch (com.google.android.gms.common.internal.safeparcel.a.ar(A)) {
                case 1:
                    i2 = i;
                    String str3 = str;
                    logicalFilter2 = (LogicalFilter) com.google.android.gms.common.internal.safeparcel.a.a(parcel, A, LogicalFilter.CREATOR);
                    sortOrder2 = sortOrder;
                    str2 = str3;
                    break;
                case 3:
                    logicalFilter2 = logicalFilter;
                    i2 = i;
                    sortOrder3 = sortOrder;
                    str2 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    sortOrder2 = sortOrder3;
                    break;
                case 4:
                    sortOrder2 = (SortOrder) com.google.android.gms.common.internal.safeparcel.a.a(parcel, A, SortOrder.CREATOR);
                    str2 = str;
                    logicalFilter2 = logicalFilter;
                    i2 = i;
                    break;
                case 1000:
                    sortOrder3 = sortOrder;
                    str2 = str;
                    logicalFilter2 = logicalFilter;
                    i2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, A);
                    sortOrder2 = sortOrder3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, A);
                    sortOrder2 = sortOrder;
                    str2 = str;
                    logicalFilter2 = logicalFilter;
                    i2 = i;
                    break;
            }
            i = i2;
            logicalFilter = logicalFilter2;
            str = str2;
            sortOrder = sortOrder2;
        }
        if (parcel.dataPosition() == B) {
            return new Query(i, logicalFilter, str, sortOrder);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: bz */
    public Query[] newArray(int i) {
        return new Query[i];
    }
}
