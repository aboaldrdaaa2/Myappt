package lip.com.google.android.gms.games.snapshot;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.Contents;

public interface Snapshot extends Parcelable, Freezable<Snapshot> {
    Contents getContents();

    SnapshotMetadata getMetadata();

    void iM();

    boolean modifyBytes(int i, byte[] bArr, int i2, int i3);

    byte[] readFully();

    boolean writeBytes(byte[] bArr);
}
