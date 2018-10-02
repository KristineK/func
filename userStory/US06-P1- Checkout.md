# Checkout process
Priority 1
## Description
Checkout functionality should allow user to buy desired Products
## Acceptance criteria
1)	In shopping cart page there should be link to Checkout
2) There should be direct link to Checkout on top menu
3)	In shopping cart popup on right side should be link to Checkout
4)	For non authorized users there should be page with guest checkout and ability to register and ability to login with existing account
5)	During checkout process it is option to use existing address or add new one
6)	It should be possibility to choose Payment method ( 1 currently)
7)  Checkout process can't be finished without checking "I have read and agree to the Terms & Conditions"
8)  Checkout page summary should have all correct information entered before
9)  Checkout process shouldn't proceed with the out of stock items

## Highlights for testing
For out of stock product use product -tablet "Space Tab 10.1"


## Tests
### Scenario US06-T01: Validate checkout process for guest user
1) Go to homepage
2) Move to "Featured" section and press "Add to cart"
3) Navigate to "Shoping cart page" and click "Checkout" button
4) Mark "Guest Checkout" checkbox and press "Continue"
5) Fill billing details and click "Continue"
6) At "Deliver Method" step, click "Continue"
7) At "Payment Methid" step, check "Terms & Conditions" checkbox and click "Continue"
8) At "Confirm Order" step, click "Confirm Order"
9) See that Checkout Process is successful


### Scenario US06-T02: Validate checkout process for loged in user
1) Go to homepage
2) Move to "Featured" section and press "Add to cart"
3) Navigate to "Shoping cart page" and click "Checkout" button
4) Mark "Guest Checkout" checkbox and press "Continue"
6) At "Deliver Method" step, click "Continue"
7) At "Payment Methid" step, check "Terms & Conditions" checkbox and click "Continue"
8) At "Confirm Order" step, click "Confirm Order"
9) See that Checkout Process is successful

 
## Bugs
### Bug US06-B01:
**Steps:** 

**Actual:** 

**Expected:**