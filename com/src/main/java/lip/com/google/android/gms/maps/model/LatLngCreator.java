package lip.com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class LatLngCreator implements Creator<LatLng> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(LatLng latLng, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, latLng.getVersionCode());
        b.a(parcel, 2, latLng.latitude);
        b.a(parcel, 3, latLng.longitude);
        b.G(parcel, C);
    }

    public LatLng createFromParcel(Parcel parcel) {
        double d = 0.0d;
        int B = a.B(parcel);
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                case 2:
                    d2 = a.m(parcel, A);
                    break;
                case 3:
                    d = a.m(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new LatLng(i, d2, d);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    public LatLng[] newArray(int size) {
        return new LatLng[size];
    }
}
