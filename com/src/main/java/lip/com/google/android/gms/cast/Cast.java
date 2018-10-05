package lip.com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.LaunchOptions.Builder;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.internal.gh;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hm;
import java.io.IOException;

public final class Cast {
    public static final Api<CastOptions> API = new Api(yI, yH, new Scope[0]);
    public static final CastApi CastApi = new a();
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 65536;
    public static final int MAX_NAMESPACE_LENGTH = 128;
    static final com.google.android.gms.common.api.Api.c<gh> yH = new com.google.android.gms.common.api.Api.c();
    private static final com.google.android.gms.common.api.Api.b<gh, CastOptions> yI = new com.google.android.gms.common.api.Api.b<gh, CastOptions>() {
        public gh a(Context context, Looper looper, gy gyVar, CastOptions castOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            hm.b((Object) castOptions, (Object) "Setting the API options is required.");
            return new gh(context, looper, castOptions.Aa, (long) castOptions.Ac, castOptions.Ab, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    };

    public interface CastApi {

        public static final class a implements CastApi {
            public ApplicationMetadata getApplicationMetadata(GoogleApiClient client) throws IllegalStateException {
                return ((gh) client.a(Cast.yH)).getApplicationMetadata();
            }

            public String getApplicationStatus(GoogleApiClient client) throws IllegalStateException {
                return ((gh) client.a(Cast.yH)).getApplicationStatus();
            }

            public double getVolume(GoogleApiClient client) throws IllegalStateException {
                return ((gh) client.a(Cast.yH)).eh();
            }

            public boolean isMute(GoogleApiClient client) throws IllegalStateException {
                return ((gh) client.a(Cast.yH)).isMute();
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client) {
                return client.b(new c() {
                    protected void a(gh ghVar) throws RemoteException {
                        try {
                            ghVar.b(null, null, this);
                        } catch (IllegalStateException e) {
                            N(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, final String applicationId) {
                return client.b(new c() {
                    protected void a(gh ghVar) throws RemoteException {
                        try {
                            ghVar.b(applicationId, null, this);
                        } catch (IllegalStateException e) {
                            N(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, final String applicationId, final String sessionId) {
                return client.b(new c() {
                    protected void a(gh ghVar) throws RemoteException {
                        try {
                            ghVar.b(applicationId, sessionId, this);
                        } catch (IllegalStateException e) {
                            N(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, final String applicationId) {
                return client.b(new c() {
                    protected void a(gh ghVar) throws RemoteException {
                        try {
                            ghVar.a(applicationId, false, (d) this);
                        } catch (IllegalStateException e) {
                            N(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, final String applicationId, final LaunchOptions options) {
                return client.b(new c() {
                    protected void a(gh ghVar) throws RemoteException {
                        try {
                            ghVar.a(applicationId, options, (d) this);
                        } catch (IllegalStateException e) {
                            N(2001);
                        }
                    }
                });
            }

            @Deprecated
            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, String applicationId, boolean relaunchIfRunning) {
                return launchApplication(client, applicationId, new Builder().setRelaunchIfRunning(relaunchIfRunning).build());
            }

            public PendingResult<Status> leaveApplication(GoogleApiClient client) {
                return client.b(new b() {
                    protected void a(gh ghVar) throws RemoteException {
                        try {
                            ghVar.d((d) this);
                        } catch (IllegalStateException e) {
                            N(2001);
                        }
                    }
                });
            }

            public void removeMessageReceivedCallbacks(GoogleApiClient client, String namespace) throws IOException, IllegalArgumentException {
                try {
                    ((gh) client.a(Cast.yH)).aj(namespace);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void requestStatus(GoogleApiClient client) throws IOException, IllegalStateException {
                try {
                    ((gh) client.a(Cast.yH)).eg();
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> sendMessage(GoogleApiClient client, final String namespace, final String message) {
                return client.b(new b() {
                    protected void a(gh ghVar) throws RemoteException {
                        try {
                            ghVar.a(namespace, message, (d) this);
                        } catch (IllegalArgumentException e) {
                            N(2001);
                        } catch (IllegalStateException e2) {
                            N(2001);
                        }
                    }
                });
            }

            public void setMessageReceivedCallbacks(GoogleApiClient client, String namespace, MessageReceivedCallback callbacks) throws IOException, IllegalStateException {
                try {
                    ((gh) client.a(Cast.yH)).a(namespace, callbacks);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setMute(GoogleApiClient client, boolean mute) throws IOException, IllegalStateException {
                try {
                    ((gh) client.a(Cast.yH)).y(mute);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setVolume(GoogleApiClient client, double volume) throws IOException, IllegalArgumentException, IllegalStateException {
                try {
                    ((gh) client.a(Cast.yH)).a(volume);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> stopApplication(GoogleApiClient client) {
                return client.b(new b() {
                    protected void a(gh ghVar) throws RemoteException {
                        try {
                            ghVar.a("", (d) this);
                        } catch (IllegalStateException e) {
                            N(2001);
                        }
                    }
                });
            }

            public PendingResult<Status> stopApplication(GoogleApiClient client, final String sessionId) {
                return client.b(new b() {
                    protected void a(gh ghVar) throws RemoteException {
                        if (TextUtils.isEmpty(sessionId)) {
                            c(2001, "IllegalArgument: sessionId cannot be null or empty");
                            return;
                        }
                        try {
                            ghVar.a(sessionId, (d) this);
                        } catch (IllegalStateException e) {
                            N(2001);
                        }
                    }
                });
            }
        }

        ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) throws IllegalStateException;

        String getApplicationStatus(GoogleApiClient googleApiClient) throws IllegalStateException;

        double getVolume(GoogleApiClient googleApiClient) throws IllegalStateException;

        boolean isMute(GoogleApiClient googleApiClient) throws IllegalStateException;

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions);

        @Deprecated
        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z);

        PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient);

        void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) throws IOException, IllegalArgumentException;

        void requestStatus(GoogleApiClient googleApiClient) throws IOException, IllegalStateException;

        PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2);

        void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException;

        void setMute(GoogleApiClient googleApiClient, boolean z) throws IOException, IllegalStateException;

        void setVolume(GoogleApiClient googleApiClient, double d) throws IOException, IllegalArgumentException, IllegalStateException;

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient);

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str);
    }

    public static class Listener {
        public void O(int i) {
        }

        public void onApplicationDisconnected(int statusCode) {
        }

        public void onApplicationStatusChanged() {
        }

        public void onVolumeChanged() {
        }
    }

    public interface MessageReceivedCallback {
        void onMessageReceived(CastDevice castDevice, String str, String str2);
    }

    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata getApplicationMetadata();

        String getApplicationStatus();

        String getSessionId();

        boolean getWasLaunched();
    }

    public static final class CastOptions implements HasOptions {
        final CastDevice Aa;
        final Listener Ab;
        private final int Ac;

        public static final class Builder {
            CastDevice Ad;
            Listener Ae;
            private int Af;

            private Builder(CastDevice castDevice, Listener castListener) {
                hm.b((Object) castDevice, (Object) "CastDevice parameter cannot be null");
                hm.b((Object) castListener, (Object) "CastListener parameter cannot be null");
                this.Ad = castDevice;
                this.Ae = castListener;
                this.Af = 0;
            }

            /* synthetic */ Builder(CastDevice x0, Listener x1, AnonymousClass1 x2) {
                this(x0, x1);
            }

            public CastOptions build() {
                return new CastOptions(this, null);
            }

            public Builder setVerboseLoggingEnabled(boolean enabled) {
                if (enabled) {
                    this.Af |= 1;
                } else {
                    this.Af &= -2;
                }
                return this;
            }
        }

        private CastOptions(Builder builder) {
            this.Aa = builder.Ad;
            this.Ab = builder.Ae;
            this.Ac = builder.Af;
        }

        /* synthetic */ CastOptions(Builder x0, AnonymousClass1 x1) {
            this(x0);
        }

        public static Builder builder(CastDevice castDevice, Listener castListener) {
            return new Builder(castDevice, castListener, null);
        }
    }

    protected static abstract class a<R extends Result> extends com.google.android.gms.common.api.a.b<R, gh> {
        public a() {
            super(Cast.yH);
        }

        public void N(int i) {
            a(c(new Status(i)));
        }

        public void c(int i, String str) {
            a(c(new Status(i, str, null)));
        }
    }

    private static abstract class b extends a<Status> {
        private b() {
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: d */
        public Status c(Status status) {
            return status;
        }
    }

    private static abstract class c extends a<ApplicationConnectionResult> {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: j */
        public ApplicationConnectionResult c(final Status status) {
            return new ApplicationConnectionResult() {
                public ApplicationMetadata getApplicationMetadata() {
                    return null;
                }

                public String getApplicationStatus() {
                    return null;
                }

                public String getSessionId() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public boolean getWasLaunched() {
                    return false;
                }
            };
        }
    }

    private Cast() {
    }
}
