package Test;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws Exception {
        Test testObject = new Test();
        Class<Test> testClassAsClass = (Class<Test>) testObject.getClass();
        Field testField = testClassAsClass.getField("testField");
        System.out.println(testField.getType());

        Field[] fields = testClassAsClass.getFields();

        for (Field field : fields) {
            System.out.println(field.getType() + " " + field.getName());
        }

        System.out.println(testObject.testField);
        testField.set(testObject, 777);
        System.out.println(testObject.testField);

        Field privateField = testClassAsClass.getDeclaredField("testPrivate");
        System.out.println(privateField.getName());
        privateField.setAccessible(true);
        privateField.set(testObject, "VVE");
        System.out.println(testObject.getTestPrivate());
    }
}
