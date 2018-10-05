package lip.com.google.android.gms.games.internal;

import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class LibjingleNativeSocket implements RealTimeSocket {
    private static final String TAG = LibjingleNativeSocket.class.getSimpleName();
    private final ParcelFileDescriptor Fj;
    private final InputStream OW;
    private final OutputStream OX;

    LibjingleNativeSocket(ParcelFileDescriptor parcelFileDescriptor) {
        this.Fj = parcelFileDescriptor;
        this.OW = new AutoCloseInputStream(parcelFileDescriptor);
        this.OX = new AutoCloseOutputStream(parcelFileDescriptor);
    }

    public void close() throws IOException {
        this.Fj.close();
    }

    public InputStream getInputStream() throws IOException {
        return this.OW;
    }

    public OutputStream getOutputStream() throws IOException {
        return this.OX;
    }

    public ParcelFileDescriptor getParcelFileDescriptor() throws IOException {
        return this.Fj;
    }

    public boolean isClosed() {
        try {
            this.OW.available();
            return false;
        } catch (IOException e) {
            return true;
        }
    }
}
