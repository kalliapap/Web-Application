/*-----------------------------*/
/* 		Papanastou Kalliopi	   */
/*		CREATE TABLES		   */
/*-----------------------------*/


drop table a_altPhen;
drop table a_phenoGeneAssoc;
drop table a_phenotypeNames;
drop table a_geneNames;
drop table a_phenotype;
drop table a_gene;

create table a_phenotype
(
phenotypeID varchar(10) primary key,
phenotypeTitle varchar(100),
description varchar(1000),
phenText varchar(1000)
);

create table a_gene
(
geneID varchar(20) primary key,
geneSymbol varchar(20),
geneTitle varchar(100),
location varchar(7),
description varchar(1000),
coordinates varchar(40)
);

create table a_phenotypeNames
(
phenoID varchar(10),
phenotypeName varchar(100),
primary key(phenoID, phenotypeName),
foreign key(phenoID) references a_phenotype(phenotypeID) on delete cascade
);

create table a_geneNames
(
gid varchar(20),
geneName varchar(100),
primary key(gid, geneName),
foreign key(gid) references a_gene(geneID) on delete cascade
);

create table a_phenoGeneAssoc
(
pheno varchar(10),
gene varchar(20),
phenoTitle varchar(100),
inheritance varchar(3),
phenotypeMappingKey numeric(1),
primary key(pheno,gene,phenoTitle),
foreign key(pheno) references a_phenotype(phenotypeID) on delete cascade,
foreign key(gene) references a_gene(geneID) on delete cascade
);

create table a_altPhen
( 
gid varchar(20),
altPhenName varchar(100),
primary key(gid,altPhenName),
foreign key(gid) references a_gene(geneID) on delete cascade
);





