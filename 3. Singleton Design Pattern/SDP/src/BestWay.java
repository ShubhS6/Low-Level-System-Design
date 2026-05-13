class SDPP{
    private static SDPP o;

    private SDPP(){
        System.out.println("Hello Constructor");
    }

    public static SDPP getObject(){
        if(o==null){
            o=new SDPP();
        }
        return o;
    }
}

public class BestWay {
    static void main() {
        SDPP sdp1=SDPP.getObject();
        SDPP sdp2=SDPP.getObject();
        System.out.println(sdp1==sdp2);
    }
}
