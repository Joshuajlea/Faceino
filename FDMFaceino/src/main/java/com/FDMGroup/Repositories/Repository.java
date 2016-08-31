package com.FDMGroup.Repositories;

import java.util.List;

public interface Repository<T> {

	boolean add(T obj);
	List<T> getAll();
	T getById(String id);
}
