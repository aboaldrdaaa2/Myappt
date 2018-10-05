package lip.com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hm;
import java.util.Collections;
import java.util.List;

public class ActivityRecognitionResult implements SafeParcelable {
    public static final ActivityRecognitionResultCreator CREATOR = new ActivityRecognitionResultCreator();
    public static final String EXTRA_ACTIVITY_RESULT = "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT";
    List<DetectedActivity> UV;
    long UW;
    long UX;
    private final int xM;

    public ActivityRecognitionResult(int versionCode, List<DetectedActivity> probableActivities, long timeMillis, long elapsedRealtimeMillis) {
        this.xM = 1;
        this.UV = probableActivities;
        this.UW = timeMillis;
        this.UX = elapsedRealtimeMillis;
    }

    public ActivityRecognitionResult(DetectedActivity mostProbableActivity, long time, long elapsedRealtimeMillis) {
        this(Collections.singletonList(mostProbableActivity), time, elapsedRealtimeMillis);
    }

    public ActivityRecognitionResult(List<DetectedActivity> probableActivities, long time, long elapsedRealtimeMillis) {
        boolean z = false;
        boolean z2 = probableActivities != null && probableActivities.size() > 0;
        hm.b(z2, (Object) "Must have at least 1 detected activity");
        if (time > 0 && elapsedRealtimeMillis > 0) {
            z = true;
        }
        hm.b(z, (Object) "Must set times");
        this.xM = 1;
        this.UV = probableActivities;
        this.UW = time;
        this.UX = elapsedRealtimeMillis;
    }

    public static ActivityRecognitionResult extractResult(Intent intent) {
        return !hasResult(intent) ? null : (ActivityRecognitionResult) intent.getExtras().get(EXTRA_ACTIVITY_RESULT);
    }

    public static boolean hasResult(Intent intent) {
        return intent == null ? false : intent.hasExtra(EXTRA_ACTIVITY_RESULT);
    }

    public int describeContents() {
        return 0;
    }

    public int getActivityConfidence(int activityType) {
        for (DetectedActivity detectedActivity : this.UV) {
            if (detectedActivity.getType() == activityType) {
                return detectedActivity.getConfidence();
            }
        }
        return 0;
    }

    public long getElapsedRealtimeMillis() {
        return this.UX;
    }

    public DetectedActivity getMostProbableActivity() {
        return (DetectedActivity) this.UV.get(0);
    }

    public List<DetectedActivity> getProbableActivities() {
        return this.UV;
    }

    public long getTime() {
        return this.UW;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public String toString() {
        return "ActivityRecognitionResult [probableActivities=" + this.UV + ", timeMillis=" + this.UW + ", elapsedRealtimeMillis=" + this.UX + "]";
    }

    public void writeToParcel(Parcel out, int flags) {
        ActivityRecognitionResultCreator.a(this, out, flags);
    }
}
