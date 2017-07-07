package defaultmethods;

public interface I2 extends I1{

	default void calc(){
		System.out.println(30);
	}
}
