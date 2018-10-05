package lip.com.google.android.gms.common.annotation;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IGooglePlayServicesRocks extends IInterface {

    public static abstract class Stub extends Binder implements IGooglePlayServicesRocks {

        private static class a implements IGooglePlayServicesRocks {
            private IBinder kq;

            a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public IBinder asBinder() {
                return this.kq;
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.common.annotation.IGooglePlayServicesRocks");
        }

        public static IGooglePlayServicesRocks asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface queryLocalInterface = obj.queryLocalInterface("com.google.android.gms.common.annotation.IGooglePlayServicesRocks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGooglePlayServicesRocks)) ? new a(obj) : (IGooglePlayServicesRocks) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1598968902:
                    reply.writeString("com.google.android.gms.common.annotation.IGooglePlayServicesRocks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }
}
