
Feature: Find owners
  As a user, I want to find an owner using the last name to see if the 
  functionality has been implemented correctly in the PetClinic app
  
Scenario: Searching an owner by looking at the complete list of Owners
  Given a web browser is on PetClinic app
  When the user goes to 'find owners' web page
  And the user clicks search button
  And a novel web page containing a table listing all the owners is shown
  And the user clicks the owner with last name "Franklin"
  Then a novel web page containing the owner information of "George Franklin" is shown

Scenario: Searching an existing owner in the list
  Given a web browser is on PetClinic app
  When the user goes to 'find owners' web page
  And the user inserts "Black" into the search box named 'Last name'
  And the user clicks search button
  Then a novel web page containing the owner information of "Black" is shown

Scenario: Searching an owner NOT present in the list
  Given a web browser is on PetClinic app
  When the user goes to 'find owners' web page
  And the user inserts "Bianchi" into the search box named 'Last name'
  And the user clicks search button
  Then in the same web page the error message "has not been found" appears under the search box
