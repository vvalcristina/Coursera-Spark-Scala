
#Time Usage

Para executar esse caso é necessário realizar o download do dataset [atussum.csv] e colocá-lo no caminho **src/main/resources/timeusage/** dentro do diretório do projeto

## Objetivo

O objetivo desde código é identificar no dataset do Kaggle [American Time Use Survey] três grupos de atividades:

* necessidades primárias (dormir e comer);
* trabalhos
* outro (lazer)

E então observar como as pessoas alocam seu tempo entre esses três tipos de atividades, e se podemos ver diferenças entre homens e mulheres, empregados e desempregados, e jovens (menos de 22 anos), ativos (entre 22 e 55 anos) velhos) e idosos.

No final da tarefa, seremos capazes de responder às seguintes perguntas com base no conjunto de dados:

quanto tempo gastamos em necessidades primárias em comparação com outras atividades?

mulheres e homens passam a mesma quantidade de tempo trabalhando?

o tempo gasto com necessidades primárias muda quando as pessoas envelhecem?

quanto tempo as pessoas empregadas gastam no lazer em comparação com as pessoas desempregadas?

**Sobre o arquivo**

O arquivo usa o formato de valores separados por vírgulas : a primeira linha é um cabeçalho que define os nomes dos campos de cada coluna, e cada linha seguinte contém um registro de informações, que é composto por várias colunas. Ele contém informações sobre como as pessoas gastam seu tempo (por exemplo, dormindo, comendo, trabalhando, etc.).

Aqui estão as primeiras linhas do conjunto de dados:

```bash
tucaseid,gemetsta,gtmetsta,peeduca,pehspnon,ptdtrace,teage,telfs,temjot,teschenr,teschlvl,tesex,tespempnot,trchildnum,trdpftpt,trernwa,trholiday,trspftpt,trsppres,tryhhchild,tudiaryday,tufnwgtp,tehruslt,tuyear,t010101,t010102,t010199,t010201,t010299,t010301,t010399,t010401,t010499,t010501,t010599,t019999,t020101,t020102,t020103,t020104,t020199,t020201,t020202,t020203,t020299,t020301,t020302,t020303,t020399,t020401,t020402,t020499,t020501,t020502,t020599,t020681,t020699,t020701,t020799,t020801,t020899,t020901,t020902,t020903,t020904,t020905,t020999,t029999,t030101,t030102,t030103,t030104,t030105,t030108,t030109,t030110,t030111,t030112,t030186,t030199,t030201,t030202,t030203,t030204,t030299,t030301,t030302,t030303,t030399,t030401,t030402,t030403,t030404,t030405,t030499,t030501,t030502,t030503,t030504,t030599,t039999,t040101,t040102,t040103,t040104,t040105,t040108,t040109,t040110,t040111,t040112,t040186,t040199,t040201,t040202,t040203,t040204,t040299,t040301,t040302,t040303,t040399,t040401,t040402,t040403,t040404,t040405,t040499,t040501,t040502,t040503,t040504,t040505,t040506,t040507,t040508,t040599,t049999,t050101,t050102,t050103,t050189,t050201,t050202,t050203,t050204,t050289,t050301,t050302,t050303,t050304,t050389,t050403,t050404,t050405,t050481,t050499,t059999,t060101,t060102,t060103,t060104,t060199,t060201,t060202,t060203,t060289,t060301,t060302,t060303,t060399,t060401,t060402,t060403,t060499,t069999,t070101,t070102,t070103,t070104,t070105,t070199,t070201,t070299,t070301,t070399,t079999,t080101,t080102,t080199,t080201,t080202,t080203,t080299,t080301,t080302,t080399,t080401,t080402,t080403,t080499,t080501,t080502,t080599,t080601,t080602,t080699,t080701,t080702,t080799,t080801,t080899,t089999,t090101,t090102,t090103,t090104,t090199,t090201,t090202,t090299,t090301,t090302,t090399,t090401,t090402,t090499,t090501,t090502,t090599,t099999,t100101,t100102,t100103,t100199,t100201,t100299,t100381,t100383,t100399,t100401,t100499,t109999,t110101,t110199,t110281,t110289,t119999,t120101,t120199,t120201,t120202,t120299,t120301,t120302,t120303,t120304,t120305,t120306,t120307,t120308,t120309,t120310,t120311,t120312,t120313,t120399,t120401,t120402,t120403,t120404,t120405,t120499,t120501,t120502,t120503,t120504,t120599,t129999,t130101,t130102,t130103,t130104,t130105,t130106,t130107,t130108,t130109,t130110,t130111,t130112,t130113,t130114,t130115,t130116,t130117,t130118,t130119,t130120,t130121,t130122,t130123,t130124,t130125,t130126,t130127,t130128,t130129,t130130,t130131,t130132,t130133,t130134,t130135,t130136,t130199,t130201,t130202,t130203,t130204,t130205,t130206,t130207,t130208,t130209,t130210,t130211,t130212,t130213,t130214,t130215,t130216,t130217,t130218,t130219,t130220,t130221,t130222,t130223,t130224,t130225,t130226,t130227,t130228,t130229,t130230,t130231,t130232,t130299,t130301,t130302,t130399,t130401,t130402,t130499,t139999,t140101,t140102,t140103,t140104,t140105,t149999,t150101,t150102,t150103,t150104,t150105,t150106,t150199,t150201,t150202,t150203,t150204,t150299,t150301,t150302,t150399,t150401,t150402,t150499,t150501,t150599,t150601,t150602,t150699,t159989,t160101,t160102,t160103,t160104,t160105,t160106,t160107,t160108,t169989,t180101,t180199,t180280,t180381,t180382,t180399,t180481,t180482,t180499,t180501,t180502,t180589,t180601,t180682,t180699,t180701,t180782,t180801,t180802,t180803,t180804,t180805,t180806,t180807,t180899,t180901,t180902,t180903,t180904,t180905,t180999,t181002,t181081,t181099,t181101,t181199,t181201,t181202,t181204,t181283,t181299,t181301,t181302,t181399,t181401,t181499,t181501,t181599,t181601,t181699,t181801,t181899,t189999,t500101,t500103,t500104,t500105,t500106,t500107,t509989
"20030100013280",1,-1,44,2,2,60,2,2,-1,-1,1,2,0,2,66000,0,-1,1,-1,6,8155463,30,2003,870,0,0,40,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,0,0,0,0,0,0,0,325,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,200,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
"20030100013344",2,-1,40,2,1,41,1,2,2,-1,2,1,2,2,20000,0,1,1,0,7,1735323,30,2003,620,0,0,60,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,60,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,90,0,0,0,0,530,0,0,0,0,0,0,60,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,20,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
"20030100013352",1,-1,41,2,1,26,2,2,2,-1,2,2,0,2,20000,0,-1,1,-1,7,3830528,12,2003,560,0,0,80,0,0,0,0,0,0,0,0,0,0,0,15,0,180,0,60,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,60,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,75,0,0,0,0,220,0,0,0,0,0,0,120,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,60,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
```

### **Problema a ser resolvido**

O conjunto de dados inicial contém muitas informações que não precisamos para responder às nossas perguntas, e até as colunas que contêm informações úteis são muito detalhadas. Portanto, com esse conjunto de dados inicial, seria um pouco difícil expressar as consultas que nos dariam as respostas que procuramos.

O primeiro passo  é identificar quais colunas estão relacionadas à mesma atividade. Com base na descrição da atividade correspondente a cada coluna (dada neste [documento] ), temos as seguintes regras:

* As atividades de “necessidades primárias” (dormir, comer, etc.) são relatadas em colunas que começam com “t01”, “t03”, “t11”, “t1801” e “t1803”;

* As atividades de trabalho são relatadas em colunas que começam com “t05” e “t1805”;

* Outras atividades (lazer) são relatadas em colunas começando com “t02”, “t04”, “t06”, “t07”, “t08”, “t09”, “t10”, “t12”, “t13”, “t14” , “t15”, “t16” e “t18” (somente aqueles que não fazem parte dos grupos anteriores).

Em seguida, nosso trabalho consiste em implementar o método **classifiedColumns** , que classifica a lista de nomes de colunas fornecida em três https://spark.apache.org/docs/3.2.0/api/scala/org/apache/spark/sql/Column. grupos html (necessidades primárias, trabalho ou outros). Este método deve retornar uma trinca contendo a lista de colunas “necessidades primárias”, a lista de colunas “trabalho” e a lista de colunas “outras”.

```bash
def classifiedColumns(columnNames: List[String]): (List[Column], List[Column], List[Column])
```

A segunda etapa é implementar o método **timeUsageSummary** , que projeta o conjunto de dados detalhado em um conjunto de dados resumido. Este resumo conterá apenas 6 colunas: o status de trabalho do entrevistado, seu sexo, sua idade, a quantidade de horas diárias gastas em atividades de necessidades primárias, a quantidade de horas diárias gastas no trabalho e a quantidade de horas diárias gastas em outras atividades .

```bash
def timeUsageSummary(
  primaryNeedsColumns: List[Column],
  workColumns: List[Column],
  otherColumns: List[Column],
  df: DataFrame
): DataFrame
```

Cada “coluna de atividade” conterá a soma das colunas relacionadas à mesma atividade do conjunto de dados inicial. Observe que os valores de tempo são dados em minutos no conjunto de dados inicial, enquanto no conjunto de dados resultante queremos que sejam em horas.

As colunas que descrevem o status de trabalho, o sexo e a idade conterão informações simplificadas em comparação com o conjunto de dados inicial.

Por último, as pessoas que não são empregáveis ​​serão excluídas do conjunto de dados resultante.

O comentário na parte superior do método timeUsageSummary fornecerá informações mais específicas sobre o que é esperado em cada coluna.

**Agregar**

Por fim, queremos comparar o tempo médio gasto em cada atividade, para todas as combinações de situação de trabalho, sexo e idade.

Vamos implementar o método **timeUsageGrouped**que calcula o número médio de horas gastas em cada atividade, agrupadas por situação de trabalho (empregado ou desempregado), sexo e idade (jovem, ativo ou idoso), e também ordenados por situação de trabalho, sexo e idade. Os valores serão arredondados para o décimo mais próximo.

```bash
def timeUsageGrouped(summed: DataFrame): DataFrame
```

Agora você pode executar o projeto e ver o que o DataFrame final contém. O que você vê quando compara o uso do tempo de homens idosos versus mulheres idosas? Quanto tempo os idosos dedicam ao lazer em comparação com os ativos? Quanto tempo os empregados ativos gastam para trabalhar?

### Resultado

|working|   sex|   age|primaryNeeds|work|other|
|--------|------|-------|-------|--------|-------|
|not working|female|active|        12.4| 0.5| 10.8|
|not working|female| elder|        10.9| 0.4| 12.4|
|not working|female| young|        12.5| 0.2| 11.1|
|not working|  male|active|        11.4| 0.9| 11.4|
|not working|  male| elder|        10.7| 0.7| 12.3|
|not working|  male| young|        11.6| 0.2| 11.9|
|    working|female|active|        11.5| 4.2|  8.1|
|    working|female| elder|        10.6| 3.9|  9.3|
|    working|female| young|        11.6| 3.3|  8.9|
|    working|  male|active|        10.8| 5.2|  7.8|
|    working|  male| elder|        10.4| 4.8|  8.6|
|    working|  male| young|        10.9| 3.7|  9.2|


* *Quanto tempo gastamos em necessidades primárias em comparação com outras atividades?*

Na maioria das situações gastamos mais tempo suprindo nossas necessidades primária comparado a outras atividades. Com exceção há homens e mulheres que não trabalham e são mais velhos (elder), eles gastam mais tempo em outras atividades (lazer).

* *Mulheres e homens passam a mesma quantidade de tempo trabalhando?*

O tempo de trabalho entre homens e mulheres difere ao longo do tempo, mas no geral os homens passam maior tempo no trabalho

* *O tempo gasto com necessidades primárias muda quando as pessoas envelhecem?*

Conforme as pessoas envelhecem o tempo das necessidades primárias tendem a diminuir.

* *Quanto tempo as pessoas empregadas gastam no lazer em comparação com as pessoas desempregadas?*

As pessoas que não trabalham gastam 1.35% do tempo em lazer a mais quando comparada as empregadas.Quando olhamos em relação a genero percebemos que as mulheres gastam mais tempo em lazer que os homens.

[atussum.csv]: https://moocs.scala-lang.org/~dockermoocs/bigdata/atussum.csv

[American Time Use Survey]: https://www.kaggle.com/bls/american-time-use-survey

[documento]: https://www.bls.gov/tus/lexiconnoex0315.pdf
