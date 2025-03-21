const express = require("express");
const router = express.Router();
const postController = require("../controllers/postController");

// Route pour récupérer tous les posts
router.get("/posts", postController.getAllPosts);

// Route pour récupérer un post par ID
router.get("/posts/:id", postController.getPostById);

// Route pour créer un post
router.post("/posts", postController.createPost);

// Route pour mettre à jour un post
router.put("/posts/:id", postController.updatePost);

// Route pour supprimer un post
router.delete("/posts/:id", postController.deletePost);

module.exports = router;
