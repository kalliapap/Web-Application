/*--------------------------------------*/
/*       Papanastou Kalliopi            */
/*				SELECT					*/
/*--------------------------------------*/

/* Phenotype - gene relationship */
SELECT g.location, p.phenotypeTitle, p.phenotypeID, a.inheritance, a.phenotypeMappingKey,
g.geneSymbol, g.geneID
 from a_phenotype p join a_phenoGeneAssoc a on
	p.phenotypeID=a.pheno
    join a_gene g on g.geneID=a.gene
    where a.pheno = "219700"; 

/* Gene - phenotype relationship */
SELECT a.gid,  g.location, p.phenoTitle, a.altPhenName,  p.inheritance,
 p.phenotypeMappingKey
 from a_altPhen a  join a_phenoGeneAssoc p on
	p.gene=a.gid and a.altPhenName = p.pheno
    join a_gene g on a.gid = g.geneID
    where a.gid = "602421"; 
 
/* Επιπλέον φαινότυποι για το γονίδιο 602421 */ 
select * from a_altPhen where gid="602421";    

/* Εναλλακτικά ονόματα φαινοτύπων */
select * from a_phenotypeNames;

/* Εναλλακτικά ονόματα γονιδίων */
select * from a_geneNames;
	


