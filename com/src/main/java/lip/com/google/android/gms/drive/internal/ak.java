package lip.com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ak implements Creator<OnListEntriesResponse> {
    static void a(OnListEntriesResponse onListEntriesResponse, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, onListEntriesResponse.xM);
        b.a(parcel, 2, onListEntriesResponse.JA, i, false);
        b.a(parcel, 3, onListEntriesResponse.IP);
        b.G(parcel, C);
    }

    /* renamed from: al */
    public OnListEntriesResponse createFromParcel(Parcel parcel) {
        boolean z = false;
        int B = a.B(parcel);
        DataHolder dataHolder = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            DataHolder dataHolder2;
            int g;
            boolean z2;
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    boolean z3 = z;
                    dataHolder2 = dataHolder;
                    g = a.g(parcel, A);
                    z2 = z3;
                    break;
                case 2:
                    g = i;
                    DataHolder dataHolder3 = (DataHolder) a.a(parcel, A, DataHolder.CREATOR);
                    z2 = z;
                    dataHolder2 = dataHolder3;
                    break;
                case 3:
                    z2 = a.c(parcel, A);
                    dataHolder2 = dataHolder;
                    g = i;
                    break;
                default:
                    a.b(parcel, A);
                    z2 = z;
                    dataHolder2 = dataHolder;
                    g = i;
                    break;
            }
            i = g;
            dataHolder = dataHolder2;
            z = z2;
        }
        if (parcel.dataPosition() == B) {
            return new OnListEntriesResponse(i, dataHolder, z);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: bh */
    public OnListEntriesResponse[] newArray(int i) {
        return new OnListEntriesResponse[i];
    }
}
