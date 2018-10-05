package lip.com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.Contents;

public class f implements Creator<CloseContentsRequest> {
    static void a(CloseContentsRequest closeContentsRequest, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, closeContentsRequest.xM);
        b.a(parcel, 2, closeContentsRequest.Iw, i, false);
        b.a(parcel, 3, closeContentsRequest.Iz, false);
        b.G(parcel, C);
    }

    /* renamed from: V */
    public CloseContentsRequest createFromParcel(Parcel parcel) {
        Boolean bool = null;
        int B = a.B(parcel);
        int i = 0;
        Contents contents = null;
        while (parcel.dataPosition() < B) {
            Contents contents2;
            int g;
            Boolean bool2;
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    Boolean bool3 = bool;
                    contents2 = contents;
                    g = a.g(parcel, A);
                    bool2 = bool3;
                    break;
                case 2:
                    g = i;
                    Contents contents3 = (Contents) a.a(parcel, A, Contents.CREATOR);
                    bool2 = bool;
                    contents2 = contents3;
                    break;
                case 3:
                    bool2 = a.d(parcel, A);
                    contents2 = contents;
                    g = i;
                    break;
                default:
                    a.b(parcel, A);
                    bool2 = bool;
                    contents2 = contents;
                    g = i;
                    break;
            }
            i = g;
            contents = contents2;
            bool = bool2;
        }
        if (parcel.dataPosition() == B) {
            return new CloseContentsRequest(i, contents, bool);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: aQ */
    public CloseContentsRequest[] newArray(int i) {
        return new CloseContentsRequest[i];
    }
}
