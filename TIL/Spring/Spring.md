### Web Server
- 정적인 컨텐츠(파일)를 제공하는 서버
- **HTML, CSS, 이미지 등 변하지 않는 파일들을 클라이언트(브라우저)에게 전달**
- 대표적인 웹 서버: **Apache, Nginx**
### WAS (Web Application Server)
- 동적인 컨텐츠를 제공하는 서버   
- **사용자의 요청에 따라 데이터를 처리하여 다른 결과를 보여줌**
- Java로 작성한 프로그램을 실행하고 결과를 사용자에게 전달
- 대표적인 WAS: **Tomcat**

### Spring
https://spring.io/
- Java 기반의 애플리케이션 개발을 위한 오픈소스 프레임워크이며 현재 가장 널리 사용되는 Java 프레임워크
- 웹사이트나 웹 서비스를 만들 때 필요한 많은 기능들을 미리 구현해놓아 개발자가 비즈니스 로직에만 집중할 수 있게 함

### Spring Boot
https://start.spring.io/
- **Spring을 더 쉽게 사용할 수 있게 해주는 도구**
- 복잡한 설정 없이 바로 개발 시작 가능
- **필요한 라이브러리들을 자동으로 설치**
- **서버가 내장되어 있어 따로 설치할 필요 없음(WAS Tomcat이 내장되어 있음 )**

### Spring Boot시작
1. spring initializr에서 
	- Project: Gradle - Groovy
	- Language: Java
	- Spring Boot: 3.4.1
	- Aritfact: 소문자로 이름 설정
	- Name: 소문자로 이름 설정
	- Package name: 대부분 도메인의 거꾸로로 작성함
	- Packaging: Jar
	- Java: 23
	- Dependencies: Spring Web, Lombok, Spring Boot Dev Tools 등
2. 위에 설정대로 된 프로젝트를 다운 받은 후 압축된 프로젝트 풀기
3. Intellij에서 프로젝트의 build.gradle을 선택해서 열기
4. ~Application의 main 함수 실행 => Spring 서버 실행됨(WAS: Tomcat)
****
 +)
#### Spring Boot DevTools의 Auto Restart(서버 자동재시작), Live Reload(브라우저 새로고침) 기능 사용하기
-  Settings -> Tools -> Advanced Settings -> Complier의 Allow auto-make to start even if developed application is currently running을 ☑

- Settings -> Build, Execution, Deployment -> Complier -> Build project automatically을 ☑

#### Lombok
- Settings -> Plugins에서 lombok 검색 후 install
- Settings → Build, Execution, Deployment → Compiler → Annotation Processotrs에서 Enable annotation processing을 ☑