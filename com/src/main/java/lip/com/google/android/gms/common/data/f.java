package lip.com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class f implements Creator<DataHolder> {
    static void a(DataHolder dataHolder, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.a(parcel, 1, dataHolder.eX(), false);
        b.c(parcel, 1000, dataHolder.getVersionCode());
        b.a(parcel, 2, dataHolder.eY(), i, false);
        b.c(parcel, 3, dataHolder.getStatusCode());
        b.a(parcel, 4, dataHolder.eU(), false);
        b.G(parcel, C);
    }

    /* renamed from: ag */
    public DataHolder[] newArray(int i) {
        return new DataHolder[i];
    }

    /* renamed from: x */
    public DataHolder createFromParcel(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int B = a.B(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    strArr = a.A(parcel, A);
                    break;
                case 2:
                    cursorWindowArr = (CursorWindow[]) a.b(parcel, A, CursorWindow.CREATOR);
                    break;
                case 3:
                    i = a.g(parcel, A);
                    break;
                case 4:
                    bundle = a.q(parcel, A);
                    break;
                case 1000:
                    i2 = a.g(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() != B) {
            throw new a.a("Overread allowed size end=" + B, parcel);
        }
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.eW();
        return dataHolder;
    }
}
