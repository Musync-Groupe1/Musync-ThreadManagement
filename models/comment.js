const { sequelize, Sequelize } = require("../models/index");
const Post = require("./post");
const Comment = sequelize.define("Comment", {
  comment_id: {
    type: DataTypes.INTEGER,
    primaryKey: true,
    autoIncrement: true,
  },
  content: { type: DataTypes.STRING(2512), allowNull: false },
  posted_date: { type: DataTypes.DATE, allowNull: false },
  author_id: { type: DataTypes.INTEGER, allowNull: false },
  associated_post: { type: DataTypes.INTEGER, allowNull: false },
});

Post.hasMany(Comment, { foreignKey: "associated_post" });
Comment.belongsTo(Post, { foreignKey: "associated_post" });

module.exports = Comment;
