package lip.com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.CameraPosition;

public class GoogleMapOptionsCreator implements Creator<GoogleMapOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

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

    public GoogleMapOptions createFromParcel(Parcel parcel) {
        byte b = (byte) 0;
        int B = a.B(parcel);
        CameraPosition cameraPosition = null;
        byte b2 = (byte) 0;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        byte b6 = (byte) 0;
        int i = 0;
        byte b7 = (byte) 0;
        byte b8 = (byte) 0;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i2 = a.g(parcel, A);
                    break;
                case 2:
                    b8 = a.e(parcel, A);
                    break;
                case 3:
                    b7 = a.e(parcel, A);
                    break;
                case 4:
                    i = a.g(parcel, A);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) a.a(parcel, A, CameraPosition.CREATOR);
                    break;
                case 6:
                    b6 = a.e(parcel, A);
                    break;
                case 7:
                    b5 = a.e(parcel, A);
                    break;
                case 8:
                    b4 = a.e(parcel, A);
                    break;
                case 9:
                    b3 = a.e(parcel, A);
                    break;
                case 10:
                    b2 = a.e(parcel, A);
                    break;
                case 11:
                    b = a.e(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new GoogleMapOptions(i2, b8, b7, i, cameraPosition, b6, b5, b4, b3, b2, b);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    public GoogleMapOptions[] newArray(int size) {
        return new GoogleMapOptions[size];
    }
}
