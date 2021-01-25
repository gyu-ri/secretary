const addButton = document.querySelector('#add-button');

addButton.addEventListener('click', () => {
    const input = document.querySelector('#input');
    const text = input.value.trim();

    if (text !== '') {
        addToList(text);
        input.value = '';
        input.focus();
    }
});

function addToList(text) {
    const list = document.querySelector('#list');

    const newLisltem = document.createElement('li');//새로운 li요소를 만듦
    newLisltem.classList.add('list-item');//list-item 클래스를 더해줌

    newLisltem.innerHTML = text; //사용자 입력 문자를 li사이에 넣음

    list.appendChild(newLisltem);//리스트에 새로 만든 li를 추가가
}