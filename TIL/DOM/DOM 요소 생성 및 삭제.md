### **document.createElement('생성할 tag')**
: 메서드를 사용하여 새로운 요소 노드를 생성
```Javascript
const newDiv = document.createElement('div');
```
### **부모요소.appendChild('생성할 tag')**
:새로운 요소를 부모 요소의 **마지막 자식으로 추가**
```HTML
<!DOCTYPE html>
<html>
  <body>
    <div id="parent-element">
      <div></div>
      <div></div>
      <div></div>
    </div>
    <script>
      const parentElement = document.querySelector('#parent-element');

      // 새로운 요소 생성
      const newDiv = document.createElement('div');

      newDiv.classList.add('newDiv');

      // 부모 요소 마지막 자식으로 새로운 요소 추가
      parentElement.appendChild(newDiv);
    </script>
  </body>
</html>

```

### **부모요소.insertBefore(새로운 요소, 특정 자식요소)**
: 부모 요소의 **특정 자식 요소 앞에** 새로운 요소를 **삽입**
```HTML
<!DOCTYPE html>
<html>
  <body>
    <div id="parent-element">
      <div></div>
      <div></div>
      <div id="lastDiv"></div>
    </div>
    <script>
      const parentElement = document.querySelector('#parent-element');

      // 새로운 요소 생성
      const newDiv = document.createElement('div');

      newDiv.classList.add('newDiv');

      const lastDiv = document.querySelector('#lastDiv');

      // 부모 요소 자식으로 새로운 요소 추가
      parentElement.appendChild(newDiv, lastDiv);
    </script>
  </body>
</html>
```

### **부모요소.append(새로운 요소1, 새로운 요소2, '텍스트')**
: 선택한 부모 요소의 마지막 자식으로 **복수의 요소나 문자열을 한 번에 추가**
```HTML
<!DOCTYPE html>
<html>
  <body>
    <div id="parent-element">
      <div></div>
      <div></div>
      <div></div>
    </div>
    <script>
      const parentElement = document.querySelector('#parent-element');

      // 새로운 요소 생성
      const newDiv = document.createElement('div');

      newDiv.classList.add('newDiv');

      // 부모 요소 마지막 자식으로 새로운 요소와 텍스트 추가
      parentElement.append(newDiv, '새로운 텍스트');
    </script>
  </body>
</html>
```

###  **부모요소.prepend(새로운 요소1, 새로운 요소2, '텍스트')**
: 선택한 부모 요소의 **첫 번째 자식으로 복수의 요소나 문자열을 한 번에 추가**


### **부모요소.removeChild(자식요소)**
: 메서드를 사용하여 부모 요소에서 **자식 요소를 제거**

### **요소.remove() **
: 메서드를 사용하여 **자기 자신을 직접 제거**

### **요소.firstChild**
: 특정 요소의 첫 번째 자식 요소 반환