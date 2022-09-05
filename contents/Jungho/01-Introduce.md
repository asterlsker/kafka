# Apache Kafka

> Open source distributed event streaming platform

- 2011 년에 LinkedIn 이 Kafka 를 만들고 Apache Software Foundation 에 기부

## What is Event Streaming ?

> Event streaming is the practice of __capturing data in real-time__ from event sources like databases, sensors, mobile devices, cloud services
> and software applications in the form of streams of events; 
> __storing these event streams durably for later retrieval.__

## What is Stream ?

![kafka-streams](https://user-images.githubusercontent.com/47518272/188469618-b189197b-93d1-4c13-aa71-08eafa5b635a.png)

- 여러개의 Data Record 로 구성되어있음
- Data Record 는 Key/Value 형식으로 구성되어있음

> Kafka 는 밀리초 지연시간(millisecond latency)을 통해 레코드당(per-record) 스트림 처리를 지원한다.

## KAFKA STREAMS

> The easiest way to write mission-critical real-time applications and microservices

- 데이터를 실시간으로 처리하기 위한 표준 Java 애플리케이션 및 마이크로서비스를 작성할 수 있다.
- Kafka Streams는 입력 및 출력 데이터가 Kafka 클러스터에 저장되는 애플리케이션 및 마이크로서비스를 구축하기 위한 클라이언트 라이브러리이다. 이는 클라이언트 측에서 표준 Java 및 Scala 애플리케이션을 작성하고 배포하는 `단순성`과 Kafka의 서버 측 `클러스터` 기술의 이점을 결합한다.

## 사용 예

- 증권 거래소, 은행 및 보험과 같은 실시간으로 지불 및 금융 거래를 처리합니다.
- 물류 및 자동차 산업과 같이 자동차, 트럭, 차량 및 선적을 실시간으로 추적하고 모니터링합니다.
- 공장 및 풍력 발전 단지와 같은 IoT 장치 또는 기타 장비의 센서 데이터를 지속적으로 캡처하고 분석합니다.
- 소매, 호텔 및 여행 산업, 모바일 애플리케이션과 같은 고객 상호 작용 및 주문을 수집하고 즉시 대응합니다.
- 병원에서 치료 중인 환자를 모니터링하고 상태 변화를 예측하여 응급 상황에서 시기 적절한 치료를 보장합니다.
- 회사의 여러 부서에서 생성된 데이터를 연결, 저장 및 사용 가능하게 만드는 것.
- 데이터 플랫폼, 이벤트 중심 아키텍처 및 마이크로서비스의 기반 역할을 합니다.

## End to End Event-Streaming 구현 방법

> 게시/구독(publish/subscribe) > 저장(store) > 처리(process)

1. 다른 시스템에서 데이터를 지속적으로 가져오기/내보내기를 포함하여 이벤트 스트림을 `게시(publish, 쓰기(write))` 및 `구독(subscribe, 읽기(read))` 합니다.
2. 이벤트 스트림을 원하는 만큼 내구성 있고 안정적으로 `저장` 합니다.
3. 이벤트 스트림을 발생 시 처리하거나 소급하여 `처리` 합니다.

## Links

- https://kafka.apache.org/documentation/#intro_streaming
- [Kafka - wide variety of use cases](https://kafka.apache.org/powered-by)
- https://zicodeng.medium.com/a-gentle-introduction-to-a-distributed-streaming-platform-kafka-e2355148dda0
- https://www.confluent.io/what-is-apache-kafka/?utm_medium=sem&utm_source=bing&utm_campaign=ch.sem_br.nonbrand_tp.prs_tgt.kafka_mt.xct_rgn.apac_lng.eng_dv.all&utm_term=what%20is%20apache%20kafka&creative=&device=c&placement=&msclkid=940ba0b8011f125f2e16c3adfc3bf8bd
