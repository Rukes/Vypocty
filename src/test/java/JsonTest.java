import simplejson.JsonBuilder;

public class JsonTest {

    /**
     * Warning: non string key objects won`t be written in quotation ("key")
     * Output: {"string": "rukes", "int": 2147483647, "long": 1234, 89.12: "double", false: "boolean"}
     */
    public static void main(String[] args){
        JsonBuilder builder = new JsonBuilder();
        builder.append("string", "rukes");
        builder.append("int", Integer.MAX_VALUE);
        builder.append("long", 1234L);
        builder.append(89.12d, "double");
        builder.append(false, "boolean");
        System.out.println(builder.toString());
    }
}
