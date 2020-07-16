package com.noida.authority.databinding;
import com.noida.authority.R;
import com.noida.authority.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityKyaCommunicationInfoBindingImpl extends ActivityKyaCommunicationInfoBinding implements com.noida.authority.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.start_circle, 7);
        sViewsWithIds.put(R.id.middle_circle, 8);
        sViewsWithIds.put(R.id.end_circle, 9);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.EditText mboundView2;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback4;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener addressLine1androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of kya_communication.addressline1
            //         is kya_communication.setAddressline1((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(addressLine1);
            // localize variables for thread safety
            // kya_communication.addressline1
            java.lang.String kyaCommunicationAddressline1 = null;
            // kya_communication
            com.noida.authority.pojo.KyaCommunication kyaCommunication = mKyaCommunication;
            // kya_communication != null
            boolean kyaCommunicationJavaLangObjectNull = false;



            kyaCommunicationJavaLangObjectNull = (kyaCommunication) != (null);
            if (kyaCommunicationJavaLangObjectNull) {




                kyaCommunication.setAddressline1(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener areaLocalityandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of kya_communication.area
            //         is kya_communication.setArea((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(areaLocality);
            // localize variables for thread safety
            // kya_communication
            com.noida.authority.pojo.KyaCommunication kyaCommunication = mKyaCommunication;
            // kya_communication.area
            java.lang.String kyaCommunicationArea = null;
            // kya_communication != null
            boolean kyaCommunicationJavaLangObjectNull = false;



            kyaCommunicationJavaLangObjectNull = (kyaCommunication) != (null);
            if (kyaCommunicationJavaLangObjectNull) {




                kyaCommunication.setArea(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView2androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of kya_communication.addressline2
            //         is kya_communication.setAddressline2((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView2);
            // localize variables for thread safety
            // kya_communication.addressline2
            java.lang.String kyaCommunicationAddressline2 = null;
            // kya_communication
            com.noida.authority.pojo.KyaCommunication kyaCommunication = mKyaCommunication;
            // kya_communication != null
            boolean kyaCommunicationJavaLangObjectNull = false;



            kyaCommunicationJavaLangObjectNull = (kyaCommunication) != (null);
            if (kyaCommunicationJavaLangObjectNull) {




                kyaCommunication.setAddressline2(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener pinCodeandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of kya_communication.pincode
            //         is kya_communication.setPincode((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(pinCode);
            // localize variables for thread safety
            // kya_communication
            com.noida.authority.pojo.KyaCommunication kyaCommunication = mKyaCommunication;
            // kya_communication.pincode
            java.lang.String kyaCommunicationPincode = null;
            // kya_communication != null
            boolean kyaCommunicationJavaLangObjectNull = false;



            kyaCommunicationJavaLangObjectNull = (kyaCommunication) != (null);
            if (kyaCommunicationJavaLangObjectNull) {




                kyaCommunication.setPincode(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener stateandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of kya_communication.state
            //         is kya_communication.setState((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(state);
            // localize variables for thread safety
            // kya_communication.state
            java.lang.String kyaCommunicationState = null;
            // kya_communication
            com.noida.authority.pojo.KyaCommunication kyaCommunication = mKyaCommunication;
            // kya_communication != null
            boolean kyaCommunicationJavaLangObjectNull = false;



            kyaCommunicationJavaLangObjectNull = (kyaCommunication) != (null);
            if (kyaCommunicationJavaLangObjectNull) {




                kyaCommunication.setState(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public ActivityKyaCommunicationInfoBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }
    private ActivityKyaCommunicationInfoBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.EditText) bindings[1]
            , (android.widget.EditText) bindings[3]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.EditText) bindings[5]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.EditText) bindings[4]
            , (android.widget.Button) bindings[6]
            );
        this.addressLine1.setTag(null);
        this.areaLocality.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (android.widget.EditText) bindings[2];
        this.mboundView2.setTag(null);
        this.pinCode.setTag(null);
        this.state.setTag(null);
        this.submitBtn.setTag(null);
        setRootTag(root);
        // listeners
        mCallback4 = new com.noida.authority.generated.callback.OnClickListener(this, 1);
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
        if (BR.kya_communication == variableId) {
            setKyaCommunication((com.noida.authority.pojo.KyaCommunication) variable);
        }
        else if (BR.kya_info == variableId) {
            setKyaInfo((com.noida.authority.body_model.PropertyResponse) variable);
        }
        else if (BR.clickHandler == variableId) {
            setClickHandler((com.noida.authority.activity.KyaCommunicationInfo.EventHandler) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setKyaCommunication(@Nullable com.noida.authority.pojo.KyaCommunication KyaCommunication) {
        this.mKyaCommunication = KyaCommunication;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.kya_communication);
        super.requestRebind();
    }
    public void setKyaInfo(@Nullable com.noida.authority.body_model.PropertyResponse KyaInfo) {
        this.mKyaInfo = KyaInfo;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.kya_info);
        super.requestRebind();
    }
    public void setClickHandler(@Nullable com.noida.authority.activity.KyaCommunicationInfo.EventHandler ClickHandler) {
        this.mClickHandler = ClickHandler;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.clickHandler);
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
        com.noida.authority.pojo.KyaCommunication kyaCommunication = mKyaCommunication;
        java.lang.String kyaCommunicationArea = null;
        com.noida.authority.body_model.PropertyResponse kyaInfo = mKyaInfo;
        com.noida.authority.activity.KyaCommunicationInfo.EventHandler clickHandler = mClickHandler;
        java.lang.String kyaCommunicationPincode = null;
        java.lang.String kyaCommunicationAddressline2 = null;
        java.lang.String kyaCommunicationState = null;
        java.lang.String kyaCommunicationAddressline1 = null;

        if ((dirtyFlags & 0x9L) != 0) {



                if (kyaCommunication != null) {
                    // read kya_communication.area
                    kyaCommunicationArea = kyaCommunication.getArea();
                    // read kya_communication.pincode
                    kyaCommunicationPincode = kyaCommunication.getPincode();
                    // read kya_communication.addressline2
                    kyaCommunicationAddressline2 = kyaCommunication.getAddressline2();
                    // read kya_communication.state
                    kyaCommunicationState = kyaCommunication.getState();
                    // read kya_communication.addressline1
                    kyaCommunicationAddressline1 = kyaCommunication.getAddressline1();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x9L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.addressLine1, kyaCommunicationAddressline1);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.areaLocality, kyaCommunicationArea);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, kyaCommunicationAddressline2);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.pinCode, kyaCommunicationPincode);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.state, kyaCommunicationState);
        }
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.addressLine1, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, addressLine1androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.areaLocality, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, areaLocalityandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView2, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView2androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.pinCode, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, pinCodeandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.state, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, stateandroidTextAttrChanged);
            this.submitBtn.setOnClickListener(mCallback4);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // kya_info
        com.noida.authority.body_model.PropertyResponse kyaInfo = mKyaInfo;
        // clickHandler != null
        boolean clickHandlerJavaLangObjectNull = false;
        // kya_communication
        com.noida.authority.pojo.KyaCommunication kyaCommunication = mKyaCommunication;
        // clickHandler
        com.noida.authority.activity.KyaCommunicationInfo.EventHandler clickHandler = mClickHandler;



        clickHandlerJavaLangObjectNull = (clickHandler) != (null);
        if (clickHandlerJavaLangObjectNull) {




            clickHandler.kyaCommunication(kyaCommunication, kyaInfo);
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): kya_communication
        flag 1 (0x2L): kya_info
        flag 2 (0x3L): clickHandler
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}