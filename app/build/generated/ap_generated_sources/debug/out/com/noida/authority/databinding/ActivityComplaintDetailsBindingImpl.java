package com.noida.authority.databinding;
import com.noida.authority.R;
import com.noida.authority.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityComplaintDetailsBindingImpl extends ActivityComplaintDetailsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.btnRegister, 11);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.TextView mboundView1;
    @NonNull
    private final android.widget.TextView mboundView10;
    @NonNull
    private final android.widget.TextView mboundView2;
    @NonNull
    private final android.widget.TextView mboundView3;
    @NonNull
    private final android.widget.TextView mboundView4;
    @NonNull
    private final android.widget.TextView mboundView5;
    @NonNull
    private final android.widget.TextView mboundView6;
    @NonNull
    private final android.widget.TextView mboundView7;
    @NonNull
    private final android.widget.TextView mboundView8;
    @NonNull
    private final android.widget.TextView mboundView9;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener mboundView1androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of complaint_detail.department
            //         is complaint_detail.setDepartment((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView1);
            // localize variables for thread safety
            // complaint_detail
            com.noida.authority.response_model.ComplaintResponse complaintDetail = mComplaintDetail;
            // complaint_detail != null
            boolean complaintDetailJavaLangObjectNull = false;
            // complaint_detail.department
            java.lang.String complaintDetailDepartment = null;



            complaintDetailJavaLangObjectNull = (complaintDetail) != (null);
            if (complaintDetailJavaLangObjectNull) {




                complaintDetail.setDepartment(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView10androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of complaint_detail.address
            //         is complaint_detail.setAddress((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView10);
            // localize variables for thread safety
            // complaint_detail
            com.noida.authority.response_model.ComplaintResponse complaintDetail = mComplaintDetail;
            // complaint_detail.address
            java.lang.String complaintDetailAddress = null;
            // complaint_detail != null
            boolean complaintDetailJavaLangObjectNull = false;



            complaintDetailJavaLangObjectNull = (complaintDetail) != (null);
            if (complaintDetailJavaLangObjectNull) {




                complaintDetail.setAddress(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView2androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of complaint_detail.service
            //         is complaint_detail.setService((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView2);
            // localize variables for thread safety
            // complaint_detail
            com.noida.authority.response_model.ComplaintResponse complaintDetail = mComplaintDetail;
            // complaint_detail != null
            boolean complaintDetailJavaLangObjectNull = false;
            // complaint_detail.service
            java.lang.String complaintDetailService = null;



            complaintDetailJavaLangObjectNull = (complaintDetail) != (null);
            if (complaintDetailJavaLangObjectNull) {




                complaintDetail.setService(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView3androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of complaint_detail.name
            //         is complaint_detail.setName((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView3);
            // localize variables for thread safety
            // complaint_detail
            com.noida.authority.response_model.ComplaintResponse complaintDetail = mComplaintDetail;
            // complaint_detail != null
            boolean complaintDetailJavaLangObjectNull = false;
            // complaint_detail.name
            java.lang.String complaintDetailName = null;



            complaintDetailJavaLangObjectNull = (complaintDetail) != (null);
            if (complaintDetailJavaLangObjectNull) {




                complaintDetail.setName(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView4androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of complaint_detail.mobile
            //         is complaint_detail.setMobile((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView4);
            // localize variables for thread safety
            // complaint_detail
            com.noida.authority.response_model.ComplaintResponse complaintDetail = mComplaintDetail;
            // complaint_detail.mobile
            java.lang.String complaintDetailMobile = null;
            // complaint_detail != null
            boolean complaintDetailJavaLangObjectNull = false;



            complaintDetailJavaLangObjectNull = (complaintDetail) != (null);
            if (complaintDetailJavaLangObjectNull) {




                complaintDetail.setMobile(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView5androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of complaint_detail.email
            //         is complaint_detail.setEmail((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView5);
            // localize variables for thread safety
            // complaint_detail
            com.noida.authority.response_model.ComplaintResponse complaintDetail = mComplaintDetail;
            // complaint_detail.email
            java.lang.String complaintDetailEmail = null;
            // complaint_detail != null
            boolean complaintDetailJavaLangObjectNull = false;



            complaintDetailJavaLangObjectNull = (complaintDetail) != (null);
            if (complaintDetailJavaLangObjectNull) {




                complaintDetail.setEmail(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView6androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of complaint_detail.address
            //         is complaint_detail.setAddress((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView6);
            // localize variables for thread safety
            // complaint_detail
            com.noida.authority.response_model.ComplaintResponse complaintDetail = mComplaintDetail;
            // complaint_detail.address
            java.lang.String complaintDetailAddress = null;
            // complaint_detail != null
            boolean complaintDetailJavaLangObjectNull = false;



            complaintDetailJavaLangObjectNull = (complaintDetail) != (null);
            if (complaintDetailJavaLangObjectNull) {




                complaintDetail.setAddress(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView7androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of complaint_detail.sector
            //         is complaint_detail.setSector((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView7);
            // localize variables for thread safety
            // complaint_detail.sector
            java.lang.String complaintDetailSector = null;
            // complaint_detail
            com.noida.authority.response_model.ComplaintResponse complaintDetail = mComplaintDetail;
            // complaint_detail != null
            boolean complaintDetailJavaLangObjectNull = false;



            complaintDetailJavaLangObjectNull = (complaintDetail) != (null);
            if (complaintDetailJavaLangObjectNull) {




                complaintDetail.setSector(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView8androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of complaint_detail.village
            //         is complaint_detail.setVillage((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView8);
            // localize variables for thread safety
            // complaint_detail
            com.noida.authority.response_model.ComplaintResponse complaintDetail = mComplaintDetail;
            // complaint_detail.village
            java.lang.String complaintDetailVillage = null;
            // complaint_detail != null
            boolean complaintDetailJavaLangObjectNull = false;



            complaintDetailJavaLangObjectNull = (complaintDetail) != (null);
            if (complaintDetailJavaLangObjectNull) {




                complaintDetail.setVillage(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView9androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of complaint_detail.plotNo
            //         is complaint_detail.setPlotNo((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView9);
            // localize variables for thread safety
            // complaint_detail
            com.noida.authority.response_model.ComplaintResponse complaintDetail = mComplaintDetail;
            // complaint_detail.plotNo
            java.lang.String complaintDetailPlotNo = null;
            // complaint_detail != null
            boolean complaintDetailJavaLangObjectNull = false;



            complaintDetailJavaLangObjectNull = (complaintDetail) != (null);
            if (complaintDetailJavaLangObjectNull) {




                complaintDetail.setPlotNo(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public ActivityComplaintDetailsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private ActivityComplaintDetailsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[11]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.TextView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView10 = (android.widget.TextView) bindings[10];
        this.mboundView10.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.TextView) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.TextView) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (android.widget.TextView) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (android.widget.TextView) bindings[6];
        this.mboundView6.setTag(null);
        this.mboundView7 = (android.widget.TextView) bindings[7];
        this.mboundView7.setTag(null);
        this.mboundView8 = (android.widget.TextView) bindings[8];
        this.mboundView8.setTag(null);
        this.mboundView9 = (android.widget.TextView) bindings[9];
        this.mboundView9.setTag(null);
        setRootTag(root);
        // listeners
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
        if (BR.clickHandler == variableId) {
            setClickHandler((com.noida.authority.activity.ComplaintDetailsActivity.EventHandler) variable);
        }
        else if (BR.complaint_detail == variableId) {
            setComplaintDetail((com.noida.authority.response_model.ComplaintResponse) variable);
        }
        else if (BR.activity == variableId) {
            setActivity((com.noida.authority.activity.ComplaintDetailsActivity) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setClickHandler(@Nullable com.noida.authority.activity.ComplaintDetailsActivity.EventHandler ClickHandler) {
        this.mClickHandler = ClickHandler;
    }
    public void setComplaintDetail(@Nullable com.noida.authority.response_model.ComplaintResponse ComplaintDetail) {
        this.mComplaintDetail = ComplaintDetail;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.complaint_detail);
        super.requestRebind();
    }
    public void setActivity(@Nullable com.noida.authority.activity.ComplaintDetailsActivity Activity) {
        this.mActivity = Activity;
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
        java.lang.String complaintDetailMobile = null;
        java.lang.String complaintDetailVillage = null;
        java.lang.String complaintDetailEmail = null;
        java.lang.String complaintDetailPlotNo = null;
        java.lang.String complaintDetailService = null;
        java.lang.String complaintDetailName = null;
        java.lang.String complaintDetailSector = null;
        com.noida.authority.response_model.ComplaintResponse complaintDetail = mComplaintDetail;
        java.lang.String complaintDetailDepartment = null;
        java.lang.String complaintDetailAddress = null;

        if ((dirtyFlags & 0xaL) != 0) {



                if (complaintDetail != null) {
                    // read complaint_detail.mobile
                    complaintDetailMobile = complaintDetail.getMobile();
                    // read complaint_detail.village
                    complaintDetailVillage = complaintDetail.getVillage();
                    // read complaint_detail.email
                    complaintDetailEmail = complaintDetail.getEmail();
                    // read complaint_detail.plotNo
                    complaintDetailPlotNo = complaintDetail.getPlotNo();
                    // read complaint_detail.service
                    complaintDetailService = complaintDetail.getService();
                    // read complaint_detail.name
                    complaintDetailName = complaintDetail.getName();
                    // read complaint_detail.sector
                    complaintDetailSector = complaintDetail.getSector();
                    // read complaint_detail.department
                    complaintDetailDepartment = complaintDetail.getDepartment();
                    // read complaint_detail.address
                    complaintDetailAddress = complaintDetail.getAddress();
                }
        }
        // batch finished
        if ((dirtyFlags & 0xaL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, complaintDetailDepartment);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView10, complaintDetailAddress);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, complaintDetailService);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, complaintDetailName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, complaintDetailMobile);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView5, complaintDetailEmail);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView6, complaintDetailAddress);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView7, complaintDetailSector);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView8, complaintDetailVillage);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView9, complaintDetailPlotNo);
        }
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView1, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView1androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView10, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView10androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView2, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView2androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView3, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView3androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView4, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView4androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView5, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView5androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView6, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView6androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView7, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView7androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView8, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView8androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView9, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView9androidTextAttrChanged);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): clickHandler
        flag 1 (0x2L): complaint_detail
        flag 2 (0x3L): activity
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}