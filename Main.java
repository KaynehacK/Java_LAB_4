import java.util.*;

import static java.lang.System.out;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean stop = false;
        out.println("Простолупов Р.Г. | ИТ-11 (ПМИ-1) | ЛАБОРАОРНАЯ РАБОТА №4 | Вариант 4 \nВведите код задания в сответствии с таблицей (при вводе иного значения программа завершит работу):");
        while (!stop) {
            out.printf(
                    "\t\t\t\t,___________________________,\n" +
                    "Код задания:\t| 1 | 2 | 3 | 4 | 5 | 6 | 7 |\n" +
                    "Номер задания:\t|1.1|1.3|2.2|3.1|3.2|3.3|3.4|\n" +
                    "Ввод: ");
            int task = in.nextInt();
            switch (task) {
                case 1: {
                    out.println("Задание 1.1: Класс Коробка для хранения обекта любого типа.");
                    Box<Integer> b1 = new Box<>(3);
                    out.println("Создана коробка целочисленного типа со значением 3.");
                    methodOfBox( b1 );
                    out.println("Коробка передана в метод, который умножает значение на 10. Вывод содержимого коробки: " + b1.get());
                    break;
                }
                case 2: {
                    out.println("Задание 1.3: Интерфейс \"Сравнимое\"");
                    Distance d1 = new Distance(9);
                    Distance d2 = new Distance(7);
                    out.println("Значение первого объекта: " + d1.toString());
                    out.println("Значение второго объекта: " + d2.toString());
                    out.println("Результат выполнения функции: " + d1.Compare(d2));
                    break;
                }
                case 3: {
                    out.println("Задание 2.2: Поиск максимума.");
                    try {
                        List<Box<? extends Number>> BoxArray = new ArrayList<>();
                        Box<Integer> Box1 = new Box<>(12);
                        Box<Long> Box2 = new Box<>(-800L);
                        Box<Float> Box3 = new Box<>(100.001f);
                        Box<Double> Box4 = new Box<>(1000000.1000001);
                        BoxArray.add(Box1);
                        BoxArray.add(Box2);
                        BoxArray.add(Box3);
                        BoxArray.add(Box4);

                        out.println("Создано четыре объекта Box:\n\tInteger: 12,\n\tLong: -800L,\n\tFloat: 100.001f,\n\tDouble: 1000000.1000001;\nНайдено максимальное значение: " + findMax(BoxArray));
                    } catch (Exception e) {
                        out.println("Получена ошибка: " + e.getMessage());
                    }
                    break;
                }
                case 4: {
                    out.println("Задание 3.1: Функция.");
                    List<String> List1 = Arrays.asList("qwerty", "asdfg", "zx");
                    List<Integer> List2 = Arrays.asList(1, -3, 7);
                    List<int[]> List3 = Arrays.asList(new int[]{1,2,3}, new int[]{4,5,-6}, new int[]{7000,800,900});
                    out.println("Список 1: " + List1 + ", результат: " + ApplyList(List1, String::length));
                    out.println("Список 2: " + List2 + ", результат: " + ApplyList(List2, Math::abs));
                    out.println("Список 3: " + Arrays.deepToString(List3.toArray()) + ", результат: " + ApplyList(List3, arr -> Arrays.stream(arr).max().orElse(0)));
                    break;
                }
                case 5: {
                    out.println("Задание 3.2: Фильтр.");
                    List<String> List1 = Arrays.asList("qwerty", "asdfg", "zx");
                    List<Integer> List2 = Arrays.asList(1, -3, 7);
                    List<int[]> List3 = Arrays.asList(new int[]{1,2,3}, new int[]{-4,-5,-6}, new int[]{7000,800,900}, new int[]{-8,-99,0});
                    out.println("Список 1: " + List1 + ", результат: " + Filter(List1, x -> x.length() >= 3));
                    out.println("Список 2: " + List2 + ", результат: " + Filter(List2, x -> x > 0));
                    out.println("Список 3: " + Arrays.deepToString(List3.toArray()) + ", результат: " + Arrays.deepToString(Filter(List3, arr -> Arrays.stream(arr).noneMatch(num -> num > 0)).toArray()));
                    break;
                }
                case 6: {
                    out.println("Задание 3.3: Сокращение.");
                    List<String> List1 = Arrays.asList("qwerty", "asdfg", "zx");
                    List<Integer> List2 = Arrays.asList(1, -3, 7);
                    List<int[]> List3 = Arrays.asList(new int[]{1,2,3}, new int[]{-4,-5,-6}, new int[]{7000,800,900}, new int[]{-8,-99,0});
                    out.println("Список 1: " + List1 + ", результат: " + ReduceList(List1, arr -> String.join("", arr)));
                    out.println("Список 2: " + List2 + ", результат: " + ReduceList(List2, arr -> arr.stream().mapToInt(Integer::intValue).sum()));
                    out.println("Список 3: " + Arrays.deepToString(List3.toArray()) + ", результат: " + Arrays.stream(ReduceList(List3, list -> list.stream().mapToInt(arr -> arr.length).toArray())).sum());
                    break;
                }
                case 7: {
                    out.println("Задание 3.4: Коллекционирование.");
                    List<Integer> List1 = Arrays.asList(1, -3, 7);
                    List<String> List2 = Arrays.asList("qwerty", "asdfg", "zx", "qw");
                    List<String> List3 = Arrays.asList("qwerty", "asdfg", "qwerty", "qw");

                    Map<Boolean, List<Integer>> partitionedNumbers = collect(
                            List1,
                            v -> new HashMap<Boolean, List<Integer>>() {{
                                put(true, new ArrayList<>());
                                put(false, new ArrayList<>());
                            }},
                            (map, num) -> map.get(num > 0).add(num)
                    );
                    System.out.println("Список 1: " + List1 + ", Результат:\n\tПоложительные: " + partitionedNumbers.get(true) + "\n\tОтрицательные: " + partitionedNumbers.get(false));

                    Map<Integer, List<String>> groupedByLength = collect(
                            List2,
                            v -> new HashMap<>(),
                            (map, word) -> map.computeIfAbsent(word.length(), k -> new ArrayList<>()).add(word)
                    );
                    System.out.println("Список 2: " + List2 + " , Результат (Разделение по длинне строки): " + groupedByLength);

                    Set<String> uniqueWords = collect(
                            List3,
                            v -> new HashSet<>(),
                            Set::add
                    );
                    System.out.println("Список 3: " + List3 + ", Результат (Уникальные строки): " + uniqueWords);
                    break;
                }
                default: stop = true;
            }
        }
    }

    public static void methodOfBox(Box<Integer> x){ // Задание 1.1
        int n = 0;
        if (!x.isEmpty()) {n = x.get();}
        else return;
        try {
            x.set(n * 10);
        } catch (Exception e) {}
    }

    public static double findMax(List<Box<? extends Number>> boxes) { // Задание 2.2
        double max = Double.NEGATIVE_INFINITY;
        for (Box<? extends Number> box : boxes) {
            if (!box.isEmpty()) {max = Math.max(max, box.get().doubleValue());}
        }
        return max;
    }

    public static <T, P> List<P> ApplyList(List<T> list, Function<T, P> func) { // Задание 3.1
        return list.stream().map(func::apply).collect(Collectors.toList());
    }

    public static <T> List<T> Filter(List<T> list, Predicate<T> pred) { // Задание 3.2
        return list.stream().filter(pred).collect(Collectors.toList());
    }

    public static <T> T ReduceList(List<T> list, Function<List<T>, T> func) { // Задание 3.3
        return func.apply(list);
    }

    public static <T, P > P collect( // Задание 3.4
            List<T> source,
            Function<Void, P> collectionFactory,
            BiConsumer<P, T> accumulator) {
        P result = collectionFactory.apply(null);
        for (T item : source) {
            accumulator.accept(result, item);
        }
        return result;
    }
}