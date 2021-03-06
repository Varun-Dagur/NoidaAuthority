// Generated by data binding compiler. Do not edit!
package com.noida.authority.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.noida.authority.R;
import com.noida.authority.activity.SearchActivity;
import java.lang.Deprecated;
import java.lang.Object;
import java.util.List;

public abstract class ActivitySearchBinding extends ViewDataBinding {
  @NonNull
  public final Spinner blockSpinner;

  @NonNull
  public final EditText edtRegisterId;

  @NonNull
  public final EditText plotFlatEd;

  @NonNull
  public final LinearLayout propertyContainer;

  @NonNull
  public final LinearLayout registerContainer;

  @NonNull
  public final Button search;

  @NonNull
  public final RadioGroup searchByGroup;

  @NonNull
  public final RadioButton searchProperty;

  @NonNull
  public final RadioButton searchRegId;

  @NonNull
  public final Spinner sectorSpinner;

  @Bindable
  protected List mBlockList;

  @Bindable
  protected List mSectorList;

  @Bindable
  protected SearchActivity.EventHandler mClickListener;

  @Bindable
  protected SearchActivity mActivity;

  protected ActivitySearchBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Spinner blockSpinner, EditText edtRegisterId, EditText plotFlatEd,
      LinearLayout propertyContainer, LinearLayout registerContainer, Button search,
      RadioGroup searchByGroup, RadioButton searchProperty, RadioButton searchRegId,
      Spinner sectorSpinner) {
    super(_bindingComponent, _root, _localFieldCount);
    this.blockSpinner = blockSpinner;
    this.edtRegisterId = edtRegisterId;
    this.plotFlatEd = plotFlatEd;
    this.propertyContainer = propertyContainer;
    this.registerContainer = registerContainer;
    this.search = search;
    this.searchByGroup = searchByGroup;
    this.searchProperty = searchProperty;
    this.searchRegId = searchRegId;
    this.sectorSpinner = sectorSpinner;
  }

  public abstract void setBlockList(@Nullable List block_list);

  @Nullable
  public List getBlockList() {
    return mBlockList;
  }

  public abstract void setSectorList(@Nullable List sector_list);

  @Nullable
  public List getSectorList() {
    return mSectorList;
  }

  public abstract void setClickListener(@Nullable SearchActivity.EventHandler clickListener);

  @Nullable
  public SearchActivity.EventHandler getClickListener() {
    return mClickListener;
  }

  public abstract void setActivity(@Nullable SearchActivity activity);

  @Nullable
  public SearchActivity getActivity() {
    return mActivity;
  }

  @NonNull
  public static ActivitySearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_search, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivitySearchBinding>inflateInternal(inflater, R.layout.activity_search, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySearchBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_search, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivitySearchBinding>inflateInternal(inflater, R.layout.activity_search, null, false, component);
  }

  public static ActivitySearchBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivitySearchBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivitySearchBinding)bind(component, view, R.layout.activity_search);
  }
}
