package com.mytest.collect;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
import com.sun.istack.internal.logging.Logger;

/**
 * 
 * @author lifeng
 *
 */
public class RangeMapTest {
	
	public static Logger logger = Logger.getLogger(RangeMapTest.class);
	
	@Test
	public void google_guava_range_map_example () {

	    RangeMap<Integer, String> gradeScale = TreeRangeMap.create();
	    gradeScale.put(Range.closed(0, 60), "F");
	    gradeScale.put(Range.closed(61, 70), "D");
	    gradeScale.put(Range.closed(71, 80), "C");
	    gradeScale.put(Range.closed(81, 90), "B");
	    gradeScale.put(Range.closed(91, 100), "A");
	    
	    String grade = gradeScale.get(77);
	    assertThat("C").isEqualTo(grade);
	    
	    grade = gradeScale.get(90);
	    assertThat("B").isEqualTo(grade);
	}
	
	
	
}
