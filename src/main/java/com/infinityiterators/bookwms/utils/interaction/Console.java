package com.infinityiterators.bookwms.utils.interaction;

public class Console {
    /**
     * 메시지를 출력하는 메소드
     * <blockquot><pre>{@code
     * print("메시지", DisplayType.NORMAL, false);
     * }</pre></blockquot>
     * @param message 출력할 메시지
     * @param displayType 출력할 메시지의 타입(색상 적용)
     * @param returnLine 줄바꿈 여부
     */
    public static void print(String message, DisplayType displayType, boolean returnLine) {
        System.out.print(displayType.getCode() + message + DisplayType.NORMAL.getCode());
        if(returnLine) System.out.println();
    }

    /**
     * 에러 메시지를 출력하는 메소드
     * @param message 출력할 에러 메시지
     */
    public static void printError(String message) {
        print(message, DisplayType.ERROR, true);
    }

    /**
     * 화면을 지우는 메소드
     */
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
