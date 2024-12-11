Feature: Create User

  @Get

  Scenario Outline: Successfully create a user

    When I send a petition to the endpoint "<endpoint> with the user id "<id>"
    Then I validate that response code is "<code>"

    Examples:
      | endpoint | id | code |
      | /users   | /1  | 200  |
