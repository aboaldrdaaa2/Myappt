package lip.com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;

public class a {
    static void a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, googleMapOptions.getVersionCode());
        b.a(parcel, 2, googleMapOptions.jq());
        b.a(parcel, 3, googleMapOptions.jr());
        b.c(parcel, 4, googleMapOptions.getMapType());
        b.a(parcel, 5, googleMapOptions.getCamera(), i, false);
        b.a(parcel, 6, googleMapOptions.js());
        b.a(parcel, 7, googleMapOptions.jt());
        b.a(parcel, 8, googleMapOptions.ju());
        b.a(parcel, 9, googleMapOptions.jv());
        b.a(parcel, 10, googleMapOptions.jw());
        b.a(parcel, 11, googleMapOptions.jx());
        b.G(parcel, C);
    }
}
