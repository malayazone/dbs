Feature: Search web link in google search page

Scenario: Search valid search web links
	Given go to google
	When enter text in search box
	And click the search button
	Then the web links will display