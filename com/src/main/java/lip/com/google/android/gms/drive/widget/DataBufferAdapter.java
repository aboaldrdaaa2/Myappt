package lip.com.google.android.gms.drive.widget;

import android.content.Context;
import android.database.CursorIndexOutOfBoundsException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.gms.common.data.DataBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DataBufferAdapter<T> extends BaseAdapter {
    private final int LR;
    private int LS;
    private final int LT;
    private final List<DataBuffer<T>> LU;
    private final LayoutInflater LV;
    private boolean LW;
    private final Context mContext;

    public DataBufferAdapter(Context context, int resource) {
        this(context, resource, 0, new ArrayList());
    }

    public DataBufferAdapter(Context context, int resource, int textViewResourceId) {
        this(context, resource, textViewResourceId, new ArrayList());
    }

    public DataBufferAdapter(Context context, int resource, int textViewResourceId, List<DataBuffer<T>> objects) {
        this.LW = true;
        this.mContext = context;
        this.LS = resource;
        this.LR = resource;
        this.LT = textViewResourceId;
        this.LU = objects;
        this.LV = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public DataBufferAdapter(Context context, int resource, int textViewResourceId, DataBuffer<T>... buffers) {
        this(context, resource, textViewResourceId, Arrays.asList(buffers));
    }

    public DataBufferAdapter(Context context, int resource, List<DataBuffer<T>> objects) {
        this(context, resource, 0, (List) objects);
    }

    public DataBufferAdapter(Context context, int resource, DataBuffer<T>... buffers) {
        this(context, resource, 0, Arrays.asList(buffers));
    }

    private View a(int i, View view, ViewGroup viewGroup, int i2) {
        View inflate = view == null ? this.LV.inflate(i2, viewGroup, false) : view;
        try {
            TextView textView = this.LT == 0 ? (TextView) inflate : (TextView) inflate.findViewById(this.LT);
            Object item = getItem(i);
            if (item instanceof CharSequence) {
                textView.setText((CharSequence) item);
            } else {
                textView.setText(item.toString());
            }
            return inflate;
        } catch (Throwable e) {
            Log.e("DataBufferAdapter", "You must supply a resource ID for a TextView");
            throw new IllegalStateException("DataBufferAdapter requires the resource ID to be a TextView", e);
        }
    }

    public void append(DataBuffer<T> buffer) {
        this.LU.add(buffer);
        if (this.LW) {
            notifyDataSetChanged();
        }
    }

    public void clear() {
        for (DataBuffer close : this.LU) {
            close.close();
        }
        this.LU.clear();
        if (this.LW) {
            notifyDataSetChanged();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getCount() {
        int i = 0;
        Iterator it = this.LU.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = ((DataBuffer) it.next()).getCount() + i2;
        }
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return a(position, convertView, parent, this.LS);
    }

    public T getItem(int position) throws CursorIndexOutOfBoundsException {
        int i = position;
        for (DataBuffer dataBuffer : this.LU) {
            int count = dataBuffer.getCount();
            if (count <= i) {
                i -= count;
            } else {
                try {
                    return dataBuffer.get(i);
                } catch (CursorIndexOutOfBoundsException e) {
                    throw new CursorIndexOutOfBoundsException(position, getCount());
                }
            }
        }
        throw new CursorIndexOutOfBoundsException(position, getCount());
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        return a(position, convertView, parent, this.LR);
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.LW = true;
    }

    public void setDropDownViewResource(int resource) {
        this.LS = resource;
    }

    public void setNotifyOnChange(boolean notifyOnChange) {
        this.LW = notifyOnChange;
    }
}
