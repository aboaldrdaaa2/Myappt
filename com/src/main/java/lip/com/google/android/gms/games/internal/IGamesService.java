package lip.com.google.android.gms.games.internal;

import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.internal.multiplayer.ZInvitationCluster;
import com.google.android.gms.games.internal.request.GameRequestCluster;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;

public interface IGamesService extends IInterface {

    public static abstract class Stub extends Binder implements IGamesService {

        private static class Proxy implements IGamesService {
            private IBinder kq;

            Proxy(IBinder remote) {
                this.kq = remote;
            }

            public void E(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(5068, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void F(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(12026, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int a(IGamesCallbacks iGamesCallbacks, byte[] bArr, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.kq.transact(5033, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent a(int i, int i2, boolean z) throws RemoteException {
                int i3 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (z) {
                        i3 = 1;
                    }
                    obtain.writeInt(i3);
                    this.kq.transact(9008, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent a(int i, byte[] bArr, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.kq.transact(10012, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent a(ZInvitationCluster zInvitationCluster, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (zInvitationCluster != null) {
                        obtain.writeInt(1);
                        zInvitationCluster.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.kq.transact(10021, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent a(GameRequestCluster gameRequestCluster, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (gameRequestCluster != null) {
                        obtain.writeInt(1);
                        gameRequestCluster.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.kq.transact(10022, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent a(RoomEntity roomEntity, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (roomEntity != null) {
                        obtain.writeInt(1);
                        roomEntity.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.kq.transact(9011, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent a(String str, boolean z, boolean z2, int i) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    obtain.writeInt(i);
                    this.kq.transact(12001, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent a(int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeIntArray(iArr);
                    this.kq.transact(12030, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent a(ParticipantEntity[] participantEntityArr, String str, String str2, Uri uri, Uri uri2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeTypedArray(participantEntityArr, 0);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (uri2 != null) {
                        obtain.writeInt(1);
                        uri2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(9031, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.kq.transact(8019, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(5005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(Contents contents) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (contents != null) {
                        obtain.writeInt(1);
                        contents.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(12019, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.kq.transact(5002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    this.kq.transact(10016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.kq.transact(10009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, int i, int i2, boolean z, boolean z2) throws RemoteException {
                int i3 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    this.kq.transact(5044, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, int i, int i2, String[] strArr, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStringArray(strArr);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(8004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.kq.transact(5015, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, int i, int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeIntArray(iArr);
                    this.kq.transact(10018, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    this.kq.transact(5058, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.kq.transact(8018, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, Bundle bundle, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.kq.transact(5021, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, IBinder iBinder, int i, String[] strArr, Bundle bundle, boolean z, long j) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeStringArray(strArr);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    this.kq.transact(5030, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, IBinder iBinder, String str, boolean z, long j) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    this.kq.transact(5031, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(5014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.kq.transact(10011, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, String str, int i, int i2, int i3, boolean z) throws RemoteException {
                int i4 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (z) {
                        i4 = 1;
                    }
                    obtain.writeInt(i4);
                    this.kq.transact(5019, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(5025, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.kq.transact(8023, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.kq.transact(5045, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2, boolean z3, boolean z4) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    obtain.writeInt(z3 ? 1 : 0);
                    if (!z4) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.kq.transact(GamesStatusCodes.STATUS_MATCH_ERROR_INACTIVE_MATCH, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, String str, int i, int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeIntArray(iArr);
                    this.kq.transact(10019, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    this.kq.transact(5016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, String str, long j, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    obtain.writeString(str2);
                    this.kq.transact(GamesStatusCodes.STATUS_INVALID_REAL_TIME_ROOM_ID, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(5023, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, String str, SnapshotMetadataChange snapshotMetadataChange, Contents contents) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    if (snapshotMetadataChange != null) {
                        obtain.writeInt(1);
                        snapshotMetadataChange.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (contents != null) {
                        obtain.writeInt(1);
                        contents.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(12007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.kq.transact(5038, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.kq.transact(GamesStatusCodes.STATUS_MILESTONE_CLAIM_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.kq.transact(10010, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
                int i4 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (z) {
                        i4 = 1;
                    }
                    obtain.writeInt(i4);
                    this.kq.transact(5039, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.kq.transact(9028, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, Contents contents) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (snapshotMetadataChange != null) {
                        obtain.writeInt(1);
                        snapshotMetadataChange.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (contents != null) {
                        obtain.writeInt(1);
                        contents.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(12033, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, String str, String str2, int[] iArr, int i, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeIntArray(iArr);
                    obtain.writeInt(i);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.kq.transact(12015, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, String str, String str2, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    this.kq.transact(GamesActivityResultCodes.RESULT_INVALID_ROOM, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, String str, String str2, String[] strArr, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(12028, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(5054, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str2);
                    obtain.writeTypedArray(participantResultArr, 0);
                    this.kq.transact(8007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeTypedArray(participantResultArr, 0);
                    this.kq.transact(8008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, String str, int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeIntArray(iArr);
                    this.kq.transact(8017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, String str, String[] strArr, int i, byte[] bArr, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i2);
                    this.kq.transact(GamesActivityResultCodes.RESULT_LEFT_ROOM, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, boolean z, Bundle bundle) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(5063, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, boolean z, String[] strArr) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    obtain.writeStringArray(strArr);
                    this.kq.transact(12031, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeIntArray(iArr);
                    this.kq.transact(GamesStatusCodes.STATUS_QUEST_NOT_STARTED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, int[] iArr, int i, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeIntArray(iArr);
                    obtain.writeInt(i);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.kq.transact(12010, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeStringArray(strArr);
                    this.kq.transact(GamesActivityResultCodes.RESULT_NETWORK_FAILURE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(IGamesCallbacks iGamesCallbacks, String[] strArr, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeStringArray(strArr);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(12029, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent aR(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.kq.transact(9004, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent aU(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.kq.transact(12034, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String aV(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.kq.transact(5064, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String aW(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.kq.transact(5035, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void aX(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.kq.transact(5050, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int aY(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.kq.transact(5060, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Uri aZ(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.kq.transact(5066, obtain, obtain2, 0);
                    obtain2.readException();
                    Uri uri = obtain2.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return uri;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kq;
            }

            public int b(byte[] bArr, String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.kq.transact(5034, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent b(int i, int i2, boolean z) throws RemoteException {
                int i3 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (z) {
                        i3 = 1;
                    }
                    obtain.writeInt(i3);
                    this.kq.transact(9009, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.kq.transact(8021, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.kq.transact(5017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.kq.transact(5046, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    this.kq.transact(8012, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.kq.transact(8020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(5018, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(IGamesCallbacks iGamesCallbacks, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.kq.transact(12023, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(IGamesCallbacks iGamesCallbacks, String str, int i, int i2, int i3, boolean z) throws RemoteException {
                int i4 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (z) {
                        i4 = 1;
                    }
                    obtain.writeInt(i4);
                    this.kq.transact(5020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(IGamesCallbacks iGamesCallbacks, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(GamesStatusCodes.STATUS_PARTICIPANT_NOT_CONNECTED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.kq.transact(10017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.kq.transact(5501, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(IGamesCallbacks iGamesCallbacks, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(5024, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.kq.transact(5041, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
                int i4 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (z) {
                        i4 = 1;
                    }
                    obtain.writeInt(i4);
                    this.kq.transact(5040, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.kq.transact(12018, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(GamesStatusCodes.STATUS_MATCH_NOT_FOUND, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_STATE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(GamesStatusCodes.STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(IGamesCallbacks iGamesCallbacks, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeStringArray(strArr);
                    this.kq.transact(GamesActivityResultCodes.RESULT_SEND_REQUEST_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.kq.transact(5051, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void ba(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.kq.transact(GamesStatusCodes.STATUS_QUEST_NO_LONGER_AVAILABLE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ParcelFileDescriptor bb(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.kq.transact(9030, obtain, obtain2, 0);
                    obtain2.readException();
                    ParcelFileDescriptor parcelFileDescriptor = obtain2.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return parcelFileDescriptor;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void c(long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.kq.transact(GamesActivityResultCodes.RESULT_APP_MISCONFIGURED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void c(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.kq.transact(5022, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void c(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.kq.transact(5048, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void c(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    this.kq.transact(GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void c(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.kq.transact(GamesActivityResultCodes.RESULT_LICENSE_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void c(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(5032, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void c(IGamesCallbacks iGamesCallbacks, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.kq.transact(12024, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void c(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.kq.transact(9001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void c(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.kq.transact(8011, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void c(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(12003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void c(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_RESULTS, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void c(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(8027, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void c(IGamesCallbacks iGamesCallbacks, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeStringArray(strArr);
                    this.kq.transact(10020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void c(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.kq.transact(8026, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void ch(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeInt(i);
                    this.kq.transact(5036, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void d(long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.kq.transact(12014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void d(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.kq.transact(5026, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void d(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.kq.transact(GamesStatusCodes.STATUS_MULTIPLAYER_DISABLED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void d(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    this.kq.transact(12011, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void d(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.kq.transact(12013, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void d(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(5037, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void d(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.kq.transact(9020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void d(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.kq.transact(8015, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void d(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(GamesStatusCodes.STATUS_MATCH_ERROR_ALREADY_REMATCHED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void d(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(12002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void e(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.kq.transact(5027, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void e(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.kq.transact(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_OPERATION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void e(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(5042, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void e(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.kq.transact(12021, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void e(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.kq.transact(8016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void e(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(12006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void e(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(12032, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle ef() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kq.transact(5004, obtain, obtain2, 0);
                    obtain2.readException();
                    Bundle bundle = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void f(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.kq.transact(5047, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void f(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(5043, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void f(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.kq.transact(12022, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void f(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.kq.transact(12009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void f(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kq.transact(12016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void g(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.kq.transact(5049, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void g(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(5052, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String gZ() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kq.transact(5007, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ParcelFileDescriptor h(Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(GamesStatusCodes.STATUS_MATCH_ERROR_LOCALLY_MODIFIED, obtain, obtain2, 0);
                    obtain2.readException();
                    ParcelFileDescriptor parcelFileDescriptor = obtain2.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return parcelFileDescriptor;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public RoomEntity h(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                RoomEntity roomEntity = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(5053, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        roomEntity = (RoomEntity) RoomEntity.CREATOR.createFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return roomEntity;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void h(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.kq.transact(5056, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public DataHolder hA() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kq.transact(5502, obtain, obtain2, 0);
                    obtain2.readException();
                    DataHolder x = obtain2.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return x;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void hB() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kq.transact(8022, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent hC() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kq.transact(9013, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void hD() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kq.transact(11002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean hE() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kq.transact(12025, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String ha() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kq.transact(5012, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent hd() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kq.transact(9003, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent he() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kq.transact(9005, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent hf() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kq.transact(9006, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent hg() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kq.transact(9007, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent hl() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kq.transact(9010, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent hm() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kq.transact(9012, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int hn() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kq.transact(9019, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String ho() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kq.transact(5003, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int hp() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kq.transact(8024, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent hq() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kq.transact(10015, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int hr() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kq.transact(10013, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int hs() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kq.transact(10023, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int ht() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kq.transact(12035, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int hu() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kq.transact(12036, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void hw() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kq.transact(5006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public DataHolder hy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kq.transact(5013, obtain, obtain2, 0);
                    obtain2.readException();
                    DataHolder x = obtain2.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return x;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean hz() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kq.transact(5067, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void i(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.kq.transact(5062, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void i(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(5061, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.kq.transact(11001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(5057, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void k(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(GamesStatusCodes.STATUS_REAL_TIME_MESSAGE_SEND_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void l(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(8005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void l(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.kq.transact(12017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(8006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.kq.transact(5029, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.kq.transact(5065, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void n(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(8009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void n(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.kq.transact(5028, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void n(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.kq.transact(8025, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void o(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(8010, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void p(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(8014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void p(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.kq.transact(5055, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void q(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.kq.transact(5001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void q(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(9002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void q(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.kq.transact(10014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void r(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.kq.transact(5059, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void r(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(12020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void s(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.kq.transact(8013, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void s(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(12005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void t(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.kq.transact(GamesActivityResultCodes.RESULT_SIGN_IN_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void t(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(12027, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void u(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.kq.transact(12012, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void u(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kq.transact(12008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IGamesService");
        }

        public static IGamesService aj(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGamesService)) ? new Proxy(iBinder) : (IGamesService) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            Contents contents = null;
            boolean z = false;
            String ho;
            DataHolder hy;
            IGamesCallbacks ai;
            int readInt;
            boolean z2;
            String readString;
            int readInt2;
            IBinder readStrongBinder;
            Bundle bundle;
            String[] createStringArray;
            int a;
            String readString2;
            int readInt3;
            int readInt4;
            int readInt5;
            IGamesCallbacks ai2;
            String readString3;
            int i;
            ParcelFileDescriptor h;
            Intent hd;
            switch (code) {
                case 5001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    q(data.readLong());
                    reply.writeNoException();
                    return true;
                case 5002:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5003:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ho = ho();
                    reply.writeNoException();
                    reply.writeString(ho);
                    return true;
                case 5004:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Bundle ef = ef();
                    reply.writeNoException();
                    if (ef != null) {
                        reply.writeInt(1);
                        ef.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 5005:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(data.readStrongBinder(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 5006:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    hw();
                    reply.writeNoException();
                    return true;
                case 5007:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ho = gZ();
                    reply.writeNoException();
                    reply.writeString(ho);
                    return true;
                case 5012:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ho = ha();
                    reply.writeNoException();
                    reply.writeString(ho);
                    return true;
                case 5013:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    hy = hy();
                    reply.writeNoException();
                    if (hy != null) {
                        reply.writeInt(1);
                        hy.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 5014:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 5015:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    readInt = data.readInt();
                    z2 = data.readInt() != 0;
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    a(ai, readInt, z2, z);
                    reply.writeNoException();
                    return true;
                case 5016:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.readLong());
                    reply.writeNoException();
                    return true;
                case 5017:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5018:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 5019:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.readInt(), data.readInt(), data.readInt(), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 5020:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.readInt(), data.readInt(), data.readInt(), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 5021:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 5022:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    c(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5023:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.readStrongBinder(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 5024:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.readStrongBinder(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 5025:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    readString = data.readString();
                    readInt2 = data.readInt();
                    readStrongBinder = data.readStrongBinder();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    a(ai, readString, readInt2, readStrongBinder, bundle);
                    reply.writeNoException();
                    return true;
                case 5026:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    d(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5027:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    e(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5028:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    n(data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 5029:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    m(data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 5030:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    IBinder readStrongBinder2 = data.readStrongBinder();
                    readInt2 = data.readInt();
                    createStringArray = data.createStringArray();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    a(ai, readStrongBinder2, readInt2, createStringArray, bundle, data.readInt() != 0, data.readLong());
                    reply.writeNoException();
                    return true;
                case 5031:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readStrongBinder(), data.readString(), data.readInt() != 0, data.readLong());
                    reply.writeNoException();
                    return true;
                case 5032:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    c(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 5033:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a = a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.createByteArray(), data.readString(), data.readString());
                    reply.writeNoException();
                    reply.writeInt(a);
                    return true;
                case 5034:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a = b(data.createByteArray(), data.readString(), data.createStringArray());
                    reply.writeNoException();
                    reply.writeInt(a);
                    return true;
                case 5035:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ho = aW(data.readString());
                    reply.writeNoException();
                    reply.writeString(ho);
                    return true;
                case 5036:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ch(data.readInt());
                    reply.writeNoException();
                    return true;
                case 5037:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    d(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 5038:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 5039:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    readString = data.readString();
                    readString2 = data.readString();
                    readInt3 = data.readInt();
                    readInt4 = data.readInt();
                    readInt5 = data.readInt();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    a(ai, readString, readString2, readInt3, readInt4, readInt5, z);
                    reply.writeNoException();
                    return true;
                case 5040:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    readString = data.readString();
                    readString2 = data.readString();
                    readInt3 = data.readInt();
                    readInt4 = data.readInt();
                    readInt5 = data.readInt();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    b(ai, readString, readString2, readInt3, readInt4, readInt5, z);
                    reply.writeNoException();
                    return true;
                case 5041:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 5042:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    e(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 5043:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    f(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 5044:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readInt(), data.readInt(), data.readInt() != 0, data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 5045:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.readInt(), data.readInt() != 0, data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 5046:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    readInt = data.readInt();
                    z2 = data.readInt() != 0;
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    b(ai, readInt, z2, z);
                    reply.writeNoException();
                    return true;
                case 5047:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    f(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5048:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    readInt = data.readInt();
                    z2 = data.readInt() != 0;
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    c(ai, readInt, z2, z);
                    reply.writeNoException();
                    return true;
                case 5049:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    g(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5050:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    aX(data.readString());
                    reply.writeNoException();
                    return true;
                case 5051:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(data.readString(), data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 5052:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    g(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 5053:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    RoomEntity h2 = h(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    if (h2 != null) {
                        reply.writeInt(1);
                        h2.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 5054:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    readString3 = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    a(ai2, readString3, z);
                    reply.writeNoException();
                    return true;
                case 5055:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    p(data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 5056:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    h(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5057:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    j(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 5058:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readLong());
                    reply.writeNoException();
                    return true;
                case 5059:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    r(data.readLong());
                    reply.writeNoException();
                    return true;
                case 5060:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a = aY(data.readString());
                    reply.writeNoException();
                    reply.writeInt(a);
                    return true;
                case 5061:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    i(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 5062:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    i(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5063:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    a(ai, z, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 5064:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ho = aV(data.readString());
                    reply.writeNoException();
                    reply.writeString(ho);
                    return true;
                case 5065:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    m(data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 5066:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Uri aZ = aZ(data.readString());
                    reply.writeNoException();
                    if (aZ != null) {
                        reply.writeInt(1);
                        aZ.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 5067:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    z2 = hz();
                    reply.writeNoException();
                    if (z2) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 5068:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    E(z);
                    reply.writeNoException();
                    return true;
                case 5501:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.readInt(), data.readInt() != 0, data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 5502:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    hy = hA();
                    reply.writeNoException();
                    if (hy != null) {
                        reply.writeInt(1);
                        hy.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER /*6001*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    a(ai2, z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE /*6002*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    readString3 = data.readString();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    a(ai2, readString3, readString, z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MULTIPLAYER_DISABLED /*6003*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    readInt = data.readInt();
                    z2 = data.readInt() != 0;
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    d(ai, readInt, z2, z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_OPERATION /*6004*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    readInt = data.readInt();
                    z2 = data.readInt() != 0;
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    e(ai, readInt, z2, z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MATCH_ERROR_INACTIVE_MATCH /*6501*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    readString = data.readString();
                    readInt2 = data.readInt();
                    boolean z3 = data.readInt() != 0;
                    boolean z4 = data.readInt() != 0;
                    boolean z5 = data.readInt() != 0;
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    a(ai, readString, readInt2, z3, z4, z5, z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_STATE /*6502*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    readString3 = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    b(ai2, readString3, z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION /*6503*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    b(ai2, z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_RESULTS /*6504*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    readString3 = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    c(ai2, readString3, z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MATCH_ERROR_ALREADY_REMATCHED /*6505*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    readString3 = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    d(ai2, readString3, z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MATCH_NOT_FOUND /*6506*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    readString3 = data.readString();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    b(ai2, readString3, readString, z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MATCH_ERROR_LOCALLY_MODIFIED /*6507*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    h = h(data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (h != null) {
                        reply.writeInt(1);
                        h.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case GamesStatusCodes.STATUS_REAL_TIME_MESSAGE_SEND_FAILED /*7001*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    k(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_INVALID_REAL_TIME_ROOM_ID /*7002*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.readLong(), data.readString());
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_PARTICIPANT_NOT_CONNECTED /*7003*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    readString = data.readString();
                    readInt2 = data.readInt();
                    readStrongBinder = data.readStrongBinder();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    b(ai, readString, readInt2, readStrongBinder, bundle);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MILESTONE_CLAIM_FAILED /*8001*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.readString(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_QUEST_NO_LONGER_AVAILABLE /*8002*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ba(data.readString());
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_QUEST_NOT_STARTED /*8003*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.createIntArray());
                    reply.writeNoException();
                    return true;
                case 8004:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    readInt = data.readInt();
                    readInt2 = data.readInt();
                    createStringArray = data.createStringArray();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    a(ai, readInt, readInt2, createStringArray, bundle);
                    reply.writeNoException();
                    return true;
                case 8005:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    l(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 8006:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    m(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 8007:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.createByteArray(), data.readString(), (ParticipantResult[]) data.createTypedArray(ParticipantResult.CREATOR));
                    reply.writeNoException();
                    return true;
                case 8008:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.createByteArray(), (ParticipantResult[]) data.createTypedArray(ParticipantResult.CREATOR));
                    reply.writeNoException();
                    return true;
                case 8009:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    n(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 8010:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    o(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 8011:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    c(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 8012:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readLong());
                    reply.writeNoException();
                    return true;
                case 8013:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    s(data.readLong());
                    reply.writeNoException();
                    return true;
                case 8014:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    p(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 8015:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    d(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 8016:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    e(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 8017:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.createIntArray());
                    reply.writeNoException();
                    return true;
                case 8018:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readLong(), data.readString());
                    reply.writeNoException();
                    return true;
                case 8019:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(data.readLong(), data.readString());
                    reply.writeNoException();
                    return true;
                case 8020:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readLong(), data.readString());
                    reply.writeNoException();
                    return true;
                case 8021:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(data.readLong(), data.readString());
                    reply.writeNoException();
                    return true;
                case 8022:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    hB();
                    reply.writeNoException();
                    return true;
                case 8023:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    readString3 = data.readString();
                    readInt = data.readInt();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    a(ai2, readString3, readInt, z);
                    reply.writeNoException();
                    return true;
                case 8024:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a = hp();
                    reply.writeNoException();
                    reply.writeInt(a);
                    return true;
                case 8025:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    n(data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 8026:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    c(data.readString(), data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 8027:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    c(ai2, z);
                    reply.writeNoException();
                    return true;
                case 9001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    c(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.readInt(), data.readInt() != 0, data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 9002:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    q(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 9003:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    hd = hd();
                    reply.writeNoException();
                    if (hd != null) {
                        reply.writeInt(1);
                        hd.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9004:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    hd = aR(data.readString());
                    reply.writeNoException();
                    if (hd != null) {
                        reply.writeInt(1);
                        hd.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9005:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    hd = he();
                    reply.writeNoException();
                    if (hd != null) {
                        reply.writeInt(1);
                        hd.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9006:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    hd = hf();
                    reply.writeNoException();
                    if (hd != null) {
                        reply.writeInt(1);
                        hd.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9007:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    hd = hg();
                    reply.writeNoException();
                    if (hd != null) {
                        reply.writeInt(1);
                        hd.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9008:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    hd = a(data.readInt(), data.readInt(), data.readInt() != 0);
                    reply.writeNoException();
                    if (hd != null) {
                        reply.writeInt(1);
                        hd.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9009:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    hd = b(data.readInt(), data.readInt(), data.readInt() != 0);
                    reply.writeNoException();
                    if (hd != null) {
                        reply.writeInt(1);
                        hd.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9010:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    hd = hl();
                    reply.writeNoException();
                    if (hd != null) {
                        reply.writeInt(1);
                        hd.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9011:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    hd = a(data.readInt() != 0 ? (RoomEntity) RoomEntity.CREATOR.createFromParcel(data) : null, data.readInt());
                    reply.writeNoException();
                    if (hd != null) {
                        reply.writeInt(1);
                        hd.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9012:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    hd = hm();
                    reply.writeNoException();
                    if (hd != null) {
                        reply.writeInt(1);
                        hd.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9013:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    hd = hC();
                    reply.writeNoException();
                    if (hd != null) {
                        reply.writeInt(1);
                        hd.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9019:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a = hn();
                    reply.writeNoException();
                    reply.writeInt(a);
                    return true;
                case 9020:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    d(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.readInt(), data.readInt() != 0, data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 9028:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.readString(), data.readInt(), data.readInt() != 0, data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 9030:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    h = bb(data.readString());
                    reply.writeNoException();
                    if (h != null) {
                        reply.writeInt(1);
                        h.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9031:
                    Uri uri;
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ParticipantEntity[] participantEntityArr = (ParticipantEntity[]) data.createTypedArray(ParticipantEntity.CREATOR);
                    readString = data.readString();
                    readString2 = data.readString();
                    Uri uri2 = data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null;
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    hd = a(participantEntityArr, readString, readString2, uri2, uri);
                    reply.writeNoException();
                    if (hd != null) {
                        reply.writeInt(1);
                        hd.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED /*10001*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    c(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readLong());
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_SIGN_IN_FAILED /*10002*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    t(data.readLong());
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_LICENSE_FAILED /*10003*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    c(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readLong(), data.readString());
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_APP_MISCONFIGURED /*10004*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    c(data.readLong(), data.readString());
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_LEFT_ROOM /*10005*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.createStringArray(), data.readInt(), data.createByteArray(), data.readInt());
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_NETWORK_FAILURE /*10006*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.createStringArray());
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_SEND_REQUEST_FAILED /*10007*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.createStringArray());
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_INVALID_ROOM /*10008*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.readString(), data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 10009:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 10010:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.readString(), data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 10011:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 10012:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    hd = a(data.readInt(), data.createByteArray(), data.readInt(), data.readString());
                    reply.writeNoException();
                    if (hd != null) {
                        reply.writeInt(1);
                        hd.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 10013:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a = hr();
                    reply.writeNoException();
                    reply.writeInt(a);
                    return true;
                case 10014:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    q(data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 10015:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    hd = hq();
                    reply.writeNoException();
                    if (hd != null) {
                        reply.writeInt(1);
                        hd.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 10016:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case 10017:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    readString3 = data.readString();
                    readInt = data.readInt();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    b(ai2, readString3, readInt, z);
                    reply.writeNoException();
                    return true;
                case 10018:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readInt(), data.createIntArray());
                    reply.writeNoException();
                    return true;
                case 10019:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.readInt(), data.createIntArray());
                    reply.writeNoException();
                    return true;
                case 10020:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    c(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 10021:
                    ZInvitationCluster bi;
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    if (data.readInt() != 0) {
                        bi = ZInvitationCluster.CREATOR.createFromParcel(data);
                    }
                    hd = a(bi, data.readString(), data.readString());
                    reply.writeNoException();
                    if (hd != null) {
                        reply.writeInt(1);
                        hd.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 10022:
                    GameRequestCluster bk;
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    if (data.readInt() != 0) {
                        bk = GameRequestCluster.CREATOR.createFromParcel(data);
                    }
                    hd = a(bk, data.readString());
                    reply.writeNoException();
                    if (hd != null) {
                        reply.writeInt(1);
                        hd.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 10023:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a = hs();
                    reply.writeNoException();
                    reply.writeInt(a);
                    return true;
                case 11001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    j(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 11002:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    hD();
                    reply.writeNoException();
                    return true;
                case 12001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    hd = a(data.readString(), data.readInt() != 0, data.readInt() != 0, data.readInt());
                    reply.writeNoException();
                    if (hd != null) {
                        reply.writeInt(1);
                        hd.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 12002:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    d(ai2, z);
                    reply.writeNoException();
                    return true;
                case 12003:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    readString3 = data.readString();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    c(ai2, readString3, readString, z);
                    reply.writeNoException();
                    return true;
                case 12005:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    s(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 12006:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    readString3 = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    e(ai2, readString3, z);
                    reply.writeNoException();
                    return true;
                case 12007:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.readInt() != 0 ? SnapshotMetadataChange.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Contents) Contents.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 12008:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    u(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 12009:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    f(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 12010:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    int[] createIntArray = data.createIntArray();
                    readInt = data.readInt();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    a(ai2, createIntArray, readInt, z);
                    reply.writeNoException();
                    return true;
                case 12011:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    d(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readLong());
                    reply.writeNoException();
                    return true;
                case 12012:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    u(data.readLong());
                    reply.writeNoException();
                    return true;
                case 12013:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    d(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readLong(), data.readString());
                    reply.writeNoException();
                    return true;
                case 12014:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    d(data.readLong(), data.readString());
                    reply.writeNoException();
                    return true;
                case 12015:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.readString(), data.createIntArray(), data.readInt(), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 12016:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    f(ai2, z);
                    reply.writeNoException();
                    return true;
                case 12017:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    l(data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 12018:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.readString(), data.readInt(), data.readInt() != 0, data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 12019:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(data.readInt() != 0 ? (Contents) Contents.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 12020:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    r(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 12021:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    e(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.readInt(), data.readInt() != 0, data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 12022:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    f(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.readInt(), data.readInt() != 0, data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 12023:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 12024:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    c(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 12025:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    z2 = hE();
                    reply.writeNoException();
                    if (z2) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 12026:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    F(z);
                    reply.writeNoException();
                    return true;
                case 12027:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    t(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 12028:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder()), data.readString(), data.readString(), data.createStringArray(), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 12029:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    String[] createStringArray2 = data.createStringArray();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    a(ai2, createStringArray2, z);
                    reply.writeNoException();
                    return true;
                case 12030:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    hd = a(data.createIntArray());
                    reply.writeNoException();
                    if (hd != null) {
                        reply.writeInt(1);
                        hd.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 12031:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    a(ai2, z, data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 12032:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    e(ai2, z);
                    reply.writeNoException();
                    return true;
                case 12033:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ai = com.google.android.gms.games.internal.IGamesCallbacks.Stub.ai(data.readStrongBinder());
                    readString = data.readString();
                    readString2 = data.readString();
                    SnapshotMetadataChange createFromParcel = data.readInt() != 0 ? SnapshotMetadataChange.CREATOR.createFromParcel(data) : null;
                    if (data.readInt() != 0) {
                        contents = (Contents) Contents.CREATOR.createFromParcel(data);
                    }
                    a(ai, readString, readString2, createFromParcel, contents);
                    reply.writeNoException();
                    return true;
                case 12034:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    hd = aU(data.readString());
                    reply.writeNoException();
                    if (hd != null) {
                        reply.writeInt(1);
                        hd.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 12035:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a = ht();
                    reply.writeNoException();
                    reply.writeInt(a);
                    return true;
                case 12036:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a = hu();
                    reply.writeNoException();
                    reply.writeInt(a);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.games.internal.IGamesService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void E(boolean z) throws RemoteException;

    void F(boolean z) throws RemoteException;

    int a(IGamesCallbacks iGamesCallbacks, byte[] bArr, String str, String str2) throws RemoteException;

    Intent a(int i, int i2, boolean z) throws RemoteException;

    Intent a(int i, byte[] bArr, int i2, String str) throws RemoteException;

    Intent a(ZInvitationCluster zInvitationCluster, String str, String str2) throws RemoteException;

    Intent a(GameRequestCluster gameRequestCluster, String str) throws RemoteException;

    Intent a(RoomEntity roomEntity, int i) throws RemoteException;

    Intent a(String str, boolean z, boolean z2, int i) throws RemoteException;

    Intent a(int[] iArr) throws RemoteException;

    Intent a(ParticipantEntity[] participantEntityArr, String str, String str2, Uri uri, Uri uri2) throws RemoteException;

    void a(long j, String str) throws RemoteException;

    void a(IBinder iBinder, Bundle bundle) throws RemoteException;

    void a(Contents contents) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, int i) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, int i, int i2, int i3) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, int i, int i2, boolean z, boolean z2) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, int i, int i2, String[] strArr, Bundle bundle) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, int i, int[] iArr) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, Bundle bundle, int i, int i2) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, IBinder iBinder, int i, String[] strArr, Bundle bundle, boolean z, long j) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, IBinder iBinder, String str, boolean z, long j) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, int i) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, int i, int i2, int i3, boolean z) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2, boolean z3, boolean z4) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, int i, int[] iArr) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, long j) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, long j, String str2) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, IBinder iBinder, Bundle bundle) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, SnapshotMetadataChange snapshotMetadataChange, Contents contents) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, boolean z, boolean z2) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, Contents contents) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, String str2, int[] iArr, int i, boolean z) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, String str2, String[] strArr) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, String str2, String[] strArr, boolean z) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, int[] iArr) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, String[] strArr, int i, byte[] bArr, int i2) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, boolean z, Bundle bundle) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, boolean z, String[] strArr) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, int[] iArr) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, int[] iArr, int i, boolean z) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String[] strArr) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String[] strArr, boolean z) throws RemoteException;

    Intent aR(String str) throws RemoteException;

    Intent aU(String str) throws RemoteException;

    String aV(String str) throws RemoteException;

    String aW(String str) throws RemoteException;

    void aX(String str) throws RemoteException;

    int aY(String str) throws RemoteException;

    Uri aZ(String str) throws RemoteException;

    int b(byte[] bArr, String str, String[] strArr) throws RemoteException;

    Intent b(int i, int i2, boolean z) throws RemoteException;

    void b(long j, String str) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, String str, int i) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, String str, int i, int i2, int i3, boolean z) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, String str, IBinder iBinder, Bundle bundle) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, boolean z, boolean z2) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, String[] strArr) throws RemoteException;

    void b(String str, String str2, int i) throws RemoteException;

    void ba(String str) throws RemoteException;

    ParcelFileDescriptor bb(String str) throws RemoteException;

    void c(long j, String str) throws RemoteException;

    void c(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void c(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException;

    void c(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException;

    void c(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException;

    void c(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void c(IGamesCallbacks iGamesCallbacks, String str, int i) throws RemoteException;

    void c(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException;

    void c(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException;

    void c(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) throws RemoteException;

    void c(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException;

    void c(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    void c(IGamesCallbacks iGamesCallbacks, String[] strArr) throws RemoteException;

    void c(String str, String str2, int i) throws RemoteException;

    void ch(int i) throws RemoteException;

    void d(long j, String str) throws RemoteException;

    void d(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void d(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException;

    void d(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException;

    void d(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException;

    void d(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void d(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException;

    void d(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException;

    void d(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException;

    void d(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    void e(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void e(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException;

    void e(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void e(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException;

    void e(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException;

    void e(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException;

    void e(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    Bundle ef() throws RemoteException;

    void f(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void f(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void f(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException;

    void f(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException;

    void f(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    void g(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void g(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    String gZ() throws RemoteException;

    ParcelFileDescriptor h(Uri uri) throws RemoteException;

    RoomEntity h(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void h(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    DataHolder hA() throws RemoteException;

    void hB() throws RemoteException;

    Intent hC() throws RemoteException;

    void hD() throws RemoteException;

    boolean hE() throws RemoteException;

    String ha() throws RemoteException;

    Intent hd() throws RemoteException;

    Intent he() throws RemoteException;

    Intent hf() throws RemoteException;

    Intent hg() throws RemoteException;

    Intent hl() throws RemoteException;

    Intent hm() throws RemoteException;

    int hn() throws RemoteException;

    String ho() throws RemoteException;

    int hp() throws RemoteException;

    Intent hq() throws RemoteException;

    int hr() throws RemoteException;

    int hs() throws RemoteException;

    int ht() throws RemoteException;

    int hu() throws RemoteException;

    void hw() throws RemoteException;

    DataHolder hy() throws RemoteException;

    boolean hz() throws RemoteException;

    void i(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void i(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void j(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void j(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void k(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void l(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void l(String str, int i) throws RemoteException;

    void m(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void m(String str, int i) throws RemoteException;

    void m(String str, String str2) throws RemoteException;

    void n(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void n(String str, int i) throws RemoteException;

    void n(String str, String str2) throws RemoteException;

    void o(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void p(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void p(String str, int i) throws RemoteException;

    void q(long j) throws RemoteException;

    void q(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void q(String str, int i) throws RemoteException;

    void r(long j) throws RemoteException;

    void r(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void s(long j) throws RemoteException;

    void s(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void t(long j) throws RemoteException;

    void t(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void u(long j) throws RemoteException;

    void u(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;
}
