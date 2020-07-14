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
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mHandlersCallOfficerAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mHandlersCallCustomerAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public ActivityLandingBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private ActivityLandingBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[1]
            , (android.widget.Button) bindings[2]
            );
        this.citizen.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.official.setTag(null);
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
        com.noida.authority.activity.LandingActivity.LandingClickHandlers handlers = mHandlers;
        android.view.View.OnClickListener handlersCallOfficerAndroidViewViewOnClickListener = null;
        android.view.View.OnClickListener handlersCallCustomerAndroidViewViewOnClickListener = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (handlers != null) {
                    // read handlers::callOfficer
                    handlersCallOfficerAndroidViewViewOnClickListener = (((mHandlersCallOfficerAndroidViewViewOnClickListener == null) ? (mHandlersCallOfficerAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mHandlersCallOfficerAndroidViewViewOnClickListener).setValue(handlers));
                    // read handlers::callCustomer
                    handlersCallCustomerAndroidViewViewOnClickListener = (((mHandlersCallCustomerAndroidViewViewOnClickListener == null) ? (mHandlersCallCustomerAndroidViewViewOnClickListener = new OnClickListenerImpl1()) : mHandlersCallCustomerAndroidViewViewOnClickListener).setValue(handlers));
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            this.citizen.setOnClickListener(handlersCallCustomerAndroidViewViewOnClickListener);
            this.official.setOnClickListener(handlersCallOfficerAndroidViewViewOnClickListener);
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
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): handlers
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}