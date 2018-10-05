package lip.com.google.ads.interactivemedia.v3.api;

import android.view.ViewGroup;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;
import java.util.Collection;

/* compiled from: IMASDK */
public interface AdDisplayContainer {
    ViewGroup getAdContainer();

    Collection<CompanionAdSlot> getCompanionSlots();

    VideoAdPlayer getPlayer();

    void setAdContainer(ViewGroup viewGroup);

    void setCompanionSlots(Collection<CompanionAdSlot> collection);

    void setPlayer(VideoAdPlayer videoAdPlayer);
}
