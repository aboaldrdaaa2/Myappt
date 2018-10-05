package lip.com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class a implements Creator<ApplicationMetadata> {
    static void a(ApplicationMetadata applicationMetadata, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, applicationMetadata.getVersionCode());
        b.a(parcel, 2, applicationMetadata.getApplicationId(), false);
        b.a(parcel, 3, applicationMetadata.getName(), false);
        b.b(parcel, 4, applicationMetadata.getImages(), false);
        b.a(parcel, 5, applicationMetadata.zR, false);
        b.a(parcel, 6, applicationMetadata.getSenderAppIdentifier(), false);
        b.a(parcel, 7, applicationMetadata.dX(), i, false);
        b.G(parcel, C);
    }

    /* renamed from: M */
    public ApplicationMetadata[] newArray(int i) {
        return new ApplicationMetadata[i];
    }

    /* renamed from: r */
    public ApplicationMetadata createFromParcel(Parcel parcel) {
        Uri uri = null;
        int B = com.google.android.gms.common.internal.safeparcel.a.B(parcel);
        int i = 0;
        String str = null;
        List list = null;
        List list2 = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < B) {
            int A = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.ar(A)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, A);
                    break;
                case 2:
                    str3 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    break;
                case 4:
                    list2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, A, WebImage.CREATOR);
                    break;
                case 5:
                    list = com.google.android.gms.common.internal.safeparcel.a.B(parcel, A);
                    break;
                case 6:
                    str = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    break;
                case 7:
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.a.a(parcel, A, Uri.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ApplicationMetadata(i, str3, str2, list2, list, str, uri);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + B, parcel);
    }
}
