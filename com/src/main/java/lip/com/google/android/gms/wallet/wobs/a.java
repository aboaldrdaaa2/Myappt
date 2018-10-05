package lip.com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.ig;
import com.google.android.gms.maps.model.LatLng;
import com.millennialmedia.android.MMException;
import java.util.ArrayList;

public class a implements Creator<CommonWalletObject> {
    static void a(CommonWalletObject commonWalletObject, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, commonWalletObject.getVersionCode());
        b.a(parcel, 2, commonWalletObject.eC, false);
        b.a(parcel, 3, commonWalletObject.ajq, false);
        b.a(parcel, 4, commonWalletObject.name, false);
        b.a(parcel, 5, commonWalletObject.ajj, false);
        b.a(parcel, 6, commonWalletObject.ajm, false);
        b.a(parcel, 7, commonWalletObject.ajn, false);
        b.a(parcel, 8, commonWalletObject.ajo, false);
        b.a(parcel, 9, commonWalletObject.ajp, false);
        b.c(parcel, 10, commonWalletObject.state);
        b.b(parcel, 11, commonWalletObject.ajr, false);
        b.a(parcel, 12, commonWalletObject.ajs, i, false);
        b.b(parcel, 13, commonWalletObject.ajt, false);
        b.a(parcel, 14, commonWalletObject.aju, false);
        b.a(parcel, 15, commonWalletObject.ajv, false);
        b.a(parcel, 17, commonWalletObject.ajx);
        b.b(parcel, 16, commonWalletObject.ajw, false);
        b.b(parcel, 19, commonWalletObject.ajz, false);
        b.b(parcel, 18, commonWalletObject.ajy, false);
        b.b(parcel, 20, commonWalletObject.ajA, false);
        b.G(parcel, C);
    }

    /* renamed from: cj */
    public CommonWalletObject createFromParcel(Parcel parcel) {
        int B = com.google.android.gms.common.internal.safeparcel.a.B(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        int i2 = 0;
        ArrayList ga = ig.ga();
        l lVar = null;
        ArrayList ga2 = ig.ga();
        String str9 = null;
        String str10 = null;
        ArrayList ga3 = ig.ga();
        boolean z = false;
        ArrayList ga4 = ig.ga();
        ArrayList ga5 = ig.ga();
        ArrayList ga6 = ig.ga();
        while (parcel.dataPosition() < B) {
            int A = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.ar(A)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, A);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    break;
                case 4:
                    str3 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    break;
                case 5:
                    str4 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    break;
                case 6:
                    str5 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    break;
                case 7:
                    str6 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    break;
                case 8:
                    str7 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    break;
                case 9:
                    str8 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    break;
                case 10:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, A);
                    break;
                case 11:
                    ga = com.google.android.gms.common.internal.safeparcel.a.c(parcel, A, p.CREATOR);
                    break;
                case 12:
                    lVar = (l) com.google.android.gms.common.internal.safeparcel.a.a(parcel, A, l.CREATOR);
                    break;
                case 13:
                    ga2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, A, LatLng.CREATOR);
                    break;
                case 14:
                    str9 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    break;
                case 15:
                    str10 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    break;
                case 16:
                    ga3 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, A, d.CREATOR);
                    break;
                case 17:
                    z = com.google.android.gms.common.internal.safeparcel.a.c(parcel, A);
                    break;
                case 18:
                    ga4 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, A, n.CREATOR);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    ga5 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, A, j.CREATOR);
                    break;
                case MMException.DISPLAY_AD_NOT_READY /*20*/:
                    ga6 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, A, n.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new CommonWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, i2, ga, lVar, ga2, str9, str10, ga3, z, ga4, ga5, ga6);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: dR */
    public CommonWalletObject[] newArray(int i) {
        return new CommonWalletObject[i];
    }
}
