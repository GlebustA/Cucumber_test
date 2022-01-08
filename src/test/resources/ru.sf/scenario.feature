Feature: Find shop
  Scenario: choose shop city
    Given url of dns shop 'https://www.dns-shop.ru/'
    Then choose city 'Москва'
    And assert that chosen city is 'Москва'
  Scenario: choose shop city
    Given url of dns shop 'https://www.dns-shop.ru/'
    Then choose city 'Милан'
    And assert that user get message 'Город не найден, возможно Вы имели ввиду:'
