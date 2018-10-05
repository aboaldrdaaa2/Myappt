package lip.com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.List;

public class a implements Creator<UserAddressRequest> {
    static void a(UserAddressRequest userAddressRequest, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, userAddressRequest.getVersionCode());
        b.b(parcel, 2, userAddressRequest.UE, false);
        b.G(parcel, C);
    }

    /* renamed from: bp */
    public UserAddressRequest createFromParcel(Parcel parcel) {
        int B = com.google.android.gms.common.internal.safeparcel.a.B(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < B) {
            int A = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.ar(A)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, A);
                    break;
                case 2:
                    list = com.google.android.gms.common.internal.safeparcel.a.c(parcel, A, CountrySpecification.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new UserAddressRequest(i, list);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: cC */
    public UserAddressRequest[] newArray(int i) {
        return new UserAddressRequest[i];
    }
}
