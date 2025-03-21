const { Post } = require("../models/post");

exports.getAllPosts = async (req, res) => {
  try {
    const posts = await Post.findAll({
      include: ["author", "Poll"], // Inclure les informations liées à User (author) et Poll
    });
    res.status(200).json(posts);
  } catch (error) {
    res
      .status(500)
      .json({ message: "Erreur lors de la récupération des posts", error });
  }
};

exports.getPostById = async (req, res) => {
  try {
    const post = await Post.findByPk(req.params.id, {
      include: ["author", "Poll"], // Inclure les informations liées à User (author) et Poll
    });
    if (!post) {
      return res.status(404).json({ message: "Post non trouvé" });
    }
    res.status(200).json(post);
  } catch (error) {
    res
      .status(500)
      .json({ message: "Erreur lors de la récupération du post", error });
  }
};

exports.createPost = async (req, res) => {
  try {
    const { author_id, content, posted_date, poll_id, quiz_id } = req.body;
    const post = await Post.create({
      author_id,
      content,
      posted_date,
      poll_id,
      quiz_id,
    });
    res.status(201).json(post);
  } catch (error) {
    res
      .status(500)
      .json({ message: "Erreur lors de la création du post", error });
  }
};

exports.updatePost = async (req, res) => {
  try {
    const post = await Post.findByPk(req.params.id);
    if (!post) {
      return res.status(404).json({ message: "Post non trouvé" });
    }
    const { content, poll_id, quiz_id } = req.body;
    await post.update({ content, poll_id, quiz_id });
    res.status(200).json(post);
  } catch (error) {
    res
      .status(500)
      .json({ message: "Erreur lors de la mise à jour du post", error });
  }
};

exports.deletePost = async (req, res) => {
  try {
    const post = await Post.findByPk(req.params.id);
    if (!post) {
      return res.status(404).json({ message: "Post non trouvé" });
    }
    await post.destroy();
    res.status(200).json({ message: "Post supprimé" });
  } catch (error) {
    res
      .status(500)
      .json({ message: "Erreur lors de la suppression du post", error });
  }
};
