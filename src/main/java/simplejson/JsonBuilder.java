package simplejson;

public class JsonBuilder {

    private StringBuilder builder;

    /***
     * Simple JSON builder intial constructor
     */
    public JsonBuilder(){
        builder = null;
    }

    /**
     * Append key & value to JSON builder
     * @param key key object to append
     * @param value value object to append
     * @return current JsonBuilder
     *
     * Non string key objects won`t be written in quotation ("key")
     */
    public JsonBuilder append(Object key, Object value){
        if (builder == null) {
            builder = new StringBuilder("{");
        } else {
            builder.append(", ");
        }
        if (key instanceof String){
            builder.append("\"").append(key).append("\"");
        } else{
            builder.append(key);
        }
        builder.append(": ");
        if (value instanceof String){
            builder.append("\"").append(value).append("\"");
        } else{
            builder.append(value);
        }
        return this;
    }

    @Override
    public String toString() {
        return builder.append("}").toString();
    }

    @Deprecated
    public StringBuilder getBuilder() {
        return builder;
    }
}
