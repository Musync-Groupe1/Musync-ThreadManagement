const express = require("express");
const router = express.Router();
const pollController = require("../controllers/pollController");

// Récupérer tous les sondages
router.get("/polls", pollController.getAllPolls);

// Récupérer un sondage par ID
router.get("/polls/:id", pollController.getPollById);

// Créer un sondage
router.post("/polls", pollController.createPoll);

// Mettre à jour un sondage
router.put("/polls/:id", pollController.updatePoll);

// Supprimer un sondage
router.delete("/polls/:id", pollController.deletePoll);

module.exports = router;
