package lip.com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class y implements Creator<x> {
    static void a(x xVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, xVar.versionCode);
        b.c(parcel, 2, xVar.statusCode);
        b.a(parcel, 3, xVar.alP, i, false);
        b.G(parcel, C);
    }

    /* renamed from: cC */
    public x createFromParcel(Parcel parcel) {
        int i = 0;
        int B = a.B(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i2 = a.g(parcel, A);
                    break;
                case 2:
                    i = a.g(parcel, A);
                    break;
                case 3:
                    parcelFileDescriptor = (ParcelFileDescriptor) a.a(parcel, A, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new x(i2, i, parcelFileDescriptor);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: el */
    public x[] newArray(int i) {
        return new x[i];
    }
}
