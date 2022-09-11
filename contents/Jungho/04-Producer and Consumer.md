# Producer and Consumer

## Producer Flow API

![image](https://user-images.githubusercontent.com/47518272/189517959-2f052218-cf0f-4463-876f-30ccd33ac882.png)

- __ProducerRecord__
  - 카프카로 전송하기 위한 실제 데이터
  - 레코드는 토픽, 파티션, 키, 밸류로 구성
  - 프로듀서가 카프카로 레코드를 전송할 때, 카프카의 특정 토픽으로 메시지를 전송
    - 따라서 레코드에서 토픽과 밸류(메시지 내용)은 필수값
    - 특정 파티션을 지정하기 위한 레코드의 파티션과 특정 파티션에 레코드들을 정렬하기 위한 레코드의 키는 필수값이 아닌 옵션
- __send()__
  - 각 레코드들은 프로듀서의 send() 메서드를 통해 시리얼라이저, 파티셔너를 거치게 됨
  - 만약에 ProducerRecord 의 파티션을 지정했다면, 파티셔너는 아무 동작도 하지 않고 지정된 파티션으로 레코드를 전달 함
  - 파티션을 지정하지 않은 경우에는 키를 가지고 파티션을 선택해 레코드를 전달 함
    - 기본적으로는 `라운드 로빈` 방식으로 동작 함
- __프로듀서 내부에서는 send() 메서드 동작 이후 레코드들을 파티션 별로 잠시 모아둔다.__
  - 모아두는 이유는 프로듀서가 카프카로 전송 하기 전, `배치 전송`을 하기 위함
  - 전송이 실패하면 재시도 동작이 이뤄짐
  - 지정한 횟수만큼의 재시도가 실패하면 최종 실패를 전달하고, 전송이 성공하면 메타데이터를 리턴함

## Links

- [Take a deep dive into kafka producer api](https://dzone.com/articles/take-a-deep-dive-into-kafka-producer-api)
- [Kafka Producer Congiruations](https://docs.confluent.io/platform/current/installation/configuration/producer-configs.html#ak-producer-configurations-for-cp)
- [Round Robin Scheduling Algorithm](https://www.guru99.com/round-robin-scheduling-example.html)
