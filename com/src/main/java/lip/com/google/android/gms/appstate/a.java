package lip.com.google.android.gms.appstate;

import com.google.android.gms.internal.hk;

public final class a implements AppState {
    private final int yB;
    private final String yC;
    private final byte[] yD;
    private final boolean yE;
    private final String yF;
    private final byte[] yG;

    public a(AppState appState) {
        this.yB = appState.getKey();
        this.yC = appState.getLocalVersion();
        this.yD = appState.getLocalData();
        this.yE = appState.hasConflict();
        this.yF = appState.getConflictVersion();
        this.yG = appState.getConflictData();
    }

    static int a(AppState appState) {
        return hk.hashCode(Integer.valueOf(appState.getKey()), appState.getLocalVersion(), appState.getLocalData(), Boolean.valueOf(appState.hasConflict()), appState.getConflictVersion(), appState.getConflictData());
    }

    static boolean a(AppState appState, Object obj) {
        if (!(obj instanceof AppState)) {
            return false;
        }
        if (appState == obj) {
            return true;
        }
        AppState appState2 = (AppState) obj;
        return hk.equal(Integer.valueOf(appState2.getKey()), Integer.valueOf(appState.getKey())) && hk.equal(appState2.getLocalVersion(), appState.getLocalVersion()) && hk.equal(appState2.getLocalData(), appState.getLocalData()) && hk.equal(Boolean.valueOf(appState2.hasConflict()), Boolean.valueOf(appState.hasConflict())) && hk.equal(appState2.getConflictVersion(), appState.getConflictVersion()) && hk.equal(appState2.getConflictData(), appState.getConflictData());
    }

    static String b(AppState appState) {
        return hk.e(appState).a("Key", Integer.valueOf(appState.getKey())).a("LocalVersion", appState.getLocalVersion()).a("LocalData", appState.getLocalData()).a("HasConflict", Boolean.valueOf(appState.hasConflict())).a("ConflictVersion", appState.getConflictVersion()).a("ConflictData", appState.getConflictData()).toString();
    }

    /* renamed from: dS */
    public AppState freeze() {
        return this;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public byte[] getConflictData() {
        return this.yG;
    }

    public String getConflictVersion() {
        return this.yF;
    }

    public int getKey() {
        return this.yB;
    }

    public byte[] getLocalData() {
        return this.yD;
    }

    public String getLocalVersion() {
        return this.yC;
    }

    public boolean hasConflict() {
        return this.yE;
    }

    public int hashCode() {
        return a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return b(this);
    }
}
