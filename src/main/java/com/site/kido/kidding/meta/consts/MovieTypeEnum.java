package com.site.kido.kidding.meta.consts;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/9/21.
 */
public enum MovieTypeEnum {

    ALL(0, "ALL"),
    FILM(1, "FILM"),
    ANIMATION(2, "ANIMATION"),
    THRILLER(3, "THRILLER");

    private Integer typeCode;
    private String typeName;

    MovieTypeEnum(Integer typeCode, String typeName) {
        this.typeCode = typeCode;
        this.typeName = typeName;
    }

    public static String getTypeName(Integer typeCode) {
        for (MovieTypeEnum movieTypeEnum : MovieTypeEnum.values()) {
            if (movieTypeEnum.getTypeCode().equals(typeCode)) {
                return movieTypeEnum.getTypeName();
            }
        }
        return FILM.getTypeName();
    }

    public Integer getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(Integer typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
