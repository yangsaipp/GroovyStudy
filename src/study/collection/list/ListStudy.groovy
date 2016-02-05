package study.collection.list

import javax.management.InstanceOfQueryExp;

class ListStudy {

	static main(args) {
//		listIterting()
//		filterAndSearch()
//		addOrRemove()
		sort()
	}
	
	/**
	 * 基本操作
	 * @return
	 */
	static base() {
		def list = [1,2,3,4]
		assert list.get(0) == 1
		assert list[2] == 3
		assert list instanceof java.util.ArrayList
		assert list[-1] == 4
		println list
		
		def list1 = ['a','b','c','d']
		def list2 = new ArrayList<String>(list1);
		def list3 = list2.clone();
		assert list3 == list1
		list1.putAt(2, 'e')
		assert list1[2] == 'e'
		assert list2.set(2, 'f') == 'c'
		assert list2 == ['a','b','f','d']
		
		println list1
		try {
			//get方法只能是从0开始，getAt以及list[-1]方法可以使用负数
			[1, 2, 3, 4, 5].get(-2)                 // but negative index not allowed with get()
			assert false
		} catch (e) {
			assert e instanceof ArrayIndexOutOfBoundsException
		}
	}
	
	/**
	 * list 遍历
	 * @return
	 */
	static listIterting() {
		[1,2,3].each {
			println "Item: $it"
		}
		//带index的遍历
		['a', 'b', 'c', 'd'].eachWithIndex {it, i ->
			println "$i:$it"		
		}
		
		//带index的遍历
		['a', 'b', 'c', 'd'].eachWithIndex {i, it ->
			println "$i:$it"
		}
		
		def list = [1,2,3]
		assert list.collect {it * 2} == [2,4,6]
		assert list*.multiply(2) == list.collect{it * 2}
		
		def list1 = [0]
		assert list.collect(list1) {it * 2} == [0,2,4,6]
		assert list1 == [0,2,4,6]
		println list
	}
	
	static filterAndSearch() {
		assert [1,2,3].find{it > 1 } == 2
		assert [1,2,3].findAll{it > 1 } == [2,3]
		assert [1,2,3,4,5].findIndexOf {
			it in [3,2,5]
		} == 1
	
		assert [1,2,3,4].indexOf(1) == 0
		assert [1,2,3,4].indexOf(9) == -1
		assert [1,2,3,4].indexOf(4) == 3
		
		assert [1,2,3,4].every{it < 5}
		assert ![1,2,3,4].every{it < 2}
		assert [1,2,3,4].any{it < 2}
		assert [1,2,3,4].sum() == 10
		assert [1,2,3,4].join(":") == '1:2:3:4'
		assert [1,2,3].inject(1) {count, item ->
			count + item
//			print count
//			print item
		} == 7
	
		def list = [9, 4, 2, 10, 5]
		assert list.max() == 10
		assert list.min() == 2
		assert list.max{a,b -> a == b ? 0 : (a < b ? -1 : 1)} == 10
		Comparator mc = {a,b -> a == b ? 0 : (a < b ? -1 : 1)}
		assert list.min(mc) == 2
		def list2 = ['abc', 'z', 'xyzuvw', 'Hello', '321']
		assert list2.min{it.size()} == 'z'
		assert list2.max{it.size()} == 'xyzuvw'
	}
	
	static addOrRemove() {
		def list = []
		assert list.empty
		
		list << 5
		assert list == [5]
		
		list << 7 << 'i' << 11
		assert list == [5,7,'i',11]
		
		list << ['m', 11]
		assert list == [5,7,'i',11, ['m', 11]]
		
		assert ([1, 2] << 3 << [4, 5] << 6) == [1, 2, 3, [4, 5], 6]
		
		assert [1, 2] + 3 + [4, 5] + 6 == [1, 2, 3, 4, 5, 6]
		
		assert [1, 2].plus(3).plus([4, 5]).plus(6) == [1, 2, 3, 4, 5, 6]
		
		def a = [1, 2, 3]
		a += 4      // creates a new list and assigns it to `a`
		a += [5, 6]
		assert a == [1, 2, 3, 4, 5, 6]
		
		assert ['a','b','c','b','b'] - 'c' == ['a','b','b','b']
		assert ['a','b','c','b','b'] - 'b' == ['a','c']
		assert ['a','b','c','b','b'] - ['b','c'] == ['a']
		
		assert [1,2,4,6,8,10,12].intersect([1,3,6,9,12]) == [1,6,12]
		
		assert [1,2,3].disjoint( [4,6,9] )
		assert ![1,2,3].disjoint( [2,4,6] )
	}
	
	static sort() {
		assert [6, 3, 9, 2, 7, 1, 5].sort() == [1, 2, 3, 5, 6, 7, 9]
		
		def list = ['abc', 'z', 'xyzuvw', 'Hello', '321']
		assert list.sort {
			it.size()
		} == ['z', 'abc', '321', 'Hello', 'xyzuvw']
		
		def list2 = [7, 4, -6, -1, 11, 2, 3, -9, 5, -13]
		assert list2.sort { a, b -> a == b ? 0 : Math.abs(a) < Math.abs(b) ? -1 : 1 } ==
				[-1, 2, 3, 4, 5, -6, 7, -9, 11, -13]
		
		
	}
}
