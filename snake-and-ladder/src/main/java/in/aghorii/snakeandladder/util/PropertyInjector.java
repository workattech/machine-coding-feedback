package in.aghorii.snakeandladder.util;

import in.aghorii.snakeandladder.util.annotation.InjectProperty;

import java.lang.reflect.Field;

public class PropertyInjector {
    private final PropertyLoader propertyLoader;

    public PropertyInjector(PropertyLoader propertyLoader) {
        this.propertyLoader = propertyLoader;
    }

    public void inject(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectProperty.class)) {
                InjectProperty annotation = field.getAnnotation(InjectProperty.class);
                String propertyValue = propertyLoader.getProperty(annotation.value());

                if (propertyValue != null) {
                    field.setAccessible(true);
                    try {
                        int intValue = Integer.parseInt(propertyValue);
                        field.set(obj, intValue);
                    } catch (IllegalAccessException e) {
                        System.out.println("Error injecting property " + field.getName() + " to " + obj.getClass().getName());
                    }
                }
            }
        }
    }
}
