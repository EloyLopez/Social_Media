CREATE TABLE friends (
    _id	INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    surname TEXT NOT NULL,
    gender TEXT NOT NULL,
    studies TEXT NOT NULL,
    birthdate DATE NOT NULL,
    friend INTEGER DEFAULT 0
);