create table Person (
	id bigserial not null primary key,
    full_name VARCHAR(50) not null,
	email VARCHAR(50) not null,
	currency VARCHAR(10) not null,
	country VARCHAR(50),
    owe int,
    lent int
);

insert into Person (id, full_name, email, currency, country, owe, lent) values (1, 'Nico Robin', 'ajenney0@samsung.com', 'EUR', 'Palestinian Territory', 0, 0);
insert into Person (id, full_name, email, currency, country, owe, lent) values (2, 'Tony Tony Chopper', 'zkelson1@furl.net', 'EUR', 'China', 0, 0);
insert into Person (id, full_name, email, currency, country, owe, lent) values (3, 'Charlotte Katakuri', 'cbangiard2@umich.edu', 'EUR', 'Peru', 0, 0);
insert into Person (id, full_name, email, currency, country, owe, lent) values (4, 'Kozuki Oden', 'fambroisin3@ocn.ne.jp', 'EUR', 'China', 0, 0);
insert into Person (id, full_name, email, currency, country, owe, lent) values (5, 'Monkey D. Garp', 'mdulin4@toplist.cz', 'EUR', 'China', 0, 0);
insert into Person (id, full_name, email, currency, country, owe, lent) values (6, 'Boa Hancock', 'jleprovest5@woothemes.com', 'EUR', 'France', 0, 0);
insert into Person (id, full_name, email, currency, country, owe, lent) values (7, 'Silvers Rayleigh', 'ejoris6@irs.gov', 'EUR', 'Sweden', 0, 0);
insert into Person (id, full_name, email, currency, country, owe, lent) values (8, 'Monkey D. Luffy', 'jabbott7@army.mil', 'EUR', 'Indonesia', 0, 0);
insert into Person (id, full_name, email, currency, country, owe, lent) values (9, 'Vinsmoke Sanji', 'pschurcke8@addthis.com', 'EUR', 'Malaysia', 0, 0);
insert into Person (id, full_name, email, currency, country, owe, lent) values (10, 'Roronoa Zoro', 'mdurak9@ucsd.edu', 'EUR', 'Portugal', 0, 0);

create table Expenses (
	id bigserial not null primary key,
	comment VARCHAR(50),
    category Varchar(4),
	create_date Date not null default current_date,
	amount numeric(7,3) not null,
    currency VARCHAR(10) not null,
    payer_id INT not null,
    split_type varchar(50) not null,
    constraint fk_payer foreign key(payer_id) references Person(id)
);
insert into Expenses (id, comment, createDate, amount, currency, payer_id, split_type) values (1, 'Some comment', '2023-02-02', '169.36'z, "EUR", 1, 0);

create table Friend (
	id bigserial not null primary key,
	friend_one INT not null,
	friend_two INT not null,
	expenses_id INT,
    constraint fk_one foreign key(friend_one) references Person(id),
    constraint fk_two foreign key(friend_two) references Person(id),
    constraint fk_expenses foreign key(expenses_id) references Expenses(id)
);
insert into Friend (id, friend_one, friend_two, expenses_id) values (1, 1, 2, null);
insert into Friend (id, friend_one, friend_two, expenses_id) values (2, 1, 8, null);
insert into Friend (id, friend_one, friend_two, expenses_id) values (3, 2, 4, null);
insert into Friend (id, friend_one, friend_two, expenses_id) values (4, 2, 8, null);
insert into Friend (id, friend_one, friend_two, expenses_id) values (5, 3, 7, null);
insert into Friend (id, friend_one, friend_two, expenses_id) values (6, 4, 7, null);
insert into Friend (id, friend_one, friend_two, expenses_id) values (7, 5, 3, null);
insert into Friend (id, friend_one, friend_two, expenses_id) values (8, 6, 9, null);
insert into Friend (id, friend_one, friend_two, expenses_id) values (9, 7, 10, null);
insert into Friend (id, friend_one, friend_two, expenses_id) values (10, 8, 6, null);

create table GroupVariety (
	id bigserial not null primary key,
	groupvar_name VARCHAR(50) not null,
	create_date Date not null default current_date,
    expenses_done boolean not null
);
insert into GroupVariety (id, groupvar_name, create_date, expenses_done) values (1, 'Nico-community', '2023-02-01', TRUE);
insert into GroupVariety (id, groupvar_name, create_date, expenses_done) values (2, 'Silverse-group', '2023-02-06', TRUE);

create table GroupMember (
	id bigserial not null primary key,
	groupvar_id INT not null,
	person_id INT not null,
    constraint fk_group foreign key(groupvar_id) references GroupVariety(id),
    constraint fk_person foreign key(person_id) references Person(id)
);
insert into GroupMember (id, groupvar_id, person_id) values (1, 1, 1);
insert into GroupMember (id, groupvar_id, person_id) values (2, 1, 2);
insert into GroupMember (id, groupvar_id, person_id) values (3, 1, 3);
insert into GroupMember (id, groupvar_id, person_id) values (4, 2, 7);
insert into GroupMember (id, groupvar_id, person_id) values (5, 2, 8);
insert into GroupMember (id, groupvar_id, person_id) values (6, 2, 9);





