import java.util.Scanner;
public class Main {
    public static void main (String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Введите строку ");
        // получаем данные, тип данных строка
        String typedStr = s.nextLine();
        System.out.println("Вы ввели " +typedStr);
        // режем строку по пробелу,
        String [] strings = typedStr.split(" ");
        // выводим значения массива
        String first = strings[0];
        String second = strings[1];
        String fird = strings[2];

        System.out.println("Первый элемент массива " +first);
        System.out.println("Второй элемент массива " +second);
        System.out.println("Третий элемент массива " +fird);

        // меняем тип данных на integer
        // пытаемся поменять тип данных если не получается обрабатываем как String
        try {
            int test = Integer.parseInt(first.trim());
        } catch (NumberFormatException e) {

            // возвращает номер символа в кодировке юникод
            int firstStr = first.codePointAt(0);
            System.out.println("Первый символ тип String " +firstStr);
            // обрабатываем второй символ (мат операция)
            // получаем значение в юникод
            int secondStr = second.codePointAt(0);
            System.out.println("Второй символ тип String " +secondStr);
            // возвращает номер символа в кодировке юникод
            int firdStr = fird.codePointAt(0);
            System.out.println("Третий символ тип String " +firdStr);

            // переводим I , V , X в цифровые значения путем вычитания
            // первое введенное значение
            switch(firstStr) {
                // I юникод 73 = 1
                case 73:
                    firstStr = firstStr - 72;
                    break;
                // V юникод 86 = 5
                case 86:
                    firstStr = firstStr - 81;
                    break;
                // X юникод 88 = 10
                case 88:
                    firstStr = firstStr - 78;
                    break;
                // вместо else
                default:
                    System.out.println("Правильно укажите число 1 Str (I, V, X)");
            }
            // переводим I , V , X в цифровые значения путем вычитания
            // первое введенное значение
            switch(firdStr) {
                // I юникод 73 = 1
                case 73:
                    firdStr = firdStr - 72;
                    break;
                // V юникод 86 = 5
                case 86:
                    firdStr = firdStr - 81;
                    break;
                // X юникод 88 = 10
                case 88:
                    firdStr = firdStr - 78;
                    break;
                // вместо else
                default:
                    System.out.println("Правильно укажите число 2 Str (I, V, X)");
            }
            // обработка математических операций Str
            // переводим математический символ в юникод, на основе числа создаем условие
            switch(secondStr){
                case 43 :
                    int additionStr = firstStr + firdStr;
                    System.out.println("Сложение Str " +additionStr);
                    break;
                case 45 :
                    int deductionStr = firstStr - firdStr;
                    System.out.println("Вычетание Str " +deductionStr);
                    break;
                case 47 :
                    int divisionStr = firstStr / firdStr;
                    System.out.println("Деление Str " +divisionStr);
                    break;
                case 42 :
                    int multiplicationStr = firstStr * firdStr;
                    System.out.println("Умножение Str " +multiplicationStr);
                    break;
                // вместо else
                default:
                    System.out.println("Правильно укажите математическую операцию Str (+,-,/,*)");

            }
            // выход из цикла Str
            // если введеное число больше 0 завершаем работу программы
            if (firstStr > 0){
                System.out.println("Обработка str завершеная");
                System.exit (1);
            }
        }

        // Обработка данных как Integer
        // меняем тип данных на integer
        int firstInt = Integer.parseInt(first.trim());
        System.out.println("Первый символ в Integer " +firstInt);
        // юникод введенного символа
        // задаем выведенный символ юникод в переменную
        // обрабатывается только первый знак
        int secondInt = second.codePointAt(0);
        System.out.println("Второй символ в Integer " +secondInt);
        int firdInt = Integer.parseInt(fird.trim());
        System.out.println("Третий символ в Integer " +firdInt);

        // обработка математических операций Int
        // переводим математический символ в юникод, на основе числа создаем условие
        switch(secondInt){
            case 43 :
                int addition = firstInt + firdInt;
                System.out.println("Сложение Int " +addition);
                break;
            case 45 :
                int deduction = firstInt - firdInt;
                System.out.println("Вычетание Int " +deduction);
                break;
            case 47 :
                int division = firstInt / firdInt;
                System.out.println("Деление Int " +division);
                break;
            case 42 :
                int multiplication = firstInt * firdInt;
                System.out.println("Умножение Int " +multiplication);
                break;
            // вместо else
            default:
                System.out.println("Правильно укажите математическую операцию Int (+,-,/,*)");
        }
    }
}