package lip.com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.ig;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.d;
import com.google.android.gms.wallet.wobs.f;
import com.google.android.gms.wallet.wobs.l;
import com.google.android.gms.wallet.wobs.n;
import com.google.android.gms.wallet.wobs.p;
import com.millennialmedia.android.MMException;
import java.util.ArrayList;

public class j implements Creator<LoyaltyWalletObject> {
    static void a(LoyaltyWalletObject loyaltyWalletObject, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, loyaltyWalletObject.getVersionCode());
        b.a(parcel, 2, loyaltyWalletObject.eC, false);
        b.a(parcel, 3, loyaltyWalletObject.aji, false);
        b.a(parcel, 4, loyaltyWalletObject.ajj, false);
        b.a(parcel, 5, loyaltyWalletObject.ajk, false);
        b.a(parcel, 6, loyaltyWalletObject.ajl, false);
        b.a(parcel, 7, loyaltyWalletObject.ajm, false);
        b.a(parcel, 8, loyaltyWalletObject.ajn, false);
        b.a(parcel, 9, loyaltyWalletObject.ajo, false);
        b.a(parcel, 10, loyaltyWalletObject.ajp, false);
        b.a(parcel, 11, loyaltyWalletObject.ajq, false);
        b.c(parcel, 12, loyaltyWalletObject.state);
        b.b(parcel, 13, loyaltyWalletObject.ajr, false);
        b.a(parcel, 14, loyaltyWalletObject.ajs, i, false);
        b.b(parcel, 15, loyaltyWalletObject.ajt, false);
        b.a(parcel, 17, loyaltyWalletObject.ajv, false);
        b.a(parcel, 16, loyaltyWalletObject.aju, false);
        b.a(parcel, 19, loyaltyWalletObject.ajx);
        b.b(parcel, 18, loyaltyWalletObject.ajw, false);
        b.b(parcel, 21, loyaltyWalletObject.ajz, false);
        b.b(parcel, 20, loyaltyWalletObject.ajy, false);
        b.a(parcel, 23, loyaltyWalletObject.ajB, i, false);
        b.b(parcel, 22, loyaltyWalletObject.ajA, false);
        b.G(parcel, C);
    }

    /* renamed from: bY */
    public LoyaltyWalletObject createFromParcel(Parcel parcel) {
        int B = a.B(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        int i2 = 0;
        ArrayList ga = ig.ga();
        l lVar = null;
        ArrayList ga2 = ig.ga();
        String str11 = null;
        String str12 = null;
        ArrayList ga3 = ig.ga();
        boolean z = false;
        ArrayList ga4 = ig.ga();
        ArrayList ga5 = ig.ga();
        ArrayList ga6 = ig.ga();
        f fVar = null;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                case 2:
                    str = a.o(parcel, A);
                    break;
                case 3:
                    str2 = a.o(parcel, A);
                    break;
                case 4:
                    str3 = a.o(parcel, A);
                    break;
                case 5:
                    str4 = a.o(parcel, A);
                    break;
                case 6:
                    str5 = a.o(parcel, A);
                    break;
                case 7:
                    str6 = a.o(parcel, A);
                    break;
                case 8:
                    str7 = a.o(parcel, A);
                    break;
                case 9:
                    str8 = a.o(parcel, A);
                    break;
                case 10:
                    str9 = a.o(parcel, A);
                    break;
                case 11:
                    str10 = a.o(parcel, A);
                    break;
                case 12:
                    i2 = a.g(parcel, A);
                    break;
                case 13:
                    ga = a.c(parcel, A, p.CREATOR);
                    break;
                case 14:
                    lVar = (l) a.a(parcel, A, l.CREATOR);
                    break;
                case 15:
                    ga2 = a.c(parcel, A, LatLng.CREATOR);
                    break;
                case 16:
                    str11 = a.o(parcel, A);
                    break;
                case 17:
                    str12 = a.o(parcel, A);
                    break;
                case 18:
                    ga3 = a.c(parcel, A, d.CREATOR);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    z = a.c(parcel, A);
                    break;
                case MMException.DISPLAY_AD_NOT_READY /*20*/:
                    ga4 = a.c(parcel, A, n.CREATOR);
                    break;
                case MMException.DISPLAY_AD_EXPIRED /*21*/:
                    ga5 = a.c(parcel, A, com.google.android.gms.wallet.wobs.j.CREATOR);
                    break;
                case MMException.DISPLAY_AD_NOT_FOUND /*22*/:
                    ga6 = a.c(parcel, A, n.CREATOR);
                    break;
                case MMException.DISPLAY_AD_ALREADY_DISPLAYED /*23*/:
                    fVar = (f) a.a(parcel, A, f.CREATOR);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new LoyaltyWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, i2, ga, lVar, ga2, str11, str12, ga3, z, ga4, ga5, ga6, fVar);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: dE */
    public LoyaltyWalletObject[] newArray(int i) {
        return new LoyaltyWalletObject[i];
    }
}
