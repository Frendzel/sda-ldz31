package pl.sda.poli;

public interface C {

    default void printMyName() {
        System.out.println(this.getClass().getSimpleName());
    }

    String getStatus();
}