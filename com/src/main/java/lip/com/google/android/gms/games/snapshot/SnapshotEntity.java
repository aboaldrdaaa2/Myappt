package lip.com.google.android.gms.games.snapshot;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hm;
import com.google.android.gms.internal.ik;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

public final class SnapshotEntity implements SafeParcelable, Snapshot {
    public static final SnapshotEntityCreator CREATOR = new SnapshotEntityCreator();
    private static final Object Ue = new Object();
    private Contents HG;
    private final SnapshotMetadataEntity Uf;
    private final int xM;

    SnapshotEntity(int versionCode, SnapshotMetadata metadata, Contents contents) {
        this.xM = versionCode;
        this.Uf = new SnapshotMetadataEntity(metadata);
        this.HG = contents;
    }

    public SnapshotEntity(SnapshotMetadata metadata, Contents contents) {
        this(1, metadata, contents);
    }

    private boolean a(int i, byte[] bArr, int i2, int i3, boolean z) {
        boolean z2;
        hm.b(this.HG, (Object) "Must provide a previously opened Snapshot");
        synchronized (Ue) {
            OutputStream fileOutputStream = new FileOutputStream(this.HG.getParcelFileDescriptor().getFileDescriptor());
            OutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            try {
                FileChannel channel = fileOutputStream.getChannel();
                channel.position((long) i);
                bufferedOutputStream.write(bArr, i2, i3);
                if (z) {
                    channel.truncate((long) bArr.length);
                }
                bufferedOutputStream.flush();
                z2 = true;
            } catch (Throwable e) {
                GamesLog.a("Snapshot", "Failed to write snapshot data", e);
                z2 = false;
            }
        }
        return z2;
    }

    static boolean a(Snapshot snapshot, Object obj) {
        if (!(obj instanceof Snapshot)) {
            return false;
        }
        if (snapshot == obj) {
            return true;
        }
        Snapshot snapshot2 = (Snapshot) obj;
        return hk.equal(snapshot2.getMetadata(), snapshot.getMetadata()) && hk.equal(snapshot2.getContents(), snapshot.getContents());
    }

    static int b(Snapshot snapshot) {
        return hk.hashCode(snapshot.getMetadata(), snapshot.getContents());
    }

    static String c(Snapshot snapshot) {
        return hk.e(snapshot).a("Metadata", snapshot.getMetadata()).a("HasContents", Boolean.valueOf(snapshot.getContents() != null)).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public Snapshot freeze() {
        return this;
    }

    public Contents getContents() {
        return this.HG;
    }

    public SnapshotMetadata getMetadata() {
        return this.Uf;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public int hashCode() {
        return b(this);
    }

    public void iM() {
        this.HG.close();
        this.HG = null;
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean modifyBytes(int dstOffset, byte[] content, int srcOffset, int count) {
        return a(dstOffset, content, srcOffset, content.length, false);
    }

    public byte[] readFully() {
        byte[] a;
        hm.b(this.HG, (Object) "Must provide a previously opened Snapshot");
        synchronized (Ue) {
            InputStream fileInputStream = new FileInputStream(this.HG.getParcelFileDescriptor().getFileDescriptor());
            InputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            try {
                fileInputStream.getChannel().position(0);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            } catch (Throwable e2) {
                GamesLog.a("Snapshot", "Failed to read snapshot data", e2);
            }
            a = ik.a(bufferedInputStream, false);
            fileInputStream.getChannel().position(0);
        }
        return a;
    }

    public String toString() {
        return c(this);
    }

    public boolean writeBytes(byte[] content) {
        return a(0, content, 0, content.length, true);
    }

    public void writeToParcel(Parcel out, int flags) {
        SnapshotEntityCreator.a(this, out, flags);
    }
}
