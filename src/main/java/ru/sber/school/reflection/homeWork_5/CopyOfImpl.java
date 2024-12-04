package ru.sber.school.reflection.homeWork_5;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CopyOfImpl {
    public void copy(Object from, Object to) throws InvocationTargetException, IllegalAccessException {
        List<Method> getMethods = getMethod(from);
        List<Method> setMethods = setMethod(to);

        for (Method setMethod : setMethods) {
            for (Method getMethod : getMethods) {
                if (setMethod.getParameterTypes()[0].isAssignableFrom(getMethod.getReturnType())) {
                    Object value = getMethod.invoke(from);
                    setMethod.invoke(to, value);
                }
            }
        }

    }

    private List<Method> getMethod(Object clazz) {
        Method[] methods = clazz.getClass().getMethods();
        List<Method> methodList = new ArrayList<>();
        for (Method method : methods) {
            if (method.getName().startsWith("get")) {
                methodList.add(method);
            }
        }
        return methodList;
    }

    private List<Method> setMethod(Object clazz) {
        Method[] methods = clazz.getClass().getMethods();
        List<Method> methodList = new ArrayList<>();
        for (Method method : methods) {
            if (method.getName().startsWith("set")) {
                methodList.add(method);
            }
        }
        return methodList;
    }
}
