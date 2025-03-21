const { Poll, Post } = require("../models");

exports.getAllPolls = async (req, res) => {
  try {
    const polls = await Poll.findAll({ include: [Post] });
    res.status(200).json(polls);
  } catch (error) {
    res
      .status(500)
      .json({ message: "Erreur lors de la récupération des sondages", error });
  }
};

exports.getPollById = async (req, res) => {
  try {
    const poll = await Poll.findByPk(req.params.id, { include: [Post] });
    if (!poll) {
      return res.status(404).json({ message: "Sondage non trouvé" });
    }
    res.status(200).json(poll);
  } catch (error) {
    res
      .status(500)
      .json({ message: "Erreur lors de la récupération du sondage", error });
  }
};

exports.createPoll = async (req, res) => {
  try {
    const { question, is_closed, post_id } = req.body;
    const poll = await Poll.create({ question, is_closed, post_id });
    res.status(201).json(poll);
  } catch (error) {
    res
      .status(500)
      .json({ message: "Erreur lors de la création du sondage", error });
  }
};

exports.updatePoll = async (req, res) => {
  try {
    const poll = await Poll.findByPk(req.params.id);
    if (!poll) {
      return res.status(404).json({ message: "Sondage non trouvé" });
    }
    await poll.update(req.body);
    res.status(200).json(poll);
  } catch (error) {
    res
      .status(500)
      .json({ message: "Erreur lors de la mise à jour du sondage", error });
  }
};

exports.deletePoll = async (req, res) => {
  try {
    const poll = await Poll.findByPk(req.params.id);
    if (!poll) {
      return res.status(404).json({ message: "Sondage non trouvé" });
    }
    await poll.destroy();
    res.status(200).json({ message: "Sondage supprimé" });
  } catch (error) {
    res
      .status(500)
      .json({ message: "Erreur lors de la suppression du sondage", error });
  }
};
