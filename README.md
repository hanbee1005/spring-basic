# spring-basic
인프런 강좌 중 김영한 개발자님의 '스프링 핵심 원리 - 기본편'을 수강하며 정리한 내용입니다.
객체지향 언어의 핵심인 다형성과 OCP, DIP를 만족하는 프로젝트를 개발하면서 스프링의 원리를 이해하는 강좌입니다.

## 사용 기술 및 환경
- Java 11
- SpringBoot 2.5.0
- Gradle

## 프로젝트 전체 구조
- 회원 도메인
    - 협력 관계
    <img src="/src/main/resources/images/member-domain-01.png" width="750" height="250">
    
    - 클래스 다이어그램
    <img src="/src/main/resources/images/member-domain-02.png" width="750" height="250">

- 주문 도메인
    - 협력 관계
    <img src="/src/main/resources/images/order-domain-01.png" width="750" height="500">
    
    - 클래스 다이어그램
    <img src="/src/main/resources/images/order-domain-02.png" width="750" height="500">

## 프로젝트 관심사
### 객체지향 프로그래밍
- 특징: 추상화, 캡슐화, 상속, ***다형성***
- 다형성의 본질은 ***클라이언트를 변경하지 않고 서버의 구현 기능을 유연하게 변경할 수 있다***는 것
- But, 다형성만으로는 OCP, DIP를 지킬 수 없음...

### 객체지향 설계와 스프링
- 스프링은 다음 기술로 다형성 + OCP, DIP를 가능하게 지원
  - ***DI(Dependency Injection)***: 의존성, 의존관계 주입
  - ***DI 컨테이너 제공***
  
### 싱글톤
- 스프링 컨테이너는 싱글톤 패턴의 단점을 모두 해결하고 스프링 빈을 싱글톤으로 생성, 등록

### 컴포넌트 스캔과 자동 의존 관계 주입
- @Configuration 파일에 @ComponentScan 애노테이션을 추가하면 @Component라고 붙은 객체를 스프링 빈으로 자동 등록
- 의존 관계 주입은 생성자 주입을 사용하는 것이 좋고 생성자에 @Autowired 애노테이션을 붙이면 됩 (생성자가 하나인 경우 애노테이션 생략 가능)

### 빈 생명 주기와 빈 스코프
- 일반적인 빈 생명 주기
  1. 스프링 컨테이너 생성
  2. 스프링 빈 생성
  3. 의존관계 주입
  4. ***초기화 콜백***
  5. 사용
  6. ***소멸 전 콜백***
  7. 스프링 종료      
 
                
- 빈 스코프
  - **싱글톤**: 기본 스코프, 스프링 컨테이너의 시작과 종료까지 유지되는 가장 넓은 범위의 스코프이다.
  - **프로토타입**: 스프링 컨테이너는 프로토타입 빈의 생성과 의존관계 주입까지만 관여하고 더는 관리하지 않는
  매우 짧은 범위의 스코프이다.
  - **웹 관련 스코프**
    - **request**: 웹 요청이 들어오고 나갈때 까지 유지되는 스코프이다.
    - **session**: 웹 세션이 생성되고 종료될 때 까지 유지되는 스코프이다.
    - **application**: 웹의 서블릿 컨텍스트와 같은 범위로 유지되는 스코프이다.