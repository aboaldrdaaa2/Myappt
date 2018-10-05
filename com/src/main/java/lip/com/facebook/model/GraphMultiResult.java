package lip.com.facebook.model;

public interface GraphMultiResult extends GraphObject {
    GraphObjectList<GraphObject> getData();
}
