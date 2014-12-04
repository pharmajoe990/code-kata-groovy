import java.util.regex.Matcher
import java.util.regex.Pattern

smallestSpreadDayNum = 0
smallestSpread = Integer.MAX_VALUE

new File("weather.dat").eachLine { line -> 
	def group = (line =~ /^\s+(\d+)\s+(\d+)\s+(\d+)/)
	assert group.hasGroup()	
	if(group.size() == 1){		
		maxTemp = group[0][2].toInteger()
		minTemp = group[0][3].toInteger()
		tempSpread = maxTemp - minTemp
		if(tempSpread < smallestSpread) {
			smallestSpread = tempSpread
			smallestSpreadDayNum = group[0][1]
		}
	}
}

println "Lowest temp. spread occured on day " + smallestSpreadDayNum
