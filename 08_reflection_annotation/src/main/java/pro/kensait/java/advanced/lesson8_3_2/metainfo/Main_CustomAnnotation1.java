package pro.kensait.java.advanced.lesson8_3_2.metainfo;

public class Main_CustomAnnotation1 {
    public static void main(String[] args) {
        MyMetaInfo classAnno = Greeting.class.getAnnotation(MyMetaInfo.class);
        System.out.println("MyMetaInfo#value => " + classAnno.value());
    }
}