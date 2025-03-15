const Sequelize = require('sequelize');
module.exports = new Sequelize('threadmusync', 'user', 'pwd', {
 host: 'localhost',
 dialect: 'mysql', // Change to your database type
});