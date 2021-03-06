// Generated by data binding compiler. Do not edit!
package com.noida.authority.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.noida.authority.R;
import com.noida.authority.activity.KyaCommunicationInfo;
import com.noida.authority.body_model.PropertyResponse;
import com.noida.authority.pojo.KyaCommunication;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityKyaCommunicationInfoBinding extends ViewDataBinding {
  @NonNull
  public final EditText addressLine1;

  @NonNull
  public final EditText areaLocality;

  @NonNull
  public final ImageView endCircle;

  @NonNull
  public final ImageView middleCircle;

  @NonNull
  public final EditText pinCode;

  @NonNull
  public final ImageView startCircle;

  @NonNull
  public final EditText state;

  @NonNull
  public final Button submitBtn;

  @Bindable
  protected PropertyResponse mKyaInfo;

  @Bindable
  protected KyaCommunication mKyaCommunication;

  @Bindable
  protected KyaCommunicationInfo.EventHandler mClickHandler;

  protected ActivityKyaCommunicationInfoBinding(Object _bindingComponent, View _root,
      int _localFieldCount, EditText addressLine1, EditText areaLocality, ImageView endCircle,
      ImageView middleCircle, EditText pinCode, ImageView startCircle, EditText state,
      Button submitBtn) {
    super(_bindingComponent, _root, _localFieldCount);
    this.addressLine1 = addressLine1;
    this.areaLocality = areaLocality;
    this.endCircle = endCircle;
    this.middleCircle = middleCircle;
    this.pinCode = pinCode;
    this.startCircle = startCircle;
    this.state = state;
    this.submitBtn = submitBtn;
  }

  public abstract void setKyaInfo(@Nullable PropertyResponse kya_info);

  @Nullable
  public PropertyResponse getKyaInfo() {
    return mKyaInfo;
  }

  public abstract void setKyaCommunication(@Nullable KyaCommunication kya_communication);

  @Nullable
  public KyaCommunication getKyaCommunication() {
    return mKyaCommunication;
  }

  public abstract void setClickHandler(@Nullable KyaCommunicationInfo.EventHandler clickHandler);

  @Nullable
  public KyaCommunicationInfo.EventHandler getClickHandler() {
    return mClickHandler;
  }

  @NonNull
  public static ActivityKyaCommunicationInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_kya_communication_info, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityKyaCommunicationInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityKyaCommunicationInfoBinding>inflateInternal(inflater, R.layout.activity_kya_communication_info, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityKyaCommunicationInfoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_kya_communication_info, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityKyaCommunicationInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityKyaCommunicationInfoBinding>inflateInternal(inflater, R.layout.activity_kya_communication_info, null, false, component);
  }

  public static ActivityKyaCommunicationInfoBinding bind(@NonNull View view) {
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
  public static ActivityKyaCommunicationInfoBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityKyaCommunicationInfoBinding)bind(component, view, R.layout.activity_kya_communication_info);
  }
}
