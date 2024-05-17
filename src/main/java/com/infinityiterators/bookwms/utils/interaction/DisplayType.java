package com.infinityiterators.bookwms.utils.interaction;

public enum DisplayType {
    NORMAL("\u001B[0m"),    // 일반적인 메시지
    ERROR("\u001B[31m"),    // 에러 메시지
    SYSTEM("\u001B[95m"),   // 시스템 메시지
    MENU("\u001B[32m"),     // 메뉴 메시지
    MENU_HEADER("\u001B[34m"),  // 메뉴 헤더 메시지
    DESCRIPTION("\u001B[33m"); // 설명 메시지

    private final String code;
    DisplayType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}