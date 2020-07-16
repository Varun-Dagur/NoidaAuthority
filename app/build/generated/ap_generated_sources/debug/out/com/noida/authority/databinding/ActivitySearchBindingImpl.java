package com.noida.authority.databinding;
import com.noida.authority.R;
import com.noida.authority.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivitySearchBindingImpl extends ActivitySearchBinding implements com.noida.authority.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.search_by_group, 4);
        sViewsWithIds.put(R.id.search_reg_id, 5);
        sViewsWithIds.put(R.id.search_property, 6);
        sViewsWithIds.put(R.id.register_container, 7);
        sViewsWithIds.put(R.id.edtRegisterId, 8);
        sViewsWithIds.put(R.id.property_container, 9);
        sViewsWithIds.put(R.id.plot_flat_ed, 10);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback5;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivitySearchBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private ActivitySearchBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Spinner) bindings[2]
            , (android.widget.EditText) bindings[8]
            , (android.widget.EditText) bindings[10]
            , (android.widget.LinearLayout) bindings[9]
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.Button) bindings[3]
            , (android.widget.RadioGroup) bindings[4]
            , (android.widget.RadioButton) bindings[6]
            , (android.widget.RadioButton) bindings[5]
            , (android.widget.Spinner) bindings[1]
            );
        this.blockSpinner.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.search.setTag(null);
        this.sectorSpinner.setTag(null);
        setRootTag(root);
        // listeners
        mCallback5 = new com.noida.authority.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
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
            setClickListener((com.noida.authority.activity.SearchActivity.EventHandler) variable);
        }
        else if (BR.sector_list == variableId) {
            setSectorList((java.util.List) variable);
        }
        else if (BR.activity == variableId) {
            setActivity((com.noida.authority.activity.SearchActivity) variable);
        }
        else if (BR.block_list == variableId) {
            setBlockList((java.util.List) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setClickListener(@Nullable com.noida.authority.activity.SearchActivity.EventHandler ClickListener) {
        this.mClickListener = ClickListener;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.clickListener);
        super.requestRebind();
    }
    public void setSectorList(@Nullable java.util.List SectorList) {
        this.mSectorList = SectorList;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.sector_list);
        super.requestRebind();
    }
    public void setActivity(@Nullable com.noida.authority.activity.SearchActivity Activity) {
        this.mActivity = Activity;
    }
    public void setBlockList(@Nullable java.util.List BlockList) {
        this.mBlockList = BlockList;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
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
        com.noida.authority.activity.SearchActivity.EventHandler clickListener = mClickListener;
        java.util.List<?> sectorList = mSectorList;
        java.util.List<?> blockList = mBlockList;

        if ((dirtyFlags & 0x12L) != 0) {
        }
        if ((dirtyFlags & 0x18L) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x18L) != 0) {
            // api target 1

            androidx.databinding.adapters.AbsSpinnerBindingAdapter.setEntries(this.blockSpinner, blockList);
        }
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            this.search.setOnClickListener(mCallback5);
        }
        if ((dirtyFlags & 0x12L) != 0) {
            // api target 1

            androidx.databinding.adapters.AbsSpinnerBindingAdapter.setEntries(this.sectorSpinner, sectorList);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // clickListener
        com.noida.authority.activity.SearchActivity.EventHandler clickListener = mClickListener;
        // clickListener != null
        boolean clickListenerJavaLangObjectNull = false;



        clickListenerJavaLangObjectNull = (clickListener) != (null);
        if (clickListenerJavaLangObjectNull) {


            clickListener.searchProperty();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): clickListener
        flag 1 (0x2L): sector_list
        flag 2 (0x3L): activity
        flag 3 (0x4L): block_list
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}