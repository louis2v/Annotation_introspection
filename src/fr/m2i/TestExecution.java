package fr.m2i;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestExecution {

	public static void run(Object o, int[] params) {

		Method[] methods = o.getClass().getMethods();

		System.out.println(java.util.Arrays.toString(methods[0].getParameters()));
		for (Method method : methods) {
			//Object[] params = ;
			if (method.isAnnotationPresent(Test.class)) {
				runTest(o, method, params);
			}
		}
	}


	private static void runTest(Object o, Method method, int[] params) {
		try {
			method.invoke(o, params[0], params[1]);
			System.out.println("Test " + method.getName() + " ok");
		} catch (InvocationTargetException e) {
			System.err.println("Test " + method.getName() + " ko");
			e.getTargetException().printStackTrace();
		} catch (Exception e) {
			System.err.println("Test " + method.getName() + " ko");
			e.printStackTrace();
		}
	}
}
