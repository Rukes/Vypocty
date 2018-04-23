package simplejson;

public class JsonBuilder {

    private StringBuilder builder;

    public JsonBuilder(){
        builder = null;
    }

    public void append(String key, String value){
        if (builder == null) {
            builder = new StringBuilder("{");
        } else {
            builder.append(", ");
        }
        builder.append("\"").append(key).append("\"").append(": \"").append(value).append("\"");
    }

    public void append(String key, int value){
        if (builder == null) {
            builder = new StringBuilder("{");
        } else {
            builder.append(", ");
        }
        builder.append("\"").append(key).append("\"").append(": ").append(value);
    }

    public void append(String key, long value){
        if (builder == null) {
            builder = new StringBuilder("{");
        } else {
            builder.append(", ");
        }
        builder.append("\"").append(key).append("\"").append(": ").append(value);
    }

    public void append(String key, double value){
        if (builder == null) {
            builder = new StringBuilder("{");
        } else {
            builder.append(", ");
        }
        builder.append("\"").append(key).append("\"").append(": ").append(value);
    }

    public void append(String key, boolean value){
        if (builder == null) {
            builder = new StringBuilder("{");
        } else {
            builder.append(", ");
        }
        builder.append("\"").append(key).append("\"").append(": ").append(value);
    }

    @Override
    public String toString() {
        return builder.append("}").toString();
    }
}
