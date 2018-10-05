package lip.com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.dynamic.c.a;

public final class b extends a {
    private Fragment Mj;

    private b(Fragment fragment) {
        this.Mj = fragment;
    }

    public static b a(Fragment fragment) {
        return fragment != null ? new b(fragment) : null;
    }

    public void c(d dVar) {
        this.Mj.registerForContextMenu((View) e.e(dVar));
    }

    public void d(d dVar) {
        this.Mj.unregisterForContextMenu((View) e.e(dVar));
    }

    public d gI() {
        return e.h(this.Mj.getActivity());
    }

    public c gJ() {
        return a(this.Mj.getParentFragment());
    }

    public d gK() {
        return e.h(this.Mj.getResources());
    }

    public c gL() {
        return a(this.Mj.getTargetFragment());
    }

    public Bundle getArguments() {
        return this.Mj.getArguments();
    }

    public int getId() {
        return this.Mj.getId();
    }

    public boolean getRetainInstance() {
        return this.Mj.getRetainInstance();
    }

    public String getTag() {
        return this.Mj.getTag();
    }

    public int getTargetRequestCode() {
        return this.Mj.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.Mj.getUserVisibleHint();
    }

    public d getView() {
        return e.h(this.Mj.getView());
    }

    public boolean isAdded() {
        return this.Mj.isAdded();
    }

    public boolean isDetached() {
        return this.Mj.isDetached();
    }

    public boolean isHidden() {
        return this.Mj.isHidden();
    }

    public boolean isInLayout() {
        return this.Mj.isInLayout();
    }

    public boolean isRemoving() {
        return this.Mj.isRemoving();
    }

    public boolean isResumed() {
        return this.Mj.isResumed();
    }

    public boolean isVisible() {
        return this.Mj.isVisible();
    }

    public void setHasOptionsMenu(boolean hasMenu) {
        this.Mj.setHasOptionsMenu(hasMenu);
    }

    public void setMenuVisibility(boolean menuVisible) {
        this.Mj.setMenuVisibility(menuVisible);
    }

    public void setRetainInstance(boolean retain) {
        this.Mj.setRetainInstance(retain);
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.Mj.setUserVisibleHint(isVisibleToUser);
    }

    public void startActivity(Intent intent) {
        this.Mj.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        this.Mj.startActivityForResult(intent, requestCode);
    }
}
