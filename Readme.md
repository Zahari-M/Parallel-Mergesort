Паралелна имплементация на сортиращия алгоритъм merge sort. 
При всяко разделяне на подмасива половината от
зададения брой нишки обработват едната половина,
а другите - другата половина от подмасива, докато
не остане само една нишка, която да обработи
подмасива по стандартния начин в алгоритъма
merge sort.

Пример:

    Output:
    1000000 elements sorted for 545 milliseconds with 1 threads
    1000000 elements sorted for 197 milliseconds with 4 threads