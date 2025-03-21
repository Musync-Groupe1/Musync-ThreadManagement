"use strict";

/** @type {import('sequelize-cli').Migration} */
module.exports = {
  async up(queryInterface, Sequelize) {
    await queryInterface.createTable("QuizAnswers", {
      quiz_answer_id: {
        type: Sequelize.INTEGER,
        primaryKey: true,
        autoIncrement: true,
      },
      quiz_question_id: {
        type: Sequelize.INTEGER,
        allowNull: false,
        references: {
          model: "QuizQuestions", // Table de la relation
          key: "quiz_question_id", // Clé primaire dans la table 'QuizQuestions'
        },
      },
      answer: {
        type: Sequelize.STRING(255),
        allowNull: false,
      },
      is_correct: {
        type: Sequelize.BOOLEAN,
        allowNull: false,
      },
      voters: {
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
    await queryInterface.dropTable("QuizAnswers");
  },
};
