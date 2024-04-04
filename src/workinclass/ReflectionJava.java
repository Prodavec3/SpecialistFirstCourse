package workinclass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

// Рефлексия проходит мимо инкапсуляции, ниже самый простой пример рефлексии

public class ReflectionJava {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        // Получаем с помощью рефлексии класс String
        Class classString = Class.forName("java.lang.String");

        for(Method method : classString.getMethods()){
            System.out.println(method); // method.getName вывести названия методов
        }

        String modifierStrMethod = Modifier.toString(classString.getModifiers());
        System.out.println("\nModifier String class: " + modifierStrMethod);

        String nameSuperClassString = classString.getSuperclass().getName();
        System.out.println("\nName super class for String: " + nameSuperClassString);

        Class myClass = Class.forName("workinclass.ReflectionJava");
        Class[] argTypes = new Class[2]; // 2 аргумента у необх. метода
        argTypes[0] = Integer.TYPE;
        argTypes[1] = Integer.TYPE; // либо так, либо передаем сразу во вх. параметры getMethod
        Method summMethod = myClass.getMethod("summ", argTypes[0], argTypes[1]);

        Integer returnValue1 = (Integer) summMethod.invoke(
                new ReflectionJava(), new Integer(2), new Integer(22));

        Integer returnValue2 = (Integer) summMethod.invoke(
                new ReflectionJava(), 4, 5); // Работаем не с int, а с оберткой Integer

        System.out.println("\nSumm: " + returnValue1 + " and " + returnValue2);
    }



    public int summ(int a, int b){
        return a + b;
    }
}
