package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.ks.c;
import com.google.android.gms.internal.ks.d;
import com.google.android.gms.internal.ks.f;
import com.google.android.gms.internal.ks.g;
import com.google.android.gms.internal.ks.h;
import com.millennialmedia.android.MMException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class kt implements Creator<ks> {
    static void a(ks ksVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        Set kk = ksVar.kk();
        if (kk.contains(Integer.valueOf(1))) {
            b.c(parcel, 1, ksVar.getVersionCode());
        }
        if (kk.contains(Integer.valueOf(2))) {
            b.a(parcel, 2, ksVar.getAboutMe(), true);
        }
        if (kk.contains(Integer.valueOf(3))) {
            b.a(parcel, 3, ksVar.kF(), i, true);
        }
        if (kk.contains(Integer.valueOf(4))) {
            b.a(parcel, 4, ksVar.getBirthday(), true);
        }
        if (kk.contains(Integer.valueOf(5))) {
            b.a(parcel, 5, ksVar.getBraggingRights(), true);
        }
        if (kk.contains(Integer.valueOf(6))) {
            b.c(parcel, 6, ksVar.getCircledByCount());
        }
        if (kk.contains(Integer.valueOf(7))) {
            b.a(parcel, 7, ksVar.kG(), i, true);
        }
        if (kk.contains(Integer.valueOf(8))) {
            b.a(parcel, 8, ksVar.getCurrentLocation(), true);
        }
        if (kk.contains(Integer.valueOf(9))) {
            b.a(parcel, 9, ksVar.getDisplayName(), true);
        }
        if (kk.contains(Integer.valueOf(12))) {
            b.c(parcel, 12, ksVar.getGender());
        }
        if (kk.contains(Integer.valueOf(14))) {
            b.a(parcel, 14, ksVar.getId(), true);
        }
        if (kk.contains(Integer.valueOf(15))) {
            b.a(parcel, 15, ksVar.kH(), i, true);
        }
        if (kk.contains(Integer.valueOf(16))) {
            b.a(parcel, 16, ksVar.isPlusUser());
        }
        if (kk.contains(Integer.valueOf(19))) {
            b.a(parcel, 19, ksVar.kI(), i, true);
        }
        if (kk.contains(Integer.valueOf(18))) {
            b.a(parcel, 18, ksVar.getLanguage(), true);
        }
        if (kk.contains(Integer.valueOf(21))) {
            b.c(parcel, 21, ksVar.getObjectType());
        }
        if (kk.contains(Integer.valueOf(20))) {
            b.a(parcel, 20, ksVar.getNickname(), true);
        }
        if (kk.contains(Integer.valueOf(23))) {
            b.b(parcel, 23, ksVar.kK(), true);
        }
        if (kk.contains(Integer.valueOf(22))) {
            b.b(parcel, 22, ksVar.kJ(), true);
        }
        if (kk.contains(Integer.valueOf(25))) {
            b.c(parcel, 25, ksVar.getRelationshipStatus());
        }
        if (kk.contains(Integer.valueOf(24))) {
            b.c(parcel, 24, ksVar.getPlusOneCount());
        }
        if (kk.contains(Integer.valueOf(27))) {
            b.a(parcel, 27, ksVar.getUrl(), true);
        }
        if (kk.contains(Integer.valueOf(26))) {
            b.a(parcel, 26, ksVar.getTagline(), true);
        }
        if (kk.contains(Integer.valueOf(29))) {
            b.a(parcel, 29, ksVar.isVerified());
        }
        if (kk.contains(Integer.valueOf(28))) {
            b.b(parcel, 28, ksVar.kL(), true);
        }
        b.G(parcel, C);
    }

    /* renamed from: bG */
    public ks createFromParcel(Parcel parcel) {
        int B = a.B(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        ks.a aVar = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        ks.b bVar = null;
        String str4 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        c cVar = null;
        boolean z = false;
        String str7 = null;
        d dVar = null;
        String str8 = null;
        int i4 = 0;
        List list = null;
        List list2 = null;
        int i5 = 0;
        int i6 = 0;
        String str9 = null;
        String str10 = null;
        List list3 = null;
        boolean z2 = false;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    ks.a aVar2 = (ks.a) a.a(parcel, A, ks.a.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    aVar = aVar2;
                    break;
                case 4:
                    str2 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str3 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    i2 = a.g(parcel, A);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    ks.b bVar2 = (ks.b) a.a(parcel, A, ks.b.CREATOR);
                    hashSet.add(Integer.valueOf(7));
                    bVar = bVar2;
                    break;
                case 8:
                    str4 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    str5 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 12:
                    i3 = a.g(parcel, A);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case 14:
                    str6 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case 15:
                    c cVar2 = (c) a.a(parcel, A, c.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    cVar = cVar2;
                    break;
                case 16:
                    z = a.c(parcel, A);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case 18:
                    str7 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    d dVar2 = (d) a.a(parcel, A, (Creator) d.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    dVar = dVar2;
                    break;
                case MMException.DISPLAY_AD_NOT_READY /*20*/:
                    str8 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case MMException.DISPLAY_AD_EXPIRED /*21*/:
                    i4 = a.g(parcel, A);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case MMException.DISPLAY_AD_NOT_FOUND /*22*/:
                    list = a.c(parcel, A, f.CREATOR);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case MMException.DISPLAY_AD_ALREADY_DISPLAYED /*23*/:
                    list2 = a.c(parcel, A, g.CREATOR);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case MMException.DISPLAY_AD_NOT_PERMITTED /*24*/:
                    i5 = a.g(parcel, A);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case MMException.AD_BROKEN_REFERENCE /*25*/:
                    i6 = a.g(parcel, A);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case MMException.AD_NO_ACTIVITY /*26*/:
                    str9 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case 27:
                    str10 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case 28:
                    list3 = a.c(parcel, A, h.CREATOR);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case 29:
                    z2 = a.c(parcel, A);
                    hashSet.add(Integer.valueOf(29));
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ks(hashSet, i, str, aVar, str2, str3, i2, bVar, str4, str5, i3, str6, cVar, z, str7, dVar, str8, i4, list, list2, i5, i6, str9, str10, list3, z2);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: dd */
    public ks[] newArray(int i) {
        return new ks[i];
    }
}
