CDN(Content Delivery Network)
: 웹 콘텐츠를 사용자에게 신속하게 제공하기 위해 *전 세계에 분산된 서버 네트워크*
자주 사용하는 파일을 전 세계에 있는 서버에 저장. **사용자 위치와 가장 가까운 서버를 통해 빠르게 데이터 제공 받음**
#### CDN 사용 시 서버 부하 감소 & 빠른 속도로 콘텐츠 제공

+ Tailwind CSS CDN 링크
```html
<!DOCTYPE html>
<html>
  <head>
    <!-- Tailwind CSS 파일을 불러온다. -->
    <script src="https://cdn.tailwindcss.com"></script>
  </head>
  <body></body>
</html>

```
+ Bootstrap CDN 링크
```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Bootstrap CSS 파일을 불러온다 -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
      crossorigin="anonymous"
    />
  </head>
  <body>
    <!-- Bootstrap JavaScript 파일을 불러온다 -->
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
      crossorigin="anonymous"
    ></script>
  </body>
</html>

```

## Tailwind
: Utility-First 아키텍처를 기반으로 하는 CSS 프레임워크
유틸리티 클래스(기능별로 하나의 스타일 속성만 가진 클래스)를 사용하여 스타일 적용하는 방식 빠르고 효율적인 스타일링 가능

## Bootstrap
: 반응형 웹 디자인을 쉽게 구현할 수 있도록 **디자인된 컴포넌트를 제공**
**다양한 UI 컴포넌트를 제공**하며, html 요소에 클래스를 추가하는 것만으로 빠르게 디자인 완성 가능