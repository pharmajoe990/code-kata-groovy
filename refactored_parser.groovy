smallestSpreadKey = ""
smallestSpread = Integer.MAX_VALUE

fileName = args[0]

//TODO How to differentiate between the regex used??
def footballExp = ~/(\w+)\s+\d+\s+\d+\s+\d+\s+\d+\s+(\d+)\s{2}\-\s{2}(\d+)\s{4}\d+$/
def weatherExp = ~/^\s+(\d+)\s+(\d+)\s+(\d+)/

//parse the file
println "Parsing " + fileName
new File(fileName).eachLine { line -> 

	def footballMatcher = line =~ footballExp
	def weatherMatcher = line =~ weatherExp

	if(footballMatcher.find()) {
		def group = (line =~ footballExp)
		parseLine(group)
	} else if(weatherMatcher.find()) {
		def group = (line =~ weatherExp)
		parseLine(group)
	} else {
		println "Discarded a line (no match)"
	}
	
}

//Setup expression for evaluation and line parsing
def parseLine(group) {
	assert group.hasGroup()	
	if(group.size() == 1){		
		high = group[0][2].toInteger()
		low = group[0][3].toInteger()
		//Invert the equation if high < goalsAgants
		if(high < low) {
			spread = low - high
		} else {
			spread = high - low
		}
		// println group[0][1] + " " + spread
		if(spread < smallestSpread) {
			smallestSpread = spread
			smallestSpreadKey = group[0][1]
		}
	}
}

println "Lowest spread was for: " + smallestSpreadKey + " value: " + smallestSpread