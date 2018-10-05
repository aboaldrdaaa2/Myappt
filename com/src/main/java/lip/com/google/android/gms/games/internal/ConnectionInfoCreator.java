package lip.com.google.android.gms.games.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ConnectionInfoCreator implements Creator<ConnectionInfo> {
    static void a(ConnectionInfo connectionInfo, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.a(parcel, 1, connectionInfo.gW(), false);
        b.c(parcel, 1000, connectionInfo.getVersionCode());
        b.c(parcel, 2, connectionInfo.gX());
        b.G(parcel, C);
    }

    /* renamed from: bf */
    public ConnectionInfo createFromParcel(Parcel parcel) {
        int i = 0;
        int B = a.B(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    str = a.o(parcel, A);
                    break;
                case 2:
                    i = a.g(parcel, A);
                    break;
                case 1000:
                    i2 = a.g(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ConnectionInfo(i2, str, i);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: cf */
    public ConnectionInfo[] newArray(int i) {
        return new ConnectionInfo[i];
    }
}
