"use strict";

/** @type {import('sequelize-cli').Migration} */
module.exports = {
  async up(queryInterface, Sequelize) {
    await queryInterface.createTable("PollOptions", {
      poll_option_id: {
        type: Sequelize.INTEGER,
        primaryKey: true,
        autoIncrement: true,
      },
      poll_id: {
        type: Sequelize.INTEGER,
        allowNull: false,
        references: {
          model: "Polls", // Référence à la table Polls
          key: "poll_id", // Clé primaire de la table Polls
        },
        onDelete: "CASCADE", // Si le poll est supprimé, les options de ce poll sont supprimées aussi
      },
      poll_option_content: {
        type: Sequelize.STRING(255),
        allowNull: false,
      },
      voters: {
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
    await queryInterface.dropTable("PollOptions");
  },
};
