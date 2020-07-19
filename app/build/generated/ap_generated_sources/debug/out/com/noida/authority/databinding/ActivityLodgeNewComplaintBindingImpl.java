package com.noida.authority.databinding;
import com.noida.authority.R;
import com.noida.authority.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityLodgeNewComplaintBindingImpl extends ActivityLodgeNewComplaintBinding implements com.noida.authority.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.complainantName, 9);
        sViewsWithIds.put(R.id.complainantMobile, 10);
        sViewsWithIds.put(R.id.complainantEmail, 11);
        sViewsWithIds.put(R.id.complainantAddress, 12);
        sViewsWithIds.put(R.id.complainantIDProof, 13);
        sViewsWithIds.put(R.id.complainantVillage, 14);
        sViewsWithIds.put(R.id.complainantPlot, 15);
        sViewsWithIds.put(R.id.complainantLocation, 16);
        sViewsWithIds.put(R.id.complaintimage1, 17);
        sViewsWithIds.put(R.id.complaintimage2, 18);
        sViewsWithIds.put(R.id.complaintimage3, 19);
        sViewsWithIds.put(R.id.complaintimage4, 20);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener complaintMessageandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of lodge_new_complaint.complaintMessage
            //         is lodge_new_complaint.setComplaintMessage((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(complaintMessage);
            // localize variables for thread safety
            // lodge_new_complaint != null
            boolean lodgeNewComplaintJavaLangObjectNull = false;
            // lodge_new_complaint
            com.noida.authority.pojo.LodgeNewComplaintPojo lodgeNewComplaint = mLodgeNewComplaint;
            // lodge_new_complaint.complaintMessage
            java.lang.String lodgeNewComplaintComplaintMessage = null;



            lodgeNewComplaintJavaLangObjectNull = (lodgeNewComplaint) != (null);
            if (lodgeNewComplaintJavaLangObjectNull) {




                lodgeNewComplaint.setComplaintMessage(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener complaintSubjectandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of lodge_new_complaint.complaintSubject
            //         is lodge_new_complaint.setComplaintSubject((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(complaintSubject);
            // localize variables for thread safety
            // lodge_new_complaint != null
            boolean lodgeNewComplaintJavaLangObjectNull = false;
            // lodge_new_complaint
            com.noida.authority.pojo.LodgeNewComplaintPojo lodgeNewComplaint = mLodgeNewComplaint;
            // lodge_new_complaint.complaintSubject
            java.lang.String lodgeNewComplaintComplaintSubject = null;



            lodgeNewComplaintJavaLangObjectNull = (lodgeNewComplaint) != (null);
            if (lodgeNewComplaintJavaLangObjectNull) {




                lodgeNewComplaint.setComplaintSubject(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public ActivityLodgeNewComplaintBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 21, sIncludes, sViewsWithIds));
    }
    private ActivityLodgeNewComplaintBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Spinner) bindings[7]
            , (android.widget.EditText) bindings[12]
            , (android.widget.EditText) bindings[11]
            , (android.widget.EditText) bindings[13]
            , (android.widget.EditText) bindings[16]
            , (android.widget.EditText) bindings[10]
            , (android.widget.EditText) bindings[9]
            , (android.widget.EditText) bindings[15]
            , (android.widget.EditText) bindings[14]
            , (android.widget.EditText) bindings[5]
            , (android.widget.EditText) bindings[4]
            , (android.widget.EditText) bindings[3]
            , (android.widget.Spinner) bindings[2]
            , (android.widget.ImageView) bindings[17]
            , (android.widget.ImageView) bindings[18]
            , (android.widget.ImageView) bindings[19]
            , (android.widget.ImageView) bindings[20]
            , (android.widget.Spinner) bindings[1]
            , (android.widget.Button) bindings[8]
            , (android.widget.Spinner) bindings[6]
            );
        this.blockSpinner.setTag(null);
        this.complaintLocation.setTag(null);
        this.complaintMessage.setTag(null);
        this.complaintSubject.setTag(null);
        this.complaintTypeSpinner.setTag(null);
        this.departmentSpinner.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.nextBtn.setTag(null);
        this.sectorSpinner.setTag(null);
        setRootTag(root);
        // listeners
        mCallback2 = new com.noida.authority.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x100L;
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
        if (BR.location == variableId) {
            setLocation((java.lang.String) variable);
        }
        else if (BR.lodge_new_complaint == variableId) {
            setLodgeNewComplaint((com.noida.authority.pojo.LodgeNewComplaintPojo) variable);
        }
        else if (BR.department_list == variableId) {
            setDepartmentList((java.util.List) variable);
        }
        else if (BR.service_list == variableId) {
            setServiceList((java.util.List) variable);
        }
        else if (BR.clickListener == variableId) {
            setClickListener((com.noida.authority.activity.LodgeNewComplaint.EventHandler) variable);
        }
        else if (BR.sector_list == variableId) {
            setSectorList((java.util.List) variable);
        }
        else if (BR.activity == variableId) {
            setActivity((com.noida.authority.activity.LodgeNewComplaint) variable);
        }
        else if (BR.block_list == variableId) {
            setBlockList((java.util.List) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setLocation(@Nullable java.lang.String Location) {
        this.mLocation = Location;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.location);
        super.requestRebind();
    }
    public void setLodgeNewComplaint(@Nullable com.noida.authority.pojo.LodgeNewComplaintPojo LodgeNewComplaint) {
        this.mLodgeNewComplaint = LodgeNewComplaint;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.lodge_new_complaint);
        super.requestRebind();
    }
    public void setDepartmentList(@Nullable java.util.List DepartmentList) {
        this.mDepartmentList = DepartmentList;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.department_list);
        super.requestRebind();
    }
    public void setServiceList(@Nullable java.util.List ServiceList) {
        this.mServiceList = ServiceList;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.service_list);
        super.requestRebind();
    }
    public void setClickListener(@Nullable com.noida.authority.activity.LodgeNewComplaint.EventHandler ClickListener) {
        this.mClickListener = ClickListener;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.clickListener);
        super.requestRebind();
    }
    public void setSectorList(@Nullable java.util.List SectorList) {
        this.mSectorList = SectorList;
        synchronized(this) {
            mDirtyFlags |= 0x20L;
        }
        notifyPropertyChanged(BR.sector_list);
        super.requestRebind();
    }
    public void setActivity(@Nullable com.noida.authority.activity.LodgeNewComplaint Activity) {
        this.mActivity = Activity;
    }
    public void setBlockList(@Nullable java.util.List BlockList) {
        this.mBlockList = BlockList;
        synchronized(this) {
            mDirtyFlags |= 0x80L;
        }
        notifyPropertyChanged(BR.block_list);
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
        java.lang.String lodgeNewComplaintComplaintMessage = null;
        java.lang.String location = mLocation;
        com.noida.authority.pojo.LodgeNewComplaintPojo lodgeNewComplaint = mLodgeNewComplaint;
        java.util.List<?> departmentList = mDepartmentList;
        java.util.List<?> serviceList = mServiceList;
        java.lang.String lodgeNewComplaintComplaintSubject = null;
        com.noida.authority.activity.LodgeNewComplaint.EventHandler clickListener = mClickListener;
        java.util.List<?> sectorList = mSectorList;
        java.util.List<?> blockList = mBlockList;

        if ((dirtyFlags & 0x101L) != 0) {
        }
        if ((dirtyFlags & 0x102L) != 0) {



                if (lodgeNewComplaint != null) {
                    // read lodge_new_complaint.complaintMessage
                    lodgeNewComplaintComplaintMessage = lodgeNewComplaint.getComplaintMessage();
                    // read lodge_new_complaint.complaintSubject
                    lodgeNewComplaintComplaintSubject = lodgeNewComplaint.getComplaintSubject();
                }
        }
        if ((dirtyFlags & 0x104L) != 0) {
        }
        if ((dirtyFlags & 0x108L) != 0) {
        }
        if ((dirtyFlags & 0x120L) != 0) {
        }
        if ((dirtyFlags & 0x180L) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x180L) != 0) {
            // api target 1

            androidx.databinding.adapters.AbsSpinnerBindingAdapter.setEntries(this.blockSpinner, blockList);
        }
        if ((dirtyFlags & 0x101L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.complaintLocation, location);
        }
        if ((dirtyFlags & 0x102L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.complaintMessage, lodgeNewComplaintComplaintMessage);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.complaintSubject, lodgeNewComplaintComplaintSubject);
        }
        if ((dirtyFlags & 0x100L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.complaintMessage, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, complaintMessageandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.complaintSubject, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, complaintSubjectandroidTextAttrChanged);
            this.nextBtn.setOnClickListener(mCallback2);
        }
        if ((dirtyFlags & 0x108L) != 0) {
            // api target 1

            androidx.databinding.adapters.AbsSpinnerBindingAdapter.setEntries(this.complaintTypeSpinner, serviceList);
        }
        if ((dirtyFlags & 0x104L) != 0) {
            // api target 1

            androidx.databinding.adapters.AbsSpinnerBindingAdapter.setEntries(this.departmentSpinner, departmentList);
        }
        if ((dirtyFlags & 0x120L) != 0) {
            // api target 1

            androidx.databinding.adapters.AbsSpinnerBindingAdapter.setEntries(this.sectorSpinner, sectorList);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // clickListener
        com.noida.authority.activity.LodgeNewComplaint.EventHandler clickListener = mClickListener;
        // clickListener != null
        boolean clickListenerJavaLangObjectNull = false;



        clickListenerJavaLangObjectNull = (clickListener) != (null);
        if (clickListenerJavaLangObjectNull) {


            clickListener.lodgeNewComplaint();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): location
        flag 1 (0x2L): lodge_new_complaint
        flag 2 (0x3L): department_list
        flag 3 (0x4L): service_list
        flag 4 (0x5L): clickListener
        flag 5 (0x6L): sector_list
        flag 6 (0x7L): activity
        flag 7 (0x8L): block_list
        flag 8 (0x9L): null
    flag mapping end*/
    //end
}