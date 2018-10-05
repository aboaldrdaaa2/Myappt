package lip.com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.query.Query;

public class at implements Creator<QueryRequest> {
    static void a(QueryRequest queryRequest, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, queryRequest.xM);
        b.a(parcel, 2, queryRequest.JE, i, false);
        b.G(parcel, C);
    }

    /* renamed from: au */
    public QueryRequest createFromParcel(Parcel parcel) {
        int B = a.B(parcel);
        int i = 0;
        Query query = null;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                case 2:
                    query = (Query) a.a(parcel, A, Query.CREATOR);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new QueryRequest(i, query);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: bq */
    public QueryRequest[] newArray(int i) {
        return new QueryRequest[i];
    }
}
