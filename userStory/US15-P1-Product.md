# Product page
Priority 1
## Description
Each product must have own product page

Product page contains information about product –
* name,
* description,
* specification,
* review,
* price,
* available options

and buttons ‘Compare’, “Add to Cart”, “Add to Wish list”

## Acceptance criteria
* User is able to open product page and add product to cart
* User is able to write review for product after purchase
* User is able to add product to compare list
* User is able to see image, price and specification
## Highlights for testing

## Tests
### Scenario US15-T01 or US05-T02: Add a product from product page to cart
1. Open any product page (e.g. http://demoshop24.com/index.php?route=product/product&product_id=40)
2. Click on "Add to Cart" 
3. See that items in cart is updated and price is correctly calculated

Automated: no

### Scenario US15-T02: Add a product from product page to compare list
1. Open any product page (e.g. http://demoshop24.com/index.php?route=product/product&product_id=40)
2. Click on compare this product
3. See successful message

Automated: no

### Scenario US15-T03: Write and submit a review for product which was purchase
1. Open any product page, which was purchased (e.g. http://demoshop24.com/index.php?route=product/product&product_id=40)
2. Write and submit a review for product
3. See successful message

Automated: yes

### Scenario US15-T04: Write and submit a review for product which was NOT purchase
1. Open any product page, which was not purchased (e.g. http://demoshop24.com/index.php?route=product/product&product_id=40)
2. Write and submit a review for product
3. See error message

Automated: no

### Scenario US15-T05: Information about product is seen on product page
1. Open any product page (e.g. http://demoshop24.com/index.php?route=product/product&product_id=40)
2. See that correct information is displayed (image, price, specification, name, description, review, available options and 3 buttons 'Compare', 'Add to Cart' and 'Add to Wish List')

Automated: yes

## Bugs
### Bug US15-B01: User can add a review without purchase of the product
**Steps:** Execute scenario US15-T04

**Expected:** error is seen

**Actual:** error is not seen, successful message is seen


### Bug US15-B02: Product Breadcrumb navigation shows sequence which user used to open this product
**Steps:** 
1) Open homepage and on featured product list click on "opa-Phone"
2) Breadcrumb navigation Shows homepage logo and String "opa-Phone"

Excpected result: Contain full breadcrumb navigation for product.
Actual result: Showing breandcrumb navigation which user used.

![Bug 1.1](Images/US15_Bug_1.PNG?raw=true "full path")

![Bug 1.2](Images/US15_Bug_2.PNG?raw=true "navigated from search")

![Bug 1.3](Images/US15_Bug_3.PNG?raw=true "navigated from homepage")



### Bug US15-B02: Product "Space tab 10.1" with out specification
**Steps:** 
1) Open homepage and input in search box "Space tab" and click search
2) Click on "Space Tab 10.1" item
3) See that between "Description" and "Reviews" is no "Specification"

Excpected result: Specification present for product
Actual result: Product with out specification.

![Bug 2.1](Images/US15_Bug_4.PNG?raw=true "Space tab with out specification")