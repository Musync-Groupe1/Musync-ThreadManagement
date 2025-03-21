const express = require("express");
const router = express.Router();
const commentController = require("../controllers/commentController");

// Récupérer tous les commentaires
router.get("/comments", commentController.getAllComments);

// Récupérer un commentaire par ID
router.get("/comments/:id", commentController.getCommentById);

// Créer un commentaire
router.post("/comments", commentController.createComment);

// Mettre à jour un commentaire
router.put("/comments/:id", commentController.updateComment);

// Supprimer un commentaire
router.delete("/comments/:id", commentController.deleteComment);

module.exports = router;
