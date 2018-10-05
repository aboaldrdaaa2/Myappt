package lip.com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CloseContentsAndUpdateMetadataRequest implements SafeParcelable {
    public static final Creator<CloseContentsAndUpdateMetadataRequest> CREATOR = new e();
    final DriveId Iu;
    final MetadataBundle Iv;
    final Contents Iw;
    final boolean Ix;
    final String Iy;
    final int xM;

    CloseContentsAndUpdateMetadataRequest(int versionCode, DriveId id, MetadataBundle metadataChangeSet, Contents contentsReference, boolean shouldDetectConflicts, String operationTag) {
        this.xM = versionCode;
        this.Iu = id;
        this.Iv = metadataChangeSet;
        this.Iw = contentsReference;
        this.Ix = shouldDetectConflicts;
        this.Iy = operationTag;
    }

    public CloseContentsAndUpdateMetadataRequest(DriveId id, MetadataBundle metadataChangeSet, Contents contentsReference, boolean shouldDetectConflicts, String operationTag) {
        this(1, id, metadataChangeSet, contentsReference, shouldDetectConflicts, operationTag);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        e.a(this, dest, flags);
    }
}
