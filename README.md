![image](https://user-images.githubusercontent.com/487999/79708354-29074a80-82fa-11ea-80df-0db3962fb453.png)

# 예제 - 음식배달

본 예제는 MSA/DDD/Event Storming/EDA 를 포괄하는 분석/설계/구현/운영 전단계를 커버하도록 구성한 예제입니다.
이는 클라우드 네이티브 애플리케이션의 개발에 요구되는 체크포인트들을 통과하기 위한 예시 답안을 포함합니다.

# 서비스 시나리오

기능적 요구사항
• 고객이 메뉴를 선택하여 주문한다.
• 고객이 선택한 메뉴에 대해 결제한다.
• 주문이 되면 주문 내역이 입점상점주인에게 주문정보가 전달된다.
• 상점주는 주문을 수락하거나 거절할 수 있다.
• 상점주는 요리시작때와 완료 시점에 시스템에 상태를 입력한다.
• 고객은 아직 요리가 시작되지 않은 주문은 취소할 수 있다.
• 요리가 완료되면 고객의 지역 인근의 라이더들에 의해 배송건 조회가 가능하다.
• 라이더가 해당 요리를 Pick한 후, 앱을 통해 통보한다.
• 고객이 주문상태를 중간중간 조회한다.
• 라이더의 배달이 끝나면 배송확인 버튼으로 모든 거래가 완료된다.

![image](https://user-images.githubusercontent.com/94352502/203246476-93a1c642-b1c5-462c-95d5-9df5ddadbd3b.png)


# 체크포인트
1. Saga (Pub / Sub)
2. CQRS
3. Compensation / Correlation
4. Request / Response
5. Circuit Breaker
6. Gateway / Ingress

# Saga (Pub / Sub)
![image](https://user-images.githubusercontent.com/94352502/203248368-ad036581-af4f-4412-8f12-d295c604798e.png)
![image](https://user-images.githubusercontent.com/94352502/203259335-2f5b7011-e914-46d2-8812-fa5002802e87.png)
![image](https://user-images.githubusercontent.com/94352502/203259541-176b062e-49df-482f-b922-c7b46ade1a92.png)

# Request / Response
![image](https://user-images.githubusercontent.com/94352502/203259956-88be85be-8868-43c5-b3dd-03e6eb3c0574.png)


# Circuit Breaker
![image](https://user-images.githubusercontent.com/94352502/203260129-9c05a7d0-1433-4b66-bcd3-b76fbd7e2d0e.png)


# Gateway / Ingress
```

spring:
  profiles: docker
  cloud:
    gateway:
      routes:
        - id: front
          uri: http://front:8080
          predicates:
            - Path=/주문/**, /orders/**, /payments/**, /메뉴판/**, /통합주문상태/**
        - id: store
          uri: http://store:8080
          predicates:
            - Path=/주문관리/**, /storeOrders/**, /주문상세보기/**, /topFoods/**
        - id: customer
          uri: http://customer:8080
          predicates:
            - Path=/notificationLogs/**, /orderStatuses/**
        - id: delivery
          uri: http://delivery:8080
          predicates:
            - Path=/deliveries/**, 
        - id: frontend
          uri: http://frontend:8080
          predicates:
            - Path=/**
      globalcors:
        corsConfigurations:
          '[/**]':
            allowedOrigins:
              - "*"
            allowedMethods:
              - "*"
            allowedHeaders:
              - "*"
            allowCredentials: true

server:
  port: 8080
```




# 추가사항 1 (포장 주문 및 배송 완료 상태 확인)
![image](https://user-images.githubusercontent.com/94352502/203258397-b38b292c-efbd-4f0d-b7f4-ca388881c160.png)



# 추가사항 2 (주문 시작 및 거절 요리 시작 및 상태 확인)
![image](https://user-images.githubusercontent.com/94352502/203258912-fd59e714-8d58-40b5-aaf9-39d1916f0881.png)

