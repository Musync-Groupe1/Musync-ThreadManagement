const { sequelize, Sequelize } = require("../models/index");

const QuizQuestion = sequelize.define("QuizQuestion", {
  quiz_question_id: {
    type: DataTypes.INTEGER,
    primaryKey: true,
    autoIncrement: true,
  },
  quiz_id: { type: DataTypes.INTEGER, allowNull: false },
  question: { type: DataTypes.STRING(255), allowNull: false },
  //answers: { type: DataTypes.ARRAY(DataTypes.INTEGER), allowNull: true },
  answers: { type: DataTypes.JSON, allowNull: true },
});

Quiz.hasMany(QuizQuestion, { foreignKey: "quiz_id" });
QuizQuestion.belongsTo(Quiz, { foreignKey: "quiz_id" });

module.exports = QuizQuestion;
