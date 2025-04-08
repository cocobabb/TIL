### Controller
- 클라이언트의 요청을 처리하는 첫 번째 단계로 처리할 클래스 파일에 컨트롤러 관련 어노테이션을 붙여줌
- **URL 요청을 처리하고 응답을 반환하는 역할**
- Spring에서는 `@Controller`와 `@RestController`를 제공한다.
    - @Controller
        - 주로 View(화면)를 반환하기 위해 사용
        - **JSP, Thymeleaf 등의 템플릿 엔진과 함께 사용**
        - 데이터를 전하는 **메서드에@ResponseBody를 붙여야 데이터를 직접 반환 가능**
    - @RestController
        - **@Controller + @ResponseBody**
        - 데이터를 직접 반환하기 위해 사용. **따로 @ResponseBody 붙일 필요 없음**
        - JSON, XML 형태의 데이터를 주로 반환

### 템플릿 엔진
- **서버에서 가져온 데이터를 HTML에 편리하게 표현**할 수 있게 해줌
- **Java 코드를 HTML 파일 내에서 사용**할 수 있게 해줌
#### 종류
- Thymeleaf
	- Spring 공식 권장 템플릿 엔진
    - Natural Template (순수 HTML을 그대로 유지)
    - 서버 실행 없이도 화면 확인 가능    
-  JSP
    - 가장 오래된 Java 템플릿 엔진
    - HTML 내부에 Java 코드 작성 가능
    - 현재는 점점 사용이 줄어드는 추세


### 렌더링 방식
- SSR(Server Side Rendering)
    - **서버에서 HTML을 생성**하여 클라이언트로 전송
    - 템플릿 엔진이 이 방식을 사용
    - **초기 로딩 속도가 빠르고 SEO에 유리**
    
- CSR(Client Side Rendering)
    - **클라이언트(브라우저)에서 JavaScript로 화면을 생성**
    - React, Vue, Angular 등이 이 방식을 사용
    - **서버 부하가 적고 사용자 경험이 좋음**


Spring 의 렌더링 방식
- 전통적인 웹 애플리케이션(SSR): 템플릿 엔진 사용
- REST API + 프론트엔드 분리(CSR): 프론트엔드 부분 React/Vue 등으로 대체 가능