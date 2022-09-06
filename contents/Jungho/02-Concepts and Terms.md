# Concepts and Terms

## Event

- __이벤트란__
  - something happened
  - record 또는 message 라고도 부름
  - Kafka 에서 데이터를 읽거나 쓸 때, 이벤트 형식으로 사용하게 됨
  - __이벤트 구조__
    - 키
    - 값
    - 타임스탬프
    - 기타 메타데이터
    - ```
      Event key: "Alice"
      Event value: "Made a payment of $200 to Bob"
      Event timestamp: "Jun. 25, 2020 at 2:06 p.m."
      ```
