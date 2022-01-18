insert into TC_TENNISCOURT (te_courtid, te_isplayable)
values (1, true);

insert into TC_TENNISCOURT (te_courtid, te_isplayable)
values (2, true);

insert into TC_TENNISCOURT (te_courtid, te_isplayable)
values (3, true);

insert into TC_TENNISCOURT (te_courtid, te_isplayable)
values (4, true);

insert into TC_Match (ma_starttime, ma_endtime, ma_te_id)
values ('2007-12-03T10:15:30', '2007-12-03T12:15:30', 1);

insert into TC_Match (ma_starttime, ma_endtime, ma_te_id)
values ('2007-12-06T10:15:30', '2007-12-06T12:15:30', 4);

insert into TC_Match (ma_starttime, ma_endtime, ma_te_id)
values ('2007-12-04T10:15:30', '2007-12-04T12:15:30', 2);

insert into TC_Match (ma_starttime, ma_endtime, ma_te_id)
values ('2007-12-07T10:15:30', '2007-12-07T12:15:30', 1);

insert into TC_MEMBER (me_mail, me_firstname, me_lastname, me_phonenumber, me_password, me_role)
values ('herbert@mail.com', 'Herbert', 'Glas', '089893444444', '$2y$10$9PgmI9VHFo4k49MaQjJNVe/Dm0gPncDprJtHh3Sgrzqtovxc.KXle', 'member');

insert into TC_MEMBER (me_mail, me_firstname, me_lastname, me_phonenumber, me_password, me_role)
values ('mia@gmx.net', 'Mia', 'Stern', '01234455667', '$2y$10$i7mnsnzTiY17nkbU0eCHx.sEzi5iZMd4wp//0s37YQ/./zkV8kcHy', 'admin');

insert into TC_MEMBER (me_mail, me_firstname, me_lastname, me_phonenumber, me_password, me_role)
values ('tessa@gmail.com', 'Tessa', 'Klopf', '9873763782', '$2y$10$2/1J0uY0FlbaxDW4029qR.4zciwHZPfhNmyT3m.QLNxyXR9pSfMcC', 'member');

insert into TC_MEMBER (me_mail, me_firstname, me_lastname, me_phonenumber, me_password, me_role)
values ('max@mein.gmx.net', 'Max', 'Klapf', '87499343264', '$2y$10$l18.13K8UMyKY8DtlbQAb.fkajUTa8gkgZl049C8oUa5u373dYOfS', 'member');

insert into TC_MEMBER (me_mail, me_firstname, me_lastname, me_phonenumber, me_password, me_role)
values ('hubert@mein.gmx.net', 'Hubert', 'Test', '6764589345', '$2y$10$yUWzwAASLeTAVynT7IB8NOfZYR24egh2CFkl6oZCAARThyErt/692', 'admin');

insert into TC_MEMBER (me_mail, me_firstname, me_lastname, me_phonenumber, me_password, me_role)
values ('jakob@gmail.com', 'Jakob', 'Niederberger', '2348477494', '$2y$10$F2GoRQiwWKjeg4flQz/teeTIYktcqf40Kyh676hSPNU9f6YmKO5A.', 'member');

insert into TC_MEMBER (me_mail, me_firstname, me_lastname, me_phonenumber, me_password, me_role)
values ('Doris@gmx.at', 'Doris', 'Kock', '94837594755', '$2y$10$QkLUfZRXX1RmpIlSSUphx.RHxqEE2zGIZk42M.yecL8Nxo29PUgOu', 'admin');

insert into TC_MATCHPLAN (MP_ME_ID, MP_MA_ID)
values(1, 1);

insert into TC_MATCHPLAN (MP_ME_ID, MP_MA_ID)
values(2, 1);

insert into TC_MATCHPLAN (MP_ME_ID, MP_MA_ID)
values(3, 2);

insert into TC_MATCHPLAN (MP_ME_ID, MP_MA_ID)
values(4, 2);

insert into TC_MATCHPLAN (MP_ME_ID, MP_MA_ID)
values(3, 3);

insert into TC_MATCHPLAN (MP_ME_ID, MP_MA_ID)
values(1, 3);

