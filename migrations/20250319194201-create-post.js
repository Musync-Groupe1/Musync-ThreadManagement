"use strict";
//const Poll = require("./poll");

/** @type {import('sequelize-cli').Migration} */
module.exports = {
  async up(queryInterface, Sequelize) {
    await queryInterface.createTable("Posts", {
      post_id: {
        type: Sequelize.INTEGER,
        primaryKey: true,
        autoIncrement: true,
      },
      author_id: {
        type: Sequelize.INTEGER,
        allowNull: false,
      },
      content: {
        type: Sequelize.STRING(512),
        allowNull: false,
      },
      posted_date: {
        type: Sequelize.DATE,
        allowNull: false,
      },
      user_shared_playlist_id: {
        type: Sequelize.INTEGER,
        allowNull: true, // La colonne peut être nulle
      },
      user_shared_music_id: {
        type: Sequelize.INTEGER,
        allowNull: true, // La colonne peut être nulle
      },
      poll_id: {
        type: Sequelize.INTEGER,
        allowNull: true,
        //references: {
        //  model: "Polls", // Table Poll
        //  key: "poll_id", // Clé primaire de Poll
        //},
      },
      quiz_id: {
        type: Sequelize.INTEGER,
        allowNull: true,
        //references: {
        //  model: "Quiz", // Table Quiz
        //  key: "quiz_id", // Clé primaire de Quiz
        //},
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
    await queryInterface.dropTable("Posts");
  },
};
