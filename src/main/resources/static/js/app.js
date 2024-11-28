document.addEventListener("DOMContentLoaded", function() {
    const menuButton = document.getElementById('user-menu-button');
    const dropdownMenu = document.getElementById('dropdown-menu');

    // Fonction pour ouvrir/fermer le menu
    menuButton.addEventListener('click', function(event) {
        // Empêcher la propagation du clic au document pour éviter de fermer immédiatement
        event.stopPropagation();

        // Vérifier si le menu est déjà ouvert
        const isOpen = dropdownMenu.classList.contains('show');

        // Toggle l'affichage du menu avec la classe 'show'
        if (isOpen) {
            dropdownMenu.classList.remove('show');
            menuButton.setAttribute('aria-expanded', 'false');
        } else {
            dropdownMenu.classList.add('show');
            menuButton.setAttribute('aria-expanded', 'true');
        }
    });

    // Fermer le menu lorsque l'utilisateur clique en dehors
    document.addEventListener('click', function(event) {
        if (!menuButton.contains(event.target) && !dropdownMenu.contains(event.target)) {
            dropdownMenu.classList.remove('show'); // Retirer la classe 'show' pour cacher le menu
            menuButton.setAttribute('aria-expanded', 'false');
        }
    });

    // Fermer le menu si un item est sélectionné
    dropdownMenu.querySelectorAll('a').forEach(item => {
        item.addEventListener('click', function() {
            dropdownMenu.classList.remove('show'); // Retirer la classe 'show' pour fermer le menu
            menuButton.setAttribute('aria-expanded', 'false');
        });
    });
});
