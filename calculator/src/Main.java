import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException{

        Scanner s = new Scanner(System.in);
        System.out.println("Введите строку ");

        String input = s.nextLine();
        System.out.println("Вы ввели " +input);
        String [] strings = input.split(" ");

        // обработка больше 3-х символов, обращение к несуществующему элементу массива +1
        if (strings.length > 3) {
            String fourth = strings[strings.length+1];
            System.out.println("Exception " +fourth);
        }

        String result = calc (input);
        System.out.println("Вывод из метода calc " +result);
    }
    public static String calc (String input) throws IOException{

        String [] strings = input.split(" ");

        String first = strings[0];
        String second = strings[1];
        String third = strings[2];

        // пытаемся перевести 2 Str -> 2 Int
        try {

            int intFirst = Integer.parseInt(first.trim());
            int intThird = Integer.parseInt(third.trim());

            // проверяем введенное арабское значение на диапазон {1...10}
            if ((intFirst < 1) || (intFirst > 10) || (intThird < 1) || (intThird > 10)) {
                String fourth = strings[strings.length+1];
                System.out.println("Exception " +fourth);
            }

            // получаем номер символа математической операции в юникод
            int secondInt = second.codePointAt(0);

                // по полученному номеру проводим мат операцию и возвращаем результат
                switch (secondInt) {
                    case 43:
                        int intSum = intFirst+intThird;
                        input = String.valueOf(intSum);
                        return "сложение Int "+input;
                    case 45:
                        int intDed = intFirst-intThird;
                        input = String.valueOf(intDed);
                        return "вычетание Int "+input;
                    case 47 :
                        int intDiv = intFirst / intThird;
                        System.out.println("деление Int " +intDiv);
                        break;
                    case 42 :
                        int intMul = intFirst * intThird;
                        System.out.println("умножение Int " +intMul);
                        break;
                    // вместо else, выбрасываем ошибку для неверной мат операции Int (+,-,/,*)
                    default:
                        throw new IOException();
                        // return exception;

                }
            return input;
        }
            // после неудачной попытки 2 -> 2
            // переводим II -> 2 через индекс enum RomanListIn, +1 для смещения индекса на 1 позицию
            // если значение не находится в RomanListIn то сразу выбрасывается исключение
            catch (NumberFormatException e) {
                {
                    int strFirst = (RomanListIn.valueOf(first).ordinal()) + 1;
                    int strThird = (RomanListIn.valueOf(third).ordinal()) + 1;

                    // получаем номер математической операции в юникод
                    int secondStr = second.codePointAt(0);

                    // по полученному номеру проводим мат операцию и получаем результат
                    // String.valueOf(RomanList.values()[strSum]); получаем значение по номеру индекса из enum RomanListOut
                    switch (secondStr) {
                        case 43:
                            int strSum = strFirst+strThird-1;
                            input = String.valueOf(RomanListOut.values()[strSum]);
                            return "сложение Str "+input;

                        case 45:
                            int strSub = strFirst-strThird-1;
                            input = String.valueOf(RomanListOut.values()[strSub]);
                            return "вычитание Str "+input;

                        case 47:
                            int strDiv = (strFirst / strThird)-1;
                            input = String.valueOf(RomanListOut.values()[strDiv]);
                            return "деление Str "+input;

                        case 42:
                            int strMul = (strFirst * strThird)-1;
                            input = String.valueOf(RomanListOut.values()[strMul]);
                            return "умножение Str "+input;

                        default:
                            throw new IOException();
                            //return exception+"Int";
                    }

                }
            }
        //return input+" test"; используется если нет return из switch
    }
}

// список для входящих Римских значений
enum RomanListIn {I, II, III, IV, V, VI, VII, VIII, IX, X};

// список для исходящих Римских значений
enum RomanListOut {I, II, III, IV, V, VI, VII, VIII, IX, X, XI, XII, XIII, XIV, XV, XVI, XVII, XVIII, XIX, XX,
        XXI, XXII, XXIII, XXIV, XXV, XXVI, XXVII, XXVIII, XXIX, XXX, XXXI, XXXII, XXXIII, XXXIV, XXXV, XXXVI, XXXVII, XXXVIII, XXXIX, XL,
        XLI, XLII, XLIII, XLIV, XLV, XLVI, XLVII, XLVIII, XLIX, L, LI, LII, LIII, LIV, LV, LVI, LVII, LVIII, LIX, LX,
        LXI, LXII, LXIII, LXIV, LXV, LXVI, LXVII, LXVIII, LXIX, LXX, LXXI, LXXII, LXXIII, LXXIV, LXXV, LXXVI, LXXVII, LXXVIII, LXXIX, LXXX,
        LXXXI, LXXXII, LXXXIII, LXXXIV, LXXXV, LXXXVI, LXXXVII, LXXXVIII, LXXXIX, XC, XCI, XCII, XCIII, XCIV, XCV, XCVI, XCVII, XCVIII, XCIX, C
        };