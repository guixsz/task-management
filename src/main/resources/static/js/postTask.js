let title = document.querySelector('#title')
let description = document.querySelector('#description')
let date = document.querySelector('#date')
let category = document.querySelector('#category')
let locationInput = document.querySelector('#location')
let button = document.querySelector('.btn-post')

button.addEventListener('click', () => {
    fetch('http://localhost:8081/tasks', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            title: title.value,
            description: description.value,
            date: date.value,
            category: category.value,
            location: locationInput.value
        })
    })
        .then(response => response.json())
        .then(data => console.log(data))
        .catch(error => console.log(error))

})
