function showGreeting() {
    const name = document.getElementById('name').value;
    const welcomeMessage = document.getElementById('welcomeMessage');
    const greetingDiv = document.getElementById('greeting');
    const nameForm = document.getElementById('nameForm');
    
    if (name) {
        welcomeMessage.textContent = `Hoş geldin, ${name}!`;
        greetingDiv.style.display = 'block';
        nameForm.style.display = 'none';
        showTime();
    } else {
        alert('Lütfen isminizi girin.');
    }
}

function showTime() {
    const timeDiv = document.getElementById('time');
    const now = new Date();
    const options = { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' };
    const dateString = now.toLocaleDateString('tr-TR', options);
    const timeString = now.toLocaleTimeString('tr-TR');

    timeDiv.textContent = `Bugün ${dateString} ve saat ${timeString}`;
}

// Sayfa her yenilendiğinde zamanı güncellemek için bir interval ayarlayalım
setInterval(showTime, 1000);
