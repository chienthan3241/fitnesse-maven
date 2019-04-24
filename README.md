# Using Fitnesse in maven Project

look in to pom.xml
+ fitnesse.command in properties
+ maven-antrun-plugin to run fitnesse synchronous with: `mvn test`
+ maven-classpath-plugin => plugins.properties

## FrontPage 
`|'''Global setting'''|`  
`|[[Test Cases][TestCases]]|Begin test here|`  
`|[[Set Up][SetUp]]|Set UP of Global Variables|`  
`|[[Tear Down][TearDown]]|Tear Down the Test Cases|`  
`|[[Class Path][root]]|Class path Settings|`  

## root Page
`#!define TEST_SYSTEM {slim}`  
`!define COLLAPSE_SETUP {true}`  
`!define COLLAPSE_TEARDOWN {true}`  
`!pomFile C:\workspace\trunk\FitnesseExp\fitnesseExp\pom.xml`  

## Setup page
`#!|import|`  
`#|com.arvarto.fitnesseExp|`  

## Teardown 
to cleanup everything after test (eg. DB ...)

## TestCases
buit testcases hier
eg.

!1 Begin test Here see Fixtures below:  
 ----  
<span style="color:blue">!style_blue['''Columnfixture:'''  maps table columns directly to properties, methods and fields of the fixture class. It is very useful for repetitive verifications if the same test needs to be repeated for different combinations of input arguments.]</span>  
   
`!|com.arvarto.fixture.ColumnFixtureTest		|`  
`|code						|preis			|getTax?	|`  
`|B978-0201616224    	|10.0       	|0.19   	|`  
`|wrong code				|100.0      	|0.0    	|`  
`|SONDER_TAX1    		|1000.0     	|0.1		|`  
----  
<span style="color:blue">!style_blue['''Actionfixture:''' was originally intended for workflow-style tests that are not repetitive. It uses a UI metaphor to automate other fixtures.]</span>  
  
`!|com.arvarto.fixture.ActionFixtureTest|`  
`|start|ActionFixtureTest		|`  
`|enter|addNoTaxProduct	|10		|`  
`|enter|addNoTaxProduct	|10		|`  
`|check|getNetto				|20.0	|`  
`|check|getBrutto			|20.0	|`  
`|press|clearProduct		|`  
`|enter|addNormalProduct	|10		|`  
`|check|getNetto				|10.0	|`  
`|check|getBrutto			|11.9	|`  
`|enter|addSonderProduct	|10		|`  
`|check|getNetto				|20.0	|`  
`|check|getBrutto			|22.9	|`  
----  
<span style="color:blue">!style_blue['''Setupfixture:''' is an excellent replacement for Columnfixture if you do not want to test anything, just to prepare the stage for other fixtures. For example, you can use Setupfixture to insert rows into a database table or to create domain objects that will be used in later tests.]</span>  

`!|com.arvarto.fixture.SetUpFixtureTest|`  
`|name|code|preis			|`  
`|product1|wrong_code|100	|`  
`|product2|ERDR-GX330|100	|`  
`|product3|SONDER_TAX1|100	|`   
----  
<span style="color:blue">!style_blue['''Rowfixture:''' tests dynamic lists of objects. It will compare the expected list (fitNesse table) with the actual result (from fixture code) and report any additional or missing items.]</span>  

`!|com.arvarto.fixture.SetUpFixtureTest|`  
`|name|code|preis			|`  
`|product1|wrong_code|100	|`  
`|product2|ERDR-GX330|100	|`  
`|product3|SONDER_TAX1|100	|`  
----  
<span style="color:blue">!style_blue['''Tablefixture:''' is an additional class in the fitNesse package (it does not exist in the core FIT fixture set, but is distributed as part of the same library with fitNesse). It is used to execute free-form tables that do not have a repetitive structure.]</span>  
  
`!|com.arvarto.fixture.TableFixtureTest|`  
`|Productname					|Product code		|Price	|`  
`|Pragmatic Programmer		|B978-0201616224	|10		|`  
`|Sony RDR-GX330				|ERDR-GX330		|10		|`  
`|Test Driven Development	|B978-0321146533	|10		|`  
`|Net Total					|					|30.00	|`  
`|Tax (on all products)	|					|5.70	|`  
`|Total						|					|35.70	|`  
----  
<span style="color:blue">!style_blue['''Calculatefixture:''' is used to verify the result of one or more calculations for different combinations of input arguments. It does the same job as Columnfixture in a different table format and with lot less code in the fixture class.]</span>  

`!|com.arvarto.fixture.CalculateFixtureTest|`  
`|code|preis			||getTax	|`  
`|ERDR-GX330	|100.0	||119.0	|`  
`|WRONG CODE|200.0	||200.0	|`  
----  
<span style="color:blue">!style_blue['''Dofixture:''' can be used to describe story-like tests, almost in plain English. It is a much more efficient replacement for Actionfixture and also has some great features like flow-mode coordination and wrapping domain objects.]</span>  

`!|com.arvarto.fixture.DoFixtureTest|`  
`|add no tax product with preis		|10	|`  
`|add normal product	with preis	|20	|`  
`|add sonder product	with preis	|10	|`   
`|number of product is					|3	|`  
`|preis of product at position |1|is|20.0|`    
`|netto of all product is				|40.0|`  
`|clear product|`  
`|number of product is					|0	|`    
----
<span style="color:blue">!style_blue['''Sequencefixture:''' is very similar to Dofixture and has almost the same features — in fact the only difference between those two is the naming convention for methods. Instead of using odd cells to construct a method name, Sequencefixture takes the first cell in each row as the method name, and all other cells as arguments (if there are no keywords to modify the row functionality). All Dofixture keywords are supported in Sequencefixture too, as well as the flow mode and domain object wrapping.]</span>  

`!|com.arvarto.fixture.SequenceFixtureTest|`  
`|add no tax product with preis	|10		|`  
`|add no tax product with preis	|10		|`    
`|check|getNetto			|20.0	|`  
`|check|getBrutto		|20.0	|`    
`|clearProduct		|`  
`|add normal product	with preis	|10		|`    
`|check|getNetto			|10.0	|`  
`|check|getBrutto		|11.9	|`  
`|add sonder product	with preis	|10		|`  
`|check|getNetto			|20.0	|`  
`|check|getBrutto		|22.9	|`  
----
<span style="color:blue">!style_blue['''Arrayfixture:''' was built as a replacement for Rowfixture . It works very similar to that other fixture type, with two main differences:]  
 * !style_blue[Element order is important for Arrayfixture .]  
 * !style_blue[Arrayfixture can work with generic collections as well as with arrays.]</span>  

`!| com.arvarto.fixture.ArrayFixtureTest |`  
`| name | code | preis |`  
`| product1 | wrong_code | 100.0 |`  
`| product2 | ERDR-GX330 | 200.0 |`  

<span style="color:blue">!style_blue['''Setfixture:''' is the same as Arrayfixture (see Arrayfixture) with one difference: the order of the rows is not checked.]</span>  

`!| com.arvarto.fixture.SetFixtureTest |`  
`| name | code | preis |`  
`| product2 | ERDR-GX330 | 200.0 |`  
`| product1 | wrong_code | 100.0 |`  

<span style="color:blue">!style_blue['''Subsetfixture:''' is a variation of Setfixture (see Setfixture) with one difference: the rows in the fixture table can be a subset of the actual rows.]</span>  

`!| com.arvarto.fixture.SubsetFixtureTest |`  
`| name | code | preis |`  
`| product2 | ERDR-GX330 | 200.0 |`  
----
<span style="color:blue">!style_blue['''Combinationfixture:''' is used to perform an operation on pairs on values. The values are specified in a row and a column and the operation is performed on all combinations of values.]</span>  

`!| com.arvarto.fixture.CombinationFixtureTest |`  
`||10|20|30|`  
`|product1|90.0|80.0|70.0|`  
`|product2|190.0|180.0|170.0|`  
`|wrong product|0.0|0.0|0.0|`  
----
<span style="color:blue">!style_blue['''Constraintfixture:''' is a variation of Calculatefixture (see Calculatefixture) that has an expected value of true for each calculation.]</span>  

`!| com.arvarto.fixture.ConstraintFixtureTest |`  
`|normalTaxCode|taxValue|`  
`|B978-0201616224|0.19|`  
`|ERDR-GX330|0.19|`  
`|B978-0321146533|0.19|`  
`|wrong code|0.19|`  
----  
!3 Use SLIM (choose test system: !define TEST_SYSTEM {slim}):  
!define TEST_SYSTEM {slim}  
----  
<span style="color:blue">!style_blue['''decision Table:''']</span>  

`!| com.arvarto.slim.SlimTest |`  
`| code | preis | getTax? | #Comment|getPreisWithTaxOfProduct?|`  
`| B978-0201616224 | 10.0 | 0.19 | this is normal code |11.9|`  
`| wrong code | 100.0 | | this code is not declare in tax table => ignored|100.0|`  
`| SONDER_TAX1 | 1000.0 | 0.1 | this is sonder code|1000<_<1190|`  
----
<span style="color:blue">!style_blue['''Baseline decision Table:''' same as decision Table with baseline at the first row]</span>  

`!| baseline: com.arvarto.slim.SlimTest |`  
`| code | preis | getTax? | #Comment|getPreisWithTaxOfProduct?|`  
`| B978-0201616224 | 10.0 | 0.19 | Base scenario |11.9|`  
`|ERDR-GX330|	|	|other normal Product same as Base scenario||`  
`|B978-0321146533|20.0||other normal Product with preis|23.8|`  
`| wrong code | 100.0 | 0.0| this code is not declare in tax table => ignored|100.0|`  
`| SONDER_TAX1 | 1000.0 | 0.1 | this is sonder code|1000<_<1190|`  
----
<span style="color:blue">!style_blue['''Dynamic decision Table:''' same as decision Table with first cell is prefixed by ddt:]</span>
<span style="color:blue">!style_blue[The dynamic decision table provides an alternative to the Decision Table when the Graceful Names of the column headers are not well suited as method names.]</span>  

`!| ddt: com.arvarto.slim.SlimTest |`  
`|B978-0201616224|ERDR-GX330|B978-0321146533|SONDER_TAX1|WRONG_CODE|total preis without tax?|total preis with tax?|`  
`|10|10|80|10|10|120.0|~=140.0|`  
----
<span style="color:blue">!style_blue['''The Hybrid Decision Table:''' Combines the advantages in the fixture implementation of a Decision and a Dynamic Decision Table. Also supported by a Baseline Decision Table]</span>  
----
<span style="color:blue">!style_blue['''Query Table:''' Supplies the expected results of a query. This is similar to the Fit Row Fixture]</span>  

`|Query: com.arvarto.slim.SlimTest|`
`|product name	|product code	|tax	|amount	|`
`|product 3		|B978-0321146533|0.19	|		|`
`|product 1		|B978-0201616224|0.19	|10		|`
`|product 2		|ERDR-GX330		|0.19	|20		|`
`|product 4		|SONDER_TAX1	|		|100	|`

<span style="color:blue">!style_blue['''Subset Query Table:''' Supplies a subset of the expected results of a query.]</span>  

`|Subset Query: com.arvarto.slim.SlimTest|`  
`|product name	|product code	|tax	|amount	|`  
`|product 1		|B978-0201616224|0.19	|10		|`  
`|product 4		|SONDER_TAX1	|		|100	|`  

<span style="color:blue">!style_blue['''Ordered Query Table:''' Supplies the expected results of a query. The rows are expected to be in order. This is similar to the Fit Row Fixture]</span>  

`|Query: com.arvarto.slim.SlimTest|`  
`|product name	|product code	|tax	|amount	|`  
`|product 1		|B978-0201616224|0.19	|10		|`  
`|product 2		|ERDR-GX330		|0.19	|20		|`  
`|product 3		|B978-0321146533|0.19	|		|`  
`|product 4		|SONDER_TAX1	|		|100	|`  
----  

<span style="color:blue">!style_blue['''Script Table:''' A series of actions and checks. Similar to Do Fixture.]</span>  

----  

<span style="color:blue">!style_blue['''Table Table:''' Whatever you want it to be!]</span>  

----  

<span style="color:blue">!style_blue['''Import:''' Add a path to the fixture search path. ]</span>  

----  

<span style="color:blue">!style_blue['''Comment:''' A table that does nothing.]</span>  

----  

<span style="color:blue">!style_blue['''Scenario Table:''' A table that can be called from other tables.]</span>  

----  

<span style="color:blue">!style_blue['''Library Table:''' A table that installs fixtures available for all test pages]</span>  

----  

<span style="color:blue">!style_blue['''Define Table Type:''' A helper table that defines the default table type for named fixtures.]</span>  

----  

<span style="color:blue">!style_blue['''Define Alias:''' A helper table that defines alias names for fixtures.]</span>  

----  

##Komschicht TestCases

!style_blue[given a dqEingabeDateiName]
#!|com.arvarto.ladenthekeFixture.InitialFixture|
  
!style_blue['''Kommschicht-Dispathcher:''' Check if this file is imported with '''AUFTRAGSTATUS = 4''' in the database?]  
  
`!|de.arvatoinfoscore.fm.cosima.regressionstest.fitnesse.ladentheke.fixture.KomschichtActionFixture               |`  
`|start|KomschichtActionFixture                                                                                   |`  
`|enter|setDqEingabeDateiName  |051151_Team27_E01625_20181208_20181208_203229_51151i08.12.2018_20181208-202714.csv|`  
`|press|doImport                                                                                                  |`  
`|press|initLocalVariable                                                                                         |`  
`|check|isImportedInTheDatabase|true                                                                              |`  
`|check|getMapping             |051151_Uebergabe                                                                  |`  
`|check|getKommId              |E01625                                                                            |`  
  
!style_blue['''Kommschicht-Worker:''' Check DQEINGABEDATEIAUFTRAG, TOUEBERGABELISTE]  
  
`!|de.arvatoinfoscore.fm.cosima.regressionstest.fitnesse.ladentheke.fixture.AuftragSubsetFixture|`  
`|name                                                 |status                                  |`  
`|Uebergabe_Anspruch                                   |4                                       |`  
`|Uebergabe_Block                                      |4                                       |`  
  
`!|de.arvatoinfoscore.fm.cosima.regressionstest.fitnesse.ladentheke.fixture.UebergabeListSubsetFixture|`  
`|kundenNummer                 |mandatenVerainbarungsnummer                 |kundenArt                |`  
`|PR432822018                  |51151                                       |109                      |`  
`|PR432982018                  |51151                                       |77                       |`  
`|PR433012018                  |51151                                       |82                       |`  
