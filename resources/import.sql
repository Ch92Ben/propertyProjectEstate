-- #1 Book id=1, Publisher 1, Author 1-4
insert into AUTHOR (ID, FIRSTNAME, LASTNAME, BIOGRAPHY) values (AUTHOR_SEQ.nextval, 'Eric', 'Freeman', 'A computer scientist, author and constituent of the Lifestreaming concept.');
insert into AUTHOR (ID, FIRSTNAME, LASTNAME, BIOGRAPHY) values (AUTHOR_SEQ.nextval, 'Elisabeth', 'Robson', 'Internet technology expert, technology manager, author');
insert into AUTHOR (ID, FIRSTNAME, LASTNAME, BIOGRAPHY) values (AUTHOR_SEQ.nextval, 'Bert', 'Bates', ' Co-authored several bestselling Java books and acted as a lead developer for many of Sun''s Java certification exams');
insert into AUTHOR (ID, FIRSTNAME, LASTNAME, BIOGRAPHY) values (AUTHOR_SEQ.nextval, 'Kathy', 'Sierra', 'An American programming instructor and game developer');

insert into ADDRESS (id, housenumber, street, city, postcode) values (ADDRESS_SEQ.nextval, '5', 'St Georges', 'Farnham','GU9 7LW');
insert into PUBLISHER (ID, NAME, ADDRESS_ID) values (PUBLISHER_SEQ.nextval, 'O''Reilly Media', 1);

insert into BOOK (DTYPE, ID, TITLE, ISBN, PAGES, PRICE, PUBLICATIONTYPE, PUBLISHEDDATE, PUBLISHER_ID) values ('Book', BOOK_SEQ.nextval, 'Design patterns', '978-0201633610', 412, 32.48, 'HARDBACK', TO_DATE('1994/10/31', 'yyyy/mm/dd'), 1);

insert into BOOK_AUTHORS (BOOK_ID, AUTHORS_ID) values (1, 1);
insert into BOOK_AUTHORS (BOOK_ID, AUTHORS_ID) values (1, 2);
insert into BOOK_AUTHORS (BOOK_ID, AUTHORS_ID) values (1, 3);
insert into BOOK_AUTHORS (BOOK_ID, AUTHORS_ID) values (1, 4);

-- #2 Periodical id=2 Publisher 2
insert into ADDRESS (id, housenumber, street, city, postcode) values (ADDRESS_SEQ.nextval, '20', 'Baldwin Road', 'Shelter Island','NY 11964');
insert into PUBLISHER (ID, NAME, ADDRESS_ID) values (PUBLISHER_SEQ.nextval, 'Manning Publications', 2);
insert into BOOK (DTYPE, ID, TITLE, ISBN, PAGES, PRICE, PUBLICATIONTYPE, PUBLISHEDDATE, PUBLICATIONPERIOD, PUBLISHER_ID) values ('Periodical', BOOK_SEQ.nextval, 'Linux monthly', '987-0192837465', 121, 10.99, 'PAPERBACK', TO_DATE('2010/01/01', 'yyyy/mm/dd'), 1, 2);
insert into BOOK_AUTHORS (BOOK_ID, AUTHORS_ID) values (2, 3);


insert into USERS (ID, USERNAME, PASSWORD) values (USERS_SEQ.nextval, 'david', 'password');

--- Specific data for tests e.g. sort by name
insert into AUTHOR (ID, FIRSTNAME, LASTNAME, BIOGRAPHY) values (AUTHOR_SEQ.nextval, 'AAA', 'AAA', 'AAA');

