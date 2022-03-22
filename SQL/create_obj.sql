--admin
create table admin(
nomeadmin varchar2(30) not null,
cognomeadmin varchar2(30) not null,
codadmin varchar2(30) primary key);

--docente

create table docente(
coddocente int primary key,
nomedocente varchar2(30) not null,
cognomedocente varchar2(30) not null,
cvdocente varchar2(200) not null
);

--corsista 
create table corsista(
codcorsista int,
nomecorsista varchar2(30) not null,
cognomecorsista varchar2(30) not null,
precedentiformativi varchar2(30) not null,
constraint p_cod_corsista primary key(codcorsista));

--corso
create table corso(
codcorso int,
nomecorso varchar2(30) not null,
datainiziocorso date not null,
datafinecorso date not null,
costocorso number(8,2) not null,
commenticorso varchar2(100) not null,
aulacorso varchar2(30) not null,
coddocente int not null,
postidisponibili int default 12,
check(postiDisponibili >= 0),
constraint p_cod_corso primary key(codcorso),
constraint f_cod_docente foreign key(coddocente) references docente(coddocente) on delete cascade);

--corsocorsista
create table corso_corsista(
codcorso int,
codcorsista int,
constraint p_cod_cc primary key(codcorso, codcorsista),
constraint f_cod_corso foreign key(codcorso) references corso(codcorso) on delete cascade,
constraint f_cod_corsista foreign key(codcorsista) references corsista(codcorsista) on delete cascade);




--ELENCO CORSISTI
create view report as select
corsista.nomecorsista, corsista.cognomecorsista, corso.nomecorso
from corsista, corso, corso_corsista
where corsista.codcorsista = corso_corsista.codcorsista
and 
corso.codcorso = corso_corsista.codcorso
order by corsista.nomecorsista, corso.codcorso;

--sequenze
create sequence corsista_seq;
create sequence corso_seq;