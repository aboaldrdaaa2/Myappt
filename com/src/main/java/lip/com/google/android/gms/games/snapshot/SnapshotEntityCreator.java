package lip.com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.Contents;

public class SnapshotEntityCreator implements Creator<SnapshotEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(SnapshotEntity snapshotEntity, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.a(parcel, 1, snapshotEntity.getMetadata(), i, false);
        b.c(parcel, 1000, snapshotEntity.getVersionCode());
        b.a(parcel, 2, snapshotEntity.getContents(), i, false);
        b.G(parcel, C);
    }

    public SnapshotEntity createFromParcel(Parcel parcel) {
        Contents contents = null;
        int B = a.B(parcel);
        int i = 0;
        SnapshotMetadata snapshotMetadata = null;
        while (parcel.dataPosition() < B) {
            int i2;
            Contents contents2;
            SnapshotMetadata snapshotMetadata2;
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i2 = i;
                    SnapshotMetadataEntity snapshotMetadataEntity = (SnapshotMetadataEntity) a.a(parcel, A, SnapshotMetadataEntity.CREATOR);
                    contents2 = contents;
                    Object snapshotMetadata22 = snapshotMetadataEntity;
                    break;
                case 2:
                    contents2 = (Contents) a.a(parcel, A, Contents.CREATOR);
                    snapshotMetadata22 = snapshotMetadata;
                    i2 = i;
                    break;
                case 1000:
                    Contents contents3 = contents;
                    snapshotMetadata22 = snapshotMetadata;
                    i2 = a.g(parcel, A);
                    contents2 = contents3;
                    break;
                default:
                    a.b(parcel, A);
                    contents2 = contents;
                    snapshotMetadata22 = snapshotMetadata;
                    i2 = i;
                    break;
            }
            i = i2;
            snapshotMetadata = snapshotMetadata22;
            contents = contents2;
        }
        if (parcel.dataPosition() == B) {
            return new SnapshotEntity(i, snapshotMetadata, contents);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    public SnapshotEntity[] newArray(int size) {
        return new SnapshotEntity[size];
    }
}
