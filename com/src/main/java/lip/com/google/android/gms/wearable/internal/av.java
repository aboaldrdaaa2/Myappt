package lip.com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.internal.ac.a;

public class av extends a {
    private final DataListener aml;
    private final MessageListener amm;
    private final NodeListener amn;
    private final IntentFilter[] amo;

    public av(DataListener dataListener, MessageListener messageListener, NodeListener nodeListener, IntentFilter[] intentFilterArr) {
        this.aml = dataListener;
        this.amm = messageListener;
        this.amn = nodeListener;
        this.amo = intentFilterArr;
    }

    public static av a(DataListener dataListener, IntentFilter[] intentFilterArr) {
        return new av(dataListener, null, null, intentFilterArr);
    }

    public static av a(MessageListener messageListener, IntentFilter[] intentFilterArr) {
        return new av(null, messageListener, null, intentFilterArr);
    }

    public static av a(NodeListener nodeListener) {
        return new av(null, null, nodeListener, null);
    }

    public void Y(DataHolder dataHolder) {
        if (this.aml != null) {
            try {
                this.aml.onDataChanged(new DataEventBuffer(dataHolder));
            } finally {
                dataHolder.close();
            }
        } else {
            dataHolder.close();
        }
    }

    public void a(af afVar) {
        if (this.amm != null) {
            this.amm.onMessageReceived(afVar);
        }
    }

    public void a(ai aiVar) {
        if (this.amn != null) {
            this.amn.onPeerConnected(aiVar);
        }
    }

    public void b(ai aiVar) {
        if (this.amn != null) {
            this.amn.onPeerDisconnected(aiVar);
        }
    }

    public IntentFilter[] nu() {
        return this.amo;
    }
}
