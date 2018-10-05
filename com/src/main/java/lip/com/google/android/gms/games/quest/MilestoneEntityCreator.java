package lip.com.google.android.gms.games.quest;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class MilestoneEntityCreator implements Creator<MilestoneEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(MilestoneEntity milestoneEntity, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.a(parcel, 1, milestoneEntity.getMilestoneId(), false);
        b.c(parcel, 1000, milestoneEntity.getVersionCode());
        b.a(parcel, 2, milestoneEntity.getCurrentProgress());
        b.a(parcel, 3, milestoneEntity.getTargetProgress());
        b.a(parcel, 4, milestoneEntity.getCompletionRewardData(), false);
        b.c(parcel, 5, milestoneEntity.getState());
        b.a(parcel, 6, milestoneEntity.getEventId(), false);
        b.G(parcel, C);
    }

    public MilestoneEntity createFromParcel(Parcel parcel) {
        long j = 0;
        int i = 0;
        String str = null;
        int B = a.B(parcel);
        byte[] bArr = null;
        long j2 = 0;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    str2 = a.o(parcel, A);
                    break;
                case 2:
                    j2 = a.i(parcel, A);
                    break;
                case 3:
                    j = a.i(parcel, A);
                    break;
                case 4:
                    bArr = a.r(parcel, A);
                    break;
                case 5:
                    i = a.g(parcel, A);
                    break;
                case 6:
                    str = a.o(parcel, A);
                    break;
                case 1000:
                    i2 = a.g(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new MilestoneEntity(i2, str2, j2, j, bArr, i, str);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    public MilestoneEntity[] newArray(int size) {
        return new MilestoneEntity[size];
    }
}
