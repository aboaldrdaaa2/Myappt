package lip.com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;

public class b implements Creator<a> {
    static void a(a aVar, Parcel parcel, int i) {
        int C = com.google.android.gms.common.internal.safeparcel.b.C(parcel);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, aVar.xM);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, aVar.Ew, i, false);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 3, aVar.AT);
        com.google.android.gms.common.internal.safeparcel.b.G(parcel, C);
    }

    /* renamed from: ab */
    public a[] newArray(int i) {
        return new a[i];
    }

    /* renamed from: w */
    public a createFromParcel(Parcel parcel) {
        int i = 0;
        int B = a.B(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            ParcelFileDescriptor parcelFileDescriptor2;
            int g;
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    int i3 = i;
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    g = a.g(parcel, A);
                    A = i3;
                    break;
                case 2:
                    g = i2;
                    ParcelFileDescriptor parcelFileDescriptor3 = (ParcelFileDescriptor) a.a(parcel, A, ParcelFileDescriptor.CREATOR);
                    A = i;
                    parcelFileDescriptor2 = parcelFileDescriptor3;
                    break;
                case 3:
                    A = a.g(parcel, A);
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    g = i2;
                    break;
                default:
                    a.b(parcel, A);
                    A = i;
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    g = i2;
                    break;
            }
            i2 = g;
            parcelFileDescriptor = parcelFileDescriptor2;
            i = A;
        }
        if (parcel.dataPosition() == B) {
            return new a(i2, parcelFileDescriptor, i);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }
}
