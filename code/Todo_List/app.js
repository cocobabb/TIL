// API 베이스 URL
const URL = 'http://localhost:3000/todos';

// DOMContentLoaded : HTML 문서 로딩이 끝나면 실행되는 이벤트
// 페이지가 로드되면 Todo 목록 초기화 함수를 실행한다.
document.addEventListener('DOMContentLoaded', main);

// 리스트 할 일 항목 만드는 함수
async function createLi(ob) {
  const todo_list = document.querySelector('#todo-list');
  const todo_li = document.createElement('li');
  todo_li.textContent = `${ob.content}`;
  todo_list.append(todo_li);

  const li_btn_finish = document.createElement('button');
  const li_btn_delete = document.createElement('button');

  li_btn_finish.textContent = '완료';
  li_btn_delete.textContent = '삭제';
  todo_li.append(li_btn_finish, li_btn_delete);

  // 완료 버튼 눌렀을 때 이벤트
  li_btn_finish.addEventListener('click', (e) => {
    todo_li.classList.toggle('finish');
    if (todo_li.classList.contains('finish')) {
      todo_li.style.textDecorationLine = 'line-through';
      todo_li.style.color = 'grey';
    } else {
      todo_li.style.textDecorationLine = '';
      todo_li.style.color = '';
    }
  });
}

// db.json 에 데이터 있으면 목록 보여주기
async function initTodos() {
  console.log('Hello World');
  const response = await fetch('http://localhost:3000/todos');
  const todosArr = await response.json(); //할 일 목록이 들어있는 배열
  // 데이터 있으면 할 일 리스트 생성
  for (let ob of todosArr) {
    createLi(ob);
  }
}
// 할 일 추가 버튼 눌렀을 때 이벤트
async function clickEvent() {
  const add_todo = document.querySelector('#add-todo');
  const todo_input = document.querySelector('#todo-input');
  add_todo.addEventListener('click', async (e) => {
    const todo = {
      content: todo_input.value,
      completed: false,
    };
    addEvent(todo); //db.json 데이터 넣기
    createLi(todo); // 추가된 데이터 화면에 보이기
  });
}

// 버튼 눌리면 db.json에 데이터 추가
async function addEvent(todo) {
  const response = await fetch('http://localhost:3000/todos', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(todo),
  });
  const addTodo = await response.json();
  return addTodo;
}

async function main() {
  initTodos();
  clickEvent();
}
