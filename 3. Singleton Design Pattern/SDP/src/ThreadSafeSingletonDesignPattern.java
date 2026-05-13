class TSSDP{
    private static TSSDP o;
    private TSSDP() {
        System.out.println("Hello thread safe");
    }
    public static TSSDP getObject() {
        synchronized (TSSDP.class) {
            if (o == null) {
                o = new TSSDP();
            }
            return o;
        }
    }
}

public class ThreadSafeSingletonDesignPattern {
    static void main() {
        TSSDP t1=TSSDP.getObject();
        TSSDP t2=TSSDP.getObject();
        System.out.println(t1==t2);
    }
}
