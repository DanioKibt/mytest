package com.mytest.javaSJMS.gczms.javaAPIExample;

/**
 * 观察者模式
 * 优点：观察者模式解除了主题和具体观察者的耦合，让耦合的双方都依赖于抽象，而不是依赖具体。从而使得各自的变化都不会影响另一边的变化
 * 缺点：依赖关系并未完全解除，抽象通知者依旧依赖抽象的观察者
 * 适用：1、当一个对象的改变需要给变其它对象时，而且它不知道具体有多少个对象有待改变时。
 *      2、一个抽象某型有两个方面，当其中一个方面依赖于另一个方面，这时用观察者模式可以将这两者封装在独立的对象中使它们各自独立地改变和复用。
 * @author cyz
 *
 */
public class Test {

	public static void main(String[] args) {
		Doll d=new Doll("test1");
		Person p1=new Person("张三");
		Person p2=new Person("李四");
		d.addObserver(p1);
		d.addObserver(p2);
		System.err.println("------------------------------");
		d.setPrice("test2");
		System.err.println("------------------------------");
		d.setPrice("test3");
	}
}
