const { sequelize, Sequelize } = require("../models/index");

const QuizAnswer = sequelize.define("QuizAnswer", {
  quiz_answer_id: {
    type: DataTypes.INTEGER,
    primaryKey: true,
    autoIncrement: true,
  },
  quiz_question_id: { type: DataTypes.INTEGER, allowNull: false },
  answer: { type: DataTypes.STRING(255), allowNull: false },
  is_correct: { type: DataTypes.BOOLEAN, allowNull: false },
  //voters: { type: DataTypes.ARRAY(DataTypes.INTEGER), allowNull: true },
  voters: { type: DataTypes.JSON, allowNull: true },
});

QuizQuestion.hasMany(QuizAnswer, { foreignKey: "quiz_question_id" });
QuizAnswer.belongsTo(QuizQuestion, { foreignKey: "quiz_question_id" });

module.exports = QuizAnswer;
