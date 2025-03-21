const express = require("express");
const app = express();
const port = 3000;

const postRouter = require("./routes/post");
app.use("/posts", postRouter);

const pollRouter = require("./routes/poll");
app.use("/poll", pollRouter);

const commentRouter = require("./routes/comment");
app.use("/comment", commentRouter);

const quizRouter = require("./routes/quiz");
app.use("/quiz", quizRouter);

const userRouter = require("./routes/user");
app.use("/user", userRouter);

app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});
