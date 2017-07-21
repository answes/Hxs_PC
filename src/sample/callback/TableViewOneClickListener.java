package sample.callback;

/**
 * 单击tableview的回掉
 */
public interface TableViewOneClickListener<T> {
    void onClick(T cls);
}
