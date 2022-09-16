# Kafka

## Table of contents

- Food Delivery
  - [Study Plan](https://github.com/asterlsker/kafka/blob/main/README.md#study-plan)
  - [Project Rules](https://github.com/asterlsker/kafka/blob/main/README.md#study-plan)
    - [Development](https://github.com/asterlsker/kafka/blob/main/README.md#study-plan)
    - [Responsibility](https://github.com/asterlsker/kafka/blob/main/README.md#study-plan)
    - [Package](https://github.com/asterlsker/kafka/blob/main/README.md#study-plan)
    - [CodeReview](https://github.com/asterlsker/kafka/blob/main/README.md#study-plan)
    - [Branch Strategy](https://github.com/asterlsker/kafka/blob/main/README.md#study-plan)
    - [Commit Message Template](https://github.com/asterlsker/kafka/blob/main/README.md#study-plan)
  - Architectures
  - Scenario

## Study Plan

- STEP-1
  - 기초 개념 공부
- STEP-2
  - 프로젝트
    - 주문 - 배송 - 사용자
- STEP-3
  - [Eventual Consistency](https://baekjungho.github.io/wiki/msa/msa-eventual-consistency/) 개념 위주로 학습
- STEP-4
  - 대용량 데이터 처리 위주로 학습

## Project Rule

### Development

- Language
  - Kotlin
- Style Guide
  - [Coding Conventions Kotlin](https://kotlinlang.org/docs/coding-conventions.html)
- Clean Code 지향
- [Testing Style](https://kotest.io/docs/framework/testing-styles.html)
  - [Using Kotest Library](https://kotest.io/)
  - Domain Layer 는 Describe Spec 적용
  - Interfaces Layer 는 Feature Spec 적용
  - Application Layer 는 Func Spec 적용
  - Infrastructure Layer 는 ~~~~
  - Non required dependency test 는 String Spec 적용
- DDD 지향
- Gradle Multi Module 설정

### Resposibility

- Jungho: 주문(Order)
  - Product
- Jongho: 매장(Store)
  - Delivery
- Juhyun: 사용자(Customer)

### Package

- interfaces
  - Controller, DTO
- application
  - xxxFacade
- domain: 도메인별 서비스 1개(xxxService)
  - order
  - product
    - enum
    - entity
    - repository interface
    - adapter interface
- infrastructure
  - 세부 구현 기술
- common
  - properties
  - utils
- config

### CodeReview

- All Approve 만 Merge 가능

### Branch Strategy

- __Merge Target: develop branch__
- 도메인명/feature/이슈번호
  - feature, refactor, hotfix
  - 작업하기 전에 이슈 생성

### Commit Message Template

- init
- feat
- fix
- refactor
- docs
- chore

```
feat: 재고 감소 로직 작성
(line break)
내용 작성
```

## Scenario

> 우리의 Food Delivery 서비스에는 환불요청기능이 존재한다. 환불요청기능은 별점 테러로 인한 가게 피해를 최소화 하기 위해서 개발되었다.
>
> - __환불요청 프로세스__
>   - 사용자가 배달 음식을 수령하고 음식 상태를 확인한다.
>   - 사용자가 환불 요청 신청을 한다.
>     - 환불 신청서 작성 기준: 배달완료상태로 부터 10분 이내
>     - 음식 사진 + 환불 사유 + 처리 방법(음식 재배달 or 환불)을 작성한다.
>     - 입점상점주인은 환불 승인 or 거부를 할 수 있으며 거부 시, 사유를 같이 작성한다.

1. 고객이 메뉴를 선택하여 주문한다.
2. 고객이 결제한다. (생략 = 주문 요청에 대해서 재고가 부족하지 않다면 결제가 되었다고 치고, 주문 완료 처리를 한다.)
3. 주문이 되면 입점상점주인에게 전달된다.
4. 입점상점주인이 확인하여 요리를 하고 배달을 한다. 
5. 고객이 주문을 취소 할 수 있다.(단, 주문접수 이전 상태에서만 가능)
6. 주문이 취소되면 결제도 취소된다. (생략 = 주문 취소시 결제 취소는 되었다고 가정한다.)
7. 고객이 중간중간 주문 상태를 조회한다.(생략)
8. 주문 상태가 바뀔때 마다 알림을 보낸다.(Ex. app-push, kakao-talk 생략)
9. 고객이 음식 상태를 확인하고 환불 신청을 한다.
10. 입점상점주인이 환불을 승인 하거나 거부한다.
11. 환불 승인 시 주문 취소 프로세스가 진행된다.

> 일단, 주문 쪽을 진행하고 환불은 추후에 진행
