package lip.com.google.ads.interactivemedia.v3.api;

/* compiled from: IMASDK */
public class AdError extends Exception {
    private final AdErrorCode a;
    private final AdErrorType b;

    /* compiled from: IMASDK */
    public enum AdErrorCode {
        INTERNAL_ERROR(-1),
        VAST_MALFORMED_RESPONSE(100),
        UNKNOWN_AD_RESPONSE(200),
        VAST_LOAD_TIMEOUT(301),
        VAST_TOO_MANY_REDIRECTS(302),
        VAST_INVALID_URL(303),
        VIDEO_PLAY_ERROR(400),
        VAST_LINEAR_ASSET_MISMATCH(403),
        OVERLAY_AD_PLAYING_FAILED(500),
        OVERLAY_AD_LOADING_FAILED(502),
        VAST_NONLINEAR_ASSET_MISMATCH(503),
        COMPANION_AD_LOADING_FAILED(603),
        UNKNOWN_ERROR(900),
        PLAYLIST_MALFORMED_RESPONSE(1004),
        FAILED_TO_REQUEST_ADS(1005),
        REQUIRED_LISTENERS_NOT_ADDED(1006),
        VAST_ASSET_NOT_FOUND(1007),
        INVALID_ARGUMENTS(1101),
        API_ERROR(1102);
        
        private final int a;

        private AdErrorCode(int errorNumber) {
            this.a = errorNumber;
        }

        static AdErrorCode a(int i) {
            for (AdErrorCode adErrorCode : values()) {
                if (adErrorCode.a == i) {
                    return adErrorCode;
                }
            }
            if (1204 == i) {
                return INTERNAL_ERROR;
            }
            return UNKNOWN_ERROR;
        }

        public final boolean equals(int errorCode) {
            return this.a == errorCode;
        }
    }

    /* compiled from: IMASDK */
    public enum AdErrorType {
        LOAD,
        PLAY
    }

    public AdError(AdErrorType errorType, int errorCode, String detailMessage) {
        this(errorType, AdErrorCode.a(errorCode), detailMessage);
    }

    public AdError(AdErrorType errorType, AdErrorCode errorCode, String detailMessage) {
        super(detailMessage);
        this.b = errorType;
        this.a = errorCode;
    }

    public AdErrorType getErrorType() {
        return this.b;
    }

    public AdErrorCode getErrorCode() {
        return this.a;
    }

    public String getMessage() {
        return super.getMessage();
    }
}
