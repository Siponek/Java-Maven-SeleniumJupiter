
Feature: Edit pet
  As a user, I want to edit a pet to see if the 
  functionality has been implemented correctly in the PetClinic app
  
Scenario: Edit pet with valid data (modify date of pet)
  Given a web browser is on PetClinic app
  When the user goes to 'find owners' web page
  And the user clicks 'Find Owner' button
  And the user clicks "George Franklin"
  And the user clicks 'Edit Pet' link of the first pet in the table associated to "George Franklin"
  And the user change the Bith Date in "2020-10-10"
  And the user clicks 'Update Pet' button
  Then the novel date "2020-10-10" of the first pet in the table is visualized instead of the old one
  
  Scenario: Edit pet with valid data (modify type of pet)
  Given a web browser is on PetClinic app
  When the user goes to 'find owners' web page
  And the user clicks 'Find Owner' button
  And the user clicks "George Franklin"
  And the user clicks 'Edit Pet' link of the first pet in the table associated to "George Franklin"
  And the user change the pet's type in "Dog"
  And the user clicks 'Update Pet' button
  Then the novel type "Dog" of the first pet in the table is visualized instead of the old one

Scenario: Try to edit an owner with invalid data (empty name)
  Given a web browser is on PetClinic app
  When the user goes to 'find owners' web page
  And the user clicks 'Find Owner' button
  And the user clicks "George Franklin"
  And the user clicks 'Edit Pet' link of the first pet in the table associated to "George Franklin"
  And the user changes the pet's name with the 'empty string' (i.e, "")
  And the user clicks 'Update Pet' button
  Then in the same web page the error message "is required" appears under the 'Name' field