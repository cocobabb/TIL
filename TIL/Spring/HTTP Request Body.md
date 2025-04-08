: HTTP 요청의 본문(Body)에 들어있는 데이터
- POST, PUT, PATCH 요청에서 주로 사용된다
- 클라이언트가 서버로 데이터를 전송할 때 사용

### Spring에서 Request Body 받기
=> `@RequestBody` 어노테이션을 사용
- 입력받은 데이터는 객체로 변환하여 사용
    - JSON의 key 이름과 객체의 필드명이 일치해야 함
    - 대소문자도 정확히 일치해야 함
    - Getter/Setter가 있어야 함
    - String, Map, 또는 다른 class로 데이터 받을 수 있음
    
```java
    @PostMapping("/articles")
    public Article createArticle(@RequestBody Article article) {
        return article;
    }
```
### Request Body VS Query Parameter

|            |           Query Parameter            |                            Request Body                            |
| :--------: | :----------------------------------: | :----------------------------------------------------------------: |
|     형태     | URL: `/articles?title=제목&content=내용` | URL: `/articles`, <br><br>Body: `{"title": "제목", "content": "내용"}` |
|     사용     |                GET 요청                |                          POST, PUT, PATCH                          |
| URL에데이터 노출 |                  O                   |                                 X                                  |
