package lip.com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.google.android.gms.dynamic.c.a;

public final class h extends a {
    private Fragment FV;

    private h(Fragment fragment) {
        this.FV = fragment;
    }

    public static h a(Fragment fragment) {
        return fragment != null ? new h(fragment) : null;
    }

    public void c(d dVar) {
        this.FV.registerForContextMenu((View) e.e(dVar));
    }

    public void d(d dVar) {
        this.FV.unregisterForContextMenu((View) e.e(dVar));
    }

    public d gI() {
        return e.h(this.FV.getActivity());
    }

    public c gJ() {
        return a(this.FV.getParentFragment());
    }

    public d gK() {
        return e.h(this.FV.getResources());
    }

    public c gL() {
        return a(this.FV.getTargetFragment());
    }

    public Bundle getArguments() {
        return this.FV.getArguments();
    }

    public int getId() {
        return this.FV.getId();
    }

    public boolean getRetainInstance() {
        return this.FV.getRetainInstance();
    }

    public String getTag() {
        return this.FV.getTag();
    }

    public int getTargetRequestCode() {
        return this.FV.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.FV.getUserVisibleHint();
    }

    public d getView() {
        return e.h(this.FV.getView());
    }

    public boolean isAdded() {
        return this.FV.isAdded();
    }

    public boolean isDetached() {
        return this.FV.isDetached();
    }

    public boolean isHidden() {
        return this.FV.isHidden();
    }

    public boolean isInLayout() {
        return this.FV.isInLayout();
    }

    public boolean isRemoving() {
        return this.FV.isRemoving();
    }

    public boolean isResumed() {
        return this.FV.isResumed();
    }

    public boolean isVisible() {
        return this.FV.isVisible();
    }

    public void setHasOptionsMenu(boolean hasMenu) {
        this.FV.setHasOptionsMenu(hasMenu);
    }

    public void setMenuVisibility(boolean menuVisible) {
        this.FV.setMenuVisibility(menuVisible);
    }

    public void setRetainInstance(boolean retain) {
        this.FV.setRetainInstance(retain);
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.FV.setUserVisibleHint(isVisibleToUser);
    }

    public void startActivity(Intent intent) {
        this.FV.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        this.FV.startActivityForResult(intent, requestCode);
    }
}
