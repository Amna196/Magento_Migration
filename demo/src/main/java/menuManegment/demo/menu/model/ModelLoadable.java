package menuManegment.demo.menu.model;

import menuManegment.demo.menu.entity.Loadable;

import java.io.Serializable;

public interface ModelLoadable<T extends Serializable> extends Loadable<T> {
    void setId(T id);
}
