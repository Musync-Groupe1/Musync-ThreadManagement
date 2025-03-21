module.exports = {
  target: "node", // Permet d'ignorer les modules built-in de Node.js
  entry: "./index.js", // Change selon ton point d'entrée
  output: {
    filename: "bundle.js",
    path: __dirname + "/dist",
  },
};
