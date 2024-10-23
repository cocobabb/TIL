: 데이터를 전달하기 위한 태그
 + form 태그 안에  input, textarea, select, button 태그들을 통해서 데이터를 입력받음
 + ***iput 태그의 type="submit"** 또는 **button 태그**의 type="submit" 를 통해 **데이터를 서버로 전달**
 + *form 태그의 **action 속성을 통해** 어떤 **URL로 데이터를 전달**할지 정함(설정 안하면 로컬호스트로 전송)*
 + form 태그의 **method 속성**을 통해 데이터 전송 시 사용할 **HTTP 메서드 지정(GET, POST, PUSH, PATCH, DELETE)**
 + input tag type 종류
	 + text :일반 텍스트 입력
	 + password :입력된 것이 마스킹 처리 되어 입력
	 + submit :폼 제출
	 + checkbox :다중 선택 시 사용하는 체크박스
	 + radio :하나만 선택 가능한 라디오 버튼
	 + email :이메일 형식으로 입력 받게 함
	 + number :숫자 입력만 가능 
	 + hidden: 화면에 표시되지 않고 숨기는 입력 필드
 + label 태그
		: input 태그의 id 속성과 label for 속성을 일치시켜 두 태그를 연결한다.
		label 태그를 클릭해도 input 태그를 클릭한 것처럼 된다.

```html
<form>
  <label for="id">아이디 :</label>
  <input type="text" name="id" id="id"><br>
  <label for="pw">비밀번호 :</label>
  <input type="password" name="pw" id="pw"><br>
  <input type="submit" value="로그인">
</form>
```

  + select 태그
	  : 사용자가 옵션 중 선택할 수 있는 드롭다운 목록 제공
```html
    <form action="">

      <label for="country">국가: </label>

      <select name="country" id="country">

        <option value="korea">대한민국</option>

        <option value="usa">미국</option>

        <option value="uk">영국</option>

        <option value="china">중국</option>

      </select>

      <input type="submit" value="제출" />

    </form>
```
  + textarea 태그
	   : 많은 양의 텍스트 입력할 때 사용
  + button 태그
	  :  사용자가 클릭할 수 있는 버튼을 생성 및 데이터 제출 
  ```html
    <form action="">

      <label for="myself">자기소개: </label>

      <textarea name="myself" id="myself" rows="4" cols="50"> </textarea>

      <button type="submit">제출</button>

    </form>
```