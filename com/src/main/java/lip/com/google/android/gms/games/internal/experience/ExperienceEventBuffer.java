package lip.com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class ExperienceEventBuffer extends DataBuffer<ExperienceEvent> {
    public ExperienceEventBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* renamed from: cn */
    public ExperienceEvent get(int i) {
        return new ExperienceEventRef(this.DG, i);
    }
}
