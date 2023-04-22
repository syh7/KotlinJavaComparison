package example.staticexample;

public class JavaStaticExample {

    public static void main(String[] args) {
        javaStatic();

        KotlinStaticExample.OtherObject.INSTANCE.otherObject();

        KotlinStaticExample.CompanionName.nonJvmStatic();
        KotlinStaticExample.CompanionName.jvmStatic();
        KotlinStaticExample.CompanionName.getNON_CONSTANT();
        int constant = KotlinStaticExample.CONSTANT;

    }

    private static void javaStatic() {
        System.out.println("javaStatic");
    }

}
