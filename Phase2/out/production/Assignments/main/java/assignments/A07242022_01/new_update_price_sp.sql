delimiter //
create procedure new_update_price (IN author_id int, IN book_id int,  IN new_price integer,
                                   OUT author_name varchar(20) , OUT author_gender varchar(6),
                                   OUT bookname varchar(20), OUT book_num_pages integer )
begin
    select a.authorname, a.gender, b.book_name, b.pages, b.bookId
    into author_name, author_gender, bookname, book_num_pages, book_id
    from author a, book b
    where a.author_id = b.author and b.bookId = book_id and b.author = author_id ;
    update book set price=new_price where book.BookId = book_id  ;
end; //
DELIMITER ;
