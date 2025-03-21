const { Quiz } = require("../models");

exports.getAllQuizzes = async (req, res) => {
  try {
    const quizzes = await Quiz.findAll({ include: "Posts" });
    res.status(200).json(quizzes);
  } catch (error) {
    res
      .status(500)
      .json({ message: "Erreur lors de la récupération des quizzes", error });
  }
};

exports.getQuizById = async (req, res) => {
  try {
    const quiz = await Quiz.findByPk(req.params.id, { include: "Posts" });
    if (!quiz) {
      return res.status(404).json({ message: "Quiz non trouvé" });
    }
    res.status(200).json(quiz);
  } catch (error) {
    res
      .status(500)
      .json({ message: "Erreur lors de la récupération du quiz", error });
  }
};

exports.createQuiz = async (req, res) => {
  try {
    const { is_launched, participants } = req.body;
    const quiz = await Quiz.create({ is_launched, participants });
    res.status(201).json(quiz);
  } catch (error) {
    res
      .status(500)
      .json({ message: "Erreur lors de la création du quiz", error });
  }
};

exports.updateQuiz = async (req, res) => {
  try {
    const quiz = await Quiz.findByPk(req.params.id);
    if (!quiz) {
      return res.status(404).json({ message: "Quiz non trouvé" });
    }
    const { is_launched, participants } = req.body;
    await quiz.update({ is_launched, participants });
    res.status(200).json(quiz);
  } catch (error) {
    res
      .status(500)
      .json({ message: "Erreur lors de la mise à jour du quiz", error });
  }
};

exports.deleteQuiz = async (req, res) => {
  try {
    const quiz = await Quiz.findByPk(req.params.id);
    if (!quiz) {
      return res.status(404).json({ message: "Quiz non trouvé" });
    }
    await quiz.destroy();
    res.status(200).json({ message: "Quiz supprimé" });
  } catch (error) {
    res
      .status(500)
      .json({ message: "Erreur lors de la suppression du quiz", error });
  }
};
