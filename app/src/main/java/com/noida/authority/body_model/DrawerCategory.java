package com.noida.authority.body_model;

import androidx.fragment.app.Fragment;

public class DrawerCategory {

    String category;
    int icon;
    Fragment fragment;

    public DrawerCategory(String category, int icon, Fragment fragment) {
        this.category = category;
        this.icon = icon;
        this.fragment = fragment;
    }

    public String getCategory() {
        return category;
    }

    public int getIcon() {
        return icon;
    }

    public Fragment getFragment() {
        return fragment;
    }
}
