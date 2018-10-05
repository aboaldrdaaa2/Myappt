package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.Notifications;
import com.millennialmedia.android.MMException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ko implements Creator<kn> {
    static void a(kn knVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        Set kk = knVar.kk();
        if (kk.contains(Integer.valueOf(1))) {
            b.c(parcel, 1, knVar.getVersionCode());
        }
        if (kk.contains(Integer.valueOf(2))) {
            b.a(parcel, 2, knVar.kl(), i, true);
        }
        if (kk.contains(Integer.valueOf(3))) {
            b.a(parcel, 3, knVar.getAdditionalName(), true);
        }
        if (kk.contains(Integer.valueOf(4))) {
            b.a(parcel, 4, knVar.km(), i, true);
        }
        if (kk.contains(Integer.valueOf(5))) {
            b.a(parcel, 5, knVar.getAddressCountry(), true);
        }
        if (kk.contains(Integer.valueOf(6))) {
            b.a(parcel, 6, knVar.getAddressLocality(), true);
        }
        if (kk.contains(Integer.valueOf(7))) {
            b.a(parcel, 7, knVar.getAddressRegion(), true);
        }
        if (kk.contains(Integer.valueOf(8))) {
            b.b(parcel, 8, knVar.kn(), true);
        }
        if (kk.contains(Integer.valueOf(9))) {
            b.c(parcel, 9, knVar.getAttendeeCount());
        }
        if (kk.contains(Integer.valueOf(10))) {
            b.b(parcel, 10, knVar.ko(), true);
        }
        if (kk.contains(Integer.valueOf(11))) {
            b.a(parcel, 11, knVar.kp(), i, true);
        }
        if (kk.contains(Integer.valueOf(12))) {
            b.b(parcel, 12, knVar.kq(), true);
        }
        if (kk.contains(Integer.valueOf(13))) {
            b.a(parcel, 13, knVar.getBestRating(), true);
        }
        if (kk.contains(Integer.valueOf(14))) {
            b.a(parcel, 14, knVar.getBirthDate(), true);
        }
        if (kk.contains(Integer.valueOf(15))) {
            b.a(parcel, 15, knVar.kr(), i, true);
        }
        if (kk.contains(Integer.valueOf(17))) {
            b.a(parcel, 17, knVar.getContentSize(), true);
        }
        if (kk.contains(Integer.valueOf(16))) {
            b.a(parcel, 16, knVar.getCaption(), true);
        }
        if (kk.contains(Integer.valueOf(19))) {
            b.b(parcel, 19, knVar.ks(), true);
        }
        if (kk.contains(Integer.valueOf(18))) {
            b.a(parcel, 18, knVar.getContentUrl(), true);
        }
        if (kk.contains(Integer.valueOf(21))) {
            b.a(parcel, 21, knVar.getDateModified(), true);
        }
        if (kk.contains(Integer.valueOf(20))) {
            b.a(parcel, 20, knVar.getDateCreated(), true);
        }
        if (kk.contains(Integer.valueOf(23))) {
            b.a(parcel, 23, knVar.getDescription(), true);
        }
        if (kk.contains(Integer.valueOf(22))) {
            b.a(parcel, 22, knVar.getDatePublished(), true);
        }
        if (kk.contains(Integer.valueOf(25))) {
            b.a(parcel, 25, knVar.getEmbedUrl(), true);
        }
        if (kk.contains(Integer.valueOf(24))) {
            b.a(parcel, 24, knVar.getDuration(), true);
        }
        if (kk.contains(Integer.valueOf(27))) {
            b.a(parcel, 27, knVar.getFamilyName(), true);
        }
        if (kk.contains(Integer.valueOf(26))) {
            b.a(parcel, 26, knVar.getEndDate(), true);
        }
        if (kk.contains(Integer.valueOf(29))) {
            b.a(parcel, 29, knVar.kt(), i, true);
        }
        if (kk.contains(Integer.valueOf(28))) {
            b.a(parcel, 28, knVar.getGender(), true);
        }
        if (kk.contains(Integer.valueOf(31))) {
            b.a(parcel, 31, knVar.getHeight(), true);
        }
        if (kk.contains(Integer.valueOf(30))) {
            b.a(parcel, 30, knVar.getGivenName(), true);
        }
        if (kk.contains(Integer.valueOf(34))) {
            b.a(parcel, 34, knVar.ku(), i, true);
        }
        if (kk.contains(Integer.valueOf(32))) {
            b.a(parcel, 32, knVar.getId(), true);
        }
        if (kk.contains(Integer.valueOf(33))) {
            b.a(parcel, 33, knVar.getImage(), true);
        }
        if (kk.contains(Integer.valueOf(38))) {
            b.a(parcel, 38, knVar.getLongitude());
        }
        if (kk.contains(Integer.valueOf(39))) {
            b.a(parcel, 39, knVar.getName(), true);
        }
        if (kk.contains(Integer.valueOf(36))) {
            b.a(parcel, 36, knVar.getLatitude());
        }
        if (kk.contains(Integer.valueOf(37))) {
            b.a(parcel, 37, knVar.kv(), i, true);
        }
        if (kk.contains(Integer.valueOf(42))) {
            b.a(parcel, 42, knVar.getPlayerType(), true);
        }
        if (kk.contains(Integer.valueOf(43))) {
            b.a(parcel, 43, knVar.getPostOfficeBoxNumber(), true);
        }
        if (kk.contains(Integer.valueOf(40))) {
            b.a(parcel, 40, knVar.kw(), i, true);
        }
        if (kk.contains(Integer.valueOf(41))) {
            b.b(parcel, 41, knVar.kx(), true);
        }
        if (kk.contains(Integer.valueOf(46))) {
            b.a(parcel, 46, knVar.ky(), i, true);
        }
        if (kk.contains(Integer.valueOf(47))) {
            b.a(parcel, 47, knVar.getStartDate(), true);
        }
        if (kk.contains(Integer.valueOf(44))) {
            b.a(parcel, 44, knVar.getPostalCode(), true);
        }
        if (kk.contains(Integer.valueOf(45))) {
            b.a(parcel, 45, knVar.getRatingValue(), true);
        }
        if (kk.contains(Integer.valueOf(51))) {
            b.a(parcel, 51, knVar.getThumbnailUrl(), true);
        }
        if (kk.contains(Integer.valueOf(50))) {
            b.a(parcel, 50, knVar.kz(), i, true);
        }
        if (kk.contains(Integer.valueOf(49))) {
            b.a(parcel, 49, knVar.getText(), true);
        }
        if (kk.contains(Integer.valueOf(48))) {
            b.a(parcel, 48, knVar.getStreetAddress(), true);
        }
        if (kk.contains(Integer.valueOf(55))) {
            b.a(parcel, 55, knVar.getWidth(), true);
        }
        if (kk.contains(Integer.valueOf(54))) {
            b.a(parcel, 54, knVar.getUrl(), true);
        }
        if (kk.contains(Integer.valueOf(53))) {
            b.a(parcel, 53, knVar.getType(), true);
        }
        if (kk.contains(Integer.valueOf(52))) {
            b.a(parcel, 52, knVar.getTickerSymbol(), true);
        }
        if (kk.contains(Integer.valueOf(56))) {
            b.a(parcel, 56, knVar.getWorstRating(), true);
        }
        b.G(parcel, C);
    }

    /* renamed from: bE */
    public kn createFromParcel(Parcel parcel) {
        int B = a.B(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        kn knVar = null;
        List list = null;
        kn knVar2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        List list2 = null;
        int i2 = 0;
        List list3 = null;
        kn knVar3 = null;
        List list4 = null;
        String str4 = null;
        String str5 = null;
        kn knVar4 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        List list5 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        String str15 = null;
        String str16 = null;
        String str17 = null;
        kn knVar5 = null;
        String str18 = null;
        String str19 = null;
        String str20 = null;
        String str21 = null;
        kn knVar6 = null;
        double d = 0.0d;
        kn knVar7 = null;
        double d2 = 0.0d;
        String str22 = null;
        kn knVar8 = null;
        List list6 = null;
        String str23 = null;
        String str24 = null;
        String str25 = null;
        String str26 = null;
        kn knVar9 = null;
        String str27 = null;
        String str28 = null;
        String str29 = null;
        kn knVar10 = null;
        String str30 = null;
        String str31 = null;
        String str32 = null;
        String str33 = null;
        String str34 = null;
        String str35 = null;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            kn knVar11;
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    knVar11 = (kn) a.a(parcel, A, kn.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    knVar = knVar11;
                    break;
                case 3:
                    list = a.B(parcel, A);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    knVar11 = (kn) a.a(parcel, A, kn.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    knVar2 = knVar11;
                    break;
                case 5:
                    str = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str2 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    str3 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case 8:
                    list2 = a.c(parcel, A, kn.CREATOR);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    i2 = a.g(parcel, A);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 10:
                    list3 = a.c(parcel, A, kn.CREATOR);
                    hashSet.add(Integer.valueOf(10));
                    break;
                case 11:
                    knVar11 = (kn) a.a(parcel, A, kn.CREATOR);
                    hashSet.add(Integer.valueOf(11));
                    knVar3 = knVar11;
                    break;
                case 12:
                    list4 = a.c(parcel, A, kn.CREATOR);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case 13:
                    str4 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(13));
                    break;
                case 14:
                    str5 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case 15:
                    knVar11 = (kn) a.a(parcel, A, (Creator) kn.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    knVar4 = knVar11;
                    break;
                case 16:
                    str6 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case 17:
                    str7 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(17));
                    break;
                case 18:
                    str8 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    list5 = a.c(parcel, A, kn.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    break;
                case MMException.DISPLAY_AD_NOT_READY /*20*/:
                    str9 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case MMException.DISPLAY_AD_EXPIRED /*21*/:
                    str10 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case MMException.DISPLAY_AD_NOT_FOUND /*22*/:
                    str11 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case MMException.DISPLAY_AD_ALREADY_DISPLAYED /*23*/:
                    str12 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case MMException.DISPLAY_AD_NOT_PERMITTED /*24*/:
                    str13 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case MMException.AD_BROKEN_REFERENCE /*25*/:
                    str14 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case MMException.AD_NO_ACTIVITY /*26*/:
                    str15 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case 27:
                    str16 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case 28:
                    str17 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case 29:
                    knVar11 = (kn) a.a(parcel, A, (Creator) kn.CREATOR);
                    hashSet.add(Integer.valueOf(29));
                    knVar5 = knVar11;
                    break;
                case 30:
                    str18 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(30));
                    break;
                case Notifications.NOTIFICATION_TYPES_ALL /*31*/:
                    str19 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(31));
                    break;
                case 32:
                    str20 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(32));
                    break;
                case 33:
                    str21 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(33));
                    break;
                case 34:
                    knVar11 = (kn) a.a(parcel, A, (Creator) kn.CREATOR);
                    hashSet.add(Integer.valueOf(34));
                    knVar6 = knVar11;
                    break;
                case 36:
                    d = a.m(parcel, A);
                    hashSet.add(Integer.valueOf(36));
                    break;
                case 37:
                    knVar11 = (kn) a.a(parcel, A, (Creator) kn.CREATOR);
                    hashSet.add(Integer.valueOf(37));
                    knVar7 = knVar11;
                    break;
                case 38:
                    d2 = a.m(parcel, A);
                    hashSet.add(Integer.valueOf(38));
                    break;
                case 39:
                    str22 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(39));
                    break;
                case 40:
                    knVar11 = (kn) a.a(parcel, A, (Creator) kn.CREATOR);
                    hashSet.add(Integer.valueOf(40));
                    knVar8 = knVar11;
                    break;
                case 41:
                    list6 = a.c(parcel, A, kn.CREATOR);
                    hashSet.add(Integer.valueOf(41));
                    break;
                case 42:
                    str23 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(42));
                    break;
                case 43:
                    str24 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(43));
                    break;
                case 44:
                    str25 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(44));
                    break;
                case 45:
                    str26 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(45));
                    break;
                case 46:
                    knVar11 = (kn) a.a(parcel, A, (Creator) kn.CREATOR);
                    hashSet.add(Integer.valueOf(46));
                    knVar9 = knVar11;
                    break;
                case 47:
                    str27 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(47));
                    break;
                case 48:
                    str28 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(48));
                    break;
                case 49:
                    str29 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(49));
                    break;
                case 50:
                    knVar11 = (kn) a.a(parcel, A, (Creator) kn.CREATOR);
                    hashSet.add(Integer.valueOf(50));
                    knVar10 = knVar11;
                    break;
                case 51:
                    str30 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(51));
                    break;
                case 52:
                    str31 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(52));
                    break;
                case 53:
                    str32 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(53));
                    break;
                case 54:
                    str33 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(54));
                    break;
                case 55:
                    str34 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(55));
                    break;
                case 56:
                    str35 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(56));
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new kn(hashSet, i, knVar, list, knVar2, str, str2, str3, list2, i2, list3, knVar3, list4, str4, str5, knVar4, str6, str7, str8, list5, str9, str10, str11, str12, str13, str14, str15, str16, str17, knVar5, str18, str19, str20, str21, knVar6, d, knVar7, d2, str22, knVar8, list6, str23, str24, str25, str26, knVar9, str27, str28, str29, knVar10, str30, str31, str32, str33, str34, str35);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: db */
    public kn[] newArray(int i) {
        return new kn[i];
    }
}
