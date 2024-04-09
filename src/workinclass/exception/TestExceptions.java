package workinclass.exception;

// Исключительная ситуация это не ошибка, это исключительная ситуация, требующая реакции программиста.
// - Синхронные исключения. Например, это деление на 0 в целых числах, или "Не найден открывающийся файл", нехватка памяти и тд.
// - Асинхронные исключения. Могут произойти в любой момент работы программы, независимо от ее логики.

import java.io.IOException;

public class TestExceptions {
    public static void main(String[] args) { // если throws выбросить в main, то оно пойдет в jm - красная ошибка,
                                             // будто ничего не обработали
        try {
            demoExceptions(2);
        } catch (ArithmeticException arithmeticException){ // Чем более серьезное исключение тем ниже его пишем
            System.out.println("ArithmeticException: " + arithmeticException.getLocalizedMessage());
        } catch (IOException ioException){
            System.out.println("IOException: " + ioException.getLocalizedMessage());
        } catch (MyException myException){
            System.out.println("MyException: " + myException.getLocalizedMessage() + ": " + myException.getValue());
        }

        System.out.println("End of main");
    }

    private static void demoExceptions(int x) throws IOException, MyException {
        switch (x){
            case 0:
                int y = 1 / x;
                break;
            case 1:
                throw new IOException("IO trouble"); // Выброс исключения вручную
                // после throw break не нужен, т.к и так выбросит
            case 2:
                throw new MyException("Value exception", 1024);
            default:
                System.out.println("Ok");
        }
    }
}

// Создание своего исключения
class MyException extends Exception {
    private int value;

    public MyException(String message, int value) {
        super(message);
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}