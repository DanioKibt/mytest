package com.mytest.javaSJMS.gczms.selfExample;

/**
 * 被观察者接口
 * @author cyz
 *
 */
public interface Subject {

	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObserver();
}
