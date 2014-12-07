import java.util.regex.Matcher
import java.util.regex.Pattern

/*
Part One: Weather Data
In weather.dat you’ll find daily weather data for Morristown, NJ 
for June 2002. Download this text file, then write a program to 
output the day number (column one) with the smallest temperature
spread (the maximum temperature is the second column, the minimum
the third column).
*/

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
