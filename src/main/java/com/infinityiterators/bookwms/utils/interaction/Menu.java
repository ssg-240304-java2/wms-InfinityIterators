package com.infinityiterators.bookwms.utils.interaction;

import java.io.*;

public class Menu {
    /**
     * 로고를 출력하는 메소드
     */
    public static void displayLogo() {
        final String logoPath = "src/main/resources/asciilogo.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(logoPath))) {
            String line;
            while((line = reader.readLine()) != null)
                Console.print(line, DisplayType.MENU_HEADER, true);
        } catch(Exception e) {
            Console.printError("로고를 출력하는 도중 오류가 발생했습니다.");
        }
    }

    /**
     * 메뉴 헤더를 출력하는 메소드
     * <blockquot><pre>{@code
     * displayMenuHeader("메뉴명");
     * }</pre></blockquot>
     * @param header 메뉴 헤더
     */
    public static void displayMenuHeader(String header) {
        final int MENU_LENGTH = 50; // 메뉴명을 포함한 전체 메뉴 길이(고정값)

        int menuNameLength = header.length();
        int leftLength = (MENU_LENGTH - menuNameLength) / 2;
        int rightLength = MENU_LENGTH - menuNameLength - leftLength;

        String format = "=".repeat(leftLength) + " " + header + " " + "=".repeat(rightLength);
        Console.print(format, DisplayType.MENU, true);
    }

    /**
     * 선택지를 출력하는 메소드
     * <blockquot><pre>{@code
     * displaySelectionMenu("선택지1", "선택지2", "선택지3");
     * }</pre></blockquot>
     * @param selections 선택지
     */
    public static void displaySelectionMenu(String... selections) {
        for (int i = 0; i < selections.length; i++) {
            String format = (i + 1) + ". " + selections[i];
            Console.print(format, DisplayType.MENU, true);
        }
    }
}
