/*---------------------------------------*/
/* 		   Papanastou Kalliopi	  		 */
/*			  INSERT 306700				 */
/*---------------------------------------*/
insert into a_phenotype(phenotypeID, phenotypeTitle, description)
	values("306700","Hemophilia A", "Hemophilia A is an X-linked recessive 
    bleeding disorder caused by a deficiency in the activity of coagulation 
    factor VIII. The disorder is clinically heterogeneous with variable severity,
    depending on the plasma levels of coagulation factor VIII: mild, with levels 
    6 to 30% of normal; moderate, with levels 2 to 5% of normal; and severe, with 
    levels less than 1% of normal.");


insert into a_gene(geneID, geneSymbol, geneTitle, location, description)
	values("300841","F8","COAGULATION FACTOR VIII","Xq28","The F8 gene
    encodes coagulation factor VIII, a large plasma glycoprotein that functions
    in the blood coagulation cascade as a cofactor for the factor IXa (300746)-dependent
    activation of factor X (F10; 613872)." );
    
insert into a_phenotypeNames(phenoID, phenotypeName)
	values("306700","HEMOPHILIA, CLASSIC");

insert into a_geneNames(gid, geneName)
	values("300841","FACTOR VIII COAGULATION FACTOR VIIIC");

insert into a_geneNames(gid, geneName)
	values("300841","PROCOAGULANT COMPONENT");
    
insert into a_geneNames(gid, geneName)
	values("300841","F8C");
    
insert into a_phenoGeneAssoc(pheno,gene,phenoTitle,inheritance,phenotypeMappingKey)
	values("306700","300841","Hemophilia A","XLR",3);
    
/*--------------------------------------*/
/*			INSERT 219700				*/
/*--------------------------------------*/

insert into a_phenotype(phenotypeID, phenotypeTitle, description)
	values("219700","CYSTIC FIBROSIS", "Formerly known as cystic fibrosis 
    of the pancreas, this entity has increasingly been labeled simply 
    'cystic fibrosis.' Manifestations relate not only to the disruption
    of exocrine function of the pancreas but also to intestinal glands
    (meconium ileus), biliary tree (biliary cirrhosis), bronchial glands
    (chronic bronchopulmonary infection with emphysema), and sweat glands 
    (high sweat electrolyte with depletion in a hot environment). Infertility
    occurs in males and females.");


insert into a_gene(geneID, geneSymbol, geneTitle, location, description)
	values("146790","FCGR2A","Fc FRAGMENT OF IgG, LOW AFFINITY IIa, RECEPTOR FOR","1q23.3",
    "Receptors for the Fc portion of IgG such as FCGR2A play an essential role in the protection
    of the organism against foreign antigens by removing antigen-antibody complexes from the circulation
    (Hibbs et al., 1988). Receptors are present on monocytes, macrophages, neutrophils, natural killer (NK)
    cells, and T and B lymphocytes, and they participate in diverse functions such as phagocytosis of immune 
    complexes and modulation of antibody production by B cells." );
    
    insert into a_gene(geneID, geneSymbol, geneTitle, location, description)
	values("602421","CFTR","CYSTIC FIBROSIS TRANSMEMBRANE CONDUCTANCE REGULATOR","7q31.2",
    "The CFTR gene encodes an ATP-binding cassette (ABC) transporter that functions as a low
    conductance Cl(-)-selective channel gated by cycles of ATP binding and hydrolysis at its
    nucleotide-binding domains (NBDs) and regulated tightly by an intrinsically disordered 
    protein segment distinguished by multiple consensus phosphorylation sites termed the 
    regulatory domain (summary by Wang et al., 2014). " );
    
    
    
insert into a_phenotypeNames(phenoID, phenotypeName)
	values("219700","MUCOVISCIDOSIS");

insert into a_geneNames(gid, geneName)
	values("146790","FCG2");

insert into a_geneNames(gid, geneName)
	values("146790","IMMUNOGLOBULIN G Fc RECEPTOR II; FcGR; IGFR2");
    
insert into a_geneNames(gid, geneName)
	values("146790","CDw32");
    
insert into a_geneNames(gid, geneName)
	values("146790","CD32");
    
insert into a_geneNames(gid, geneName)
	values("602421","ATP-BINDING CASSETTE, SUBFAMILY C, MEMBER 7; ABCC7");


insert into a_phenoGeneAssoc(pheno,gene,phenoTitle,inheritance,phenotypeMappingKey)
	values("219700","146790","Pseudomonas aeruginosa, susceptibility to chronic infection by, in cystic fibrosis","AR",3);

insert into a_phenoGeneAssoc(pheno,gene,phenoTitle,inheritance,phenotypeMappingKey)
	values("219700","602421","Cystic fibrosis","AR",3);

	/*--------------------------------------*/
	/*		INSERT GENE 602421 MORE PHENO	*/
	/*--------------------------------------*/

insert into a_phenotype(phenotypeID, phenotypeTitle, description)
	values("277180","VAS DEFERENS, CONGENITAL BILATERAL APLASIA OF; CBAVD", 
    "Congenital bilateral absence of the vas deferens is found in more than 
    25% of men with obstructive azoospermia, involving a complete or partial 
    defect of the Wolffian duct derivatives. In 80% of men with CBAVD, mutations 
    are identified in the CFTR gene");
    
insert into a_phenoGeneAssoc(pheno,gene,phenoTitle,inheritance,phenotypeMappingKey)
	values("277180","602421","Congenital bilateral absence of vas deferens","AR",3);
	
insert into a_altPhen(gid,altPhenName)values("602421","277180");
insert into a_altPhen(gid,altPhenName)values("602421","219700");

insert into a_phenotype(phenotypeID, phenotypeTitle, description)values("211400",
 "BRONCHIECTASIS WITH OR WITHOUT ELEVATED SWEAT CHLORIDE 1; BESC1"," ");

insert into a_phenoGeneAssoc(pheno,gene,phenoTitle,inheritance,phenotypeMappingKey)
	values("211400","602421","Bronchiectasis with or without elevated sweat chloride 1, modifier of","AD",3);
    
insert into a_altPhen(gid,altPhenName)values("602421","211400");

insert into a_phenotype(phenotypeID, phenotypeTitle, description)values("167800",
 "Pancreatitis, hereditary"," ");

insert into a_phenoGeneAssoc(pheno,gene,phenoTitle,inheritance,phenotypeMappingKey)
	values("167800","602421","Pancreatitis, hereditary","AD",3);
    
insert into a_altPhen(gid,altPhenName)values("602421","167800");

/*--------------------------------------*/
/*			INSERT 603903				*/
/*--------------------------------------*/

insert into a_phenotype(phenotypeID, phenotypeTitle, description)
	values("603903","SICKLE CELL ANEMIA", "Sickle cell anemia is a
    multisystem disease associated with episodes of acute illness
    and progressive organ damage. Hemoglobin polymerization, leading
    to erythrocyte rigidity and vasoocclusion, is central to the 
    pathophysiology of the disease, but the importance of chronic anemia, 
    hemolysis, and vasculopathy has been established. The most common cause
    of sickle cell anemia is the HbS variant (141900.0243), with hemoglobin 
    SS disease being most prevalent in Africans (review by Rees et al., 2010).");


insert into a_gene(geneID, geneSymbol, geneTitle, location, description)
	values("141900","HBB","HEMOGLOBIN--BETA LOCUS; HBB","11p15.4",
    "The alpha (HBA1, 141800; HBA2, 141850) and beta (HBB) loci determine
    the structure of the 2 types of polypeptide chains in adult hemoglobin, 
    HbA. Mutant beta globin that sickles causes sickle cell anemia (603903). 
    Absence of beta chain causes beta-zero-thalassemia. Reduced amounts of
    detectable beta globin causes beta-plus-thalassemia. For clinical purposes, 
    beta-thalassemia (613985) is divided into thalassemia major (transfusion dependent), 
    thalassemia intermedia (of intermediate severity), and thalassemia minor (asymptomatic)." );    
    
    
insert into a_phenotypeNames(phenoID, phenotypeName)
	values("603903","");

insert into a_geneNames(gid, geneName)
	values("141900","");


insert into a_phenoGeneAssoc(pheno,gene,phenoTitle,inheritance,phenotypeMappingKey)
	values("603903","141900","Sickle cell anemia","AR",3);



/*--------------------------------------*/
/*			INSERT 613985				*/
/*--------------------------------------*/


insert into a_phenotype(phenotypeID, phenotypeTitle, description)
	values("613985","BETA-THALASSEMIA", "Beta-thalassemia is characterized
    by a reduced production of hemoglobin A (HbA, alpha-2/beta-2), which 
    results from the reduced synthesis of beta-globin chains relative to
    alpha-globin chains, thus causing an imbalance in globin chain production 
    and hence abnormal erythropoiesis. The disorder is clinically heterogeneous 
    (summary by Ottolenghi et al., 1975).");


insert into a_phenoGeneAssoc(pheno,gene,phenoTitle,inheritance,phenotypeMappingKey)
	values("613985","141900","Thalassemia, beta","",3);
    

insert into a_gene(geneID, geneSymbol, geneTitle, location, description)
	values("152424","LCRB","LOCUS CONTROL REGION, BETA","11p15.4",
    "The hemoglobin beta (HBB; 141900) locus control region (LCRB) is 
    thought to organize the entire 60-kb beta-globin gene cluster into 
    an active chromatin domain and to enhance the transcription of the 
    individual globin genes. Similar LCRs are present in the alpha-globin
    gene cluster (see 152422), the visual pigment gene cluster (see 300824), 
    the major histocompatibility complex gene cluster, and the growth hormone 
    gene cluster (see 139250), among others." );    
    

insert into a_geneNames(gid, geneName)
	values("152424","LCR-BETA; LCRB");

insert into a_phenoGeneAssoc(pheno,gene,phenoTitle,inheritance,phenotypeMappingKey)
	values("613985","152424","Thalassemia, Hispanic gamma-delta-beta","",3);

/*--------------------------------------*/
/*			INSERT 140700				*/
/*--------------------------------------*/

insert into a_phenotype(phenotypeID, phenotypeTitle, description)
	values("140700","HEINZ BODY ANEMIAS", "This is a form of nonspherocytic 
    hemolytic anemia of Dacie type I (in vitro autohemolysis is not corrected 
    by added glucose). After splenectomy, which has little benefit, basophilic 
    inclusions called Heinz bodies are demonstrable in the erythrocytes. Before 
    splenectomy, diffuse or punctate basophilia may be evident. Most of these 
    cases are probably instances of hemoglobinopathy. The hemoglobin demonstrates heat lability.");


insert into a_phenoGeneAssoc(pheno,gene,phenoTitle,inheritance,phenotypeMappingKey)
	values("140700","141900","Heinz body anemia","AD",3);
    

insert into a_gene(geneID, geneSymbol, geneTitle, location, description)
	values("141850","HBA2","HEMOGLOBIN--ALPHA LOCUS 2; HBA2","16p13.3",
    "" );    

insert into a_geneNames(gid, geneName)
	values("141850","5-PRIME ALPHA-GLOBIN GENE");
    
insert into a_geneNames(gid, geneName)
	values("141850","ALPHA-GLOBIN LOCUS, SECOND");
    
insert into a_geneNames(gid, geneName)
	values("141850","MAJOR ALPHA-GLOBIN LOCUS");

insert into a_phenoGeneAssoc(pheno,gene,phenoTitle,inheritance,phenotypeMappingKey)
	values("140700","141850","Heinz body anemia","AD",3);
 
 
insert into a_gene(geneID, geneSymbol, geneTitle, location, description)
	values("141800","HBA1","HEMOGLOBIN--ALPHA LOCUS 1; HBA1","16p13.3",
    "The alpha and beta loci determine the structure of the 2 types of
    polypeptide chains in the tetrameric adult hemoglobin, Hb A, 
    alpha-2/beta-2. The alpha locus also determines a polypeptide chain, 
    the alpha chain, in fetal hemoglobin (alpha-2/gamma-2), in hemoglobin
    A2(alpha-2/delta-2), and in embryonic hemoglobin (alpha-2/epsilon-2).
    The number of normal alpha genes (3, 2, 1 or none) in Asian cases of 
    alpha-thalassemia (604131) results in 4 different alpha-thalassemia
    syndromes (Kan et al., 1976). Three normal alpha genes gives a silent 
    carrier state. Two normal alpha genes results in microcytosis (so-called
    heterozygous alpha-thalassemia). One normal alpha gene results in microcytosis
    and hemolysis (so-called Hb H disease, 613978). No normal alpha gene results in
    'homozygous alpha-thalassemia' manifested as fatal hydrops fetalis. " );    



insert into a_geneNames(gid, geneName)
	values("141800","3-PRIME ALPHA-GLOBIN GENE");
    
insert into a_geneNames(gid, geneName)
	values("141800","MINOR ALPHA-GLOBIN LOCUS");
    

insert into a_phenoGeneAssoc(pheno,gene,phenoTitle,inheritance,phenotypeMappingKey)
	values("140700","141800","Heinz body anemias, alpha-","AD",3);


/*--------------------------------------*/
/*				UPDATE					*/
/*--------------------------------------*/

/* Προσθήκη - Αλλαγή πληροφορίας στο πεδίο text του a_phenotype */
UPDATE a_phenotype set phenText="A number sign (#)
 is used with this entry because classic hemophilia,
 or hemophilia A, is caused by mutation in the gene
 encoding coagulation factor VIII (F8; 300841) on 
 chromosome Xq28."
 where phenotypeID="306700";

UPDATE a_phenotype set phenText="A number sign (#) 
is used with this entry because cystic fibrosis is 
caused by homozygous or compound heterozygous mutation 
in the cystic fibrosis conductance regulator gene 
(CFTR; 602421) on chromosome 7q31."
 where phenotypeID="219700";
 
 UPDATE a_phenotype set phenText="A number sign (#)
 is used with this entry because sickle cell anemia 
 is the result of mutant beta globin (HBB; 141900)
 in which the mutation causes sickling of hemoglobin."
 where phenotypeID="603903";
 
  UPDATE a_phenotype set phenText="A number sign (#) 
  is used with this entry because beta-thalassemia can
  be caused by homozygous or compound heterozygous mutation 
  in the beta-globin gene (HBB; 141900) on chromosome 11p15.
Beta-thalassemia may also be due to deletion of the entire
 beta-globin gene cluster or of sequences 5-prime from the 
 beta-globin gene cluster; these sequences are referred to 
 as the locus control region beta (LCRB; 152424)."
 where phenotypeID="613985";
 
UPDATE a_phenotype set phenText="A number sign (#) is used 
  with this entry because Heinz body anemia is observed with 
  heterozygous mutations in either the alpha-globin
  (HBA1, 141800; HBA2, 141850) or the beta-globin (HBB; 141900) genes."
 where phenotypeID="140700";
 
 
/* Προσθήκη - Αλλαγή πληροφορίας στο πεδίο coordinates στο a_gene*/ 
UPDATE a_gene set coordinates="16:176,650-177,521" where geneID="141800";
UPDATE a_gene set coordinates="16:172,846-173,709" where geneID="141850";
UPDATE a_gene set coordinates="11:5,225,465-5,227,070" where geneID="141900";
UPDATE a_gene set coordinates="1:161,505,414-161,524,047" where geneID="146790";
UPDATE a_gene set coordinates="11:5,269,924-5,304,185" where geneID="152424";
UPDATE a_gene set coordinates="X:154,835,787-155,022,722" where geneID="300841";
UPDATE a_gene set coordinates="7:117,479,962-117,668,664" where geneID="602421";
