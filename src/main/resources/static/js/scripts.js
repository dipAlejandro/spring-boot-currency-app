
const darkModeButton = document.getElementById('darkModeButton');
const lightModeButton = document.getElementById('lightModeButton');
const body = document.body;
const navbar = document.querySelector('nav');
const footer = document.querySelector('footer');
const toggleButton = document.getElementById('darkModeToggle');

const updateButtonText = () => {
    if (body.classList.contains('bg-dark')) {
        toggleButton.innerHTML = 'Modo: Claro';
    } else {
        toggleButton.innerHTML = 'Modo: Oscuro';
    }
};

const enableDarkMode = () => {
    body.classList.add('bg-dark', 'text-light');
    body.classList.remove('bg-light', 'text-dark');

    navbar.classList.add('bg-dark', 'text-light');
    navbar.classList.remove('bg-light', 'text-dark');

    footer.classList.add('bg-dark', 'text-light');
    footer.classList.remove('bg-light', 'text-dark');

    localStorage.setItem("theme", "dark");
    updateButtonText();
};

const enableLightMode = () => {
    body.classList.add('bg-light', 'text-dark');
    body.classList.remove('bg-dark', 'text-light');

    navbar.classList.add('bg-light', 'text-dark');
    navbar.classList.remove('bg-dark', 'text-light');

    footer.classList.add('bg-light', 'text-dark');
    footer.classList.remove('bg-dark', 'text-light');
    localStorage.setItem("theme", "light");
    updateButtonText();
};

// Inicializar el estado del tema al cargar la página
const theme = localStorage.getItem("theme");
if (theme === "dark") {
    enableDarkMode();
} else {
    enableLightMode();
}

// Agregar eventos de click a los botones
darkModeButton.addEventListener('click', enableDarkMode);
lightModeButton.addEventListener('click', enableLightMode);

// Inicializar el texto del botón
updateButtonText();