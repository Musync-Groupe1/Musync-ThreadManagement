const { Comment, Post, User } = require("../models");

exports.getAllComments = async (req, res) => {
  try {
    const comments = await Comment.findAll({ include: [Post, User] });
    res.status(200).json(comments);
  } catch (error) {
    res
      .status(500)
      .json({
        message: "Erreur lors de la récupération des commentaires",
        error,
      });
  }
};

exports.getCommentById = async (req, res) => {
  try {
    const comment = await Comment.findByPk(req.params.id, {
      include: [Post, User],
    });
    if (!comment) {
      return res.status(404).json({ message: "Commentaire non trouvé" });
    }
    res.status(200).json(comment);
  } catch (error) {
    res
      .status(500)
      .json({
        message: "Erreur lors de la récupération du commentaire",
        error,
      });
  }
};

exports.createComment = async (req, res) => {
  try {
    const { content, posted_date, author_id, post_id } = req.body;
    const comment = await Comment.create({
      content,
      posted_date,
      author_id,
      post_id,
    });
    res.status(201).json(comment);
  } catch (error) {
    res
      .status(500)
      .json({ message: "Erreur lors de la création du commentaire", error });
  }
};

exports.updateComment = async (req, res) => {
  try {
    const comment = await Comment.findByPk(req.params.id);
    if (!comment) {
      return res.status(404).json({ message: "Commentaire non trouvé" });
    }
    const { content } = req.body;
    await comment.update({ content });
    res.status(200).json(comment);
  } catch (error) {
    res
      .status(500)
      .json({ message: "Erreur lors de la mise à jour du commentaire", error });
  }
};

exports.deleteComment = async (req, res) => {
  try {
    const comment = await Comment.findByPk(req.params.id);
    if (!comment) {
      return res.status(404).json({ message: "Commentaire non trouvé" });
    }
    await comment.destroy();
    res.status(200).json({ message: "Commentaire supprimé" });
  } catch (error) {
    res
      .status(500)
      .json({ message: "Erreur lors de la suppression du commentaire", error });
  }
};
