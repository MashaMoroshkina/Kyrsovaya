import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Выводим сообщение с информацией о работе программы
        System.out.println("""
                Данная программа определяет тип файла по его содержимому и востановливает утеренное расширение.
                Программа может распознать только данные расширения: gif, exr, exe, png, pdf, jpg, rar.
                Обратите внимание! Запуская программу из командной строки, убедитесь,
                что вы используете исключительно символы ASCII кода для ввода пути к файлу.""");

        // Создаем объект класса Scanner для чтения данных с клавиатуры
        Scanner scanner = new Scanner(System.in);
        // Создаем переменную для записи ответа пользователя
        String continuationOfWork;

        // Работа основной программы
        Expansion.expansion();

        boolean answer;
        do {
            // Задаем вопрос пользователю, требуется ли запустить программу снова
            System.out.println("Хотите запустить программу вновь? (Да/Нет)");

            // Считываем введенную строку с помощью метода nextLine()
            continuationOfWork = scanner.nextLine();

            // Определяем дальнейшую работу программы после ввода пользователем своего ответа с помощью метода класса
            answer = Expansion.yesOrNo(continuationOfWork);
        } while (answer);

    }

}
