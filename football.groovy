smallestSpreadTeam = ""
smallestSpread = Integer.MAX_VALUE

new File("football.dat").eachLine { line -> 
	def group = (line =~ /(\w+)\s+\d+\s+\d+\s+\d+\s+\d+\s+(\d+)\s{2}\-\s{2}(\d+)\s{4}\d+$/)
	assert group.hasGroup()	
	if(group.size() == 1){		
		goalsFor = group[0][2].toInteger()
		goalsAgainst = group[0][3].toInteger()
		//Invert the equation if goalsFor < goalsAgants
		if(goalsFor < goalsAgainst) {
			spread = goalsAgainst - goalsFor
		} else {
			spread = goalsFor - goalsAgainst
		}
		// println group[0][1] + " " + spread
		if(spread < smallestSpread) {
			smallestSpread = spread
			smallestSpreadTeam = group[0][1]
		}
	}
}

println "Team with lowest spread: " + smallestSpreadTeam
