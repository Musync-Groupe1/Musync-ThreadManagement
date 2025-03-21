const { sequelize, Sequelize } = require("../models/index");
const { DataTypes } = require("sequelize");
const Post = sequelize.define("Post", {
  post_id: { type: DataTypes.INTEGER, primaryKey: true, autoIncrement: true },
  author_id: { type: DataTypes.INTEGER, allowNull: false },
  content: { type: DataTypes.STRING(512), allowNull: false },
  posted_date: { type: DataTypes.DATE, allowNull: false },
  user_shared_playlist_id: { type: DataTypes.INTEGER },
  user_shared_music_id: { type: DataTypes.INTEGER },
  poll_id: {
    type: DataTypes.INTEGER,
    allowNull: true,
    references: {
      model: "Polls", // Référence à la table Polls
      key: "poll_id", // Clé primaire de Poll
    },
  },
  quiz_id: {
    type: DataTypes.INTEGER,
    allowNull: true,
    references: {
      model: "Quiz", // Référence à la table Polls
      key: "quiz_id", // Clé primaire de Poll
    },
  },
});

// Relation entre Post et User
User.hasMany(Post, { foreignKey: "author_id" });
Post.belongsTo(User, { foreignKey: "author_id" });

// Relation entre Post et Poll : Un Post appartient à un Poll
Post.belongsTo(Poll, { foreignKey: "poll_id" });

module.exports = Post;
