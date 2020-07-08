package com.noida.authority.databinding;
import com.noida.authority.R;
import com.noida.authority.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityKyaDocumentUploadBindingImpl extends ActivityKyaDocumentUploadBinding implements com.noida.authority.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.start_circle, 2);
        sViewsWithIds.put(R.id.middle_circle, 3);
        sViewsWithIds.put(R.id.end_circle, 4);
        sViewsWithIds.put(R.id.txtIdProof, 5);
        sViewsWithIds.put(R.id.attach_id_proof, 6);
        sViewsWithIds.put(R.id.txtLetter, 7);
        sViewsWithIds.put(R.id.attach_letter, 8);
        sViewsWithIds.put(R.id.txtOtherProof, 9);
        sViewsWithIds.put(R.id.attach_other_proof, 10);
        sViewsWithIds.put(R.id.checkbox, 11);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityKyaDocumentUploadBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private ActivityKyaDocumentUploadBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[6]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.CheckBox) bindings[11]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.Button) bindings[1]
            , (android.widget.EditText) bindings[5]
            , (android.widget.EditText) bindings[7]
            , (android.widget.TextView) bindings[9]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.submitBtn.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.noida.authority.generated.callback.OnClickListener(this, 1);
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
        if (BR.kya_communication == variableId) {
            setKyaCommunication((com.noida.authority.pojo.KyaCommunication) variable);
        }
        else if (BR.kya_info == variableId) {
            setKyaInfo((com.noida.authority.body_model.PropertyResponse) variable);
        }
        else if (BR.Kya_Document == variableId) {
            setKyaDocument((com.noida.authority.pojo.KyaDocument) variable);
        }
        else if (BR.clickHandler == variableId) {
            setClickHandler((com.noida.authority.activity.KyaDocumentUpload.EventHandler) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setKyaCommunication(@Nullable com.noida.authority.pojo.KyaCommunication KyaCommunication) {
        this.mKyaCommunication = KyaCommunication;
    }
    public void setKyaInfo(@Nullable com.noida.authority.body_model.PropertyResponse KyaInfo) {
        this.mKyaInfo = KyaInfo;
    }
    public void setKyaDocument(@Nullable com.noida.authority.pojo.KyaDocument KyaDocument) {
        this.mKyaDocument = KyaDocument;
    }
    public void setClickHandler(@Nullable com.noida.authority.activity.KyaDocumentUpload.EventHandler ClickHandler) {
        this.mClickHandler = ClickHandler;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
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
        com.noida.authority.activity.KyaDocumentUpload.EventHandler clickHandler = mClickHandler;
        // batch finished
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            this.submitBtn.setOnClickListener(mCallback1);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // clickHandler != null
        boolean clickHandlerJavaLangObjectNull = false;
        // clickHandler
        com.noida.authority.activity.KyaDocumentUpload.EventHandler clickHandler = mClickHandler;



        clickHandlerJavaLangObjectNull = (clickHandler) != (null);
        if (clickHandlerJavaLangObjectNull) {


            clickHandler.kyaDocumentUpload();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): kya_communication
        flag 1 (0x2L): kya_info
        flag 2 (0x3L): Kya_Document
        flag 3 (0x4L): clickHandler
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}