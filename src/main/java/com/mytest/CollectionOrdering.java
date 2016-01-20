package com.mytest;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mytest.param.BaseEntity;
import com.mytest.param.Person;
import com.sun.istack.internal.logging.Logger;

public class CollectionOrdering {
    
	
	public static Logger logger = Logger.getLogger(CollectionOrdering.class);       
	
	public static void main(String[] args) {
		
		List<Person> list = Lists.newArrayList();
        list.add(new Person(4L,"jason", "male", 16, 120.50));
        list.add(new Person(1L,"tom", "male", 48, 163.50));
        list.add(new Person(3L,"john", "male", 33, 105));
        list.add(new Person(2L,"rose", "female", 26, 90));
        
        
        logger.info(list.toString());
        
        //分割列表
        List<List<Person>> subList = Lists.partition(list, 2);
        
        logger.info(subList.toString());
        
        for (List<Person> list2 : subList) {
        	//logger.info("----------------------------------");
			//logger.info(list2.toString());
			for (Person person : list2) {
				//logger.info(person.toString());
			}
		}
        
        List<Long> idxx  = entityIds(list);
        logger.info("---------------idxx-------------------");
        logger.info(idxx.toString());
        
        List<Long> ids = Lists.transform(list, new Function<Person, Long>(){
        	public Long apply(Person person){
        		return person.getId();
        	}
        }); 
        logger.info("---------------ids-------------------");
        logger.info(ids.toString());
        
        logger.info("---------------maps-------------------");
        Map<Long, Person> maps = entityMaps(list);
        Set<Long> keys = maps.keySet();
        for (Long id : keys) {
			logger.info("key: " + id + " value: " + maps.get(id));
		}
        
        logger.info("---------------entrySet-------------------");
        Set persons =  maps.entrySet();
        for (Object person : persons) {
			logger.info(person.toString());
		}
        
        
        logger.info("---------------ImmutableSortedMap-------------------");
        Comparator<Long> comparator = new Comparator<Long>(){
        	public int compare(Long a, Long b) {
        		if(a>b)
        			return -1;
        		return 1;
        	}
        };
        
        
        Map<Long, Person> sortMaps= sortMaps(maps, "xxx");
        Set persons2 =  sortMaps.entrySet();
        for (Object person : persons2) {
			logger.info(person.toString());
		}
        
      /*  ImmutableSortedMap.orderedBy(new Comparator<Long>(){
        	public Person compare(Person a, Person b) {
        		if (a.getId()>b.getId())
        		return a;
        	}
        });*/
	}
	
	/**
	 * 获取表记录集合的Id集合
	 * @param list
	 * @return
	 */
	public static<T extends BaseEntity> List<Long> entityIds(List<T> list){
		List<Long> ids = Lists.transform(list, new Function<T, Long>(){
        	public Long apply(T entity){
        		return entity.getId();
        	}
        }); 
		return ids;
	}
	
	/**
	 * 根据实体记录，输出Map<Long id,K extend BaseEntity>集合
	 * @param list
	 * @return
	 */
	public static<V extends BaseEntity> Map<Long,V> entityMaps(List<V> list){
		Map<Long,V> maps = Maps.uniqueIndex(list.iterator(),  new Function<V, Long>() {
		    public Long apply(V entity) {
		        return entity.getId();
		    }
		});
		return maps;
	}
	
	public static<V extends BaseEntity> Map<Long, V> sortMaps(Map<Long, V> maps, String sort){
		Comparator<Long> comparator = null;
		//倒序
		if (sort.equals("desc")){
		    comparator = new Comparator<Long>(){
        	public int compare(Long a, Long b) {
        		if(a>b)
        			return -1;
        		return 1;
        	}
		    };
        }else{
        	//顺序
        	comparator = new Comparator<Long>(){
            	public int compare(Long a, Long b) {
            		if(a>b)
            			return 1;
            		return -1;
            	}};
        }
        
        
        ImmutableSortedMap.Builder<Long, V> sortMapsBuilder = ImmutableSortedMap.orderedBy(comparator);
        ImmutableSortedMap<Long, V> sortMaps= sortMapsBuilder.putAll(maps).build();
        return sortMaps;
	}
	 
	
	
}
