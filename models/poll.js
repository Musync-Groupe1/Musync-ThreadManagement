const { sequelize, Sequelize } = require("../models/index");

const Poll = sequelize.define("Poll", {
  poll_id: { type: DataTypes.INTEGER, primaryKey: true, autoIncrement: true },
  question: { type: DataTypes.STRING(255), allowNull: false },
  is_closed: { type: DataTypes.BOOLEAN, allowNull: false },
});

//Post.hasOne(Poll, { foreignKey: "poll_id" });
//Poll.belongsTo(Post, { foreignKey: "poll_id" });
//
//Poll.hasMany(Post, { foreignKey: "poll_id" });
//Post.belongsTo(Poll, { foreignKey: "poll_id" });

module.exports = Poll;
