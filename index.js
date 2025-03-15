const express = require('express')
const app = express()
const port = 3000


const postRouter = require('./routes/Posts');
app.use("/posts", postRouter);


app.listen(port, () => {
    console.log(`Server is running on port ${port}`)
}
)

