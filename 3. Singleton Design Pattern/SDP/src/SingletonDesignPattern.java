class SDP{
    private static SDP o;

    private SDP(){
        System.out.println("Hello Constructor");
    }

    public static SDP getObject(){
        if(o==null){
            o=new SDP();
        }
        return o;
    }
}

public class SingletonDesignPattern {
    static void main() {
        SDP sdp1=SDP.getObject();
        SDP sdp2=SDP.getObject();
        System.out.println(sdp1==sdp2);
    }
}
