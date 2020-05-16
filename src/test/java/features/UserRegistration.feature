Feature: User Registration
   I want to check that the user register in our e-commerce website.
    
  Scenario Outline: User Registration
  Given the user in the home page 
  When i click on register link 
  And i entered "<firstname>" , "<lastname>" , "<email>" , "<password>"
  Then the registration page displayed successfully
  
  Examples:
  | firstname  | lastname | email | password | 
  |mahmoud | gawish | ndfsnjs@test.com | 12368999 |
  |ahmed | hhjkl | nsndsndfds@test.com | 1236858999 |

  
  

