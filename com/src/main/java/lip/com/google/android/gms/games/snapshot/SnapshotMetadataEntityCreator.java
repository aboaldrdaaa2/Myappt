package lip.com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;

public class SnapshotMetadataEntityCreator implements Creator<SnapshotMetadataEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(SnapshotMetadataEntity snapshotMetadataEntity, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.a(parcel, 1, snapshotMetadataEntity.getGame(), i, false);
        b.c(parcel, 1000, snapshotMetadataEntity.getVersionCode());
        b.a(parcel, 2, snapshotMetadataEntity.getOwner(), i, false);
        b.a(parcel, 3, snapshotMetadataEntity.getSnapshotId(), false);
        b.a(parcel, 5, snapshotMetadataEntity.getCoverImageUri(), i, false);
        b.a(parcel, 6, snapshotMetadataEntity.getCoverImageUrl(), false);
        b.a(parcel, 7, snapshotMetadataEntity.getTitle(), false);
        b.a(parcel, 8, snapshotMetadataEntity.getDescription(), false);
        b.a(parcel, 9, snapshotMetadataEntity.getLastModifiedTimestamp());
        b.a(parcel, 10, snapshotMetadataEntity.getPlayedTime());
        b.a(parcel, 11, snapshotMetadataEntity.getCoverImageAspectRatio());
        b.a(parcel, 12, snapshotMetadataEntity.getUniqueName(), false);
        b.G(parcel, C);
    }

    public SnapshotMetadataEntity createFromParcel(Parcel parcel) {
        int B = a.B(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        PlayerEntity playerEntity = null;
        String str = null;
        Uri uri = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j = 0;
        long j2 = 0;
        float f = 0.0f;
        String str5 = null;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    gameEntity = (GameEntity) a.a(parcel, A, GameEntity.CREATOR);
                    break;
                case 2:
                    playerEntity = (PlayerEntity) a.a(parcel, A, PlayerEntity.CREATOR);
                    break;
                case 3:
                    str = a.o(parcel, A);
                    break;
                case 5:
                    uri = (Uri) a.a(parcel, A, Uri.CREATOR);
                    break;
                case 6:
                    str2 = a.o(parcel, A);
                    break;
                case 7:
                    str3 = a.o(parcel, A);
                    break;
                case 8:
                    str4 = a.o(parcel, A);
                    break;
                case 9:
                    j = a.i(parcel, A);
                    break;
                case 10:
                    j2 = a.i(parcel, A);
                    break;
                case 11:
                    f = a.l(parcel, A);
                    break;
                case 12:
                    str5 = a.o(parcel, A);
                    break;
                case 1000:
                    i = a.g(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new SnapshotMetadataEntity(i, gameEntity, playerEntity, str, uri, str2, str3, str4, j, j2, f, str5);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    public SnapshotMetadataEntity[] newArray(int size) {
        return new SnapshotMetadataEntity[size];
    }
}
