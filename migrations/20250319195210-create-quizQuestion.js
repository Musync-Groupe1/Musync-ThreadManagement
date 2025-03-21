"use strict";

/** @type {import('sequelize-cli').Migration} */
module.exports = {
  async up(queryInterface, Sequelize) {
    await queryInterface.createTable("QuizQuestions", {
      quiz_question_id: {
        type: Sequelize.INTEGER,
        primaryKey: true,
        autoIncrement: true,
      },
      quiz_id: {
        type: Sequelize.INTEGER,
        allowNull: false,
        references: {
          model: "Quiz", // Table de la relation
          key: "quiz_id", // Clé primaire dans la table 'Quizzes'
        },
      },
      question: {
        type: Sequelize.STRING(255),
        allowNull: false,
      },
      answers: {
        //type: Sequelize.ARRAY(Sequelize.INTEGER),
        type: Sequelize.JSON,
        allowNull: true,
      },
      createdAt: {
        type: Sequelize.DATE,
        allowNull: false,
        defaultValue: Sequelize.fn("now"),
      },
      updatedAt: {
        type: Sequelize.DATE,
        allowNull: false,
        defaultValue: Sequelize.fn("now"),
      },
    });
  },

  async down(queryInterface, Sequelize) {
    await queryInterface.dropTable("QuizQuestions");
  },
};
