package com.site.kido.kidding.utils;

import com.site.kido.kidding.meta.consts.Constants;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/9/21.
 */
public class PermissionUtil {
    public static boolean checkAuth(String secretCode) {
        if (Constants.ERP_SECRET_CODE.equals(secretCode)) {
            return true;
        }
        return false;
    }
}
