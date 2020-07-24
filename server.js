'use strict';

const express = require('express');

// server basic setting
const PORT = 8080;
const HOST = '0.0.0.0';

// home app
const app = express();
app.get('/', (req, res) => {
  res.send('Hello World');
});

app.listen(PORT, HOST);
console.log(`Running on http://${HOST}:${PORT}`);
