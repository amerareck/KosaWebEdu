select * from book;

"SELECT TRUNC(AVG(price)) AS price, class_title FROM book, book_class WHERE book.class = book_class.class GROUP BY class_title ORDER BY class";

SELECT TRUNC(AVG(price)) AS price, class_title FROM book, book_class WHERE book.class = book_class.id GROUP BY class_title ORDER BY class_title