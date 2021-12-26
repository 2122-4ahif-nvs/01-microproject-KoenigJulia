insert into TC_TENNISCOURT (te_courtid)
values (1);

insert into TC_TENNISCOURT (te_courtid)
values (2);

insert into TC_TENNISCOURT (te_courtid)
values (3);

insert into TC_TENNISCOURT (te_courtid)
values (4);

insert into TC_Match (ma_playtime, ma_te_id)
values ('2007-12-03T10:15:30', 1);

insert into TC_Match (ma_playtime, ma_te_id)
values ('2007-12-03T10:15:30', 4);

insert into TC_Match (ma_playtime, ma_te_id)
values ('2007-12-03T10:15:30', 2);

insert into TC_Match (ma_playtime, ma_te_id)
values ('2007-12-03T10:15:30', 1);

insert into TC_TRAININGSSESSION (ts_trainingstime, ts_te_id)
values ('2007-12-03T10:15:30', 3);

insert into TC_TRAININGSSESSION (ts_trainingstime, ts_te_id)
values ('2007-12-03T10:15:30', 3);

insert into TC_TRAININGSSESSION (ts_trainingstime, ts_te_id)
values ('2007-12-03T10:15:30', 4);

insert into TC_TRAININGSSESSION (ts_trainingstime, ts_te_id)
values ('2007-12-03T10:15:30', 2);

insert into TC_MEMBER (me_trainer, me_mail, me_firstname, me_lastname, me_phonenumber, me_ma_id, me_ts_id)
values (true, 'herbert@mail.com', 'Herbert', 'Glas', '089893444444', null, 1);

insert into TC_MEMBER (me_trainer, me_mail, me_firstname, me_lastname, me_phonenumber, me_ma_id, me_ts_id)
values (false, 'mia@gmx.net', 'Mia', 'Stern', '01234455667', 2, 3);

insert into TC_MEMBER (me_trainer, me_mail, me_firstname, me_lastname, me_phonenumber, me_ma_id, me_ts_id)
values (true, 'tessa@gmail.com', 'Tessa', 'Klopf', '9873763782', 4, null);

insert into TC_MEMBER (me_trainer, me_mail, me_firstname, me_lastname, me_phonenumber, me_ma_id, me_ts_id)
values (true, 'max@mein.gmx.net', 'Max', 'Klapf', '87499343264', 1, 4);