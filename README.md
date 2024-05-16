# Основная программа

Java-программа, которая считывает числа из текстового файла (readNumbersFromFile) и выполняет базовые математические операции над ними:

* Поиск минимального числа `_min`
* Поиск максимального числа `_max`
* Суммирование всех чисел `_sum`
* Произведение всех чисел `_mult`
## Использование
1. Создайте текстовый файл с именем "numbers.txt" и запишите в него числа, разделенные пробелами.
2. Скомпилируйте и запустите программу `main.Main.java`.
3. Программа выведет в консоль минимальное, максимальное число, сумму и произведение всех чисел из файла.

> [!IMPORTANT]
> Программа работает только с целыми числами.
_______
# Тестирование
В test.NumberAnalyzerTest включены модульные тесты (JUnit) для проверки функциональности программы. Тесты проверяют:
* Корректность нахождение минимума `testFindMin`
* Корректность нахождение максимума `testFindMax`
* Корректность суммирования чисел `testSum`
* Корректность произведения всех чисел `testMultiply`
* Корректность выполнения общего теста `testMinMaxSumMultInt` *(этот тест проверяет все описанные выше математические операции)*
* Производительность математических функций при увеличении размера входного файла `testPerformanceSum`, `testPerformanceMin`, `testPerformanceMax`, `testPerformanceMult` (сумма, минимум, максимум, произведение соответственно)
  * Эти тесты создают 10 файлов с количеством значений от 1 до 1 млн (каждый раз количество чисел в файле увеличивается в 10 раз)
  * Отдельно для теста `testPerformanceMult` написан график на Python ниже
* Корректность работы с отрицательными числами `testNegativeNumbers`
* Корректность чтения файла `testReadNumbersFromFile`

Есть дополнительная функция `createFileWithNumbers`, которая создаёт файлы для прохождения теста `testPerformanceSum` и тп.

_______
# График
Для построения графика был взят один из результатов теста `testPerformanceMult`:
* Размер файла: 1, Время выполнения: 0.01106 мс
* Размер файла: 10, Время выполнения: 0.010518 мс
* Размер файла: 100, Время выполнения: 0.033763 мс
* Размер файла: 1000, Время выполнения: 0.26855 мс
* Размер файла: 10000, Время выполнения: 1.880772 мс
* Размер файла: 100000, Время выполнения: 17.708003 мс
* Размер файла: 1000000, Время выполнения: 33.199771 мс

## Программа для построение графа:
```python
import matplotlib.pyplot as plt

file_sizes = [1, 10, 100, 1000, 10000, 100000, 1000000]
execution_times = [0.01106, 0.010518, 0.033763, 0.26855, 1.880772, 17.708003, 33.199771]

plt.plot(file_sizes, execution_times, marker='o', color='b', linestyle='-')

plt.title('Зависимость времени выполнения от количества чисел в файле')
plt.xlabel('Размер файла')
plt.ylabel('Время выполнения (мс)')

plt.xscale('log')  

plt.grid(True)
plt.show()
```


## Результат программы:

![Figure_1 2](https://github.com/Pa-u-li-na/Task-2/assets/166948085/a0825b55-b272-42f3-974d-cb14c87136ec)
