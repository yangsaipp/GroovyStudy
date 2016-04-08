 package study.io

class IOStudy {
	static main(arg) {
//		println 'test'
		def path = "E:\\Workspaces\\workspace_eclipse_4\\GroovyStudy\\source\\index.html"
		def study = new IOStudy()
//		study.readFile(path)
//		study.readFileAsList(path)
		study.readFileAsInputStream(path)
	}
	
	def readFile(path) {
		new File(path).eachLine {line, nb ->
			println "line $nb: $line"
			if(nb > 100) {
//				throw new RuntimeException("nb > 100")
			}
		}
	}
	
	def readFileAsList(file) {
		def list = new File(file).collect{it};
		println list.size;
		
		def array = new File(file) as String[]
		println list.size
	}
	
	def readFileAsInputStream(file) {
		new File(file).withInputStream {stream ->
//			def b = new byte[1024];
//			while(stream.read(b, 0, b.length) != -1){
//				println new String(b)
//			}
			
			int b
			List<Integer> byteList = new ArrayList<Integer>()
			int number = 1
			while((b = stream.read()) != -1) {
			//	byte to char
				byteList.add(b)
				if(b == 10) {	// /n »»ÐÐ·û
					def byteA = new byte[byteList.size()];
					byteList.eachWithIndex {it,i ->
						byteA[i] = it
					}
					byteList.clear()
					print "number $number :" + new String(byteA)
					number++
				}
//				println b
			}
			
			if(!byteList.empty) {
				def byteA = new byte[byteList.size()];
				byteList.eachWithIndex {it,i ->
					byteA[i] = it
				}
				byteList.clear()
				print "number $number :" + new String(byteA)
				number++
			}
		}
	}
	
	
}
