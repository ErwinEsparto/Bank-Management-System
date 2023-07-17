/**
 *
 * @author Sean Paula Estayan
 */
create database bankmanagementsystem;

create table accounts(
Firstname varchar (50) not null,
Lastname varchar (50) not null,
EmailAddress varchar (50) not null,
Banknumber int primary key,
Password varchar (50) not null,
Type varchar (20) not null,
Cash double not null,
DateCreated date not null
);

insert into accounts (Firstname, Lastname, EmailAddress, Banknumber, Password, Type, Cash, DateCreated)
values ("Sean Paula", "Estayan", "spestayan@gmail.com", 1,  123, "Admin", 0.00, current_date()),
("Erwin", "Esparto", "eesparto@gmail.com", 2, 456, "Admin", 0.00, current_date());

insert into accounts (Firstname, Lastname, EmailAddress, Banknumber, Password, Type, Cash, DateCreated)
values ("Mekaila", "Aguila", "maguila@gmail.com", 3, 789, "Admin", 0.00, current_date()),
("Rose Joy", "Balonzo", "rjbalonzo@gmail.com", 4 , 987, "Admin", 0.00, current_date()),
("Andrei", "Bodota", "abodota@gmail.com", 5, 654, "Admin", 0.00, current_date());

insert into accounts (Firstname, Lastname, EmailAddress, Banknumber, Password, Type, Cash, DateCreated)
values ("Customer", "A", "customera@gmail.com", 20200101, 12345, "Customer", 0.00, current_date());

insert into accounts (Firstname, Lastname, EmailAddress, Banknumber, Password, Type, Cash, DateCreated)
values ("Customer", "B", "customerb@gmail.com", 20210101, 54321, "Customer", 0.00, current_date());

Select * from accounts;