Feature: when I go to the Google search page, and search for an item,
		I expect to see some reference to that item in the result summary.

Scenario:
	Given that I have gone to the Google page
	When I add "<url>" to the search box
	And click the Search Button
	Then "cats" should be mentioned in the results