package rohit.comparable;

public class com  implements comparable_Generics<Exception> {

    @Override
    public void compareTo(Object o) {
        try {
            throw new Exception("Its fucking raw man");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
