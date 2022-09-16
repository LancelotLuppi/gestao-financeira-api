package com.luppi.gestaofinanceira.enums;

public enum OfficeEnum {
    USER(1);

    private Integer idOffice;

    OfficeEnum(Integer idOffice) {
        this.idOffice = idOffice;
    }

    public Integer getIdOffice() {
        return idOffice;
    }
}
