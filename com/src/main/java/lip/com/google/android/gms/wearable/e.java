package lip.com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class e implements Creator<PutDataRequest> {
    static void a(PutDataRequest putDataRequest, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, putDataRequest.xM);
        b.a(parcel, 2, putDataRequest.getUri(), i, false);
        b.a(parcel, 4, putDataRequest.nm(), false);
        b.a(parcel, 5, putDataRequest.getData(), false);
        b.G(parcel, C);
    }

    /* renamed from: cu */
    public PutDataRequest createFromParcel(Parcel parcel) {
        byte[] bArr = null;
        int B = a.B(parcel);
        int i = 0;
        Bundle bundle = null;
        Uri uri = null;
        while (parcel.dataPosition() < B) {
            Bundle bundle2;
            Uri uri2;
            int g;
            byte[] bArr2;
            int A = a.A(parcel);
            byte[] bArr3;
            switch (a.ar(A)) {
                case 1:
                    bArr3 = bArr;
                    bundle2 = bundle;
                    uri2 = uri;
                    g = a.g(parcel, A);
                    bArr2 = bArr3;
                    break;
                case 2:
                    g = i;
                    Bundle bundle3 = bundle;
                    uri2 = (Uri) a.a(parcel, A, Uri.CREATOR);
                    bArr2 = bArr;
                    bundle2 = bundle3;
                    break;
                case 4:
                    uri2 = uri;
                    g = i;
                    bArr3 = bArr;
                    bundle2 = a.q(parcel, A);
                    bArr2 = bArr3;
                    break;
                case 5:
                    bArr2 = a.r(parcel, A);
                    bundle2 = bundle;
                    uri2 = uri;
                    g = i;
                    break;
                default:
                    a.b(parcel, A);
                    bArr2 = bArr;
                    bundle2 = bundle;
                    uri2 = uri;
                    g = i;
                    break;
            }
            i = g;
            uri = uri2;
            bundle = bundle2;
            bArr = bArr2;
        }
        if (parcel.dataPosition() == B) {
            return new PutDataRequest(i, uri, bundle, bArr);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: ec */
    public PutDataRequest[] newArray(int i) {
        return new PutDataRequest[i];
    }
}
