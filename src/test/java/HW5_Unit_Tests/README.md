## Unit-тесты
### Семинар 5. Другие виды тестирования


### _Домашнее задание 1._
Представьте, что вы работаете над разработкой простого приложения для записной книжки, которое позволяет пользователям
добавлять, редактировать и удалять контакты.
Ваша задача - придумать как можно больше различных тестов (unit-тесты, интеграционные тесты, сквозные тесты) для этого
приложения. Напишите название каждого теста, его тип и краткое описание того, что этот тест проверяет.

_**Ответы:**_

**Модульные тесты (unit-тесты)**

- _addContactTest()_  
  Тестирование корректной работы функции добавления контакта.

- _editContactTest()_  
  Тестирование корректного изменения данных через функцию редактирования контакта.

- _deleteContactTest()_  
  Тестирование корректного удаления записи из базы данных через функцию удаления контакта.

- _emptyNameTest()_  
  Тестирование обработки исключения при вводе имени с пустым полем или пробелом для функции добавления контакта.

- _invalidPhoneTest()_  
  Тестирование обработки исключения при вводе некорректного номера телефона для функции добавления контакта.

- _invalidEmailTest()_  
  Тестирование обработки исключения при вводе некорректного адреса электронной почты для функции добавления контакта.

- _duplicateNameTest()_  
  Тестирование обработки исключения при вводе имени, идентичного существующему в БД, для функции добавления контакта.

- _duplicatePhoneTest()_  
  Тестирование обработки исключения при вводе телефона, идентичного существующему в БД, для функции добавления контакта.

- _duplicateEmailTest()_  
  Тестирование обработки исключения при вводе адреса электронной почты, идентичного существующему в БД, для функции добавления контакта.

**Интеграционные тесты**

- _addAndViewContactTest()_  
  Тестирование корректного добавления контакта и его последующего просмотра.

- _addAndEditContactTest()_  
  Тестирование корректного добавления контакта и последующего его редактирования.

- _addAndDeleteContactTest()_  
  Тестирование корректного добавления контакта и последующего его удаления.

- _addAndFindContactTest()_  
  Тестирование корректного добавления контакта и последующего его нахождения через поиск.

- _editAndDeleteContactTest()_  
  Тестирование корректного редактирования контакта и последующего его удаления.

- _deleteAndRestoreContactTest()_  
  Тестирование корректного удаления контакта и последующего его восстановления.

- _getAllContactsTest()_  
  Тестирование корректного получения списка всех контактов.

- _addContactAndGetAllContactsTest()_  
  Тестирование корректного добавления контакта и последующего получения его в списке всех контактов.

- _deleteAllContacts()_  
  Тестирование корректного удаления всех контактов.

**Сквозные тесты (End-to-End тесты)**

- _findContactTest(contact)_  
  Тестирование корректного поиска контакта с отображением всех его полей.

- _addViewAndDeleteContactTest(contact)_  
  Тестирование корректной совместной работы функций добавления, просмотра и удаления контакта.

- _addEditAndDeleteContactTest(contact)_  
  Тестирование корректной совместной работы функций добавления, редактирования и удаления контакта.


## _Домашнее задание 2._
Ниже список тестовых сценариев. Ваша задача - определить тип каждого теста (unit-тест, интеграционный тест,
сквозной тест) и объяснить, почему вы так решили:  
"Проверка того, что функция add_contact корректно добавляет новый контакт в список контактов".  
"Проверка того, что при добавлении контакта через пользовательский интерфейс, контакт корректно отображается в списке контактов".  
"Проверка полного цикла работы с контактом: создание контакта, его редактирование и последующее удаление".

_**Ответы:**_

_"Проверка того, что функция add_contact корректно добавляет новый контакт в список контактов"_ - **это unit-тест**.  
Он проверяет конкретную функциональность - добавление контакта - и включает в себя все необходимые проверки,
чтобы убедиться, что функция работает правильно.
В реализации нашего приложения для записной книжки - это метод _addContactTest()_

_"Проверка того, что при добавлении контакта через пользовательский интерфейс,
контакт корректно отображается в списке контактов"_ - **это интеграционный тест**.  
Этот тест проверяет, как различные части системы взаимодействуют друг с другом, в данном случае,
между пользовательским интерфейсом и внутренним функционалом приложения.
Если говорить о нашей реализации - это метод _addAndViewContactTest()_

_"Проверка полного цикла работы с контактом: создание контакта, его редактирование и последующее удаление"_ - **это сквозной тест**.  
Он охватывает все этапы работы с контактом и проверяет, что каждый из них выполняется корректно.
Если говорить о нашей реализации - это метод _addEditAndDeleteContactTest(contact)_