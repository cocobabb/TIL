### 커스텀 예외(Custom Exception)

: 일반적으로 커스텀 예외는 **`RuntimeException`을 상속 받아 만듦**

- 컴파일 시 예외 처리를 강제하지 않음(Unchecked Exception)
- 스프링의 트랜잭션 롤백 메커니즘과 호환
- 더 유연한 예외 처리가 가능

```java
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException() {
        super("리소스를 찾을 수 없습니다.");
    }
}
```

### @ExceptionHandler

: 특정 **Controller 클래스 내에서 발생하는 예외를 처리하는 메서드를 지정**하는 어노테이션

- **예외 발생 시 자동으로 해당 메서드가 실행**됨
- 예외 종류별로 다른 처리 방식 적용 가능
- ResponseEntity를 통한 응답 제어 가능

### @ControllerAdvice

: **전역적으로 예외를 처리하는 클래스를 지정**하는 어노테이션

- 모든 Controller에서 발생하는 예외를 한 곳에서 관리
- **`@RestControllerAdvice`= `@ControllerAdvice` + `@ResponseBody`**
  GlobalExceptionHandler

```java
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse<Void>> handleUserNotFound(ResourceNotFoundException ex) {
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(ApiResponse.error(ex.getMessage(), "NOT_FOUND"));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse<Void>> handleGeneralException(Exception ex) {
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ApiResponse.error("서버 내부 오류가 발생했습니다.", "INTERNAL_SERVER_ERROR"));
	}

 }
```
