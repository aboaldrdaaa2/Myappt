package lip.com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c implements Creator<LaunchOptions> {
    static void a(LaunchOptions launchOptions, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, launchOptions.getVersionCode());
        b.a(parcel, 2, launchOptions.getRelaunchIfRunning());
        b.a(parcel, 3, launchOptions.getLanguage(), false);
        b.G(parcel, C);
    }

    /* renamed from: Q */
    public LaunchOptions[] newArray(int i) {
        return new LaunchOptions[i];
    }

    /* renamed from: t */
    public LaunchOptions createFromParcel(Parcel parcel) {
        boolean z = false;
        int B = a.B(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                case 2:
                    z = a.c(parcel, A);
                    break;
                case 3:
                    str = a.o(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new LaunchOptions(i, z, str);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }
}
