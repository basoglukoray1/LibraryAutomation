@us02
Feature: As a librarian, I want to know the amount of borrowed books.

@db @ui
Scenario: verify the amount of borrowed books
  Given I am on the homepage of the library app
  When I get borrowed books number
  Then borrowed books number information must match with DB
