
package com.ipuc.base.membresia;

import java.util.List;

/**
 *
 * @author wilson-rivera
 */
public interface MembresiaManager {

    public void create(Membresia membresia);

    public void update(Membresia membresia) throws Exception;

    public Membresia find(String cod_congregacion) throws Exception;

    public List<Membresia> findAll() throws Exception;

}
