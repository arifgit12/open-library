CREATE TABLE `logs` (
`Date` varchar(200) default NULL,
`Logger` varchar(1000) default NULL,
`Priority` varchar(1000) default NULL,
`Message` varchar(2000) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 

INSERT INTO paper values (1,"Administrador");
INSERT INTO role values (1,"Regra de Teste","R_TEST");
INSERT INTO paper_role values(1,1);
INSERT INTO person values (1,"11111","gc@gc.com","Gabriel","1234",1);
