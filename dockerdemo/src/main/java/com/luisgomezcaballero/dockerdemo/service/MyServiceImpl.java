package com.luisgomezcaballero.dockerdemo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.luisgomezcaballero.dockerdemo.model.MyEntity;

@Service
public class MyServiceImpl implements MyService {

	private List<MyEntity> myEntityList;

	{
		myEntityList = new ArrayList<MyEntity>();
		myEntityList.add(new MyEntity(1, "Entity1"));
		myEntityList.add(new MyEntity(2, "Entity2"));
		myEntityList.add(new MyEntity(3, "Entity3"));
	}

	@Override
	public List<MyEntity> readAll() {
		return myEntityList;
	}

	@Override
	public MyEntity readById(long id) {
		for (MyEntity myEntity : myEntityList) {
			if (myEntity.getMyLong() == id) {
				return myEntity;
			}
		}
		return null;
	}

	@Override
	public MyEntity create(MyEntity myEntity) {
		myEntityList.add(myEntity);
		return myEntity;
	}

	@Override
	public MyEntity update(long id, MyEntity myEntity) {
		for (MyEntity myEntityToModify : myEntityList) {
			if (myEntityToModify.getMyLong() == id) {
				int index = myEntityList.indexOf(myEntityToModify);
				myEntityList.set(index, myEntity);
				break;
			}
		}
		return myEntity;
	}

	@Override
	public void deleteById(long id) {
		for (Iterator<MyEntity> iterator = myEntityList.iterator(); iterator.hasNext();) {
			MyEntity myEntity = iterator.next();
			if (myEntity.getMyLong() == id) {
				iterator.remove();
			}
		}
	}

	@Override
	public void deleteAll() {
		myEntityList.clear();
	}

}
