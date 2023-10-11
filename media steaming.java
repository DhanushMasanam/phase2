messageInput.value
movieInput.value
listItem.textContent
/* styles.css */
#playlist-container, #chat-container {
  width: 300px;
  margin-bottom: 20px;
}

input[type="text"], button {
  display: block;
  margin-bottom: 10px;
}

#playlist li, #chat-messages li {
  margin-bottom: 5px;
}// script.js
document.addEventListener('DOMContentLoaded', function() {
  const playlist = document.getElementById('playlist');
  const addMovieForm = document.getElementById('add-movie-form');
  const movieInput = document.getElementById('movie-input');
  const chatMessages = document.getElementById('chat-messages');
  const chatForm = document.getElementById('chat-form');
  const messageInput = document.getElementById('message-input');
  
  addMovieForm.addEventListener('submit', function(event) {
    event.preventDefault();
    const movie = movieInput.value;
    if (movie) {
      const listItem = document.createElement('li');
      listItem.textContent = movie;
      playlist.appendChild(listItem);
      movieInput.value = '';
    }
  });
  
  chatForm.addEventListener('submit', function(event) {
    event.preventDefault();
    const message = messageInput.value;
    if (message) {
      const listItem = document.createElement('li');
      listItem.textContent = message;
      chatMessages.appendChild(listItem);
      messageInput.value = '';
    }
  });
});
socket.io
const express = require('express');
const app = express();
const http = require('http').createServer(app);
const io = require('socket.io')(http);

app.use(express.static('public'));

io.on('connection', function(socket) {
  console.log('A user connected');

  socket.on('chat message', function(message) {
    io.emit('chat message', message);
  });

  socket.on('disconnect', function() {
    console.log('A user disconnected');
  });
});

http.listen(3000, function() {
  console.log('Server listening on port 3000');
});
