package lip.com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Contents implements SafeParcelable {
    public static final Creator<Contents> CREATOR = new a();
    final ParcelFileDescriptor Fj;
    String HA;
    boolean HB;
    private boolean HC = false;
    private boolean HD = false;
    private boolean HE = false;
    final int Hy;
    final DriveId Hz;
    private boolean mClosed = false;
    final int ra;
    final int xM;

    Contents(int versionCode, ParcelFileDescriptor parcelFileDescriptor, int requestId, int mode, DriveId driveId, String baseContentHash, boolean validForConflictDetection) {
        this.xM = versionCode;
        this.Fj = parcelFileDescriptor;
        this.ra = requestId;
        this.Hy = mode;
        this.Hz = driveId;
        this.HA = baseContentHash;
        this.HB = validForConflictDetection;
    }

    public void close() {
        this.mClosed = true;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.Hz;
    }

    public InputStream getInputStream() {
        if (this.mClosed) {
            throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
        } else if (this.Hy != DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
        } else if (this.HC) {
            throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
        } else {
            this.HC = true;
            return new FileInputStream(this.Fj.getFileDescriptor());
        }
    }

    public int getMode() {
        return this.Hy;
    }

    public OutputStream getOutputStream() {
        if (this.mClosed) {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        } else if (this.Hy != DriveFile.MODE_WRITE_ONLY) {
            throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
        } else if (this.HD) {
            throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
        } else {
            this.HD = true;
            return new FileOutputStream(this.Fj.getFileDescriptor());
        }
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        if (!this.mClosed) {
            return this.Fj;
        }
        throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }

    public int getRequestId() {
        return this.ra;
    }

    public void writeToParcel(Parcel dest, int flags) {
        a.a(this, dest, flags);
    }
}
