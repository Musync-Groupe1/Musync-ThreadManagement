const express = require("express");
const router = express.Router();
const quizController = require("../controllers/quizController");

// Récupérer tous les quizzes
router.get("/quiz", quizController.getAllQuiz);

// Récupérer un quiz par ID
router.get("/quiz/:id", quizController.getQuizById);

// Créer un quiz
router.post("/quiz", quizController.createQuiz);

// Mettre à jour un quiz
router.put("/quiz/:id", quizController.updateQuiz);

// Supprimer un quiz
router.delete("/quiz/:id", quizController.deleteQuiz);

module.exports = router;
