import java.util.Scanner;
public class Main {
    public static void main (String[] args) {

        // получаем данные, разделяем полученную строку по пробелу, создаем три переменные где
        // first - первый элемент
        // second - математическая операция
        // fird - третий элемент
        // далее проводим математические операции Int для 1,2,3... Str для I,II,II...

        Scanner s = new Scanner(System.in);
        System.out.println("Введите строку ");

        String typedStr = s.nextLine();
        System.out.println("Вы ввели " +typedStr);
        String [] strings = typedStr.split(" ");

        String first = strings[0];
        String second = strings[1];
        String fird = strings[2];

        // обработка введенных данных
        // пытаемся поменять тип данных на Integer
        // если    получается обрабатываем как Integer
        // если не получается обрабатываем как String  catch (NumberFormatException e)
        try {

            // получаем юникод введенного символа
            // задаем выведенный символ юникод в переменную
            // обрабатывается только первый знак невозможно обработать двойные символы XX
            int firstInt = Integer.parseInt(first.trim());
            int secondInt = second.codePointAt(0);
            int firdInt = Integer.parseInt(fird.trim());

            // обработка математических операций Int
            // переводим математический символ в юникод, на основе полученного числа создаем условие
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

            // завершена обработка Int (Арабски), начинается обработка Str (Римских)
        } catch (NumberFormatException e) {

            // создаем массив для обработки входящих значений от 0 до 10
            // ищем по индексу первый символ в массиве и возвращаем найденный индекс
            String[] romanInput = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",};
            int indexFirst = -1;
            for (int i=0; i<romanInput.length; i++) {
                if (romanInput[i].equals(first)) {
                    indexFirst = i;
                    break;
                }
            }
            if (indexFirst == -1){
                System.out.println("Введено неверное значение " +first);
                indexFirst = 0;
            }

            int indexFird = -1;
            for (int iii=0; iii<romanInput.length; iii++) {
                if (romanInput[iii].equals(fird)) {
                    indexFird = iii;
                    break;
                }
            }
            if (indexFird == -1){
                System.out.println("Введено неверное значение " +fird);
                indexFird = 0;
            }

            // обработка математических операция для романских цифр
            // переводим математический символ в юникод,
            int secondStr = second.codePointAt(0);

            // на основе полученного числа юникод создаем условие
            // в которое прописываем математические операции + - * /
            // в мат операции создаем класс Сonversion в нем метод gettingString для исключения повторов romanList
            switch(secondStr){
                case 43 :
                    // additionStrByIndex - это результат мат операции для Str
                    // отправляем её значение (индекс для массива) в класс conversionSum и метод additionStrByIndex
                    // в ответ получаем значение из массива
                    int additionStrByIndex = indexFirst + indexFird;

                    Сonversion conversionSum = new Сonversion();
                    String additionAfter = conversionSum.gettingString(additionStrByIndex);
                    System.out.println("Сложение Str " +additionAfter);
                    break;
                case 45 :
                    int deductionStrByIndex = indexFirst - indexFird;

                    Сonversion conversionDed = new Сonversion();
                    String deductionAfter = conversionDed.gettingString(deductionStrByIndex);
                    System.out.println("Вычетание Str " +deductionAfter);
                    break;
                case 47 :
                    int divisionStrByIndex = indexFirst / indexFird;

                    Сonversion conversionDiv = new Сonversion();
                    String divisionAfter = conversionDiv.gettingString(divisionStrByIndex);
                    System.out.println("Деление Str " +divisionAfter);
                    break;
                case 42 :
                    int multiplicationStrByIndex = indexFirst * indexFird;

                    Сonversion conversionMult = new Сonversion();
                    String multiplicationAfter = conversionMult.gettingString(multiplicationStrByIndex);
                    System.out.println("Умножение Str " +multiplicationAfter);
                    break;
                // вместо else
                default:
                    System.out.println("Правильно укажите математическую операцию Int (+,-,/,*)");
            }
        }
    }
}
// class Сonversion 2 -> II
// создадим класс для конвертации Арабских цифр в Римские
// в классе создадим массив с полным списком Римских цифр до 100 (макс значение 10*10)
// создадим метод в который передается Арабская цифра 2, по индексу 2 сопоставим цифру II в массиве

class Сonversion{
    String gettingString(int indexInRomanList) {
        String[] romanList = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return romanList[indexInRomanList];
    }
}