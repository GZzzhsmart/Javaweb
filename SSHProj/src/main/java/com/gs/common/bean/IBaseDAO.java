package com.gs.common.bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

public abstract interface IBaseDAO {
	public abstract boolean delete(Object paramObject);

	public abstract boolean delAll(Collection paramCollection);

	public abstract boolean save(Object paramObject);

	public abstract boolean saveorUpdate(Object paramObject);

	public abstract boolean update(Object paramObject);

	public abstract Object findObjByID(Class paramClass, Serializable paramSerializable);

	public abstract List findAllByHQL(String paramString);

	public abstract List findByDetached(DetachedCriteria paramDetachedCriteria);

	public abstract List findAll(Object paramObject);

	public abstract List find(String paramString);

	public abstract boolean deleteAll(Collection paramCollection);

	public abstract List findPageByDetached(DetachedCriteria paramDetachedCriteria, int paramInt1, int paramInt2);

	public abstract List findBySQL(String paramString);

	public abstract Integer getCount(DetachedCriteria paramDetachedCriteria);

	public abstract void saveStoredProcedure(String paramString, String[] paramArrayOfString);
}