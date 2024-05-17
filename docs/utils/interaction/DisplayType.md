
# **DisplayType** Enum

## 네임스페이스
```java
com.infinityiterators.bookwms.utils.interaction
```

## 열거형 값

#### **NORMAL**
```java
NORMAL("\u001B[0m")
```
- 설명: 일반적인 메시지
- 코드: `"[0m"`

#### **ERROR**
```java
ERROR("\u001B[31m")
```
- 설명: 에러 메시지
- 코드: `"[31m"`

#### **SYSTEM**
```java
SYSTEM("\u001B[95m")
```
- 설명: 시스템 메시지
- 코드: `"[95m"`

#### **MENU**
```java
MENU("\u001B[32m")
```
- 설명: 메뉴 메시지
- 코드: `"[32m"`

#### **MENU_HEADER**
```java
MENU_HEADER("\u001B[34m")
```
- 설명: 메뉴 헤더 메시지
- 코드: `"[34m"`

#### **DESCRIPTION**
```java
DESCRIPTION("\u001B[33m")
```
- 설명: 설명 메시지
- 코드: `"[33m"`

## 메서드

#### **getCode()**
```java
public String getCode()
```
- 설명: 열거형 값에 해당하는 색상 코드를 반환합니다.
- 반환 값: 색상 코드 (`String`)

## 생성자

#### **DisplayType(String code)**
```java
DisplayType(String code)
```
- 설명: `DisplayType` 열거형의 생성자입니다.
- 매개변수:
    - `code` (`String`): 열거형 값에 해당하는 색상 코드
