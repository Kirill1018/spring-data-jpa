insert into contact(id, first_name, last_name,
birth_date, version) values(3, 'name0', 'lastName0',
'2015-07-08', 0);
insert into contact(id, first_name, last_name,
birth_date, version) values(8, 'name1', 'lastName1',
'2014-09-01', 0);
insert into contact(id, first_name, last_name,
birth_date, version) values(10, 'name2', 'lastName2',
'2014-05-01', 0);
insert into contact(id, first_name, last_name,
birth_date, version) values(11, 'name3', 'lastName3',
'2016-09-02', 0);
insert into contact(id, first_name, last_name,
birth_date, version) values(12, 'name4', 'lastName4',
'2015-11-01', 0);
insert into contact(id, first_name, last_name,
birth_date, version) values(13, 'name5', 'lastName5',
'2012-09-07', 0);
insert into contact_tel_detail(id, contact_id, tel_type,
tel_number, version) values(1, 3, 'домашний телефон',
'8-800-200-600', 0);
insert into contact_tel_detail(id, contact_id, tel_type,
tel_number, version) values(3, 3, 'рабочий телефон',
'555-44-33', 0);
insert into hobby(hobby_id) values('football');
insert into hobby(hobby_id) values('movies');
insert into hobby(hobby_id) values('swimming');
insert into contact_hobby_detail(contact_id, hobby_id) values(8, 'football');
insert into contact_hobby_detail(contact_id, hobby_id) values(13, 'football');
insert into contact_hobby_detail(contact_id, hobby_id) values(11, 'movies');
insert into contact_hobby_detail(contact_id, hobby_id) values(8, 'swimming');