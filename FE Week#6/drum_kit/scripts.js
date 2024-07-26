document.addEventListener('DOMContentLoaded', function() {
    const buttons = document.querySelectorAll('.drum');
    
    buttons.forEach(button => {
        button.addEventListener('click', () => {
            playSound(button);
        });
    });

    document.addEventListener('keydown', (event) => {
        const key = event.key.toLowerCase();
        const button = document.querySelector(`.drum[data-key="${key}"]`);
        if (button) {
            playSound(button);
        }
    });
});

function playSound(button) {
    const sound = new Audio(button.getAttribute('data-sound'));
    sound.addEventListener('canplaythrough', () => {
        sound.play();
        animateButton(button);
    });
    sound.addEventListener('error', (e) => {
        console.error(`Error playing sound: ${e}`);
    });
}


function animateButton(button) {
    button.classList.add('playing');
    setTimeout(() => {
        button.classList.remove('playing');
    }, 100);
}
