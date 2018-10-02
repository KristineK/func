# Brows and categories 
Priority 1
## Description 
All products should have own page and category
## Acceptance criteria
1)	Each product should belong to 1 category and (not mandatory) belong to one subcategory
2)	Categories should be present in all pages as drop-down menu with subcategories
3)	Each subcategory button should contain count of available products
4)	Categories list is available on left side of browse page
5)	Browse page contains list of products from this category
6)	List has sorting and pagination functionality
7)	Products in list can be added to Wish List, Compare and Add to Cart
 
## Highlights for testing

## Tests
### Scenario US10-T01: Categories are seen
1. Open any page
2. See menu with Categories 

Automated: no

### Scenario US10-T02: Each product has category and sometimes sub-category
1. Open product which was just category (http://demoshop24.com/index.php?route=product/product&path=57&product_id=49)
2. See that only category is displayed
 
Automated: no

### Scenario US10-T02: Some product has category and sub-category
1. Open product which was just category and sub-category (http://demoshop24.com/index.php?route=product/product&path=18_46&product_id=43)
2. See that category and sub-category is displayed

Automated: no

### Scenario US10-T03: Sub-categories are seen under categories 
1. Open any page
2. Click in menu on any category which was sub-category
3. See that all sub-categories for this category is seen with correct number of products available  

Automated: no

### Scenario US10-T04: Categories are see on browse page
1. Open browse page
2. See that all categories are see on left side of the page

Automated: no

### Scenario US10-T05: Products for specific category is seen in browse page
1. Open browse page for specific category
2. All products for the selected category are seen
3. All products can be sorted and 
4. Pagination is available if there is more then 9 items per category
5. Each product can be added to wish list, for comparison and to card 

Automated: no

## Bugs
### Bug US10-B01: incorrect category for one of the products
**Steps:** open product http://demoshop24.com/index.php?route=product/product&search=Space%20Tab%2010.1&product_id=49

**Actual:** Category is seen (Tablet?)

**Expected:** Category is not seen ('Search' instead of category)

### Bug US10-B02: no pagination on browse page
**Steps:** open a category in browse page with more then 10 products (http://demoshop24.com/index.php?route=product/category&path=20)

**Actual:** No pagination is seen and only 9 items are displayed, instead of 10

**Expected:** Pagination for 10 items is seen
