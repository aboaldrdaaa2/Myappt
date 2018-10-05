package lip.com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public class a implements Creator<Asset> {
    static void a(Asset asset, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, asset.xM);
        b.a(parcel, 2, asset.getData(), false);
        b.a(parcel, 3, asset.getDigest(), false);
        b.a(parcel, 4, asset.alh, i, false);
        b.a(parcel, 5, asset.uri, i, false);
        b.G(parcel, C);
    }

    /* renamed from: cs */
    public Asset createFromParcel(Parcel parcel) {
        Uri uri = null;
        int B = com.google.android.gms.common.internal.safeparcel.a.B(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        String str = null;
        byte[] bArr = null;
        while (parcel.dataPosition() < B) {
            int A = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.ar(A)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, A);
                    break;
                case 2:
                    bArr = com.google.android.gms.common.internal.safeparcel.a.r(parcel, A);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    break;
                case 4:
                    parcelFileDescriptor = (ParcelFileDescriptor) com.google.android.gms.common.internal.safeparcel.a.a(parcel, A, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.a.a(parcel, A, Uri.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new Asset(i, bArr, str, parcelFileDescriptor, uri);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: ea */
    public Asset[] newArray(int i) {
        return new Asset[i];
    }
}
