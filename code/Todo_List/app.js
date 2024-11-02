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
  li_btn_finish.addEventListener('click', async (e) => {
    ob = await changeStatus(ob); // object 데이터 변화

    set_styleText(ob, todo_li);
  });
  set_styleText(ob, todo_li);

  // 삭제 버튼 눌렀을 떄 이벤트
  li_btn_delete.addEventListener('click', async (e) => {
    const response = await deleteOb(ob);
    if (response.ok) {
      todo_li.remove();
    }
  });
}

// 완료 버튼을 누름에 따라 할일 항목에 text 스타일 변화
function set_styleText(ob, todo_li) {
  if (ob.completed) {
    todo_li.style.textDecorationLine = 'line-through';
    todo_li.style.color = 'grey';
  } else {
    todo_li.style.textDecorationLine = '';
    todo_li.style.color = '';
  }
}

// 완료 버튼으로 인한 db.json 데이터 변화시키기
async function changeStatus(ob) {
  const response = await fetch(`http://localhost:3000/todos/${ob.id}`, {
    method: 'PATCH',
    body: JSON.stringify({
      completed: !ob.completed,
    }),
    headers: {
      'Content-type': 'application/json; charset=UTF-8',
    },
  });
  const data = await response.json();
  // console.log(data);
  return data;
}

// db.json 에 데이터 있으면 목록 보여주기
async function initTodos() {
  console.log('Hello World');
  const response = await fetch('http://localhost:3000/todos');

  //할 일 목록이 들어있는 배열
  let todosArr = await response.json();
  // 데이터 있으면 할 일 리스트 생성
  for (let ob of todosArr) {
    todosArr = createLi(ob);
  }
}
// 할 일 추가 버튼 눌렀을 때 이벤트
async function clickAddEvent() {
  const add_todo = document.querySelector('#add-todo');
  const todo_input = document.querySelector('#todo-input');
  add_todo.addEventListener('click', async (e) => {
    const todo = {
      content: todo_input.value,
      completed: false,
    };
    //db.json 데이터 넣기
    addEvent(todo);

    // 추가된 데이터 화면에 보이기
    createLi(todo);
  });
}

// 추가 버튼 눌리면 db.json에 데이터 추가
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

async function deleteOb(ob) {
  const response = await fetch(`http://localhost:3000/todos/${ob.id}`, {
    method: 'DELETE',
  });
  // console.log(response);
  return response;
}

async function main() {
  initTodos();
  clickAddEvent();
}
