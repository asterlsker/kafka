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
- Jongho: 배송(Delivery)
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
