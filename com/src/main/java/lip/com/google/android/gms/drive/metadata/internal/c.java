package lip.com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class c implements Creator<CustomProperty> {
    static void a(CustomProperty customProperty, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, customProperty.xM);
        b.a(parcel, 2, customProperty.JQ, i, false);
        b.a(parcel, 3, customProperty.mValue, false);
        b.G(parcel, C);
    }

    /* renamed from: aB */
    public CustomProperty createFromParcel(Parcel parcel) {
        String str = null;
        int B = a.B(parcel);
        int i = 0;
        CustomPropertyKey customPropertyKey = null;
        while (parcel.dataPosition() < B) {
            CustomPropertyKey customPropertyKey2;
            int g;
            String str2;
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    String str3 = str;
                    customPropertyKey2 = customPropertyKey;
                    g = a.g(parcel, A);
                    str2 = str3;
                    break;
                case 2:
                    g = i;
                    CustomPropertyKey customPropertyKey3 = (CustomPropertyKey) a.a(parcel, A, CustomPropertyKey.CREATOR);
                    str2 = str;
                    customPropertyKey2 = customPropertyKey3;
                    break;
                case 3:
                    str2 = a.o(parcel, A);
                    customPropertyKey2 = customPropertyKey;
                    g = i;
                    break;
                default:
                    a.b(parcel, A);
                    str2 = str;
                    customPropertyKey2 = customPropertyKey;
                    g = i;
                    break;
            }
            i = g;
            customPropertyKey = customPropertyKey2;
            str = str2;
        }
        if (parcel.dataPosition() == B) {
            return new CustomProperty(i, customPropertyKey, str);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: bx */
    public CustomProperty[] newArray(int i) {
        return new CustomProperty[i];
    }
}
