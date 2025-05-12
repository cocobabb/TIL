### 형태: `?.`
```
   const value = data?.property ?? '기본 값';
```

- `data?.property`: `data`가 `null` 또는 `undefined`가 아니면 `property`에 접근하고, 그렇지 않으면 `undefined`를 반환
- `??` `'기본 값'`: `data?.property`가 `null` 또는 `undefined`면 `'기본 값'`을 사용