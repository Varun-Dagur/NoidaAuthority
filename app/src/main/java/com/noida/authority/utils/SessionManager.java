package com.noida.authority.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.noida.authority.MainActivity;
import com.noida.authority.activity.LoginActivity;

import java.util.HashMap;

public class SessionManager {

    public static final String TOKEN_ID = "token_id";
    public static final String USER_NAME = "user_name";
    public static final String EMPLOYEE_ID = "employee_id";
    public static final String USER_ID = "user_id";
    public static final String USER_PASSWORD = "user_password";
    public static final String TYPE_Password = "type_password";
    public static final String NAME = "name";
    public static final String RID = "rid";
    public static final String IOB = "iob";
    public static final String ISU = "isu";

    // public static final String PROFILE_PIC = "profile_pic";

    public static final String MOBILE_NUMBER = "mobile_number";
    public static final String EMAIL_ID = "email_id";
    public static final String DEVICE_ID = "device_id";
    public static final String ENCRYPTED_KEY = "encrypted_key";
    public static final String PUNCH_IN = "punch_in";
    public static final String KYA_STATUS = "kya_status";
    public static final String PUNCH_TIME = "punch_time";
    public static final String FCM_TOKEN = "fcm_token";
    public static final String SELECTED_LANGUAGE = "selected_language";
    private static final String STRING_LOCALE = "string_locale";
    private static final String ATTENDANCE_TYPE = "attendance_type";

    // Sharedpref file name
    private static final String PREF_NAME = "hrms";
    // All Shared Preferences Keys
    private static final String IS_LOGIN = "is_logged_in";
    // Shared Preferences
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    // Context
    Context _context;
    // Shared pref mode
    int PRIVATE_MODE = 0;


    // Constructor
    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createLoginSession( String userName, String password, String type) {

        // Storing login value as TRUE
        //   editor.putBoolean(IS_LOGIN, true);

        // Storing name in pref
        editor.putString(USER_NAME, userName);
        editor.putString(USER_PASSWORD, password);
        editor.putString(TYPE_Password, type);
     /*   editor.putString(DEVICE_ID, deviceId);
        editor.putInt(USER_ID, result.getId());
        editor.putString(NAME, result.getName());
        editor.putString(RID, result.getRid());
        editor.putBoolean(IOB, result.getIob());
        editor.putBoolean(ISU, result.getIsu());*/

        // commit changes
        editor.commit();
    }


    /**
     * Create login session
     */
   /* public void createLoginSession(LoginResponse.LoginResult result, String deviceId) {

        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Storing name in pref
        editor.putString(TOKEN_ID, result.getToken());
        editor.putString(DEVICE_ID, deviceId);
        editor.putInt(USER_ID, result.getId());
        editor.putString(NAME, result.getName());
        editor.putString(RID, result.getRid());
        editor.putBoolean(IOB, result.getIob());
        editor.putBoolean(ISU, result.getIsu());

        // commit changes
        editor.commit();
    }*/

    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     */
    public void checkLogin() {
        // Check login status
        if (this.isLoggedIn()) {

            Intent i = new Intent(_context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(i);

        } else {
            Intent i = new Intent(_context, LoginActivity.class);
            // Staring Login Activity
            _context.startActivity(i);
        }
    }

    public String getUserToken() {
        return pref.getString(TOKEN_ID, null);
    }

    public String getUserName() {
        return pref.getString(USER_NAME, null);
    }

    public String getUserPassword() {
        return pref.getString(USER_PASSWORD, null);
    }

    public String getTYPE_Password() {
        return pref.getString(TYPE_Password, null);
    }

    public int getUserId() {
        return pref.getInt(USER_ID, 0);
    }

    public int getEmployeeId() {
        return pref.getInt(EMPLOYEE_ID, 0);
    }

    /**
     * Get stored session data
     */
    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<>();
        user.put(TOKEN_ID, pref.getString(TOKEN_ID, null));
        user.put(DEVICE_ID, pref.getString(DEVICE_ID, null));
        user.put(USER_ID, String.valueOf(pref.getInt(USER_ID, 0)));
        user.put(NAME, pref.getString(NAME, null));
        user.put(RID, pref.getString(RID, null));
        // user.put(IOB, pref.getBoolean(IOB, false));
        // user.put(ISU, pref.getBoolean(ISU, false));

        // return user
        return user;
    }

    public void saveEncryptedKey(String key) {
        editor.putString(ENCRYPTED_KEY, key);
        editor.commit();
    }

    public void saveToke(String token) {
        editor.putString(TOKEN_ID, token);
        editor.commit();
    }

    public void saveKyaStatus(boolean status) {
        editor.putBoolean(KYA_STATUS, status);

        editor.commit();
    }

    public boolean getKyaStatus() {
        return pref.getBoolean(KYA_STATUS, false);
    }

    public boolean getIsu() {
        return pref.getBoolean(ISU, false);
    }


    public long getPunchInTime() {
        return pref.getLong(PUNCH_TIME, 0);
    }

    public String getEncryptedKey() {
        return pref.getString(ENCRYPTED_KEY, null);

    }

    public String getDeviceId() {
        return pref.getString(DEVICE_ID, null);

    }


    public void saveFcmToken(String token) {
        editor.putString(FCM_TOKEN, token);
        editor.commit();
    }

    public String getFcmToken() {
        return pref.getString(FCM_TOKEN, null);

    }

   /* public void saveLanguage(String localeCode) {
        editor.putString(SELECTED_LANGUAGE, localeCode);
        editor.commit();
    }

    public String getSelectedLanguage() {
        return pref.getString(SELECTED_LANGUAGE, null);

    }*/

  /*  public void saveLocale(LocaleStringResponse localeStringResponse) {
        Gson gson = new Gson();
        String json = gson.toJson(localeStringResponse);
        editor.putString(STRING_LOCALE, json);
        editor.commit();
    }

    public LocaleStringResponse getStringLocale() {
        Gson gson = new Gson();
        String json = pref.getString(STRING_LOCALE, null);
        LocaleStringResponse stringResponse = gson.fromJson(json, LocaleStringResponse.class);

        return stringResponse;
    }

    public List<AttendanceTypeResponse.Result> getAttendanceTypes() {
        Gson gson = new Gson();
        String json = pref.getString(ATTENDANCE_TYPE, null);

        Type type = new TypeToken<List<AttendanceTypeResponse.Result>>() {
        }.getType();
        return gson.fromJson(json, type);
    }

    public void saveAttendanceTypes(List<AttendanceTypeResponse.Result> result) {
        Gson gson = new Gson();
        String json = gson.toJson(result);
        editor.putString(ATTENDANCE_TYPE, json);
        editor.commit();
    }*/

    /**
     * Clear session details
     */
    public void logoutUser() {
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Home Activity
        Intent i = new Intent(_context, LoginActivity.class);
        _context.startActivity(i);
    }

    /**
     * Quick check for login
     **/
    // Get Login State
    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }
}