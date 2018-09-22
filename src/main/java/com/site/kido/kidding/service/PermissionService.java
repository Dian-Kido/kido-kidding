package com.site.kido.kidding.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/9/21.
 */
@Service("permissionService")
public class PermissionService {

    @Value("${erp.secret.code}")
    private String erpSecretCode = "DEFAULTSECRETCODE";

    public boolean checkAuth(String secretCode) {
        if (erpSecretCode.equals(secretCode)) {
            return true;
        }
        return false;
    }
}
