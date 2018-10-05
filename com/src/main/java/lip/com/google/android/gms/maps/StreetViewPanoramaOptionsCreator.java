package lip.com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class StreetViewPanoramaOptionsCreator implements Creator<StreetViewPanoramaOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(StreetViewPanoramaOptions streetViewPanoramaOptions, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, streetViewPanoramaOptions.getVersionCode());
        b.a(parcel, 2, streetViewPanoramaOptions.getStreetViewPanoramaCamera(), i, false);
        b.a(parcel, 3, streetViewPanoramaOptions.getPanoramaId(), false);
        b.a(parcel, 4, streetViewPanoramaOptions.getPosition(), i, false);
        b.a(parcel, 5, streetViewPanoramaOptions.getRadius(), false);
        b.a(parcel, 6, streetViewPanoramaOptions.jD());
        b.a(parcel, 7, streetViewPanoramaOptions.jv());
        b.a(parcel, 8, streetViewPanoramaOptions.jE());
        b.a(parcel, 9, streetViewPanoramaOptions.jF());
        b.a(parcel, 10, streetViewPanoramaOptions.jr());
        b.G(parcel, C);
    }

    public StreetViewPanoramaOptions createFromParcel(Parcel parcel) {
        Integer num = null;
        byte b = (byte) 0;
        int B = a.B(parcel);
        byte b2 = (byte) 0;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        LatLng latLng = null;
        String str = null;
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                case 2:
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera) a.a(parcel, A, StreetViewPanoramaCamera.CREATOR);
                    break;
                case 3:
                    str = a.o(parcel, A);
                    break;
                case 4:
                    latLng = (LatLng) a.a(parcel, A, LatLng.CREATOR);
                    break;
                case 5:
                    num = a.h(parcel, A);
                    break;
                case 6:
                    b5 = a.e(parcel, A);
                    break;
                case 7:
                    b4 = a.e(parcel, A);
                    break;
                case 8:
                    b3 = a.e(parcel, A);
                    break;
                case 9:
                    b2 = a.e(parcel, A);
                    break;
                case 10:
                    b = a.e(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new StreetViewPanoramaOptions(i, streetViewPanoramaCamera, str, latLng, num, b5, b4, b3, b2, b);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    public StreetViewPanoramaOptions[] newArray(int size) {
        return new StreetViewPanoramaOptions[size];
    }
}
