CREATE TABLE book
(
    book_id BIGSERIAL   NOT NULl
        CONSTRAINT book_pk
            PRIMARY KEY,
    title   TEXT        NOT NULL,
    author  TEXT        NOT NULL,
    summary TEXT        NOT NULL,
    isbn    VARCHAR(13) NOT NULL
);

INSERT INTO book(title, author, summary, isbn)
VALUES ('猫島列伝', '名無しのGonbey', '猫島の生き様', '0123456789012'),
       ('猫島列伝II', '名無しのGonbey', '猫島の生き様', '0123456789012');
