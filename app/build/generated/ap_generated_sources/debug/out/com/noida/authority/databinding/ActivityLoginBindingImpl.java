package com.noida.authority.databinding;
import com.noida.authority.R;
import com.noida.authority.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityLoginBindingImpl extends ActivityLoginBinding implements com.noida.authority.generated.callback.OnClickListener.Listener {

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
    @Nullable
    private final android.view.View.OnClickListener mCallback6;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener mobileNumberandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of login.mobileNumber
            //         is login.setMobileNumber((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mobileNumber);
            // localize variables for thread safety
            // login != null
            boolean loginJavaLangObjectNull = false;
            // login.mobileNumber
            java.lang.String loginMobileNumber = null;
            // login
            com.noida.authority.pojo.Login login = mLogin;



            loginJavaLangObjectNull = (login) != (null);
            if (loginJavaLangObjectNull) {




                login.setMobileNumber(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener passwordandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of login.password
            //         is login.setPassword((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(password);
            // localize variables for thread safety
            // login.password
            java.lang.String loginPassword = null;
            // login != null
            boolean loginJavaLangObjectNull = false;
            // login
            com.noida.authority.pojo.Login login = mLogin;



            loginJavaLangObjectNull = (login) != (null);
            if (loginJavaLangObjectNull) {




                login.setPassword(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public ActivityLoginBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private ActivityLoginBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[3]
            , (android.widget.EditText) bindings[1]
            , (android.widget.EditText) bindings[2]
            );
        this.loginBtn.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mobileNumber.setTag(null);
        this.password.setTag(null);
        setRootTag(root);
        // listeners
        mCallback6 = new com.noida.authority.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
        if (BR.clickListener == variableId) {
            setClickListener((com.noida.authority.activity.LoginActivity.EventHandler) variable);
        }
        else if (BR.activity == variableId) {
            setActivity((com.noida.authority.activity.LoginActivity) variable);
        }
        else if (BR.login == variableId) {
            setLogin((com.noida.authority.pojo.Login) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setClickListener(@Nullable com.noida.authority.activity.LoginActivity.EventHandler ClickListener) {
        this.mClickListener = ClickListener;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.clickListener);
        super.requestRebind();
    }
    public void setActivity(@Nullable com.noida.authority.activity.LoginActivity Activity) {
        this.mActivity = Activity;
    }
    public void setLogin(@Nullable com.noida.authority.pojo.Login Login) {
        this.mLogin = Login;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.login);
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
        java.lang.String loginPassword = null;
        java.lang.String loginMobileNumber = null;
        com.noida.authority.activity.LoginActivity.EventHandler clickListener = mClickListener;
        com.noida.authority.pojo.Login login = mLogin;

        if ((dirtyFlags & 0xcL) != 0) {



                if (login != null) {
                    // read login.password
                    loginPassword = login.getPassword();
                    // read login.mobileNumber
                    loginMobileNumber = login.getMobileNumber();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.loginBtn.setOnClickListener(mCallback6);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mobileNumber, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mobileNumberandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.password, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, passwordandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mobileNumber, loginMobileNumber);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.password, loginPassword);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // clickListener
        com.noida.authority.activity.LoginActivity.EventHandler clickListener = mClickListener;
        // clickListener != null
        boolean clickListenerJavaLangObjectNull = false;



        clickListenerJavaLangObjectNull = (clickListener) != (null);
        if (clickListenerJavaLangObjectNull) {


            clickListener.loginApi();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): clickListener
        flag 1 (0x2L): activity
        flag 2 (0x3L): login
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}