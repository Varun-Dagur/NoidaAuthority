package com.noida.authority.databinding;
import com.noida.authority.R;
import com.noida.authority.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityLandingBindingImpl extends ActivityLandingBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rvStatus, 4);
        sViewsWithIds.put(R.id.imgStatus, 5);
        sViewsWithIds.put(R.id.txtStatus, 6);
        sViewsWithIds.put(R.id.imgProduct, 7);
        sViewsWithIds.put(R.id.txtItemName, 8);
        sViewsWithIds.put(R.id.rvStatus1, 9);
        sViewsWithIds.put(R.id.imgStatus1, 10);
        sViewsWithIds.put(R.id.txtStatus1, 11);
        sViewsWithIds.put(R.id.imgProduct1, 12);
        sViewsWithIds.put(R.id.txtItemName1, 13);
        sViewsWithIds.put(R.id.rvStatus2, 14);
        sViewsWithIds.put(R.id.imgStatus2, 15);
        sViewsWithIds.put(R.id.txtStatus2, 16);
        sViewsWithIds.put(R.id.imgProduct2, 17);
        sViewsWithIds.put(R.id.txtItemName2, 18);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final com.google.android.material.card.MaterialCardView mboundView1;
    @NonNull
    private final com.google.android.material.card.MaterialCardView mboundView2;
    @NonNull
    private final android.widget.LinearLayout mboundView3;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mHandlersCallOfficerAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mHandlersCallCustomerAndroidViewViewOnClickListener;
    private OnClickListenerImpl2 mHandlersCallAdminAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public ActivityLandingBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds));
    }
    private ActivityLandingBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[7]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.ImageView) bindings[17]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.RelativeLayout) bindings[4]
            , (android.widget.RelativeLayout) bindings[9]
            , (android.widget.RelativeLayout) bindings[14]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[16]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (com.google.android.material.card.MaterialCardView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (com.google.android.material.card.MaterialCardView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.LinearLayout) bindings[3];
        this.mboundView3.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.handlers == variableId) {
            setHandlers((com.noida.authority.activity.LandingActivity.LandingClickHandlers) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHandlers(@Nullable com.noida.authority.activity.LandingActivity.LandingClickHandlers Handlers) {
        this.mHandlers = Handlers;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.handlers);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        android.view.View.OnClickListener handlersCallOfficerAndroidViewViewOnClickListener = null;
        android.view.View.OnClickListener handlersCallCustomerAndroidViewViewOnClickListener = null;
        android.view.View.OnClickListener handlersCallAdminAndroidViewViewOnClickListener = null;
        com.noida.authority.activity.LandingActivity.LandingClickHandlers handlers = mHandlers;

        if ((dirtyFlags & 0x3L) != 0) {



                if (handlers != null) {
                    // read handlers::callOfficer
                    handlersCallOfficerAndroidViewViewOnClickListener = (((mHandlersCallOfficerAndroidViewViewOnClickListener == null) ? (mHandlersCallOfficerAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mHandlersCallOfficerAndroidViewViewOnClickListener).setValue(handlers));
                    // read handlers::callCustomer
                    handlersCallCustomerAndroidViewViewOnClickListener = (((mHandlersCallCustomerAndroidViewViewOnClickListener == null) ? (mHandlersCallCustomerAndroidViewViewOnClickListener = new OnClickListenerImpl1()) : mHandlersCallCustomerAndroidViewViewOnClickListener).setValue(handlers));
                    // read handlers::callAdmin
                    handlersCallAdminAndroidViewViewOnClickListener = (((mHandlersCallAdminAndroidViewViewOnClickListener == null) ? (mHandlersCallAdminAndroidViewViewOnClickListener = new OnClickListenerImpl2()) : mHandlersCallAdminAndroidViewViewOnClickListener).setValue(handlers));
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            this.mboundView1.setOnClickListener(handlersCallAdminAndroidViewViewOnClickListener);
            this.mboundView2.setOnClickListener(handlersCallOfficerAndroidViewViewOnClickListener);
            this.mboundView3.setOnClickListener(handlersCallCustomerAndroidViewViewOnClickListener);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.noida.authority.activity.LandingActivity.LandingClickHandlers value;
        public OnClickListenerImpl setValue(com.noida.authority.activity.LandingActivity.LandingClickHandlers value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.callOfficer(arg0); 
        }
    }
    public static class OnClickListenerImpl1 implements android.view.View.OnClickListener{
        private com.noida.authority.activity.LandingActivity.LandingClickHandlers value;
        public OnClickListenerImpl1 setValue(com.noida.authority.activity.LandingActivity.LandingClickHandlers value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.callCustomer(arg0); 
        }
    }
    public static class OnClickListenerImpl2 implements android.view.View.OnClickListener{
        private com.noida.authority.activity.LandingActivity.LandingClickHandlers value;
        public OnClickListenerImpl2 setValue(com.noida.authority.activity.LandingActivity.LandingClickHandlers value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.callAdmin(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): handlers
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}