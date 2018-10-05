package lip.com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveFile;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class a implements SafeParcelable {
    public static final Creator<a> CREATOR = new b();
    final int AT;
    ParcelFileDescriptor Ew;
    private Bitmap Ex;
    private boolean Ey;
    private File Ez;
    final int xM;

    a(int i, ParcelFileDescriptor parcelFileDescriptor, int i2) {
        this.xM = i;
        this.Ew = parcelFileDescriptor;
        this.AT = i2;
        this.Ex = null;
        this.Ey = false;
    }

    public a(Bitmap bitmap) {
        this.xM = 1;
        this.Ew = null;
        this.AT = 0;
        this.Ex = bitmap;
        this.Ey = true;
    }

    private void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (Throwable e) {
            Log.w("BitmapTeleporter", "Could not close stream", e);
        }
    }

    private FileOutputStream eT() {
        if (this.Ez == null) {
            throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
        }
        try {
            File createTempFile = File.createTempFile("teleporter", ".tmp", this.Ez);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                this.Ew = ParcelFileDescriptor.open(createTempFile, DriveFile.MODE_READ_ONLY);
                createTempFile.delete();
                return fileOutputStream;
            } catch (FileNotFoundException e) {
                throw new IllegalStateException("Temporary file is somehow already deleted");
            }
        } catch (Throwable e2) {
            throw new IllegalStateException("Could not create temporary file", e2);
        }
    }

    public void a(File file) {
        if (file == null) {
            throw new NullPointerException("Cannot set null temp directory");
        }
        this.Ez = file;
    }

    public int describeContents() {
        return 0;
    }

    public Bitmap eS() {
        if (!this.Ey) {
            Closeable dataInputStream = new DataInputStream(new AutoCloseInputStream(this.Ew));
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                int readInt = dataInputStream.readInt();
                int readInt2 = dataInputStream.readInt();
                Config valueOf = Config.valueOf(dataInputStream.readUTF());
                dataInputStream.read(bArr);
                a(dataInputStream);
                Buffer wrap = ByteBuffer.wrap(bArr);
                Bitmap createBitmap = Bitmap.createBitmap(readInt, readInt2, valueOf);
                createBitmap.copyPixelsFromBuffer(wrap);
                this.Ex = createBitmap;
                this.Ey = true;
            } catch (Throwable e) {
                throw new IllegalStateException("Could not read from parcel file descriptor", e);
            } catch (Throwable th) {
                a(dataInputStream);
            }
        }
        return this.Ex;
    }

    public void writeToParcel(Parcel dest, int flags) {
        if (this.Ew == null) {
            Bitmap bitmap = this.Ex;
            Buffer allocate = ByteBuffer.allocate(bitmap.getRowBytes() * bitmap.getHeight());
            bitmap.copyPixelsToBuffer(allocate);
            byte[] array = allocate.array();
            Closeable dataOutputStream = new DataOutputStream(eT());
            try {
                dataOutputStream.writeInt(array.length);
                dataOutputStream.writeInt(bitmap.getWidth());
                dataOutputStream.writeInt(bitmap.getHeight());
                dataOutputStream.writeUTF(bitmap.getConfig().toString());
                dataOutputStream.write(array);
                a(dataOutputStream);
            } catch (Throwable e) {
                throw new IllegalStateException("Could not write into unlinked file", e);
            } catch (Throwable th) {
                a(dataOutputStream);
            }
        }
        b.a(this, dest, flags);
    }
}
