## Clusterização StackOverflow Perguntas e respostas de linguagens de programação

### Resultado

O K-means levou 44 iterações para convergir, logo há 45 clusters:

  Score | Linguagem Dominante (%)  |Questões
-----------------------------|--------------------------------------|----------------
0 | MATLAB (100,0%) |  3725
0 | Groovy (100,0%)| 1631
1 | PHP (100,0%) | 315771
1 | Java  (100,0%)  |  383473
1 | Objective-C  (100,0%) | 94745
1 | JavaScript  (100,0%) |  365649
1 | C#  (100,0%)  | 361835
1 | CSS (100,0%) | 113598
1 | Ruby  (100,0%) | 54727
2 | Perl  (100,0%)| 19229
2 | MATLAB(100,0%) | 7989
2 | Scala  (100,0%)| 12423
2 | Python  (100,0%)| 174586
2 | C++ (100,0%) | 181255
2 | Clojure (100,0%) | 3441
3 | Groovy (100,0%)| 1390
4 | Haskell (100,0%) | 10362
5 | MATLAB   (100,0%) | 2774
9 | Perl   (100,0%)| 4716
14 | Clojure  (100,0%) | 595
25 | Scala (100,0%)| 728
36 | Groovy  (100,0%) | 32
53 | Haskell  (100,0%) | 202
66 | Clojure  (100,0%)|   57
78 | Perl  (100,0%) | 56
79 | C#   (100,0%) | 2585
85 | Ruby  (100,0%) | 648
97 | Objective-C  (100,0%) | 784
130 | Scala (100,0%)| 47
139|  PHP  (100,0%) | 475
172 | CSS   (100,0%)|  358
212 | C++  (100,0%)|  264
227|  Python   (100,0%)| 400
249 | Java   (100,0%)| 483
377 | JavaScript  (100,0%) |431
443 | C#  (100,0%) |  147
503 | Objective-C  (100,0%)   | 73
546| Ruby (100,0%) |  34
766 | CSS   (100,0%) |  26
887 |PHP  (100,0%) |  13
1130 | Haskell  (100,0%)| 2
1269 | Python (100,0%)|  19
1290 | C++   (100,0%)|  9
1895 | JavaScript   (100,0%) | 33
10271 | Java  (100,0%)|  2

### Perguntas

* *Você acha que particionar os dados ajudaria?*

Sim, o particionamento reduz o shuffle quando os dados são agrupados por seus clusters para calcular novos centróides. Após o particionamento o tempo de execução caiu de 1.201s para 105s.

* *Você já pensou em persistir alguns de seus dados? Você consegue pensar por que persistir seus dados na memória pode ser útil para esse algoritmo?*

Sim,persistir `vectors` na memória ajudou, pois facilitou sua reutilização no algoritmo k-means.

* *Dos clusters não vazios, quantos clusters têm "Java" como rótulo (com base na maioria das perguntas, veja acima)? Por quê?*

3 clusters são rotulados de Java.

* *Considerando apenas os "clusters Java", quais clusters se destacam e por quê?*

Há um grupo enorme com mais de 380 mil perguntas, mas a média de votos nas respostas é de apenas 1. Isso sugere perguntas para iniciantes. Por outro lado, há um pequeno grupo com apenas 2 perguntas, mas a média de votos nas respostas é de 10 mil.

* *Como os cluster C# são diferentes comparados aos clusters Java?*

Os clusters Java têm respostas de maior qualidade do que os clusters C#, conforme indicado pelos votos score mais altos. Ou também pode significar que a comunidade Java é maior que C#. De qualquer forma, ambas as comunidades parecem ser muito saudáveis, pois há muitas perguntas e respostas altamente votadas.
