package lip.com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class e implements Creator<TextDeletedDetails> {
    static void a(TextDeletedDetails textDeletedDetails, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, textDeletedDetails.xM);
        b.c(parcel, 2, textDeletedDetails.mIndex);
        b.c(parcel, 3, textDeletedDetails.LL);
        b.G(parcel, C);
    }

    /* renamed from: aX */
    public TextDeletedDetails createFromParcel(Parcel parcel) {
        int i = 0;
        int B = a.B(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i3 = a.g(parcel, A);
                    break;
                case 2:
                    i2 = a.g(parcel, A);
                    break;
                case 3:
                    i = a.g(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new TextDeletedDetails(i3, i2, i);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: bU */
    public TextDeletedDetails[] newArray(int i) {
        return new TextDeletedDetails[i];
    }
}
