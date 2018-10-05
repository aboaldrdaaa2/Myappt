package lip.com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Collection;

public class a implements Creator<AppVisibleCustomProperties> {
    static void a(AppVisibleCustomProperties appVisibleCustomProperties, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, appVisibleCustomProperties.xM);
        b.b(parcel, 2, appVisibleCustomProperties.JO, false);
        b.G(parcel, C);
    }

    /* renamed from: aA */
    public AppVisibleCustomProperties createFromParcel(Parcel parcel) {
        int B = com.google.android.gms.common.internal.safeparcel.a.B(parcel);
        int i = 0;
        Collection collection = null;
        while (parcel.dataPosition() < B) {
            int A = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.ar(A)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, A);
                    break;
                case 2:
                    collection = com.google.android.gms.common.internal.safeparcel.a.c(parcel, A, CustomProperty.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new AppVisibleCustomProperties(i, collection);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: bw */
    public AppVisibleCustomProperties[] newArray(int i) {
        return new AppVisibleCustomProperties[i];
    }
}
