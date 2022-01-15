package menuManegment.demo.menu.model;

import java.io.Serializable;
import java.sql.Timestamp;

public abstract class AbstractMenuModel<T extends Serializable> implements ModelLoadable<T>  {

    private Timestamp createdAt;

    private Timestamp updatedAt;

    @Override
    public void setId(T id) {
        return;
    }

    @Override
    public T getId() {
        return null;
    }
}
