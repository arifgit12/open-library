CREATE TABLE `logs` (
`Date` varchar(200) default NULL,
`Logger` varchar(1000) default NULL,
`Priority` varchar(1000) default NULL,
`Message` varchar(2000) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 

INSERT INTO Paper values (1,"Administrador");
INSERT INTO Role values (1,"Regra de Teste","R_TEST");
INSERT INTO Paper_Role values(1,1);
INSERT INTO Person values (1,"11111","gc@gc.com","Gabriel","1234",1);
INSERT INTO Book values(1,1986,"Eric Evans","Muito Bom","2 Edicao Revisada","Alta Books","/images/",1231233,"Domain-Driven Design",230,"Martin Fowler",3);
INSERT INTO Book values(2,1986,"Eric Evans","Muito Bom","2 Edicao Revisada","Alta Books","/images/",1231233,"Domain-Driven Design",230,"Martin Fowler",3);
INSERT INTO Book values(3,1986,"Eric Evans","Muito Bom","2 Edicao Revisada","Alta Books","/images/",1231233,"Domain-Driven Design",230,"Martin Fowler",3);
INSERT INTO Book values(4,1986,"Eric Evans","Muito Bom","2 Edicao Revisada","Alta Books","/images/",1231233,"Domain-Driven Design",230,"Martin Fowler",3);
INSERT INTO Book values(5,1986,"Eric Evans","Muito Bom","2 Edicao Revisada","Alta Books","/images/",1231233,"Domain-Driven Design",230,"Martin Fowler",3);
