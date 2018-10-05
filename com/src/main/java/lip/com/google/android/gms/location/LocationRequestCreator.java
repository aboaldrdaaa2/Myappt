package lip.com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class LocationRequestCreator implements Creator<LocationRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(LocationRequest locationRequest, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, locationRequest.mPriority);
        b.c(parcel, 1000, locationRequest.getVersionCode());
        b.a(parcel, 2, locationRequest.Vl);
        b.a(parcel, 3, locationRequest.Vm);
        b.a(parcel, 4, locationRequest.Vn);
        b.a(parcel, 5, locationRequest.Vb);
        b.c(parcel, 6, locationRequest.Vo);
        b.a(parcel, 7, locationRequest.Vp);
        b.G(parcel, C);
    }

    public LocationRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        int B = a.B(parcel);
        int i = 102;
        long j = 3600000;
        long j2 = 600000;
        long j3 = Long.MAX_VALUE;
        int i2 = Integer.MAX_VALUE;
        float f = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                case 2:
                    j = a.i(parcel, A);
                    break;
                case 3:
                    j2 = a.i(parcel, A);
                    break;
                case 4:
                    z = a.c(parcel, A);
                    break;
                case 5:
                    j3 = a.i(parcel, A);
                    break;
                case 6:
                    i2 = a.g(parcel, A);
                    break;
                case 7:
                    f = a.l(parcel, A);
                    break;
                case 1000:
                    i3 = a.g(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new LocationRequest(i3, i, j, j2, z, j3, i2, f);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    public LocationRequest[] newArray(int size) {
        return new LocationRequest[size];
    }
}
