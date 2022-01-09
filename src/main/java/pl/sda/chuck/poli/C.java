package pl.sda.chuck.poli;

public interface C {

    default void printMyName() {
        System.out.println(this.getClass().getSimpleName());
    }
}