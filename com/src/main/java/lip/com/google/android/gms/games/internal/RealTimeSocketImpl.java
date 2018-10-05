package lip.com.google.android.gms.games.internal;

import android.net.LocalSocket;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class RealTimeSocketImpl implements RealTimeSocket {
    private ParcelFileDescriptor Fj;
    private final String Oq;
    private final LocalSocket Pd;

    RealTimeSocketImpl(LocalSocket localSocket, String participantId) {
        this.Pd = localSocket;
        this.Oq = participantId;
    }

    public void close() throws IOException {
        this.Pd.close();
    }

    public InputStream getInputStream() throws IOException {
        return this.Pd.getInputStream();
    }

    public OutputStream getOutputStream() throws IOException {
        return this.Pd.getOutputStream();
    }

    public ParcelFileDescriptor getParcelFileDescriptor() throws IOException {
        if (this.Fj == null && !isClosed()) {
            Parcel obtain = Parcel.obtain();
            obtain.writeFileDescriptor(this.Pd.getFileDescriptor());
            obtain.setDataPosition(0);
            this.Fj = obtain.readFileDescriptor();
        }
        return this.Fj;
    }

    public boolean isClosed() {
        return (this.Pd.isConnected() || this.Pd.isBound()) ? false : true;
    }
}
