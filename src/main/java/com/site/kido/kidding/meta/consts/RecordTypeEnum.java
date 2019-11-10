package com.site.kido.kidding.meta.consts;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/10/1.
 */
public enum RecordTypeEnum {

    ALL(0, "ALL"),
    //浏览记录
    BROWSE(1, "BROWSE"),
    //留言记录（已废弃）
    MESSAGE(2, "MESSAGE"),
    //EMOTION点击
    CLICKEMOTION(3, "CLICKEMOTION");

    private Integer typeCode;
    private String typeName;

    RecordTypeEnum(Integer typeCode, String typeName) {
        this.typeCode = typeCode;
        this.typeName = typeName;
    }

    public static String getTypeName(Integer typeCode) {
        for (RecordTypeEnum recordTypeEnum : RecordTypeEnum.values()) {
            if (recordTypeEnum.getTypeCode().equals(typeCode)) {
                return recordTypeEnum.getTypeName();
            }
        }
        return BROWSE.getTypeName();
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
