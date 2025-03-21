const { sequelize, Sequelize } = require("../models/index");

const Quiz = sequelize.define("Quiz", {
  quiz_id: { type: DataTypes.INTEGER, primaryKey: true, autoIncrement: true },
  is_launched: { type: DataTypes.BOOLEAN, allowNull: false },
  //participants: { type: DataTypes.ARRAY(DataTypes.INTEGER), allowNull: true },
  participants: { type: DataTypes.JSON, allowNull: true },
});

Post.hasOne(Quiz, { foreignKey: "quiz_id" });
Quiz.belongsTo(Post, { foreignKey: "quiz_id" });

Quiz.hasMany(Post, { foreignKey: "quiz_id" });
Post.belongsTo(Quiz, { foreignKey: "quiz_id" });

module.exports = Quiz;
