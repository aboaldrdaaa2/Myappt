package lip.com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public interface MostRecentGameInfo extends Parcelable, Freezable<MostRecentGameInfo> {
    String ip();

    String iq();

    long ir();

    Uri is();

    Uri it();

    Uri iu();
}
