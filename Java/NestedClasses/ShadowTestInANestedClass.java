//kp: https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html 12/6/16
public class ShadowTestInANestedClass { //kp: enclosing/outer class

    public int x = 0;

    class FirstLevel {

        public int x = 1; //kp: this shadows above x 

        void methodInFirstLevel(int x) {  //kp: This method parameter 'x' shadows both x above
            System.out.println("x = " + x); //kp: method parameter (shadows both)
            System.out.println("this.x = " + this.x);//kp: This is second 'x' (member of FirstLevel class
            System.out.println("ShadowTestInANestedClass.this.x = " + ShadowTestInANestedClass.this.x); //kp: this is the 'x' of the outer class
        }
    }

    public static void main(String... args) {
        ShadowTestInANestedClass st = new ShadowTestInANestedClass();
        ShadowTestInANestedClass.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}
