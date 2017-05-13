package com.dingmouren.wallpager.utils;

import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dingmouren on 2017/5/4.
 */

public class ViewUtil {
    public static List<View> getAllChildren(View target){
        if (!(target instanceof ViewGroup)) return Collections.singletonList(target);

        ArrayList<View> allChildren  = new ArrayList<>();
        ViewGroup viewGroup = (ViewGroup) target;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View child = viewGroup.getChildAt(i);
            ArrayList<View> targetsChildren = new ArrayList<>();
            targetsChildren.add(target);
            targetsChildren.addAll(getAllChildren(child));
            allChildren.addAll(targetsChildren);
        }
        return allChildren;
    }
}
