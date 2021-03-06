package com.noida.authority;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.noida.authority.databinding.ActivityComplaintDetailsBindingImpl;
import com.noida.authority.databinding.ActivityGenralOrganisationBindingImpl;
import com.noida.authority.databinding.ActivityKyaAllotteeInfoBindingImpl;
import com.noida.authority.databinding.ActivityKyaCommunicationInfoBindingImpl;
import com.noida.authority.databinding.ActivityKyaDocumentUploadBindingImpl;
import com.noida.authority.databinding.ActivityLandingBindingImpl;
import com.noida.authority.databinding.ActivityLodgeNewComplaintBindingImpl;
import com.noida.authority.databinding.ActivityLoginBindingImpl;
import com.noida.authority.databinding.ActivitySearchBindingImpl;
import com.noida.authority.databinding.GeneralInstructionsFragmentBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYCOMPLAINTDETAILS = 1;

  private static final int LAYOUT_ACTIVITYGENRALORGANISATION = 2;

  private static final int LAYOUT_ACTIVITYKYAALLOTTEEINFO = 3;

  private static final int LAYOUT_ACTIVITYKYACOMMUNICATIONINFO = 4;

  private static final int LAYOUT_ACTIVITYKYADOCUMENTUPLOAD = 5;

  private static final int LAYOUT_ACTIVITYLANDING = 6;

  private static final int LAYOUT_ACTIVITYLODGENEWCOMPLAINT = 7;

  private static final int LAYOUT_ACTIVITYLOGIN = 8;

  private static final int LAYOUT_ACTIVITYSEARCH = 9;

  private static final int LAYOUT_GENERALINSTRUCTIONSFRAGMENT = 10;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(10);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.noida.authority.R.layout.activity_complaint_details, LAYOUT_ACTIVITYCOMPLAINTDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.noida.authority.R.layout.activity_genral_organisation, LAYOUT_ACTIVITYGENRALORGANISATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.noida.authority.R.layout.activity_kya_allottee_info, LAYOUT_ACTIVITYKYAALLOTTEEINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.noida.authority.R.layout.activity_kya_communication_info, LAYOUT_ACTIVITYKYACOMMUNICATIONINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.noida.authority.R.layout.activity_kya_document_upload, LAYOUT_ACTIVITYKYADOCUMENTUPLOAD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.noida.authority.R.layout.activity_landing, LAYOUT_ACTIVITYLANDING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.noida.authority.R.layout.activity_lodge_new_complaint, LAYOUT_ACTIVITYLODGENEWCOMPLAINT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.noida.authority.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.noida.authority.R.layout.activity_search, LAYOUT_ACTIVITYSEARCH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.noida.authority.R.layout.general_instructions_fragment, LAYOUT_GENERALINSTRUCTIONSFRAGMENT);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYCOMPLAINTDETAILS: {
          if ("layout/activity_complaint_details_0".equals(tag)) {
            return new ActivityComplaintDetailsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_complaint_details is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYGENRALORGANISATION: {
          if ("layout/activity_genral_organisation_0".equals(tag)) {
            return new ActivityGenralOrganisationBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_genral_organisation is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYKYAALLOTTEEINFO: {
          if ("layout/activity_kya_allottee_info_0".equals(tag)) {
            return new ActivityKyaAllotteeInfoBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_kya_allottee_info is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYKYACOMMUNICATIONINFO: {
          if ("layout/activity_kya_communication_info_0".equals(tag)) {
            return new ActivityKyaCommunicationInfoBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_kya_communication_info is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYKYADOCUMENTUPLOAD: {
          if ("layout/activity_kya_document_upload_0".equals(tag)) {
            return new ActivityKyaDocumentUploadBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_kya_document_upload is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLANDING: {
          if ("layout/activity_landing_0".equals(tag)) {
            return new ActivityLandingBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_landing is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLODGENEWCOMPLAINT: {
          if ("layout/activity_lodge_new_complaint_0".equals(tag)) {
            return new ActivityLodgeNewComplaintBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_lodge_new_complaint is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLOGIN: {
          if ("layout/activity_login_0".equals(tag)) {
            return new ActivityLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_login is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSEARCH: {
          if ("layout/activity_search_0".equals(tag)) {
            return new ActivitySearchBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_search is invalid. Received: " + tag);
        }
        case  LAYOUT_GENERALINSTRUCTIONSFRAGMENT: {
          if ("layout/general_instructions_fragment_0".equals(tag)) {
            return new GeneralInstructionsFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for general_instructions_fragment is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(19);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "activity");
      sKeys.put(2, "gender");
      sKeys.put(3, "clickHandler");
      sKeys.put(4, "kya_communication");
      sKeys.put(5, "sector_list");
      sKeys.put(6, "registration_id");
      sKeys.put(7, "login");
      sKeys.put(8, "lodge_new_complaint");
      sKeys.put(9, "Kya_Document");
      sKeys.put(10, "department_list");
      sKeys.put(11, "complaint_detail");
      sKeys.put(12, "handlers");
      sKeys.put(13, "service_list");
      sKeys.put(14, "location");
      sKeys.put(15, "block_list");
      sKeys.put(16, "kya_info");
      sKeys.put(17, "clickListener");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(10);

    static {
      sKeys.put("layout/activity_complaint_details_0", com.noida.authority.R.layout.activity_complaint_details);
      sKeys.put("layout/activity_genral_organisation_0", com.noida.authority.R.layout.activity_genral_organisation);
      sKeys.put("layout/activity_kya_allottee_info_0", com.noida.authority.R.layout.activity_kya_allottee_info);
      sKeys.put("layout/activity_kya_communication_info_0", com.noida.authority.R.layout.activity_kya_communication_info);
      sKeys.put("layout/activity_kya_document_upload_0", com.noida.authority.R.layout.activity_kya_document_upload);
      sKeys.put("layout/activity_landing_0", com.noida.authority.R.layout.activity_landing);
      sKeys.put("layout/activity_lodge_new_complaint_0", com.noida.authority.R.layout.activity_lodge_new_complaint);
      sKeys.put("layout/activity_login_0", com.noida.authority.R.layout.activity_login);
      sKeys.put("layout/activity_search_0", com.noida.authority.R.layout.activity_search);
      sKeys.put("layout/general_instructions_fragment_0", com.noida.authority.R.layout.general_instructions_fragment);
    }
  }
}
