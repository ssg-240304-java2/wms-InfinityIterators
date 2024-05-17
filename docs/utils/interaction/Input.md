# **Input** 클래스

## 네임스페이스
```java
com.infinityiterators.bookwms.utils.interaction
```

## 메서드

#### **requestString(String msg)**
```java
public static String requestString(String msg)
```

- 설명: 사용자로부터 문자열을 입력받습니다.
- 매개변수:
    - `msg` (`String`): 입력을 요청하는 메시지
- 반환 값: 입력받은 문자열 (`String`)
- 예외:
    - 입력 중 예외 발생 시 `null` 반환

#### **requestInt(String msg)**
```java
public static Integer requestInt(String msg)
```

- 설명: 사용자로부터 정수를 입력받습니다.
- 매개변수:
    - `msg` (`String`): 입력을 요청하는 메시지
- 반환 값: 입력받은 정수 (`Integer`)
- 예외:
    - 입력 중 예외 발생 시 `null` 반환

#### **requestChar(String msg)**

```java
public static Character requestChar(String msg)
```

- 설명: 사용자로부터 문자를 입력받습니다.
- 매개변수:
    - `msg` (`String`): 입력을 요청하는 메시지
- 반환 값: 입력받은 문자 (`Character`)
- 예외:
    - 입력 중 예외 발생 시 `null` 반환

#### **requestHiddenInput(String msg)**

```java
public static String requestHiddenInput(String msg)
```

- 설명: 사용자로부터 숨겨진 문자열을 입력받습니다. 주로 비밀번호 입력에 사용됩니다.
- 매개변수:
    - `msg` (`String`): 입력을 요청하는 메시지
- 반환 값: 입력받은 문자열 (`String`)
- 예외:
    - `RuntimeException`: 콘솔이 사용 가능하지 않을 경우