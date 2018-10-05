package lip.com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletFragmentOptions implements SafeParcelable {
    public static final Creator<WalletFragmentOptions> CREATOR = new b();
    private int Hy;
    private WalletFragmentStyle akC;
    private int akb;
    private int mTheme;
    final int xM;

    public final class Builder {
        private Builder() {
        }

        public WalletFragmentOptions build() {
            return WalletFragmentOptions.this;
        }

        public Builder setEnvironment(int environment) {
            WalletFragmentOptions.this.akb = environment;
            return this;
        }

        public Builder setFragmentStyle(int styleResourceId) {
            WalletFragmentOptions.this.akC = new WalletFragmentStyle().setStyleResourceId(styleResourceId);
            return this;
        }

        public Builder setFragmentStyle(WalletFragmentStyle fragmentStyle) {
            WalletFragmentOptions.this.akC = fragmentStyle;
            return this;
        }

        public Builder setMode(int mode) {
            WalletFragmentOptions.this.Hy = mode;
            return this;
        }

        public Builder setTheme(int theme) {
            WalletFragmentOptions.this.mTheme = theme;
            return this;
        }
    }

    private WalletFragmentOptions() {
        this.xM = 1;
    }

    WalletFragmentOptions(int versionCode, int environment, int theme, WalletFragmentStyle fragmentStyle, int mode) {
        this.xM = versionCode;
        this.akb = environment;
        this.mTheme = theme;
        this.akC = fragmentStyle;
        this.Hy = mode;
    }

    public static WalletFragmentOptions a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WalletFragmentOptions);
        int i = obtainStyledAttributes.getInt(0, 0);
        int i2 = obtainStyledAttributes.getInt(1, 1);
        int resourceId = obtainStyledAttributes.getResourceId(2, 0);
        int i3 = obtainStyledAttributes.getInt(3, 1);
        obtainStyledAttributes.recycle();
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.mTheme = i;
        walletFragmentOptions.akb = i2;
        walletFragmentOptions.akC = new WalletFragmentStyle().setStyleResourceId(resourceId);
        walletFragmentOptions.akC.Q(context);
        walletFragmentOptions.Hy = i3;
        return walletFragmentOptions;
    }

    public static Builder newBuilder() {
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.getClass();
        return new Builder();
    }

    public void Q(Context context) {
        if (this.akC != null) {
            this.akC.Q(context);
        }
    }

    public int describeContents() {
        return 0;
    }

    public int getEnvironment() {
        return this.akb;
    }

    public WalletFragmentStyle getFragmentStyle() {
        return this.akC;
    }

    public int getMode() {
        return this.Hy;
    }

    public int getTheme() {
        return this.mTheme;
    }

    public void writeToParcel(Parcel dest, int flags) {
        b.a(this, dest, flags);
    }
}
