package com.inc.smart.portal.document.domain.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Top Menu 구분 (가장 최상위 프로세스 단계 정의 )
 */
public enum TopMenu {
    PLANNING(1,"프로젝트 계획"),
    PROGRESS(2,"프로젝트 수행"),
    OPERATION(3,"운영"),
    MAINTAIN(4,"유지보수");

    private final int code;
    private final String name;

    TopMenu(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static List<Integer> topMenuCodeList() {

        return Arrays.stream(values())
                .map(TopMenu::getCode)
                .collect(Collectors.toList());
    }

    public static List<String> topMenuList() {
        return Arrays.stream(values())
                .map(TopMenu::getName)
                .collect(Collectors.toList());
    }

    public static TopMenu findByCode(int code) {
        for (TopMenu topMenu : values()) {
            if (topMenu.code == code) {
                return topMenu;
            }
        }
        throw new IllegalArgumentException("No matching menu for top menu code: " + code);
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
