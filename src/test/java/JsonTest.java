import simplejson.JsonBuilder;

public class JsonTest {

    public static void main(String[] args){
        JsonBuilder builder = new JsonBuilder();
        builder.append("string", "rukes");
        builder.append("int", Integer.MAX_VALUE);
        builder.append("long", 1234L);
        builder.append("double", 89.12d);
        builder.append("boolean", true);
        System.out.println(builder.toString());
    }
}
