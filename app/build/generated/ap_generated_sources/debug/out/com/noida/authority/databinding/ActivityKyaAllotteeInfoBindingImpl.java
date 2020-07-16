package com.noida.authority.databinding;
import com.noida.authority.R;
import com.noida.authority.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityKyaAllotteeInfoBindingImpl extends ActivityKyaAllotteeInfoBinding implements com.noida.authority.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.start_circle, 12);
        sViewsWithIds.put(R.id.middle_circle, 13);
        sViewsWithIds.put(R.id.end_circle, 14);
        sViewsWithIds.put(R.id.spinner_gender, 15);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener edtAlloteeAddressandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of kya_info.applicantAddress
            //         is kya_info.setApplicantAddress((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(edtAlloteeAddress);
            // localize variables for thread safety
            // kya_info
            com.noida.authority.body_model.PropertyResponse kyaInfo = mKyaInfo;
            // kya_info.applicantAddress
            java.lang.String kyaInfoApplicantAddress = null;
            // kya_info != null
            boolean kyaInfoJavaLangObjectNull = false;



            kyaInfoJavaLangObjectNull = (kyaInfo) != (null);
            if (kyaInfoJavaLangObjectNull) {




                kyaInfo.setApplicantAddress(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener edtAlloteeNameandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of kya_info.applicant
            //         is kya_info.setApplicant((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(edtAlloteeName);
            // localize variables for thread safety
            // kya_info
            com.noida.authority.body_model.PropertyResponse kyaInfo = mKyaInfo;
            // kya_info.applicant
            java.lang.String kyaInfoApplicant = null;
            // kya_info != null
            boolean kyaInfoJavaLangObjectNull = false;



            kyaInfoJavaLangObjectNull = (kyaInfo) != (null);
            if (kyaInfoJavaLangObjectNull) {




                kyaInfo.setApplicant(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener edtBlockandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of kya_info.blockName
            //         is kya_info.setBlockName((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(edtBlock);
            // localize variables for thread safety
            // kya_info
            com.noida.authority.body_model.PropertyResponse kyaInfo = mKyaInfo;
            // kya_info.blockName
            java.lang.String kyaInfoBlockName = null;
            // kya_info != null
            boolean kyaInfoJavaLangObjectNull = false;



            kyaInfoJavaLangObjectNull = (kyaInfo) != (null);
            if (kyaInfoJavaLangObjectNull) {




                kyaInfo.setBlockName(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener edtDepartmentandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of kya_info.department
            //         is kya_info.setDepartment((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(edtDepartment);
            // localize variables for thread safety
            // kya_info
            com.noida.authority.body_model.PropertyResponse kyaInfo = mKyaInfo;
            // kya_info.department
            java.lang.String kyaInfoDepartment = null;
            // kya_info != null
            boolean kyaInfoJavaLangObjectNull = false;



            kyaInfoJavaLangObjectNull = (kyaInfo) != (null);
            if (kyaInfoJavaLangObjectNull) {




                kyaInfo.setDepartment(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener edtMobileNumberandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of kya_info.mobileNo
            //         is kya_info.setMobileNo((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(edtMobileNumber);
            // localize variables for thread safety
            // kya_info
            com.noida.authority.body_model.PropertyResponse kyaInfo = mKyaInfo;
            // kya_info.mobileNo
            java.lang.String kyaInfoMobileNo = null;
            // kya_info != null
            boolean kyaInfoJavaLangObjectNull = false;



            kyaInfoJavaLangObjectNull = (kyaInfo) != (null);
            if (kyaInfoJavaLangObjectNull) {




                kyaInfo.setMobileNo(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener edtPlotandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of kya_info.plotNo
            //         is kya_info.setPlotNo((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(edtPlot);
            // localize variables for thread safety
            // kya_info
            com.noida.authority.body_model.PropertyResponse kyaInfo = mKyaInfo;
            // kya_info.plotNo
            java.lang.String kyaInfoPlotNo = null;
            // kya_info != null
            boolean kyaInfoJavaLangObjectNull = false;



            kyaInfoJavaLangObjectNull = (kyaInfo) != (null);
            if (kyaInfoJavaLangObjectNull) {




                kyaInfo.setPlotNo(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener edtRegisterIdandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of kya_info.registrationId
            //         is kya_info.setRegistrationId((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(edtRegisterId);
            // localize variables for thread safety
            // kya_info
            com.noida.authority.body_model.PropertyResponse kyaInfo = mKyaInfo;
            // kya_info.registrationId
            java.lang.String kyaInfoRegistrationId = null;
            // kya_info != null
            boolean kyaInfoJavaLangObjectNull = false;



            kyaInfoJavaLangObjectNull = (kyaInfo) != (null);
            if (kyaInfoJavaLangObjectNull) {




                kyaInfo.setRegistrationId(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener edtSectorandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of kya_info.sectorName
            //         is kya_info.setSectorName((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(edtSector);
            // localize variables for thread safety
            // kya_info
            com.noida.authority.body_model.PropertyResponse kyaInfo = mKyaInfo;
            // kya_info != null
            boolean kyaInfoJavaLangObjectNull = false;
            // kya_info.sectorName
            java.lang.String kyaInfoSectorName = null;



            kyaInfoJavaLangObjectNull = (kyaInfo) != (null);
            if (kyaInfoJavaLangObjectNull) {




                kyaInfo.setSectorName(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener emailIdandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of kya_info.emailId
            //         is kya_info.setEmailId((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(emailId);
            // localize variables for thread safety
            // kya_info
            com.noida.authority.body_model.PropertyResponse kyaInfo = mKyaInfo;
            // kya_info.emailId
            java.lang.String kyaInfoEmailId = null;
            // kya_info != null
            boolean kyaInfoJavaLangObjectNull = false;



            kyaInfoJavaLangObjectNull = (kyaInfo) != (null);
            if (kyaInfoJavaLangObjectNull) {




                kyaInfo.setEmailId(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener panNumberandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of kya_info.panNumber
            //         is kya_info.setPanNumber((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(panNumber);
            // localize variables for thread safety
            // kya_info
            com.noida.authority.body_model.PropertyResponse kyaInfo = mKyaInfo;
            // kya_info != null
            boolean kyaInfoJavaLangObjectNull = false;
            // kya_info.panNumber
            java.lang.String kyaInfoPanNumber = null;



            kyaInfoJavaLangObjectNull = (kyaInfo) != (null);
            if (kyaInfoJavaLangObjectNull) {




                kyaInfo.setPanNumber(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public ActivityKyaAllotteeInfoBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }
    private ActivityKyaAllotteeInfoBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[1]
            , (android.widget.EditText) bindings[9]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.Button) bindings[11]
            , (android.widget.EditText) bindings[10]
            , (android.widget.Spinner) bindings[15]
            , (android.widget.ImageView) bindings[12]
            );
        this.edtAlloteeAddress.setTag(null);
        this.edtAlloteeName.setTag(null);
        this.edtBlock.setTag(null);
        this.edtDepartment.setTag(null);
        this.edtMobileNumber.setTag(null);
        this.edtPlot.setTag(null);
        this.edtRegisterId.setTag(null);
        this.edtSector.setTag(null);
        this.emailId.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.nextBtn.setTag(null);
        this.panNumber.setTag(null);
        setRootTag(root);
        // listeners
        mCallback3 = new com.noida.authority.generated.callback.OnClickListener(this, 1);
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
        if (BR.gender == variableId) {
            setGender((com.noida.authority.body_model.PropertyResponse) variable);
        }
        else if (BR.kya_info == variableId) {
            setKyaInfo((com.noida.authority.body_model.PropertyResponse) variable);
        }
        else if (BR.clickHandler == variableId) {
            setClickHandler((com.noida.authority.activity.KyaAllotteeInfo.EventHandler) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setGender(@Nullable com.noida.authority.body_model.PropertyResponse Gender) {
        this.mGender = Gender;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.gender);
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
    public void setClickHandler(@Nullable com.noida.authority.activity.KyaAllotteeInfo.EventHandler ClickHandler) {
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
        java.lang.String kyaInfoDepartment = null;
        java.lang.String kyaInfoBlockName = null;
        java.lang.String kyaInfoPlotNo = null;
        java.lang.String kyaInfoEmailId = null;
        java.lang.String kyaInfoApplicant = null;
        java.lang.String kyaInfoPanNumber = null;
        java.lang.String kyaInfoSectorName = null;
        com.noida.authority.body_model.PropertyResponse gender = mGender;
        com.noida.authority.body_model.PropertyResponse kyaInfo = mKyaInfo;
        java.lang.String kyaInfoMobileNo = null;
        com.noida.authority.activity.KyaAllotteeInfo.EventHandler clickHandler = mClickHandler;
        java.lang.String kyaInfoRegistrationId = null;
        java.lang.String kyaInfoApplicantAddress = null;

        if ((dirtyFlags & 0xaL) != 0) {



                if (kyaInfo != null) {
                    // read kya_info.department
                    kyaInfoDepartment = kyaInfo.getDepartment();
                    // read kya_info.blockName
                    kyaInfoBlockName = kyaInfo.getBlockName();
                    // read kya_info.plotNo
                    kyaInfoPlotNo = kyaInfo.getPlotNo();
                    // read kya_info.emailId
                    kyaInfoEmailId = kyaInfo.getEmailId();
                    // read kya_info.applicant
                    kyaInfoApplicant = kyaInfo.getApplicant();
                    // read kya_info.panNumber
                    kyaInfoPanNumber = kyaInfo.getPanNumber();
                    // read kya_info.sectorName
                    kyaInfoSectorName = kyaInfo.getSectorName();
                    // read kya_info.mobileNo
                    kyaInfoMobileNo = kyaInfo.getMobileNo();
                    // read kya_info.registrationId
                    kyaInfoRegistrationId = kyaInfo.getRegistrationId();
                    // read kya_info.applicantAddress
                    kyaInfoApplicantAddress = kyaInfo.getApplicantAddress();
                }
        }
        // batch finished
        if ((dirtyFlags & 0xaL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.edtAlloteeAddress, kyaInfoApplicantAddress);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.edtAlloteeName, kyaInfoApplicant);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.edtBlock, kyaInfoBlockName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.edtDepartment, kyaInfoDepartment);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.edtMobileNumber, kyaInfoMobileNo);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.edtPlot, kyaInfoPlotNo);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.edtRegisterId, kyaInfoRegistrationId);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.edtSector, kyaInfoSectorName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.emailId, kyaInfoEmailId);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.panNumber, kyaInfoPanNumber);
        }
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.edtAlloteeAddress, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, edtAlloteeAddressandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.edtAlloteeName, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, edtAlloteeNameandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.edtBlock, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, edtBlockandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.edtDepartment, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, edtDepartmentandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.edtMobileNumber, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, edtMobileNumberandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.edtPlot, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, edtPlotandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.edtRegisterId, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, edtRegisterIdandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.edtSector, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, edtSectorandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.emailId, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, emailIdandroidTextAttrChanged);
            this.nextBtn.setOnClickListener(mCallback3);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.panNumber, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, panNumberandroidTextAttrChanged);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // kya_info
        com.noida.authority.body_model.PropertyResponse kyaInfo = mKyaInfo;
        // gender
        com.noida.authority.body_model.PropertyResponse gender = mGender;
        // clickHandler != null
        boolean clickHandlerJavaLangObjectNull = false;
        // clickHandler
        com.noida.authority.activity.KyaAllotteeInfo.EventHandler clickHandler = mClickHandler;
        // gender.gender
        java.lang.String genderGender = null;
        // gender != null
        boolean genderJavaLangObjectNull = false;



        clickHandlerJavaLangObjectNull = (clickHandler) != (null);
        if (clickHandlerJavaLangObjectNull) {




            genderJavaLangObjectNull = (gender) != (null);
            if (genderJavaLangObjectNull) {


                genderGender = gender.getGender();

                clickHandler.allotteInfoNext(kyaInfo, genderGender);
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): gender
        flag 1 (0x2L): kya_info
        flag 2 (0x3L): clickHandler
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}