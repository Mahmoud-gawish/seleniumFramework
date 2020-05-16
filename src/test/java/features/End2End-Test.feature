Feature: Automated End2End Test
   Description : The Purpose of this feature is test End 2 End integration.
   
   Scenario: Customer place an order by purchasing an item from search
   Given User is on Home Page 
   When he searched for "<productName>"
   And choose to buy two items 
   And move to checkout cart and enter personal details on checkout page and place the order 
   Then he can view the order and download the invoice 
   
   
   Examples:
    | productName              |
    |Apple MacBook Pro 13-inch|

