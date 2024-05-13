//create DB
use cubyDB

//create collection books
db.createCollection("books")

//insert first book
db.books.insertOne(
    {
        name : "Harry Potter and the goblet of fire",
        author : ["J.K. Rowling"],
        date : new Date("2000-07-08"),
        circulation : 1000
    })

//insert other books
db.books.insertMany([
    {
        name : "The Lord of the Rings: Part I",
        author : ["J.R.R. Tolkien"],
        date : new Date("1954-07-29"),
        circulation : 500
    },
    {
        name : "Двенадцать стульев",
        author : ["Ильф И.Л.","Петров Е.К."],
        date : new Date("1928-01-01"),
        circulation : 1500
    },
    {
        name : "Harry Potter and the prisoner of azkaban",
        author : ["J.K. Rowling"],
        date : new Date("1999-07-08"),
        circulation : 10000
    },
    {
        name : "Book for delete",
        author : ["A.A. Khort"],
        date : new Date("2024-05-13"),
        circulation : 23
    }
    ])

//find all books
db.books.find()

//delete book
db.books.deleteOne({author: "A.A. Khort"})

//find all books
db.books.find()

//search books by author
db.books.find({author: "J.K. Rowling"})

//search books by author and circulation > 2000
db.books.find({author: "J.K. Rowling", circulation: {$gt : 2000}})

//update circulation in one book
db.books.updateOne({name: "The Lord of the Rings: Part I"}, {$set: {circulation: 1500}})

//search books by circulation >= 1500
db.books.find({circulation: {$gte : 1500}})

