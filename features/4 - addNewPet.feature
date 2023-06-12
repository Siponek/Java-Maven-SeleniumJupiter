
Feature: Add new pet to an owner
  As a user, I want to add a pet to an owner to see if the 
  functionality has been implemented correctly in the PetClinic app
  
Scenario: Add a new pet with valid data
  Given a web browser is on PetClinic app
  When the user goes to 'find owners' web page
  And the user clicks 'Find Owner' button
  And the user clicks "George Franklin"
  And the user clicks 'Add New Pet' button
  And the user inserts pet name with "Charles"
  And the user inserts birth date with "1999-05-30"
  And the user chooses type with "dog"
  And the user clicks 'Add Pet' button
  Then the pet "Charles" is shown in a table in the owner page relating to "George Franklin"

Scenario: Try to add a new pet already present in the DB
  Given a web browser is on PetClinic app
  When the user goes to 'find owners' web page
  And the user clicks 'Find Owner' button
  And the user clicks "George Franklin"
  And the user clicks 'Add New Pet' button
  And the user inserts pet name with "Leo"
  And the user inserts birth date with "1999-05-30"
  And the user chooses type with "bird"
  And the user clicks 'Add Pet' button
  Then the message error "is already in use" is shown in the same page under the input field 'Name'
  
Scenario: Try to add a new pet with invalid data (an empty field)
  Given a web browser is on PetClinic app
  When the user goes to 'find owners' web page
  And the user clicks 'Find Owner' button
  And the user clicks "George Franklin"
  And the user clicks 'Add New Pet' button
  And the user inserts pet name with 'empty string' (i.e., "")
  And the user inserts birth date with "1999-05-30"
  Then the message error "is required" is shown in the same page under the corresponding input field (i.e., pet name)
