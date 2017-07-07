package defaultmethods;

public interface I1 {

	default void calc(){
		System.out.println(12);
	}
}
