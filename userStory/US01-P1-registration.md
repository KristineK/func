# User Registration
Priority 1
## Description
Users are able to create their accounts via email
## Requirements
Registration form contains mandatory text fields

1. First name

2. Second name

3. Email (email validation) (has email RegEx)

4. Phone number (numbers 7-32) 

5. Password (4-20 chars)

Radio button Subscribe ("No" by default, not required) and checkbox "I have read and agree to the Privacy Policy"
## Acceptance criteria
After registration user is able to login into the system.
## Highlights for testing
Information from registration should be the same in account page

## Tests
### Scenario US01-T01: Add a product from product page to cart
1. Open registration page (e.g. http://demoshop24.com/index.php?route=account/register)
2. Fill all registration fields
3. Agree Private Policy 
4. Click continue button
5. Verify Congratulations message

Automated: yes


### Scenario US01-T02: Check Radio button subscribe by default is "No"
1. Open registration page (e.g. http://demoshop24.com/index.php?route=account/register)
2. See Subscribe radio button by default is "No"

Automated: yes

### Scenario US01-T03: Check Radio button subscribe by default is "No"
1. Open registration page (e.g. http://demoshop24.com/index.php?route=account/register)
2. Fill all registration fields
3. Add 3 numbers in phone input field
4. Agree Private Policy 
5. Click continue button

Automated: No

### Bug US05-B01: Validation for phone number not working correct
**Steps:** Execute scenario US01-T03

**Expected:** User see phone validation error message

**Actual:** error is not seen and user are successful registered