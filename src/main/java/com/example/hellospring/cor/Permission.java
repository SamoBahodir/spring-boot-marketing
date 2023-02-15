package com.example.hellospring.cor;

import com.example.hellospring.cor.constant.CabinetType;
import lombok.Getter;

@Getter
public enum Permission {
    //ADMIN CABINET
    USER_VIEW(CabinetType.ADMIN_CABINET, "Users ma'lumotlarini ko'rish");

    //FRONT OFFICE

    //BACK OFFICE

    private final CabinetType cabinetType;
    private final String title;

    Permission(CabinetType cabinetType, String title) {
        this.cabinetType = cabinetType;
        this.title = title;
    }

}
