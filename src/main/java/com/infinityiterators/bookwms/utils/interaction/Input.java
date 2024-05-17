package com.infinityiterators.bookwms.utils.interaction;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * 사용자로부터 문자열을 입력받는 메소드<br>
     * <blockquot><pre>{@code
     * requestString("문자열을 입력하세요", false);
     * }</pre></blockquot>
     * @param msg 입력을 요청하는 메시지
     * @return 입력받은 문자열
     */
    public static String requestString(String msg) {
        Console.print(msg + ": ", DisplayType.NORMAL, false);

        String input;
        try {
            input = scanner.nextLine();
        } catch (Exception e) {
            return null;
        }

        return input;
    }

    /**
     * 사용자로부터 정수를 입력받는 메소드<br>
     * <blockquot><pre>{@code
     * requestInt("정수를 입력하세요", false);
     * }</pre></blockquot>
     * @param msg 입력을 요청하는 메시지
     * @return 입력받은 정수
     */
    public static Integer requestInt(String msg) {
        Console.print(msg + ": ", DisplayType.NORMAL, false);

        int input;
        try {
            input = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            return null;
        }

        return input;
    }

    /**
     * 사용자로부터 문자를 입력받는 메소드<br>
     * <blockquot><pre>{@code
     * requestChar("문자를 입력하세요", false);
     * }</pre></blockquot>
     * @param msg 입력을 요청하는 메시지
     * @return 입력받은 문자
     */
    public static Character requestChar(String msg) {
        Console.print(msg + ": ", DisplayType.NORMAL, false);

        char input;
        try {
            input = scanner.next().charAt(0);
            scanner.nextLine();
        } catch (Exception e) {
            return null;
        }

        return input;
    }

    /**
     * 사용자로부터 숨겨진 문자열을 입력받는 메소드
     * <br>
     * <blockquot><pre>{@code
     * requestHiddenInput("비밀번호를 입력하세요", false);
     * }</pre></blockquot>
     * @param msg 입력을 요청하는 메시지
     * @return 입력받은 문자열
     */
    public static String requestHiddenInput(String msg) {
        java.io.Console console = System.console();
        if(console == null) throw new RuntimeException("Console not available");

        Console.print(msg + ": ", DisplayType.NORMAL, false);
        char[] input = console.readPassword();

        return new String(input);
    }
}
