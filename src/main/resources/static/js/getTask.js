fetch('http://localhost:8081/tasks')
    .then(response => response.json())
    .then((tasks) =>  {
        console.log('tasks', tasks)
        for(let task of tasks) {
            createCardTask(task)
        }
})


function createCardTask(task) {
    const main = document.querySelector('#app')

    const card = document.createElement('div')
    card.className = 'card'

    const title = document.createElement('h2')
    title.textContent = task.title
    title.className = 'data-title'

    const description = document.createElement('p')
    description.textContent = task.description
    description.className = 'data-description'

    const taskDate = document.createElement('p')
    taskDate.textContent = task.date
    taskDate.className = 'data-date'

    const taskLocation = document.createElement('p')
    taskLocation.textContent = task.location
    taskLocation.className = 'data-location'

    const category = document.createElement('p')
    category.textContent = task.category
    category.className = 'data-category'
    iconData(category, task)


    const hour = document.createElement('p')
    hour.textContent = task.hour
    hour.className = 'data-hour'

    card.appendChild(title)
    card.appendChild(description)
    card.appendChild(taskDate)
    card.appendChild(taskLocation)
    card.appendChild(hour)
    card.appendChild(category)


    main.appendChild(card)
}

function iconData(category, task) {
    if(task.category === 'DENTIST') {
        category.classList.add('data-dentist')
    }   else if (task.category === 'HEALTH') {
            category.classList.add('data-health')
    }   else if (task.category == 'EVENTS') {
            category.classList.add('data-events')
    }
}