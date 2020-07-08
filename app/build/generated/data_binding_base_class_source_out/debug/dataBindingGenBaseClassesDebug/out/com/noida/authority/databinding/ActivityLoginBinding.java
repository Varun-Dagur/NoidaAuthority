// Generated by data binding compiler. Do not edit!
package com.noida.authority.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.noida.authority.R;
import com.noida.authority.activity.LoginActivity;
import com.noida.authority.pojo.Login;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityLoginBinding extends ViewDataBinding {
  @NonNull
  public final Button loginBtn;

  @NonNull
  public final EditText mobileNumber;

  @NonNull
  public final EditText password;

  @NonNull
  public final TextView welcome;

  @Bindable
  protected LoginActivity mActivity;

  @Bindable
  protected Login mLogin;

  @Bindable
  protected LoginActivity.EventHandler mClickListener;

  protected ActivityLoginBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button loginBtn, EditText mobileNumber, EditText password, TextView welcome) {
    super(_bindingComponent, _root, _localFieldCount);
    this.loginBtn = loginBtn;
    this.mobileNumber = mobileNumber;
    this.password = password;
    this.welcome = welcome;
  }

  public abstract void setActivity(@Nullable LoginActivity activity);

  @Nullable
  public LoginActivity getActivity() {
    return mActivity;
  }

  public abstract void setLogin(@Nullable Login login);

  @Nullable
  public Login getLogin() {
    return mLogin;
  }

  public abstract void setClickListener(@Nullable LoginActivity.EventHandler clickListener);

  @Nullable
  public LoginActivity.EventHandler getClickListener() {
    return mClickListener;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_login, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityLoginBinding>inflateInternal(inflater, R.layout.activity_login, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_login, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityLoginBinding>inflateInternal(inflater, R.layout.activity_login, null, false, component);
  }

  public static ActivityLoginBinding bind(@NonNull View view) {
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
  public static ActivityLoginBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityLoginBinding)bind(component, view, R.layout.activity_login);
  }
}
