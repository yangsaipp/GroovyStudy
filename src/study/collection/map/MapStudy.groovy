package study.collection.map

class MapStudy {
	static main(args) {
//		new MapStudy().base()
//		new MapStudy().iterating()
		new MapStudy().filterAndSearch()
	}
	
	void base() {
		def map = [name:'Gromit', likes:'cheese', id:1234]
		assert map.get('name') == 'Gromit'
		assert map.get('id') == 1234
		assert map['name'] == 'Gromit'
		assert map['id'] == 1234
		assert map.name == 'Gromit'
		assert map.id == 1234
		assert map instanceof java.util.Map
		
		def emptyMap = [:]
		assert emptyMap.size() == 0
//		assert emptyMap.empty
		emptyMap.put("foo", 5)
		assert emptyMap["foo"] == 5
		
		def a = 'Bob'
		def ages =[a: 43]
		assert ages['Bob'] == null
		assert ages['a'] == 43
		
		ages = [(a): 43]
		assert ages['Bob'] == 43
		println ages.getClass()
	}
	
	void iterating() {
		def map = [
			Bob  : 42,
			Alice: 54,
			Max  : 33
		]
	
		map.each {entry ->
			println "Name: $entry.key Age: $entry.value"
		}
		
		map.eachWithIndex {entry, i ->
			println "$i- Name: $entry.key Age: $entry.value"
		}
		
		map.each {key, value ->
			println "Name: $key Age: $value"
		}
		
		map.eachWithIndex {key, value, i ->
			println "$i- Name: $key Age: $value"
		}
		
	}
	
	void filterAndSearch() {
		def people = [
			1: [name:'Bob', age: 32, gender: 'M'],
			2: [name:'Johnny', age: 36, gender: 'M'],
			3: [name:'Claire', age: 21, gender: 'F'],
			4: [name:'Amy', age: 54, gender:'F']
		]
		def bob = people.find{it.value.name == 'Bob'}
		def females = people.findAll{it.value.gender == 'F'}
		def ageOfBob = bob.value.age
		def agesOfFemales = females.collect {
			it.value.age
		}
		
		assert ageOfBob == 32
		assert agesOfFemales == [21,54]
		
		def agesOfMales = people.findAll{id, person->
			person.gender == 'M'
		}.collect{id, person ->
			person.age
		}
		
		assert agesOfMales == [32, 36]
	}
}
