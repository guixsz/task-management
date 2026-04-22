class MeuHeader extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
        <header class="header-container">
            <ul class="nav-link">
                <li><a href="index.html">Create Task</a></li>
                <li><a href="getTasks.html">Tasks</a></li>
                <li><a>Login</a></li>
            </ul>
        </header>
        `;
    }
}
customElements.define('meu-header', MeuHeader);