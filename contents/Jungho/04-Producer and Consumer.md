# Producer and Consumer

## Producer

> 프로듀서는 카프카로 메시지를 보내는 역할을 담당한다.

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

## Consumer

> 컨슈머는 카프카의 토픽에 저장되어 있는 메시지를 가져오는 역할을 담당한다.

- 메시지를 가져올 때 내부적으로 컨슈머 그룹, 리밸런싱 등 여러 동작을 수행한다.
- 프로듀서가 아무리 빠르게 카프카로 메시지를 전송하더라도 컨슈머가 빠르게 읽지 못하면 지연이 발생한다.

### 컨슈머의 기본동작

- 프로듀서가 카프카의 토픽으로 메시지를 전송하면 해당 메시지들은 브로커들의 로컬 디스크에 저장된다.
- 그 후, 컨슈머를 통해 토픽에 저장된 메시지를 읽어올 수 있다.
- 컨슈머 그룹은 하나 이상의 컨슈머들이 모여 있는 그룹을 의미하며, 컨슈머는 반드시 컨슈머 그룹에 속하게 된다. 그리고 이 컨슈머 그룹은 각 파티션의 리더에게 카프카 토픽에 저장된 메시지를 가져오기 위한 요청을 보낸다.
  - 파티션의 수:컨슈머의 수 = 1:1 이 가장 이상적
  - 파티션의 수 > 컨슈머의 수 는 바람직한 구성이 아님. 왜냐하면 파티션의 수가 더 많다고 해서 더 빠르게 토픽의 메시지를 가져오거나 처리량이 높아지는 것이 아니기 때문.
  - __간혹 active/standby 개념으로 추가 컨슈머가 더 있으면 좋을 것이라고 생각할 수 있지만, 컨슈머 그룹내에서 리밸런싱 동작을 통해 장애가 발생한 컨슈머의 역할을 동일한 그룹에 있는 다른 컨슈머가 그 역할을 대신 수행하기 때문에 굳이 장애 대비를 위한 추가 컨슈머 리소스를 할당하지 않아도 된다.__
- 컨슈머들은 토픽의 파티션과 1:1로 매핑되어 메시지를 가져온다.

## Links

- [Take a deep dive into kafka producer api](https://dzone.com/articles/take-a-deep-dive-into-kafka-producer-api)
- [Kafka Producer Congiruations](https://docs.confluent.io/platform/current/installation/configuration/producer-configs.html#ak-producer-configurations-for-cp)
- [Kafka Consumer Configurations](https://docs.confluent.io/platform/current/installation/configuration/consumer-configs.html#ak-consumer-configurations-for-cp)
- [Round Robin Scheduling Algorithm](https://www.guru99.com/round-robin-scheduling-example.html)
- [Streams Architecture](https://docs.confluent.io/platform/current/streams/architecture.html#memory-management)
