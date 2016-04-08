package study.collection.range

class RangeStudy {
	static main(arg) {
		range()
	}
	
	
	def static range() {
		def range = 5..8
		assert range.size() == 4
		assert range[2] == 7
		assert range instanceof java.util.List
		assert range.get(2) == 7
		assert range.contains(7)
		assert range.contains(8)
		
		range = 5..<8
		assert range.size() == 3
		assert range[2] == 7
		assert range.contains(7)
		assert !range.contains(8)
		
		range = 1..10
		assert range.from == 1
		assert range.to == 10
		
		for (i in range) {
			println "range for: $i "
		} 
		
		range.each { i ->
			println "range each: $i"
		}
		
		switch(5) {
			case 1..3 : println '1-3';break;
			case 4..6 : println '4-6';break;
			default : println 'unkown'
		}
	}
	
	
}
