
- HTML 문서를 **트리 구조 형태의 객체(Object)로 표현한 것**
- **웹 페이지를 동적으로 조작**하기 위해 브라우저와 JavaScript 사이에서 중간 다리 역할
- DOM을 통해 **요소 선택 및 조작**, **요소의** **속성 변경**, **이벤트 처리 등


### DOM 트리(Tree) 구조와 노드(Node)
	node: DOM 트리에서 각 단위를 의미
- **부모 노드(Parent Node)** : 다른 노드를 **자식을 갖는 노드**
- **자식 노드(Child Node)** : **부모 노드의 하위에 연결된 노드들**
- **형제 노드(Sibling Node)** : **같은 부모 노드를 공유**하는 노드들

### 노드의 종류
- 문서 노드(Document Node) : DOM 트리의 **최상위 노드**로, 문서 전체를 대표
- 요소 노드(Element Node) : **HTML 요소를 나타내며, 다른 노드를 자식으로 가질 수 있음**
- 텍스트 노드(Text Node) : 요소 노드의 콘텐츠인 **텍스트를 나타내는 노드**
- 속성 노드(Attribute Node) : **요소의 속성**을 나타내며, 요소 노드의 일부로 간주
- 주석 노드(Comment Node) : HTML 문서의 **주석**을 나타냄


### 노드의 구조
```HTML
<!DOCTYPE html>
<html>
  <head>
    <title>Document</title>
  </head>
  <body>
    <h1>Hello, World!</h1>
    <p>This is a paragraph.</p>
  </body>
</html>
```

Document
└── html (요소 노드)
    ├── head (요소 노드)
    │   └── title (요소 노드)
    │       └── Text ("Document") (텍스트 노드)
    └── body (요소 노드)
        ├── h1 (요소 노드)
        │   └── Text ("Hello, World!") (텍스트 노드)
        └── p (요소 노드)
            └── Text ("This is a paragraph.") (텍스트 노드)