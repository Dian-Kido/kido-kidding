package com.site.kido.kidding.vo;

import java.io.Serializable;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/9/21.
 */
public class ErpInfo<T> implements Serializable {

    private static final long serialVersionUID = -1L;

    private String secretCode;

    private T data;

    public String getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
