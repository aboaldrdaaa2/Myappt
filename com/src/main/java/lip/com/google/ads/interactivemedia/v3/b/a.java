package lip.com.google.ads.interactivemedia.v3.b;

import android.view.ViewGroup;
import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
public final class a implements AdDisplayContainer {
    private static int e = 0;
    private VideoAdPlayer a;
    private ViewGroup b;
    private Collection<CompanionAdSlot> c = Collections.emptyList();
    private Map<String, CompanionAdSlot> d = null;

    public final VideoAdPlayer getPlayer() {
        return this.a;
    }

    public final void setPlayer(VideoAdPlayer player) {
        this.a = player;
    }

    public final ViewGroup getAdContainer() {
        return this.b;
    }

    public final void setAdContainer(ViewGroup container) {
        this.b = container;
    }

    public final Collection<CompanionAdSlot> getCompanionSlots() {
        return this.c;
    }

    public final void setCompanionSlots(Collection<CompanionAdSlot> companionSlots) {
        this.c = companionSlots;
    }

    public final Map<String, CompanionAdSlot> a() {
        if (this.d == null) {
            this.d = new HashMap();
            for (CompanionAdSlot companionAdSlot : this.c) {
                Map map = this.d;
                StringBuilder stringBuilder = new StringBuilder("compSlot_");
                int i = e;
                e = i + 1;
                map.put(stringBuilder.append(i).toString(), companionAdSlot);
            }
        }
        return this.d;
    }
}
