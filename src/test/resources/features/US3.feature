@us03
Feature: As a librarian, I want to know the genre of books are being borrowed the most

  @db
  Scenario: verify the common book genre that’s being borrowed
    When I execute a query to find the most popular book genre
    Then verify that "Classic" is the most popular book genre.