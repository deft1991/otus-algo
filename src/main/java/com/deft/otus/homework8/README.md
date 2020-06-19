## Домашнее задание.
```
Решить олимпиадную задачу "Сумма на отрезке"
Ссылка на задачу: http://codeforces.com/gym/100249/
Дан массив из N элементов. Нужно научиться находить сумму чисел на любом отрезке.
Формат входного файла.
Первая строка входного айла содержит два целых числа:
N - число чисел в массиве (1 ≤ N ≤ 100 000),
K - количество запросов (0 ≤ K ≤ 100 000).
Следующие K строк содержат запросы вида:
1. A i x присвоить i-му элементу массива значение x (1 ≤ i ≤ N, 0 ≤ x ≤ 10^9)
2. Q L R найти сумму чисел в массиве на позициях от L до R. (1 ≤ L ≤ R ≤ N)
Изначально массиве заполнен нулями.
Формат выходного файла:
На каждый запрос вида Q L R нужно вывести единственное число - сумму на отрезке.
Пример
sum.in
5 9
A 2 2
A 3 1
A 4 2
Q 1 1
Q 2 2
Q 3 3
Q 4 4
Q 5 5
Q 1 5
sum.out
0
2
1
2
0
5
Написанную программу отправьте на проверку на сайте http://codeforces.com/gym/100249/
```

    private static void manualTest() {
        List<String> list = List.of("13 17", "A 1 3", "A 2 1", "A 3 4", "A 4 1", "A 5 5", "A 6 9"
                , "A 7 2", "A 8 6", "A 9 5", "A 10 3", "A 11 5", "A 12 8", "A 13 9 ", "A 14 7", "Q 3 12", "Q 5 8", "A 7 7");

        String[] firstLine = list.get(0).split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int K = Integer.parseInt(firstLine[1]);
        /*
         * loga b = log10 b / log10 a
         * log2 N = log10 N / log10 2
         */
        double ceil = Math.ceil(Math.log10(N) / Math.log10(2));
        double baseLength = Math.pow(2, ceil);
        double length = 2 * baseLength;

        int[] arr = new int[(int) length];
        Arrays.fill(arr, 0);
        for (int i = 1; i <= K; i++) {
            String[] split = list.get(i).split(" ");
            if ("A".equalsIgnoreCase(split[0])) {
                insert(arr, split[1], split[2], (int) baseLength);
                recalculateTree(arr, split[1], (int) baseLength);
            } else if ("Q".equalsIgnoreCase(split[0])) {
                int sum = calculateAndGetSum(arr, split[1], split[2], (int) baseLength);
            }
        }
        System.out.println(Arrays.toString(arr));
    }
