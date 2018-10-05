package lip.com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hm;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragmentInitParams implements SafeParcelable {
    public static final Creator<WalletFragmentInitParams> CREATOR = new a();
    private int akA;
    private MaskedWalletRequest akm;
    private MaskedWallet akn;
    final int xM;
    private String yQ;

    public final class Builder {
        private Builder() {
        }

        public WalletFragmentInitParams build() {
            boolean z = true;
            boolean z2 = (WalletFragmentInitParams.this.akn != null && WalletFragmentInitParams.this.akm == null) || (WalletFragmentInitParams.this.akn == null && WalletFragmentInitParams.this.akm != null);
            hm.a(z2, "Exactly one of MaskedWallet or MaskedWalletRequest is required");
            if (WalletFragmentInitParams.this.akA < 0) {
                z = false;
            }
            hm.a(z, "masked wallet request code is required and must be non-negative");
            return WalletFragmentInitParams.this;
        }

        public Builder setAccountName(String accountName) {
            WalletFragmentInitParams.this.yQ = accountName;
            return this;
        }

        public Builder setMaskedWallet(MaskedWallet maskedWallet) {
            WalletFragmentInitParams.this.akn = maskedWallet;
            return this;
        }

        public Builder setMaskedWalletRequest(MaskedWalletRequest request) {
            WalletFragmentInitParams.this.akm = request;
            return this;
        }

        public Builder setMaskedWalletRequestCode(int requestCode) {
            WalletFragmentInitParams.this.akA = requestCode;
            return this;
        }
    }

    private WalletFragmentInitParams() {
        this.xM = 1;
        this.akA = -1;
    }

    WalletFragmentInitParams(int versionCode, String accountName, MaskedWalletRequest maskedWalletRequest, int maskedWalletRequestCode, MaskedWallet maskedWallet) {
        this.xM = versionCode;
        this.yQ = accountName;
        this.akm = maskedWalletRequest;
        this.akA = maskedWalletRequestCode;
        this.akn = maskedWallet;
    }

    public static Builder newBuilder() {
        WalletFragmentInitParams walletFragmentInitParams = new WalletFragmentInitParams();
        walletFragmentInitParams.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountName() {
        return this.yQ;
    }

    public MaskedWallet getMaskedWallet() {
        return this.akn;
    }

    public MaskedWalletRequest getMaskedWalletRequest() {
        return this.akm;
    }

    public int getMaskedWalletRequestCode() {
        return this.akA;
    }

    public void writeToParcel(Parcel dest, int flags) {
        a.a(this, dest, flags);
    }
}
