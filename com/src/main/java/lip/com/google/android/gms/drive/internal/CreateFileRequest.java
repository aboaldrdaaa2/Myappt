package lip.com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.hm;

public class CreateFileRequest implements SafeParcelable {
    public static final Creator<CreateFileRequest> CREATOR = new j();
    final MetadataBundle IE;
    final Integer IF;
    final DriveId IG;
    final boolean IH;
    final Contents Iw;
    final String Iy;
    final int xM;

    CreateFileRequest(int versionCode, DriveId parentDriveId, MetadataBundle metadata, Contents contentsReference, Integer fileType, boolean shouldReportConflict, String operationTag) {
        this.xM = versionCode;
        this.IG = (DriveId) hm.f(parentDriveId);
        this.IE = (MetadataBundle) hm.f(metadata);
        if (fileType == null || fileType.intValue() == 0) {
            this.Iw = (Contents) hm.f(contentsReference);
        } else {
            this.Iw = null;
        }
        this.IF = fileType;
        this.IH = shouldReportConflict;
        this.Iy = operationTag;
    }

    public CreateFileRequest(DriveId parentDriveId, MetadataBundle metadata, Contents contentsReference, int fileType, boolean shouldReportConflict, String operationTag) {
        this(2, parentDriveId, metadata, contentsReference, Integer.valueOf(fileType), shouldReportConflict, operationTag);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        j.a(this, dest, flags);
    }
}
