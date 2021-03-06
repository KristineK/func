# Shopping cart
Priority 1
## Description
Available products could be added to shopping cart and all prices are calculated correctly
## Acceptance criteria
1)	One product added to the cart and can be visible in cart with correct prices
2)  Items with required fields can't be added to the shopping cart while all required fields are filled
2)	Shopping cart should be visible in all pages on top menu and on menu on the right
3)	Item count and prices should be displayed correctly on shopping cart button / link
4)	It should be possibility increase / decrease product count in shopping cart
5)	Prices should be calculated correctly on item list changes
6)  Items That are out of stock - should be marked with *** and there should be notice in red " Products marked with *** are not available in the desired quantity or not in stock!"


## Highlights for testing
For out of stock product use product Tablet : "Space Tab 10.1"
For most required field product use Desktop: Appricot Cinema 30


 ____________________
## Tests
### Scenario US05-T01: Add a product from homepage to cart
1. Open homepage
2. Click on "Add to Cart" of any of 4 product displayed below carousel
3. See that items in cart is updated and price is correctly calculated

Automated: no

### Scenario US15-T01 or US05-T02: Add a product from product page to cart
1. Open any product page (e.g. http://demoshop24.com/index.php?route=product/product&product_id=40)
2. Click on "Add to Cart" 
3. See that items in cart is updated and price is correctly calculated

Automated: no

### Scenario US05-T03: Add a product from product page with error
1. Open any product page which was additional (beside Qty) option (e.g. http://demoshop24.com/index.php?route=product/product&manufacturer_id=7&product_id=47 or http://demoshop24.com/index.php?route=product/product&path=20&product_id=42)
2. Do not fill some of the mandatory field
3. Click on "Add to Cart" 
4. See error "<Field> required!"

Automated: no

### Scenario US05-T04: Shopping Card is visible on all pages
1. Open any page
2. Shopping card is visible on any page and is being filled correctly

Automated: no

### Scenario US05-T05: Add a product from product page with incorrect values for the additional options
1. Open any product page which was delivery date (e.g. http://demoshop24.com/index.php?route=product/product&manufacturer_id=7&product_id=47 or http://demoshop24.com/index.php?route=product/product&path=20&product_id=42)
2. Set some incorrect data (e.g. Delivery date in the past or Qty smaller then required)
3. Click on "Add to Cart" 
4. See error, like "Incorrect value into the field, should be ..."

Automated: no

### Scenario US05-T06: Items out of stock
1. Add item out of stock to card (e.g. http://demoshop24.com/index.php?route=product/product&product_id=49&search=Space+Tab+10.1)
2. Open cart
3. Items out of stock are marked specially marked

Automated: no
 
 ____________________
## Bugs
### Bug US05-B01: On homepage only first 2 links work
**Steps:** Execute scenario US05-T01 for 3rd and 4th element

**Actual:** Product page for 3rd and 4th item is displayed

**Expected:** Product is added to the card

### Bug US05-B02: Qty is not marked as mandatory field, therefor can add an item without filling it
**Steps:** Open any product page

**Actual:** Qty is not marked as mandatory field, therefor can add an item without filling it

**Expected:** Qty is marked as mandatory field

### Bug US05-B03: No additional check for the field
**Steps:** Execute scenario US05-T05

**Expected:** error is seen

**Actual:** error is not seen and product is successfully added to the card


### Bug US05-B04: No additional check for the field
**Steps:** 
1) Add 1st item from feature items to your cart

2) Add 3rd item from feature items to your cart

3) After you are navigated to 3rd item's product page , click navigate back button in browser
           

**Actual:** Shows 0 items in cart

**Expected:** 1 item in cart
