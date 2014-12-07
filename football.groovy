import java.util.regex.Matcher
import java.util.regex.Pattern

/*
Part Two: Soccer League Table
The file football.dat contains the results from the English Premier
League for 2001/2. The columns labeled ‘F’ and ‘A’ contain the
total number of goals scored for and against each team in that
season (so Arsenal scored 79 goals against opponents, and had 36
goals scored against them). Write a program to print the name of
the team with the smallest difference in ‘for’ and ‘against’ goals.
*/

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
